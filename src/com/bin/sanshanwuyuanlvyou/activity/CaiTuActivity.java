package com.bin.sanshanwuyuanlvyou.activity;

import com.bin.sanshanwuyuanlvyou.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CaiTuActivity extends Activity {
	
	TextView titleText;
	TextView caiTuShuoMing;
	ImageView caiTuGuDai;
	ImageView caiTuXianDai;
	Button caiTuChaKan;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caitu);
		
		titleText = (TextView) findViewById(R.id.title_text);
		titleText.setText("猜猜这是哪");
		caiTuGuDai = (ImageView) findViewById(R.id.caitu_gudai);
		caiTuGuDai.setBackgroundResource(R.drawable.caitu_gudai);
		caiTuXianDai = (ImageView) findViewById(R.id.caitu_xiandai);
		
		caiTuShuoMing = (TextView) findViewById(R.id.caitu_shuoming);
		
		caiTuChaKan = (Button) findViewById(R.id.caitu_chakan);
		caiTuChaKan.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				caiTuXianDai.setBackgroundResource(R.drawable.caitu_xiandai);
				caiTuXianDai.setVisibility(View.VISIBLE);
				caiTuShuoMing.setText("这是那那那那那那那那那那那那那那那那");
				caiTuShuoMing.setVisibility(View.VISIBLE);
			}
		});
		
	}
}
