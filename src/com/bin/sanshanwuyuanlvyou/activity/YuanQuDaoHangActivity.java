package com.bin.sanshanwuyuanlvyou.activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.bin.sanshanwuyuanlvyou.R;



public class YuanQuDaoHangActivity extends Activity {
	int[] imageIds = new int[]{R.drawable.changchunyuan,R.drawable.jingmingyuan
    		,R.drawable.jingyiyuan,R.drawable.wanshoushan,R.drawable.xiangshan
    		,R.drawable.yiheyuan,R.drawable.yuanmingyuan,R.drawable.yuquanshan
    };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yuanqudaohang_layout);
		
		GridView gridview = (GridView) findViewById(R.id.gridview);  
        
	      //生成动态数组，并且转入数据  
	      ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
	      for(int i=0;i<imageIds.length;i++)  
	      {  
	        HashMap<String, Object> listItem = new HashMap<String, Object>();  
	        listItem.put("ItemImage", imageIds[i]);//添加图像资源的ID  
//	        listItem.put("ItemText", "NO."+String.valueOf(i));//按序号做ItemText  
	        lstImageItem.add(listItem);  
	      }  
	      //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应  
	      SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释  
	                                                lstImageItem,//数据来源   
	                                                R.layout.jingqu_item,//jingqu_item的XML实现  
	                                                  
	                                                //动态数组与ImageItem对应的子项          
	                                                new String[] {"ItemImage"},   
	                                                  
	                                                //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
	                                                new int[] {R.id.ItemImage});  
	      //添加并且显示  
	      gridview.setAdapter(saImageItems);  
	      //添加消息处理  
	      gridview.setOnItemClickListener(new ItemClickListener());  
	  }  
	    
	// 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
	class ItemClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> parent,// The AdapterView where the
													// click happened
				View view,// The view within the AdapterView that was clicked
				int position,// The position of the view in the adapter
				long id// The row id of the item that was clicked
		) {
			Intent intent = null;
			int mJingQuInfo = 0;
			switch (imageIds[position]) {
			case R.drawable.changchunyuan:
				intent = new Intent(YuanQuDaoHangActivity.this,JingQuActivity.class);
				mJingQuInfo = R.drawable.changchunyuan;
				intent.putExtra("mJingQuInfo", mJingQuInfo);
				break;
			case R.drawable.jingmingyuan:
				intent = new Intent(YuanQuDaoHangActivity.this,JingQuActivity.class);
				mJingQuInfo = R.drawable.jingmingyuan;
				intent.putExtra("mJingQuInfo", mJingQuInfo);
				break;
			case R.drawable.jingyiyuan:
				intent = new Intent(YuanQuDaoHangActivity.this,JingQuActivity.class);
				mJingQuInfo = R.drawable.jingyiyuan;
				intent.putExtra("mJingQuInfo", mJingQuInfo);
				break;
			case R.drawable.wanshoushan:
				intent = new Intent(YuanQuDaoHangActivity.this,JingQuActivity.class);
				mJingQuInfo = R.drawable.wanshoushan;
				intent.putExtra("mJingQuInfo", mJingQuInfo);
				break;
			case R.drawable.xiangshan:
				intent = new Intent(YuanQuDaoHangActivity.this,JingQuActivity.class);
				mJingQuInfo = R.drawable.xiangshan;
				intent.putExtra("mJingQuInfo", mJingQuInfo);
				break;
			case R.drawable.yiheyuan:
				intent = new Intent(YuanQuDaoHangActivity.this,JingQuActivity.class);
				mJingQuInfo = R.drawable.yiheyuan;
				intent.putExtra("mJingQuInfo", mJingQuInfo);
				break;
			case R.drawable.yuanmingyuan:
				intent = new Intent(YuanQuDaoHangActivity.this,JingQuActivity.class);
				mJingQuInfo = R.drawable.yuanmingyuan;
				intent.putExtra("mJingQuInfo", mJingQuInfo);
				break;
			case R.drawable.yuquanshan:
				intent = new Intent(YuanQuDaoHangActivity.this,JingQuActivity.class);
				mJingQuInfo = R.drawable.yuquanshan;
				intent.putExtra("mJingQuInfo", mJingQuInfo);
				break;
			default:
				break;
			}
			startActivity(intent);
		}
	}
}
