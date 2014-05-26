package cy.ac.ucy.teamc.scc;

import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;
import android.content.Intent;

public class ExaminationList extends ListActivity {





	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		DatabaseManager db = DatabaseManager.getHelper(getApplicationContext());
		ArrayList<String> listOfChoices = db.getExamNamesonly();
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listOfChoices));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
			try {
				Class<?> ourClass = Class
						.forName("cy.ac.ucy.teamc.scc.ExamActivity");
				Intent ourIntent = new Intent(ExaminationList.this, ourClass);
				Bundle b = new Bundle();
				b.putInt("position", position); //Your id
				ourIntent.putExtras(b); //Put your id to your next Intent
				startActivity(ourIntent);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		

	}

}