package com.shamu11.storystudiopro;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;

import com.rengwuxian.materialedittext.MaterialEditText;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MadlibsCreateText extends Fragment {

	View view;
    MaterialEditText story;
	Button generate;
	ImageButton newField;
	Spanned storyText;
	String moreText;
	Editable Text;
	String[] field = new String[200];
	Spanned spanned = null;
	String storyTitle = "no_title";
	int start, end;
	int y = 0;
	int[] length = new int[200];
	String storyTextTrimmed;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.madlibs_create_text, container, false);

		story = (MaterialEditText) view.findViewById(R.id.story);

		newField = (ImageButton) view.findViewById(R.id.createField);
		newField.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				start = Math.max(story.getSelectionStart(), 0);
				end = Math.max(story.getSelectionEnd(), 0);

				storyText = new SpannableString(story.getText());

				AlertDialog.Builder builder = new AlertDialog.Builder(
						getActivity());
				builder.setTitle("Add Story Field");

				// Set up the input
				final EditText input = new EditText(getActivity());
				input.setHint("Ex: Noun, Verb, Color, etc");
				// Specify the type of input expected; this, for example, sets
				// the input as a password, and will mask the text
				builder.setView(input);

				// Set up the buttons
				builder.setPositiveButton("Add Field",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								field[y] = input.getText().toString();
								field[y] = field[y].trim();

								moreText = "<b>" + field[y] + "</b>";

								Log.d("ADebugTagMoreText", "Value: " + moreText);

								Text = story.getText();
								Text = Text.replace(start, end,
										Html.fromHtml(moreText));

								Log.d("ADebugTagText", "Value: " + Text);

								storyText = Text;
								story.setText(storyText);

								Toast.makeText(
										getActivity().getApplicationContext(),
										"Field Added", Toast.LENGTH_SHORT)
										.show();
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

				y++;

			}
		});

		generate = (Button) view.findViewById(R.id.generate);
		generate.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				//if (((MainActivity) getActivity()).getCreateValue() < 2) { //remove if statement for pro version

					AlertDialog.Builder builder2 = new AlertDialog.Builder(
							getActivity());
					builder2.setTitle("Title of Story");

					// Set up the input
					final EditText input2 = new EditText(getActivity());
					// Specify the type of input expected; this, for example,
					// sets
					// the input as a password, and will mask the text
					builder2.setView(input2);

					// Set up the buttons
					builder2.setPositiveButton("Create Story",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									
									((MainActivity) getActivity()).setCreateValue(1); //user has used up there 1 create madlib

									String[] savedArrayCheck = new String[50];
									for (int c = 0; c < savedArrayCheck.length; c++) {
										savedArrayCheck[c] = "x";
									}

									int startPos = 0;
									int endPos = 0;

									storyTitle = input2.getText().toString();
									storyTitle = storyTitle.trim();

									String stringText = Html.toHtml(story
											.getText());

									Log.d("ADebugstringTextBefore", "Value: "
											+ stringText);

									List<String> check = getTagValues(stringText);// gets
									// bolded
									// fields
									// to check for extra bold tags

									String[] arrayCheck = check
											.toArray(new String[check.size()]);

									for (int z = 0; z < arrayCheck.length; z++) {
										int i = 0;
										Log.d("ADebugstringarrayCheckValues",
												"Value: " + arrayCheck[z]);
										if (arrayCheck[z].endsWith(" ")
												&& (!arrayCheck[z].equals(null))) {
											savedArrayCheck[i] = arrayCheck[z];
											i++;
										}
									}

									for (int it = 0; it < savedArrayCheck.length; it++) {

										Log.d("ADebugSavedArrayCheck[it]",
												"Value: " + savedArrayCheck[it]);

										if (!(savedArrayCheck[it].equals("x"))) {
											startPos = stringText
													.indexOf(savedArrayCheck[it]);
											startPos = (startPos
													+ savedArrayCheck[it]
															.length() - 1);
											endPos = (startPos + 8);

											Log.d("ADebugStart", "Value: "
													+ startPos);
											Log.d("ADebugEnd", "Value: "
													+ endPos);

											stringText = stringText.replace(
													stringText.substring(
															startPos, endPos),
													" ");
										}
									}

									Log.d("ADebugstringText", "Value: "
											+ stringText);

									story.setText(Html.fromHtml(stringText));

									List<String> fields = getTagValues(stringText);// gets
																					// bolded
																					// fields

									String[] array = fields
											.toArray(new String[fields.size()]);

									for (int z = 0; z < array.length; z++) {
										Log.d("ADebugTagFields", "Value: "
												+ array[z]);
									}

									Log.d("ADebugTag",
											"Value: "
													+ Html.toHtml(story
															.getText()));

									try {

										FileOutputStream fOut = getActivity()
												.openFileOutput(
														storyTitle
																+ "_fields.txt",
														Context.MODE_PRIVATE);
										ObjectOutputStream osw = new ObjectOutputStream(
												fOut);
										osw.writeObject(array);
										osw.flush();
										osw.close();
									} catch (IOException ioe) {
									}

									// replace all bolded text with "_"'s
									Spanned getStoryText = new SpannableString(
											story.getText());
									storyTextTrimmed = Html
											.toHtml(getStoryText);
									storyTextTrimmed = storyTextTrimmed
											.replaceAll("\\<b>.*?\\</b>", "_");
									Log.d("ADebugTagStory",
											"Value: "
													+ Html.toHtml(getStoryText));

									String[] temp = new String[1];
									temp[0] = storyTextTrimmed;

									try {

										FileOutputStream fOut = getActivity()
												.openFileOutput(
														storyTitle
																+ "_story.txt",
														Context.MODE_PRIVATE);
										ObjectOutputStream osw = new ObjectOutputStream(
												fOut);
										osw.writeObject(temp);
										osw.flush();
										osw.close();
									} catch (IOException ioe) {
									}

									int[] numTemp = new int[1];
									numTemp[0] = fields.size();

									try {

										FileOutputStream fOut = getActivity()
												.openFileOutput(
														storyTitle
																+ "_numEditText.txt",
														Context.MODE_PRIVATE);
										ObjectOutputStream osw = new ObjectOutputStream(
												fOut);
										osw.writeObject(numTemp);
										osw.flush();
										osw.close();
									} catch (IOException ioe) {
									}

									SharedPreferences sp;

									sp = getActivity()
											.getSharedPreferences(
													"CreatePrefs",
													Context.MODE_PRIVATE);
									sp.edit()
											.putString(storyTitle,
													storyTitle + "_fields.txt")
											.commit();

									((MainActivity) getActivity())
											.setStoryTitle(storyTitle);

									((MainActivity) getActivity())
											.setNumEditText(fields.size());

									Toast.makeText(
											getActivity()
													.getApplicationContext(),
											"Story Saved; you may now fill out your Story",
											Toast.LENGTH_SHORT).show();

									Fragment newFragment = new MadlibsLoadCreatedStory();
									FragmentTransaction transaction = getFragmentManager()
											.beginTransaction();

									transaction.replace(
											R.id.fragment_container,
											newFragment);
									transaction.addToBackStack(null);

									transaction.commit();

								}
							});
					builder2.setNegativeButton("Cancel",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
								}
							});

					builder2.show();

				/*} else {
					Fragment newFragment = new MadlibsPay();
					FragmentTransaction transaction = getFragmentManager()
							.beginTransaction();

					transaction.replace(R.id.fragment_container, newFragment);
					transaction.addToBackStack(null);

					transaction.commit();
				}*/
			}
		});

		return view;
	}

	private static final Pattern TAG_REGEX = Pattern.compile("<b>(.+?)</b>");

	public static String html2text(String html) {
		return Jsoup.parse(html).text();
	}

	private static List<String> getTagValues(final String str) {
		final List<String> tagValues = new ArrayList<String>();
		final Matcher matcher = TAG_REGEX.matcher(str);
		while (matcher.find()) {
			tagValues.add(matcher.group(1));
			Log.d("ADebugTagValues", "Value: " + tagValues);
		}
		return tagValues;
	}
}
