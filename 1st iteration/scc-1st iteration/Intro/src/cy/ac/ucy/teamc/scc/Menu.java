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
		
		TabSpec generalSpec=menuTabHost.newTabSpec("ÃƒÃ¥Ã­Ã©ÃªÃž\nÃ…Ã­Ã§Ã¬ÃÃ±Ã¹Ã³Ã§");
		generalSpec.setIndicator("ÃƒÃ¥Ã­Ã©ÃªÃž Ã…Ã­Ã§Ã¬ÃÃ±Ã¹Ã³Ã§",getResources().getDrawable(R.drawable.mytab1));
		Intent generalIntent=new Intent(this,GeneralInform.class);
		generalSpec.setContent(generalIntent);
		
		TabSpec personalSpec=menuTabHost.newTabSpec("ÃÃ±Ã¯Ã³Ã¹Ã°Ã©ÃªÃž\nÃ…Ã­Ã§Ã¬ÃÃ±Ã¹Ã³Ã§");
		personalSpec.setIndicator("ÃÃ±Ã¯Ã³Ã¹Ã°Ã©ÃªÃž Ã…Ã­Ã§Ã¬ÃÃ±Ã¹Ã³Ã§",getResources().getDrawable(R.drawable.mytab2));
		Intent personallIntent=new Intent(this,PersonalInform.class);
		personalSpec.setContent(personallIntent);
		
		TabSpec settingsSpec=menuTabHost.newTabSpec("Ã‘ÃµÃ¨Ã¬ÃŸÃ³Ã¥Ã©Ã²");
		settingsSpec.setIndicator("Ã‘ÃµÃ¨Ã¬ÃžÃ³Ã¥Ã©Ã²",getResources().getDrawable(R.drawable.mytab3));
		Intent settingslIntent=new Intent(this,Settings.class);
		settingsSpec.setContent(settingslIntent);
		
		TabSpec pasikafinfo =menuTabHost.newTabSpec("Î Î›Î—Î¡ÎŸÎ¦ÎŸÎ¡Î™Î•Î£ Î Î‘Î£Î¥ÎšÎ‘Î¦");
		pasikafinfo.setIndicator("Î Î›Î—Î¡ÎŸÎ¦ÎŸÎ¡Î™Î•Î£ Î Î‘Î£Î¥ÎšÎ‘Î¦",getResources().getDrawable(R.drawable.pasikaf));
		Intent pasikafinfolIntent=new Intent("cy.ac.ucy.teamc.scc.PASIKAFINFO");
		pasikafinfo.setContent(pasikafinfolIntent);
		
		menuTabHost.addTab(generalSpec);
		menuTabHost.addTab(personalSpec);
		menuTabHost.addTab(settingsSpec);
		menuTabHost.addTab(pasikafinfo);

	}


}

