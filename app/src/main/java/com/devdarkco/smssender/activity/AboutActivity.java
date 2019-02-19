package com.devdarkco.smssender.activity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.devdarkco.smssender.R;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mTwitter, mGithub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getWindow().setNavigationBarColor(Color.WHITE);
        getWindow().setStatusBarColor(Color.WHITE);

        mTwitter = (ImageView) findViewById(R.id.twitter);
        mTwitter.setOnClickListener(this);
        mGithub = (ImageView) findViewById(R.id.github);
        mGithub.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mTwitter) {
            openWebBrowser("https://twitter.com/marcobaunilha");
        } else if (v == mGithub) {
            openWebBrowser("https://github.com/marcoSource");
        }
    }

    private void openWebBrowser(String link) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
