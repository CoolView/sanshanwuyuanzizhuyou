package com.bin.sanshanwuyuanlvyou.function;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.bin.sanshanwuyuanlvyou.R;

public class LiuXiaZuJiActivity extends Activity {
	// 定位相关
	LocationClient mLocClient;
	public MyLocationListenner myListener = new MyLocationListenner();
	private LocationMode mCurrentMode;
	BitmapDescriptor mCurrentMarker;
	boolean isFirstLoc = true;// 是否首次定位
	MapView mMapView;
	BaiduMap mBaiduMap;
	private static final String LINE_SEPARATOR = System
			.getProperty("line.separator");

	// UI
	TextView tv_liuXiaZuJi_info;
	Button bt_start_jiluzuji;
	Button bt_save_jiluzuji;
	Button bt_stop_jiluzuji;
	Button bt_yiqian_zuji;

	//
	double latitude = 4.9E-324;
	double longitude = 4.9E-324;
	Thread p;
	LatLng latLng;
	boolean startJiLu = true;
	int startCount = 0;
	List<LatLng> points;

	// 存储
	private SharedPreferences preferences;
	int saveCount; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.liuxiazuji_layout);

		mCurrentMode = LocationMode.NORMAL;

		// 地图初始化
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
		// 更改缩放级别为15
		mBaiduMap.setMapStatus(MapStatusUpdateFactory.zoomTo(17));

		mBaiduMap.setMyLocationEnabled(true);
		// 定位初始化
		mLocClient = new LocationClient(this);
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
		mLocClient.start();
		option.setIsNeedAddress(true);
		tv_liuXiaZuJi_info = (TextView) findViewById(R.id.tv_liuxiazuji_info);
		points = new ArrayList<LatLng>();

		// 开始记录足迹
		bt_start_jiluzuji = (Button) findViewById(R.id.bt_start_jiluzuji);

		bt_start_jiluzuji.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.d("mynininin", "点击开始记录足迹");
				startJiLu = true;
				if (startCount == 0) {
					Toast.makeText(getApplicationContext(), "开始记录足迹",
							Toast.LENGTH_SHORT).show();
					p = new Thread() {
						int count = 0;
						LatLng ll = null;

						@Override
						public void run() {
							while (startJiLu) {
								if (latitude == 4.9E-324) {
									// 加入Looper.prepare();Looper.loop();解决Can't
									// create handler inside thread that has not
									// called Looper.prepare()，但貌似线程就停了
									Looper.prepare();
									Toast.makeText(getApplicationContext(),
											"请检查您的网络", Toast.LENGTH_SHORT).show();
									Looper.loop();
									continue;
								}

								if (count == 0) {
									ll = new LatLng(latitude, longitude);
									points.add(ll);
									Log.d("mynininin", "第一次记录足迹");
									count++;
									continue;
								}
								if (ll == null) {
									Log.d("mynininin", "ll");
									continue;
								} else if (ll.latitude == latLng.latitude
										&& ll.longitude == latLng.longitude) {
									Log.d("mynininin", "你没有动");

								} else {
									ll = new LatLng(latLng.latitude,
											latLng.longitude);

									points.add(ll);
									Log.d("mynininin", "记录了一次");
								}

								try {
									sleep(15000);
									Log.d("mynininin", "等会啊啊啊啊啊啊");
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					};
					p.start();
					startCount++;
				} else {
					Toast.makeText(getApplicationContext(), "请不要重复点击",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		// 停止记录并展示足迹
		bt_stop_jiluzuji = (Button) findViewById(R.id.bt_stop_jiluzuji);
		bt_stop_jiluzuji.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startJiLu = false;
				startCount = 0;
				if (points.size() > 1 && points.size() < 10000) {
					OverlayOptions ooPolyline = new PolylineOptions().width(10)
							.color(0xAAFF0000).points(points);
					mBaiduMap.addOverlay(ooPolyline);

					Toast.makeText(getApplicationContext(), "停止记录成功，显示您的足迹",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "记录点数为一",
							Toast.LENGTH_SHORT).show();
				}

			}
		});
		// 保存记录
		bt_save_jiluzuji = (Button) findViewById(R.id.bt_save_jiluzuji);
		bt_save_jiluzuji.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// 读取SharedPreferences中需要的数据
				preferences = getSharedPreferences("saveCount", MODE_WORLD_READABLE);
				saveCount = preferences.getInt("saveCount", 0);

				// 存储次数加一
				Editor editor = preferences.edit();
				// 存入数据
				editor.putInt("saveCount", ++saveCount);
				// 提交修改
				editor.commit();
				/**
				 * 写xml文件到本地
				 */
				writeXmlToLocal();
				Log.d("yyyyyyyyyyyyyyyyy", "写了写了");
				Toast.makeText(getApplicationContext(), "保存成功", Toast.LENGTH_SHORT).show();
			}
		});
		//查看以前的足迹
		bt_yiqian_zuji = (Button) findViewById(R.id.bt_yiqian_zuji);
		bt_yiqian_zuji.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(LiuXiaZuJiActivity.this,ZuJiLieBiaoActivity.class);
				startActivity(intent);
			}
		});

	}
	private void writeXmlToLocal() {
		List<LatLng> latLngList = points;
		
		// 获得序列化对象
		XmlSerializer serializer = Xml.newSerializer();
		
		try {
			File path = new File(Environment.getExternalStorageDirectory(), "latLng"+saveCount+".xml");
			FileOutputStream fos = new FileOutputStream(path);
			
//			FileOutputStream fos = this.openFileOutput("latLng"+saveCount+".xml", Context.MODE_PRIVATE);

			// 指定序列化对象输出的位置和编码
			serializer.setOutput(fos, "utf-8");
			
			serializer.startDocument("utf-8", true);	// 写开始 <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
			
			serializer.startTag(null, "latLngs");		// <latLngs>
			
			for (LatLng latLng : latLngList) {
				// 开始写人

				serializer.startTag(null, "latLng");	// <latLng>
				
				// latitude
				serializer.startTag(null, "latitude");		// <latitude>
				serializer.text(String.valueOf(latLng.latitude));
				serializer.endTag(null, "latitude");		// </latitude>
				// 写longitude
				serializer.startTag(null, "longitude");		// <longitude>
				serializer.text(String.valueOf(latLng.longitude));
				serializer.endTag(null, "longitude");		// </longitude>
				
				serializer.endTag(null, "latLng");	// </latLng>
			}
			
			serializer.endTag(null, "latLngs");			// </latLngs>
			
			serializer.endDocument();		// 结束
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}		
	/**
	 * 定位SDK监听函数
	 */
	public class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// map view 销毁后不在处理新接收的位置
			if (location == null || mMapView == null)
				return;

			StringBuffer sb = new StringBuffer(256);
			sb.append("您所在的位置：" + location.getAddrStr() + "\n");
			sb.append("定位精度：");
			int jingdu = (int) location.getRadius();
			sb.append(jingdu + "米\n");
			sb.append("当前时间为：");
			sb.append(location.getTime() + "\n");
			sb.append("纬度：" + location.getLatitude());
			sb.append("经度：" + location.getLongitude());
			logMsg(sb.toString());

			latitude = location.getLatitude();
			longitude = location.getLongitude();
			latLng = new LatLng(latitude, longitude);
			MyLocationData locData = new MyLocationData.Builder()
					.accuracy(location.getRadius())
					// 此处设置开发者获取到的方向信息，顺时针0-360
					.direction(100).latitude(location.getLatitude())
					.longitude(location.getLongitude()).build();
			mBaiduMap.setMyLocationData(locData);
			if (isFirstLoc) {
				isFirstLoc = false;
				LatLng ll = new LatLng(location.getLatitude(),
						location.getLongitude());
				MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
				mBaiduMap.animateMapStatus(u);
			}
		}

		public void onReceivePoi(BDLocation poiLocation) {
		}
	}

	public void logMsg(String str) {
		try {
			if (tv_liuXiaZuJi_info != null)
				tv_liuXiaZuJi_info.setText(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onPause() {
		mMapView.onPause();
		super.onPause();
	}

	@Override
	protected void onResume() {
		mMapView.onResume();
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		// 退出时销毁定位
		mLocClient.stop();
		// 关闭定位图层
		mBaiduMap.setMyLocationEnabled(false);
		mMapView.onDestroy();
		mMapView = null;

		super.onDestroy();
	}
}
