package cy.ac.ucy.teamc.scc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Intro extends Activity{
	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		ourSong=MediaPlayer.create(Intro.this, R.raw.my_music2);
		
		@SuppressWarnings("unused")
		DatabaseManager db =DatabaseManager.getHelper(getApplicationContext());
		
		AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		//sound won't play if device is in silent mode
		switch (am.getRingerMode()) {
	    	case AudioManager.RINGER_MODE_SILENT:
				        							break;
	    	case AudioManager.RINGER_MODE_VIBRATE:
				        							break;
	    	case AudioManager.RINGER_MODE_NORMAL:
				    								ourSong.start();
				    								break;
		}
		
		// Create a new HttpClient and Post Header
		/*HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("https://dione.in.cs.ucy.ac.cy/assignments/stopcancercyprus/api/getExams.php"); 
		
		try {
		    // Add your data
		    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		    Date date = new Date();
		    nameValuePairs.add(new BasicNameValuePair("dateTime", new Long(date.getTime()).toString()));
		    
		    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		    // Execute HTTP Post Request
		    HttpResponse response = httpclient.execute(httppost);

		} catch (ClientProtocolException e) {
		    // TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		    // TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		*/
		
		new SQLConnection().doInBackground();

		
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartingPoint=new Intent("cy.ac.ucy.teamc.scc.PASIKAFINFO");
					startActivity(openStartingPoint);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
