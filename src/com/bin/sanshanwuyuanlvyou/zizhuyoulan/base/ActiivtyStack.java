package com.bin.sanshanwuyuanlvyou.zizhuyoulan.base;

import java.util.Stack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class ActiivtyStack {
	private Stack<Fragment> mActivityStack;
	private FragmentManager fm;

	public ActiivtyStack(FragmentManager fm) {
		this.fm = fm;
		mActivityStack = new Stack<Fragment>();
	}

	// 閫�嚭鏍堥《Activity
	public void popActivity(Fragment activity) {
		if (activity != null) {
			mActivityStack.remove(activity);
			fm.popBackStack();
			// mActivityStack.pop();
			activity = null;
		}
	}

	// 鑾峰緱褰撳墠鏍堥《Activity
	public Fragment currentActivity() {
		Fragment activity = mActivityStack.lastElement();
		// Activity activity = mActivityStack.pop();
		return activity;
	}

	// 灏嗗綋鍓岮ctivity鎺ㄥ叆鏍堜腑
	public void pushActivity(Fragment activity) {
		mActivityStack.add(activity);
		// mActivityStack.push(activity);
	}

	// 閫�嚭鏍堜腑鎵�湁Activity
	public void popAllActivityExceptOne(Class<Fragment> cls) {
		while (true) {
			Fragment activity = currentActivity();
			if (activity == null) {
				break;
			}
			if (activity.getClass().equals(cls)) {
				break;
			}
			popActivity(activity);
		}
	}

	public int getFragmentSize() {
		return mActivityStack.size();
	}
}
