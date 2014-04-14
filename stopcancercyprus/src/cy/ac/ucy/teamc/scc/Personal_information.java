package cy.ac.ucy.teamc.scc;


import java.util.ArrayList;



import android.R.color;

import android.os.Build;

import android.os.Bundle;

import android.preference.PreferenceManager;

import android.annotation.SuppressLint;

import android.annotation.TargetApi;

import android.app.Activity;

import android.app.AlarmManager;

import android.app.PendingIntent;

import android.content.Intent;

import android.content.SharedPreferences;

import android.graphics.Color;

import android.util.Log;

import android.view.Gravity;

import android.view.Menu;

import android.view.View;

import android.widget.EditText;

import android.widget.ImageButton;

import android.widget.ImageView.ScaleType;

import android.widget.LinearLayout;

import android.widget.Toast;


public class Personal_information extends Activity {


	ArrayList<Exam> exams;

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)

	@SuppressLint("NewApi")

	@Override

	protected void onCreate(Bundle savedInstanceState) {

	

		DatabaseManager db =DatabaseManager.getHelper(getApplicationContext());

		exams=db.getAllPrevExams();

		

	ArrayList<Exam> list = new ArrayList<Exam>();

	

	

	

		

		try{

		    // Get the Bundle Object        

		    Bundle bundleObject = getIntent().getExtras();

		   

		        // Get ArrayList Bundle

		    ArrayList<Exam> classObject = (ArrayList<Exam>) bundleObject.getSerializable("EXTRA_ARRAY");

		             

		       // Retrieve Objects from Bundle

		    for(int index = 0; index < classObject.size(); index++){

		                 

		    	

		        Exam Object = classObject.get(index);

		        Toast.makeText(getApplicationContext(), "Εξέταση :"+Object.get_name(), Toast.LENGTH_SHORT).show();

		        list.add(Object);

		        

		        //create new notification

		        PendingIntent pendingIntent=PendingIntent.getService(this, 0, getIntent(), PendingIntent.FLAG_UPDATE_CURRENT);
		        
				

				

		        Bundle extras = getIntent().getExtras();

				String id = extras.getString("ID");

				//extras.putString("WEEK",time);

				

				//pendingIntent.putExtra("ID", id);

				

				

				//startService(pendingIntent);

		        

		    }

		} catch(Exception e){

		    e.printStackTrace();

		}

	

	

	Log.e("personal information", "personal information");

	

	SharedPreferences s_pref=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

	

	//the related exams of the exam

			int input_exam;

			int input_num_of_exmas=s_pref.getInt("num_of_exam",9999999);

			Log.e("antoniaaainput_num_of_exmas", ""+input_num_of_exmas);

			for(int i=0;i<input_num_of_exmas;i++)

				{

				Log.e("antonia1aaexam", "");

				

				input_exam=s_pref.getInt("exam"+i,99999);

				Exam current=exams.get(input_exam-1);

				list.add(current);

				Log.e("antonia2aaexam", ""+input_exam);

				

				

				

				

				}

	

	

		

	 // Create the text view

	    super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_personal_information);

 

        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout2);

 

        for(int i=0;i<list.size();i++)

        {

        	String name =  list.get(i).get_name();

    	    String description =  list.get(i).get_description();

    	    String img_name = list.get(i).get_image_name();

    	    int freq =   list.get(i).get_frequency();

        

        

        // add text view for the name of the exam

        EditText tv_name = new EditText(this);

        tv_name.setText(name);

        tv_name.setTextSize(20);

        tv_name.setBackgroundColor(Color.parseColor("#ddfac0"));

        tv_name.setClickable(false);

        tv_name.setKeyListener(null);

        tv_name.setCursorVisible(false);

        tv_name.setPressed(false);

        tv_name.setFocusable(false);

        tv_name.setGravity(Gravity.CENTER);

        ll.addView(tv_name);

	    

        if(freq>0)

        {String frequency =   Integer.toString(list.get(i).get_frequency());

	     // add text view for the frequency of the exam

	        EditText tv_freq = new EditText(this);

	        tv_freq.setText("Συχνότητα διεξαγωγής τις εκέτασης: κάθε "+frequency+" μήνες.");

	        tv_freq.setBackgroundColor(color.holo_green_light);

	        tv_freq.setTextSize(20);

	        tv_freq.setGravity(Gravity.CENTER);

	        tv_freq.setClickable(false);

	        tv_freq.setKeyListener(null);

	        tv_freq.setCursorVisible(false);

	        tv_freq.setPressed(false);

	        tv_freq.setFocusable(false);

	        ll.addView(tv_freq);

        }

	    

        

     // add text view for the description of the exam

        EditText tv_descr = new EditText(this);

        tv_descr.setText(description);

        tv_descr.setBackgroundColor(color.holo_green_light);

        tv_descr.setTextSize(10);

        tv_descr.setGravity(Gravity.CENTER);

        tv_descr.setClickable(false);

        tv_descr.setKeyListener(null);

        tv_descr.setCursorVisible(false);

        tv_descr.setPressed(false);

        tv_descr.setFocusable(false);

        ll.addView(tv_descr);

	    



        

        //check if for this exam there is an image

        if(!(img_name.equals("-")))

        {

        

        int checkExistence = getResources().getIdentifier(img_name, "drawable","cy.ac.ucy.teamc.scc");

        boolean result;

        

        

        

        if ( checkExistence != 0 ) {  // the resource exists

            result = true;

            final String image_id_str = String.valueOf(checkExistence);

            ImageButton Bimage = new ImageButton(this);

            Bimage.setImageResource(checkExistence);

   

            Bimage.setScaleType(ScaleType.FIT_XY);

            



            Bimage.setLayoutParams(new LinearLayout.LayoutParams(285,200));

            ll.addView(Bimage);

            

            

            

            Bimage.setOnClickListener(new View.OnClickListener() {



				@Override

				public void onClick(View arg0) {

					// TODO Auto-generated method stub

					Intent i = new Intent(getApplicationContext(),TouchImageViewActivity.class);

					

					Bundle extras = new Bundle();

					extras.putString("EXTRA_IMAGE_ID",image_id_str);

					i.putExtras(extras);

					

					

	                startActivity(i);

	  

				}

            

            });

        }

        else {  // checkExistence == 0  // the resource does NOT exist!!

            result = false;

           

        }

        }

        

        }

	}



	

	@Override

	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.personal_information, menu);

		return true;

	}

	

	

}





