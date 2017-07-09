package com.sunh.dayup.android_d1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;

import com.sunh.dayup.R;

/**
 * Created by Administrator on 2017/7/9/009.
 * Description:ToolBar使用
 */

public class ToolBarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("主标题");
        toolbar.setSubtitle("副标题");
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.colorAccent));
        toolbar.setLogo(getResources().getDrawable(R.mipmap.ic_launcher));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.menu1));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
