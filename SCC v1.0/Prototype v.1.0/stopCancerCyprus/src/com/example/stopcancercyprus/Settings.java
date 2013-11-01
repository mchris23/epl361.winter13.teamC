package com.example.stopcancercyprus;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Settings extends Activity{
	ToggleButton checkNotificationActivity;
	TextView displayNotificationActivity;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		createAllObjects();
		
		checkNotificationActivity.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				displayNotificationActivity.setText("����������(��������)");
			}
		});
	}
	


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
	private void createAllObjects() {
		// TODO Auto-generated method stub
		checkNotificationActivity= (ToggleButton) findViewById(R.id.deActivateNotification);
		displayNotificationActivity=(TextView) findViewById(R.id.MsgPushNotification);
	}
	
}
