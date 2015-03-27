package com.bin.sanshanwuyuanlvyou.activity;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;

import com.baidu.mapapi.SDKInitializer;
import com.bin.sanshanwuyuanlvyou.R;
import com.bin.sanshanwuyuanlvyou.notes.ui.NotesListActivity;
import com.bin.sanshanwuyuanlvyou.zizhuyoulan.ZiZhuYouLanActivity;

public class MyMainActivity extends Activity {
		int[] imageIds = new int[]{R.drawable.main_yuanqujieshao,R.drawable.main_zizhuyoulan
	    		,R.drawable.main_xianluchaxu,R.drawable.main_lvyoujilu
	    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		SDKInitializer.initialize(getApplicationContext());  
		setContentView(R.layout.myactivity_main);
		
		ImageButton imBt_Info = (ImageButton) findViewById(R.id.imb_info);
		imBt_Info.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MyMainActivity.this,AboutActivity.class);
				startActivity(intent);
			}
		});
		
		GridView gridview = (GridView) findViewById(R.id.main_gridview);  
        
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
			Intent intent;
			switch (imageIds[position]) {
			case R.drawable.main_yuanqujieshao:
				intent = new Intent(MyMainActivity.this,YuanQuDaoHangActivity.class);
				startActivity(intent);
				break;
			case R.drawable.main_zizhuyoulan:
				intent = new Intent(MyMainActivity.this,ZiZhuYouLanActivity.class);
				startActivity(intent);
				break;
			case R.drawable.main_xianluchaxu:
				intent = new Intent(MyMainActivity.this,XianLuChaXunActivity.class);
				startActivity(intent);
				break;
			case R.drawable.main_lvyoujilu:
				intent = new Intent(MyMainActivity.this,NotesListActivity.class);
				startActivity(intent);
				break;
			default:
				break;
			}
			
		}
	}

}
