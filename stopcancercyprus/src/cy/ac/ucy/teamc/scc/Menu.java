package cy.ac.ucy.teamc.scc;


import android.app.TabActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
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
		
		TabSpec generalSpec=menuTabHost.newTabSpec("Γενική Ενημέρωση");
		generalSpec.setIndicator("Γενική Ενημέρωση",getResources().getDrawable(R.drawable.mytab1));
		Intent generalIntent=new Intent(this,GeneralInform.class);
		generalSpec.setContent(generalIntent);
		
		TabSpec personalSpec=menuTabHost.newTabSpec("Προσωπική Ενημέρωση");
		personalSpec.setIndicator("Προσωπική Ενημέρωση",getResources().getDrawable(R.drawable.mytab2));
		//Intent personallIntent=new Intent(this,ChoosePersonalInform.class);
		//personalSpec.setContent(personallIntent);
		
		
		
SharedPreferences s_pref=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		
		int input_smoker=s_pref.getInt("smoker",5);
		
		Log.e("////////antoni**********", ""+input_smoker);
		
		
		super.onCreate(savedInstanceState);
		boolean flag_first_time = true;
		
		if(input_smoker==5)
			flag_first_time=false;
		
		
		if(flag_first_time==false)
		{
				
					Intent personallIntent=new Intent(this,PersonalInform.class);
					personalSpec.setContent(personallIntent);
					flag_first_time=true;
					personallIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				}
				
				
	
		else
			
		{
				
					Intent personallIntent=new Intent(this,PersonalInformNotFirstTime.class);
					personalSpec.setContent(personallIntent);
					personallIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				
			}
	
		
		
		
		
		TabSpec settingsSpec=menuTabHost.newTabSpec("Ρυθμίσεις");
		settingsSpec.setIndicator("Ρυθμίσεις",getResources().getDrawable(R.drawable.mytab3));
		Intent settingslIntent=new Intent(this,Settings.class);
		settingsSpec.setContent(settingslIntent);
		settingslIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		TabSpec pasikafinfo =menuTabHost.newTabSpec("Πληροφορίες ΠΑΣΥΚΑΦ");
		pasikafinfo.setIndicator("Πληροφορίες ΠΑΣΥΚΑΦ",getResources().getDrawable(R.drawable.logo));
		Intent pasikafinfolIntent=new Intent(this,PasikafInfoafter.class);
		pasikafinfo.setContent(pasikafinfolIntent);
		menuTabHost.addTab(generalSpec);
		menuTabHost.addTab(personalSpec);
		menuTabHost.addTab(settingsSpec);
		menuTabHost.addTab(pasikafinfo);

		
		
		

	}
	
	
	


}
