package com.bin.sanshanwuyuanlvyou.function;


import com.bin.sanshanwuyuanlvyou.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class HuoDongInfoActivity extends Activity {
	TextView textView;
	TextView titleText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.huodonginfo_layout);
		
		Intent intent = getIntent();
		int id = intent.getIntExtra("ID", 0);
		
		textView = (TextView) findViewById(R.id.tv_huodonginfo);
		titleText = (TextView) findViewById(R.id.title_text);
		switch (id) {
		case 0:
			titleText.setText("香山活动信息");
			textView.setText("暂无");
			break;
		case 1:
			titleText.setText("畅春园活动信息");
			textView.setText("暂无");
			break;
		case 2:
			titleText.setText("静明园活动信息");
			textView.setText("暂无");
			break;
		case 3:
			titleText.setText("静宜园活动信息");
			textView.setText("暂无");
			break;
		case 4:
			titleText.setText("万寿山活动信息");
			textView.setText("暂无");
			break;
		case 5:
			titleText.setText("颐和园活动信息");
			textView.setText("暂无");
			break;
		case 6:
			titleText.setText("圆明园活动信息");
			textView.setText("暂无");
			break;
		case 7:
			titleText.setText("玉泉山活动信息");
			textView.setText("暂无");
			break;
		default:
			break;
		}
	}
}
