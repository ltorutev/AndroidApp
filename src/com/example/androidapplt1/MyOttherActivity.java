package com.example.androidapplt1;

import java.io.File;
import java.net.URI;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyOttherActivity extends Activity {
	private Button myDoneButton;
	private EditText myEdTextForDoneButton;
	private Button myViewButton;
	private Button myMapButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.my_form);
		this.myDoneButton = (Button) this.findViewById(R.id.doneButton);
		this.myViewButton = (Button) this.findViewById(R.id.buttonExternalView);
		this.myMapButton = (Button) this.findViewById(R.id.viewMapButton);
		this.myEdTextForDoneButton = (EditText) this.findViewById(R.id.myEditTextForDoneButton);
		// First button
		this.myDoneButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent data = new Intent();
				data.putExtra("com.example.androidapplt1.message", myEdTextForDoneButton.getText().toString());
				setResult(Activity.RESULT_OK, data);
				finish();
			}
		});
		// Second button
		this.myViewButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent picture = new Intent();
				picture.setAction(android.content.Intent.ACTION_VIEW);
				String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
				File file = new File(path+ "/Camera/IMG_20160521_202349.jpg");
				picture.setDataAndType(Uri.fromFile(file), "image/*");
				startActivity(picture);
			}
		});
		// Tercer button
		this.myMapButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {	
				String geoURIString = "geo:0,0?q=1600+Pennsylvania+Avenue+NW+Washington,+DC+20500";
				Uri geoURI = Uri.parse(geoURIString);
				Intent map = new Intent(android.content.Intent.ACTION_VIEW, geoURI);
				startActivity(map);
			}
		});
	}
}
