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
	// ��λ���
	LocationClient mLocClient;
	public MyLocationListenner myListener = new MyLocationListenner();
	private LocationMode mCurrentMode;
	BitmapDescriptor mCurrentMarker;
	boolean isFirstLoc = true;// �Ƿ��״ζ�λ
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

	// �洢
	private SharedPreferences preferences;
	int saveCount; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.liuxiazuji_layout);

		mCurrentMode = LocationMode.NORMAL;

		// ��ͼ��ʼ��
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
		// �������ż���Ϊ15
		mBaiduMap.setMapStatus(MapStatusUpdateFactory.zoomTo(17));

		mBaiduMap.setMyLocationEnabled(true);
		// ��λ��ʼ��
		mLocClient = new LocationClient(this);
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// ��gps
		option.setCoorType("bd09ll"); // ������������
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
		mLocClient.start();
		option.setIsNeedAddress(true);
		tv_liuXiaZuJi_info = (TextView) findViewById(R.id.tv_liuxiazuji_info);
		points = new ArrayList<LatLng>();

		// ��ʼ��¼�㼣
		bt_start_jiluzuji = (Button) findViewById(R.id.bt_start_jiluzuji);

		bt_start_jiluzuji.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.d("mynininin", "�����ʼ��¼�㼣");
				startJiLu = true;
				if (startCount == 0) {
					Toast.makeText(getApplicationContext(), "��ʼ��¼�㼣",
							Toast.LENGTH_SHORT).show();
					p = new Thread() {
						int count = 0;
						LatLng ll = null;

						@Override
						public void run() {
							while (startJiLu) {
								if (latitude == 4.9E-324) {
									// ����Looper.prepare();Looper.loop();���Can't
									// create handler inside thread that has not
									// called Looper.prepare()����ò���߳̾�ͣ��
									Looper.prepare();
									Toast.makeText(getApplicationContext(),
											"������������", Toast.LENGTH_SHORT).show();
									Looper.loop();
									continue;
								}

								if (count == 0) {
									ll = new LatLng(latitude, longitude);
									points.add(ll);
									Log.d("mynininin", "��һ�μ�¼�㼣");
									count++;
									continue;
								}
								if (ll == null) {
									Log.d("mynininin", "ll");
									continue;
								} else if (ll.latitude == latLng.latitude
										&& ll.longitude == latLng.longitude) {
									Log.d("mynininin", "��û�ж�");

								} else {
									ll = new LatLng(latLng.latitude,
											latLng.longitude);

									points.add(ll);
									Log.d("mynininin", "��¼��һ��");
								}

								try {
									sleep(15000);
									Log.d("mynininin", "�Ȼᰡ����������");
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
					Toast.makeText(getApplicationContext(), "�벻Ҫ�ظ����",
							Toast.LENGTH_SHORT).show();
				}
			}
		});

		// ֹͣ��¼��չʾ�㼣
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

					Toast.makeText(getApplicationContext(), "ֹͣ��¼�ɹ�����ʾ�����㼣",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "��¼����Ϊһ",
							Toast.LENGTH_SHORT).show();
				}

			}
		});
		// �����¼
		bt_save_jiluzuji = (Button) findViewById(R.id.bt_save_jiluzuji);
		bt_save_jiluzuji.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// ��ȡSharedPreferences����Ҫ������
				preferences = getSharedPreferences("saveCount", MODE_WORLD_READABLE);
				saveCount = preferences.getInt("saveCount", 0);

				// �洢������һ
				Editor editor = preferences.edit();
				// ��������
				editor.putInt("saveCount", ++saveCount);
				// �ύ�޸�
				editor.commit();
				/**
				 * дxml�ļ�������
				 */
				writeXmlToLocal();
				Log.d("yyyyyyyyyyyyyyyyy", "д��д��");
				Toast.makeText(getApplicationContext(), "����ɹ�", Toast.LENGTH_SHORT).show();
			}
		});
		//�鿴��ǰ���㼣
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
		
		// ������л�����
		XmlSerializer serializer = Xml.newSerializer();
		
		try {
			File path = new File(Environment.getExternalStorageDirectory(), "latLng"+saveCount+".xml");
			FileOutputStream fos = new FileOutputStream(path);
			
//			FileOutputStream fos = this.openFileOutput("latLng"+saveCount+".xml", Context.MODE_PRIVATE);

			// ָ�����л����������λ�úͱ���
			serializer.setOutput(fos, "utf-8");
			
			serializer.startDocument("utf-8", true);	// д��ʼ <?xml version='1.0' encoding='utf-8' standalone='yes' ?>
			
			serializer.startTag(null, "latLngs");		// <latLngs>
			
			for (LatLng latLng : latLngList) {
				// ��ʼд��

				serializer.startTag(null, "latLng");	// <latLng>
				
				// latitude
				serializer.startTag(null, "latitude");		// <latitude>
				serializer.text(String.valueOf(latLng.latitude));
				serializer.endTag(null, "latitude");		// </latitude>
				// дlongitude
				serializer.startTag(null, "longitude");		// <longitude>
				serializer.text(String.valueOf(latLng.longitude));
				serializer.endTag(null, "longitude");		// </longitude>
				
				serializer.endTag(null, "latLng");	// </latLng>
			}
			
			serializer.endTag(null, "latLngs");			// </latLngs>
			
			serializer.endDocument();		// ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}		
	/**
	 * ��λSDK��������
	 */
	public class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			// map view ���ٺ��ڴ����½��յ�λ��
			if (location == null || mMapView == null)
				return;

			StringBuffer sb = new StringBuffer(256);
			sb.append("�����ڵ�λ�ã�" + location.getAddrStr() + "\n");
			sb.append("��λ���ȣ�");
			int jingdu = (int) location.getRadius();
			sb.append(jingdu + "��\n");
			sb.append("��ǰʱ��Ϊ��");
			sb.append(location.getTime() + "\n");
			sb.append("γ�ȣ�" + location.getLatitude());
			sb.append("���ȣ�" + location.getLongitude());
			logMsg(sb.toString());

			latitude = location.getLatitude();
			longitude = location.getLongitude();
			latLng = new LatLng(latitude, longitude);
			MyLocationData locData = new MyLocationData.Builder()
					.accuracy(location.getRadius())
					// �˴����ÿ����߻�ȡ���ķ�����Ϣ��˳ʱ��0-360
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
		// �˳�ʱ���ٶ�λ
		mLocClient.stop();
		// �رն�λͼ��
		mBaiduMap.setMyLocationEnabled(false);
		mMapView.onDestroy();
		mMapView = null;

		super.onDestroy();
	}
}
