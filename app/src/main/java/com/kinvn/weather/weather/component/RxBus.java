package com.kinvn.weather.weather.component;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by Kinvn on 2018/3/31.
 * <p>
 * Email:kinvn123@gmail.com
 */

public class RxBus {
    private final Subject<Object> mBus;

    private RxBus() {
        mBus = PublishSubject.create();
    }

    private static class RxBusHolder {
        private static final RxBus INSTANCE = new RxBus();
    }

    public static RxBus getDefault() {
        return RxBusHolder.INSTANCE;
    }

    public void post(Object o) {
        mBus.onNext(o);
    }

    public <T> Observable<T> tObservable(Class<T> eventType) {
        return mBus.ofType(eventType);
    }
}
