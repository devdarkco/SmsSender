package com.devdarkco.smssender.adapter;

import com.devdarkco.smssender.fragment.IntroFragment;
import com.devdarkco.smssender.fragment.PolicyFragment;
import com.devdarkco.smssender.fragment.StartFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                IntroFragment postFragment = new IntroFragment();
                return postFragment;
            case 1:
                PolicyFragment userPostFragment = new PolicyFragment();
                return userPostFragment;
            case 2:
                StartFragment startFragment = new StartFragment();
                return startFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
