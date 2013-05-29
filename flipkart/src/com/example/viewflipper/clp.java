package com.example.viewflipper;

import java.util.ArrayList;

import net.simonvt.menudrawer.MenuDrawer;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class clp extends SherlockActivity{
	ArrayList<ListDetails> al;
	private MenuDrawer menuDrawer;
	CustomListAdapter cl ;
	private int[] mImages = new int[] {
			R.drawable.toswipe,
			R.drawable.background1,
			R.drawable.background2,

			R.drawable.ic_launcher
	};
	ImageView clpBannerimage;
	private int clpBannerImageNo=0;
	public void onCreate(Bundle b){
		super.onCreate(b);
		
		//setContentView(R.layout.clp);
		al=new ArrayList<ListDetails>();
		ActionBar ab = getSupportActionBar();
		ab.setIcon(R.drawable.category_icon);
		ab.setCustomView(R.layout.action_bar_logo_view);		
		ab.setDisplayShowTitleEnabled(false);
		ab.setDisplayShowCustomEnabled(true);
		ab.setHomeButtonEnabled(true);		
		
		// this is for the menudrawer
		menuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_WINDOW);
		menuDrawer.setContentView(R.layout.clp);
		menuDrawer.setMenuView(R.layout.shopbycategory);
		menuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);
		al.add(new ListDetails(R.drawable.lumia));
		al.add(new ListDetails(R.drawable.lumia3));
		al.add(new ListDetails(R.drawable.lumia2));
		al.add(new ListDetails(R.drawable.lumia));
		al.add(new ListDetails(R.drawable.lumia3));
		al.add(new ListDetails(R.drawable.lumia2));
		al.add(new ListDetails(R.drawable.lumia));
		al.add(new ListDetails(R.drawable.lumia3));
		al.add(new ListDetails(R.drawable.lumia2));
		al.add(new ListDetails(R.drawable.lumia));
		al.add(new ListDetails(R.drawable.lumia3));
		al.add(new ListDetails(R.drawable.lumia2));
		al.add(new ListDetails(R.drawable.lumia));
		al.add(new ListDetails(R.drawable.lumia3));
		al.add(new ListDetails(R.drawable.lumia2));
		al.add(new ListDetails(R.drawable.lumia));
		al.add(new ListDetails(R.drawable.lumia3));
		al.add(new ListDetails(R.drawable.lumia2));
		cl=new CustomListAdapter(this,R.layout.clp_lv,al);
		ListView lv=(ListView)findViewById(R.id.clp_lv);		
		LayoutInflater lf=this.getLayoutInflater();
		View view=(View)lf.inflate(R.layout.header,null,false);
		lv.addHeaderView(view,null,false);
		lv.setAdapter(cl);	
		clpBannerimage=(ImageView)findViewById(R.id.clpbannerimage);		
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
	
	public void nextClpBanner(View v){
		
		if(clpBannerImageNo==mImages.length-1)
			return;
		clpBannerimage.setImageResource(mImages[++clpBannerImageNo]);
	}
	public void previousClpBanner(View v){
		if(clpBannerImageNo==0)
			return;
		Log.d("error","hereddd");
		clpBannerimage.setImageResource(mImages[--clpBannerImageNo]);		
	}
	public void browsePage(View v){
		startActivity(new Intent(this,BrowsePage.class));
	}
	public void clpActivity(View v){
		startActivity(new Intent(this,clp.class));
	}
	
	
	
	
	
	
	
	
}
