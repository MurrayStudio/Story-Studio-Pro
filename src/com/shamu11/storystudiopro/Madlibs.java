package com.shamu11.storystudiopro;

import com.rengwuxian.materialedittext.MaterialEditText;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;

public class Madlibs extends Fragment {
	private int outviewid; // will hold the id number for the textview found in
	// main_class_activity_out.xml
	String test;
	StringBuffer stringbuffer = new StringBuffer();
	String[] stringviews = new String[16];

	private String[] Stories;
	private String[] Titles;

	MaterialEditText[] addEdit;

	String savedTitle = "";

	Button convert, save;
	TextView output;
	String outputText;

	android.support.v7.app.ActionBar actionBar;
	String title;
	int editTextNumber = 0;

	String temp;

	View view;

	String shareStoryText;

	//AdView adView;
	//AdRequest adRequest;

	private int fontSizeInt = 22;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(false);

	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// super.onCreate(savedInstanceState);

		Stories = getResources().getStringArray(R.array.MadlibsStories);
		Titles = getResources().getStringArray(R.array.MadlibsTitles);

		view = inflater.inflate(R.layout.madlibinput1, container, false);

/*		// Look up the AdView as a resource and load a request.
		adView = (AdView) view.findViewById(R.id.adView);
		adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR) // All emulators
				.addTestDevice("90BC42D1E9E60DCB46BCBA82A1A0D0D7") // My Galaxy
																	// Nexus
																	// test
																	// phone
				.build();
		// adView.loadAd(adRequest);
*/
		LinearLayout l_layout = (LinearLayout) view
				.findViewById(R.id.anskey_clover);
		l_layout.setOrientation(LinearLayout.VERTICAL);

		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);

		outviewid = (R.id.outview14);

		actionBar = (android.support.v7.app.ActionBar) ((MainActivity) getActivity())
				.getSupportActionBar();

		output = (TextView) view.findViewById(R.id.outview14);

		switch (((MainActivity) getActivity()).getStory()) {
		case 0:
			output.setText(Stories[0]);
			title = Titles[0];
			actionBar.setTitle(title);
			editTextNumber = 12;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Name of Sickness");
			addEdit[1].setHint("Adjective");
			addEdit[2].setHint("Name of Boy");
			addEdit[3].setHint("Body Part");
			addEdit[4].setHint("Color");
			addEdit[5].setHint("Animal");
			addEdit[6].setHint("Article of Clothing");
			addEdit[7].setHint("Relative");
			addEdit[8].setHint("Adjective");
			addEdit[9].setHint("Article of Clothing");
			addEdit[10].setHint("Body Part");
			addEdit[11].setHint("Number");

			break;
		case 1:
			output.setText(Stories[1]);
			title = Titles[1];
			actionBar.setTitle(title);
			editTextNumber = 47;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Number");
			addEdit[1].setHint("Type of Shelter");
			addEdit[2].setHint("Something Outside");
			addEdit[3].setHint("Adjective");
			addEdit[4].setHint("Male Relative");
			addEdit[5].setHint("Adjective");
			addEdit[6].setHint("Transportation");
			addEdit[7].setHint("Verb");
			addEdit[8].setHint("Color");
			addEdit[9].setHint("Verb");
			addEdit[10].setHint("Open or Shut");
			addEdit[11].setHint("Number");
			addEdit[12].setHint("Men or Women");
			addEdit[13].setHint("Adjective");
			addEdit[14].setHint("Cartoon Character");
			addEdit[15].setHint("Noun");
			addEdit[16].setHint("Verb ending in ING");
			addEdit[17].setHint("Noun");
			addEdit[18].setHint("Animal");
			addEdit[19].setHint("Body Part");
			addEdit[20].setHint("Clothing");
			addEdit[21].setHint("Female Relative");
			addEdit[22].setHint("Noun");
			addEdit[23].setHint("Noun");
			addEdit[24].setHint("Type of Material");
			addEdit[25].setHint("Body Part");
			addEdit[26].setHint("Another Female Relative");
			addEdit[27].setHint("Room of House");
			addEdit[28].setHint("Noun");
			addEdit[29].setHint("Noun");
			addEdit[30].setHint("Verb ending in ED");
			addEdit[31].setHint("Verb ending in ED");
			addEdit[32].setHint("Body Part");
			addEdit[33].setHint("Number");
			addEdit[34].setHint("Room of House");
			addEdit[35].setHint("Plural Occupation (Dancers, Doctors, Etc)");
			addEdit[36].setHint("Body Part");
			addEdit[37].setHint("Plural Noun");
			addEdit[38].setHint("Clothing");
			addEdit[39].setHint("Noun");
			addEdit[40].setHint("Adjective");
			addEdit[41].setHint("Good or Bad");
			addEdit[42].setHint("Country");
			addEdit[43].setHint("Plural Noun");
			addEdit[44].setHint("Number");
			addEdit[45].setHint("Number");
			addEdit[46].setHint("Single Food Item");

			break;
		case 2:
			output.setGravity(Gravity.CENTER);
			output.setText(Stories[2]);
			title = Titles[2];
			actionBar.setTitle(title);
			editTextNumber = 14;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Noun");
			addEdit[1].setHint("Noun");
			addEdit[2].setHint("Verb ending in ING");
			addEdit[3].setHint("Noun");
			addEdit[4].setHint("Adjective");
			addEdit[5].setHint("Verb");
			addEdit[6].setHint("Noun");
			addEdit[7].setHint("Animal (plural)");
			addEdit[8].setHint("Adjective");
			addEdit[9].setHint("Plural Noun");
			addEdit[10].setHint("Verb");
			addEdit[11].setHint("Plural Noun");
			addEdit[12].setHint("Adjective");
			addEdit[13].setHint("Plural Noun");
			break;
		case 3:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[3]);
			title = Titles[3];
			actionBar.setTitle(title);
			editTextNumber = 11;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Adjective");
			addEdit[1].setHint("Part of Body");
			addEdit[2].setHint("Noun");
			addEdit[3].setHint("Noun");
			addEdit[4].setHint("Adjective");
			addEdit[5].setHint("Adjective");
			addEdit[6].setHint("Verb ending in S");
			addEdit[7].setHint("Adjective");
			addEdit[8].setHint("Animal");
			addEdit[9].setHint("Adjective");
			addEdit[10].setHint("Adjective");
			break;
		case 4:
			output.setText(Stories[4]);
			title = Titles[4];
			actionBar.setTitle(title);
			editTextNumber = 29;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Adjective");
			addEdit[1].setHint("Body Part");
			addEdit[2].setHint("Adjective");
			addEdit[3].setHint("Food Item");
			addEdit[4].setHint("Adjective");
			addEdit[5].setHint("Exclamation");
			addEdit[6].setHint("Adjective");
			addEdit[7].setHint("Adjective");
			addEdit[8].setHint("Exclamation");
			addEdit[9].setHint("Adjective");
			addEdit[10].setHint("Adjective");
			addEdit[11].setHint("Adjective");
			addEdit[12].setHint("Funny Word");
			addEdit[13].setHint("Room of the House");
			addEdit[14].setHint("Exclamation");
			addEdit[15].setHint("Animal");
			addEdit[16].setHint("First Name");
			addEdit[17].setHint("Location");
			addEdit[18].setHint("Adjective");
			addEdit[19].setHint("Exclamation");
			addEdit[20].setHint("Number");
			addEdit[21].setHint("Plural Noun");
			addEdit[22].setHint("Plural Noun");
			addEdit[23].setHint("Noun");
			addEdit[24].setHint("Adjective");
			addEdit[25].setHint("Animal");
			addEdit[26].setHint("Adjective");
			addEdit[27].setHint("Piece of Furniture");
			addEdit[28].setHint("Adjective");
			break;
		case 5:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[5]);
			title = Titles[5];
			actionBar.setTitle(title);
			editTextNumber = 24;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("First Name");
			addEdit[1].setHint("Emotion");
			addEdit[2].setHint("Adjective");
			addEdit[3].setHint("Body Part");
			addEdit[4].setHint("Adjective");
			addEdit[5].setHint("Noun");
			addEdit[6].setHint("Adjective");
			addEdit[7].setHint("Adjective");
			addEdit[8].setHint("Adjective");
			addEdit[9].setHint("Verb");
			addEdit[10].setHint("Adjective");
			addEdit[11]
					.setHint("Abstract noun (A noun you can't see i.e. love, pain, etc)");
			addEdit[12]
					.setHint("Abstract noun (A noun you can't see i.e. love, pain, etc)");
			addEdit[13].setHint("Plural Noun");
			addEdit[14].setHint("Number");
			addEdit[15].setHint("Adjective");
			addEdit[16].setHint("Body Part");
			addEdit[17].setHint("Adjective");
			addEdit[18].setHint("Adjective");
			addEdit[19].setHint("Body Part");
			addEdit[20].setHint("Body Part");
			addEdit[21].setHint("Verb");
			addEdit[22].setHint("Body Part");
			addEdit[23].setHint("First Name");
			break;

		case 6:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[6]);
			title = Titles[6];
			actionBar.setTitle(title);
			editTextNumber = 16;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Verb - Non 3rd Person Singular Present");
			addEdit[1].setHint("Noun");
			addEdit[2].setHint("Noun");
			addEdit[3].setHint("Noun");
			addEdit[4].setHint("Plural Noun");
			addEdit[5].setHint("Noun");
			addEdit[6].setHint("Plural Noun");
			addEdit[7]
					.setHint("Preposition (i.e. about, before, in, off, etc.)");
			addEdit[8].setHint("Verb - Past Tense");
			addEdit[9].setHint("Noun");
			addEdit[10].setHint("Noun");
			addEdit[11].setHint("Noun");
			addEdit[12].setHint("Verb - Past Tense");
			addEdit[13].setHint("Noun");
			addEdit[14].setHint("Verb - Past Tense");
			addEdit[15].setHint("Noun");
			break;

		case 7:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[7]);
			title = Titles[7];
			actionBar.setTitle(title);
			editTextNumber = 15;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("First Name");
			addEdit[1].setHint("Adjective");
			addEdit[2].setHint("Verb");
			addEdit[3].setHint("Verb");
			addEdit[4].setHint("Plural Noun");
			addEdit[5].setHint("Plural Noun");
			addEdit[6].setHint("First Name");
			addEdit[7].setHint("Verb");
			addEdit[8].setHint("Verb");
			addEdit[9].setHint("Verb");
			addEdit[10].setHint("Noun");
			addEdit[11].setHint("Verb ending in ING");
			addEdit[12].setHint("First Name");
			addEdit[13].setHint("Plural Noun");
			addEdit[14].setHint("Adjective");
			break;

		case 8:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[8]);
			title = Titles[8];
			actionBar.setTitle(title);
			editTextNumber = 18;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Adjective");
			addEdit[1].setHint("Name of a Person");
			addEdit[2].setHint("Verb ending in ING");
			addEdit[3].setHint("Noun");
			addEdit[4].setHint("Part of Body");
			addEdit[5].setHint("Adjective");
			addEdit[6].setHint("Name of a Person");
			addEdit[7].setHint("Verb Past Tense");
			addEdit[8].setHint("Plural Noun");
			addEdit[9].setHint("Plural Noun");
			addEdit[10].setHint("Proper Noun");
			addEdit[11].setHint("Job Title");
			addEdit[12].setHint("Noun");
			addEdit[13].setHint("Plural Noun");
			addEdit[14].setHint("Verb");
			addEdit[15].setHint("Plural Noun");
			addEdit[16].setHint("Adjective");
			addEdit[17].setHint("Period of Time");
			break;

		case 9:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[9]);
			title = Titles[9];
			actionBar.setTitle(title);
			editTextNumber = 22;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Number");
			addEdit[1].setHint("First Name of a Person");
			addEdit[2].setHint("Animal");
			addEdit[3].setHint("Location");
			addEdit[4].setHint("Adjective");
			addEdit[5].setHint("Noun");
			addEdit[6].setHint("Color");
			addEdit[7].setHint("Animal (plural)");
			addEdit[8].setHint("Color");
			addEdit[9].setHint("Adjective");
			addEdit[10].setHint("Noun");
			addEdit[11].setHint("Celebrity Name");
			addEdit[12].setHint("Plural Noun");
			addEdit[13].setHint("Adverb  (i.e gently, quite, then, there)");
			addEdit[14].setHint("Adjective");
			addEdit[15].setHint("Noun");
			addEdit[16].setHint("Exclamation");
			addEdit[17].setHint("Verb Ending In ING");
			addEdit[18].setHint("Celebrity Name");
			addEdit[19].setHint("Verb Ending In ING");
			addEdit[20].setHint("Noun");
			addEdit[21].setHint("Exclamation");
			break;

		case 10:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[10]);
			title = Titles[10];
			actionBar.setTitle(title);
			editTextNumber = 17;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("First Name");
			addEdit[1].setHint("Word");
			addEdit[2].setHint("Word ending in er");
			addEdit[3].setHint("Word ending in er");
			addEdit[4].setHint("Color");
			addEdit[5].setHint("Noun");
			addEdit[6].setHint("Word");
			addEdit[7].setHint("Number");
			addEdit[8].setHint("Verb");
			addEdit[9].setHint("Verb");
			addEdit[10].setHint("Liquid holding device");
			addEdit[11].setHint("Word ending in er");
			addEdit[12].setHint("Noun");
			addEdit[13].setHint("Number");
			addEdit[14].setHint("Adjective");
			addEdit[15].setHint("Number");
			addEdit[16].setHint("Verb");
			break;

		case 11:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[11]);
			title = Titles[11];
			actionBar.setTitle(title);
			editTextNumber = 23;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Company Name");
			addEdit[1].setHint("Adjective");
			addEdit[2].setHint("Adjective");
			addEdit[3].setHint("Adjective");
			addEdit[4].setHint("Article of Clothing");
			addEdit[5].setHint("Adjective");
			addEdit[6].setHint("Adjective");
			addEdit[7].setHint("Body Part");
			addEdit[8].setHint("Verb");
			addEdit[9].setHint("Verb");
			addEdit[10].setHint("Noun");
			addEdit[11].setHint("Adjective");
			addEdit[12].setHint("Adjective");
			addEdit[13].setHint("Body Part");
			addEdit[14].setHint("Noun");
			addEdit[15].setHint("Noun");
			addEdit[16].setHint("Plural Noun");
			addEdit[17].setHint("Plural Noun");
			addEdit[18].setHint("Adjective");
			addEdit[19].setHint("Noun");
			addEdit[20].setHint("Verb ending in ING");
			addEdit[21].setHint("Plural Noun");
			addEdit[22].setHint("Verb");
			break;

		case 12:
			output.setGravity(Gravity.CENTER);
			output.setText(Stories[12]);
			title = Titles[12];
			actionBar.setTitle(title);
			editTextNumber = 28;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Adjective");
			addEdit[1].setHint("Present Tense Verb");
			addEdit[2].setHint("Room in a House");
			addEdit[3].setHint("Present Tense Verb");
			addEdit[4].setHint("Body Part");
			addEdit[5].setHint("Adjective");
			addEdit[6].setHint("Verb ending in ING");
			addEdit[7].setHint("Adjective");
			addEdit[8].setHint("Adjective");
			addEdit[9].setHint("Adjective");
			addEdit[10].setHint("Adjective");
			addEdit[11].setHint("Adjective");
			addEdit[12].setHint("Room in House");
			addEdit[13].setHint("Present Tense Verb");
			addEdit[14].setHint("Body Part");
			addEdit[15].setHint("Adjective");
			addEdit[16].setHint("Adjective");
			addEdit[17].setHint("Adjective");
			addEdit[18].setHint("Present Tense Verb");
			addEdit[19].setHint("Body Part");
			addEdit[20].setHint("Adjective");
			addEdit[21].setHint("Present Tense Verb");
			addEdit[22].setHint("Body Part");
			addEdit[23].setHint("Adjective");
			addEdit[24].setHint("Verb ending in ING");
			addEdit[25].setHint("Adjective");
			addEdit[26].setHint("Adjective");
			addEdit[27].setHint("Adjective");
			break;

		case 13:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[13]);
			title = Titles[13];
			actionBar.setTitle(title);
			editTextNumber = 9;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("First Name");
			addEdit[1].setHint("Noun");
			addEdit[2].setHint("Noun");
			addEdit[3].setHint("Adjective");
			addEdit[4].setHint("Noun");
			addEdit[5].setHint("Noun");
			addEdit[6].setHint("Adverb  (i.e gently, quite, then, there)");
			addEdit[7].setHint("Adverb  (i.e gently, quite, then, there)");
			addEdit[8].setHint("Noun");
			break;

		case 14:
			output.setGravity(Gravity.CENTER);
			output.setText(Stories[14]);
			title = Titles[14];
			actionBar.setTitle(title);
			editTextNumber = 20;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Adjective");
			addEdit[1].setHint("Noun");
			addEdit[2].setHint("Adjective");
			addEdit[3].setHint("Noun");
			addEdit[4].setHint("Plural Noun");
			addEdit[5].setHint("Past tense Verb");
			addEdit[6].setHint("Plural Noun");
			addEdit[7].setHint("Past tense Verb");
			addEdit[8].setHint("Adjective");
			addEdit[9].setHint("Past tense Verb");
			addEdit[10].setHint("Adjective");
			addEdit[11].setHint("Past tense Verb");
			addEdit[12].setHint("Amount of Time");
			addEdit[13].setHint("Noun");
			addEdit[14].setHint("Noun");
			addEdit[15].setHint("Noun");
			addEdit[16].setHint("Noun");
			addEdit[17].setHint("Noun");
			addEdit[18].setHint("Plural Noun");
			addEdit[19].setHint("Past tense Verb");
			break;

		case 15:
			output.setGravity(Gravity.CENTER);
			output.setText(Stories[15]);
			title = Titles[15];
			actionBar.setTitle(title);
			editTextNumber = 13;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Number");
			addEdit[1].setHint("First name");
			addEdit[2].setHint("First name");
			addEdit[3].setHint("Song");
			addEdit[4].setHint("Location");
			addEdit[5].setHint("Song");
			addEdit[6].setHint("Number");
			addEdit[7].setHint("Name of Person");
			addEdit[8].setHint("Location");
			addEdit[9].setHint("Name of Person");
			addEdit[10].setHint("Adjective ending in EST");
			addEdit[11].setHint("Location");
			addEdit[12].setHint("Adjective ending in ER");
			break;

		case 16:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[16]);
			title = Titles[16];
			actionBar.setTitle(title);
			editTextNumber = 6;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Adjective");
			addEdit[1].setHint("Adjective");
			addEdit[2].setHint("Adjective");
			addEdit[3].setHint("Adjective");
			addEdit[4].setHint("Adjective");
			addEdit[5].setHint("Adjective");
			break;

		case 17:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[17]);
			title = Titles[17];
			actionBar.setTitle(title);
			editTextNumber = 14;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Adjective");
			addEdit[1].setHint("Place");
			addEdit[2].setHint("Adjective");
			addEdit[3].setHint("Number");
			addEdit[4].setHint("Plural Body Part");
			addEdit[5].setHint("Adjective");
			addEdit[6].setHint("Adjective");
			addEdit[7].setHint("Adjective");
			addEdit[8].setHint("Direction");
			addEdit[9].setHint("Personality");
			addEdit[10].setHint("Verb - Present (-ing)");
			addEdit[11].setHint("Noun");
			addEdit[12].setHint("Number");
			addEdit[13].setHint("Fake or Real Animal (Plural)");
			break;

		case 18:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[18]);
			title = Titles[18];
			actionBar.setTitle(title);
			editTextNumber = 11;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Adjective");
			addEdit[1].setHint("Adjective");
			addEdit[2].setHint("Noun");
			addEdit[3].setHint("Noun");
			addEdit[4].setHint("Noun");
			addEdit[5].setHint("Past Tense Verb");
			addEdit[6].setHint("Noun");
			addEdit[7].setHint("Liquid");
			addEdit[8].setHint("Adjective");
			addEdit[9].setHint("Adjective");
			addEdit[10].setHint("Noun");
			break;

		case 19:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[19]);
			title = Titles[19];
			actionBar.setTitle(title);
			editTextNumber = 33;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Nonsense Word");
			addEdit[1].setHint("Nonsense Word");
			addEdit[2].setHint("Occupation");
			addEdit[3].setHint("Nonsense Word");
			addEdit[4].setHint("Nonsense Word");
			addEdit[5].setHint("Occupation");
			addEdit[6].setHint("Nonsense Word");
			addEdit[7].setHint("Adjective");
			addEdit[8].setHint("Nonsense Word");
			addEdit[9].setHint("Nonsense Word");
			addEdit[10].setHint("Nonsense Word");
			addEdit[11].setHint("Nonsense Word");
			addEdit[12].setHint("Verb");
			addEdit[13].setHint("Occupation");
			addEdit[14].setHint("Nonsense Word");
			addEdit[15].setHint("Occupation");
			addEdit[16].setHint("Nonsense Word");
			addEdit[17].setHint("Adjective");
			addEdit[18].setHint("Occupation");
			addEdit[19].setHint("Nonsense Word");
			addEdit[20].setHint("Nonsense Word");
			addEdit[21].setHint("Nonsense Word");
			addEdit[22].setHint("Noun");
			addEdit[23].setHint("Nonsense Word");
			addEdit[24].setHint("Noun");
			addEdit[25].setHint("Noun");
			addEdit[26].setHint("Occupation");
			addEdit[27].setHint("Nonsense Word");
			addEdit[28].setHint("Adjective");
			addEdit[29].setHint("Adjective");
			addEdit[30].setHint("Noun");
			addEdit[31].setHint("Adjective");
			addEdit[32].setHint("Adjective");
			break;

		case 20:
			output.setGravity(Gravity.CENTER);
			output.setText(Stories[20]);
			title = Titles[20];
			actionBar.setTitle(title);
			editTextNumber = 38;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Verb");
			addEdit[1].setHint("Noun");
			addEdit[2].setHint("Past Tense Verb");
			addEdit[3].setHint("Past Tense Verb");
			addEdit[4].setHint("Verb");
			addEdit[5].setHint("Adjective");
			addEdit[6].setHint("Adjective");
			addEdit[7].setHint("Past Tense Verb");
			addEdit[8].setHint("Plural Noun");
			addEdit[9].setHint("Past Tense Verb");
			addEdit[10].setHint("Plural Noun");
			addEdit[11].setHint("Adjective");
			addEdit[12].setHint("Plural Noun");
			addEdit[13].setHint("Adjective");
			addEdit[14].setHint("Verb");
			addEdit[15].setHint("Plural Noun");
			addEdit[16].setHint("Verb ending in ING");
			addEdit[17].setHint("Plural Noun");
			addEdit[18].setHint("Noun");
			addEdit[19].setHint("Past Tense Verb");
			addEdit[20].setHint("Past Tense Verb");
			addEdit[21].setHint("Plural Noun");
			addEdit[22].setHint("Verb");
			addEdit[23].setHint("Adjective");
			addEdit[24].setHint("Adjective");
			addEdit[25].setHint("Plural Noun");
			addEdit[26].setHint("Verb");
			addEdit[27].setHint("Verb");
			addEdit[28].setHint("Verb");
			addEdit[29].setHint("Noun");
			addEdit[30].setHint("Verb");
			addEdit[31].setHint("Past Tense Verb");
			addEdit[32].setHint("Noun");
			addEdit[33].setHint("Past Tense Verb");
			addEdit[34].setHint("Past Tense Verb");
			addEdit[35].setHint("Verb ending in ING");
			addEdit[36].setHint("Noun");
			addEdit[37].setHint("Noun");
			break;

		case 21:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[21]);
			title = Titles[21];
			actionBar.setTitle(title);
			editTextNumber = 34;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Adjective");
			addEdit[1].setHint("Adjective");
			addEdit[2].setHint("Adjective");
			addEdit[3].setHint("Noun");
			addEdit[4].setHint("Adjective");
			addEdit[5].setHint("Location");
			addEdit[6].setHint("Adjective");
			addEdit[7].setHint("Adjective");
			addEdit[8].setHint("Adjective");
			addEdit[9].setHint("Animal Plural");
			addEdit[10].setHint("Adjective");
			addEdit[11].setHint("Adjective");
			addEdit[12].setHint("Animal Plural");
			addEdit[13].setHint("Number");
			addEdit[14].setHint("Number");
			addEdit[15].setHint("Adjective");
			addEdit[16].setHint("Number");
			addEdit[17].setHint("Past Tense Verb");
			addEdit[18].setHint("Adjective");
			addEdit[19].setHint("Adjective");
			addEdit[20].setHint("Animal Plural");
			addEdit[21].setHint("Noun");
			addEdit[22].setHint("Adjective");
			addEdit[23].setHint("Past Tense Verb");
			addEdit[24].setHint("Adverb  (i.e gently, quite, then, there)");
			addEdit[25].setHint("Noun");
			addEdit[26].setHint("Adverb  (i.e gently, quite, then, there)");
			addEdit[27].setHint("Noun");
			addEdit[28].setHint("Number");
			addEdit[29].setHint("Adjective");
			addEdit[30].setHint("Adjective");
			addEdit[31].setHint("Adverb  (i.e gently, quite, then, there)");
			addEdit[32].setHint("Adjective");
			addEdit[33].setHint("Adjective");
			break;

		case 22:
			// output.setGravity(Gravity.CENTER);
			output.setText(Stories[22]);
			title = Titles[22];
			actionBar.setTitle(title);
			editTextNumber = 17;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Plural noun");
			addEdit[1].setHint("Verb ending in ING");
			addEdit[2].setHint("Noun");
			addEdit[3].setHint("Noun");
			addEdit[4].setHint("Plural Noun");
			addEdit[5].setHint("Part of Body");
			addEdit[6].setHint("Noun");
			addEdit[7].setHint("Verb ending in ING");
			addEdit[8].setHint("Adjective");
			addEdit[9].setHint("Part of Body");
			addEdit[10].setHint("Part of Body");
			addEdit[11].setHint("Verb ending in ING");
			addEdit[12].setHint("Noun");
			addEdit[13].setHint("Noun");
			addEdit[14].setHint("Part of Body");
			addEdit[15].setHint("Adverb  (i.e gently, quite, then, there)");
			addEdit[16].setHint("Part of Body Plural");
			break;

		case 23:
			output.setGravity(Gravity.CENTER);
			output.setText(Stories[23]);
			title = Titles[23];
			actionBar.setTitle(title);
			editTextNumber = 32;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Noun");
			addEdit[1].setHint("Verb");
			addEdit[2].setHint("Plural Noun");
			addEdit[3].setHint("Adjective");
			addEdit[4].setHint("Noun");
			addEdit[5].setHint("Noun");
			addEdit[6].setHint("Noun");
			addEdit[7].setHint("Adjective");
			addEdit[8].setHint("Plural Noun");
			addEdit[9].setHint("Verb");
			addEdit[10].setHint("Noun");
			addEdit[11].setHint("Adjective");
			addEdit[12].setHint("Verb");
			addEdit[13].setHint("Verb");
			addEdit[14].setHint("Adjective");
			addEdit[15].setHint("Adjective");
			addEdit[16].setHint("Noun");
			addEdit[17].setHint("Noun");
			addEdit[18].setHint("Verb");
			addEdit[19].setHint("Verb");
			addEdit[20].setHint("Verb");
			addEdit[21].setHint("Plural Noun");
			addEdit[22].setHint("Verb");
			addEdit[23].setHint("Noun");
			addEdit[24].setHint("Verb");
			addEdit[25].setHint("Verb");
			addEdit[26].setHint("Adjective");
			addEdit[27].setHint("Verb");
			addEdit[28].setHint("Verb");
			addEdit[29].setHint("Verb");
			addEdit[30].setHint("Adjective");
			addEdit[31].setHint("Verb");
			break;

		case 24:
			//output.setGravity(Gravity.CENTER);
			output.setText(Stories[24]);
			title = Titles[24];
			actionBar.setTitle(title);
			editTextNumber = 38;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Verb ending in ING");
			addEdit[1].setHint("Place");
			addEdit[2].setHint("Adjective");
			addEdit[3].setHint("Plural Noun");
			addEdit[4].setHint("Plural Noun");
			addEdit[5].setHint("Place");
			addEdit[6].setHint("Transportation");
			addEdit[7].setHint("Days, Hours, Weeks, Or Seconds");
			addEdit[8].setHint("Food");
			addEdit[9].setHint("Place");
			addEdit[10].setHint("Animal");
			addEdit[11].setHint("Adjective");
			addEdit[12].setHint("Verb");
			addEdit[13].setHint("Liquid");
			addEdit[14].setHint("Weather ending in ING");
			addEdit[15].setHint("Verb");
			addEdit[16].setHint("Noun");
			addEdit[17].setHint("Plural Noun");
			addEdit[18].setHint("Plural Noun");
			addEdit[19].setHint("Transportation");
			addEdit[20].setHint("Liquid");
			addEdit[21].setHint("Noun");
			addEdit[22].setHint("Room of House");
			addEdit[23].setHint("Plural Noun");
			addEdit[24].setHint("Emotion");
			addEdit[25].setHint("Place");
			addEdit[26].setHint("Adjective");
			addEdit[27].setHint("Body of Water");
			addEdit[28].setHint("Nationality");
			addEdit[29].setHint("Transportation");
			addEdit[30].setHint("Adverb  (i.e gently, quite, then, there)");
			addEdit[31].setHint("Yes or No");
			addEdit[32].setHint("Adjective");
			addEdit[33].setHint("Plural Animal");
			addEdit[34].setHint("Plural Animal");
			addEdit[35].setHint("Occupation");
			addEdit[36].setHint("Food");
			addEdit[37].setHint("Adjective");
			break;
			
		case 25:
			//output.setGravity(Gravity.CENTER);
			output.setText(Stories[25]);
			title = Titles[25];
			actionBar.setTitle(title);
			editTextNumber = 42;

			addEdit = new MaterialEditText[editTextNumber];
			for (int i = 0; i < addEdit.length; i++) {
				addEdit[i] = new MaterialEditText(getActivity());
				l_layout.addView(addEdit[i]);
				params.setMargins(0, 20, 0, 20);
				addEdit[i].setLayoutParams(params);
				addEdit[i].setId(i);
			}
			addEdit[0].setHint("Color");
			addEdit[1].setHint("Creature");
			addEdit[2].setHint("Animal");
			addEdit[3].setHint("Plural Food");
			addEdit[4].setHint("Liquid");
			addEdit[5].setHint("Name of Company or Brand");
			addEdit[6].setHint("Plural Food");
			addEdit[7].setHint("Name of Company or Brand");
			addEdit[8].setHint("Adjective");
			addEdit[9].setHint("Celebrity");
			addEdit[10].setHint("Adjective");
			addEdit[11].setHint("Verb ending in ING");
			addEdit[12].setHint("Verb ending in ING");
			addEdit[13].setHint("Plural Food");
			addEdit[14].setHint("Plural Food");
			addEdit[15].setHint("Time Frame (Tomorrow, Yesterday, etc.)");
			addEdit[16].setHint("Verb ending in ED");
			addEdit[17].setHint("Period of Time");
			addEdit[18].setHint("Noun");
			addEdit[19].setHint("Period of Time");
			addEdit[20].setHint("Period of Time");
			addEdit[21].setHint("Noun");
			addEdit[22].setHint("Place");
			addEdit[23].setHint("Verb ending in ING");
			addEdit[24].setHint("Time Frame (Tomorrow, Yesterday, etc.)");
			addEdit[25].setHint("Family Member");
			addEdit[26].setHint("Emotion");
			addEdit[27].setHint("Family Member");
			addEdit[28].setHint("Color");
			addEdit[29].setHint("Name");
			addEdit[30].setHint("Name");
			addEdit[31].setHint("Name");
			addEdit[32].setHint("Noun");
			addEdit[33].setHint("Plural Noun");
			addEdit[34].setHint("Adjective");
			addEdit[35].setHint("Verb ending in ED");
			addEdit[36].setHint("Verb ending in ED");
			addEdit[37].setHint("Body Part");
			addEdit[38].setHint("Plural Animal");
			addEdit[39].setHint("Adjective");
			addEdit[40].setHint("Good or Bad");
			addEdit[41].setHint("Adjective");
			break;

        case 26:
        //output.setGravity(Gravity.CENTER);
        output.setText(Stories[26]);
        title = Titles[26];
        actionBar.setTitle(title);
        editTextNumber = 29;

        addEdit = new MaterialEditText[editTextNumber];
        for (int i = 0; i < addEdit.length; i++) {
            addEdit[i] = new MaterialEditText(getActivity());
            l_layout.addView(addEdit[i]);
            params.setMargins(0, 20, 0, 20);
            addEdit[i].setLayoutParams(params);
            addEdit[i].setId(i);
        }
        addEdit[0].setHint("Adjective");
        addEdit[1].setHint("Family Member");
        addEdit[2].setHint("Number");
        addEdit[3].setHint("Animal");
        addEdit[4].setHint("Verb ending in ING");
        addEdit[5].setHint("Plural Animal");
        addEdit[6].setHint("Adjective");
        addEdit[7].setHint("Animal");
        addEdit[8].setHint("Verb");
        addEdit[9].setHint("Noun");
        addEdit[10].setHint("Plural Animal");
        addEdit[11].setHint("Plural Food");
        addEdit[12].setHint("Adjective");
        addEdit[13].setHint("Plural Animal");
        addEdit[14].setHint("Plural Food");
        addEdit[15].setHint("Name");
        addEdit[16].setHint("Plural Animal");
        addEdit[17].setHint("Number");
        addEdit[18].setHint("Family Member");
        addEdit[19].setHint("Animal");
        addEdit[20].setHint("Plural Food");
        addEdit[21].setHint("Adjective");
        addEdit[22].setHint("Transportation");
        addEdit[23].setHint("Animal");
        addEdit[24].setHint("Animal");
        addEdit[25].setHint("Verb ending in ING");
        addEdit[26].setHint("Fruit");
        addEdit[27].setHint("Adjective");
        addEdit[28].setHint("Adjective");
        break;

            case 27:
                //output.setGravity(Gravity.CENTER);
                output.setText(Stories[27]);
                title = Titles[27];
                actionBar.setTitle(title);
                editTextNumber = 34;

                addEdit = new MaterialEditText[editTextNumber];
                for (int i = 0; i < addEdit.length; i++) {
                    addEdit[i] = new MaterialEditText(getActivity());
                    l_layout.addView(addEdit[i]);
                    params.setMargins(0, 20, 0, 20);
                    addEdit[i].setLayoutParams(params);
                    addEdit[i].setId(i);
                }
                addEdit[0].setHint("Piece of Clothing");
                addEdit[1].setHint("Adjective");
                addEdit[2].setHint("Adjective");
                addEdit[3].setHint("Body Part");
                addEdit[4].setHint("Liquid");
                addEdit[5].setHint("Adjective");
                addEdit[6].setHint("Animal");
                addEdit[7].setHint("Plural Body Part");
                addEdit[8].setHint("Plural Body Part");
                addEdit[9].setHint("Liquid");
                addEdit[10].setHint("Verb");
                addEdit[11].setHint("Verb ending in ING");
                addEdit[12].setHint("Body Part");
                addEdit[13].setHint("Body Part");
                addEdit[14].setHint("Body Part");
                addEdit[15].setHint("Plural Body Part");
                addEdit[16].setHint("Animal");
                addEdit[17].setHint("Verb");
                addEdit[18].setHint("Direction");
                addEdit[19].setHint("Body Part");
                addEdit[20].setHint("Plural Noun");
                addEdit[21].setHint("Plural Body Part");
                addEdit[22].setHint("Plural Noun");
                addEdit[23].setHint("Noun");
                addEdit[24].setHint("Noun");
                addEdit[25].setHint("Noun");
                addEdit[26].setHint("Animal");
                addEdit[27].setHint("Substance");
                addEdit[28].setHint("Emotion");
                addEdit[29].setHint("Liquid");
                addEdit[30].setHint("Adjective");
                addEdit[31].setHint("Adjective");
                addEdit[32].setHint("Adjective");
                addEdit[33].setHint("Adjective ending in EST");
                break;

            case 28:
                //output.setGravity(Gravity.CENTER);
                output.setText(Stories[28]);
                title = Titles[28];
                actionBar.setTitle(title);
                editTextNumber = 27;

                addEdit = new MaterialEditText[editTextNumber];
                for (int i = 0; i < addEdit.length; i++) {
                    addEdit[i] = new MaterialEditText(getActivity());
                    l_layout.addView(addEdit[i]);
                    params.setMargins(0, 20, 0, 20);
                    addEdit[i].setLayoutParams(params);
                    addEdit[i].setId(i);
                }
                addEdit[0].setHint("Noun");
                addEdit[1].setHint("Emotion");
                addEdit[2].setHint("Plural Noun");
                addEdit[3].setHint("Noun");
                addEdit[4].setHint("Verb ending in ING");
                addEdit[5].setHint("Friend");
                addEdit[6].setHint("Male Celebrity");
                addEdit[7].setHint("Female Celebrity");
                addEdit[8].setHint("Noun");
                addEdit[9].setHint("Conjunction");
                addEdit[10].setHint("Adjective");
                addEdit[11].setHint("Animal");
                addEdit[12].setHint("Plural Noun");
                addEdit[13].setHint("Adjective");
                addEdit[14].setHint("Proper Noun");
                addEdit[15].setHint("Noun");
                addEdit[16].setHint("Adjective");
                addEdit[17].setHint("Pronoun (i.e. I, me, he, she)");
                addEdit[18].setHint("Interjection");
                addEdit[19].setHint("Adjective");
                addEdit[20].setHint("Adjective");
                addEdit[21].setHint("Adjective");
                addEdit[22].setHint("Preposition (i.e. in, on, beside)");
                addEdit[23].setHint("Conjunction (i.e. for, and, nor, or)");
                addEdit[24].setHint("Noun");
                addEdit[25].setHint("Compound Verb");
                addEdit[26].setHint("Adverb");
                break;

            case 29:
                //output.setGravity(Gravity.CENTER);
                output.setText(Stories[29]);
                title = Titles[29];
                actionBar.setTitle(title);
                editTextNumber = 12;

                addEdit = new MaterialEditText[editTextNumber];
                for (int i = 0; i < addEdit.length; i++) {
                    addEdit[i] = new MaterialEditText(getActivity());
                    l_layout.addView(addEdit[i]);
                    params.setMargins(0, 20, 0, 20);
                    addEdit[i].setLayoutParams(params);
                    addEdit[i].setId(i);
                }
                addEdit[0].setHint("Adjective");
                addEdit[1].setHint("Adjective");
                addEdit[2].setHint("Location");
                addEdit[3].setHint("Noun");
                addEdit[4].setHint("Noun");
                addEdit[5].setHint("Past Tense Verb");
                addEdit[6].setHint("Adjective");
                addEdit[7].setHint("Noun");
                addEdit[8].setHint("Verb ending in ING");
                addEdit[9].setHint("Verb ending in ING");
                addEdit[10].setHint("Verb ending in ING");
                addEdit[11].setHint("Adjective");
                break;

            case 30:
                //output.setGravity(Gravity.CENTER);
                output.setText(Stories[30]);
                title = Titles[30];
                actionBar.setTitle(title);
                editTextNumber = 21;

                addEdit = new MaterialEditText[editTextNumber];
                for (int i = 0; i < addEdit.length; i++) {
                    addEdit[i] = new MaterialEditText(getActivity());
                    l_layout.addView(addEdit[i]);
                    params.setMargins(0, 20, 0, 20);
                    addEdit[i].setLayoutParams(params);
                    addEdit[i].setId(i);
                }
                addEdit[0].setHint("Noun");
                addEdit[1].setHint("Plural Noun");
                addEdit[2].setHint("Verb Past Tense");
                addEdit[3].setHint("Noun");
                addEdit[4].setHint("Adjective");
                addEdit[5].setHint("Noun");
                addEdit[6].setHint("Verb Past Tense");
                addEdit[7].setHint("Adverb  (i.e gently, quite, then, there)");
                addEdit[8].setHint("Adjective");
                addEdit[9].setHint("Adjective");
                addEdit[10].setHint("Noun");
                addEdit[11].setHint("Adverb  (i.e gently, quite, then, there)");
                addEdit[12].setHint("Noun");
                addEdit[13].setHint("Verb");
                addEdit[14].setHint("Verb Past Tense");
                addEdit[15].setHint("Noun");
                addEdit[16].setHint("Noun");
                addEdit[17].setHint("Verb ending in ING");
                addEdit[18].setHint("Verb Past Tense");
                addEdit[19].setHint("Noun");
                addEdit[20].setHint("Adjective");
                break;
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
				if (b == editTextNumber) {
					gather();
					postIt();
					outputText = output.getText().toString();
					setHasOptionsMenu(true);
					//adView.loadAd(adRequest);
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

								SharedPreferences sp;

								sp = getActivity().getSharedPreferences(
										"SavedPrefs", Context.MODE_PRIVATE);
								sp.edit().putString(savedTitle, outputText)
										.commit();

								/*
								 * SharedPreferences sp;
								 * 
								 * sp =
								 * PreferenceManager.getDefaultSharedPreferences
								 * (getActivity());
								 * sp.edit().putString(savedTitle, outputText)
								 * .commit();
								 */

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
		fontSizeInt = Integer.parseInt(fontSizeString);

		TextView outview = (TextView) view.findViewById(outviewid);

		Log.d("ADebugFontSize", "Value: " + fontSizeInt);

		outview.setTextSize(fontSizeInt);
		str = (String) outview.getText();
		stringviews = stringbuffer.toString().split("\n"); // turns the
															// stringbuffer from
															// getAllXml() into
															// an array and
															// assigns to
															// stringviews.

		for (int i = 0; i < stringviews.length; i++) {

			str2 = stringviews[i];
			str2 = "<b>" + str2 + "</b>";
			newstr = str.replaceFirst("_", str2); // replaces all the "wx"s in
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

	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.action_menu, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case R.id.share:
			Intent i = new Intent(android.content.Intent.ACTION_SEND);
			i.setType("text/plain");
			i.putExtra(android.content.Intent.EXTRA_SUBJECT,
					"Story Studio Creation");
			i.putExtra(android.content.Intent.EXTRA_TEXT, shareStoryText);
			startActivity(Intent.createChooser(i, "Share Story via"));
			break;
		}
		return false;
	}

}
