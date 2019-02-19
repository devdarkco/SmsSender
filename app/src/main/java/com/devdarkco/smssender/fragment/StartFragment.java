package com.devdarkco.smssender.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.devdarkco.smssender.R;
import com.devdarkco.smssender.activity.MainActivity;

import androidx.fragment.app.Fragment;

public class StartFragment extends Fragment {

    private Button mStart;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private static final String APP_PREFS = "smssendernv";

    public StartFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        mSharedPreferences = getActivity().getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

        mStart = (Button) view.findViewById(R.id.start);
        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mSharedPreferences.getBoolean("agree", false)){
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    getActivity().finish();
                    mEditor.putBoolean("firstTimeLaunched", true);
                    mEditor.commit();
                } else {
                    Toast.makeText(getContext(), R.string.toast_message, Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

}
