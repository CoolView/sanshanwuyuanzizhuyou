package com.bin.sanshanwuyuanlvyou.activity;

import com.bin.sanshanwuyuanlvyou.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class AboutActivity extends Activity {
	TextView textAbout;
	TextView titleText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		titleText = (TextView) findViewById(R.id.title_text);
		titleText.setText("����");
		textAbout = (TextView) findViewById(R.id.info);
		String html="<center><h1>��ɽ��԰������</h1></center>" +
				"<p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ��ʵ�ã���ɽ��԰�������αر�����������һ���Σ�" +
				"<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ʵ�õ�԰�����ܺ�������·�Ƽ���" +
				"ȫ����ܱ���Ϣ����ȷ�ĵ�ͼ������"+
				"���Ĵ�����ɽ��԰������ɫ���Ρ�"+
				"<p><h5>���ߣ�XXX</h5>" +
				"<p><h5>�����ʼ���XXXXXX@126.com</h5>";
		textAbout.setText(Html.fromHtml(html));
	}
}
