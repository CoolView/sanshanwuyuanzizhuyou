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
						"�����ڵ�λ�ã�null��ǰʱ��Ϊ��null��λ���ȣ�0��γ�ȣ�4.9E-324���ȣ�4.9E-324����������ľ���Ϊ������ɽ9589637��"))) {
			Toast.makeText(this, "��λʧ�ܣ��뷵����ҳ���¶�λ", Toast.LENGTH_LONG).show();
		} else if (saveUserInfo(this)) {
			Toast.makeText(this, "�㼣��¼�ɹ����뵽SDcard�²鿴MyLocationInfo.txt�ļ�", Toast.LENGTH_LONG)
					.show();
		}else {
			Toast.makeText(this, "��λʧ�ܣ��뷵����ҳ���¶�λ", Toast.LENGTH_LONG).show();
		}
		
	}

	public static boolean saveUserInfo(Context context) {
		try {
			// �жϵ�ǰ���ֻ��Ƿ���sd��
			String state = Environment.getExternalStorageState();
			if (!Environment.MEDIA_MOUNTED.equals(state)) {
				// �Ѿ�������sd��
				return false;
			}
			// ���SD��λ��
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
