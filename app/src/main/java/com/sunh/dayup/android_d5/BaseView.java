package com.sunh.dayup.android_d5;

/**
 * Created by jpwen on 2017/7/31.
 */

public interface BaseView<T> {
    //给view设置presenter
    void setPresenter(T presenter);
}
