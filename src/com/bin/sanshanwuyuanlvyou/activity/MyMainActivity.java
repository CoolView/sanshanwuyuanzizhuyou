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
        
	      //���ɶ�̬���飬����ת������  
	      ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
	      for(int i=0;i<imageIds.length;i++)  
	      {  
	        HashMap<String, Object> listItem = new HashMap<String, Object>();  
	        listItem.put("ItemImage", imageIds[i]);//���ͼ����Դ��ID  
//	        listItem.put("ItemText", "NO."+String.valueOf(i));//�������ItemText  
	        lstImageItem.add(listItem);  
	      }  
	      //������������ImageItem <====> ��̬�����Ԫ�أ�����һһ��Ӧ  
	      SimpleAdapter saImageItems = new SimpleAdapter(this, //ûʲô����  
	                                                lstImageItem,//������Դ   
	                                                R.layout.jingqu_item,//jingqu_item��XMLʵ��  
	                                                  
	                                                //��̬������ImageItem��Ӧ������          
	                                                new String[] {"ItemImage"},   
	                                                  
	                                                //ImageItem��XML�ļ������һ��ImageView,����TextView ID  
	                                                new int[] {R.id.ItemImage});  
	      //��Ӳ�����ʾ  
	      gridview.setAdapter(saImageItems);  
	      //�����Ϣ����  
	      gridview.setOnItemClickListener(new ItemClickListener());  
	  }  
	    
	// ��AdapterView������(���������߼���)���򷵻ص�Item�����¼�
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
