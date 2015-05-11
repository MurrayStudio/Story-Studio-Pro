package com.shamu11.storystudiopro;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.rengwuxian.materialedittext.MaterialEditText;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;

public class MadlibsLoadCreatedStory extends Fragment {

	View view;
    MaterialEditText[] addEdit;
	String field[];
	int[] editTextNumber = new int[1];
	String readString;
	String storyTitle;
	String[] fields = new String[200];
	StringBuffer stringbuffer = new StringBuffer();
	String[] stringviews = new String[16];
	int outviewid;
	Button convert, save;
	String outputText;
	TextView output;
	String story[];
	String savedTitle = "";
	android.support.v7.app.ActionBar actionBar;
	String shareStoryText;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(false);

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.madlibs_load_created_story, container,
				false);

		actionBar = (android.support.v7.app.ActionBar) ((MainActivity) getActivity())
				.getSupportActionBar();
		
		outviewid = (R.id.outview14);
		
		output = (TextView) view.findViewById(R.id.outview14);

		storyTitle = ((MainActivity) getActivity()).getStoryTitle();
		
		actionBar.setTitle(storyTitle);

		LinearLayout l_layout = (LinearLayout) view
				.findViewById(R.id.anskey_clover);
		l_layout.setOrientation(LinearLayout.VERTICAL);

		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);

		try {
			FileInputStream fIn = getActivity().openFileInput(
					storyTitle + "_fields.txt");
			ObjectInputStream isr = new ObjectInputStream(fIn);

			fields = (String[]) isr.readObject();
			isr.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			FileInputStream fIn = getActivity().openFileInput(
					storyTitle + "_story.txt");
			ObjectInputStream isr = new ObjectInputStream(fIn);

			story = (String[]) isr.readObject();
			isr.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileInputStream fIn = getActivity().openFileInput(
					storyTitle + "_numEditText.txt");
			ObjectInputStream isr = new ObjectInputStream(fIn);

			editTextNumber = (int[]) isr.readObject();
			isr.close();
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		addEdit = new MaterialEditText[editTextNumber[0]];

		for (int y = 0; y < editTextNumber[0]; y++) {
			addEdit[y] = new MaterialEditText(getActivity());
			l_layout.addView(addEdit[y]);
			params.setMargins(0, 20, 0, 20);
			addEdit[y].setLayoutParams(params);
			addEdit[y].setId(y);
			addEdit[y].setHint(fields[y]);
		}

		convert = (Button) view.findViewById(R.id.convert);
		convert.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				int i;
				String s;
				int b = 0;

				for (i = 0; i < addEdit.length; i++) {
					s = addEdit[i].getText().toString().trim();

					if (s.isEmpty() || s.length() == 0 || s.equals("")
							|| s == null) {

					} else {
						b = b + 1;
					}
				}
				if (b == editTextNumber[0]) {
					gather();
					postIt();
					outputText = output.getText().toString();
					setHasOptionsMenu(true);
				} else {
					Toast.makeText(getActivity().getApplicationContext(),
							"Please Fill In All Fields", Toast.LENGTH_LONG)
							.show();
				}

			}
		});
		
		save = (Button) view.findViewById(R.id.save);
		save.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("Set Saved Story Title:");

				// Set up the input
				final EditText input = new EditText(getActivity());
				// Specify the type of input expected; this, for example, sets
				// the input as a password, and will mask the text
				builder.setView(input);

				// Set up the buttons
				builder.setPositiveButton("Save",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								savedTitle = input.getText().toString();

/*								SharedPreferences sp;

								sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
								sp.edit().putString(savedTitle, outputText)
										.commit();*/
								
								SharedPreferences sp;

								sp = getActivity().getSharedPreferences(
										"SavedPrefs", Context.MODE_PRIVATE);
								sp.edit()
										.putString(savedTitle,
												outputText)
										.commit();

								Toast.makeText(
										getActivity().getApplicationContext(),
										"Saved", Toast.LENGTH_LONG).show();
							}
						});
				builder.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.cancel();
							}
						});

				builder.show();

			}
		});
		
		

		return view;
	}

	public void gather() {

		ViewGroup layout = (ViewGroup) view.findViewById(R.id.anskey_clover);
		View[] views = new View[layout.getChildCount()];
		int[] ids = new int[layout.getChildCount()];

		for (int i = 0; i < layout.getChildCount(); i++) {
			ids[i] = layout.getChildAt(i).getId();
		}

		for (int i = 0; i < layout.getChildCount(); i++) {
            MaterialEditText au = (MaterialEditText) view
					.findViewById(ids[i]);
			stringbuffer.append(au.getText().toString() + "\n");

		}

	}

	public void postIt() {
		String str = "let's go to the park";
		String str2;
		String newstr = null;
		Spanned spanned = null;
		
		SharedPreferences settings = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		String fontSizeString = settings.getString("list", "22");
		int fontSizeInt = Integer.parseInt(fontSizeString);

		TextView outview = (TextView) view.findViewById(outviewid);
		outview.setTextSize(fontSizeInt);
		//str = (String) outview.getText();
		str = story[0];
		stringviews = stringbuffer.toString().split("\n"); // turns the
															// stringbuffer from
															// getAllXml() into
															// an array and
															// assigns to
															// stringviews.

		for (int i = 0; i < stringviews.length; i++) {

			str2 = stringviews[i];
			str2 = "<b>" + str2 + "</b>";
			newstr = str.replaceFirst("_", str2); // replaces all the "_"s in
													// the
													// main_class_activity_out
													// textview with values from
													// strinvgviews.
			str = newstr;
			spanned = Html.fromHtml(str);
		}
		outview.setText(spanned);
		ScrollView textScroll = (ScrollView) view
				.findViewById(R.id.scrollView1);
		textScroll.getLayoutParams().width = LayoutParams.FILL_PARENT;
		textScroll.getLayoutParams().height = LayoutParams.FILL_PARENT;

		stringbuffer.delete(0, stringbuffer.length());
		
		shareStoryText = outview.getText().toString();

	}
	
	public void onCreateOptionsMenu(
		      Menu menu, MenuInflater inflater) {
		   inflater.inflate(R.menu.action_menu, menu);
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
