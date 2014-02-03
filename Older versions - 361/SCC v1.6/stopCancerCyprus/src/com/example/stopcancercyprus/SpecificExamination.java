package com.example.stopcancercyprus;

import org.xml.sax.ContentHandler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class SpecificExamination extends Activity{

	ImageView myImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Bundle bundle=getIntent().getExtras();
		int examId=bundle.getInt("examId");

		switch(examId){
		case 0:
		case 1:
			
		}
	
		
		
		createAllObjects();
//		
//		final Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
//		final Animation zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);
//		myImage.setAnimation(zoomin);
//		myImage.setAnimation(zoomout);
//		
//		myImage.setOnClickListener(new OnClickListener(){
//            public void onClick(View v) {
//            	boolean pressed=false;
//            	
//                if(!pressed) {
//                    v.startAnimation(zoomin);
//                    pressed = !pressed;
//                } 
//                 {
//                    v.startAnimation(zoomout);
//                    pressed = !pressed;
//                }
//            }
//        });	
	}
	private void createAllObjects() {
		// TODO Auto-generated method stub
		myImage=(ImageView) findViewById(R.id.img);
}
}
