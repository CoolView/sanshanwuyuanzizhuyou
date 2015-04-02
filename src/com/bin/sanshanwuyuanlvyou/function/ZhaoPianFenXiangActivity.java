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
				// 指定开启系统相机的Action
				intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				// 根据文件地址创建文件
				Date date = new Date(); 
				DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
				String dateStr = dateFormat.format(date);
				FILE_PATH = FILE_PATH + dateStr +".jpg";
				File file = new File(FILE_PATH);
				
				if (file.exists()) {
					file.delete();
				}
				// 把文件地址转换成Uri格式
				Uri uri = Uri.fromFile(file);
				// 设置系统相机拍摄照片完成后图片文件的存放地址
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
		Log.i(TAG, "系统相机拍照完成，resultCode="+resultCode);
		
		if (requestCode == 0) {
			File file = new File(FILE_PATH);
			Uri uri = Uri.fromFile(file);
			iv_CameraImg.setImageURI(uri);
		} else if (requestCode == 1) {
			Log.i(TAG, "默认content地址："+data.getData());
			iv_CameraImg.setImageURI(data.getData());
		}
	}
}

