package com.kinvn.weather.weather.module.main;

import com.kinvn.weather.weather.base.BasePresenter;
import com.kinvn.weather.weather.base.BaseView;

/**
 * Created by Kinvn on 2018/3/30.
 * <p>
 * Email:kinvn123@gmail.com
 */

interface MainContract {
    interface MainView extends BaseView<MainPresenter> {
        void updateGraphView();
    }

    interface LocalView extends BaseView<LocalPresenter> {

    }

    interface CityView extends BaseView<CityPresenter> {

    }

    interface MainPresenter extends BasePresenter{

    }

    interface LocalPresenter extends BasePresenter {
        //根据经纬度查询所在城市
        void queryCity(int x, int y);

        //根据城市查询天气情况
        void queryWeather(String city);
    }

    interface CityPresenter extends BasePresenter{

    }
}
