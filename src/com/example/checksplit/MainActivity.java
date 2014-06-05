package com.example.checksplit;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	    WindowManager.LayoutParams.FLAG_FULLSCREEN);
	    
	    super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    Button beginButton = (Button) findViewById(R.id.beginButton);
	    OnClickListener listener = new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            Intent i = new Intent(MainActivity.this, InputPortal.class);
	            i.putExtra("userNumber", 0);
	            i.putExtra("billData", new ArrayList<Integer>());
	            startActivity(i);
	            finish();
	        }
	    };	
	    beginButton.setOnClickListener(listener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
