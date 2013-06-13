package com.example.flipkart;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.animation.TranslateAnimation;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class SearchPageListAdapter extends ArrayAdapter<BrowsePageListDetails>{
	Context context;	
	List<BrowsePageListDetails> mylist;
	int layout,checkbox_count=0;
	int lp=0;
	public SearchPageListAdapter(Context c,int res,List<BrowsePageListDetails> l){
		super(c,res,l);
		context=c;
		layout=res;
		mylist=l;
	}

	@Override
	public View getView(int position,View convertView,final ViewGroup parent) {			
		View view = convertView;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(layout, parent, false);
		}
		ImageView iv=(ImageView)view.findViewById(R.id.searchPage_imageitem);
		iv.setImageResource(mylist.get(position).getImg1());
		
		if(position>lp){
			TranslateAnimation animate2 = new TranslateAnimation(0,0,view.getHeight(),0);
			animate2.setDuration(500);
			view.startAnimation(animate2);}
			lp=position;
		return view;
	}
}
