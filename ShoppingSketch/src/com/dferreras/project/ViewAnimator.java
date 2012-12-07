package com.dferreras.project;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class ViewAnimator extends Thread{

	public enum AnimationType {X_ANIM,Y_ANIM, HEIGHT_ANIM}


	private static final String tag = "VIEW_ANIMATOR";
	
	
	private View v;
	private int to;
	private AnimationType aType;
	private Activity pActivity;

	public int increment=40;
	public static int interval=20;
	
	public ViewAnimator(View v,int to, AnimationType type, Activity parentActivity) {
		this.v=v;
		this.to=to;
		this.aType=type;
		pActivity=parentActivity;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(aType==AnimationType.Y_ANIM) {
			int from=v.getScrollY();
			
			if(from>to) increment=-increment;
			
			while(from!=to) {
				from+=increment;
				
				if(Math.abs(to-from)<Math.abs(increment)) from=to;
				
				final int y=from;
				Log.d(tag, y+"");
				pActivity.runOnUiThread(new Runnable() {
	        		public void run() {
	        			v.scrollTo(0, y);
	        		}
				});
				
				try {
					this.sleep(interval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if(aType==AnimationType.HEIGHT_ANIM) {
			int from=v.getHeight();
			int w=v.getWidth();
			if(from>to) increment=-increment;
			
			while(from!=to) {
				from+=increment;
				
				if(Math.abs(to-from)<Math.abs(increment)) from=to;
				
				final LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(w, from);
				Log.d(tag, from+"");
				pActivity.runOnUiThread(new Runnable() {
	        		public void run() {
	        			v.setLayoutParams(layoutParams);
	        		}
				});
				
				try {
					this.sleep(interval);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
