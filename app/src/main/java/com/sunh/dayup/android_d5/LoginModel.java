package com.sunh.dayup.android_d5;

/**
 * Created by jpwen on 2017/7/31.
 */

public class LoginModel implements LoginContract.Model{

    //登录
    @Override
    public void login(final String name, String pwd, final LoginContract.OnLoginClickListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(name.equals("123")){
                    listener.complete();
                }else{
                    listener.error("用户名密码不正确");
                }
            }
        }).start();
    }
}
