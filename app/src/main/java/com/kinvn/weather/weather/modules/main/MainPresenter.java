package com.kinvn.weather.weather.modules.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

import com.kinvn.weather.weather.common.C;
import com.kinvn.weather.weather.R;
import com.kinvn.weather.weather.component.SharedPreferencesManager;
import com.kinvn.weather.weather.common.utils.ToastUtil;
import com.kinvn.weather.weather.common.utils.Util;
import com.kinvn.weather.weather.component.RetrofitSingleton;
import com.kinvn.weather.weather.model.HeWeather;
import com.kinvn.weather.weather.model.HourlyItem;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

import static com.kinvn.weather.weather.common.utils.Util.checkNotNull;

/**
 * Created by Kinvn on 2018/3/30.
 * <p>
 * Email:kinvn123@gmail.com
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private Context mContext;
    private CompositeDisposable mDisposables;
    private HeWeather mWeather = new HeWeather();

    public MainPresenter(Context context, MainContract.View view) {
        mContext = context;
        mView = checkNotNull(view);
        mDisposables = new CompositeDisposable();
    }

    @Override
    public void checkLocationPermission() {
        if (!Util.checkPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)) {
            Util.requestPermission((MainActivity) mContext
                    , Manifest.permission.ACCESS_FINE_LOCATION
                    , R.string.explanation_about_request_location
                    , C.MY_FINE_LOCATION_REQUEST_CODE);
        } else {
            getCurrentCity();
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void getCurrentCity() {
        LocationManager locationManager = checkNotNull((LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE));
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        for (String provider : providers) {
            Location l = locationManager.getLastKnownLocation(provider);
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                bestLocation = l;
            }
        }
        if (bestLocation != null) {
            queryWeather(String.valueOf(bestLocation.getLongitude()) + "," + String.valueOf(bestLocation.getLatitude()));
        } else {
            ToastUtil.showShort(R.string.get_location_failed);
            queryWeather(SharedPreferencesManager.getInstance().getCity());
        }
    }

    @Override
    public void queryWeather(String location) {
        RetrofitSingleton.getInstance().fetchWeatherByLocation(location)
                .doOnSubscribe(disposable -> mDisposables.add(disposable))
                .onErrorReturn(throwable -> {
                    Logger.e(throwable.getMessage());
                    HeWeather weather = new HeWeather();
                    weather.setStatus("");
                    return weather;
                })
                .doOnNext(weather -> {
                    if (weather.getStatus().equals("ok")) {
                        SharedPreferencesManager.getInstance().setCity(weather.getBasic().getLocation());
                        Logger.d(weather.getHourly().get(0).getTmp());
                        mView.updateWeather(weather);
                        List<HourlyItem> hourlyItems = weather.getHourly();
                        List<String> xList = new ArrayList<>();
                        List<Integer> yList = new ArrayList<>();
                        for (int i = 0; i < hourlyItems.size(); i++) {
                            xList.add(hourlyItems.get(i).getTime());
                            yList.add(Integer.parseInt(hourlyItems.get(i).getTmp()));
                        }
                        mView.updateGraphView(xList, yList);
                    }
                })
                .doOnComplete(() -> {

                })
                .subscribe();
    }

    @Override
    public void destroy() {
        mDisposables.clear();
    }
}
