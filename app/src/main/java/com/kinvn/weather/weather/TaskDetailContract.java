package com.kinvn.weather.weather;

import com.kinvn.weather.weather.base.BasePresenter;
import com.kinvn.weather.weather.base.BaseView;

/**
 * Created by Kinvn on 2018/3/21.
 */

public interface TaskDetailContract {
    interface View extends BaseView {
        //设置数据加载状态
        void setLoadingIndicator(boolean active);
        //处理Task加载失败的情况
        void showMissingTask();
        //隐藏待办事项Title
        void hideTitle();
        //显示待办事项Title
        void showTitle();
        //隐藏待办事项描述
        void hideDescription();
        //显示待办事项描述
        void showDescription();
    }

    interface Presenter extends BasePresenter {
        //修改待办事项
        void editTask();
        //删除待办事项
        void deleteTask();
        //标记完成
        void completeTask();
        //标记未完成
        void activiteTask();
    }
}
