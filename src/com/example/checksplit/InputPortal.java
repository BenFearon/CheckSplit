package com.example.checksplit;
import java.util.ArrayList;

import com.example.checksplit.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class InputPortal extends Activity {
	
	public ArrayList<Integer> billData;
	public int[] billCount = new int[4];
	public int userNumber = 0;
	
	public TextView t20;
	public TextView t10;
	public TextView t5;
	public TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
	    WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.input_portal);	
		
		//get previously entered data
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    billData = extras.getIntegerArrayList("billData");
		    userNumber = extras.getInt("userNumber");
		    Log.w("Data Received:", "Extras Downloaded");
		}
		
		//set up buttons
	    Button b20 = (Button) findViewById(R.id.twentyplus);
	    Button b10 = (Button) findViewById(R.id.tenplus);
	    Button b5 = (Button) findViewById(R.id.fiveplus);
	    Button b1 = (Button) findViewById(R.id.oneplus);
	    
	    Button m20 = (Button) findViewById(R.id.twentyminus);
	    Button m10 = (Button) findViewById(R.id.tenminus);
	    Button m5 = (Button) findViewById(R.id.fiveminus);
	    Button m1 = (Button) findViewById(R.id.oneminus);
	    
	    Button next = (Button) findViewById(R.id.next);

	    t20 = (TextView) findViewById(R.id.textView20);
	    t10 = (TextView) findViewById(R.id.textView10);
	    t5 = (TextView) findViewById(R.id.textView5);
	    t1 = (TextView) findViewById(R.id.textView1);
	    
	    OnClickListener listener = new OnClickListener() {
	        @Override
	        public void onClick(View v) {
	    		switch(v.getId()){
				case R.id.twentyplus:
					billCount[0]++;
					t20.setText(billCount[0]+"");
					break;
				case R.id.tenplus:
					billCount[1]++;
					t10.setText(billCount[1]+"");	
					break;
				case R.id.fiveplus:
					billCount[2]++;
					t5.setText(billCount[2]+"");
					break;
				case R.id.oneplus:
					billCount[3]++;
					t1.setText(billCount[3]+"");
					break;
				case R.id.twentyminus:
					if(billCount[0]!=0){
						billCount[0]--;
						t20.setText(billCount[0]+"");
					}
					break;
				case R.id.tenminus:
					if(billCount[1]!=0){
						billCount[1]--;
						t10.setText(billCount[1]+"");
					}
					break;
				case R.id.fiveminus:
					if(billCount[2]!=0){
						billCount[2]--;
						t5.setText(billCount[2]+"");
					}
					break;
				case R.id.oneminus:
					if(billCount[3]!=0){
						billCount[3]--;
						t1.setText(billCount[3]+"");
					}
					break;
				case R.id.next:
					for (int i = 0; i < billCount.length; i++) {
						billData.add(billCount[i]);
						Log.w("Data Written:", billCount[i]+"");
					}
					Intent i = new Intent(InputPortal.this, InputPortal.class);
		            i.putExtra("userNumber", 1+userNumber);
		            i.putExtra("billData", billData);
		            startActivity(i);
		            finish();
	    		}
	        }
	    };	
	    b20.setOnClickListener(listener);
	    b10.setOnClickListener(listener);
	    b5.setOnClickListener(listener);
	    b1.setOnClickListener(listener);
	    
	    m20.setOnClickListener(listener);
	    m10.setOnClickListener(listener);
	    m5.setOnClickListener(listener);
	    m1.setOnClickListener(listener);
	    next.setOnClickListener(listener);
	    
		for (int i = 0; i < billCount.length; i++) {
			billCount[i]=0;
		}
	}
}
