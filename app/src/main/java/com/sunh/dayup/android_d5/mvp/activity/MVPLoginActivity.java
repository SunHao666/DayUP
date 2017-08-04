package com.sunh.dayup.android_d5.mvp.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.sunh.dayup.R;
import com.sunh.dayup.android_d5.mvp.base.BaseActivity;
import com.sunh.dayup.android_d5.mvp.base.BasePresenter;
import com.sunh.dayup.android_d5.mvp.mvp.contract.LoginContract;
import com.sunh.dayup.android_d5.mvp.mvp.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jpwen on 2017/8/2.
 * 登录
 */

public class MVPLoginActivity extends BaseActivity implements LoginContract.view {
    TextInputEditText etPhone;
    TextInputEditText etPwd;
    AppCompatButton btnLogin;
    LoginPresenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp_login;
    }

    @Override
    protected void initListener() {
        btnLogin.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        etPhone = (TextInputEditText) findViewById(R.id.et_phone);
        etPwd = (TextInputEditText) findViewById(R.id.et_pwd);
        btnLogin = (AppCompatButton) findViewById(R.id.btn_login);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void weightClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                presenter.login(etPhone.getText().toString(),etPwd.getText().toString());
                break;
        }
    }

    @Override
    protected BasePresenter loadPresenter() {
        presenter = new LoginPresenter(this);
        return presenter;
    }

    @Override
    public void showLoading() {
        Snackbar.make(btnLogin, "loading...", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity() {
        finish();
    }

    @Override
    public void showError() {
        Snackbar.make(btnLogin, "用户名或密码不正确", Snackbar.LENGTH_SHORT).show();
    }
}
