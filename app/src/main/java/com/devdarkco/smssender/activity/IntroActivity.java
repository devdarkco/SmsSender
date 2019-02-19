package com.devdarkco.smssender.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.devdarkco.smssender.R;
import com.devdarkco.smssender.adapter.PagerAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class IntroActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private ImageView mDot1, mDot2, mDot3;
    private RelativeLayout mLayout;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private static final String APP_PREFS = "smssendernv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        mSharedPreferences = getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        if (mSharedPreferences.getBoolean("firstTimeLaunched", false)) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        getWindow().setNavigationBarColor(Color.WHITE);
        getWindow().setStatusBarColor(Color.WHITE);

        mLayout = (RelativeLayout) findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) mLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        mViewPager = (ViewPager) findViewById(R.id.mainPager);
        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                changeFocus(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        mDot1 = (ImageView) findViewById(R.id.dot1);
        mDot2 = (ImageView) findViewById(R.id.dot2);
        mDot3 = (ImageView) findViewById(R.id.dot3);
    }

    private void changeFocus(int position) {
        if (position == 0) {
            mDot1.setImageResource(R.drawable.dot_active);
            mDot2.setImageResource(R.drawable.dot);
            mDot3.setImageResource(R.drawable.dot);
        } else if (position == 1) {
            mDot1.setImageResource(R.drawable.dot);
            mDot2.setImageResource(R.drawable.dot_active);
            mDot3.setImageResource(R.drawable.dot);
        } else if (position == 2) {
            mDot1.setImageResource(R.drawable.dot);
            mDot2.setImageResource(R.drawable.dot);
            mDot3.setImageResource(R.drawable.dot_active);
        }
    }
}
