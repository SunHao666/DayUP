package com.sunh.dayup.android_d4;

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
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.sunh.dayup.R;

import java.util.List;

/**
 * Created by jpwen on 2017/7/19.
 * CoordinatorLayout ToolBar隐藏折叠
 */

public class CoordinatorLayoutActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coordinator);
        initView();
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("coordinator");

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpaper);
        viewPager.setAdapter(new MFragmentPagerAdapter(getSupportFragmentManager(),this));

        TabLayout tablayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout.setupWithViewPager(viewPager);

    }


    private class MFragmentPagerAdapter extends FragmentPagerAdapter {
        public  Context context;

        public MFragmentPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public Fragment getItem(int position) {
            MFragment fragment = MFragment.newInstance(context,position);
            return fragment;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return "Tab"+position;
        }

    }
}
