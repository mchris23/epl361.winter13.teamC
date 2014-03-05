package cy.ac.ucy.teamc.scc;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class CancerActivity extends Activity{
	
	TextView name;
	TextView description;
	ListView relatedExams;
	ArrayList<String>cNameDescr;
	ArrayList<String>relEx;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle b = getIntent().getExtras();
		int id = b.getInt("position");
		id++;
		DatabaseManager db = DatabaseManager.getHelper(getApplicationContext());
		cNameDescr=db.getCancerNameDescription(id);
		relEx=db.getRelatedExamsFromCancer(new Cancer(id,null,null));
		
setContentView(R.layout.cancer_view);
		
		createAllObjects();
		name.setText(cNameDescr.get(0));
		description.setText(cNameDescr.get(1));
		relatedExams.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, relEx));
		//Add contents accordingly,get from database
		//setContentView(R.layout.cancer_mastos);
		
	}

	private void createAllObjects() {
		// TODO Auto-generated method stub
		name= (TextView) findViewById(R.id.CancerName);
		description= (TextView) findViewById(R.id.CancerDescription);
		relatedExams= (ListView) findViewById(R.id.RelatedExams);
	}
}
