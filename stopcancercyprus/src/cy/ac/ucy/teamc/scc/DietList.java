package cy.ac.ucy.teamc.scc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;

public class DietList extends ListActivity{
	private String listOfChoices[] = { "Διατροφή - Καρκίνος του μαστού","Διατροφή - Καρκίνος του προστάτη","Διατροφή - Καρκίνος του παχέος εντέρου"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(DietList.this,
				android.R.layout.simple_list_item_1, listOfChoices));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
			if (position==0) {
				try{
					Class<?> ourClass=Class.forName("com.example.stopcancercyprus.DietBreast");
					Intent ourIntent=new Intent(DietList.this, ourClass);
					startActivity(ourIntent);
				}catch(ClassNotFoundException e){
					e.printStackTrace();
				}
			}
			else
				if (position==1){
					try{
						Class<?> ourClass=Class.forName("com.example.stopcancercyprus.DietProstate");
						Intent ourIntent=new Intent(DietList.this, ourClass);
						startActivity(ourIntent);
					}catch(ClassNotFoundException e){
						e.printStackTrace();
					}
				}
				else
					if (position==2){
						try{
							Class<?> ourClass=Class.forName("com.example.stopcancercyprus.DietRectum");
							Intent ourIntent=new Intent(DietList.this, ourClass);
							startActivity(ourIntent);
						}catch(ClassNotFoundException e){
							e.printStackTrace();
						}
					}
				}
}