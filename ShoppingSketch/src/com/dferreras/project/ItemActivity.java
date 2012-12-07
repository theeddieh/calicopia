package com.dferreras.project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends Activity implements OnClickListener, OnTouchListener{

	Singleton singleton;
	TextView tNut,tCho,tSto,tVar;
	boolean toogle=true;
	LinearLayout dropSView;
	int currentY;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item);
		singleton=Singleton.getInstance();
		
		dropSView=(LinearLayout) findViewById(R.id.dropDLayout);
		dropSView.scrollTo(0, 600);
		ImageView lace=(ImageView) findViewById(R.id.imageLace);
		lace.setOnTouchListener(this);
				
		TextView title=(TextView) findViewById(R.id.textView1);
		String elements[]=getResources().getStringArray(R.array.items_array);
		
		// Use this name to get data from App Engine
		String produce = elements[singleton.itemSelected].toUpperCase();
		
		title.setText(produce);
		
		String sNut = singleton.getFoods().get(singleton.itemSelected).getNutrition();
		String sCho= singleton.getFoods().get(singleton.itemSelected).getFreshness();
		String sSto = singleton.getFoods().get(singleton.itemSelected).getStorage();
		String sVar= singleton.getFoods().get(singleton.itemSelected).getVarieties();
		
		//sNut = answer.toString();
        
        tNut=(TextView) findViewById(R.id.textViewNut);
		tNut.setVisibility(View.VISIBLE);
		tNut.setText(sNut);
		
		
		tCho=(TextView) findViewById(R.id.textViewCho);
		tCho.setText(sCho);
		tCho.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 0));
		
		tSto=(TextView) findViewById(R.id.textViewSto);
		tSto.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 0));
		tSto.setText(sSto);
		
		tVar=(TextView) findViewById(R.id.textViewVar);
		tVar.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 0));
		tVar.setText(sVar);
		
		TextView b=(TextView) findViewById(R.id.bNut);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.bCho);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.bSto);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.bVar);
		b.setOnClickListener(this);
		
		b=(TextView) findViewById(R.id.button2);
		b.setOnClickListener(this);
		if(singleton.screenIndex==0){
			b.setBackgroundColor(Color.parseColor("#829080"));
			b.setTextColor(Color.parseColor("#232007"));
		}
		
		b=(TextView) findViewById(R.id.button3);
		b.setOnClickListener(this);
		if(singleton.screenIndex!=0) {
			b.setBackgroundColor(Color.parseColor("#829080"));
			b.setTextColor(Color.parseColor("#232007"));
		}
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()) {
		case R.id.bNut:
			if(tNut.getHeight()==0) tNut.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			else animateHeight(0, tNut);
			break;
		case R.id.bSto:
			if(tSto.getHeight()==0) tSto.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			else animateHeight(0, tSto);
			break;
		case R.id.bCho:
			if(tCho.getHeight()==0) tCho.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			else animateHeight(0, tCho);
			break;
		case R.id.bVar:
			if(tVar.getHeight()==0) tVar.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			else animateHeight(0, tVar);
			break;
		case R.id.button2:
			singleton.screenIndex=0;
			this.finish();
			break;
		case R.id.button3:
			singleton.screenIndex=1;
			this.finish();
			break;
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
	
	public void animateHeight(int to , View v) {
		ViewAnimator animator=new ViewAnimator(v,to,ViewAnimator.AnimationType.HEIGHT_ANIM,this);
		animator.start();
	}

	

}
