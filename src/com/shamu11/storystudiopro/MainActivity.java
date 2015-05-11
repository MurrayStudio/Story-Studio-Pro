package com.shamu11.storystudiopro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.shamu11.storystudiopro.MadlibsTracker.TrackerName;

public class MainActivity extends ActionBarActivity implements
		OnItemClickListener {

	protected DrawerLayout drawerLayout;
	private ListView listView;
	private ActionBarDrawerToggle drawerListener;
	private MyAdapter myAdapter;
	private String[] Madlibs;
	private int storyNumber;
	private int length = 0;
	private int numEditText = 0;
	private String storyTitle = null;
	private Boolean trueFalse;
	private int createValue = 0;
	private int font;
	CheckBox prefCheckBox;
	TextView prefList;
	Fragment fragment;
	FrameLayout frameLayout;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		Fragment fragment;

		fragment = new MadlibsSelect();

		FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
		fragment.setArguments(getIntent().getExtras());
		fm.add(R.id.fragment_container, fragment);
		fm.commit();
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
		
		//ActionBar bar = getActionBar();
		//bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#428bca")));

		SharedPreferences settings = PreferenceManager
				.getDefaultSharedPreferences(getBaseContext());
		String val1 = settings.getString("list0", "Blue");

		if (val1.equals("Blue")) {
			toolbar.setBackgroundDrawable(new ColorDrawable(Color
					.parseColor("#428bca")));
		} else if (val1.equals("LGrey")) {
			toolbar.setBackgroundDrawable(new ColorDrawable(Color
					.parseColor("#adadad")));
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getWindow().setStatusBarColor(Color
					.parseColor("#919191"));
			}
		} else if (val1.equals("DGrey")) {
			toolbar.setBackgroundDrawable(new ColorDrawable(Color
					.parseColor("#212121")));
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getWindow().setStatusBarColor(Color
					.parseColor("#0e0e0e"));
			}
		} else if (val1.equals("Red")) {
			toolbar.setBackgroundDrawable(new ColorDrawable(Color
					.parseColor("#d01716")));
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			getWindow().setStatusBarColor(Color
					.parseColor("#b11413"));
			}
		}


		// Get tracker.
		Tracker t = ((MadlibsTracker) getApplication())
				.getTracker(TrackerName.APP_TRACKER);

		// Set screen name.
		// Where path is a String representing the screen name.
		t.setScreenName("Story Studio Pro");

		// Send a screen view.
		t.send(new HitBuilders.AppViewBuilder().build());
		
		

		Madlibs = getResources().getStringArray(R.array.Madlibs);

		frameLayout = (FrameLayout) findViewById(R.id.fragment_container);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		listView = (ListView) findViewById(R.id.drawerList);
		myAdapter = new MyAdapter(this);
		listView.setAdapter(myAdapter);
		listView.setOnItemClickListener(this);

		if (drawerLayout != null) {
			drawerListener = new ActionBarDrawerToggle(this, drawerLayout,
					R.drawable.ic_drawer, R.string.open) {
				@Override
				public void onDrawerOpened(View drawerView) {
					// TODO Auto-generated method stub
					super.onDrawerOpened(drawerView);
				}

				@Override
				public void onDrawerClosed(View drawerView) {
					// TODO Auto-generated method stub
					super.onDrawerClosed(drawerView);
				}

				@Override
				public void onDrawerSlide(View drawerView, float slideOffset) {
					super.onDrawerSlide(drawerView, slideOffset);
					frameLayout.setTranslationX(slideOffset
							* drawerView.getWidth());
					drawerLayout.bringChildToFront(drawerView);
					drawerLayout.requestLayout();
				}
			};
			drawerLayout.setDrawerListener(drawerListener);
			getSupportActionBar().setHomeButtonEnabled(true);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (drawerListener.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		if (drawerLayout != null) {
		drawerListener.onConfigurationChanged(newConfig);
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		if (drawerLayout != null) {
		drawerListener.syncState();
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		selectItem(position);

		setNavDrawerItemNormal();
		TextView txtview = ((TextView) view.findViewById(R.id.rowText));
		txtview.setTypeface(null, Typeface.BOLD);
	}

	public void setNavDrawerItemNormal() {
		for (int i = 0; i < listView.getChildCount(); i++) {
			View v = listView.getChildAt(i);
			TextView txtview = ((TextView) v.findViewById(R.id.rowText));
			txtview.setTypeface(null, Typeface.NORMAL);
		}
	}

	private void selectItem(int position) {
		listView.setItemChecked(position, true);
		setTitle(Madlibs[position]);
		// drawerLayout.closeDrawers();

		fragment = new MadlibsSelect();
		// FragmentManager fm = getSupportFragmentManager();

		switch (position) {
		case 0:
			fragment = new MadlibsSelect();
			break;
		case 1:
			fragment = new MadlibsCreate();
			break;
		case 2:
			fragment = new MadlibsSaved();
			break;
		case 3:
			android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
			android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction();
			Fragment fragmentS = new MadlibsSettings();
			fragmentTransaction.replace(R.id.fragment_container, fragmentS);
			fragmentTransaction.addToBackStack(null);
			fragmentTransaction.commit();

			/*
			 * Intent myIntent = new Intent(MainActivity.this,
			 * MadlibsPrefs.class); MainActivity.this.startActivity(myIntent);
			 */
			
			if (drawerLayout != null) {
			drawerLayout.closeDrawers();
			}
			break;
		case 4:
			fragment = new MadlibsAbout();
			break;
		}

		if ((position == 1 || position == 2)) {
			new Handler().postDelayed(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					if (drawerLayout != null) {
					drawerLayout.closeDrawers(); // delay nav drawer when
													// loading large fragment
					}

				}
			}, 5);
			FragmentTransaction fm = getSupportFragmentManager()
					.beginTransaction();
			fm.replace(R.id.fragment_container, fragment);
			fm.addToBackStack(null);
			fm.commit();
		}

		if ((position == 0 || position == 4)) {

			FragmentTransaction fm = getSupportFragmentManager()
					.beginTransaction();			
			fm.replace(R.id.fragment_container, fragment);
			fm.addToBackStack(null);
			fm.commit();

			if (drawerLayout != null) {
			drawerLayout.closeDrawers();
			}
		}

	}

	public void setTitle(String title) {
		// getSupportActionBar().setTitle(title);
	}

	public void setStory(int titleNumber) {
		storyNumber = titleNumber;
	}

	public int getStory() {
		return storyNumber;
	}

	public void setFieldLength(int Length) {
		length = Length;
	}

	public int getFieldLength() {
		return length;
	}

	public void setNumEditText(int y) {
		numEditText = y;
	}

	public int getNumEditText() {
		return numEditText;
	}

	public void setStoryTitle(String story) {
		storyTitle = story;
	}

	public String getStoryTitle() {
		return storyTitle;
	}

	public void setFont(int size) {
		font = size;
	}

	public int getFont() {
		return font;
	}

	public void setThemeSwitch(boolean bool) {
		trueFalse = bool;
	}

	public boolean setThemeSwitch() {
		return trueFalse;
	}

	public void setCreateValue(int value) {
		createValue = value;
	}

	public int getCreateValue() {
		return createValue;
	}

	@Override
	protected void onStart() {
		super.onStart();
		// Get an Analytics tracker to report app starts & uncaught exceptions
		// etc.
		GoogleAnalytics.getInstance(this).reportActivityStart(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		// Stop the analytics tracking
		GoogleAnalytics.getInstance(this).reportActivityStop(this);
	}

	@Override
	public void onBackPressed() {

		android.support.v4.app.Fragment fragment = getSupportFragmentManager()
				.findFragmentById(R.id.fragment_container);
		int count = getFragmentManager().getBackStackEntryCount();

		if (fragment instanceof MadlibsSettings) {
			super.onBackPressed();
			Intent i = getBaseContext().getPackageManager()
					.getLaunchIntentForPackage(
							getBaseContext().getPackageName());
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
		} else {
			getSupportFragmentManager().popBackStack();
		}

	}
}

class MyAdapter extends BaseAdapter {
	private Context context;
	String[] Madlibs;
	int[] images = { R.drawable.note, R.drawable.pen, R.drawable.stack,
			R.drawable.settings, R.drawable.user };

	public MyAdapter(Context context) {
		this.context = context;
		Madlibs = context.getResources().getStringArray(R.array.Madlibs);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Madlibs.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return Madlibs[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = null;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.custom_row, parent, false);
		} else {
			row = convertView;
		}
		TextView titleTextView = (TextView) row.findViewById(R.id.rowText);
		ImageView titleImageView = (ImageView) row
				.findViewById(R.id.imageView1);
		
		//titleTextView.setTypeface(null, Typeface.BOLD);
		 
		titleTextView.setText(Madlibs[position]);
		titleImageView.setImageResource(images[position]);

		return row;
	}

}
