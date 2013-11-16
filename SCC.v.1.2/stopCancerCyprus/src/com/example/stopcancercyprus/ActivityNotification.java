package com.example.stopcancercyprus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class ActivityNotification extends Activity implements OnClickListener{

	TimePicker notificationTime;
	Button BsetTimeNotification;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
		
		NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		notificationManager.cancelAll();
		notificationTime=(TimePicker)findViewById(R.id.timePicker);
		BsetTimeNotification=(Button)findViewById(R.id.BtimeNotification);		
		
		BsetTimeNotification.setOnClickListener(this);
	}

			@SuppressLint("ShowToast")
			public void onClick(View view) {
				// TODO Auto-generated method stub
				int hour=notificationTime.getCurrentHour();
				int minutes=notificationTime.getCurrentMinute();
				Toast.makeText(getApplicationContext(), "Ώρα που καθορίστηκε: "+hour+":"+minutes,Toast.LENGTH_SHORT).show();
				Intent intent=new Intent();
				
				switch(view.getId()){
				case R.id.BtimeNotification: intent.setClass(this, ActivityNotificationService.class);
				startService(intent);
				}
	}
	
}
