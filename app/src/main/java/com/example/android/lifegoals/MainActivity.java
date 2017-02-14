package com.example.android.lifegoals;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.main_view_pager);

        MainPageViewAdapter mainPageViewAdapter = new MainPageViewAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mainPageViewAdapter);

    }

    public void openNewActivity(View view) {
        Intent act = new Intent(this, AddGoal.class);
        startActivity(act);
    }
}