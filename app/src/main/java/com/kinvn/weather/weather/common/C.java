package com.kinvn.weather.weather.common;

import com.kinvn.weather.weather.BuildConfig;
import com.kinvn.weather.weather.base.BaseApplication;

import java.io.File;

/**
 * Created by Kinvn on 2018/3/29.
 * <p>
 * Email:kinvn123@gmail.com
 */

public class C {
    public static final String STATUS_OK = "ok";//数据正常
    public static final String STATUS_INVALID_KEY = "invalid key";//错误的key，请检查你的key是否输入以及是否输入有误
    public static final String STATUS_UNKNOWN_LOCATION = "unknown location";//未知或错误城市/地区
    public static final String STATUS_NO_DATA = "no data for this location";//该城市/地区没有你所请求的数据
    public static final String STATUS_NO_MORE_REQUESTS = "no more requests";//超过访问次数，需要等到当月最后一天24点后进行访问次数的重置或升级你的访问量
    public static final String STATUS_PARAM_INVALID = "param invalid";//参数错误，请检查你传递的参数是否正确
    public static final String STATUS_TOO_FAST = "too fast";//超过限定的QPM，请参考QPM说明
    public static final String STATUS_DEAD = "dead";//无响应或超时，接口服务异常请联系我们
    public static final String STATUS_PERMISSION_DENIED = "permission denied";//无访问权限，你没有购买你所访问的这部分服务
    public static final String STATUS_SIGN_ERROR = "sign error";//签名错误，请参考签名算法


    public static final int MY_FINE_LOCATION_REQUEST_CODE = 1;

    public static String KEY = BuildConfig.WeatherKey;

    public static String NET_CACHE_DIR = BaseApplication.getAppCacheDir() + File.separator + "NetCache";
}
