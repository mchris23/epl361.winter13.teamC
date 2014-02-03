package com.example.stopcancercyprus;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageAdapter extends BaseAdapter {

	private Context context;
	public ImageAdapter(Context context) {
		// TODO Auto-generated constructor stub
		this.context=context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageIds.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		ImageView imageView;
		
		if(convertView==null){
			imageView=new ImageView(context);
			imageView.setPadding(8, 8, 8, 8);
			imageView.setLayoutParams(new GridView.LayoutParams(90,90));
			imageView.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent=new Intent(context,MyImageActivity.class);
					intent.putExtra("imgId", imageIds[position]);
					context.startActivity(intent);
					Toast.makeText(context,Integer.toString(position), Toast.LENGTH_SHORT).show();
				}
			});
		}
		else{
			imageView=(ImageView)convertView;
		}
		
		imageView.setImageResource(imageIds[position]);
		return imageView;
	}

	private Integer [] imageIds={
			R.drawable.blue,
			R.drawable.ic_launcher,
			R.drawable.ic_launcher2,
			R.drawable.karkinos,
			R.drawable.mancancer,
			R.drawable.pasikaf,
			R.drawable.wallpaper
	};
}
