package com.bin.sanshanwuyuanlvyou.activity;

import java.util.ArrayList;
import java.util.List;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.model.LatLng;
import com.bin.sanshanwuyuanlvyou.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class LvDaoActivity extends Activity {
	// 定位相关
	LocationClient mLocClient;
	public MyLocationListenner myListener = new MyLocationListenner();
	private LocationMode mCurrentMode;
	BitmapDescriptor mCurrentMarker;
	boolean isFirstLoc = true;// 是否首次定位
	MapView mMapView;
	BaiduMap mBaiduMap;

	TextView titleText;
	Button bt_lvdao_myweizhi;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_lvdao);
		titleText = (TextView) findViewById(R.id.title_text);
		titleText.setText("健身绿道");
		mCurrentMode = LocationMode.NORMAL;

		// 地图初始化
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
		// 更改缩放级别为12
//		mBaiduMap.setMapStatus(MapStatusUpdateFactory.zoomTo(12));

//		mBaiduMap.setMyLocationEnabled(true);
		// 定位初始化
		mLocClient = new LocationClient(this);
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
		bt_lvdao_myweizhi = (Button) findViewById(R.id.bt_lvdao_myweizhi);
		bt_lvdao_myweizhi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				mBaiduMap.setMyLocationEnabled(true);
				mLocClient.start();
			}
		});
		MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(13.0f);
		MapStatusUpdate msu2 = MapStatusUpdateFactory.newLatLng(new LatLng(39.992965,116.249944));//39.998473,116.27487
		mBaiduMap.setMapStatus(msu);
		mBaiduMap.setMapStatus(msu2);
		// 添加绿道
		addLvDaoElements();

	}

	private void addLvDaoElements() {
		// TODO Auto-generated method stub
		List<LatLng> points = new ArrayList<LatLng>();
		points.add(new LatLng(40.005841, 116.321589));
		points.add(new LatLng(40.005813, 116.317483));
		points.add(new LatLng(40.005647, 116.316549));
		points.add(new LatLng(40.005398, 116.315624));
		points.add(new LatLng(40.005129, 116.315094));
		points.add(new LatLng(40.005081, 116.315031));
		points.add(new LatLng(40.004031, 116.313917));
		points.add(new LatLng(40.003844, 116.31363));
		points.add(new LatLng(40.003761, 116.313306));
		points.add(new LatLng(40.003595, 116.310863));
		points.add(new LatLng(40.001164, 116.310899));
		points.add(new LatLng(40.000162, 116.310935));
		points.add(new LatLng(39.998165, 116.311249));
		points.add(new LatLng(39.994517, 116.311797));
		points.add(new LatLng(39.992285, 116.312085));
		points.add(new LatLng(39.991518, 116.312139));
		points.add(new LatLng(39.991366, 116.306538));
		points.add(new LatLng(39.992057, 116.305558));
		points.add(new LatLng(39.99632, 116.305334));
		points.add(new LatLng(39.997039, 116.287224));
		points.add(new LatLng(39.989521, 116.28629));
		points.add(new LatLng(39.985099, 116.288194));
		points.add(new LatLng(39.983371, 116.289218));
		points.add(new LatLng(39.983647, 116.294069));
		points.add(new LatLng(39.988139, 116.298722));
		points.add(new LatLng(39.990544, 116.302639));
		points.add(new LatLng(39.992057,116.305558));
		
		//第二条
		List<LatLng> points2 = new ArrayList<LatLng>();
		points2.add(new LatLng(39.985099, 116.288194));
		points2.add(new LatLng(39.984712, 116.287296));
		points2.add(new LatLng(39.98297, 116.288428));
		points2.add(new LatLng(39.980603, 116.2907));
		points2.add(new LatLng(39.978889, 116.29221));
		points2.add(new LatLng(39.975669, 116.293485));
		points2.add(new LatLng(39.976042, 116.294509));
		points2.add(new LatLng(39.973153, 116.296216));
		points2.add(new LatLng(39.972061, 116.297025));
		points2.add(new LatLng(39.97213, 116.297348));
		points2.add(new LatLng(39.971563, 116.297833));
		points2.add(new LatLng(39.971259, 116.298534));
		points2.add(new LatLng(39.971204, 116.298677));
		
		//第三条
		List<LatLng> points3 = new ArrayList<LatLng>();
		points3.add(new LatLng(39.98297, 116.288428));
		points3.add(new LatLng(39.981612, 116.288455));
		points3.add(new LatLng(39.980714, 116.289245));
		points3.add(new LatLng(39.976401, 116.280226));
		points3.add(new LatLng(39.976235, 116.271872));
		points3.add(new LatLng(39.979691, 116.268746));
		points3.add(new LatLng(39.988371, 116.261488));
		points3.add(new LatLng(39.990167, 116.265692));
		points3.add(new LatLng(39.992102, 116.267955));
		points3.add(new LatLng(39.993069, 116.269321));
		points3.add(new LatLng(39.993788, 116.268458));
		points3.add(new LatLng(39.995336, 116.266123));
		points3.add(new LatLng(39.996745, 116.265764));
		points3.add(new LatLng(39.997685, 116.266195));
		points3.add(new LatLng(39.998293, 116.265656));
		points3.add(new LatLng(39.99879, 116.265548));
		points3.add(new LatLng(39.99915, 116.266231));
		points3.add(new LatLng(40.000421, 116.265584));
		points3.add(new LatLng(40.00067, 116.265081));
		points3.add(new LatLng(39.998376, 116.263787));
		points3.add(new LatLng(39.997243, 116.262027));
		points3.add(new LatLng(39.996552, 116.261847));
		points3.add(new LatLng(39.996469, 116.261488));
		points3.add(new LatLng(39.996828, 116.2612));
		points3.add(new LatLng(39.997132, 116.2612));
		points3.add(new LatLng(39.995584, 116.259727));
		points3.add(new LatLng(39.995197, 116.259691));
		points3.add(new LatLng(39.995032, 116.260158));
		points3.add(new LatLng(39.995336, 116.260841));
		points3.add(new LatLng(39.99575, 116.26138));
		points3.add(new LatLng(39.995612, 116.261775));
		points3.add(new LatLng(39.996137, 116.262278));
		points3.add(new LatLng(39.996275, 116.262673));
		points3.add(new LatLng(39.995363, 116.262602));
		points3.add(new LatLng(39.994949, 116.261524));
		points3.add(new LatLng(39.99412, 116.261991));
		points3.add(new LatLng(39.993843, 116.261452));
		points3.add(new LatLng(39.993401, 116.260841));
		points3.add(new LatLng(39.993125, 116.259763));
		points3.add(new LatLng(39.992351, 116.259799));
		points3.add(new LatLng(39.991798, 116.260589));
		points3.add(new LatLng(39.991383, 116.26005));
		points3.add(new LatLng(39.988371, 116.261488));
		
		//第四条
		List<LatLng> points4 = new ArrayList<LatLng>();
		points4.add(new LatLng(39.991383, 116.26005));
		points4.add(new LatLng(39.993436, 116.257787));
		points4.add(new LatLng(39.991307, 116.252828));
		points4.add(new LatLng(39.989787, 116.253547));
		points4.add(new LatLng(39.987714, 116.25405));
		points4.add(new LatLng(39.987742, 116.254804));
		points4.add(new LatLng(39.988129, 116.255738));
		points4.add(new LatLng(39.98846, 116.256852));
		points4.add(new LatLng(39.98987, 116.259978));
		points4.add(new LatLng(39.991383, 116.26005));
		
		//第五条
		List<LatLng> points5 = new ArrayList<LatLng>();
		points5.add(new LatLng(39.979691, 116.268746));
		points5.add(new LatLng(39.978951, 116.243486));
		points5.add(new LatLng(39.98061, 116.243593));
		points5.add(new LatLng(39.983402, 116.242048));
		points5.add(new LatLng(39.983872, 116.242084));
		points5.add(new LatLng(39.984259, 116.240144));
		points5.add(new LatLng(39.984342, 116.23788));
		points5.add(new LatLng(39.984757, 116.235401));
		points5.add(new LatLng(39.983098, 116.234862));
		points5.add(new LatLng(39.982683, 116.23461));
		points5.add(new LatLng(39.982822, 116.233604));
		points5.add(new LatLng(39.9826, 116.233425));
		points5.add(new LatLng(39.982905, 116.232921));
		points5.add(new LatLng(39.982739, 116.232526));
		points5.add(new LatLng(39.982103, 116.232239));
		points5.add(new LatLng(39.978869, 116.231269));
		points5.add(new LatLng(39.978951, 116.243486));
		
		
		
		//第6条
		List<LatLng> points6 = new ArrayList<LatLng>();
		points6.add(new LatLng(39.978869, 116.231269));
		points6.add(new LatLng(39.978841, 116.213985));
		points6.add(new LatLng(39.978703, 116.210248));
		
		//第7条
		List<LatLng> points7 = new ArrayList<LatLng>();
		points7.add(new LatLng(39.978841, 116.213985));
		points7.add(new LatLng(39.98448, 116.213518));
		points7.add(new LatLng(39.986664, 116.213662));
		points7.add(new LatLng(39.988267, 116.213662));
		points7.add(new LatLng(39.989677, 116.213698));
		points7.add(new LatLng(39.990202, 116.213949));
		points7.add(new LatLng(39.991335, 116.214812));
		points7.add(new LatLng(39.99338, 116.216932));
		points7.add(new LatLng(39.994403, 116.217614));
		points7.add(new LatLng(39.995343, 116.217722));
		points7.add(new LatLng(39.999599, 116.216177));
		points7.add(new LatLng(39.999295, 116.222753));
		points7.add(new LatLng(39.999267, 116.224334));
		points7.add(new LatLng(39.998687, 116.227711));
		points7.add(new LatLng(39.999018, 116.228861));
		points7.add(new LatLng(39.99877, 116.22958));
		points7.add(new LatLng(39.998355, 116.230334));
		points7.add(new LatLng(39.9983, 116.233245));
		points7.add(new LatLng(39.998576, 116.234503));
		points7.add(new LatLng(39.99841, 116.236694));
		points7.add(new LatLng(39.998659, 116.240755));
		points7.add(new LatLng(39.995895, 116.240898));
		points7.add(new LatLng(39.995121, 116.239569));
		points7.add(new LatLng(39.990036, 116.243809));
		points7.add(new LatLng(39.990865, 116.245641));
		points7.add(new LatLng(39.990312, 116.246001));
		points7.add(new LatLng(39.989594, 116.245965));
		points7.add(new LatLng(39.989124, 116.244671));
		points7.add(new LatLng(39.987852, 116.245606));
		points7.add(new LatLng(39.986111, 116.242803));
		points7.add(new LatLng(39.986, 116.240719));
		points7.add(new LatLng(39.984259, 116.240144));
		
		
		//第8条
		List<LatLng> points8 = new ArrayList<LatLng>();
		points8.add(new LatLng(39.987852, 116.245606));
		points8.add(new LatLng(39.991307, 116.252828));

		
		OverlayOptions ooPolyline = new PolylineOptions().width(10)
				.color(0xAA00FF00).points(points);
		mBaiduMap.addOverlay(ooPolyline);
		OverlayOptions ooPolyline2 = new PolylineOptions().width(10)
				.color(0xAA00FF00).points(points2);
		mBaiduMap.addOverlay(ooPolyline2);
		OverlayOptions ooPolyline3 = new PolylineOptions().width(10)
				.color(0xAA00FF00).points(points3);
		mBaiduMap.addOverlay(ooPolyline3);
		OverlayOptions ooPolyline4 = new PolylineOptions().width(10)
				.color(0xAA00FF00).points(points4);
		mBaiduMap.addOverlay(ooPolyline4);
		OverlayOptions ooPolyline5 = new PolylineOptions().width(10)
				.color(0xAA00FF00).points(points5);
		mBaiduMap.addOverlay(ooPolyline5);
		OverlayOptions ooPolyline6 = new PolylineOptions().width(10)
				.color(0xAA00FF00).points(points6);
		mBaiduMap.addOverlay(ooPolyline6);
		OverlayOptions ooPolyline7 = new PolylineOptions().width(10)
				.color(0xAA00FF00).points(points7);
		mBaiduMap.addOverlay(ooPolyline7);
		OverlayOptions ooPolyline8 = new PolylineOptions().width(10)
				.color(0xAA00FF00).points(points8);
		mBaiduMap.addOverlay(ooPolyline8);
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
