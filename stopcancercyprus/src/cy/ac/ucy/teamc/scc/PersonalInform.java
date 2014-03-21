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

    static ArrayList<Exam> exams = new ArrayList<Exam>();
	
    
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
			exams.add(new Exam("ΑΥΤΟΕΞΕΤΑΣΗ ΟΡΧΕΩΝ","18-24",3,2,"0-50",0,0,1,"Η καλύτερη ίσως ώρα να αυτοεξετάζεστε είναι  όταν παίρνετε το μπάνιο σας, διότι λόγω του χλιαρού νερού οι μύες της περιοχής είναι πιο χαλαροί. Ελέγχετε οπτικά το όσχεο πριν από την ψηλάφηση για τυχόν αλλαγή του χρώματος ή του σχήματός του. Συγκρατείτε τους όρχεις με το ένα χέρι ενώ ψηλαφείτε με το άλλο τον κάθε όρχι ξεχωριστά.  Με ήπιες κινήσεις ψηλαφήστε τον όρχι ανάμεσα στα δάχτυλά σας. Ο ένας όρχις μπορεί να έχει από την εφηβεία διαφορετικό μέγεθος ή να βρίσκεται ψηλότερα ή χαμηλότερα από τον άλλο. Δεν είναι κάτι το ανησυχητικό, εφόσον δεν έχει συμβεί ξαφνικά. Μάθετε να ξεχωρίζετε τον όρχι από την επιδιδυμίδα κατά τη διάρκεια της ψηλάφησης. Η επιδιδυμίδα βρίσκεται πίσω και πάνω από τον όρχι και έχει σωληνώδη και πιο σκληρή -σαν \"σχοινί\"- υφή.","-",6));
			exams.add(new Exam("ΑΥΤΟΕΞΕΤΑΣΗ ΜΑΣΤΩΝ","0-120",3,2,"0-50",2,2,2,"Η ψηλάφηση πρέπει να γίνεται με την επιφάνεια των δακτύλων με κυκλικές κινήσεις σε όλη την επιφάνεια του μαστού. Αρχίζοντας από την κλείδα μέχρι τη βάση του μαστού και από τη μασχάλη μέχρι το στέρνο. Οι κινήσεις αυτές πρέπει στην αρχή να γίνονται με μικρή πίεση και στη συνέχεια με αρκετή πίεση. Σαπουνίστε καλά κάθε μαστό. Με το δεξί χέρι ψηλά, εξετάστε το δεξιό σας μαστό με το αριστερό σας χέρι. Στην συνέχεια κάντε το ίδιο για τον αριστερό σας μαστό με το δεξί σας χέρι. Παρατηρήστε αν υπάρχουν αλλαγές στους μαστούς σας (σχήμα, μέγεθος, δέρμα, συμμετρία, θηλές): 1) με τα χέρια κάτω, 2) με τα χέρια ψηλά πίσω από το κεφάλι, 3) με τα χέρια ενωμένα κάτω από το πηγούνι σας και σφίγγοντας συγχρόνως τους μυς του στήθους, και 4) σκύβοντας εμπρός με τους μαστούς να κρέμονται.Ξαπλώστε και τοποθετήστε μια διπλωμένη πετσέτα κάτω από την πλάτη σας και επαναλάβετε με κυκλικές κινήσεις και με την επιφάνεια των δακτύλων την εξέταση κάθε μαστού. Συμβουλευτείτε το γιατρό σας αν διαπιστώσετε οποιαδήποτε ανωμαλία.","askisi_nefro",6));
			exams.add(new Exam("ΜΑΣΤΟΓΡΑΦΙΑ","40-90",3,2,"0-50",1,1,1,"Είναι μια εξέταση των μαστών με ακτίνες Χ και η οποία σώζει ζωές! Μαζί με την κλινική εξέταση του μαστού, αποτελεί τον πιο αποτελεσματικό τρόπο για την ανίχνευση καρκίνου του μαστού ενώ τα τελευταία χρόνια έχει πετύχει τη μείωση της θνησιμότητας από τον καρκίνο του στήθους κατά 30 με 40%. Με ειδικό ακτινολογικό μηχάνημα μπορεί να εντοπίσει τον καρκίνο του μαστού σε πρώιμο στάδιο, πολύ πριν υπάρξει κλινικό εύρημα. Η εξέταση μπορεί να δείξει τις αλλαγές, όπως για παράδειγμα μικρούς όγκους, στο στήθος μιας γυναίκας πολύ πριν η ίδια ή ή το γιατρό της το καταλάβουν με την ψηλάφηση.","-",12));
			
			Exam selected_exam = null;
			String descr=null;
			
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
