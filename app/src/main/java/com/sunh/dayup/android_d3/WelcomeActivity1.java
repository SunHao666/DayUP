package com.sunh.dayup.android_d3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sunh.dayup.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/16/016.
 * Description:引导页1
 */

public class WelcomeActivity1 extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager viewPager;
    public List<View> imgs = new ArrayList<View>();
    private LinearLayout lay_dot;
    private int current = 0;
    private Button btn_start;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.welcome1);
        viewPager = (ViewPager) findViewById(R.id.viewpaper);

        btn_start = (Button) findViewById(R.id.btn_start);
        LayoutInflater inflater = LayoutInflater.from(WelcomeActivity1.this);
        View v1 = inflater.inflate(R.layout.viewpaper_p1,null);
        View v2 = inflater.inflate(R.layout.viewpaper_p2,null);
        View v3 = inflater.inflate(R.layout.viewpaper_p3,null);
        View v4 = inflater.inflate(R.layout.viewpaper_p4,null);

        imgs.add(v1);
        imgs.add(v2);
        imgs.add(v3);
        imgs.add(v4);


        //绘制圆点
        lay_dot = (LinearLayout) findViewById(R.id.lay_dot);
        for (int i = 0; i < imgs.size(); i++) {
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(10,10);
            if(current == i){
                imageView.setImageResource(R.drawable. icon_dot_normal);
            }else{
                imageView.setImageResource(R.drawable. icon_dot_select);
            }
            if(i>0){
                layoutParams.leftMargin = 10;
            }

            imageView.setLayoutParams(layoutParams);
            lay_dot .addView(imageView);
        }

        viewPager.setAdapter(new MyPagerAdapter(imgs));
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        current = position;
        for (int i = 0; i < lay_dot.getChildCount(); i++) {
            ImageView imageview = (ImageView) lay_dot.getChildAt(i);
            if(current == i){
                imageview.setImageResource(R.drawable. icon_dot_normal);
            }else{
                imageview.setImageResource(R.drawable. icon_dot_select);
            }
        }
        if(current == 3){
            btn_start.setVisibility(View.VISIBLE);
        }else {
            btn_start.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 自定义adapter
     */
    class MyPagerAdapter extends PagerAdapter{
        public List<View> res;
        public MyPagerAdapter(List<View> res) {
            this.res = res;
        }

        @Override
        public int getCount() {
            return res.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(res.get(position));
            return res.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(res.get(position));
        }
    }
}
