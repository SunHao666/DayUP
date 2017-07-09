package com.sunh.dayup.android_d1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sunh.dayup.R;

/**
 * Created by sunh on 2017/7/9/009.
 * Description: Actionbar 使用
 */

public class ActionBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);
        ActionBar actionBar = getSupportActionBar();
        //隐藏actionbar
//        actionBar.hide();
        //actionbar背景图片
//        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.logo));
        //默认home图标
//        actionBar.setIcon(R.drawable.logo);
        //替换默认home图标
//        actionBar.setLogo(R.drawable.turn_left);
        //显隐home图标开关
        actionBar.setDisplayUseLogoEnabled(true);
        //主标题
//        actionBar.setTitle("ActionBar");
        //副标题
//        actionBar.setSubtitle("副标题");
        //显隐logo开关
        actionBar.setDisplayShowHomeEnabled(true);
        //显隐标题开关
        actionBar.setDisplayShowTitleEnabled(true);
        //添加返回按钮
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            //添加action按钮
            getMenuInflater().inflate(R.menu.menu, menu);
            MenuItem searchItem = menu.findItem(R.id.action_search);
            SearchView searchView = (SearchView) searchItem.getActionView();
            return true;
    }

    /**
     * action item click
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_compose:
                Toast.makeText(getApplicationContext(),"action_compose",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(getApplicationContext(),"action_delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(),"action_settings",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * toolbar
     */
    public void toolbar(View view){
        startActivity(new Intent(getApplicationContext(),ToolBarActivity.class));
    }

}
