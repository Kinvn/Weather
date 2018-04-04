package com.kinvn.weather.weather.module.main;

import com.kinvn.weather.weather.base.BasePresenter;
import com.kinvn.weather.weather.base.BaseView;

/**
 * Created by Kinvn on 2018/3/30.
 * <p>
 * Email:kinvn123@gmail.com
 */

interface MainContract {
    interface View extends BaseView<Presenter> {
        //更新天气图表
        void updateGraphView();

    }

    interface Presenter extends BasePresenter{
        //检查与请求Location权限
        void checkLocationPermission();

        //根据经纬度查询所在城市
        void getCurrentCity();

        //根据位置查询天气情况
        void queryWeather(String location);

    }
}
