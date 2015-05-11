package com.shamu11.storystudiopro;

import java.util.ArrayList;
import java.util.Map;

import com.beardedhen.androidbootstrap.BootstrapButton;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MadlibsCreate extends Fragment {

	View view;
	ImageButton newCreate;
	BootstrapButton[] create;
    Button[] createBtn;
	String[] values = null;
	int i = 0;
	android.support.v7.app.ActionBar actionBar;
	Button playStore;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.madlibcreate, container, false);

		actionBar = (android.support.v7.app.ActionBar) ((MainActivity) getActivity())
				.getSupportActionBar();
		actionBar.setTitle("Create Your Own");

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
                LinearLayout.LayoutParams.FILL_PARENT);
		
/*		playStore = (Button) view.findViewById(R.id.playStore);
		playStore.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) { 
				Fragment newFragment = new MadlibsPay();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();			
			}
		});*/

		SharedPreferences sp;

		sp = getActivity().getSharedPreferences("CreatePrefs",
				Context.MODE_PRIVATE);
		Map<String, ?> keys = sp.getAll();

		ArrayList<String> strings = new ArrayList<String>();
		for (Map.Entry<String, ?> entry : keys.entrySet()) {
			if (entry.getValue() instanceof String) {
				strings.add((String) entry.getKey());
			}
		}
		values = strings.toArray(new String[strings.size()]);

		// get child information
		ViewGroup layout1 = (ViewGroup) view.findViewById(R.id.loadView);
		int[] id = new int[layout1.getChildCount()];

		for (int i = 0; i < layout1.getChildCount(); i++) {
			id[i] = layout1.getChildAt(i).getId();
		}

		create = new BootstrapButton[layout1.getChildCount()];
        createBtn = new Button[values.length + 1];

		// create = new BootstrapButton[5];

		// int[] id = { R.id.create0, R.id.create1, R.id.create2, R.id.create3,
		// R.id.create4 };

		for (int y = 0; y < create.length; y++) {
			create[y] = (BootstrapButton) view.findViewById(id[y]);
			create[y].setVisibility(View.GONE);
		}

		for (i = 0; i < strings.size(); i++) {

			if (!(values[i].equals(null)) || (!(values[i].equals("")))) {
				//create[i].setVisibility(View.VISIBLE);
				//create[i].setText("Created Madlib: " + values[i]);
                createBtn[i] = new Button(getActivity());
                layout1.addView(createBtn[i]);
                params.setMargins(45, 15, 45, 15);
                createBtn[i].setLayoutParams(params);
                createBtn[i].setBackgroundResource(R.drawable.button_material);
                createBtn[i].setTextColor(Color.parseColor("#ffffff"));
                createBtn[i].setAllCaps(false);
                createBtn[i].setTextSize(17);
                createBtn[i].setText("Created Story: " + values[i]);

				((MainActivity) getActivity()).setStoryTitle(values[i]);

			} else {
				create[i].setVisibility(View.GONE); // if no value to be
													// displayed, hide button
			}
		}

		newCreate = (ImageButton) view.findViewById(R.id.create);
		newCreate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				((MainActivity) getActivity()).setCreateValue(values.length);
				
				//if (values.length < 2) { //used only to limit creates in free app
					Fragment newFragment = new MadlibsCreateText();
					FragmentTransaction transaction = getFragmentManager()
							.beginTransaction();

					transaction.replace(R.id.fragment_container, newFragment);
					transaction.addToBackStack(null);

					transaction.commit();
				//} else {
					//Fragment newFragment = new MadlibsPay();
					//FragmentTransaction transaction = getFragmentManager()
					//		.beginTransaction();
//
					//transaction.replace(R.id.fragment_container, newFragment);
					//transaction.addToBackStack(null);
//
					//transaction.commit();
				//}
			}
		});

		int a = 0;
		while (a < values.length) {
			final int i = a;
			createBtn[a].setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					String storyTitle = values[i];

					((MainActivity) getActivity()).setStoryTitle(storyTitle);

					Fragment newFragment = new MadlibsLoadCreatedStory();
					FragmentTransaction transaction = getFragmentManager()
							.beginTransaction();

					transaction.replace(R.id.fragment_container, newFragment);
					transaction.addToBackStack(null);

					transaction.commit();
				}
			});
			createBtn[a].setOnLongClickListener(new View.OnLongClickListener() {

				@Override
				public boolean onLongClick(View v) {
					// TODO Auto-generated method stub

					new AlertDialog.Builder(getActivity())
							.setTitle("Delete Story?")
							.setMessage("Delete This Created Story?")
							.setPositiveButton(android.R.string.yes,
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog,
												int which) {

											SharedPreferences settings = getActivity()
													.getSharedPreferences(
															"CreatePrefs",
															Context.MODE_PRIVATE);
											settings.edit().remove(values[i])
													.commit();

											createBtn[i].setVisibility(View.GONE);

										}
									})
							.setNegativeButton(android.R.string.no,
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog,
												int which) {
											// do nothing
										}
									})
							.setIcon(android.R.drawable.ic_dialog_alert).show();

					return false;
				}
			});
			a++;
		}

		// future...set on long click listener that makes value[whatever number
		// is] null or "" and then make button gone.

		/*
		 * create[0].setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { String storyTitle =
		 * values[0];
		 * 
		 * ((MainActivity) getActivity()) .setStoryTitle(storyTitle);
		 * 
		 * Fragment newFragment = new MadlibsLoadCreatedStory();
		 * FragmentTransaction transaction =
		 * getFragmentManager().beginTransaction();
		 * 
		 * transaction.replace(R.id.fragment_container, newFragment);
		 * transaction.addToBackStack(null);
		 * 
		 * transaction.commit();
		 * 
		 * } });
		 * 
		 * create[1].setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { String storyTitle =
		 * values[1];
		 * 
		 * ((MainActivity) getActivity()) .setStoryTitle(storyTitle);
		 * 
		 * Fragment newFragment = new MadlibsLoadCreatedStory();
		 * FragmentTransaction transaction =
		 * getFragmentManager().beginTransaction();
		 * 
		 * transaction.replace(R.id.fragment_container, newFragment);
		 * transaction.addToBackStack(null);
		 * 
		 * transaction.commit();
		 * 
		 * } });
		 * 
		 * create[2].setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { String storyTitle =
		 * values[2];
		 * 
		 * ((MainActivity) getActivity()) .setStoryTitle(storyTitle);
		 * 
		 * Fragment newFragment = new MadlibsLoadCreatedStory();
		 * FragmentTransaction transaction =
		 * getFragmentManager().beginTransaction();
		 * 
		 * transaction.replace(R.id.fragment_container, newFragment);
		 * transaction.addToBackStack(null);
		 * 
		 * transaction.commit();
		 * 
		 * } });
		 * 
		 * create[3].setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { String storyTitle =
		 * values[3];
		 * 
		 * ((MainActivity) getActivity()) .setStoryTitle(storyTitle);
		 * 
		 * Fragment newFragment = new MadlibsLoadCreatedStory();
		 * FragmentTransaction transaction =
		 * getFragmentManager().beginTransaction();
		 * 
		 * transaction.replace(R.id.fragment_container, newFragment);
		 * transaction.addToBackStack(null);
		 * 
		 * transaction.commit();
		 * 
		 * } }); create[4].setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { String storyTitle =
		 * values[4];
		 * 
		 * ((MainActivity) getActivity()) .setStoryTitle(storyTitle);
		 * 
		 * Fragment newFragment = new MadlibsLoadCreatedStory();
		 * FragmentTransaction transaction =
		 * getFragmentManager().beginTransaction();
		 * 
		 * transaction.replace(R.id.fragment_container, newFragment);
		 * transaction.addToBackStack(null);
		 * 
		 * transaction.commit();
		 * 
		 * } });
		 */

		return view;
	}

}
