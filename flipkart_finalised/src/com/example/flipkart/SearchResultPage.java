package com.example.flipkart;

import java.util.ArrayList;

import net.simonvt.menudrawer.LeftDrawer;
import net.simonvt.menudrawer.MenuDrawer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class SearchResultPage extends SherlockActivity{
	MenuDrawer menuDrawer;
	SearchPageListAdapter adapter;
	ArrayList<BrowsePageListDetails> browsePageList;	
	ArrayList<ListDetails> al;
	LeftDrawer lf;
	CustomListAdapter cl ;
	ViewPager searchPageViewPager = null;
	ListView lv,lv2;
	Intent intent;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		intent=new Intent(this,ProductPageFragment.class);
		ActionBar ab = getSupportActionBar();
		ab.setIcon(R.drawable.category_icon);
		ab.setCustomView(R.layout.action_bar_logo_view);
		
		ab.setDisplayShowTitleEnabled(false);
		ab.setDisplayShowCustomEnabled(true);
		ab.setHomeButtonEnabled(true);		
		
		// this is for the menudrawer
		menuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_WINDOW);
		menuDrawer.setContentView(R.layout.search_page_screen_layout);		
		menuDrawer.setMenuView(R.layout.shopbycategory);
		menuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);
		
		InputMethodManager imm = (InputMethodManager)
				SearchResultPage.this.getSystemService(Context.INPUT_METHOD_SERVICE);

			if (imm != null){
			    imm.toggleSoftInput(InputMethodManager.HIDE_NOT_ALWAYS,0);
			}
		lf=(LeftDrawer)findViewById(R.id.productPageDrawer);
		lf.toggleMenu();
		//lv=(ListView)findViewById(R.id.search_page_slider_product_list);
		al=new ArrayList<ListDetails>();
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		al.add(new ListDetails(R.drawable.clplv1));
		al.add(new ListDetails(R.drawable.clplv2));
		//lv.setAdapter(new CustomListAdapter(this,R.layout.clp_lv, al));
		
		browsePageList=new ArrayList<BrowsePageListDetails>();
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv1));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv4));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv1));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv4));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv1));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv4));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv1));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv4));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv1));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv2));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv3));
		browsePageList.add(new BrowsePageListDetails(R.drawable.lv4));
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
		adapter=new SearchPageListAdapter(this, R.layout.search_page_lv, browsePageList);		
		//viewpager
		searchPageViewPager = (ViewPager)findViewById(R.id.search_page_view_pager);		
		searchPageViewPager.setAdapter(new FKProductPageAdapter());
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
	private class FKProductPageAdapter extends PagerAdapter {		  
		  @Override
		  public int getCount() {
			  return 1;
		  }
		
		  @Override
		  public boolean isViewFromObject(View view, Object object) {
		   // return view == ((View) object);
			  return true;
		  }
		  @Override
		  public Object instantiateItem(ViewGroup container, int position) {
		    Context context = SearchResultPage.this;		
		    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		    View view=inflater.inflate(R.layout.search_page_view_page_layout, null);

			AutoCompleteTextView textView = (AutoCompleteTextView)view.findViewById(R.id.autocomplete_country2);
			textView.setText("Samsung Mobiles");
		    ListView lv2=(ListView)view.findViewById(R.id.search_page_result_list_view);		   
		    lv2.setAdapter(adapter);
		    lv2.setOnItemClickListener(new OnItemClickListener() {
			    @Override
			    public void onItemClick (AdapterView<?> parent, View view, int position, long id) {		        
					startActivity(intent);
					overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
			    }
			});
		    
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
			startActivity(new Intent(this,SearchPage.class));
			overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
	public void goToProductPage(View v){
		
	}
	public void clpActivityNew(View v){
		menuDrawer.toggleMenu();
		startActivity(new Intent(this,clp.class));
		overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
	}
	public void goToBrowsePage(View v){
		startActivity(new Intent(this,BrowsePage.class));
		overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
	}
	public void onBackPressed(){
		if(menuDrawer.isMenuVisible()){
			menuDrawer.toggleMenu();
			return;
		}
		if(lf.isMenuVisible()){
			lf.toggleMenu();
			return;
		}
		super.onBackPressed();
		overridePendingTransition  (R.anim.in_from_left, R.anim.out_to_right);
	}
}
