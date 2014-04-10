package cy.ac.ucy.teamc.scc;

import java.util.Calendar;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PersonalInformNotFirstTime extends Activity {
	TextView cont;
	Button showRelatedExams;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_personal_inform_not_first_time);
		
		LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout2);
		createAllObjects();
		SharedPreferences s_pref=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		int curyear = Calendar.getInstance().get(Calendar.YEAR);
		
		int input_smoker=s_pref.getInt("smoker",0);
		int input_Gender=s_pref.getInt("Gender",0);
		int input_year_of_birth=s_pref.getInt("year_of_birth",0);
		int input_alcoholic=s_pref.getInt("alcoholic",0);
		int input_Preposission=s_pref.getInt("Preposission",0);
		int input_SexualSituation=s_pref.getInt("SexualSituation",0);
		float input_maza_somatos=s_pref.getFloat("maza_somatos",(float) 0.0);
		
		
		
		//calculate the  age of the use
		int age=curyear-input_year_of_birth;
		String in_Gender, in_Smoker,in_alcoholic,in_Preposission,in_SexualSituation,inp_maza_somatos;
		
		//inGender
		if(input_Gender==0)
			in_Gender="άντρας. ";
		else
			in_Gender="γυναίκα. ";
		
		//inSmoker
		if(input_smoker==0)
		{
			if(input_Gender==0)
				in_Smoker="Είσατε νυν καπνιστής. ";
			else
				in_Smoker="Είσατε νυν καπνίστρια. ";
			
		}
		else if(input_smoker==1)
		{
			if(input_Gender==0)
				in_Smoker="Είσατε πρώην καπνιστής. ";
			else
				in_Smoker="Είσατε πρώην καπνίστρια. ";
			
		}
			
		else
		{
			if(input_Gender==0)
				in_Smoker="Είσατε μη καπνιστής. ";
			else
				in_Smoker="Είσατε μη  καπνίστρια. ";
			
		}
			
		
		//in_alcoholic
		if(input_alcoholic==0)
		{
			if(input_Gender==0)
				in_alcoholic="Είσατε καταναλωτής αλκοόλ. ";
			else
				in_alcoholic="Eίσαστε καταναλώτρια αλκοόλ. ";
			
		}
		else 
		{
			if(input_Gender==0)
				in_alcoholic="Δεν είσαστε καταναλωτής αλκοόλ. ";
			else
				in_alcoholic="Δεν είσαστε καταναλώτρια αλκοόλ. ";
			
		}
		
		//in_Preposission
		if(input_Preposission==0)
			in_Preposission="Έχετε Προδιάθεση/Οικογενειακό ιστορικό. ";
		else
			in_Preposission="Δεν εχετε Προδιάθεση/Οικογενειακό ιστορικό. ";
		
		//in_SexualSituation
		if(input_SexualSituation==0)
		{
			if(input_Gender==0)
				in_SexualSituation="Είσαστε σεξουαλικά ενεργός για περισσότερα από 2 χρόνια. ";
			else
				in_SexualSituation="Είσαστε σεξουαλικά ενεργή για περισσότερα από 2 χρόνια. ";
			
		}
		else
		{
			if(input_Gender==0)
				in_SexualSituation="Δεν είσαστε σεξουαλικά ενεργός για περισσότερα από 2 χρόνια. ";
			else
				in_SexualSituation="Δεν είσαστε σεξουαλικά ενεργή για περισσότερα από 2 χρόνια. ";
		}	
		
			
		
		  // set the of the text view for context of the user's info
       
        cont.setText("Έχετε ήδη εισάγει τα προσωπικά σας στοιχεία. Αν επιθυμήται να τα τροποποιήσεται υπάρχει η επιλογή Ρυθμίσεις. Είσατε "+in_Gender+" Είσαστε "+age+" χρονών. Ο δείκτης μάζας σώματος σας είναι "+input_maza_somatos+". "+in_Smoker+in_alcoholic+in_Preposission+in_SexualSituation);
       
		
        

        showRelatedExams.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
					Class ourClass = Class.forName("cy.ac.ucy.teamc.scc.ShowForFirstTime");
					//triggered a class that user selected.
					Intent ourIntent = new Intent(PersonalInformNotFirstTime.this, ourClass);
					startActivity(ourIntent);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	

	
	

	public boolean createAllObjects() {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.personal_inform_not_first_time, menu);
		cont = (TextView) findViewById(R.id.Cont);
		showRelatedExams = (Button) findViewById(R.id.Bsubmit);
		return true;
	}

}
