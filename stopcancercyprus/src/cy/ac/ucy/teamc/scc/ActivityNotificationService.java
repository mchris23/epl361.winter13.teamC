package cy.ac.ucy.teamc.scc;


import java.util.ArrayList;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.IBinder;
//import android.widget.Toast;
import android.preference.PreferenceManager;

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
		//Toast.makeText(this, "create", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		//Toast.makeText(this, "destroy", Toast.LENGTH_SHORT).show();
	}

	@SuppressWarnings("deprecation")
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		//String message=intent.getStringExtra("msg");
		DatabaseManager dm = DatabaseManager.getHelper(null);
		//String message = null; //from database (exam info)
		
		NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		Intent notificationIntent=new Intent(this, ActivityNotification.class);
		PendingIntent pedIntent=PendingIntent.getActivity(this, 0, notificationIntent, 0);
		
		Bundle extras = notificationIntent.getExtras();
		
		String examid = null;
		extras.getInt(examid);
		int a = Integer.parseInt(examid);
		ArrayList<Exam> e = dm.getExam(a);

		String text = e.get(0).get_name();
		
		int icon=R.drawable.pasikaf;
		long f=0, when; 
		
		
		//F temp in comments
		//if(extras.getString("WEEK")!="1"){
			//int frequency = e.get(0).get_frequency(); //from database(in months)
			//f = (frequency-1/*notific. before 1 month*/);
			//f *= 30/*days*/ ;
		//}
		//else
			//f = 7 /*days*/;
		
		//f *= 24/*h*/ ;
		//f *= 60/*min*/ ;
		//f *= 60/*sec*/ ;
		//f *= 100/*millisec*/; //time in milliseconds

		
		when=System.currentTimeMillis() + f;
		
		Notification notification=new Notification(icon, text, when);
		String contentText = "Î£Î±Ï‚ ÏƒÏ…Î½Î¹ÏƒÏ„Î¿ÏÎ¼Îµ Î½Î± ÎºÎ¬Î½ÎµÏ„Îµ Ï„Î·Î½ ÎµÎ¾Î­Ï„Î±ÏƒÎ· : "+ text;
		String contentTitle= text; //from database (exam title)
		notification.setLatestEventInfo(this, contentTitle, contentText, pedIntent);
		notificationManager.notify(1,notification);
		
		//notification.
		//showNotification();
		
		int h,m;
		
		SharedPreferences s_pref=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		Editor edit=s_pref.edit();
		
		h = s_pref.getInt("notification_hour",0);
		m = s_pref.getInt("notification_min",0);
		
		edit.commit();
		
		//int time = (h * 60) + m;
		//time *= 60 *100;
		 int time  =0;
		 
		//AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
		//alarmManager.set(AlarmManager.RTC_WAKEUP, time, getIntent());
		AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
		alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), getIntent());
	}

	private PendingIntent getIntent() {
		// TODO Auto-generated method stub
		return null;
	}

}



