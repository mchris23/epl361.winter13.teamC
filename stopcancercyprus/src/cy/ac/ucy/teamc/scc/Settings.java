package cy.ac.ucy.teamc.scc;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Settings extends Activity {

	Button Bpersonal;
	Button Bnotification;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose_setting_type);

		createAllObjects();

		Bpersonal.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					Class ourClass = Class.forName("cy.ac.ucy.teamc.scc.Personal_settings");
					//triggered a class that user selected.
					Intent ourIntent = new Intent(Settings.this, ourClass);
					startActivity(ourIntent);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				
				setContentView(R.layout.personal_settings);
			}
		});

		Bnotification.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					Class ourClass = Class.forName("com.example.stopcancercyprus.ActivityNotification");
					//triggered a class that user selected.
					Intent ourIntent = new Intent(Settings.this, ourClass);
					startActivity(ourIntent);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

	}

	private void createAllObjects() {
		// TODO Auto-generated method stub
		Bpersonal = (Button) findViewById(R.id.BpersonalInfo);
		Bnotification = (Button) findViewById(R.id.Bnotification);
	}

}
