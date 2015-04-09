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
		// 若文件夹不存在 首先创建文件夹
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
				// 指定开启系统相机的Action
				intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.addCategory(Intent.CATEGORY_DEFAULT);
				// 根据文件地址创建文件
				Date date = new Date();
				DateFormat dateFormat = DateFormat.getDateTimeInstance();// getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
				String dateStr = dateFormat.format(date);
				// FILE_PATH = FILE_PATH + dateStr +".jpg";
				fileImage = new File(FILE_PATH, dateStr + ".jpg");

				if (fileImage.exists()) {
					fileImage.delete();
				}
				// 把文件地址转换成Uri格式
				Uri uri = Uri.fromFile(fileImage);
				// 设置系统相机拍摄照片完成后图片文件的存放地址
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
		// 关闭sso授权
		oks.disableSSOWhenAuthorize();

		// 分享时Notification的图标和文字 2.5.9以后的版本不调用此方法
		// oks.setNotification(R.drawable.ic_launcher,
		// getString(R.string.app_name));
		// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
		oks.setTitle(getString(R.string.share));
		// titleUrl是标题的网络链接，仅在人人网和QQ空间使用
		oks.setTitleUrl("http://sharesdk.cn");
		// text是分享文本，所有平台都需要这个字段
		oks.setText("分享文本");
		// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数

		if (!FILE_PATH.equals(getSDPath() + File.separator + "sanshanwuyuan/"))
			oks.setImagePath(FILE_PATH);// 确保SDcard下面存在此张图片
		// url仅在微信（包括好友和朋友圈）中使用
		oks.setUrl("http://sharesdk.cn");
		// comment是我对这条分享的评论，仅在人人网和QQ空间使用
		oks.setComment("我是测试评论文本");
		// site是分享此内容的网站名称，仅在QQ空间使用
		oks.setSite(getString(R.string.app_name));
		// siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl("http://sharesdk.cn");

		// 启动分享GUI
		oks.show(this);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.i(TAG, "系统相机拍照完成，resultCode=" + resultCode);

		if (requestCode == 0) {
			File file = fileImage;
			Uri uri = Uri.fromFile(file);
			iv_CameraImg.setImageURI(uri);
		} else if (requestCode == 1) {
			Log.i(TAG, "默认content地址：" + data.getData());
			iv_CameraImg.setImageURI(data.getData());
		}
	}

	/**
	 * 获取sd卡的路径
	 * 
	 * @return 路径的字符串
	 */
	public static String getSDPath() {
		File sdDir = null;
		boolean sdCardExist = Environment.getExternalStorageState().equals(
				android.os.Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory();// 获取外存目录
		}
		return sdDir.toString();
	}
}
