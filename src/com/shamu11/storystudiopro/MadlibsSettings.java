package com.shamu11.storystudiopro;

import android.graphics.Color;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.support.v4.preference.PreferenceFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MadlibsSettings extends PreferenceFragment {

	android.support.v7.app.ActionBar actionBar;
	CheckBoxPreference themeSwitch;
	ListPreference fontSize;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Load the preferences from an XML resource
		addPreferencesFromResource(R.xml.prefs);
		
		actionBar = (android.support.v7.app.ActionBar) ((MainActivity) getActivity())
				.getSupportActionBar();
		actionBar.setTitle("Settings");
	}
	
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().setBackgroundColor(Color.WHITE);

    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout v = (LinearLayout) super.onCreateView(inflater, container, savedInstanceState);

        TextView text = new TextView(getActivity().getApplicationContext());
        text.setText("Hit Back To Save Changes");
        text.setTextSize(13);
        text.setTextColor(Color.parseColor("#428bca"));
        text.setGravity(Gravity.CENTER);
        text.setPadding(0, 0, 0, 30);

        v.addView(text);

        return v;
    }
}
