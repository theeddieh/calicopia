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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalendarActivity extends Activity implements OnClickListener, OnTouchListener{
	
	Singleton singleton;
	
	boolean toogle=true;
	LinearLayout dropSView;
	int currentY;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calendar);
		
		singleton=Singleton.getInstance();
		
		dropSView=(LinearLayout) findViewById(R.id.dropDLayout);
		dropSView.scrollTo(0, 600);
		ImageView lace=(ImageView) findViewById(R.id.imageLace);
		lace.setOnTouchListener(this);
		
		TextView b=(TextView) findViewById(R.id.button2);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.button3);
		b.setBackgroundColor(Color.parseColor("#829080"));
		b.setTextColor(Color.parseColor("#232007"));
		
		
		b=(TextView) findViewById(R.id.b1);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b2);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b3);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b4);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b5);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b6);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b7);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b8);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b9);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b10);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b11);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.b12);
		b.setOnClickListener(this);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(singleton.screenIndex==0) this.finish();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		singleton.screenIndex=0;
		this.finish();
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.button2) {
			singleton.screenIndex=0;
			this.finish();
		}else {
			switch(v.getId()) {
			
			case R.id.b1: singleton.monthSelected=1; break;
			case R.id.b2: singleton.monthSelected=2; break;
			case R.id.b3: singleton.monthSelected=3; break;
			case R.id.b4: singleton.monthSelected=4; break;
			case R.id.b5: singleton.monthSelected=5; break;
			case R.id.b6: singleton.monthSelected=6; break;
			case R.id.b7: singleton.monthSelected=7; break;
			case R.id.b8: singleton.monthSelected=8; break;
			case R.id.b9: singleton.monthSelected=9; break;
			case R.id.b10: singleton.monthSelected=10; break;
			case R.id.b11: singleton.monthSelected=11; break;
			case R.id.b12: singleton.monthSelected=12; break;
				
			}
			Intent intent=new Intent(CalendarActivity.this , MonthDetailActivity.class);
			startActivity(intent);
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
