package com.sunh.dayup.android_d5.mvp.base;

import com.sunh.dayup.android_d5.mvp.mvpinterface.IModel;
import com.sunh.dayup.android_d5.mvp.mvpinterface.IPresenter;
import com.sunh.dayup.android_d5.mvp.mvpinterface.IView;

import java.lang.ref.WeakReference;

/**
 * Created by jpwen on 2017/8/2.
 * activity关闭 presenter 仍然拥有activity引用，会导致内存泄漏
 */

public class BasePresenter<V extends IView,M extends IModel> implements IPresenter{

    private WeakReference reference;

    @Override
    public void attachView(IView view) {
        reference = new WeakReference(view);
    }

    @Override
    public void deachView(IView view) {
        if (reference != null){
            reference.clear();
            reference = null;
        }
    }

    @Override
    public V getView() {
        return (V) reference.get();
    }
}
