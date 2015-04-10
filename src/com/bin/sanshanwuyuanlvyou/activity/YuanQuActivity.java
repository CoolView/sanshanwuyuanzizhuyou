package com.bin.sanshanwuyuanlvyou.activity;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.BaiduMap.OnMarkerClickListener;
import com.baidu.mapapi.map.BaiduMap.OnMarkerDragListener;
import com.baidu.mapapi.map.InfoWindow.OnInfoWindowClickListener;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.bin.sanshanwuyuanlvyou.R;
//注意之后看YuanQuDaoHangActivity
public class YuanQuActivity extends Activity {
	// 定位相关
		LocationClient mLocClient;
		public MyLocationListenner myListener = new MyLocationListenner();
		private LocationMode mCurrentMode;
		BitmapDescriptor mCurrentMarker;

		MapView mMapView;
		BaiduMap mBaiduMap;

		// UI相关
		OnCheckedChangeListener radioButtonListener;
		boolean isFirstLoc = true;// 是否首次定位
//		Marker 相关
		private Marker mMarkerChangChunYuan;
		private Marker mMarkerJingMingYuan;
		private Marker mMarkerJingYiYuan;
		private Marker mMarkerWanShouShan;
		private Marker mMarkerXiangShan;
		private Marker mMarkerYiHeYuan;
		private Marker mMarkerYuanMingYuan;
		private Marker mMarkerYuQuanShan;
		private InfoWindow mInfoWindow;
		
		// 初始化全局 bitmap 信息，不用时及时 recycle
		BitmapDescriptor bdA = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_mark);
		BitmapDescriptor bdB = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_mark);
		BitmapDescriptor bdC = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_mark);
		BitmapDescriptor bdD = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_mark);
		BitmapDescriptor bdE = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_mark);
		BitmapDescriptor bdF = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_mark);
		BitmapDescriptor bdG = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_mark);
		BitmapDescriptor bdH = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_mark);
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_yuanqu);
			mCurrentMode = LocationMode.NORMAL;

			// 地图初始化
			mMapView = (MapView) findViewById(R.id.bmapView);
			mBaiduMap = mMapView.getMap();
			// 开启定位图层
//			mBaiduMap.setMyLocationEnabled(true);
			// 定位初始化
			mLocClient = new LocationClient(this);
			mLocClient.registerLocationListener(myListener);
			LocationClientOption option = new LocationClientOption();
			option.setOpenGps(true);// 打开gps
			option.setCoorType("bd09ll"); // 设置坐标类型
			option.setScanSpan(1000);
			mLocClient.setLocOption(option);
			
			Button bt_MyWeiZhi = (Button) findViewById(R.id.bt_myweizhi);
			bt_MyWeiZhi.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					mBaiduMap.setMyLocationEnabled(true);
					mLocClient.start();
				}
			});
//			mLocClient.start();
			
			MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(13.0f);
			MapStatusUpdate msu2 = MapStatusUpdateFactory.newLatLng(new LatLng(39.992965,116.249944));//39.998473,116.27487
			mBaiduMap.setMapStatus(msu);
			mBaiduMap.setMapStatus(msu2);
			
			initOverlay();
			mBaiduMap.setOnMarkerClickListener(new OnMarkerClickListener() {
				@SuppressLint("ResourceAsColor")
				public boolean onMarkerClick(final Marker marker) {
					LinearLayout lLayout = new LinearLayout(getApplicationContext());
					lLayout.setOrientation(LinearLayout.VERTICAL);
					
					Button button = new Button(lLayout.getContext());
					ImageView imageView = new ImageView(lLayout.getContext());
					lLayout.addView(imageView);
					lLayout.addView(button);
					button.setBackgroundResource(R.drawable.popup);
					button.setTextColor(R.color.myblue);
					
					if (marker == mMarkerChangChunYuan) {
						button.setText("畅春园");//更改位置
						imageView.setBackgroundResource(R.drawable.changchunyuan_mark);
						lLayout.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								mBaiduMap.hideInfoWindow();
								Intent intent = new Intent(YuanQuActivity.this,JingQuActivity.class);
								int mJingQuInfo = R.drawable.changchunyuan;
								intent.putExtra("mJingQuInfo", mJingQuInfo);
								startActivity(intent);
							}
						});
						LatLng ll = marker.getPosition();
						mInfoWindow = new InfoWindow(lLayout, ll, 0);
						mBaiduMap.showInfoWindow(mInfoWindow);
					} else if (marker == mMarkerJingMingYuan) {
						button.setText("静明园");
						imageView.setBackgroundResource(R.drawable.jingmingyuan_mark);
						lLayout.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								mBaiduMap.hideInfoWindow();
								Intent intent = new Intent(YuanQuActivity.this,JingQuActivity.class);
								int mJingQuInfo = R.drawable.jingmingyuan;
								intent.putExtra("mJingQuInfo", mJingQuInfo);
								startActivity(intent);
							}
						});
						LatLng ll = marker.getPosition();
						mInfoWindow = new InfoWindow(lLayout, ll, 0);
						mBaiduMap.showInfoWindow(mInfoWindow);
					} else if (marker == mMarkerJingYiYuan) {
						button.setText("静宜园");
						imageView.setBackgroundResource(R.drawable.jingyiyuan_mark);
						lLayout.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
//								
								mBaiduMap.hideInfoWindow();
								Intent intent = new Intent(YuanQuActivity.this,JingQuActivity.class);
								int mJingQuInfo = R.drawable.jingyiyuan;
								intent.putExtra("mJingQuInfo", mJingQuInfo);
								startActivity(intent);
							}
						});
						LatLng ll = marker.getPosition();
						mInfoWindow = new InfoWindow(lLayout, ll, 0);
						mBaiduMap.showInfoWindow(mInfoWindow);
					}else if (marker == mMarkerWanShouShan) {
						button.setText("万寿山");
						imageView.setBackgroundResource(R.drawable.wanshoushan_mark);
						lLayout.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								mBaiduMap.hideInfoWindow();
								Intent intent = new Intent(YuanQuActivity.this,JingQuActivity.class);
								int mJingQuInfo = R.drawable.wanshoushan;
								intent.putExtra("mJingQuInfo", mJingQuInfo);
								startActivity(intent);
							}
						});
						LatLng ll = marker.getPosition();
						mInfoWindow = new InfoWindow(lLayout, ll, 0);
						mBaiduMap.showInfoWindow(mInfoWindow);
					}else if (marker == mMarkerXiangShan) {
						button.setText("香山");
						imageView.setBackgroundResource(R.drawable.xiangshan_mark);
						lLayout.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								mBaiduMap.hideInfoWindow();
								Intent intent = new Intent(YuanQuActivity.this,JingQuActivity.class);
								int mJingQuInfo = R.drawable.xiangshan;
								intent.putExtra("mJingQuInfo", mJingQuInfo);
								startActivity(intent);
							}
						});
						LatLng ll = marker.getPosition();
						mInfoWindow = new InfoWindow(lLayout, ll, 0);
						mBaiduMap.showInfoWindow(mInfoWindow);
					}else if (marker == mMarkerYiHeYuan) {
						button.setText("颐和园");
						imageView.setBackgroundResource(R.drawable.yiheyuan_mark);
						lLayout.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								mBaiduMap.hideInfoWindow();
								Intent intent = new Intent(YuanQuActivity.this,JingQuActivity.class);
								int mJingQuInfo = R.drawable.yiheyuan;
								intent.putExtra("mJingQuInfo", mJingQuInfo);
								startActivity(intent);
							}
						});
						LatLng ll = marker.getPosition();
						mInfoWindow = new InfoWindow(lLayout, ll, 0);
						mBaiduMap.showInfoWindow(mInfoWindow);
					}else if (marker == mMarkerYuanMingYuan) {
						button.setText("圆明园");
						imageView.setBackgroundResource(R.drawable.yuanmingyuan_mark);
						lLayout.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								mBaiduMap.hideInfoWindow();
								Intent intent = new Intent(YuanQuActivity.this,JingQuActivity.class);
								int mJingQuInfo = R.drawable.yuanmingyuan;
								intent.putExtra("mJingQuInfo", mJingQuInfo);
								startActivity(intent);
							}
						});
						LatLng ll = marker.getPosition();
						mInfoWindow = new InfoWindow(lLayout, ll, 0);
						mBaiduMap.showInfoWindow(mInfoWindow);
					}else if (marker == mMarkerYuQuanShan) {
						button.setText("玉泉山");
						imageView.setBackgroundResource(R.drawable.yuquanshan_mark);
						lLayout.setOnClickListener(new OnClickListener() {
							public void onClick(View v) {
								mBaiduMap.hideInfoWindow();
								Intent intent = new Intent(YuanQuActivity.this,JingQuActivity.class);
								int mJingQuInfo = R.drawable.yuquanshan;
								intent.putExtra("mJingQuInfo", mJingQuInfo);
								startActivity(intent);
							}
						});
						LatLng ll = marker.getPosition();
						mInfoWindow = new InfoWindow(lLayout, ll, 0);
						mBaiduMap.showInfoWindow(mInfoWindow);
					}
					return true;
				}
			});
		}

		public void initOverlay() {
			// add marker overlay
			LatLng llChangChunYuan = new LatLng(39.998826,116.306938);
			LatLng llJingMingYuan = new LatLng(40.001705,116.255097);
			LatLng llJingYiYuan = new LatLng(39.997078,116.203106);
			LatLng llWanShouShan = new LatLng(40.006059,116.281049);
			LatLng llXiangShan = new LatLng(39.996636,116.196129);
			LatLng llYiHeYuan = new LatLng(39.998473,116.27487);
			LatLng llYuanMingYuan = new LatLng(40.01629,116.314607);
			LatLng llYuQuanShan = new LatLng(39.995031,116.251611);

			OverlayOptions ooA = new MarkerOptions().position(llChangChunYuan).icon(bdA)
					.perspective(false).anchor(0.5f, 0.5f).zIndex(7);
			mMarkerChangChunYuan = (Marker) (mBaiduMap.addOverlay(ooA));
			
			OverlayOptions ooB = new MarkerOptions().position(llJingMingYuan).icon(bdB)
					.perspective(false).anchor(0.5f, 0.5f).zIndex(7);
			mMarkerJingMingYuan = (Marker) (mBaiduMap.addOverlay(ooB));
			
			OverlayOptions ooC = new MarkerOptions().position(llJingYiYuan).icon(bdC)
					.perspective(false).anchor(0.5f, 0.5f).zIndex(7);
			mMarkerJingYiYuan = (Marker) (mBaiduMap.addOverlay(ooC));
			
			OverlayOptions ooD = new MarkerOptions().position(llWanShouShan).icon(bdD)
					.perspective(false).anchor(0.5f, 0.5f).zIndex(7);
			mMarkerWanShouShan = (Marker) (mBaiduMap.addOverlay(ooD));
			
			OverlayOptions ooE = new MarkerOptions().position(llXiangShan).icon(bdE)
					.perspective(false).anchor(0.5f, 0.5f).zIndex(7);
			mMarkerXiangShan = (Marker) (mBaiduMap.addOverlay(ooE));
			
			OverlayOptions ooF = new MarkerOptions().position(llYiHeYuan).icon(bdF)
					.perspective(false).anchor(0.5f, 0.5f).zIndex(7);
			mMarkerYiHeYuan = (Marker) (mBaiduMap.addOverlay(ooF));
			
			OverlayOptions ooG = new MarkerOptions().position(llYuanMingYuan).icon(bdG)
					.perspective(false).anchor(0.5f, 0.5f).zIndex(7);
			mMarkerYuanMingYuan = (Marker) (mBaiduMap.addOverlay(ooG));
			
			OverlayOptions ooH = new MarkerOptions().position(llYuQuanShan).icon(bdH)
					.perspective(false).anchor(0.5f, 0.5f).zIndex(7);
			mMarkerYuQuanShan = (Marker) (mBaiduMap.addOverlay(ooH));
			
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
//			mLocClient.stop();
//			// 关闭定位图层
//			mBaiduMap.setMyLocationEnabled(false);
			mMapView.onDestroy();
			mMapView = null;
			// 回收 bitmap 资源
			bdA.recycle();
			bdB.recycle();
			bdC.recycle();
			bdD.recycle();
			bdE.recycle();
			bdF.recycle();
			bdG.recycle();
			bdH.recycle();
			super.onDestroy();
		}

	}
