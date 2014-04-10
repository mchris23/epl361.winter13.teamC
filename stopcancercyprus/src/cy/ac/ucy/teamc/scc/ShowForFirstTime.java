package cy.ac.ucy.teamc.scc;

import java.util.ArrayList;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;

public class ShowForFirstTime extends Activity {
	ArrayList<Exam> exams;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		DatabaseManager db =DatabaseManager.getHelper(getApplicationContext());
		exams=db.getAllExams();
		
	super.onCreate(savedInstanceState);
	//	setContentView(R.layout.activity_show_not_for_first_time_related_exams);
		
		SharedPreferences s_pref=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		
		//the related exams of the 
		ArrayList<Exam> selected_exams= new ArrayList<Exam>();
				int input_exam;
				int input_num_of_exmas=s_pref.getInt("num_of_exam",9999999);
				Log.e("antoniaaainput_num_of_exmas", ""+input_num_of_exmas);
				for(int i=0;i<input_num_of_exmas;i++)
					{
					input_exam=s_pref.getInt("exam"+i,99999);
					Exam current=exams.get(input_exam-1);
					selected_exams.add(current);
					Log.e("antoniaaaexam", ""+input_exam);
					
					
					
					
					}
				
				
				
				if(selected_exams!=null)
				{
					
					try{
						
						Intent passIntent = new Intent();
						passIntent.setClass(ShowForFirstTime.this, Personal_information.class);
						
						// Create a Bundle and Put Bundle in to it
						Bundle bundleObject = new Bundle();
						bundleObject.putSerializable("EXTRA_ARRAY", selected_exams);
						                 
						// Put Bundle in to Intent and call start Activity
						passIntent.putExtras(bundleObject);
						startActivity(passIntent);
						
		
			
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

}
