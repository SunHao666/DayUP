package com.sunh.dayup.android_d3;

import android.animation.ArgbEvaluator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.sunh.dayup.R;

public class TabWelcomeActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;



    private ImageButton buttonPre;
    private ImageButton buttonNext;
    private AppCompatButton buttonFinish;
    private int currentPosition = 0;
    private ImageView[] indicators;
    int[] bgColors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_welcome);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        buttonPre = (ImageButton) findViewById(R.id.imageButtonPre);
        buttonNext = (ImageButton) findViewById(R.id.imageButtonNext);
        buttonFinish = (AppCompatButton) findViewById(R.id.buttonFinish);
        ImageView imageViewIndicator0 = (ImageView) findViewById(R.id.imageViewIndicator0);
        ImageView imageViewIndicator1 = (ImageView) findViewById(R.id.imageViewIndicator1);
        ImageView imageViewIndicator2 = (ImageView) findViewById(R.id.imageViewIndicator2);
        indicators = new ImageView[]{imageViewIndicator0,imageViewIndicator1,imageViewIndicator2};

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int colorUpdate = (Integer) new ArgbEvaluator().evaluate(positionOffset, bgColors[position], bgColors[position == 2 ? position : position + 1]);
                mViewPager.setBackgroundColor(colorUpdate);
            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
                updateIndicators(position);
                mViewPager.setBackgroundColor(bgColors[position]);
                buttonPre.setVisibility(position == 0 ? View.GONE : View.VISIBLE);
                buttonNext.setVisibility(position == 2 ? View.GONE : View.VISIBLE);
                buttonFinish.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bgColors = new int[]{
                ContextCompat.getColor(this, R.color.colorPrimary),
                ContextCompat.getColor(this, R.color.colorAccent),
                ContextCompat.getColor(this, R.color.colorPrimary)
        };
    }
    private void updateIndicators(int position) {
        View[] indicators = new View[]{};
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setBackgroundResource(
                    i == position ? R.drawable.icon_dot_select : R.drawable.icon_dot_normal
            );
        }
    }



    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab_welcome, container, false);
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
