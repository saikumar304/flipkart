package com.example.viewflipper;

import java.util.ArrayList;

import net.simonvt.menudrawer.MenuDrawer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class BrowsePage extends SherlockActivity{
	private MenuDrawer menuDrawer;
	private ViewFlipper vf;	
	private int viewchanger_status=1;
	private CustomListAdapterBrowsePage adapter;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.browsepage);
		ActionBar ab = getSupportActionBar();
		ab.setIcon(R.drawable.category_icon);
		ab.setCustomView(R.layout.action_bar_logo_view);		
		ab.setDisplayShowTitleEnabled(false);
		ab.setDisplayShowCustomEnabled(true);
		ab.setHomeButtonEnabled(true);			
		// this is for the menudrawer
		menuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_WINDOW);
		menuDrawer.setContentView(R.layout.browsepage);
		menuDrawer.setMenuView(R.layout.shopbycategory);		
		menuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);
		
		vf=(ViewFlipper)findViewById(R.id.viewflipper_browsepage);
		
		//listview and gridview
		ListView lv=(ListView)findViewById(R.id.listview_browsepage);			
		ArrayList<BrowsePageListDetails> al=new ArrayList<BrowsePageListDetails>();
		al.add(new BrowsePageListDetails(R.drawable.lv1));
		al.add(new BrowsePageListDetails(R.drawable.lv2));
		al.add(new BrowsePageListDetails(R.drawable.lv3));
		al.add(new BrowsePageListDetails(R.drawable.lv4));
		al.add(new BrowsePageListDetails(R.drawable.lv1));
		al.add(new BrowsePageListDetails(R.drawable.lv2));
		al.add(new BrowsePageListDetails(R.drawable.lv3));
		al.add(new BrowsePageListDetails(R.drawable.lv4));
		al.add(new BrowsePageListDetails(R.drawable.lv1));
		al.add(new BrowsePageListDetails(R.drawable.lv2));
		al.add(new BrowsePageListDetails(R.drawable.lv3));
		al.add(new BrowsePageListDetails(R.drawable.lv4));
		adapter=new CustomListAdapterBrowsePage(this,R.layout.browsepagelistdetails,al);
		lv.setAdapter(adapter);
		
		GridView gv=(GridView)findViewById(R.id.gridview_browsepage);
		gv.setAdapter(new CustomGridAdapterBrowsePage(this));
	}
	public void toggleBetweenViews(View v){
		vf.setOutAnimation(this, R.anim.out_to_left);
		vf.setInAnimation(this, R.anim.in_from_right);
		vf.showNext();
		ImageView iv=(ImageView)findViewById(R.id.viewchanger);
		viewchanger_status=-1*viewchanger_status;
		if(viewchanger_status==-1)
			iv.setImageResource(R.drawable.viewchanger_listview);
		else
			iv.setImageResource(R.drawable.viewchanger_gridview);
			
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
		// Handle item selection
		switch (item.getItemId()) {
		case android.R.id.home:
			menuDrawer.toggleMenu();
			return true;
		case R.id.menu_search:
			//openSearch();
			startActivity(new Intent(this,searchpage.class));
			return true;
		
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	private class CustomGridAdapterBrowsePage extends BaseAdapter {
	    private Context mContext;

	    public CustomGridAdapterBrowsePage(Context c) {
	        mContext = c;
	    }

	    public int getCount() {
	        return mThumbIds.length;
	    }

	    public Object getItem(int position) {
	        return null;
	    }

	    public long getItemId(int position) {
	        return 0;
	    }

	    // create a new ImageView for each item referenced by the Adapter
	    public View getView(int position, View convertView, ViewGroup parent) {
	        ImageView imageView;
	        if (convertView == null) {  // if it's not recycled, initialize some attributes
	            imageView = new ImageView(mContext);
	            //imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
	            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            //imageView.setPadding(8, 8, 8, 8);
	        } else {
	            imageView = (ImageView) convertView;
	        }

	        imageView.setImageResource(mThumbIds[position]);
	        return imageView;
	    }

	    // references to our images
	    private Integer[] mThumbIds = {
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3
	            
	    };
	}
	
	
	
	
	private class CustomListAdapterBrowsePage extends ArrayAdapter<BrowsePageListDetails>{
		Context context;
		ArrayList<BrowsePageListDetails> mylist;
		int layout;
		public CustomListAdapterBrowsePage(Context c,int res,ArrayList<BrowsePageListDetails> l){
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
	    ImageView iv=(ImageView)convertView.findViewById(R.id.imageview_browsepage);
	    iv.setImageResource(mylist.get(position).getImg());
	    return convertView;
	}


}
	public void clpActivity(View v){
		startActivity(new Intent(this,clp.class));
	}
}
