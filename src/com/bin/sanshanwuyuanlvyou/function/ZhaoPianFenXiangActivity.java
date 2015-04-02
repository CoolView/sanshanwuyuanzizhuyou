package com.bin.sanshanwuyuanlvyou.function;


import java.io.File;
import java.text.DateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bin.sanshanwuyuanlvyou.R;

public class ZhaoPianFenXiangActivity extends Activity {
	private Button btn_bySysCamera;
	private static final String TAG = "main";
	private static String FILE_PATH = "/sdcard/";
	private ImageView iv_CameraImg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhaopianfenxiang_layout);
		
		btn_bySysCamera = (Button) findViewById(R.id.btn_bySysCamera);

		btn_bySysCamera.setOnClickListener(click);
		iv_CameraImg = (ImageView) findViewById(R.id.iv_CameraImg);
	}
	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent=null;
			switch (v.getId()) {
			case R.id.btn_bySysCamera:
				intent = new Intent();
				// ָ������ϵͳ�����Action
				intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				// �����ļ���ַ�����ļ�
				Date date = new Date(); 
				DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
				String dateStr = dateFormat.format(date);
				FILE_PATH = FILE_PATH + dateStr +".jpg";
				File file = new File(FILE_PATH);
				
				if (file.exists()) {
					file.delete();
				}
				// ���ļ���ַת����Uri��ʽ
				Uri uri = Uri.fromFile(file);
				// ����ϵͳ���������Ƭ��ɺ�ͼƬ�ļ��Ĵ�ŵ�ַ
				intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
				startActivityForResult(intent, 0);
				break;
			default:
				break;
			}

		}
	};
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i(TAG, "ϵͳ���������ɣ�resultCode="+resultCode);
		
		if (requestCode == 0) {
			File file = new File(FILE_PATH);
			Uri uri = Uri.fromFile(file);
			iv_CameraImg.setImageURI(uri);
		} else if (requestCode == 1) {
			Log.i(TAG, "Ĭ��content��ַ��"+data.getData());
			iv_CameraImg.setImageURI(data.getData());
		}
	}
}

