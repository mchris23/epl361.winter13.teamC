package com.example.mystopcancercyprus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;

public class ActivityList extends ListActivity{
	String listOfChoices[] = { "Ασκηση 1", "Ασκηση 2","Ασκηση 3", "Ασκηση 4", "Ασκηση 5", "Ασκηση 6","Ασκηση 7", "Ασκηση 8"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(ActivityList.this,
				android.R.layout.simple_list_item_1, listOfChoices));
	}

//	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
//		String choice=listOfChoices[position].replace(" ", "");
//		super.onListItemClick(l, v, position, id);

//		try {
//			Class ourClass = Class.forName("com.example.stopcancercyprus."+choice);
//			//triggered a class that user selected.
//			Intent ourIntent = new Intent(ActivityList.this, ourClass);
//			startActivity(ourIntent);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
}
