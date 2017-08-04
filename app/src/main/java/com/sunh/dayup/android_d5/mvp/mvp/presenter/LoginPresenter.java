package com.sunh.dayup.android_d5.mvp.mvp.presenter;

import com.sunh.dayup.android_d5.mvp.activity.MVPLoginActivity;
import com.sunh.dayup.android_d5.mvp.base.BasePresenter;
import com.sunh.dayup.android_d5.mvp.mvp.contract.LoginContract;
import com.sunh.dayup.android_d5.mvp.mvp.model.LoginModel;

/**
 * Created by jpwen on 2017/8/2.
 */

public class LoginPresenter extends BasePresenter<MVPLoginActivity,LoginModel>implements LoginContract.Presenter{

    LoginContract.view view;
    LoginModel model;
    public LoginPresenter(LoginContract.view view) {
        this.view = view;
        model = new LoginModel();
    }


    @Override
    public void login(String phone, String p) {
        view.showLoading();
        model.login(phone, p, new LoginContract.MvpClickListener() {
            @Override
            public void complete() {
                view.toMainActivity();
            }

            @Override
            public void error() {
                view.showError();
            }
        });
    }
}
