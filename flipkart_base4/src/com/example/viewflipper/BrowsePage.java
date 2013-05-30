package com.example.viewflipper;

import java.util.ArrayList;
import net.simonvt.menudrawer.MenuDrawer;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

import com.haarman.listviewanimations.ArrayAdapter;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.itemmanipulation.SwipeDismissAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;


public class BrowsePage extends SherlockActivity implements OnDismissCallback{
	private GoogleCardsAdapter mGoogleCardsAdapter;
	private MenuDrawer menuDrawer;
	private ViewFlipper vf;	
	int sda=0;
	private int viewchanger_status=1;
	//private CustomListAdapterBrowsePage adapter;
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
		menuDrawer.setContentView(R.layout.browsepage2);
		menuDrawer.setMenuView(R.layout.shopbycategory);		
		menuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);
		
		vf=(ViewFlipper)findViewById(R.id.viewflipper_browsepage);
		
		//listview and gridview
		ListView lv=(ListView)findViewById(R.id.listview_browsepage);			
		mGoogleCardsAdapter = new GoogleCardsAdapter(this);
		SwingBottomInAnimationAdapter swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(new SwipeDismissAdapter(mGoogleCardsAdapter, this));
		swingBottomInAnimationAdapter.setListView(lv);
		lv.setAdapter(swingBottomInAnimationAdapter);
		mGoogleCardsAdapter.addAll(getItems());		

		
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
			iv.setImageResource(R.drawable.viewchanger_gridview);
		else
			iv.setImageResource(R.drawable.viewchanger_listview);
			
	}
	private ArrayList<Integer> getItems() {
		ArrayList<Integer> items = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			items.add(i);
		}
		return items;
	}
	@Override
	public void onDismiss(ListView listView, int[] reverseSortedPositions) {
		for (int position : reverseSortedPositions) {
			//mGoogleCardsAdapter.remove(position);
		}
	}
	private static class GoogleCardsAdapter extends ArrayAdapter<Integer> {

		private Context mContext;
		private LruCache<Integer, Bitmap> mMemoryCache;

		public GoogleCardsAdapter(Context context) {
			mContext = context;

			final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

			// Use 1/8th of the available memory for this memory cache.
			final int cacheSize = maxMemory;
			mMemoryCache = new LruCache<Integer, Bitmap>(cacheSize) {
				@Override
				protected int sizeOf(Integer key, Bitmap bitmap) {
					// The cache size will be measured in kilobytes rather than
					// number of items.
					return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
				}
			};
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {			
			View view = convertView;
			if (view == null) {
				view = LayoutInflater.from(mContext).inflate(R.layout.clp_lv, parent, false);
			}
			ImageView iv=(ImageView)view.findViewById(R.id.imageitem);
			setImageView(iv, position);
			return view;
		}
		private void setImageView(ImageView v, int position) {
			int imageResId;
			switch (getItem(position) % 5) {
				case 0:
					imageResId = R.drawable.lv1;
					break;
				case 1:
					imageResId = R.drawable.lv2;
					break;
				case 2:
					imageResId = R.drawable.lv3;
					break;
				case 3:
					imageResId = R.drawable.lv4;
					break;
				default:
					imageResId = R.drawable.lv1;
			}			
			v.setImageResource(imageResId);		
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
			//openSearch();
			startActivity(new Intent(this,searchpage.class));
			overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
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
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3,
	            R.drawable.gv1,R.drawable.gv4,R.drawable.gv2,R.drawable.gv3
	            
	    };
	}			
	/*
	private class CustomListAdapterBrowsePage extends ArrayAdapter<BrowsePageListDetails>{
		Context context;
		ArrayList<BrowsePageListDetails> mylist;
		int layout;
		public CustomListAdapterBrowsePage(Context c,int res,ArrayList<BrowsePageListDetails> l){
			//super(c,res,l);
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
}*/
	public void clpActivity(View v){
		startActivity(new Intent(this,clp.class));
		overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
	}
	public void onBackPressed(){
		super.onBackPressed();
		overridePendingTransition  (R.anim.in_from_left, R.anim.out_to_right);
	}
	public void goToProductPage(View V){
		startActivity(new Intent(this,ProductPageFragment.class));
		overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
	}
	public void onClickGoToHomePage(View v){
		startActivity(new Intent(this,clp.class));
		overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
	}
}
