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
