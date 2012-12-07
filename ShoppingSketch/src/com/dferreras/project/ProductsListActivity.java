package com.dferreras.project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductsListActivity extends Activity implements OnItemClickListener, OnClickListener, OnTouchListener{

	ListView list;
	String elements[];
	Singleton singleton;
	MyAdapter mAdapter;
	//ScrollView dropSView;
	boolean toogle=false;
	LinearLayout dropSView;
	int currentY;
	View lastSelected;
	int lastColor;
	boolean animating=false;
	
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.productslist);
			
		dropSView=(LinearLayout) findViewById(R.id.dropDLayout);
		//dropSView.scrollTo(0, 600);
		ImageView lace=(ImageView) findViewById(R.id.imageLace);
		lace.setOnTouchListener(this);
		
		elements=getResources().getStringArray(R.array.items_array);
		
		list=(ListView) findViewById(R.id.listView1);
		
		mAdapter=new MyAdapter(this,elements , 0);
		list.setAdapter(mAdapter);
		list.setOnItemClickListener(this);
		
		singleton=Singleton.getInstance();
		singleton.screenIndex=0;
		
		TextView b=(TextView) findViewById(R.id.button3);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.button2);
		
		b.setBackgroundColor(Color.parseColor("#829080"));
		b.setTextColor(Color.parseColor("#232007"));
		

	}	
	
	public void animatePosition(int to, View v) {
    	ViewAnimator animator=new ViewAnimator(v, to, ViewAnimator.AnimationType.Y_ANIM , this);
    	animator.start();
    }
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(lastSelected!=null) {
			lastSelected.setBackgroundColor(lastColor);
			lastSelected=null;
		}
		if(singleton.screenIndex==1) {
			Intent intent=new Intent(ProductsListActivity.this , CalendarActivity.class );
			startActivity(intent);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		// TODO Auto-generated method stub
		
		singleton.itemSelected=position;
		lastColor=mAdapter.getNextColor(position);
		view.setBackgroundColor(Color.WHITE);
		lastSelected=view;
		Intent intent=new Intent(ProductsListActivity.this , ItemActivity.class);
		startActivity(intent);
		Log.d("LIST", ""+position);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
			singleton.screenIndex=1;
			Intent intent=new Intent(ProductsListActivity.this , CalendarActivity.class );
			startActivity(intent);
		
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
	        case MotionEvent.ACTION_DOWN: {
	            currentY = (int) event.getRawY();
	            break;
	        }
	
	        case MotionEvent.ACTION_MOVE: {
	            int y2 = (int) event.getRawY();
	            dropSView.scrollBy(0, currentY - y2);
	            currentY = y2;
	            break;
	        }   
	        case MotionEvent.ACTION_UP: {
	        	if(!toogle) {
					//dropSView.setVisibility(View.INVISIBLE);
					animatePosition(600,dropSView);
					toogle=true;
				}else{
					animatePosition( 0,dropSView);
					toogle=false;
				}
	            break;
	        }
	    }

		return true;
	}

}
