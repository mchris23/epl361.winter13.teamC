
package cy.ac.ucy.teamc.scc;

import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
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

			@SuppressWarnings("static-access")
			@SuppressLint("ShowToast")
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				Bundle extras = intent.getExtras();
				
				switch(view.getId()){
				case R.id.BtimeNotification: intent.setClass(this, ActivityNotificationService.class);
				int hour=notificationTime.getCurrentHour();
				int minutes=notificationTime.getCurrentMinute();
				Toast.makeText(getApplicationContext(), "¿ñá ðïõ êáèïñßóôçêå: "+hour+":"+minutes,Toast.LENGTH_SHORT).show();
				Calendar calendar=Calendar.getInstance();
				calendar.set(calendar.YEAR, calendar.MONTH, calendar.DAY_OF_MONTH, calendar.HOUR, calendar.MINUTE);
				AlarmManager alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
				
				PendingIntent pendingIntent=PendingIntent.getService(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
				
				
				String time = extras.getString("WEEK");
				extras.putString("WEEK",time);
				
				//intent.putExtra("msg", "¸êëåéóåò ñáíôåâïý;");
				
				
				//startService(intent);
				}
	}
	
}
