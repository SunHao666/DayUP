package com.sunh.dayup.android_d5.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.sunh.dayup.android_d5.mvp.mvpinterface.IView;

import butterknife.ButterKnife;

/**
 * Created by jpwen on 2017/8/2.
 * activity 基类
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IView,View.OnClickListener{

    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        mPresenter = loadPresenter();
        initCommonData();
        initView();
        initListener();
        initData();
    }

    private void initCommonData() {
        if(mPresenter != null)
             mPresenter.attachView(this);
    }

    @Override
    public void onClick(View v) {
        weightClick(v);
    }
    //布局
    protected abstract int getLayoutId();
    //初始化点击事件
    protected abstract void initListener();
    //初始化view
    protected abstract void initView();
    //初始化数据
    protected abstract void initData();
    //点击事件处理
    protected abstract void weightClick(View v);
    //获取presenter
    protected abstract P loadPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.deachView(this);
    }
}
