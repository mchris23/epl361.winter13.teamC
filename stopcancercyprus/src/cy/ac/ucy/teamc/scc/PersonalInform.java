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
	public final static String EXTRA_NAME = "cy.ac.ucy.teamc.scc.MESSAGE";
	public final static String EXTRA_DESCRIPTION = "cy.ac.ucy.teamc.scc.MESSAGE";
	public final static String EXTRA_IMAGE_NAME= "cy.ac.ucy.teamc.scc.MESSAGE";
	public final static String EXTRA_FREQUENCY= "cy.ac.ucy.teamc.scc.MESSAGE";
	Button checkSubmition;
	TextView displaySubmit;
	EditText Tweight;
	EditText Theight;
	
	private DatePicker dpResult;
	private int year;
	private int month;
	private int day;
	public float maza_somatos;

	DatabaseManager db =DatabaseManager.getHelper(getApplicationContext());
	ArrayList<Exam> exams=db.getAllExams();
	static final int DATE_DIALOG_ID = 999;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
					displaySubmit.setText("Γ„Γ�Γ­ Γ�Γ·Γ¥Γ© Γ£Γ�Γ­Γ¥Γ© Γ¥Γ©Γ³Γ΅Γ£ΓΉΓ£Γ� Γ΄Γ―Γµ ΓΆΓ�Γ±Γ―ΓµΓ²");
					displaySubmit.setTextColor(Color.RED);
				} else if (Float.parseFloat(Tweight.getText().toString()) > (float) 350.00
							|| Float.parseFloat(Tweight.getText().toString()) < (float) 20) 
					{
					displaySubmit.setText("Γ‹Γ΅Γ­Γ¨Γ¥Γ³Γ¬Γ�Γ­Γ§ Γ¥Γ�Γ³Γ―Γ¤Γ― ΓΆΓ�Γ±Γ―ΓµΓ²:\nΓ�Γ±Γ�Γ°Γ¥Γ© Γ­Γ΅ Γ¥Γ�Γ­Γ΅Γ© Γ³Γ΄Γ― Γ¤Γ©Γ�Γ³Γ΄Γ§Γ¬Γ΅ [20-350]");
					displaySubmit.setTextColor(Color.RED);
					} else if (Theight.getText().toString().equalsIgnoreCase(""))
						{
						displaySubmit.setText("Γ„Γ�Γ­ Γ�Γ·Γ¥Γ© Γ£Γ�Γ­Γ¥Γ© Γ¥Γ©Γ³Γ΅Γ£ΓΉΓ£Γ� Γ΄Γ―Γµ Γ½ΓΈΓ―ΓµΓ²");
						displaySubmit.setTextColor(Color.RED);
						} else if (Float.parseFloat(Theight.getText().toString()) > (float) 250.00
								|| Float.parseFloat(Theight.getText().toString()) < (float) 40)
							{
							displaySubmit.setText("Γ‹Γ΅Γ­Γ¨Γ¥Γ³Γ¬Γ�Γ­Γ§ Γ¥Γ�Γ³Γ―Γ¤Γ― Γ½ΓΈΓ―ΓµΓ²:\nΓ�Γ±Γ�Γ°Γ¥Γ© Γ­Γ΅ Γ¥Γ�Γ­Γ΅Γ© Γ³Γ΄Γ― Γ¤Γ©Γ�Γ³Γ΄Γ§Γ¬Γ΅ [40-250]");
							displaySubmit.setTextColor(Color.RED);
							}
							else if (dpResult.getYear()>=(curyear) || dpResult.getYear()<(curyear-120))
									{
										displaySubmit.setText("Not a valid date");
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
								displaySubmit.setText("Ξ¤Ξ± Ξ΄ΞµΞ΄ΞΏΞΌΞ­Ξ½Ξ± ΞµΞΉΟƒΞ¬Ο‡ΞΈΞ·ΞΊΞ±Ξ½ ΞΌΞµ ΞµΟ€ΞΉΟ„Ο…Ο‡Ξ―Ξ±!\n Ξ� Ξ΄ΞµΞ―ΞΊΟ„Ξ·Ο‚ ΞΌΞ¬Ξ¶Ξ±Ο‚ ΟƒΟ�ΞΌΞ±Ο„ΞΏΟ‚ ΟƒΞ±Ο‚ ΞµΞ―Ξ½Ξ±ΞΉ:"+maza_somatos);
								
								displaySubmit.setTextColor(Color.GREEN);
								
								Exam exam_selected=informUser(age,smoker, Gender,maza_somatos,alcoholic,Preposission,SexualSituation);
								String exam_description=exam_selected.get_description();
								String exam_name=exam_selected.get_name();
								String image_name=exam_selected.get_image_name();
								int frequency=exam_selected.get_frequency();
								if(!(exam_description==null))
								{
									try{
										Class<?> ourClass=Class.forName("cy.ac.ucy.teamc.scc.Personal_information");
										Intent ourIntent=new Intent(PersonalInform.this, ourClass);
										
										
										
										Bundle extras = new Bundle();
									extras.putString("EXTRA_NAME",exam_name);
										extras.putString("EXTRA_DESCRIPTION",exam_description);
										extras.putString("EXTRA_IMAGE_NAME",image_name);
										extras.putInt("EXTRA_FREQUENCY",frequency);
										ourIntent.putExtras(extras);
										startActivity(ourIntent);
									}catch(ClassNotFoundException e){
										e.printStackTrace();
									}
								}
								
							}
			}
		});
	}
	
	//Inform personal the user about the exams that he/she should do
		public Exam informUser(int age,int smoker, int gender,float deiktis_mazas_somatos,int alcoholic,int preposission, int sexual_situation)
		{
			Exam selected_exam = null;
			String descr=null;
			Exam a =new Exam("ΞµΞΎΞµΟ„Ξ±ΟƒΞ·","18-40",3,2,"18-45",2,2,2,"My descriptionn!","prostatis",3);
			exams.add(a);
			for(int i=0;i<exams.size();i++)
			{
				// get age range (split)
				String  age_range=exams.get(i).get_age_range();
				String [] age_r=age_range.split("-");
				int start_age=Integer.parseInt(age_r[0]);
				int end_age=Integer.parseInt(age_r[1]);
				
				//get deiktis mazas somatos (split)
				String  deiktis_mazas_range=exams.get(i).get_deiktis_mazas_range();
				String [] deiktis_mazas=deiktis_mazas_range.split("-");
				int start_deiktis_mazas=Integer.parseInt(deiktis_mazas[0]);
				int end_deiktis_mazas=Integer.parseInt(deiktis_mazas[1]);
				
				int smoker_in=(exams.get(i).get_smoker());
				int gender_in=(exams.get(i).get_gender());
				int alcoholic_in=(exams.get(i).get_alcohol());
				int prepos_in=(exams.get(i).get_inheritance());
				int sexual_situation_in=(exams.get(i).get_SexualSituation());
				
				//Log.w("---->", "ag "+age_r[0]);
				
				if(deiktis_mazas_somatos>=start_deiktis_mazas && deiktis_mazas_somatos<=end_deiktis_mazas && age>=start_age && age<=end_age && (smoker_in==3 ||smoker_in==smoker) && (gender_in==2 || gender_in==gender) && (sexual_situation_in==2 || sexual_situation_in==sexual_situation) && (alcoholic_in==2 || alcoholic_in==alcoholic) && (prepos_in==2 || prepos_in==preposission))
				{
					selected_exam=(exams.get(i));
					
				}
			} return selected_exam;
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
