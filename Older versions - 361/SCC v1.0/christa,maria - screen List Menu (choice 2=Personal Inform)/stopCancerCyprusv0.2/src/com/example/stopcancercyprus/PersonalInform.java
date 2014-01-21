package com.example.stopcancercyprus;import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PersonalInform extends Activity{
	Button checkSubmition;
	TextView displaySubmit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		createAllObjects();
				
		checkSubmition.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				displaySubmit.setText("Επιτυχής υποβολή");
				displaySubmit.setTextColor(Color.GREEN);
			}
		});
	}

	private void createAllObjects() {
		// TODO Auto-generated method stub
		checkSubmition= (Button) findViewById(R.id.Bsubmit);
		displaySubmit=(TextView) findViewById(R.id.msgSubmit);
	}

}
