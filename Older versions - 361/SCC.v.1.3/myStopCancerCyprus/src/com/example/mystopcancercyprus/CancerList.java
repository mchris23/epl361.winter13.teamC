package com.example.mystopcancercyprus;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CancerList extends ListActivity{
	String listOfChoices[] = { "Καρκίνος του μαστού", "Καρκίνος 2","Καρκίνος 3", "Καρκίνος 4", "Καρκίνος 5", "Καρκίνος 6","Καρκίνος 7", "Καρκίνος 8", "Καρκίνος 9"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(CancerList.this,
				android.R.layout.simple_list_item_1, listOfChoices));
	}

	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		try {
			Class ourClass = Class.forName("com.example.stopcancercyprus.SpecificCancer");
			//triggered a class that user selected.
			Intent ourIntent = new Intent(CancerList.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}
}
