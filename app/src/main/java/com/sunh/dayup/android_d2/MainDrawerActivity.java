package com.sunh.dayup.android_d2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.sunh.dayup.R;

/**
 * Created by Administrator on 2017/7/15/015.
 * Description:DrawerLayout
 */

public class MainDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_drawer);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        //头部点击
        navigationView.getHeaderView(0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DrawerLayoutActivity.class));
            }
        });
    }

    /**
     * 侧滑item点击事件处理
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ng_1:
                Snackbar.make(toolbar,"menu1",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.ng_2:
                Snackbar.make(toolbar,"menu2",Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.ng_3:
                Snackbar.make(toolbar,"menu3",Snackbar.LENGTH_SHORT).show();
                break;
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
