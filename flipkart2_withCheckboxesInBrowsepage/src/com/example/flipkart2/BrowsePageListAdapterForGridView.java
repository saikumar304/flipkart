package com.example.flipkart2;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class BrowsePageListAdapterForGridView extends ArrayAdapter<BrowsePageListDetailsForGridView>{
	Context context;	
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
		final View browse_page_popup,browse_page_popup2;
		ImageView iv=(ImageView)view.findViewById(R.id.imageitem_gridview);
		iv.setImageResource(mylist.get(position).getImg1());
		ImageView iv2=(ImageView)view.findViewById(R.id.imageitem_gridview2);
		iv2.setImageResource(mylist.get(position).getImg2());
		Button popup=(Button)view.findViewById(R.id.browse_page_popup_button_gridview);
		Button popup2=(Button)view.findViewById(R.id.browse_page_popup_button_gridview2);
		browse_page_popup=(View)view.findViewById(R.id.browse_page_popup_gridview);						
		browse_page_popup2=(View)view.findViewById(R.id.browse_page_popup_gridview2);						
		browse_page_popup.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				System.out.println("popup clicked");
				popup_Array[position]=0;
				browse_page_popup.setVisibility(View.GONE);
			}
		});
		if(popup_Array[position]==0){
			browse_page_popup.setVisibility(View.GONE);
		}
		else browse_page_popup.setVisibility(View.VISIBLE);
		popup.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				View parent = (View)v.getParent().getParent(); 					
				popup_Array[position]=1;
				browse_page_popup.setVisibility(View.VISIBLE);						
			}
		});
//
		browse_page_popup2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				System.out.println("popup clicked");
				popup_Array2[position]=0;
				browse_page_popup2.setVisibility(View.GONE);
			}
		});
		if(popup_Array2[position]==0){
			browse_page_popup2.setVisibility(View.GONE);
		}
		else browse_page_popup2.setVisibility(View.VISIBLE);
		popup2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				View parent = (View)v.getParent().getParent(); 					
				popup_Array2[position]=1;
				browse_page_popup2.setVisibility(View.VISIBLE);						
			}
		});
		return view;
	}
	/*
	//listview with checkboxes
	@Override
	public View getView(final int position,View convertView,ViewGroup parent){
		View view=convertView;
		if (view == null) {
			view = LayoutInflater.from(context).inflate(layout, parent, false);
		}
		final View browse_page_popup;
		ImageView iv=(ImageView)view.findViewById(R.id.imageitem);
		View temp_parent=(View)view.getParent().getParent();
		final ImageView bottombar=(ImageView)temp_parent.findViewById(R.id.filter_bar);	
		iv.setImageResource(mylist.get(position).getImg1());
		final CheckBox cb=(CheckBox)view.findViewById(R.id.checkbox_browsepage);
		if(checkedArray[position]==1)
			cb.setChecked(true);
		else cb.setChecked(false);	
		cb.setOnClickListener(new OnClickListener() {			 
            public void onClick(View v) {
            	if(cb.isChecked()){
            		checkbox_count++;
							        	
					bottombar.setImageResource(R.drawable.browsepage_contextual_bottombar);			        	
					checkedArray[position]=1;
            	}
            	else{
            		checkbox_count--;
					checkedArray[position]=0;
					if(checkbox_count==0){			        							
						bottombar.setImageResource(R.drawable.filter_bottom);	
					}
            	}
            }
        });
		return view;
	}
*/

}
