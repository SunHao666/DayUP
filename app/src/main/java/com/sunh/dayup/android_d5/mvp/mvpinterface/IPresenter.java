package com.sunh.dayup.android_d5.mvp.mvpinterface;

/**
 * Created by jpwen on 2017/8/2.
 */

public interface IPresenter<V extends IView> {
    /**
     * 绑定view
     * @param view
     */
    void attachView(V view);

    /**
     * 防止内存泄漏 关闭activity 解除绑定
     * @param view
     */
    void deachView(V view);

    /**
     * 获取绑定View
     */
    V getView();
}

