package com.example.stopcancercyprus;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CancerList extends ListActivity{
//
//	private ListView listView;
//	private ArrayAdapter<String> adapter;
	private String[] listOfChoise = { "Καρκίνος του προστάτη","Καρκίνος του μαστού","Καρκίνος του δέρματος","Καρκίνος του παχέος εντέρου",
	"Καρκίνος του τραχίλου της μήτρας","Καρκίνος των ωοθηκών","Καρκίνος του παγκρέατος"};
	
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
						Class<?> ourClass=Class.forName("com.example.stopcancercyprus.CancerProstate");
						Intent ourIntent=new Intent(CancerList.this, ourClass);;
						String key = null;
						ourIntent.putExtra("CancerActivity.ctitle[0]",key);
						startActivity(ourIntent);
					}catch(ClassNotFoundException e){
						e.printStackTrace();
					}
				}
				else
					if (position==1){
						try{
							Class<?> ourClass=Class.forName("com.example.stopcancercyprus.CancerActivity");
							Intent ourIntent=new Intent(CancerList.this, ourClass);;
							String key = null;
							ourIntent.putExtra("CancerActivity.ctitle[0]",key);
							startActivity(ourIntent);
						}catch(ClassNotFoundException e){
							e.printStackTrace();
						}
					}
					else
						if (position==2){
							try{
								Class<?> ourClass=Class.forName("com.example.stopcancercyprus.CancerSkin");
								Intent ourIntent=new Intent(CancerList.this, ourClass);
								startActivity(ourIntent);
							}catch(ClassNotFoundException e){
								e.printStackTrace();
							}
						}
						else
							if (position==3){
								try{
									Class<?> ourClass=Class.forName("com.example.stopcancercyprus.CancerRectum");
									Intent ourIntent=new Intent(CancerList.this, ourClass);
									startActivity(ourIntent);
								}catch(ClassNotFoundException e){
									e.printStackTrace();
								}
							}
							else
								if (position==4)
								{
									try{
										Class<?> ourClass=Class.forName("com.example.stopcancercyprus.CancerUterus");
										Intent ourIntent=new Intent(CancerList.this, ourClass);
										startActivity(ourIntent);
									}catch(ClassNotFoundException e){
										e.printStackTrace();
									}
								}
								else
									if (position==5)
									{
										try{
											Class<?> ourClass=Class.forName("com.example.stopcancercyprus.CancerOvarian");
											Intent ourIntent=new Intent(CancerList.this, ourClass);
											startActivity(ourIntent);
										}catch(ClassNotFoundException e){
											e.printStackTrace();
										}
									}
									else
										if (position==6)
										{
											try{
												Class<?> ourClass=Class.forName("com.example.stopcancercyprus.CancerPangkreas");
												Intent ourIntent=new Intent(CancerList.this, ourClass);
												startActivity(ourIntent);
											}catch(ClassNotFoundException e){
												e.printStackTrace();
											}
										}

					
				}

}