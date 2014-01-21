package com.example.mystopcancercyprus;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class GeneralInform extends Activity {

	Button Bexams;
	Button Bactiv;
	Button Bdiet;
	Button Bcancer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general);
		createAllObjects();
		
		Bexams.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Class ourClass = Class.forName("com.example.stopcancercyprus.ExaminationList");
					//triggered a class that user selected.
					Intent ourIntent = new Intent(GeneralInform.this, ourClass);
					startActivity(ourIntent);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
Bactiv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					Class ourClass = Class.forName("com.example.stopcancercyprus.ActivityList");
					//triggered a class that user selected.
					Intent ourIntent = new Intent(GeneralInform.this, ourClass);
					startActivity(ourIntent);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});

Bdiet.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		try {
			Class ourClass = Class.forName("com.example.stopcancercyprus.DietList");
			//triggered a class that user selected.
			Intent ourIntent = new Intent(GeneralInform.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
});

Bcancer.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		try {
			Class ourClass = Class.forName("com.example.stopcancercyprus.CancerList");
			//triggered a class that user selected.
			Intent ourIntent = new Intent(GeneralInform.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
});
	}

	private void createAllObjects() {
		// TODO Auto-generated method stub
		Bexams= (Button) findViewById(R.id.Bexam);
		Bactiv= (Button) findViewById(R.id.Bactiv);
		Bdiet= (Button) findViewById(R.id.Bdiet);
		Bcancer= (Button) findViewById(R.id.Bcancer);
	}
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
