package com.sunh.dayup.android_d5;

/**
 * Created by jpwen on 2017/7/31.
 */

public class LoginPresenter {

    public LoginContract.View view;
    public LoginModel model;

    public LoginPresenter(LoginContract.View view) {
        this.view = view;
        model = new LoginModel();
    }


    public void login(String name, String pwd) {
            view.showProgress();
            model.login(name, pwd, new LoginContract.OnLoginClickListener() {
                @Override
                public void error(String msg) {
                    view.showErroreMessage(msg);
                }

                @Override
                public void complete() {
                    view.complete();
                }
            });
    }
}
