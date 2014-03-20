package com.example.stopcancercyprus;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import java.util.ArrayList;
import android.widget.TextView;

public class CancerActivity extends Activity{

		ImageButton BimageBreast;
			
				
				public static  final String[] ctitle = {"Breast", "Kidney", "Rectum", "Ovarian", "Pancreas", "Prostate", "Skin"};
				String[] cinfo = {"Breast", "Kidney", "Rectum", "Ovarian", "Pancreas", "Prostate", "Skin"};
				ArrayList<ImageButton> cimage = new ArrayList<ImageButton>();
				
				
				protected void onCreate(Bundle savedInstanceState, String cancername) {
					// TODO Auto-generated method stub
			
			
			
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			
			
			Bundle bundle = getIntent().getExtras();
			int i;
			for(i=0; i<ctitle.length; i++){
				if(bundle.getString(ctitle[i])!= null)
					break;
			}
			
			//if(bundle.getString(ctitle[0])!= null){
				
				//Set to the label cancer title the name of the cancer
				 EditText mTextView1 = (EditText) findViewById(R.id.KarkinosMastou); 
				mTextView1.setText(ctitle[i]);
				
				//Retreive Image
				//ImageButton btn_stop = new ImageButton(getBaseContext());
				
				//Set Image
				//ImageButton ibtn = (ImageButton)findViewById(R.id.BimageBreast);
				//ibtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.prostatis, 0, 0, 0);


				
				//Retreive Data in Info
				final String Info = new String("..............................................................");
			
				//Set to the label cancer info the information about the cancer
				EditText mTextView2 = (EditText) findViewById(R.id.KarkinosMastosView); 
				mTextView2.setText(cinfo[i]);

			//ArrayList<String> stringList = new ArrayList<String>();
		
				
			//}
			
			setContentView(R.layout.activity_cancer);
			
			createAllObjects();

			BimageBreast.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i = new Intent(getApplicationContext(),TouchImageViewActivity.class);
	                startActivity(i);
	                BimageBreast.clearAnimation();
				}
			});
			
		}
		private void createAllObjects() {
			// TODO Auto-generated method stub
			BimageBreast = (ImageButton) findViewById(R.id.BimageBreast);
		}
	}





