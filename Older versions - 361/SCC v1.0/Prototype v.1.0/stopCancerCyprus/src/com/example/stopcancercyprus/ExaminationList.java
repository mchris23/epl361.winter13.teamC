package com.example.stopcancercyprus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;

public class ExaminationList extends ListActivity{
	String listOfChoices[] = { "�������� ��� ������ - ���������", "������� 2","������� 3", "������� 4", "������� 5", "������� 6","������� 7", "������� 8"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(ExaminationList.this,
				android.R.layout.simple_list_item_1, listOfChoices));
	}

	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		try {
			Class ourClass = Class.forName("com.example.stopcancercyprus.SpecificExamination");
			//triggered a class that user selected.
			Intent ourIntent = new Intent(ExaminationList.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
	}
}
