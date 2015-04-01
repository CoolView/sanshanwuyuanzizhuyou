package com.bin.sanshanwuyuanlvyou.activity;

import com.bin.sanshanwuyuanlvyou.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends Activity {
	protected void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.activity_welcome);
	}

	protected void onStart() {
		super.onStart();
		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent localIntent = new Intent(WelcomeActivity.this,
						MyMainActivity.class);
				WelcomeActivity.this.startActivity(localIntent);
				WelcomeActivity.this.finish();
			}
		}, 2000L);
	}
}
