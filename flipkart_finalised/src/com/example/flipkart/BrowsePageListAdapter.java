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

public class BrowsePageListAdapter extends ArrayAdapter<BrowsePageListDetails>{
	Context context;	
	List<BrowsePageListDetails> mylist;
	ListView lv;
	int layout,checkbox_count=0;
	int lp=0;
	View last_popup = null;
	int popup_Array[],checkedArray[];
	View tempv;
	public BrowsePageListAdapter(Context c,int res,List<BrowsePageListDetails> l,ListView lv){
		super(c,res,l);
		context=c;
		layout=res;
		mylist=l;
		this.lv=lv;
		popup_Array=new int[100];
		checkedArray=new int[100];
	}

	//popup image getView(Without checkboxes)
	@Override
	public View getView(final int position,View convertView,final ViewGroup parent) {	
		
		View view = convertView;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(layout, parent, false);
		}
		final ImageView browse_page_popup;
		ImageView iv=(ImageView)view.findViewById(R.id.imageitem);
		iv.setImageResource(mylist.get(position).getImg1());
		Button popup=(Button)view.findViewById(R.id.browse_page_popup_button);			
		browse_page_popup=(ImageView)view.findViewById(R.id.browse_page_popup);						
		browse_page_popup.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				System.out.println("popup clicked");
				popup_Array[position]=0;
				browse_page_popup.setVisibility(View.INVISIBLE);
				last_popup = null;
			}
		});
			browse_page_popup.setVisibility(View.INVISIBLE);
		popup.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				popup_Array[position]=1;
				if(last_popup != null){
					if(last_popup.isShown()){
						last_popup.setVisibility(View.INVISIBLE);
					}
					else{
						last_popup = null;
					}
				}
				last_popup = browse_page_popup;
				
				browse_page_popup.setVisibility(View.VISIBLE);
				
				TranslateAnimation animate2 = new TranslateAnimation(browse_page_popup.getWidth(),0,0, 0);
				animate2.setDuration(500);
				
				browse_page_popup.startAnimation(animate2);	
			}
		});
		if(position>lp){
		TranslateAnimation animate2 = new TranslateAnimation(0,0,view.getHeight(),0);
		animate2.setDuration(500);
		view.startAnimation(animate2);}
		lp=position;
		return view;
	}
}
