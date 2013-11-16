package com.example.stopcancercyprus;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ActivityNotificationService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "create", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "destroy", Toast.LENGTH_SHORT).show();
	}

	@SuppressWarnings("deprecation")
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Toast.makeText(this, "start", Toast.LENGTH_SHORT).show();
		NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		Intent notificationIntent=new Intent(this, ActivityNotification.class);
		PendingIntent pedIntent=PendingIntent.getActivity(this, 0, notificationIntent, 0);
		int icon=R.drawable.pasikaf;
		String text="You have notification message";
		long when=System.currentTimeMillis();
		Notification notification=new Notification(icon, text, when);
		String contentText="This is your message";
		String contentTitle="Notification";
		notification.setLatestEventInfo(this, contentTitle, contentText, pedIntent);
		notificationManager.notify(1,notification);
		
	}

}
