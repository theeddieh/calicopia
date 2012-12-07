package com.dferreras.project;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MonthDetailActivity extends Activity implements OnItemClickListener, OnClickListener, OnTouchListener{
	
	ListView list;
	String elements[];
	String tempElements[];
	Singleton singleton;
	MyAdapter mAdapter;
	
	boolean toogle=true;
	LinearLayout dropSView;
	int currentY;
	
	View lastSelected;
	int lastColor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.monthdetail);
		
		dropSView=(LinearLayout) findViewById(R.id.dropDLayout);
		dropSView.scrollTo(0, 600);
		ImageView lace=(ImageView) findViewById(R.id.imageLace);
		lace.setOnTouchListener(this);
		
		elements = getResources().getStringArray(R.array.items_array);
				
		//Arrays.contains(singleton.getFoods().get(i).getMonths())
		

		list=(ListView) findViewById(R.id.listView1);
		
		mAdapter=new MyAdapter(this,elements , 1);
		list.setAdapter(mAdapter);
		list.setOnItemClickListener(this);
		
		singleton=Singleton.getInstance();
		
		TextView b=(TextView) findViewById(R.id.button2 );
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.button3);
		b.setOnClickListener(this);
		b.setBackgroundColor(Color.parseColor("#829080"));
		b.setTextColor(Color.parseColor("#232007"));
		
		setTitle();
	}
	
	private void setTitle() {
		TextView title=(TextView) findViewById(R.id.textView1);
		switch(singleton.monthSelected) {
		case 1:
			title.setBackgroundColor(Color.parseColor("#94b734"));
			title.setText("MARCH");
			break;
		case 2:
			title.setBackgroundColor(Color.parseColor("#7ead38"));
			title.setText("APRIL");
			break;
		case 3:
			title.setBackgroundColor(Color.parseColor("#72ab61"));
			title.setText("MAY");
			break;
		case 4:
			title.setBackgroundColor(Color.parseColor("#be0040"));
			title.setText("JUNE");
			break;
		case 5:
			title.setBackgroundColor(Color.parseColor("#ab013d"));
			title.setText("JULY");
			break;
		case 6:
			title.setBackgroundColor(Color.parseColor("#8b1235"));
			title.setText("AUGUST");
			break;
		case 7:
			title.setBackgroundColor(Color.parseColor("#f7ef73"));
			title.setText("SEPTEMBER");
			break;
		case 8:
			title.setBackgroundColor(Color.parseColor("#f6eb48"));
			title.setText("OCTOBER");
			break;
		case 9:
			title.setBackgroundColor(Color.parseColor("#f1d001"));
			title.setText("NOVEMBER");
			break;
		case 10:
			title.setBackgroundColor(Color.parseColor("#a6cccc"));
			title.setText("DECEMBER");
			break;
		case 11:
			title.setBackgroundColor(Color.parseColor("#79b4af"));
			title.setText("JANUARY");
			break;
		case 12:
			title.setBackgroundColor(Color.parseColor("#1d9a99"));
			title.setText("FEBRUARY");
			break;
		}
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(lastSelected!=null) {
			lastSelected.setBackgroundColor(lastColor);
			lastSelected=null;
		}
		if(singleton.screenIndex==0) this.finish();
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		// TODO Auto-generated method stub
		
		singleton.itemSelected=position;
		lastColor=mAdapter.getNextColor(position);
		view.setBackgroundColor(Color.WHITE);
		lastSelected=view;
		Intent intent=new Intent(MonthDetailActivity.this , ItemActivity.class);
		startActivity(intent);
		Log.d("LIST", ""+position);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button3) {
			singleton.screenIndex=1;
			this.finish();
		}else {
			singleton.screenIndex=0;
			this.finish();
		}
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
	
	public void animatePosition(int to, View v) {
    	ViewAnimator animator=new ViewAnimator(v, to, ViewAnimator.AnimationType.Y_ANIM , this);
    	animator.start();
    }

}
