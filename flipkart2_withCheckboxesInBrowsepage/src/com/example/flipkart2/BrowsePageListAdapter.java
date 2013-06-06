package com.example.flipkart2;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;

public class BrowsePageListAdapter extends ArrayAdapter<BrowsePageListDetails>{
	Activity activity;	
	List<BrowsePageListDetails> mylist;
	int layout,checkbox_count=0,last_popup=-1;
	int checkedArray[];
	View tempv;
	public BrowsePageListAdapter(Activity activity,int res,List<BrowsePageListDetails> l){
		super(activity,res,l);
		this.activity = activity;
		layout=res;
		mylist=l;
		checkedArray=new int[100];
	}
	@Override
	public View getView(final int position,View convertView,ViewGroup parent){
		View view=convertView;
		if (view == null) {
			view = LayoutInflater.from(activity).inflate(layout, parent, false);
		}
		ImageView iv=(ImageView)view.findViewById(R.id.imageitem);int u=0;
		iv.setImageResource(mylist.get(position).getImg1());
		//new code for image  cb
		final ImageButton cb=(ImageButton)view.findViewById(R.id.cb);
		if(checkedArray[position]==1)
			cb.setImageResource(R.drawable.cb_highligted);
		else cb.setImageResource(R.drawable.cb_normal);	
		cb.setOnClickListener(new OnClickListener() {			 
            public void onClick(View v) {
            	ImageView bottombar=(ImageView)activity.findViewById(R.id.filter_bar);
        		ImageView bottombarContextual=(ImageView)activity.findViewById(R.id.filter_bar_contextual);
        		
            	//if(cb.isChecked()){
            	if(checkedArray[position]==0){
            		checkedArray[position]=1;
        			checkbox_count++; 
        			cb.setImageResource(R.drawable.cb_highligted);
            		//ImageView bottombar=(ImageView)activity.findViewById(R.id.filter_bar);
            		//ImageView bottombarContextual=(ImageView)activity.findViewById(R.id.filter_bar_contextual);
            		if(checkbox_count==1){
            		TranslateAnimation animate1 = new TranslateAnimation(0,0,0, bottombar.getHeight());
    				animate1.setDuration(500);    				
    				TranslateAnimation animate2 = new TranslateAnimation(0,0,bottombar.getHeight(),0);
    				animate2.setDuration(500);    				
    				bottombar.startAnimation(animate1);		
    				bottombarContextual.startAnimation(animate2);
    				bottombar.setVisibility(View.INVISIBLE);
    				bottombarContextual.setVisibility(View.VISIBLE);
            		}
					//bottombar.setImageResource(R.drawable.browsepage_contextual_bottombar);		
						checkedArray[position]=1;
            	}
            	else{
            		checkbox_count--;
					checkedArray[position]=0;
					cb.setImageResource(R.drawable.cb_normal);
					if(checkbox_count==0){		
						//ImageView bottombar=(ImageView)activity.findViewById(R.id.filter_bar);						
						TranslateAnimation animate1 = new TranslateAnimation(0,0, bottombar.getHeight(),0);
	    				animate1.setDuration(500);    				
	    				TranslateAnimation animate2 = new TranslateAnimation(0,0,0,bottombar.getHeight());
	    				animate2.setDuration(500);    				
	    				bottombar.startAnimation(animate1);		
	    				bottombarContextual.startAnimation(animate2);
	    				bottombar.setVisibility(View.VISIBLE);
	    				bottombarContextual.setVisibility(View.INVISIBLE);
						//bottombar.setImageResource(R.drawable.filter_bottom);	
					}
            	}
            }
        });
		/*final CheckBox cb=(CheckBox)view.findViewById(R.id.checkbox_browsepage);
		if(checkedArray[position]==1)
			cb.setChecked(true);
		else cb.setChecked(false);	
		cb.setOnClickListener(new OnClickListener() {			 
            public void onClick(View v) {
            	ImageView bottombar=(ImageView)activity.findViewById(R.id.filter_bar);
        		ImageView bottombarContextual=(ImageView)activity.findViewById(R.id.filter_bar_contextual);
        		
            	if(cb.isChecked()){
            		checkbox_count++; 
            		//ImageView bottombar=(ImageView)activity.findViewById(R.id.filter_bar);
            		//ImageView bottombarContextual=(ImageView)activity.findViewById(R.id.filter_bar_contextual);
            		if(checkbox_count==1){
            		TranslateAnimation animate1 = new TranslateAnimation(0,0,0, bottombar.getHeight());
    				animate1.setDuration(500);    				
    				TranslateAnimation animate2 = new TranslateAnimation(0,0,bottombar.getHeight(),0);
    				animate2.setDuration(500);    				
    				bottombar.startAnimation(animate1);		
    				bottombarContextual.startAnimation(animate2);
    				bottombar.setVisibility(View.INVISIBLE);
    				bottombarContextual.setVisibility(View.VISIBLE);
            		}
					//bottombar.setImageResource(R.drawable.browsepage_contextual_bottombar);		
						checkedArray[position]=1;
            	}
            	else{
            		checkbox_count--;
					checkedArray[position]=0;
					if(checkbox_count==0){		
						//ImageView bottombar=(ImageView)activity.findViewById(R.id.filter_bar);						
						TranslateAnimation animate1 = new TranslateAnimation(0,0, bottombar.getHeight(),0);
	    				animate1.setDuration(500);    				
	    				TranslateAnimation animate2 = new TranslateAnimation(0,0,0,bottombar.getHeight());
	    				animate2.setDuration(500);    				
	    				bottombar.startAnimation(animate1);		
	    				bottombarContextual.startAnimation(animate2);
	    				bottombar.setVisibility(View.VISIBLE);
	    				bottombarContextual.setVisibility(View.INVISIBLE);
						//bottombar.setImageResource(R.drawable.filter_bottom);	
					}
            	}
            }
        });*/
		return view;
	}

}
