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
		titleText.setText("关于");
		textAbout = (TextView) findViewById(R.id.info);
		String html="<center><h1>三山五园自助游</h1></center>" +
				"<p> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 简单实用，三山五园地区旅游必备！带上它，一起游！" +
				"<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;实用的园区介绍和游玩线路推荐，" +
				"全面的周边信息，精确的地图导航，"+
				"精心打造三山五园地区特色旅游。"+
				"<p><h5>作者：XXX</h5>" +
				"<p><h5>电子邮件：XXXXXX@126.com</h5>";
		textAbout.setText(Html.fromHtml(html));
	}
}
