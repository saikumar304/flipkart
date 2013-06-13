package com.example.flipkart;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.TranslateAnimation;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class BrowsePageListAdapterForGridView extends ArrayAdapter<BrowsePageListDetailsForGridView>{
	Context context;	
	ImageView last_popup=null;
	int lp=0;
	List<BrowsePageListDetailsForGridView> mylist;
	int layout,checkbox_count=0;
	int popup_Array[],checkedArray[],popup_Array2[];
	public BrowsePageListAdapterForGridView(Context c,int res,List<BrowsePageListDetailsForGridView> l){
		super(c,res,l);
		context=c;
		layout=res;
		mylist=l;
		popup_Array=new int[100];
		popup_Array2=new int[100];
		checkedArray=new int[100];
	}
	
	//popup image getView(Without checkboxes)
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {			
		View view = convertView;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(layout, parent, false);
		}
		final ImageView browse_page_popup,browse_page_popup2;
		ImageView iv=(ImageView)view.findViewById(R.id.imageitem_gridview);
		iv.setImageResource(mylist.get(position).getImg1());
		ImageView iv2=(ImageView)view.findViewById(R.id.imageitem_gridview2);
		iv2.setImageResource(mylist.get(position).getImg2());
		Button popup=(Button)view.findViewById(R.id.browse_page_popup_button_gridview);
		Button popup2=(Button)view.findViewById(R.id.browse_page_popup_button_gridview2);
		browse_page_popup=(ImageView)view.findViewById(R.id.browse_page_popup_gridview);						
		browse_page_popup2=(ImageView)view.findViewById(R.id.browse_page_popup_gridview2);						
		browse_page_popup.setVisibility(View.INVISIBLE);
		browse_page_popup2.setVisibility(View.INVISIBLE);
		//popup button listeners
		popup.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(last_popup!=null){
					if(last_popup.isShown()){
						last_popup.setVisibility(View.INVISIBLE);
					}
					else
						last_popup=null;
				}					
				last_popup=browse_page_popup;
				last_popup.setVisibility(View.VISIBLE);			
				TranslateAnimation animate2 = new TranslateAnimation(-last_popup.getWidth(),0,0, 0);
				animate2.setDuration(100);
				
				last_popup.startAnimation(animate2);	
			}
		});
		popup2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				if(last_popup!=null){
					if(last_popup.isShown()){
						last_popup.setVisibility(View.INVISIBLE);
					}
					else
						last_popup=null;
				}					
				last_popup=browse_page_popup2;
				last_popup.setVisibility(View.VISIBLE);	
				TranslateAnimation animate2 = new TranslateAnimation(last_popup.getWidth(),0,0, 0);
				animate2.setDuration(250);
				
				last_popup.startAnimation(animate2);
				System.out.println("one clicked");
			}
		});
		
		//popup image listeners
		browse_page_popup.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				last_popup.setVisibility(View.INVISIBLE);
				last_popup=null;
			}
		});
		browse_page_popup2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				last_popup.setVisibility(View.INVISIBLE);
				last_popup=null;
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
