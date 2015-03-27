package com.bin.sanshanwuyuanlvyou.function;


import com.bin.sanshanwuyuanlvyou.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class TuiJianLuXianActivity extends Activity {
	TextView textView;
	TextView titleText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.tuijianluxian_layout);
		
		Intent intent = getIntent();
		int id = intent.getIntExtra("ID", 0);
		
		textView = (TextView) findViewById(R.id.tv_tuijianluxian);
		titleText = (TextView) findViewById(R.id.title_text);
		switch (id) {
		case 0:
			titleText.setText("香山推荐路线");
			textView.setText("        香山公园游览路线：名山御园健康徒步线路，从香山致远斋遗址出发，历经柏林小区、玉乳泉路、栖月山庄、香雾窑（平台）、梯云山馆、芙蓉馆、知松园再回到致远斋遗址。");
			break;
		case 1:
			titleText.setText("畅春园推荐路线");
			textView.setText("        暂无数据");
			break;
		case 2:
			titleText.setText("静明园推荐路线");
			textView.setText("        暂无数据");
			break;
		case 3:
			titleText.setText("静宜园推荐路线");
			textView.setText("        暂无数据");
			break;
		case 4:
			titleText.setText("万寿山推荐路线");
			textView.setText("        暂无数据");
			break;
		case 5:
			titleText.setText("颐和园推荐路线");
			textView.setText("一、 东宫门入园： "
					+"\n        1．1小时路线"
					+"\n                东宫门--仁寿殿--德和园--玉澜堂--宜芸馆--乐寿堂--邀月门--游览结束 "
					+"\n        2．1.5小时路线方案"
					+"\n                东宫门--仁寿殿--德和园--玉澜堂--宜芸馆--乐寿堂--邀月门--长廊--昆明湖畔--排云门--游览结束"
					+"\n        3．2小时路线 "
					+"\n                东宫门--仁寿殿--德和园--玉澜堂--宜芸馆--乐寿堂--邀月门--长廊--昆明湖畔--排云殿--佛香阁--苏州街桥--游览结束"
					+"\n二、 北宫门入园："
					+"\n        2小时路线"
					+"\n                北宫门--苏州街--石舫--长廊--排云殿--佛香阁--乐寿堂--德和园--文昌院--仁寿殿--东宫门。"
					+"\n三、 新建宫门入园："
					+"\n        2.5小时路线"
					+"\n                新建宫门--昆明湖东堤--文昌院--仁寿殿--德和园--玉澜堂、宜芸馆--乐寿堂--长廊--排云殿--佛香阁--苏州街--北宫门。"
					);
			break;
		case 6:
			titleText.setText("圆明园推荐路线");
			textView.setText("        暂无数据");
			break;
		case 7:
			titleText.setText("玉泉山推荐路线");
			textView.setText("        暂无数据");
			break;
		default:
			break;
		}
	}
}
