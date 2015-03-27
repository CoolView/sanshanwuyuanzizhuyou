package com.bin.sanshanwuyuanlvyou.zizhuyoulan.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;

import com.bin.sanshanwuyuanlvyou.zizhuyoulan.utils.T;


public abstract class BaseActivity extends FragmentActivity {

	/**
	 * 灞忓箷鐨勫搴︺�楂樺害銆佸瘑搴�
	 */
	protected int mScreenWidth;
	protected int mScreenHeight;
	protected float mDensity;
	protected Context mContext;
	protected String LogName; // 鎵撳嵃鐨勫悕绉�
	protected ImageView titleBack;
	protected TextView titleName;
	protected TextView titleRightText;

	private static String mDialogTag = "basedialog";

	protected Boolean isfinish = false;
	protected ActivityTack tack = ActivityTack.getInstanse();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	     requestWindowFeature(Window.FEATURE_NO_TITLE);
		// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
		// WindowManager.LayoutParams.FLAG_FULLSCREEN);
		mContext = this;
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		mScreenWidth = metric.widthPixels;
		mScreenHeight = metric.heightPixels;
		mDensity = metric.density;
		LogName = this.getClass().getSimpleName();
		tack.addActivity(this);

	}

	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		super.setContentView(layoutResID);
		ButterKnife.inject(this);

	}

	/** 閫氳繃Class璺宠浆鐣岄潰 **/
	protected void startActivity(Class<?> cls) {
		startActivity(cls, null);
	}

	/** 鍚湁Bundle閫氳繃Class璺宠浆鐣岄潰 **/
	protected void startActivity(Class<?> cls, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(this, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	/** 閫氳繃Action璺宠浆鐣岄潰 **/
	protected void startActivity(String action) {
		startActivity(action, null);
	}

	/** 鍚湁Bundle閫氳繃Action璺宠浆鐣岄潰 **/
	protected void startActivity(String action, Bundle bundle) {
		Intent intent = new Intent();
		intent.setAction(action);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
	}

	// /**
	// * 鍚愬徃
	// *
	// * @param message
	// */
	protected void showShort(String message) {
		T.showShort(mContext, message);
	}

	protected void showLong(String message) {
		T.showLong(mContext, message);
	}

	@Override
	public void finish() {
		super.finish();
		tack.removeActivity(this);

	}

}
