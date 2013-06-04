package com.example.flipkart;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class CustomListAdapter extends ArrayAdapter<ListDetails>{
	Context context;
	List<ListDetails> mylist;
	int layout;
	public CustomListAdapter(Context c,int res,List<ListDetails> l){
		super(c,res,l);
		context=c;
		layout=res;
		mylist=l;
	}
	public View getView(int position, View convertView, ViewGroup parent) {
    
    // First let's verify the convertView is not null
    if (convertView == null) {
        // This a new view we inflate the new layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(layout, parent, false);
    }
    ImageView iv=(ImageView)convertView.findViewById(R.id.imageitem);
    int resId=mylist.get(position).getImgRsc();
    iv.setImageResource(resId);
    return convertView;
}

}
