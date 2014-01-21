package com.example.stopcancercyprus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.app.ListActivity;

public class ActivityList extends ListActivity{

	private String[] listOfChoise = { "Προληπτική άσκηση για το καρκίνο του μαστού", "Προληπτική άσκηση για το καρκίνο των νεφρών",
	"Προληπτική άσκηση για το καρκίνο του παχέως εντέρου"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listOfChoise));

	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
			if (position==0) {
				try{
					Class<?> ourClass=Class.forName("com.example.stopcancercyprus.ActivityBreast");
					Intent ourIntent=new Intent(ActivityList.this, ourClass);
					startActivity(ourIntent);
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			else
				if (position==1){
					try{
						Class<?> ourClass=Class.forName("com.example.stopcancercyprus.ActivityKidney");
						Intent ourIntent=new Intent(ActivityList.this, ourClass);
						startActivity(ourIntent);
					}catch(ClassNotFoundException e){
						e.printStackTrace();
					}
				}
				else
					if (position==2){
						try{
							Class<?> ourClass=Class.forName("com.example.stopcancercyprus.ActivityRectum");
							Intent ourIntent=new Intent(ActivityList.this, ourClass);
							startActivity(ourIntent);
						}catch(ClassNotFoundException e){
							e.printStackTrace();
						}
					}
				}

}
