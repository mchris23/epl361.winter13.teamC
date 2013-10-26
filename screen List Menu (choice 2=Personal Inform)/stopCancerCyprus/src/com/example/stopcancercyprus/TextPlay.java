package com.example.stopcancercyprus;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class TextPlay extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		Button checkCommend= (Button) findViewById(R.id.Bsubmit);
		TextView displaySubmit=(TextView) findViewById(R.id.Bsubmit);
		
	}

}
