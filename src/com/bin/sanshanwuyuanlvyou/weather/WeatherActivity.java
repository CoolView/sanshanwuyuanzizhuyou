package com.bin.sanshanwuyuanlvyou.weather;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bin.sanshanwuyuanlvyou.R;


public class WeatherActivity extends Activity implements OnClickListener{

	private LinearLayout weatherInfoLayout;
	/**
	 * 用于显示城市名
	 */
	private TextView cityNameText;
	/**
	 * 用于显示发布时间
	 */
	private TextView publishText;
	/**
	 * 用于显示天气描述信息
	 */
	private TextView weatherDespText;
	/**
	 * 用于显示气温1
	 */
	private TextView temp1Text;
	/**
	 * 用于显示气温2
	 */
	private TextView temp2Text;
	/**
	 * 用于显示当前日期
	 */
	private TextView currentDateText;
	/**
	 * 更新天气按钮
	 */
	private Button refreshWeather;
	/**
	 * 用于显示图片
	 */
	private ImageView imgView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.weather_layout);
		// 初始化各控件
		weatherInfoLayout = (LinearLayout) findViewById(R.id.weather_info_layout);
		cityNameText = (TextView) findViewById(R.id.city_name);
		publishText = (TextView) findViewById(R.id.publish_text);
		imgView1 = (ImageView) findViewById(R.id.img1);
		weatherDespText = (TextView) findViewById(R.id.weather_desp);
		temp1Text = (TextView) findViewById(R.id.temp1);
		temp2Text = (TextView) findViewById(R.id.temp2);
		currentDateText = (TextView) findViewById(R.id.current_date);
		refreshWeather = (Button) findViewById(R.id.refresh_weather);
		String countyCode = "010102";
		if (!TextUtils.isEmpty(countyCode)) {
			// 有县级代号时就去查询天气
			publishText.setText("同步中...");
			Log.d("hhhhhh", countyCode);
			weatherInfoLayout.setVisibility(View.INVISIBLE);
			cityNameText.setVisibility(View.INVISIBLE);
			queryWeatherCode(countyCode);
		} else {
			// 没有县级代号时就直接显示本地天气
			showWeather();
		}
		refreshWeather.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		
		case R.id.refresh_weather:
			publishText.setText("同步中...");
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
			String weatherCode = prefs.getString("weather_code", "");
			if (!TextUtils.isEmpty(weatherCode)) {
				queryWeatherInfo(weatherCode);
			}
			break;
		default:
			break;
		}
	}
	/**
	 * 查询县级代号所对应的天气代号。
	 */
	private void queryWeatherCode(String countyCode) {
		String address = "http://www.weather.com.cn/data/list3/city" + countyCode + ".xml";
		queryFromServer(address, "countyCode");
	}

	/**
	 * 查询天气代号所对应的天气。
	 */
	private void queryWeatherInfo(String weatherCode) {
		String address = "http://www.weather.com.cn/data/cityinfo/" + weatherCode + ".html";
		queryFromServer(address, "weatherCode");
	}
	
	/**
	 * 根据传入的地址和类型去向服务器查询天气代号或者天气信息。
	 */
	private void queryFromServer(final String address, final String type) {
		HttpUtil.sendHttpRequest(address, new HttpCallbackListener() {
			@Override
			public void onFinish(final String response) {
				if ("countyCode".equals(type)) {
					if (!TextUtils.isEmpty(response)) {
						// 从服务器返回的数据中解析出天气代号
						String[] array = response.split("\\|");
						if (array != null && array.length == 2) {
							String weatherCode = array[1];
							queryWeatherInfo(weatherCode);
						}
					}
				} else if ("weatherCode".equals(type)) {
					// 处理服务器返回的天气信息
					Utility.handleWeatherResponse(WeatherActivity.this, response);
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							showWeather();
						}
					});
				}
			}
			
			@Override
			public void onError(Exception e) {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						publishText.setText("同步失败");
						Toast.makeText(getApplicationContext(), "同步失败,请检查你的网络", Toast.LENGTH_SHORT).show();
					}
				});
			}
		});
	}
	
	/**
	 * 从SharedPreferences文件中读取存储的天气信息，并显示到界面上。
	 */
	private void showWeather() {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		cityNameText.setText( prefs.getString("city_name", ""));
		temp1Text.setText(prefs.getString("temp1", ""));
		temp2Text.setText(prefs.getString("temp2", ""));
		weatherDespText.setText(prefs.getString("weather_desp", ""));
		int resoid = imageResoId(prefs.getString("weather_desp", ""));
		imgView1.setBackgroundResource(resoid);
		publishText.setText("今天" + prefs.getString("publish_time", "") + "发布");
		currentDateText.setText(prefs.getString("current_date", ""));
		weatherInfoLayout.setVisibility(View.VISIBLE);
		cityNameText.setVisibility(View.VISIBLE);
	}
	private int imageResoId(String weather){
		int resoid=R.drawable.s_2;
		if(weather.indexOf("多云")!=-1||weather.indexOf("晴")!=-1){//多云转晴，以下类同 indexOf:包含字串
            resoid=R.drawable.s_1;}
        else if(weather.indexOf("多云")!=-1&&weather.indexOf("阴")!=-1){
            resoid=R.drawable.s_2;}
        else if(weather.indexOf("阴")!=-1&&weather.indexOf("雨")!=-1){
            resoid=R.drawable.s_3;}
        else if(weather.indexOf("晴")!=-1&&weather.indexOf("雨")!=-1){
            resoid=R.drawable.s_12;}
        else if(weather.indexOf("晴")!=-1&&weather.indexOf("雾")!=-1){
            resoid=R.drawable.s_12;}
        else if(weather.indexOf("晴")!=-1){resoid=R.drawable.s_13;}
        else if(weather.indexOf("多云")!=-1){resoid=R.drawable.s_2;}
        else if(weather.indexOf("阵雨")!=-1){resoid=R.drawable.s_3;}
        else if(weather.indexOf("小雨")!=-1){resoid=R.drawable.s_3;}
        else if(weather.indexOf("中雨")!=-1){resoid=R.drawable.s_4;}
        else if(weather.indexOf("大雨")!=-1){resoid=R.drawable.s_5;}
        else if(weather.indexOf("暴雨")!=-1){resoid=R.drawable.s_5;}
        else if(weather.indexOf("冰雹")!=-1){resoid=R.drawable.s_6;}
        else if(weather.indexOf("雷阵雨")!=-1){resoid=R.drawable.s_7;}
        else if(weather.indexOf("小雪")!=-1){resoid=R.drawable.s_8;}
        else if(weather.indexOf("中雪")!=-1){resoid=R.drawable.s_9;}
        else if(weather.indexOf("大雪")!=-1){resoid=R.drawable.s_10;}
        else if(weather.indexOf("暴雪")!=-1){resoid=R.drawable.s_10;}
        else if(weather.indexOf("扬沙")!=-1){resoid=R.drawable.s_11;}
        else if(weather.indexOf("沙尘")!=-1){resoid=R.drawable.s_11;}
        else if(weather.indexOf("雾")!=-1){resoid=R.drawable.s_12;}
		return resoid;
	}
}