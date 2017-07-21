package com.sunh.dayup.android_d4;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TableLayout;

import com.sunh.dayup.R;

/**
 * Created by jpwen on 2017/7/18.
 */

public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewpaper;
    private MyFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);

        initView();
    }

    private void initView() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);

        viewpaper = (ViewPager) findViewById(R.id.viewpaper);
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),this);
        viewpaper.setAdapter(adapter);
        initTab();
    }

    private void initTab() {
        tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tablayout.setupWithViewPager(viewpaper);
        //给TabLayout设置适配器
        tablayout.setTabsFromPagerAdapter(adapter);
    }



    class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public final int COUNT = 5;
        private String[] titles = new String[]{"Tab1", "Tab2", "Tab3", "Tab4", "Tab5"};
        private Context context;

        public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }


}
