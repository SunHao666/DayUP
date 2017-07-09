package com.sunh.dayup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sunh.dayup.android_d1.ActionBarActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void actionbar(View view){
        startActivity(new Intent(getApplicationContext(), ActionBarActivity.class));
    }
}
