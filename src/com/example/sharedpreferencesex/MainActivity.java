package com.example.sharedpreferencesex;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button bt;
	EditText et;
	TextView tv1, tv2;
	SharedPreferences sp;
	String data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bt = (Button) findViewById(R.id.bt);
		et = (EditText) findViewById(R.id.et);
		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		bt.setOnClickListener(this);
		sp = getSharedPreferences("name", MODE_PRIVATE);
		data = sp.getString("name", "not yet set");
		tv2.setText(data);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		data = et.getText().toString();
		tv2.setText(data);
		SharedPreferences.Editor speditor = sp.edit();
		speditor.putString("name", data);
		speditor.commit();
	}

}
