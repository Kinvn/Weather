package com.kinvn.weather.weather;

import com.kinvn.weather.weather.base.BaseApplication;

import java.io.File;

/**
 * Created by Kinvn on 2018/3/29.
 * <p>
 * Email:kinvn123@gmail.com
 */

public class C {
    public static final int MY_FINE_LOCATION_REQUEST_CODE = 1;

    public static String KEY = BuildConfig.WeatherKey;

    public static String NET_CACHE_DIR = BaseApplication.getAppCacheDir() + File.separator + "NetCache";
}
