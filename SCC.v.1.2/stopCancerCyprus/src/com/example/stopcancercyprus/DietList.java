package com.example.stopcancercyprus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;

public class DietList extends ListActivity{
	String listOfChoices[] = { "Διατροφή 1", "Διατροφή 2","Διατροφή 3", "Διατροφή 4", "Διατροφή 5", "Διατροφή 6","Διατροφή 7", "Διατροφή 8"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(DietList.this,
				android.R.layout.simple_list_item_1, listOfChoices));
	}

//	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
//		String choice=listOfChoices[position].replace(" ", "");
//		super.onListItemClick(l, v, position, id);

//		try {
//			Class ourClass = Class.forName("com.example.stopcancercyprus."+choice);
//			//triggered a class that user selected.
//			Intent ourIntent = new Intent(DietList.this, ourClass);
//			startActivity(ourIntent);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
}
