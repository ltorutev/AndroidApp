package com.example.androidapplt1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private static final int MESSAGE_REQUEST = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button myButton = (Button) this.findViewById(R.id.myVurron);
		myButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
		public void onClick(View v) {
			Intent intent = new Intent(MainActivity.this, MyOttherActivity.class);
			startActivityForResult(intent, MESSAGE_REQUEST);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == MESSAGE_REQUEST){
			String msg = "";
			if(data != null && !data.getExtras().getString("com.example.androidapplt1.message").isEmpty()){
				msg = data.getExtras().getString("com.example.androidapplt1.message");
			}else{
				msg = "Lastima, no has puesto nigun mensaje";
			}
			Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
		}
	}
}
