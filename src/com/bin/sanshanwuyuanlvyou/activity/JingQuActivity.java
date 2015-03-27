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
			titleText.setText("����԰");
			imageView.setBackgroundResource(R.drawable.image_changchunyuan);
			jingQu = 1;
			myShow();
			break;
		case R.drawable.jingmingyuan:
			titleText.setText("����԰");
			imageView.setBackgroundResource(R.drawable.image_jingmingyuan);
			jingQu =2;
			myShow();
			break;
		case R.drawable.jingyiyuan:
			titleText.setText("����԰");
			imageView.setBackgroundResource(R.drawable.image_jingyiyuan);
			jingQu =3;
			myShow();
			break;
		case R.drawable.wanshoushan:
			titleText.setText("����ɽ");
			imageView.setBackgroundResource(R.drawable.image_wanshoushan);
			jingQu = 4;
			myShow();
			break;
		case R.drawable.xiangshan:
			titleText.setText("��ɽ");
			imageView.setBackgroundResource(R.drawable.image_xiangshan);
			jingQu = 0;
			myShow();
			break;
		case R.drawable.yiheyuan:
			titleText.setText("�ú�԰");
			imageView.setBackgroundResource(R.drawable.imag_yiheyuan);
			jingQu = 5;
			myShow();
			break;
		case R.drawable.yuanmingyuan:
			titleText.setText("Բ��԰");
			imageView.setBackgroundResource(R.drawable.image_yuanmingyuan);
			jingQu = 6;
			myShow();
			break;
		case R.drawable.yuquanshan:
			titleText.setText("��Ȫɽ");
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

		// ���ɶ�̬���飬����ת������
		ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < imageIds.length; i++) {
			HashMap<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("ItemImage", imageIds[i]);// ���ͼ����Դ��ID
			// listItem.put("ItemText", "NO."+String.valueOf(i));//�������ItemText
			lstImageItem.add(listItem);
		}
		// ������������ImageItem <====> ��̬�����Ԫ�أ�����һһ��Ӧ
		SimpleAdapter saImageItems = new SimpleAdapter(this, // ûʲô����
				lstImageItem,// ������Դ
				R.layout.jingqu_item,// jingqu_item��XMLʵ��
				// ��̬������ImageItem��Ӧ������
				new String[] { "ItemImage" },
				// ImageItem��XML�ļ������һ��ImageView,����TextView ID
				new int[] { R.id.ItemImage });
		// ��Ӳ�����ʾ
		gridview.setAdapter(saImageItems);
		// �����Ϣ����
		gridview.setOnItemClickListener(new ItemClickListener());

	}

	// ��AdapterView������(���������߼���)���򷵻ص�Item�����¼�
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
