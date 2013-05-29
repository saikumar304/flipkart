package com.example.viewflipper;

import net.simonvt.menudrawer.MenuDrawer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;

public class MainActivity extends SherlockActivity{
	private MenuDrawer menuDrawer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main_with_viewpager_swipe);
		
		ActionBar ab = getSupportActionBar();
		ab.setIcon(R.drawable.category_icon);
		ab.setCustomView(R.layout.action_bar_logo_view);
		
		ab.setDisplayShowTitleEnabled(false);
		ab.setDisplayShowCustomEnabled(true);
		ab.setHomeButtonEnabled(true);		
		
		// this is for the menudrawer
		menuDrawer = MenuDrawer.attach(this, MenuDrawer.MENU_DRAG_WINDOW);
		menuDrawer.setContentView(R.layout.activity_main_with_viewpager_swipe);

		//menuDrawer.setContentView(R.layout.activity_home_fragment_holder);
		//menuDrawer.setContentView(R.layout.activity_main);
		//menuDrawer.setMenuView(R.layout.category_side_pane_drawer);
		menuDrawer.setMenuView(R.layout.shopbycategory);
		//menuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);
		menuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_NONE);

		ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
		ImagePagerAdapter adapter = new ImagePagerAdapter();
		viewPager.setAdapter(adapter);
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
	private class ImagePagerAdapter extends PagerAdapter {
		private int[] mImages = new int[] {
				R.drawable.banner,
				R.drawable.background1,
				R.drawable.background2,
				R.drawable.ic_launcher
		};

		@Override
		public int getCount() {
			return mImages.length;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == ((ImageView) object);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			Context context = MainActivity.this;
			ImageView imageView = new ImageView(context);
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setImageResource(mImages[position]);
			((ViewPager) container).addView(imageView, 0);
			return imageView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			((ViewPager) container).removeView((ImageView) object);
		}
	}
	public void newActivity(View v){
		startActivity(new Intent(this,Clp2NewListview.class));
	}
	public void clpActivity(View v){
		startActivity(new Intent(this,clp.class));
		overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);		
	}
}