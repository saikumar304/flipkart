package com.example.flipkart;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class SearchPage extends Activity{
	Intent intent;
	
	public void onCreate(Bundle v){
		super.onCreate(v);
		setContentView(R.layout.searchpage);
		InputMethodManager imm = (InputMethodManager)
				SearchPage.this.getSystemService(Context.INPUT_METHOD_SERVICE);

			if (imm != null){
			    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
			}
		intent=new Intent(this,SearchResultPage.class);
		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autocomplete_country);
		// Get the string array
		String[] countries = getResources().getStringArray(R.array.countries_array);
		// Create the adapter and set it to the AutoCompleteTextView 
		ArrayAdapter<String> adapter = 
		        new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
		textView.setAdapter(adapter);
		textView.setOnItemClickListener(new OnItemClickListener() {
		    @Override
		    public void onItemClick (AdapterView<?> parent, View view, int position, long id) {	
		    	startActivity(intent);
				overridePendingTransition  (R.anim.in_from_right, R.anim.out_to_left);
		    }
		});
	}
	public void onBackPressed(){
		super.onBackPressed();
		overridePendingTransition  (R.anim.in_from_left, R.anim.out_to_right);
	}
	public void autoclicked(View v){
		System.out.println("clkaldksk");
	}
}
