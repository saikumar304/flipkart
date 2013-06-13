package com.example.flipkart;

import java.util.ArrayList;

import net.simonvt.menudrawer.MenuDrawer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ViewFlipper;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;


public class BrowsePage extends SherlockActivity implements OnDismissCallback{
	//private GoogleCardsAdapter mGoogleCardsAdapter;
	private MenuDrawer menuDrawer;	
	ArrayList<BrowsePageListDetails> browsePageList;
	ArrayList<BrowsePageListDetailsForGridView> browsePageListGridView;
	private ViewFlipper vf;	
	int checkbox_count=0;

	Handler handler = new Handler();
	
	int popup_Array[];
	int checkedArray[];
	int x,popshown=0;
	ListView lv;
	BrowsePageListAdapter adapter;
	BrowsePageListAdapterForGridView adapter2;
	protected Object mActionMode;
	ArrayList<String> al=new ArrayList<String>();
	private int viewchanger_status=1;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		ActionBar ab = getSupportActionBar();		
		menuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_WINDOW);
		menuDrawer.setContentView(R.layout.browsepage);
		new ActionBarAndMenuDrawer(ab, menuDrawer);
		vf=(ViewFlipper)findViewById(R.id.viewflipper_browsepage);
		Intent from=getIntent();		
		String source=from.getStringExtra("source");
		browsePageList=new ArrayList<BrowsePageListDetails>();
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv1));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv4));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		
		//listview and gridview
		lv=(ListView)findViewById(R.id.listview_browsepage);			
		LayoutInflater lf=this.getLayoutInflater();
		View view=(View)lf.inflate(R.layout.browse_page_listview_header,null,false);
		lv.addHeaderView(view,null,false);
		adapter=new BrowsePageListAdapter(this, R.layout.browsepage_lv, browsePageList,lv);
		lv.setAdapter(adapter);
		al.add("asdkhbf");
		al.add("asdkhbf");
		al.add("asdkhbf");al.add("asdkhbf");al.add("asdkhbf");al.add("asdkhbf");al.add("asdkhbf");
		al.add("asdkhbf");al.add("asdkhbf");al.add("asdkhbf");al.add("asdkhbf");al.add("asdkhbf");
		//lv.setAdapter(new android.widget.ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,al));
		/*
		lv.setOnItemClickListener(new OnItemClickListener()
		{
		    @Override public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
		    { 
		    	System.out.println("just click");
		    }
		});
	
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
		lv.setMultiChoiceModeListener(new MultiChoiceModeListener() {

			@Override
			public void onItemCheckedStateChanged(ActionMode mode, int position,
					long id, boolean checked) {
				// Here you can do something when items are selected/de-selected,
				// such as update the title in the CAB
				System.out.println("clicked long");

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
				//System.out.println("");
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
		*/
		//
		//GridView gv=(GridView)findViewById(R.id.gridview_browsepage);
		//gv.setAdapter(new CustomGridAdapterBrowsePage(this));
		browsePageListGridView=new ArrayList<BrowsePageListDetailsForGridView>();
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		browsePageListGridView.add(new BrowsePageListDetailsForGridView(R.drawable.gv1, R.drawable.gv1));
		ListView gv=(ListView)findViewById(R.id.listview_browsepage_gridview);
		LayoutInflater lf2=this.getLayoutInflater();
		View view2=(View)lf2.inflate(R.layout.browse_page_listview_header_gridview,null,false);
		gv.addHeaderView(view2,null,false);
		adapter2=new BrowsePageListAdapterForGridView(this,R.layout.browsepage_lv_gridview, browsePageListGridView);
		gv.setAdapter(adapter2);
		popup_Array=new int [100];				
		checkedArray=new int [100];
		if(source!=null && source.equalsIgnoreCase("lifestyle"))
			vf.showNext();
		
		ImageView logo=(ImageView)findViewById(R.id.actionBarLogo);
		logo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            		goToHomePage(v);
            }
        });
		

	}

	public void goToHomePage(View v){
		startActivity(new Intent(this,MainActivity.class));
		overridePendingTransition  ( R.anim.in_from_left,R.anim.out_to_right);
	}
	public void toggleBetweenViews(View v){
		vf.setOutAnimation(this, R.anim.out_to_left);
		vf.setInAnimation(this, R.anim.in_from_right);
		vf.showNext();
		/*
		ImageView iv=(ImageView)findViewById(R.id.viewchanger);
		viewchanger_status=-1*viewchanger_status;		
		if(viewchanger_status==-1)
			iv.setImageResource(R.drawable.viewchanger_gridview);
		else
			iv.setImageResource(R.drawable.viewchanger_listview);
			*/

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
			startActivity(new Intent(this,SearchPage.class));
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
		if(menuDrawer.isMenuVisible()){
			System.out.println("aaaaaaaaaaaaa");
			menuDrawer.toggleMenu();
			return;
		}
		View browse=(View)adapter.last_popup;
		View browse2=(View)adapter2.last_popup;		
		if(adapter.last_popup!=null){System.out.println("bbbbbbbb");
			adapter.last_popup.setVisibility(View.INVISIBLE);
			adapter.last_popup=null;
		}
		else if(adapter2.last_popup!=null){System.out.println("ccccc");
			adapter2.last_popup.setVisibility(View.INVISIBLE);
			adapter2.last_popup=null;
		}
		else
		{
			super.onBackPressed();
			overridePendingTransition  (R.anim.in_from_left, R.anim.out_to_right);
			System.out.println("sajhdbfjhasbdf");
		}
		
	}
	public void goToProductPage(View V){
		ImageView popup=(ImageView)adapter.last_popup;
		if(popup!=null && popup.isShown()){
			popup.setVisibility(View.INVISIBLE);
			popup=null;
			return;
		}
		startActivity(new Intent(this,ProductPageFragment.class));
		overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
	}
	public void goToProductPageGridView(View v){
		ImageView popup=(ImageView)adapter2.last_popup;
		if(popup!=null && popup.isShown()){
			popup.setVisibility(View.INVISIBLE);
			popup=null;
			return;
		}
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
	public void animate(View v){		
		
	}
	public void abc(View v){
		System.out.println("hiii");
	}
	public void remove(int last_popup){
		
	}
	public void goBack(View v){		
		onBackPressed();
	}

	public void clpActivityNew(View v){
		handler.postDelayed(new Runnable() {
			public void run() {     	

				long endTime = System.currentTimeMillis() + 100;

				while (System.currentTimeMillis() < endTime) {
					synchronized (this) {
						try {
							wait(endTime- System.currentTimeMillis());
						} catch (Exception e) {}
					}
				}
				menuDrawer.toggleMenu();
			}
		}, 200);
		startActivity(new Intent(this,clp.class));
		overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
	}
}
