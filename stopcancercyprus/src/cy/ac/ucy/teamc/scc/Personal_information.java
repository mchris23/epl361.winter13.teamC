package cy.ac.ucy.teamc.scc;


import android.R.color;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;


public class Personal_information extends Activity {
	public final static String EXTRA_IMAGE_ID = "com.example.stopcancercyprus.MESSAGE";

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		
		//get the name and the description of the exam 
		String name = extras.getString("EXTRA_NAME");
	    String description = extras.getString("EXTRA_DESCRIPTION");
	    String img_name = extras.getString("EXTRA_IMAGE_NAME");
	    String frequency = extras.getString("EXTRA_FREQUENCY");
	 // Create the text view
	    
	    
	    
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);
 
        LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout2);
 
        // add text view for the name of the exam
        EditText tv_name = new EditText(this);
        tv_name.setText(name);
        tv_name.setTextSize(40);
        tv_name.setBackgroundColor(Color.parseColor("#ddfac0"));
        tv_name.setClickable(false);
        tv_name.setKeyListener(null);
        tv_name.setCursorVisible(false);
        tv_name.setPressed(false);
        tv_name.setFocusable(false);
        tv_name.setGravity(Gravity.CENTER);
        ll.addView(tv_name);
	    
     // add text view for the frequency of the exam
        EditText tv_freq = new EditText(this);
        tv_freq.setText(frequency);
        tv_freq.setBackgroundColor(color.holo_green_light);
        tv_freq.setTextSize(20);
        tv_freq.setGravity(Gravity.CENTER);
        tv_freq.setClickable(false);
        tv_freq.setKeyListener(null);
        tv_freq.setCursorVisible(false);
        tv_freq.setPressed(false);
        tv_freq.setFocusable(false);
        ll.addView(tv_freq);
	    
        
     // add text view for the description of the exam
        EditText tv_descr = new EditText(this);
        tv_descr.setText(description);
        tv_descr.setBackgroundColor(color.holo_green_light);
        tv_descr.setTextSize(20);
        tv_descr.setGravity(Gravity.CENTER);
        tv_descr.setClickable(false);
        tv_descr.setKeyListener(null);
        tv_descr.setCursorVisible(false);
        tv_descr.setPressed(false);
        tv_descr.setFocusable(false);
        ll.addView(tv_descr);
	    

        
        //check if for this exam there is an image
        
        int checkExistence = getResources().getIdentifier(img_name, "drawable","com.example.stopcancercyprus");
        boolean result;
        
        
        
        if ( checkExistence != 0 ) {  // the resource exists...
            result = true;
            final String image_id_str = String.valueOf(checkExistence);
            ImageButton Bimage = new ImageButton(this);
            Bimage.setImageResource(checkExistence);
   
            Bimage.setScaleType(ScaleType.FIT_XY);
            
            
            ll.addView(Bimage);
            
            Log.w("HEREEE 1"," "+result);
            
            
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
        else {  // checkExistence == 0  // the resouce does NOT exist!!
            result = false;
            Log.w("HEREE 2"," "+result);
        }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.personal_information, menu);
		return true;
	}
	
	
	

}
