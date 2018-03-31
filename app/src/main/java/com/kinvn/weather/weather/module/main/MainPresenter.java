package com.kinvn.weather.weather.module.main;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import com.kinvn.weather.weather.C;
import com.kinvn.weather.weather.R;
import com.kinvn.weather.weather.ToastUtil;
import com.kinvn.weather.weather.Util;
import com.orhanobut.logger.Logger;

import java.util.List;

import static com.kinvn.weather.weather.Util.checkNotNull;

/**
 * Created by Kinvn on 2018/3/30.
 * <p>
 * Email:kinvn123@gmail.com
 */

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private Context mContext;

    public MainPresenter(Context context, MainContract.View view) {
        mContext = context;
        mView = checkNotNull(view);
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
            Logger.d(bestLocation.getLongitude() + "," + bestLocation.getLatitude());
        } else {
            ToastUtil.showShort("获取位置信息失败");
        }
    }

    @Override
    public void queryWeather(String city) {

    }
}
