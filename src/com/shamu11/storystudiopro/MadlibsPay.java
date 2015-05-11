package com.shamu11.storystudiopro;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class MadlibsPay extends Fragment {

	android.support.v7.app.ActionBar actionBar;
	ImageButton playStore;
	private final static String APP_NAME = "com.murraystudio.madlibsportable";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		View view = inflater.inflate(R.layout.madlibs_pro, container, false);

		actionBar = (android.support.v7.app.ActionBar) ((MainActivity) getActivity())
				.getSupportActionBar();
		actionBar.setTitle("About");
		
		
		playStore = (ImageButton) view.findViewById(R.id.playStore);
		playStore.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) { 
				try {
				    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_NAME)));
				} catch (android.content.ActivityNotFoundException anfe) {
				    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + APP_NAME)));
				}				
			}
		});
		
		
		return view;
		
		

	}
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        populateViewForOrientation(inflater, (ViewGroup) getView());
    }
 
    private void populateViewForOrientation(LayoutInflater inflater, ViewGroup viewGroup) {
        viewGroup.removeAllViewsInLayout();
        View subview = inflater.inflate(R.layout.madlibs_pro, viewGroup);
 
        // Find your buttons in subview, set up onclicks, set up callbacks to your parent fragment or activity here.
        
        // You can create ViewHolder or separate method for that.
        // example of accessing views: TextView textViewExample = (TextView) view.findViewById(R.id.text_view_example);
        // textViewExample.setText("example");
        
		playStore = (ImageButton) subview.findViewById(R.id.playStore);
		playStore.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) { 
				try {
				    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_NAME)));
				} catch (android.content.ActivityNotFoundException anfe) {
				    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + APP_NAME)));
				}				
			}
		});
    }
}
