package cy.ac.ucy.teamc.scc;

import java.util.ArrayList;
import java.util.Calendar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.EditText;



public class PersonalInform extends Activity {
	public final static String EXTRA_ARRAY = "cy.ac.ucy.teamc.scc.MESSAGE";

	Button checkSubmition;
	TextView displaySubmit;
	EditText Tweight;
	EditText Theight;
	
	private DatePicker dpResult;
	private int year;
	private int month;
	private int day;
	public float maza_somatos;
	ArrayList<Exam> exams;
   // static ArrayList<Exam> exams = new ArrayList<Exam>();
	
    
    static final int DATE_DIALOG_ID = 999;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		DatabaseManager db =DatabaseManager.getHelper(getApplicationContext());
		exams=db.getAllExams();
		for(int i=0;i<exams.size();i++)
			Log.e("here",i+") "+exams.get(i).get_name());
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personal);
		createAllObjects();

		checkSubmition.setOnClickListener(new View.OnClickListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				int curyear = Calendar.getInstance().get(Calendar.YEAR);
			showDialog(DATE_DIALOG_ID);

				
				if (Tweight.getText().toString().equalsIgnoreCase(""))
				{
					displaySubmit.setText("Δεν έχετε εισάγει όλα τα δεδομένα²");
					displaySubmit.setTextColor(Color.RED);
				} else if (Float.parseFloat(Tweight.getText().toString()) > (float) 350.00
							|| Float.parseFloat(Tweight.getText().toString()) < (float) 20) 
					{
					displaySubmit.setText("Εισάγατε λάθος όριο βάρους. Το όριο βάρους είναι [20-350]");
					displaySubmit.setTextColor(Color.RED);
					} else if (Theight.getText().toString().equalsIgnoreCase(""))
						{
						displaySubmit.setText("Δεν έχετε εισάγει όλα τα δεδομένα");
						displaySubmit.setTextColor(Color.RED);
						} else if (Float.parseFloat(Theight.getText().toString()) > (float) 250.00
								|| Float.parseFloat(Theight.getText().toString()) < (float) 40)
							{
							displaySubmit.setText("Εισάγατε λάθος όριο ύψους. Το όριο ύψους είναι[40-250]");
							displaySubmit.setTextColor(Color.RED);
							}
							else if (dpResult.getYear()>=(curyear) || dpResult.getYear()<(curyear-120))
									{
										displaySubmit.setText("Εισάγαται λάθος ημερομηνία Γέννησης");
										displaySubmit.setTextColor(Color.RED);
									}
							else 
							{ 
								//get the user's personals information from screen
								int age=curyear-dpResult.getYear();
								 final Spinner selectsmoke = (Spinner) findViewById(R.id.selectSmoke);
								 final Spinner selectGender = (Spinner) findViewById(R.id.selectGender);
								 final Spinner selectalcoholic = (Spinner) findViewById(R.id.selectAlcohol);
								 final Spinner selectPreposission = (Spinner) findViewById(R.id.selectPreposission);
								 final Spinner selectSexualSituation = (Spinner) findViewById(R.id.selectSexualSituation);
								
								 int smoker= selectsmoke.getSelectedItemPosition();
								 int Gender= selectGender.getSelectedItemPosition();
							 int alcoholic= selectalcoholic.getSelectedItemPosition();
							 int Preposission= selectPreposission.getSelectedItemPosition();
								 int SexualSituation= selectSexualSituation.getSelectedItemPosition();
								maza_somatos=Float.parseFloat(Tweight.getText().toString())/ (((Float.parseFloat(Theight.getText().toString()))*(Float.parseFloat(Theight.getText().toString())))/10000);
								displaySubmit.setText("Τα δεδομένα εισάχθηκαν με επιτυχία!");
								
								displaySubmit.setTextColor(Color.GREEN);
								ArrayList<Exam> selected_exams= new ArrayList<Exam>();
								
								selected_exams=informUser(age,smoker, Gender,maza_somatos,alcoholic,Preposission,SexualSituation);
								
								
								
								if(selected_exams!=null)
								{
									
									try{
										
										
										Intent passIntent = new Intent();
										passIntent.setClass(PersonalInform.this, Personal_information.class);
										
										// Create a Bundle and Put Bundle in to it
										Bundle bundleObject = new Bundle();
										bundleObject.putSerializable("EXTRA_ARRAY", selected_exams);
										                 
										// Put Bundle in to Intent and call start Activity
										passIntent.putExtras(bundleObject);
										startActivity(passIntent);
										
						
							
									}catch(Exception e){
										e.printStackTrace();
									}
								}
							}
			}
		});
	}
	
	//Inform personal the user about the exams that he/she should do
		public ArrayList<Exam> informUser(int age,int smoker, int gender,float deiktis_mazas_somatos,int alcoholic,int preposission, int sexual_situation)
		{
			 ArrayList<Exam> selected_exams_array = new ArrayList<Exam>();
			
			
			for(int i=0;i<exams.size();i++)
			{
				if(exams.get(i)!=null)
				{
					int start_age = 0,end_age = 0,start_deiktis_mazas = 0,end_deiktis_mazas = 0,smoker_in,gender_in,alcoholic_in,prepos_in,sexual_situation_in;
					Log.e("this2",""+exams.get(i).get_name());
					// get age range (split)
					if(exams.get(i).get_age_range()!=null){
					String  age_range=exams.get(i).get_age_range();
					String [] age_r=age_range.split("-");
					start_age=Integer.parseInt(age_r[0]);
					end_age=Integer.parseInt(age_r[1]);
					}
					
					//get deiktis mazas somatos (split)
					if(exams.get(i).get_deiktis_mazas_range()!=null){
					String  deiktis_mazas_range=exams.get(i).get_deiktis_mazas_range();
					String [] deiktis_mazas=deiktis_mazas_range.split("-");
					start_deiktis_mazas=Integer.parseInt(deiktis_mazas[0]);
					end_deiktis_mazas=Integer.parseInt(deiktis_mazas[1]);
					}
					
					
					smoker_in=(exams.get(i).get_smoker());
					gender_in=(exams.get(i).get_gender());
					alcoholic_in=(exams.get(i).get_alcohol());
					prepos_in=(exams.get(i).get_inheritance());
					sexual_situation_in=(exams.get(i).get_SexualSituation());
					
					
					if(deiktis_mazas_somatos>=start_deiktis_mazas && deiktis_mazas_somatos<=end_deiktis_mazas && age>=start_age && age<=end_age && (smoker_in==3 ||smoker_in==smoker) && (gender_in==2 || gender_in==gender) && (sexual_situation_in==2 || sexual_situation_in==sexual_situation) && (alcoholic_in==2 || alcoholic_in==alcoholic) && (prepos_in==2 || prepos_in==preposission))
					{
						selected_exams_array.add(exams.get(i));
						
					}
				}
			} return selected_exams_array;
		} 


	
	
	

	// display current date
	public void setCurrentDateOnView() {
		dpResult = (DatePicker) findViewById(R.id.dpResult);
 
		final Calendar c = Calendar.getInstance();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);
 
		// set current date into datepicker
		dpResult.init(year, month, day, null);
 
	}
	


	
	


	private void createAllObjects() {
		// TODO Auto-generated method stub
		checkSubmition = (Button) findViewById(R.id.Bsubmit);
		displaySubmit = (TextView) findViewById(R.id.msgSubmit);
		Tweight = (EditText) findViewById(R.id.CommandWeight);
		Theight=(EditText) findViewById(R.id.CommandHeigh);
		setCurrentDateOnView();
	}

}
