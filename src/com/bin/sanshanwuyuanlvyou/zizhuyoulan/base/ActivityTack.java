package com.bin.sanshanwuyuanlvyou.zizhuyoulan.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.content.Context;

/**
 * activity 鏍堢鐞�
 * @author duohuo-jinghao
 *
 */
public class ActivityTack {
	
	
	public 	 List<Activity> activityList=new ArrayList<Activity>();
	
	public static ActivityTack tack=new ActivityTack();
	
	public static  ActivityTack getInstanse(){
		return tack;
	}
	
	private ActivityTack(){
		
	}
	
	public  void addActivity(Activity activity){
		activityList.add(activity);
	}
	
	public  void removeActivity(Activity activity){
		activityList.remove(activity);
	}
	
	/**
	 * 瀹屽叏閫�嚭
	 * @param context
	 */
	public  void exit(Context context){
		while (activityList.size()>0) {
			activityList.get(activityList.size()-1).finish();
		}
	    System.exit(0);
	}
	
	
	/**
	 * 鏍规嵁class name鑾峰彇activity
	 * @param name
	 * @return
	 */
	public Activity getActivityByClassName(String name){
		for(Activity ac:activityList){
			if(ac.getClass().getName().indexOf(name)>=0)
			{
		      	return ac;	
			}
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public Activity getActivityByClass(Class cs){
		for(Activity ac:activityList){
			if(ac.getClass().equals(cs))
			{
		      	return ac;	
			}
		}
		return null;
	}
	
	/**
	 * 寮瑰嚭activity
	 * @param activity
	 */
	public void popActivity(Activity activity){
		removeActivity(activity);
		activity.finish();
	}
	
	
	/**
	 * 寮瑰嚭activity鍒�
	 * @param cs
	 */
	@SuppressWarnings("rawtypes")
	public void popUntilActivity(Class... cs){
		List<Activity> list=new ArrayList<Activity>();
		 for (int i = activityList.size()-1; i>=0; i--){
			 Activity ac= activityList.get(i);
			 boolean isTop=false;
			 for (int j = 0; j < cs.length; j++) {
				 if(ac.getClass().equals(cs[j])){
					 isTop=true;
					 break;
				 }
			}
			 if(!isTop){
				 list.add(ac);
			 }else break;
		}
		 for (Iterator<Activity> iterator = list.iterator(); iterator.hasNext();) {
				Activity activity = iterator.next();
				popActivity(activity);
		  }
	}
}
