package cy.ac.ucy.teamc.scc;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Intro extends Activity{
	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intro);
		ourSong=MediaPlayer.create(Intro.this, R.raw.my_music2);
		ourSong.start();
		//new SQLConnection().doInBackground("getCancerNames.php");
		DatabaseManager db =DatabaseManager.getHelper(getApplicationContext());
		
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
