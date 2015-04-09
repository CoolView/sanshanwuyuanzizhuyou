package com.bin.sanshanwuyuanlvyou.function;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

import com.bin.sanshanwuyuanlvyou.R;

public class ZhaoPianFenXiangActivity extends Activity {
	private Button btn_bySysCamera, btn_fenxiang;
	private static final String TAG = "main";
	private static String FILE_PATH = getSDPath() + File.separator
			+ "sanshanwuyuan/";
	private ImageView iv_CameraImg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zhaopianfenxiang_layout);
		// ���ļ��в����� ���ȴ����ļ���
		File path = new File(FILE_PATH);
		if (!path.exists()) {
			path.mkdirs();
		}
		ShareSDK.initSDK(this);
		btn_bySysCamera = (Button) findViewById(R.id.btn_bySysCamera);

		btn_bySysCamera.setOnClickListener(click);
		btn_fenxiang = (Button) findViewById(R.id.btn_fenxiang);
		btn_fenxiang.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showShare();
			}
		});
		iv_CameraImg = (ImageView) findViewById(R.id.iv_CameraImg);
	}
	private File fileImage; 
	private View.OnClickListener click = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = null;
			switch (v.getId()) {
			case R.id.btn_bySysCamera:
				intent = new Intent();
				// ָ������ϵͳ�����Action
				intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				// �����ļ���ַ�����ļ�
				Date date = new Date();
				DateFormat dateFormat = DateFormat.getDateTimeInstance();// getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
				String dateStr = dateFormat.format(date);
				// FILE_PATH = FILE_PATH + dateStr +".jpg";
				fileImage = new File(FILE_PATH, dateStr + ".jpg");

				if (fileImage.exists()) {
					fileImage.delete();
				}
				// ���ļ���ַת����Uri��ʽ
				Uri uri = Uri.fromFile(fileImage);
				// ����ϵͳ���������Ƭ��ɺ�ͼƬ�ļ��Ĵ�ŵ�ַ
				intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
				startActivityForResult(intent, 0);
				break;
			default:
				break;
			}

		}
	};

	private void showShare() {
		ShareSDK.initSDK(this);
		OnekeyShare oks = new OnekeyShare();
		// �ر�sso��Ȩ
		oks.disableSSOWhenAuthorize();

		// ����ʱNotification��ͼ������� 2.5.9�Ժ�İ汾�����ô˷���
		// oks.setNotification(R.drawable.ic_launcher,
		// getString(R.string.app_name));
		// title���⣬ӡ��ʼǡ����䡢��Ϣ��΢�š���������QQ�ռ�ʹ��
		oks.setTitle(getString(R.string.share));
		// titleUrl�Ǳ�����������ӣ�������������QQ�ռ�ʹ��
		oks.setTitleUrl("http://sharesdk.cn");
		// text�Ƿ����ı�������ƽ̨����Ҫ����ֶ�
		oks.setText("�����ı�");
		// imagePath��ͼƬ�ı���·����Linked-In�����ƽ̨��֧�ִ˲���

		if (!FILE_PATH.equals(getSDPath() + File.separator + "sanshanwuyuan/"))
			oks.setImagePath(FILE_PATH);// ȷ��SDcard������ڴ���ͼƬ
		// url����΢�ţ��������Ѻ�����Ȧ����ʹ��
		oks.setUrl("http://sharesdk.cn");
		// comment���Ҷ�������������ۣ�������������QQ�ռ�ʹ��
		oks.setComment("���ǲ��������ı�");
		// site�Ƿ�������ݵ���վ���ƣ�����QQ�ռ�ʹ��
		oks.setSite(getString(R.string.app_name));
		// siteUrl�Ƿ�������ݵ���վ��ַ������QQ�ռ�ʹ��
		oks.setSiteUrl("http://sharesdk.cn");

		// ��������GUI
		oks.show(this);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i(TAG, "ϵͳ���������ɣ�resultCode=" + resultCode);

		if (requestCode == 0) {
			File file = fileImage;
			Uri uri = Uri.fromFile(file);
			iv_CameraImg.setImageURI(uri);
		} else if (requestCode == 1) {
			Log.i(TAG, "Ĭ��content��ַ��" + data.getData());
			iv_CameraImg.setImageURI(data.getData());
		}
	}

	/**
	 * ��ȡsd����·��
	 * 
	 * @return ·�����ַ���
	 */
	public static String getSDPath() {
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED); // �ж�sd���Ƿ����
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory();// ��ȡ���Ŀ¼
		}
		return sdDir.toString();
	}
}
