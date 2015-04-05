package com.bin.sanshanwuyuanlvyou.function;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.ArcOptions;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.bin.sanshanwuyuanlvyou.R;
import com.bin.sanshanwuyuanlvyou.R.id;

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

	//
	double latitude = 4.9E-324;
	double longitude = 4.9E-324;
	Thread p;
	LatLng latLng;
	boolean startJiLu = true;
	int startCount = 0;

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
		final List<LatLng> points = new ArrayList<LatLng>();

		// ��ʼ��¼�㼣
		bt_start_jiluzuji = (Button) findViewById(R.id.bt_start_jiluzuji);

		bt_start_jiluzuji.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Log.d("mynininin", "�����ʼ��¼�㼣");

				if (startCount == 0) {
					p = new Thread() {
						int count = 0;
						LatLng ll = null;

						@Override
						public void run() {
							while (startJiLu) {
								if (latitude == 4.9E-324) {
									// ����Looper.prepare();Looper.loop();���Can't
									// create handler inside thread that has not
									// called Looper.prepare()
									Looper.prepare();
									Toast.makeText(getApplicationContext(),
											"�ȴ���λ", Toast.LENGTH_SHORT).show();
									Looper.loop();
									continue;
								}

								if (count == 0) {
									ll = new LatLng(latitude, longitude);
									points.add(ll);
									Log.d("mynininin", "��һ�μ�¼�㼣");
									Looper.prepare();
									Toast.makeText(getApplicationContext(),
											"��ʼ��¼�㼣", Toast.LENGTH_SHORT)
											.show();
									Looper.loop();
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
				}else{
					Toast.makeText(getApplicationContext(), "�벻Ҫ�ظ����", Toast.LENGTH_SHORT).show();
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
					// �������
					points.clear();
					Toast.makeText(getApplicationContext(), "ֹͣ��¼�ɹ�����ʾ�����㼣",
							Toast.LENGTH_SHORT).show();
				} else {
					Toast.makeText(getApplicationContext(), "��¼����Ϊһ",
							Toast.LENGTH_SHORT).show();
				}

			}
		});

		bt_save_jiluzuji = (Button) findViewById(R.id.bt_save_jiluzuji);

	}

	public static boolean saveUserInfo(Context context) {
		try {
			// �жϵ�ǰ���ֻ��Ƿ���sd��
			String state = Environment.getExternalStorageState();
			if (!Environment.MEDIA_MOUNTED.equals(state)) {
				// �Ѿ�������sd��
				return false;
			}
			// ���SD��λ��
			File sdCardFile = Environment.getExternalStorageDirectory();

			File file = new File(sdCardFile, "MyLocationInfo.txt");
			FileOutputStream fos = new FileOutputStream(file, true);

			// String data = mLocationInfo + LINE_SEPARATOR;
			// fos.write(data.getBytes());

			fos.flush();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
