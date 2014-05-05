package cy.ac.ucy.teamc.scc;

import java.util.ArrayList;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class Notify extends Activity{
	
	ArrayList<Exam> list = new ArrayList<Exam>();
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		for(int i=0;i<list.size();i++)
        {
    	    
    	    //create new notification

	        PendingIntent pendingIntent=PendingIntent.getService(this, 0, getIntent(), PendingIntent.FLAG_UPDATE_CURRENT);
			

	        Bundle extras = getIntent().getExtras();

			String id = extras.getString("ID");

			//extras.putString("WEEK",time);

			pendingIntent.

			pendingIntent.putExtra("ID", id);

			

			

			//startService(pendingIntent);

	        

        }
	}
	//private Intent getIntent() {
		// TODO Auto-generated method stub
		//return null;
	//}

}
