package com.kinvn.weather.weather.component;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.kinvn.weather.weather.BuildConfig;
import com.kinvn.weather.weather.C;
import com.kinvn.weather.weather.Util;
import com.kinvn.weather.weather.base.BaseApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
    }

    private void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        File cacheFile = new File(C.NET_CACHE_DIR);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!Util.isNetworkConnected(BaseApplication.getAPPContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                Response.Builder responseBuilder = response.newBuilder();
                if (Util.isNetworkConnected(BaseApplication.getAPPContext())) {
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
}
