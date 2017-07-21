package com.sunh.dayup.android_d3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sunh.dayup.R;

/**
 * Created by Administrator on 2017/7/16/016.
 * Description:ViewPaper
 */

public class MainViewPaperActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_welcome1,btn_welcome2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewpaper);
        initView();
    }

    private void initView() {
        btn_welcome1 = (Button) findViewById(R.id.button);
        btn_welcome2 = (Button) findViewById(R.id.button2);
        btn_welcome1.setOnClickListener(this);
        btn_welcome2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(getApplicationContext(),WelcomeActivity1.class));
                break;
            case R.id.button2:
                startActivity(new Intent(getApplicationContext(),TabWelcomeActivity.class));
                break;
        }
    }
}
