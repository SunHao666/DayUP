package com.sunh.dayup.android_d5.mvp.mvp.model;


import com.sunh.dayup.android_d5.mvp.mvp.contract.LoginContract;
import com.sunh.dayup.android_d5.mvp.mvpinterface.IModel;

/**
 * Created by jpwen on 2017/8/2.
 */

public class LoginModel implements IModel{
    public void login(String phone, String pwd, LoginContract.MvpClickListener listener){
        if(phone.equals("123")){
            listener.complete();
        }else{
            listener.error();
        }
    }

}
