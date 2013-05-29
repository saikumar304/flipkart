package com.example.viewflipper;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.haarman.listviewanimations.ArrayAdapter;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.itemmanipulation.SwipeDismissAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;

public class Clp2NewListview extends Activity implements OnDismissCallback {

	private GoogleCardsAdapter mGoogleCardsAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clp2newlistview);

		ListView listView = (ListView) findViewById(R.id.abc);

		mGoogleCardsAdapter = new GoogleCardsAdapter(this);
		SwingBottomInAnimationAdapter swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(new SwipeDismissAdapter(mGoogleCardsAdapter, this));
		swingBottomInAnimationAdapter.setListView(listView);

		listView.setAdapter(swingBottomInAnimationAdapter);

		mGoogleCardsAdapter.addAll(getItems());
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
					imageResId = R.drawable.lumia3;
					break;
				case 1:
					imageResId = R.drawable.lumia2;
					break;
				case 2:
					imageResId = R.drawable.lumia;
					break;
				case 3:
					imageResId = R.drawable.lumia2;
					break;
				default:
					imageResId = R.drawable.lumia3;
			}
			/*Bitmap bitmap = getBitmapFromMemCache(imageResId);
			if (bitmap == null) {
				bitmap = BitmapFactory.decodeResource(mContext.getResources(), imageResId);
				addBitmapToMemoryCache(imageResId, bitmap);
			}*/
			v.setImageResource(imageResId);		
		}
		/*private void addBitmapToMemoryCache(int key, Bitmap bitmap) {
			if (getBitmapFromMemCache(key) == null) {
				mMemoryCache.put(key, bitmap);
			}
		}
		private Bitmap getBitmapFromMemCache(int key) {
			return mMemoryCache.get(key);
		}*/
	}
}
