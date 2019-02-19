package com.devdarkco.smssender.activity;

import android.graphics.Color;
import android.os.Bundle;

import com.devdarkco.smssender.R;

import androidx.appcompat.app.AppCompatActivity;

public class CreditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);

        getWindow().setNavigationBarColor(Color.WHITE);
        getWindow().setStatusBarColor(Color.WHITE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
