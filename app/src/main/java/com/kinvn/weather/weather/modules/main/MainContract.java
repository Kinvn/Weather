package com.kinvn.weather.weather.modules.main;

import com.kinvn.weather.weather.base.BasePresenter;
import com.kinvn.weather.weather.base.BaseView;
import com.kinvn.weather.weather.model.HeWeather;

import java.util.List;

/**
 * Created by Kinvn on 2018/3/30.
 * <p>
 * Email:kinvn123@gmail.com
 */

interface MainContract {
    interface View extends BaseView<Presenter> {
        //更新天气图表
        void updateGraphView(List<String> xList, List<Integer> yList);

        //更新天气信息
        void updateWeather(HeWeather weather);

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
