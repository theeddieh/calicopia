package com.dferreras.project;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter{

	Context mContext;
	String elements[];
	int startR,startG,startB,endR,endG,endB;
	
	public MyAdapter(Context context, String elements[], int type){
		mContext=context;
		this.elements=elements;
		if(type==0) {
			startR = 29;
			startG = 154;
			startB = 153;
			endR = 205;
			endG = 227;
			endB = 230;
		}else{
			startR = 241;
			startG = 237;
			startB = 212;
			endR = 186;
			endG = 179;
			endB = 165;
		}
	}
	
	public int getNextColor(int position) {
		int color;
		int pR=startR +(endR-startR)*position/(elements.length-1);
		int pG=startG +(endG-startG)*position/(elements.length-1);
		int pB=startB +(endB-startB)*position/(elements.length-1);
		color=Color.rgb(pR, pG, pB);
		//Log.d("COLOR", startR+" "+pR + " " + endR);
		return color;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return elements.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		LinearLayout layout=new LinearLayout(mContext);
		layout.setOrientation(LinearLayout.VERTICAL);
		layout.setPadding(10, 10, 10, 10);
		layout.setBackgroundColor(getNextColor(position));
		
		TextView text=new TextView(mContext);
		text.setText(elements[position].toUpperCase());
		text.setTextSize(16);
		text.setTextColor(Color.parseColor("#151B54")); 
			
		text.setLayoutParams(new AbsListView.LayoutParams(LayoutParams.FILL_PARENT , LayoutParams.WRAP_CONTENT));
		text.setGravity(Gravity.LEFT);
		text.setPadding(5, 40, 0, 40);
	
		layout.addView(text);
		
		return layout;
	}
}
