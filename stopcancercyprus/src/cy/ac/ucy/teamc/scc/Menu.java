package cy.ac.ucy.teamc.scc;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class Menu extends TabActivity {

	TabHost menuTabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		menuTabHost=getTabHost();
		
		TabSpec generalSpec=menuTabHost.newTabSpec("Ãåíé�?�?\nÅíçì�?ñùóç");
		generalSpec.setIndicator("Ãåíé�?�? Åíçì�?ñùóç",getResources().getDrawable(R.drawable.mytab1));
		Intent generalIntent=new Intent(this,GeneralInform.class);
		generalSpec.setContent(generalIntent);
		
		TabSpec personalSpec=menuTabHost.newTabSpec("�?ñïóùðé�?�?\nÅíçì�?ñùóç");
		personalSpec.setIndicator("�?ñïóùðé�?�? Åíçì�?ñùóç",getResources().getDrawable(R.drawable.mytab2));
		Intent personallIntent=new Intent(this,PersonalInform.class);
		personalSpec.setContent(personallIntent);
		
		TabSpec settingsSpec=menuTabHost.newTabSpec("Ñõèì�?óåéò");
		settingsSpec.setIndicator("Ñõèì�?óåéò",getResources().getDrawable(R.drawable.mytab3));
		Intent settingslIntent=new Intent(this,Settings.class);
		settingsSpec.setContent(settingslIntent);
		
		TabSpec pasikafinfo =menuTabHost.newTabSpec("ΠΛΗΡ�?Φ�?ΡΙΕΣ ΠΑΣΥ�?ΑΦ");
		pasikafinfo.setIndicator("ΠΛΗΡ�?Φ�?ΡΙΕΣ ΠΑΣΥ�?ΑΦ",getResources().getDrawable(R.drawable.pasikaf));
		Intent pasikafinfolIntent=new Intent(this,Settings.class);
		pasikafinfo.setContent(settingslIntent);
		
		menuTabHost.addTab(generalSpec);
		menuTabHost.addTab(personalSpec);
		menuTabHost.addTab(settingsSpec);
		menuTabHost.addTab(pasikafinfo);

	}


}
