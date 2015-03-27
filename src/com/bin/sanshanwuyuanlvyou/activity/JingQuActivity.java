package com.bin.sanshanwuyuanlvyou.activity;

import java.util.ArrayList;
import java.util.HashMap;

import com.bin.sanshanwuyuanlvyou.R;
import com.bin.sanshanwuyuanlvyou.function.GongYuanJieShaoActivity;
import com.bin.sanshanwuyuanlvyou.function.HuoDongInfoActivity;
import com.bin.sanshanwuyuanlvyou.function.JingDianJieShaoActivity;
import com.bin.sanshanwuyuanlvyou.function.LiuXiaZuJiActivity;
import com.bin.sanshanwuyuanlvyou.function.TuiJianLuXianActivity;
import com.bin.sanshanwuyuanlvyou.function.ZhaoPianFenXiangActivity;
import com.bin.sanshanwuyuanlvyou.function.ZhouBianJieShaoActivity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class JingQuActivity extends Activity {
	TextView titleText;
	ImageView imageView;
	int[] imageIds = new int[] { R.drawable.gongyuanjianjie,
			R.drawable.huodongxinxi, R.drawable.jingdianjieshao,
			R.drawable.liuxiazuji, R.drawable.tuijianluxian,
			R.drawable.zhaopianfenxiang, R.drawable.zhoubianjiaotong,
			R.drawable.zhoubianjieshao };
	int jingQu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jingqu);
		Intent myIntent = getIntent();
		int id = myIntent.getIntExtra("mJingQuInfo", 0);

		titleText = (TextView) findViewById(R.id.title_text);
		imageView = (ImageView) findViewById(R.id.image_jingdian2);
		
		switch (id) {
		case R.drawable.changchunyuan:
			titleText.setText("畅春园");
			imageView.setBackgroundResource(R.drawable.image_changchunyuan);
			jingQu = 1;
			myShow();
			break;
		case R.drawable.jingmingyuan:
			titleText.setText("静明园");
			imageView.setBackgroundResource(R.drawable.image_jingmingyuan);
			jingQu =2;
			myShow();
			break;
		case R.drawable.jingyiyuan:
			titleText.setText("静宜园");
			imageView.setBackgroundResource(R.drawable.image_jingyiyuan);
			jingQu =3;
			myShow();
			break;
		case R.drawable.wanshoushan:
			titleText.setText("万寿山");
			imageView.setBackgroundResource(R.drawable.image_wanshoushan);
			jingQu = 4;
			myShow();
			break;
		case R.drawable.xiangshan:
			titleText.setText("香山");
			imageView.setBackgroundResource(R.drawable.image_xiangshan);
			jingQu = 0;
			myShow();
			break;
		case R.drawable.yiheyuan:
			titleText.setText("颐和园");
			imageView.setBackgroundResource(R.drawable.imag_yiheyuan);
			jingQu = 5;
			myShow();
			break;
		case R.drawable.yuanmingyuan:
			titleText.setText("圆明园");
			imageView.setBackgroundResource(R.drawable.image_yuanmingyuan);
			jingQu = 6;
			myShow();
			break;
		case R.drawable.yuquanshan:
			titleText.setText("玉泉山");
			imageView.setBackgroundResource(R.drawable.image_yuquanshan);
			jingQu = 7;
			myShow();
			break;
		default:
			break;
		}
	}

	private void myShow() {
		GridView gridview = (GridView) findViewById(R.id.gridview1);

		// 生成动态数组，并且转入数据
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < imageIds.length; i++) {
			HashMap<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("ItemImage", imageIds[i]);// 添加图像资源的ID
			// listItem.put("ItemText", "NO."+String.valueOf(i));//按序号做ItemText
			lstImageItem.add(listItem);
		}
		// 生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
		SimpleAdapter saImageItems = new SimpleAdapter(this, // 没什么解释
				lstImageItem,// 数据来源
				R.layout.jingqu_item,// jingqu_item的XML实现
				// 动态数组与ImageItem对应的子项
				new String[] { "ItemImage" },
				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.ItemImage });
		// 添加并且显示
		gridview.setAdapter(saImageItems);
		// 添加消息处理
		gridview.setOnItemClickListener(new ItemClickListener());

	}

	// 当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
	class ItemClickListener implements OnItemClickListener {
		public void onItemClick(AdapterView<?> parent,// The AdapterView where
														// the
														// click happened
				View view,// The view within the AdapterView that was clicked
				int position,// The position of the view in the adapter
				long id// The row id of the item that was clicked
		) {
			Intent intent;
			switch (imageIds[position]) {
			case R.drawable.gongyuanjianjie:
				intent = new Intent(getApplicationContext(),
						GongYuanJieShaoActivity.class);
				intent.putExtra("ID", jingQu);
				startActivity(intent);
				break;
			case R.drawable.huodongxinxi:
				intent = new Intent(getApplicationContext(),
						HuoDongInfoActivity.class);
				intent.putExtra("ID", jingQu);
				startActivity(intent);
				break;
			case R.drawable.jingdianjieshao:
				intent = new Intent(getApplicationContext(),
						JingDianJieShaoActivity.class);
				intent.putExtra("ID", jingQu);
				startActivity(intent);
				break;
			case R.drawable.liuxiazuji:
				intent = new Intent(getApplicationContext(),
						LiuXiaZuJiActivity.class);
				intent.putExtra("ID", jingQu);
				startActivity(intent);
				break;
			case R.drawable.tuijianluxian:
				intent = new Intent(getApplicationContext(),
						TuiJianLuXianActivity.class);
				intent.putExtra("ID", jingQu);
				startActivity(intent);
				break;
			case R.drawable.zhaopianfenxiang:
				intent = new Intent(getApplicationContext(),
						ZhaoPianFenXiangActivity.class);
				intent.putExtra("ID", jingQu);
				startActivity(intent);
				break;
			case R.drawable.zhoubianjiaotong:
				intent = new Intent(getApplicationContext(),
						ZhouBianJieShaoActivity.class);
				intent.putExtra("ID", jingQu);
				startActivity(intent);
				break;
			case R.drawable.zhoubianjieshao:
				intent = new Intent(getApplicationContext(),
						ZhouBianJieShaoActivity.class);
				intent.putExtra("ID", jingQu);
				startActivity(intent);
				break;

			default:
				break;
			}

		}
	}
}
