package com.bin.sanshanwuyuanlvyou.function;


import com.bin.sanshanwuyuanlvyou.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class HuoDongInfoActivity extends Activity {
	TextView textView;
	TextView titleText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.huodonginfo_layout);
		
		Intent intent = getIntent();
		int id = intent.getIntExtra("ID", 0);
		
		textView = (TextView) findViewById(R.id.tv_huodonginfo);
		titleText = (TextView) findViewById(R.id.title_text);
		switch (id) {
		case 0:
			titleText.setText("��ɽ���Ϣ");
			textView.setText("����");
			break;
		case 1:
			titleText.setText("����԰���Ϣ");
			textView.setText("����");
			break;
		case 2:
			titleText.setText("����԰���Ϣ");
			textView.setText("����");
			break;
		case 3:
			titleText.setText("����԰���Ϣ");
			textView.setText("����");
			break;
		case 4:
			titleText.setText("����ɽ���Ϣ");
			textView.setText("����");
			break;
		case 5:
			titleText.setText("�ú�԰���Ϣ");
			textView.setText("����");
			break;
		case 6:
			titleText.setText("Բ��԰���Ϣ");
			textView.setText("����");
			break;
		case 7:
			titleText.setText("��Ȫɽ���Ϣ");
			textView.setText("����");
			break;
		default:
			break;
		}
	}
}
