package com.bin.sanshanwuyuanlvyou.function;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bin.sanshanwuyuanlvyou.R;

public class ZuJiLieBiaoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zujiliebiao);
		// 获取目录下指定文件
//		File dir = new File("/data/data/com.bin.sanshanwuyuanlvyou/files/");
		File dir = new File("/mnt/sdcard/");

		String[] names = dir.list(new SuffixFilter("latLng"));// 获取目录下含latLng的文件
		if (names!= null) {
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(
					ZuJiLieBiaoActivity.this,
					android.R.layout.simple_list_item_1, names);
			ListView listView = (ListView) findViewById(R.id.list_zuji);
			listView.setAdapter(adapter);
			listView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int positon, long id) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(ZuJiLieBiaoActivity.this,XianShiZuJiActivity.class);
					intent.putExtra("id", positon);
					Log.d("xixixiixixix", positon+"");
					startActivity(intent);
				}
			});
		}
	}
}
