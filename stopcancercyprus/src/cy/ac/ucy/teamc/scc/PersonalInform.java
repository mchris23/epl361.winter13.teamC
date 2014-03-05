package com.example.stopcancercyprus;
//write test egit
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PersonalInform extends Activity {
	Button checkSubmition;
	TextView displaySubmit;
	EditText Tweight;
	EditText Theight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal);

		createAllObjects();

		checkSubmition.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (Tweight.getText().toString().equalsIgnoreCase(""))
				{
					displaySubmit.setText("Δέν έχει γίνει εισαγωγή του βάρους");
					displaySubmit.setTextColor(Color.RED);
				} else if (Float.parseFloat(Tweight.getText().toString()) > (float) 350.00
							|| Float.parseFloat(Tweight.getText().toString()) < (float) 20) 
					{
					displaySubmit.setText("Λανθεσμένη είσοδο βάρους:\nΠρέπει να είναι στο διάστημα [20-350]");
					displaySubmit.setTextColor(Color.RED);
					} else if (Theight.getText().toString().equalsIgnoreCase(""))
						{
						displaySubmit.setText("Δέν έχει γίνει εισαγωγή του ύψους");
						displaySubmit.setTextColor(Color.RED);
						} else if (Float.parseFloat(Theight.getText().toString()) > (float) 250.00
								|| Float.parseFloat(Theight.getText().toString()) < (float) 40)
							{
							displaySubmit.setText("Λανθεσμένη είσοδο ύψους:\nΠρέπει να είναι στο διάστημα [40-250]");
							displaySubmit.setTextColor(Color.RED);
							}
			}
		});
	}

	private void createAllObjects() {
		// TODO Auto-generated method stub
		checkSubmition = (Button) findViewById(R.id.Bsubmit);
		displaySubmit = (TextView) findViewById(R.id.msgSubmit);
		Tweight = (EditText) findViewById(R.id.CommandWeight);
		Theight=(EditText) findViewById(R.id.CommandHeigh);
	}

}
