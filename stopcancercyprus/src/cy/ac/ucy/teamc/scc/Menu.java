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
		
		TabSpec generalSpec=menuTabHost.newTabSpec("Γενική Ενημέρωση");
		generalSpec.setIndicator("Γενική Ενημέρωση",getResources().getDrawable(R.drawable.mytab1));
		Intent generalIntent=new Intent(this,GeneralInform.class);
		generalSpec.setContent(generalIntent);
		
		TabSpec personalSpec=menuTabHost.newTabSpec("Προσωπική Ενημέρωση");
		personalSpec.setIndicator("Προσωπική Ενημέρωση",getResources().getDrawable(R.drawable.mytab2));
		Intent personallIntent=new Intent(this,PersonalInform.class);
		personalSpec.setContent(personallIntent);
		
		TabSpec settingsSpec=menuTabHost.newTabSpec("Ρυθμίσεις");
		settingsSpec.setIndicator("Ρυθμίσεις",getResources().getDrawable(R.drawable.mytab3));
		Intent settingslIntent=new Intent(this,Settings.class);
		settingsSpec.setContent(settingslIntent);
			
		menuTabHost.addTab(generalSpec);
		menuTabHost.addTab(personalSpec);
		menuTabHost.addTab(settingsSpec);

	}


}
