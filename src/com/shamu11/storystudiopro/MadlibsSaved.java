package com.shamu11.storystudiopro;

import java.util.ArrayList;
import java.util.Map;

import com.beardedhen.androidbootstrap.BootstrapButton;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class MadlibsSaved extends Fragment {

    Menu menu;
	View view;
	BootstrapButton[] load;
    Button[] loadBtn;
	String savedText;
	TextView outview;
	String[] key = null;
	String[] values = null;
	int i = 0;
	int a = 0;
	int z = 0;
	View nextChild;
	int[] id;
	android.support.v7.app.ActionBar actionBar;
	String shareStoryText;
	
	//AdView adView;
	//AdRequest adRequest;
	
	int fontSizeInt = 22;
	
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(false);

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.saved_libs, container, false);

        showOverflowMenu(false);
		
/*		// Look up the AdView as a resource and load a request.
		adView = (AdView) view.findViewById(R.id.adView);
		adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR) // All emulators
				.addTestDevice("90BC42D1E9E60DCB46BCBA82A1A0D0D7") // My Galaxy
																	// Nexus
																	// test
																	// phone
				.build();
		//adView.loadAd(adRequest);
*/

		actionBar = (android.support.v7.app.ActionBar) ((MainActivity) getActivity())
				.getSupportActionBar();
		actionBar.setTitle("Saved Stories");

		outview = (TextView) view.findViewById(R.id.loadedText);

		LinearLayout layout = (LinearLayout) view.findViewById(R.id.loadView);
		layout.setOrientation(LinearLayout.VERTICAL);

		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);

/*		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(getActivity());*/
		SharedPreferences sp;
		sp = getActivity().getSharedPreferences("SavedPrefs", Context.MODE_PRIVATE);
		
		Map<String, ?> keys = sp.getAll();

		ArrayList<String> strings = new ArrayList<String>();
		for (Map.Entry<String, ?> entry : keys.entrySet()) {
			if (entry.getValue() instanceof String) {
				strings.add((String) entry.getKey());
			}
		}
		values = strings.toArray(new String[strings.size()]);
		
		//get child information
		ViewGroup layout1 = (ViewGroup) view.findViewById(R.id.loadView);
		int[] id = new int[layout1.getChildCount()];

		for (int i = 0; i < layout1.getChildCount(); i++) {
			id[i] = layout1.getChildAt(i).getId();
		}

		load = new BootstrapButton[layout.getChildCount()];
        loadBtn = new Button[values.length + 1];

		for (int y = 0; y < load.length; y++) {
			load[y] = (BootstrapButton) view.findViewById(id[y]);
			load[y].setVisibility(View.GONE);
		}
		
		for (i = 0; i < strings.size(); i++) {

			if (!(values[i].equals(null)) || (!(values[i].equals("")))) {
				//load[i].setVisibility(View.VISIBLE);
				//load[i].setText("Saved Madlib: " + values[i]);
                loadBtn[i] = new Button(getActivity());
                layout1.addView(loadBtn[i]);
                params.setMargins(45, 15, 45, 15);
                loadBtn[i].setLayoutParams(params);
                loadBtn[i].setBackgroundResource(R.drawable.button_material);
                loadBtn[i].setTextColor(Color.parseColor("#ffffff"));
                loadBtn[i].setAllCaps(false);
                loadBtn[i].setTextSize(17);
                loadBtn[i].setText("Saved Story: " + values[i]);
			} else {
				load[i].setVisibility(View.GONE);
			}
		}
		
		int a = 0;
		while (a < values.length)
		{
			final int i = a;
			loadBtn[a].setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
/*					SharedPreferences sp1 = PreferenceManager
							.getDefaultSharedPreferences(getActivity());*/
					SharedPreferences sp1;
					sp1 = getActivity().getSharedPreferences("SavedPrefs", Context.MODE_PRIVATE);
					
					savedText = sp1.getString(values[i], "Couldn't Retrieve Saved Story");
					
					SharedPreferences settings = PreferenceManager
							.getDefaultSharedPreferences(getActivity());
					String fontSizeString = settings.getString("list", "22");
					fontSizeInt = Integer.parseInt(fontSizeString);
					
					actionBar = (android.support.v7.app.ActionBar) ((MainActivity) getActivity())
							.getSupportActionBar();
					actionBar.setTitle(values[i]);
					
					outview.setText(savedText);
					outview.setTextSize(fontSizeInt);
					
					Log.d("ADebugFontSize", "Value: " + fontSizeInt);
					
					setHasOptionsMenu(true);
					
					shareStoryText = outview.getText().toString();

					ScrollView textScroll = (ScrollView) view
							.findViewById(R.id.scrollView1);
					textScroll.getLayoutParams().width = LayoutParams.FILL_PARENT;
					textScroll.getLayoutParams().height = LayoutParams.FILL_PARENT;

                    showOverflowMenu(true);
					
					//adView.loadAd(adRequest);
					
					Log.d("ADebugTagButtonNumber", "Value: " + i);
					
				}
			});
			loadBtn[a].setOnLongClickListener(new View.OnLongClickListener() {
				
				@Override
				public boolean onLongClick(View v) {
					// TODO Auto-generated method stub
					
					new AlertDialog.Builder(getActivity())
				    .setTitle("Delete Story?")
				    .setMessage("Delete This Saved Story?")
				    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int which) { 
							
				        	SharedPreferences settings = getActivity().getSharedPreferences("SavedPrefs", Context.MODE_PRIVATE);
							settings.edit().remove(values[i]).commit();
							
							loadBtn[i].setVisibility(View.GONE);
							
							
				        }
				     })
				    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
				        public void onClick(DialogInterface dialog, int which) { 
				            // do nothing
				        }
				     })
				    .setIcon(android.R.drawable.ic_dialog_alert)
				     .show();	
					
					return false;
				}
			});
			a++;
		}

		return view;
	}

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.action_menu, menu);
        this.menu = menu;
    }

    public void showOverflowMenu(boolean showMenu){
        if(menu == null)
            return;
        menu.setGroupVisible(R.id.main_menu_group, showMenu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.share:
                Intent i=new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Story Studio Creation");
                i.putExtra(android.content.Intent.EXTRA_TEXT, shareStoryText);
                startActivity(Intent.createChooser(i,"Share Story via"));
                break;
        }
        return false;
    }

}
