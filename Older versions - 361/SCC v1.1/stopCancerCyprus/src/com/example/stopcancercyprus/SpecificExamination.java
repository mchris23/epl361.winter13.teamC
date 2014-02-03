package com.example.stopcancercyprus;

import com.example.stopcancercyprus.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class SpecificExamination extends Activity{

	ImageView myImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.examination_orchis);
		
		createAllObjects();
		
		final Animation zoomin = AnimationUtils.loadAnimation(this, R.anim.zoomin);
		final Animation zoomout = AnimationUtils.loadAnimation(this, R.anim.zoomout);
		myImage.setAnimation(zoomin);
		myImage.setAnimation(zoomout);
		
		myImage.setOnClickListener(new OnClickListener(){
            public void onClick(View v) {
            	boolean pressed=false;
            	
                if(!pressed) {
                    v.startAnimation(zoomin);
                    pressed = !pressed;
                } 
                 {
                    v.startAnimation(zoomout);
                    pressed = !pressed;
                }
            }
        });	
	}
	private void createAllObjects() {
		// TODO Auto-generated method stub
		myImage=(ImageView) findViewById(R.id.img);
}
}
