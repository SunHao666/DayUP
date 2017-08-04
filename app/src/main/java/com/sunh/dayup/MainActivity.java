package com.sunh.dayup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sunh.dayup.android_d1.ActionBarActivity;
import com.sunh.dayup.android_d2.DrawerLayoutActivity;
import com.sunh.dayup.android_d2.MainDrawerActivity;
import com.sunh.dayup.android_d3.FabActivity;
import com.sunh.dayup.android_d3.MainViewPaperActivity;
import com.sunh.dayup.android_d4.CoordinatorLayoutActivity;
import com.sunh.dayup.android_d4.TabLayoutActivity;
import com.sunh.dayup.android_d5.LoginActivity;
import com.sunh.dayup.android_d5.MvpDemoActivity;
import com.sunh.dayup.android_d5.mvp.activity.MVPLoginActivity;
import com.sunh.dayup.android_d6.RetrofitActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void actionbar(View view){
        startActivity(new Intent(getApplicationContext(), ActionBarActivity.class));
    }

    public void DrawerLayout(View view){
        startActivity(new Intent(getApplicationContext(), MainDrawerActivity.class));
    }
    public void ViewPaper(View view){
        startActivity(new Intent(getApplicationContext(), MainViewPaperActivity.class));
    }
    public void floatingActionButton(View view){
        startActivity(new Intent(getApplicationContext(), FabActivity.class));
    }

    public void tablayout(View view){
        startActivity(new Intent(getApplicationContext(), TabLayoutActivity.class));
    }
    public void CoordinatorLayout(View view){
        startActivity(new Intent(getApplicationContext(), CoordinatorLayoutActivity.class));
    }

    public void mvp(View view){
        startActivity(new Intent(getApplicationContext(), MvpDemoActivity.class));
    }
    public void mvp2(View view){
        startActivity(new Intent(getApplicationContext(), MVPLoginActivity.class));
    }
    public void retrofit(View view){
        startActivity(new Intent(getApplicationContext(), RetrofitActivity.class));
    }
}
