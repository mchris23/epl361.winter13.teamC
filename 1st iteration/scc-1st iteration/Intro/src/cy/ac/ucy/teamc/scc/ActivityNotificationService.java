package cy.ac.ucy.teamc.scc;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
//import android.widget.Toast;

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
		
		String message = null; //from database (exam info)
		
		NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
		Intent notificationIntent=new Intent(this, ActivityNotification.class);
		PendingIntent pedIntent=PendingIntent.getActivity(this, 0, notificationIntent, 0);
		
		Bundle extras = notificationIntent.getExtras();
		
		
		int icon=R.drawable.pasikaf;
		String text=null; //from database
		long f=0, when; 
		
		if(extras.getString("WEEK")!="1"){
			int frequency = 0; //from database(in months)
			f = (frequency-1/*notific. before 1 month*/);
			f *= 30/*days*/ ;
		}
		else
			f = 7 /*days*/;
		
		f *= 24/*h*/ ;
		f *= 60/*min*/ ;
		f *= 60/*sec*/ ;
		f *= 100/*millisec*/; //time in milliseconds
		
		when=System.currentTimeMillis() + f;
		
		Notification notification=new Notification(icon, text, when);
		String contentText=message;
		String contentTitle=null; //from database (exam title)
		notification.setLatestEventInfo(this, contentTitle, contentText, pedIntent);
		notificationManager.notify(1,notification);
		
	}

}


