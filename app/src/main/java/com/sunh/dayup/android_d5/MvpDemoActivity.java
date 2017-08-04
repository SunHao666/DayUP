package com.sunh.dayup.android_d5;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.sunh.dayup.R;

/**
 * Created by jpwen on 2017/7/31.
 * mvp demo
 */

public class MvpDemoActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("MVP");

        LoginFragment loginFragment = (LoginFragment) getSupportFragmentManager().
                findFragmentById(R.id.framelayout);

        if(loginFragment == null){
            loginFragment = LoginFragment.newInstance();
            addFragmentToActivity(getSupportFragmentManager(),loginFragment,R.id.framelayout);
        }


    }

    public static void addFragmentToActivity (@NonNull FragmentManager fragmentManager,
                                              @NonNull Fragment fragment, int frameId) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(frameId, fragment);
        transaction.commit();
    }
}
