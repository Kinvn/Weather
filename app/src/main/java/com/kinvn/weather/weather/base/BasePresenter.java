package com.kinvn.weather.weather.base;

/**
 * Created by Kinvn on 2018/3/21.
 */

public interface BasePresenter<T> {
    //释放资源
    void destroy();
}
