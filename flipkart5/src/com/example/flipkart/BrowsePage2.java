package com.example.flipkart;

import java.util.ArrayList;

import net.simonvt.menudrawer.MenuDrawer;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.haarman.listviewanimations.ArrayAdapter;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.itemmanipulation.SwipeDismissAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;


public class BrowsePage2 extends SherlockActivity implements OnDismissCallback{
	private GoogleCardsAdapter mGoogleCardsAdapter;
	private MenuDrawer menuDrawer;
	private ViewFlipper vf;	
	protected Object mActionMode;
	int checkbox_count=0;
	int popup_Array[];	
	int x;
	View pops;
	View browse_page_popup;
	private int viewchanger_status=1;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		ActionBar ab = getSupportActionBar();		
		menuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_WINDOW);
		menuDrawer.setContentView(R.layout.browsepage);
		new ActionBarAndMenuDrawer(ab, menuDrawer);
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
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		lv.setMultiChoiceModeListener(new MultiChoiceModeListener() {

		    @Override
		    public void onItemCheckedStateChanged(ActionMode mode, int position,
		                                          long id, boolean checked) {
		        // Here you can do something when items are selected/de-selected,
		        // such as update the title in the CAB
		    	
		    }

		    @Override
		    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
		        // Respond to clicks on the actions in the CAB
		        switch (item.getItemId()) {
		          
		            default:
		                return false;
		        }
		    }

		    @Override
		    public boolean onCreateActionMode(ActionMode mode, android.view.Menu menu) {
		        // Inflate the menu for the CAB
		        MenuInflater inflater = mode.getMenuInflater();
		        inflater.inflate(R.menu.main , menu);
		        return true;
		    }

		    @Override
		    public void onDestroyActionMode(ActionMode mode) {
		        // Here you can make any necessary updates to the activity when
		        // the CAB is removed. By default, selected items are deselected/unchecked.
		    }

		    @Override
		    public boolean onPrepareActionMode(ActionMode mode, android.view.Menu menu) {
		        // Here you can perform updates to the CAB due to
		        // an invalidate() request
		        return false;
		    }
		});
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
	private  class GoogleCardsAdapter extends ArrayAdapter<Integer> {

		private Context mContext;
		private LruCache<Integer, Bitmap> mMemoryCache;
		int imageArray[]=new int[100];
		int i;
		//final int popup_Array[];
		public GoogleCardsAdapter(Context context) {
			mContext = context;
			popup_Array=new int[100];
			for(i=0;i<100;i++){			
				popup_Array[i]=0;				
			}
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
		//checkbox view
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {			
			View view = convertView;
			if (view == null) {
				view = LayoutInflater.from(mContext).inflate(R.layout.browsepage_lv2, parent, false);
			}
			final CheckBox cb=(CheckBox)view.findViewById(R.id.checkbox_browsepage);;			
			cb.setOnCheckedChangeListener(new OnCheckedChangeListener()
			{
			    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
			    {
			        if ( isChecked )
			        {
			        	checkbox_count++;
			        	ImageView bottombar=(ImageView)findViewById(R.id.filter_bar);			        	
			        	bottombar.setImageResource(R.drawable.browsepage_contextual_bottombar);
			        }
			        else{
			        	checkbox_count--;
			        	if(checkbox_count==0){
			        		//vf_filterbar.setOutAnimation(this, R.anim.out_to_left);
			        		//vf_filterbar.setInAnimation(this, R.anim.in_from_right);
			        		//vf_filterbar.showNext();
			        	ImageView bottombar=(ImageView)findViewById(R.id.filter_bar);
			        	bottombar.setImageResource(R.drawable.filter_bottom);		
			        	}
			        }

			    }
			});

			ImageView iv=(ImageView)view.findViewById(R.id.imageitem);
			setImageView(iv, position);
			return view;
		}
		 
		//popup view
		/*
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {			
			View view = convertView;
			if (view == null) {
				view = LayoutInflater.from(mContext).inflate(R.layout.browsepage_lv2, parent, false);
			}
			x=position;	
			browse_page_popup=(View)view.findViewById(R.id.browse_page_popup);			
			pops=browse_page_popup;
			browse_page_popup.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					System.out.println("gerrrrr");
					popup_Array[x]=0;
					browse_page_popup.setVisibility(View.GONE);
					
				}
			});
			//popup
			//View tempparent = (View)view.getParent().getParent();
			if(popup_Array[x]==0){
				browse_page_popup.setVisibility(View.GONE);
			}
			else browse_page_popup.setVisibility(View.VISIBLE);
			
			Button popup=(Button)view.findViewById(R.id.browse_page_popup_button);
			popup.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					View parent = (View)v.getParent().getParent(); 					
					popup_Array[x]=1;
					View browse_page_popup=(View)parent.findViewById(R.id.browse_page_popup);					
					browse_page_popup.setVisibility(View.VISIBLE);	
					RelativeLayout browselist=(RelativeLayout)parent.findViewById(R.id.currentlayout);
					browselist.setVisibility(View.GONE);
					System.out.println("hello");
				}
			});
			ImageView iv=(ImageView)view.findViewById(R.id.imageitem);
			setImageView(iv, position);
			return view;
		}*/

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
			//v.setImageResource(imageArray[position]);
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
	public void onClickOpenBrowsePageOptions(View v){
		View browse_page_popup=(View)findViewById(R.id.browse_page_popup);
		System.out.println("error here");
		browse_page_popup.setVisibility(View.VISIBLE);	
		RelativeLayout browselist=(RelativeLayout)findViewById(R.id.currentlayout);
		browselist.setVisibility(View.GONE);
	}
	public void onClickToggleView(View v){
		
		View parent = (View)v.getParent();
		
		View browse_page_popup=(View)parent.findViewById(R.id.browse_page_popup);
		browse_page_popup.setVisibility(View.GONE);	
		RelativeLayout browselist=(RelativeLayout)parent.findViewById(R.id.currentlayout);
		browselist.setVisibility(View.VISIBLE);
	}
}
