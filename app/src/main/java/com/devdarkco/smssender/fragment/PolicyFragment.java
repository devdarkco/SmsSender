package com.devdarkco.smssender.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.devdarkco.smssender.R;

import androidx.fragment.app.Fragment;

public class PolicyFragment extends Fragment {

    private CheckBox mAgree;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private static final String APP_PREFS = "smssendernv";

    public PolicyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_policy, container, false);

        mSharedPreferences = getActivity().getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        mAgree = (CheckBox) view.findViewById(R.id.check);
        mAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mEditor.putBoolean("agree", b);
                mEditor.commit();
            }
        });

        return view;
    }

}
