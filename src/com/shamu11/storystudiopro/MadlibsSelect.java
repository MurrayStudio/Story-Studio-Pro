package com.shamu11.storystudiopro;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MadlibsSelect extends Fragment {

	Button[] button;
	android.support.v7.app.ActionBar actionBar;
	String[] title;
	int titleNumber;
	RelativeLayout layout;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment

		View view = inflater.inflate(R.layout.madlibselect, container, false);

		layout = (RelativeLayout) view.findViewById(R.id.SelectLayout);

		actionBar = (android.support.v7.app.ActionBar) ((MainActivity) getActivity())
				.getSupportActionBar();

        actionBar.setTitle("Story Studio Pro");

		title = getResources().getStringArray(R.array.MadlibsTitles);

		button = new Button[40];

		button[0] = (Button) view.findViewById(R.id.School_Sickness);
		button[0].setText(title[0]);
		button[0].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 0;
				actionBar.setTitle(title[0]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[1] = (Button) view.findViewById(R.id.Intruders);
		button[1].setText(title[1]);
		button[1].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 1;
				actionBar.setTitle(title[1]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[2] = (Button) view.findViewById(R.id.Let_it_go);
		button[2].setText(title[2]);
		button[2].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 2;
				actionBar.setTitle(title[2]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[3] = (Button) view
				.findViewById(R.id.Beauty_and_the_Beast);
		button[3].setText(title[3]);
		button[3].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 3;
				actionBar.setTitle(title[3]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[4] = (Button) view.findViewById(R.id.Doras_Surprise);
		button[4].setText(title[4]);
		button[4].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 4;
				actionBar.setTitle(title[4]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[5] = (Button) view
				.findViewById(R.id.A_Letter_to_the_Bride);
		button[5].setText(title[5]);
		button[5].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 5;
				actionBar.setTitle(title[5]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[6] = (Button) view
				.findViewById(R.id.What_Happened_Last_Night);
		button[6].setText(title[6]);
		button[6].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 6;
				actionBar.setTitle(title[6]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[7] = (Button) view
				.findViewById(R.id.Letter_Home_From_Camp);
		button[7].setText(title[7]);
		button[7].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 7;
				actionBar.setTitle(title[7]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[8] = (Button) view
				.findViewById(R.id.Harry_Potter_Story);
		button[8].setText(title[8]);
		button[8].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 8;
				actionBar.setTitle(title[8]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[9] = (Button) view.findViewById(R.id.Magic_Mushrooms);
		button[9].setText(title[9]);
		button[9].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 9;
				actionBar.setTitle(title[9]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[10] = (Button) view.findViewById(R.id.Oxi_Clean);
		button[10].setText(title[10]);
		button[10].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 10;
				actionBar.setTitle(title[10]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[11] = (Button) view.findViewById(R.id.Job_Interview);
		button[11].setText(title[11]);
		button[11].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 11;
				actionBar.setTitle(title[11]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[12] = (Button) view.findViewById(R.id.OneD);
		button[12].setText(title[12]);
		button[12].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 12;
				actionBar.setTitle(title[12]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[13] = (Button) view.findViewById(R.id.Twilight);
		button[13].setText(title[13]);
		button[13].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 13;
				actionBar.setTitle(title[13]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

		button[14] = (Button) view.findViewById(R.id.Crazy_Encounter);
		button[14].setText(title[14]);
		button[14].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 14;
				actionBar.setTitle(title[14]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[15] = (Button) view.findViewById(R.id.Rockstar);
		button[15].setText(title[15]);
		button[15].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 15;
				actionBar.setTitle(title[15]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[16] = (Button) view.findViewById(R.id.Making_A_Sandwich);
		button[16].setText(title[16]);
		button[16].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 16;
				actionBar.setTitle(title[16]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[17] = (Button) view.findViewById(R.id.New_Creature);
		button[17].setText(title[17]);
		button[17].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 17;
				actionBar.setTitle(title[17]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[18] = (Button) view.findViewById(R.id.Itsy_Spider);
		button[18].setText(title[18]);
		button[18].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 18;
				actionBar.setTitle(title[18]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[19] = (Button) view.findViewById(R.id.Knights_of_Ni);
		button[19].setText(title[19]);
		button[19].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 19;
				actionBar.setTitle(title[19]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[20] = (Button) view.findViewById(R.id.Set_Fire);
		button[20].setText(title[20]);
		button[20].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 20;
				actionBar.setTitle(title[20]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[21] = (Button) view.findViewById(R.id.Farmyard_Storm);
		button[21].setText(title[21]);
		button[21].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 21;
				actionBar.setTitle(title[21]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[22] = (Button) view.findViewById(R.id.The_Dark);
		button[22].setText(title[22]);
		button[22].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 22;
				actionBar.setTitle(title[22]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[23] = (Button) view.findViewById(R.id.Uprising);
		button[23].setText(title[23]);
		button[23].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 23;
				actionBar.setTitle(title[23]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[24] = (Button) view.findViewById(R.id.A_Road_Trip);
		button[24].setText(title[24]);
		button[24].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 24;
				actionBar.setTitle(title[24]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});
		
		button[25] = (Button) view.findViewById(R.id.Survey);
		button[25].setText(title[25]);
		button[25].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				titleNumber = 25;
				actionBar.setTitle(title[25]);

				((MainActivity) getActivity()).setStory(titleNumber);

				Fragment newFragment = new Madlibs();
				FragmentTransaction transaction = getFragmentManager()
						.beginTransaction();

				transaction.replace(R.id.fragment_container, newFragment);
				transaction.addToBackStack(null);

				transaction.commit();

			}
		});

        button[26] = (Button) view.findViewById(R.id.Life_on_the_Farm);
        button[26].setText(title[26]);
        button[26].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                titleNumber = 26;
                actionBar.setTitle(title[26]);

                ((MainActivity) getActivity()).setStory(titleNumber);

                Fragment newFragment = new Madlibs();
                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();

            }
        });

        button[27] = (Button) view.findViewById(R.id.Swimming_Lessons);
        button[27].setText(title[27]);
        button[27].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                titleNumber = 27;
                actionBar.setTitle(title[27]);

                ((MainActivity) getActivity()).setStory(titleNumber);

                Fragment newFragment = new Madlibs();
                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();

            }
        });

        button[28] = (Button) view.findViewById(R.id.Attacked_by_Aliens);
        button[28].setText(title[28]);
        button[28].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                titleNumber = 28;
                actionBar.setTitle(title[28]);

                ((MainActivity) getActivity()).setStory(titleNumber);

                Fragment newFragment = new Madlibs();
                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();

            }
        });

        button[29] = (Button) view.findViewById(R.id.Day_at_Beach);
        button[29].setText(title[29]);
        button[29].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                titleNumber = 29;
                actionBar.setTitle(title[29]);

                ((MainActivity) getActivity()).setStory(titleNumber);

                Fragment newFragment = new Madlibs();
                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();

            }
        });

        button[30] = (Button) view.findViewById(R.id.Pirates);
        button[30].setText(title[30]);
        button[30].setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                titleNumber = 30;
                actionBar.setTitle(title[30]);

                ((MainActivity) getActivity()).setStory(titleNumber);

                Fragment newFragment = new Madlibs();
                FragmentTransaction transaction = getFragmentManager()
                        .beginTransaction();

                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);

                transaction.commit();

            }
        });

		return view;

	}

}
