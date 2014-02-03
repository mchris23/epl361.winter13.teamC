package com.example.stopcancercyprus;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;
import android.content.Intent;

public class ExaminationList extends ListActivity {

	private String[] listOfChoise = { "Αυτοεξέταση όρχεων", "Αυτοεξέταση μαστού",
			"Τεστ Παπανικολάου", "Κολονοσκόπιση", "Εξέταση κοπράνων","Εξετάσεις αίματος" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOfChoise));
//		listView = (ListView) findViewById(R.id.examlist);
//		
//
//		adapter = new ArrayAdapter<String>(this,
//			 android.R.layout.simple_list_item_1, listOfChoise);
//
//		// Assign adapter to ListView
//		listView.setAdapter(adapter);
//
//		// ListView Item Click Listener
//		listView.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
			if (position==0) {
				try{
					Class<?> ourClass=Class.forName("com.example.stopcancercyprus.ExamTesticles");
					Intent ourIntent=new Intent(ExaminationList.this, ourClass);
					startActivity(ourIntent);
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			else
				if (position==1){
					try{
						Class<?> ourClass=Class.forName("com.example.stopcancercyprus.ExamBreast");
						Intent ourIntent=new Intent(ExaminationList.this, ourClass);
						startActivity(ourIntent);
					}catch(ClassNotFoundException e){
						e.printStackTrace();
					}
				}
				else
					if (position==2){
						try{
							Class<?> ourClass=Class.forName("com.example.stopcancercyprus.ExamPap");
							Intent ourIntent=new Intent(ExaminationList.this, ourClass);
							startActivity(ourIntent);
						}catch(ClassNotFoundException e){
							e.printStackTrace();
						}
					}
					else
						if (position==3){
							try{
								Class<?> ourClass=Class.forName("com.example.stopcancercyprus.ExamColonoscopy");
								Intent ourIntent=new Intent(ExaminationList.this, ourClass);
								startActivity(ourIntent);
							}catch(ClassNotFoundException e){
								e.printStackTrace();
							}
						}
						else
							if (position==4){
								try{
									Class<?> ourClass=Class.forName("com.example.stopcancercyprus.ExamStool");
									Intent ourIntent=new Intent(ExaminationList.this, ourClass);
									startActivity(ourIntent);
								}catch(ClassNotFoundException e){
									e.printStackTrace();
								}
							}
							else
								if (position==5){
									try{
										Class<?> ourClass=Class.forName("com.example.stopcancercyprus.ExamBlood");
										Intent ourIntent=new Intent(ExaminationList.this, ourClass);
										startActivity(ourIntent);
									}catch(ClassNotFoundException e){
										e.printStackTrace();
									}
								}
				}

}
