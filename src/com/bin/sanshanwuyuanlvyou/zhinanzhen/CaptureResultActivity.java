package com.bin.sanshanwuyuanlvyou.zhinanzhen;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bin.sanshanwuyuanlvyou.R;
import com.google.zxing.client.android.Intents;

public class CaptureResultActivity extends Activity {
	private TextView tvResult;
	private Button btOpenAddress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_capture_result);
		tvResult = (TextView) findViewById(R.id.tv_result);
		btOpenAddress = (Button) findViewById(R.id.bt_open_address);
		initData();
	}

	private void initData() {

		final Intent intent = getIntent();
		if (null != intent) {
			tvResult.setText(intent.getStringExtra(Intents.Scan.RESULT));
			btOpenAddress.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					String address = intent.getStringExtra(Intents.Scan.RESULT);
					Log.d("hahhahhaha", address);
					// 更多隐式意图用法
					// 调用浏览器打开网页
					if (address != null)
						if (address.startsWith("http://")) {
							Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri
									.parse(address));
							// intent2.setData(Uri.parse("address"));
							startActivity(intent2);
						}else {
							Toast.makeText(getApplicationContext(), "网址才可以使用浏览器打开", Toast.LENGTH_SHORT).show();
						}

				}
			});

		}
	}
}
