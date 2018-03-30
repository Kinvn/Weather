package com.kinvn.weather.weather.component;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.kinvn.weather.weather.BuildConfig;
import com.kinvn.weather.weather.C;
import com.kinvn.weather.weather.R;
import com.kinvn.weather.weather.ToastUtil;
import com.kinvn.weather.weather.Util;
import com.kinvn.weather.weather.base.BaseApplication;
import com.kinvn.weather.weather.model.HeWeather;
import com.kinvn.weather.weather.model.WeatherAPI;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kinvn on 2018/3/29.
 */

public class RetrofitSingleton {
    private OkHttpClient mOkHttpClient;
    private Retrofit mRetrofit;
    private ApiInterface mApiInterface;

    private static class SingletonHolder {
        private static final RetrofitSingleton INSTANCE = new RetrofitSingleton();
    }

    public RetrofitSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private RetrofitSingleton() {
        init();
    }

    private void init() {
        initOkHttp();
        initRetrofit();
        mApiInterface = mRetrofit.create(ApiInterface.class);
    }

    private void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        File cacheFile = new File(C.NET_CACHE_DIR);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!Util.isNetworkConnected(BaseApplication.getAppContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                Response.Builder responseBuilder = response.newBuilder();
                if (Util.isNetworkConnected(BaseApplication.getAppContext())) {
                    int maxAge = 0;
                    responseBuilder.header("Cache-Control", "public, max-age=" + maxAge);
                } else {
                    int maxStale = 60 * 60 * 24 * 28;
                    responseBuilder.header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale);
                }
                return responseBuilder.build();
            }
        };
        builder.cache(cache).addInterceptor(cacheInterceptor);
        if (BuildConfig.DEBUG) {
            builder.addNetworkInterceptor(new StethoInterceptor());
        }
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);

        builder.retryOnConnectionFailure(true);
        mOkHttpClient = builder.build();
    }

    private void initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private Consumer<Throwable> disposeFailedInfo(Throwable t) {
        return throwable -> {
            if (t.toString().contains("GaiException") || t.toString().contains("SocketTimeoutException")
                ||t.toString().contains("UnknownHostException")){
                ToastUtil.showShort(BaseApplication.getAppContext().getString(R.string.network_error));
            } else if (t.toString().contains("API没有")) {
                ToastUtil.showShort("错误：" + t.getMessage() );
            }
            Logger.w(t.getMessage());
        };
    }

    public Observable<HeWeather> fetchWeather(String city) {
        return mApiInterface.weatherAPI(city, C.KEY)
                .flatMap(new Function<WeatherAPI, ObservableSource<WeatherAPI>>() {
                    @Override
                    public ObservableSource<WeatherAPI> apply(WeatherAPI weatherAPI) throws Exception {
                        String status = weatherAPI.getHeWeather6().get(0).getStatus();
                        if ("no more requests".equals(status)) {
                            return Observable.error(new RuntimeException("API次数已用完"));
                        } else if ("unknown city".equals(status)) {
                            return Observable.error(new RuntimeException(String.format("查询不到：%s", city)));
                        }
                        return Observable.just(weatherAPI);
                    }
                })
                .map(new Function<WeatherAPI, HeWeather>() {
                    @Override
                    public HeWeather apply(WeatherAPI weatherAPI) throws Exception {
                        return weatherAPI.getHeWeather6().get(0);
                    }
                })
                .doOnError(this::disposeFailedInfo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true);
    }


}
