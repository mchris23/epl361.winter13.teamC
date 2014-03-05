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
					String str="";
					switch (position){
					case 0: str="����������� �������� ��� ������"; break;
					case 1: str="�������� ��� �������� ��� ������"; break;
					case 2:  str="�������� ��� ������ �������"; break;
					case 3: str="K������� ��� ������"; break;
					case 4: str="����������� �������� ��� ������"; break;
					case 5: str="������� �������� ��� ������"; break;
					case 6: str="����������� �������� ��� ������"; break;
					case 7: str="�������������"; break;
					case 8: str="���� ������������"; break;
					case 9: str="�������� ���������"; break;
					case 10: str="K������� ��� ��������"; break;
					case 11: str="�������� �������"; break;
					}					
					Toast.makeText(context,str, Toast.LENGTH_SHORT).show();
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
			R.drawable.cancer_traxilou_mitras,
			R.drawable.breastself_exam,
			R.drawable.paxientero
	};
}
