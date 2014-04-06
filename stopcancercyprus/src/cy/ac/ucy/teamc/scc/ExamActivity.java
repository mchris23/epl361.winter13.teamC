package cy.ac.ucy.teamc.scc;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

public class ExamActivity extends Activity {
	public final static String EXTRA_IMAGE_ID = "cy.ac.ucy.teamc.scc.MESSAGE";
	TextView name;
	TextView description;
	ListView relatedExams;
	ArrayList<Exam> cNameDescr;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b = getIntent().getExtras();
		int id = b.getInt("position");
		Log.e("position", ""+id);
		id++;
		DatabaseManager db = DatabaseManager.getHelper(getApplicationContext());
		
		cNameDescr = db.getExam(id);
		
		Log.e("IAM hereeeeeeeee","");
		
		setContentView(R.layout.cancer_view);
		LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout2);
		createAllObjects();
		 Log.e("oups0",""+id);
		name.setText(cNameDescr.get(0).get_name());
		description.setText(cNameDescr.get(0).get_description());
		// Add contents accordingly,get from database
		// setContentView(R.layout.cancer_mastos);
		Log.e("oups",""+id);
		 String img_name = cNameDescr.get(0).get_image_name();
		 Log.e("oups1",""+id);
//check if for this exam there is an image
		 if(!img_name.equals("-")){
			 Log.e("oups2",""+id);
        int checkExistence = getResources().getIdentifier(img_name, "drawable","cy.ac.ucy.teamc.scc");
        boolean result;
        Log.e("IAM hereeeeeeeee 2","");
        
        
        if ( checkExistence != 0 ) {  // the resource exists...
        	Log.e("IAM hereeeeeeeee 3","");
        	result = true;
            final String image_id_str = String.valueOf(checkExistence);
            ImageButton Bimage = new ImageButton(this);
            Bimage.setImageResource(checkExistence);
   
            Bimage.setScaleType(ScaleType.FIT_XY);
            
            
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
        else {  // checkExistence == 0  // the resouce does NOT exist!!
            result = false;
            Log.w("HEREE 2"," "+result);
        }
		
		 }
		 else 
	            Log.w("oupsssssssssss"," "+id);
	}

	private void createAllObjects() {
		// TODO Auto-generated method stub
		
		name = (TextView) findViewById(R.id.CancerName);
		description = (TextView) findViewById(R.id.CancerDescription);
		 Log.e("createAllObjects","");

	}
}

