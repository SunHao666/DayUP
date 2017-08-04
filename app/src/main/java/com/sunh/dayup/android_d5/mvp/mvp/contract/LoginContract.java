package com.sunh.dayup.android_d5.mvp.mvp.contract;

/**
 * Created by jpwen on 2017/8/2.
 */

public interface LoginContract {

    public interface Presenter{
        void login(String phone, String p);
    }

    public interface view{

        void showLoading();

        void hideLoading();

        void toMainActivity();

        void showError();

    }

    public interface model {
        void login(String phone, String p, MvpClickListener listener);
    }

    public interface MvpClickListener {
        void complete();

        void error();
    }
}
