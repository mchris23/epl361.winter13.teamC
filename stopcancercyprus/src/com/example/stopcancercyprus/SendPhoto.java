package com.example.stopcancercyprus;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

import android.app.Activity;
import android.os.Bundle;


public class SendPhoto extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        try{
        TouchImageView img = (TouchImageView) findViewById(R.id.img);
        img.setMaxZoom(4);
        }catch(Exception e){
        	Log.e("ERROR_IMAGE_EXCEPTION",e.getMessage());
        }
    }
}