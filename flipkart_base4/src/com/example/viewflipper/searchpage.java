package com.example.viewflipper;

import android.app.Activity;
import android.os.Bundle;

public class searchpage extends Activity{
	public void onCreate(Bundle v){
		super.onCreate(v);
		setContentView(R.layout.searchpage);
	}
	public void onBackPressed(){
		super.onBackPressed();
		overridePendingTransition  (R.anim.in_from_left, R.anim.out_to_right);
	}

}
