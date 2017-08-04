package com.sunh.dayup.android_d5;

/**
 * Created by jpwen on 2017/7/31.
 * 契约类 view presenter 注册
 */

public interface LoginContract {
    //view接口
    public interface View {

        void showProgress();

        void hideProgress();

        void showErroreMessage(String error);

        void complete();
    }
    //presenter接口
    public interface Presenter extends BasePresenter{

        void login(String name,String pwd);

    }
    //model 接口
    public interface Model {
        void login(String name,String pwd,OnLoginClickListener listener);
    }

    public interface OnLoginClickListener {
        void error(String msg);

        void complete();
    }
}
