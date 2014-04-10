package cy.ac.ucy.teamc.scc;

import cy.ac.ucy.teamc.scc.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pushNotificationScreen extends Activity{
	public final static String WEEK = "1";

	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.push_notification_screen);
        
        final String week = null;
        
        final Button yes = (Button) findViewById(R.id.byes);
        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            }
        });

        final Button no = (Button) findViewById(R.id.bno);
        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	//Create a new notification after a week
            	Intent i = new Intent(getApplicationContext(),ActivityNotification.class);
            	
            	Bundle extras = new Bundle();
				extras.putString("WEEK",week);
				i.putExtras(extras);
				
				startActivity(i);
            	
            }
        });

	}
	
	
	
}
