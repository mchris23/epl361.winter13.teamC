package com.example.stopcancercyprus;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity {

	String listOfChoices[] = { "General Inform", "Personal Inform","3", "4", "5", "6","3", "4", "5", "6" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(Menu.this,
				android.R.layout.simple_list_item_1, listOfChoices));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		String choice=listOfChoices[position].replace(" ", "");
		super.onListItemClick(l, v, position, id);

		try {
			Class ourClass = Class.forName("com.example.stopcancercyprus."+choice);
			//triggered a class that user selected.
			Intent ourIntent = new Intent(Menu.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
