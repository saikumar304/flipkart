package com.example.viewflipper;

import java.util.ArrayList;

import net.simonvt.menudrawer.MenuDrawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class ProductPageFragment extends SherlockActivity{
	ArrayList<BrowsePageListDetails> al;
	 MenuDrawer menuDrawer;
	ViewPager productViewPager = null;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.product_page_screen_layout);
		
		ActionBar ab = getSupportActionBar();
		ab.setIcon(R.drawable.category_icon);
		ab.setCustomView(R.layout.action_bar_logo_view);
		
		ab.setDisplayShowTitleEnabled(false);
		ab.setDisplayShowCustomEnabled(true);
		ab.setHomeButtonEnabled(true);		
		
		// this is for the menudrawer
		menuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_WINDOW);
		menuDrawer.setContentView(R.layout.product_page_screen_layout);		
		menuDrawer.setMenuView(R.layout.shopbycategory);
		menuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);
		
		
		
		
		ListView product_page_slider_product_list=(ListView)findViewById(R.id.product_page_slider_product_list);
		al=new ArrayList<BrowsePageListDetails>();
		al.add(new BrowsePageListDetails(R.drawable.mobile1,R.drawable.ic_launcher));
		al.add(new BrowsePageListDetails(R.drawable.mobile2,R.drawable.ic_launcher));
		al.add(new BrowsePageListDetails(R.drawable.mobile1,R.drawable.ic_launcher));
		al.add(new BrowsePageListDetails(R.drawable.mobile2,R.drawable.ic_launcher));
		al.add(new BrowsePageListDetails(R.drawable.mobile1,R.drawable.ic_launcher));
		al.add(new BrowsePageListDetails(R.drawable.mobile2,R.drawable.ic_launcher));
		al.add(new BrowsePageListDetails(R.drawable.mobile1,R.drawable.ic_launcher));
		al.add(new BrowsePageListDetails(R.drawable.mobile2,R.drawable.ic_launcher));
		al.add(new BrowsePageListDetails(R.drawable.mobile1,R.drawable.ic_launcher));
		al.add(new BrowsePageListDetails(R.drawable.mobile2,R.drawable.ic_launcher));
		product_page_slider_product_list.setAdapter
		(new CustomListAdapterBrowsePage(this,R.layout.sliderlistview,al));
		product_page_slider_product_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				ImageView iv=(ImageView)findViewById(R.id.product_page_image_layout_image_view);
				iv.setImageResource(arg1.getId());
			}
		});
		
		//viewpager
		productViewPager = (ViewPager)findViewById(R.id.product_page_view_pager);		
		productViewPager.setAdapter(new FKProductPageAdapter());
		
	}
	private class FKProductPageAdapter extends PagerAdapter {
		  private int[] mImages = new int[] {
				  R.drawable.product_page1,
				  R.drawable.product_page2,
		      R.drawable.background2,
		      
		      R.drawable.ic_launcher
		  };
		
		  @Override
		  public int getCount() {
		    //return mImages.length;
			  return 6;
		  }
		
		  @Override
		  public boolean isViewFromObject(View view, Object object) {
		    return view == ((View) object);
			//  return true;
		  }
		  @Override
		  public Object instantiateItem(ViewGroup container, int position) {
		    Context context = ProductPageFragment.this;		
		    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    View view=inflater.inflate(R.layout.product_page_view_page_layout, null);
		    //View view=inflater.inflate(R.layout.viewpager_resource, null);		    		    
		    ((ViewPager) container).addView(view);
		    return view;
		  }
		
		  @Override
		  public void destroyItem(ViewGroup container, int position, Object object) {
		    //((ViewPager) container).removeView((ImageView) object);
			  ((ViewPager) container).removeView((View) object);
		  }
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
			startActivity(new Intent(this,searchpage.class));
			overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
	public void newActivity(View v){
		startActivity(new Intent(this,ProductPageFragment.class));
		overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
	}
	public void onBackPressed(){
		super.onBackPressed();
		overridePendingTransition  (R.anim.in_from_left, R.anim.out_to_right);
	}
	public void clpActivity(View v){
		startActivity(new Intent(this,clp.class));
		overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);		
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
	    ImageView iv=(ImageView)convertView.findViewById(R.id.tempimg);
	    iv.setImageResource(mylist.get(position).getImg1());
	    return convertView;
		}
		
	}
}