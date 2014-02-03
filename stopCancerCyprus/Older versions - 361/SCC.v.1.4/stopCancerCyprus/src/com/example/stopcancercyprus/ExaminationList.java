package com.example.stopcancercyprus;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

public class ExaminationList extends Activity {

	private ListView listView;
	private ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.exam_list);
		listView = (ListView) findViewById(R.id.examlist);
		String[] listOfChoise = { "Αυτοεξέταση όρχεων", "Κολονοσκόπιση",
				"Τεστ Παπανικολάου", "4", "5", "6", "7", "8" };

		adapter = new ArrayAdapter<String>(this,
			 android.R.layout.simple_list_item_1, listOfChoise);

		// Assign adapter to ListView
		listView.setAdapter(adapter);

		// ListView Item Click Listener
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				if (position==0) 
					setContentView(R.layout.examination_orchis);
				else
					if (position==1)
						setContentView(R.layout.cancer_mastos);
					else
						if (position==2)
							setContentView(R.layout.examination_paptest);
						else
							if (position==3)
								setContentView(R.layout.cancer_mastos);
							else
								if (position==4)
									setContentView(R.layout.cancer_mastos);
								else
									if (position==5)
										setContentView(R.layout.cancer_mastos);
				
					
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.layout.exam_list, menu);
		return true;
	}

	// protected void onListItemClick(ListView l, View v, int position, long id)
	// {
	// // TODO Auto-generated method stub
	//
	// try {
	// Intent intent=new Intent(this, SpecificExamination.class);
	// intent.putExtra("examId", listOfChoices[position]);
	// startActivity(intent);
	// } catch (ActivityNotFoundException e) {
	// e.printStackTrace();
	// }
	//
	//
	// }

}
