package com.bin.sanshanwuyuanlvyou.function;

import java.io.File;
import java.io.FileOutputStream;

import com.bin.sanshanwuyuanlvyou.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;


public class LiuXiaZuJiActivity extends Activity {
	static String mLocationInfo;
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.liuxiazuji_layout);

		Intent intent = getIntent();
		mLocationInfo = intent.getStringExtra("mLocationInfo");

		TextView tv_liuXiaZuJi_info = (TextView) findViewById(R.id.tv_liuxiazuji_info);
		tv_liuXiaZuJi_info.setText(mLocationInfo);

		if (mLocationInfo
				.equals(new String(
						"您所在的位置：null当前时间为：null定位精度：0米纬度：4.9E-324经度：4.9E-324距离您最近的景区为：万寿山9589637米"))) {
			Toast.makeText(this, "定位失败，请返回主页重新定位", Toast.LENGTH_LONG).show();
		} else if (saveUserInfo(this)) {
			Toast.makeText(this, "足迹记录成功，请到SDcard下查看MyLocationInfo.txt文件", Toast.LENGTH_LONG)
					.show();
		}else {
			Toast.makeText(this, "定位失败，请返回主页重新定位", Toast.LENGTH_LONG).show();
		}
		
	}

	public static boolean saveUserInfo(Context context) {
		try {
			// 判断当前的手机是否有sd卡
			String state = Environment.getExternalStorageState();
			if (!Environment.MEDIA_MOUNTED.equals(state)) {
				// 已经挂载了sd卡
				return false;
			}
			// 获得SD卡位置
			File sdCardFile = Environment.getExternalStorageDirectory();

			File file = new File(sdCardFile,
					"MyLocationInfo.txt");
			FileOutputStream fos = new FileOutputStream(file, true);

			String data = mLocationInfo + LINE_SEPARATOR;
			fos.write(data.getBytes());

			fos.flush();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
