package com.bin.sanshanwuyuanlvyou.zizhuyoulan;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.lbsapi.BMapManager;
import com.baidu.lbsapi.panoramaview.PanoramaView;
import com.baidu.lbsapi.panoramaview.PanoramaViewListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.GeofenceClient;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationConfiguration.LocationMode;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.overlayutil.WalkingRouteOverlay;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.route.DrivingRouteResult;
import com.baidu.mapapi.search.route.OnGetRoutePlanResultListener;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.RoutePlanSearch;
import com.baidu.mapapi.search.route.TransitRouteResult;
import com.baidu.mapapi.search.route.WalkingRouteLine.WalkingStep;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;
import com.baidu.mapapi.search.route.WalkingRouteResult;
import com.baidu.mapapi.utils.DistanceUtil;
import com.bin.sanshanwuyuanlvyou.R;
import com.bin.sanshanwuyuanlvyou.zizhuyoulan.base.BaseActivity;
import com.bin.sanshanwuyuanlvyou.zizhuyoulan.base.BaseApplication;
import com.bin.sanshanwuyuanlvyou.zizhuyoulan.utils.T;

public class ZiZhuYouLanActivity extends BaseActivity implements
BaiduMap.OnMapClickListener, OnGetRoutePlanResultListener,
PanoramaViewListener, OnGetGeoCoderResultListener{
	boolean isFirstLoc = true;// 是否首次定位
	Map<String, Double[]> map;
	public class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(final BDLocation location) {
			// map view 销毁后不在处理新接收的位置
			if (location == null || mMapView == null)
				return;
			
			
			map = new HashMap<String, Double[]>();
			map.put("颐和园西门", new Double[]{116.270777,39.993381});
			map.put("颐和园如意门",new Double[]{116.287027,39.9869});
			map.put("颐和园北宫门",new Double[]{116.28044,40.008629});
			map.put("颐和园东门",new Double[]{116.287408,40.004235});
			map.put("颐和园新建宫门",new Double[]{116.286729,39.997313});
			map.put("圆明园东门",new Double[]{116.324404,40.021649});
			map.put("圆明园东南门",new Double[]{116.321284,40.012242});
			map.put("圆明园南门",new Double[]{116.318895,40.005807});
			map.put("圆明园东门",new Double[]{116.324933,40.018569});
			map.put("畅春园",new Double[]{116.306956,39.998826});
			map.put("静宜园",new Double[]{116.203106,39.997078});
			map.put("香山",new Double[]{116.196129,39.996636});
			map.put("万寿山",new Double[]{116.281049,40.006059});
			
			Set<String> keySet = map.keySet();
			Iterator<String> it = keySet.iterator();
				
			LatLng p1 = new LatLng(location.getLatitude(),
					location.getLongitude());
			LatLng p2 = null;
			double min = DistanceUtil.getDistance(p1,new LatLng(116.281049,40.006059));
			
			String minJingQu = "万寿山";
			while(it.hasNext()){
				String key = it.next();
				Double[] value = map.get(key);
				
				double x = value[0];
				double y = value[1];
				p2= new LatLng( y,x);
				
//				min = DistanceUtil.getDistance(p1,p2)<min?DistanceUtil.getDistance(p1,p2):min;
				if(min>DistanceUtil.getDistance(p1,p2)){
					minJingQu = key;
					min = DistanceUtil.getDistance(p1,p2);
				}
			}
			int juli = (int)min;
			StringBuffer sb = new StringBuffer(256);
			sb.append("您所在的位置："+location.getAddrStr()+"\n");
//			sb.append("当前时间为：");
//			sb.append(location.getTime());
			sb.append("定位精度：");
			int jingdu = (int) location.getRadius();
			sb.append(jingdu+"米\n");
//			sb.append("纬度："+location.getLatitude());
//			sb.append("经度："+location.getLongitude());
			
			sb.append("距离您最近的景区为："+minJingQu+""+juli+"米");
			logMsg(sb.toString());
			Log.i("BaiduLocation", sb.toString());
			
			MyLocationData locData = new MyLocationData.Builder()
					.accuracy(location.getRadius())//设置定位数据的精度信息，单位：米,,获取定位精度
					// 此处设置开发者获取到的方向信息，顺时针0-360
					.direction(100).latitude(location.getLatitude())//设置定位数据的方向信息,,设置定位数据的纬度
					.longitude(location.getLongitude()).build();//设置定位数据的经度,,,构建生成定位数据对象
			mBaiduMap.setMyLocationData(locData);//设置定位数据, 只有先允许定位图层后设置数据才会生效，参见 setMyLocationEnabled(boolean)
			if (isFirstLoc) {
				isFirstLoc = false;
				mStartPt = new LatLng(location.getLatitude(),
						location.getLongitude());
				LatLng ll = new LatLng(location.getLatitude(),
						location.getLongitude());
				MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
				mBaiduMap.animateMapStatus(u);//以动画方式更新地图状态，动画耗时 300 ms
				setStartPoint(ll);
			}
		}
		public void onReceivePoi(BDLocation poiLocation) {
		}
	}

	// 定位相关
	LocationClient mLocClient;
	public MyLocationListenner myListener = new MyLocationListenner();
	private LocationMode mCurrentMode;
	BitmapDescriptor mCurrentMarker;

	MapView mMapView;
	BaiduMap mBaiduMap;
	public GeofenceClient mGeofenceClient;
	private TextView mLocationResult;
	
	
	private String mCity;
	// UI相关

	private LatLng mStartPt;
	private LatLng mEndPt = null;

	private Marker mStartMarker;
	private Marker mEndMarker;

//	@InjectView(R.id.customicon)
//	Button customicon;
	private GeoCoder mGeoSearch;
	
	// 搜索相关
	RoutePlanSearch mSearch = null;
	RouteLine route = null;
	private Marker mRunPosMarker;
	private ArrayList<LatLng> myAllStep = new ArrayList();
	private BitmapDescriptor bd;
	private WalkingRouteOverlay mRouteOverlay;
	private float mTotalDistance;
	private float mAvgSpeed = 5;
	private int mAlyTime = 0;
	private float mAlyDistance = 0;
	AsyncTask<Void, LatLng, String> task;

	private PanoramaView mPanoView;
	private boolean isPanoViewMap = false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 去掉默认标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		// 先初始化BMapManager
		BaseApplication app = (BaseApplication) this.getApplication();
		if (app.mBMapManager == null) {
			app.mBMapManager = new BMapManager(app);

			app.mBMapManager.init(new BaseApplication.MyGeneralListener());
		}
		setContentView(R.layout.activity_zizhuyoulan);
//标题
		TextView textView = (TextView) findViewById(R.id.title_text);
		
		textView.setText("三山五园 ");
		
	
		// 地图初始化
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();
		//更改缩放级别为15
		mBaiduMap.setMapStatus(MapStatusUpdateFactory.zoomTo(15));
		
		
		mLocationResult = (TextView)findViewById(R.id.textView1);
		mGeofenceClient = new GeofenceClient(getApplicationContext());
		// 开启定位图层
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
		
		
		
		mCurrentMarker = BitmapDescriptorFactory
				.fromResource(R.drawable.icon_geo);
		mBaiduMap.setMyLocationConfigeration(new MyLocationConfiguration(null,
				false, null));
		option.setIsNeedAddress(true);
		mBaiduMap.setOnMapClickListener(this);

		// 初始化搜索模块，注册事件监听
		mSearch = RoutePlanSearch.newInstance();
		mSearch.setOnGetRoutePlanResultListener(this);
		mGeoSearch = GeoCoder.newInstance();
		mGeoSearch.setOnGetGeoCodeResultListener(this);
		bd = BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding);

		// 全景
		mPanoView = (PanoramaView) findViewById(R.id.panorama);
		mPanoView.setPanoramaImageLevel(4);
		mPanoView.setPanoramaViewListener(this);
		mPanoView.setShowTopoLink(false);
		mPanoView.setZoomGestureEnabled(false);
		mPanoView.setRotateGestureEnabled(false);
		mPanoView.setPanorama("0100220000130817164838355J5");

		Button bt_Customicon = (Button) findViewById(R.id.customicon);
		bt_Customicon.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.d("zhuzhuzhuzhuz", "点击了线路规划");
				startSearchRoute();
				mLocationResult.setVisibility(View.GONE);
			}
		});
		Button bt_Muni = (Button) findViewById(R.id.muni);
		bt_Muni.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.d("zhuzhuzhuzhuz", "点击了模拟");
//				T.showShort(mContext, "请点击路线规划，模拟路线");
					startMuniRun();
			}
		});
	}
	
	
	
	private void setStartPoint(LatLng latlng) {

		// TODO Auto-generated method stub
		if (mStartMarker != null) {
			mStartMarker.remove();
			mStartMarker = null;
		}

		MarkerOptions markeroptions = (new MarkerOptions())
				.position(latlng)
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_geo))
				.zIndex(16).draggable(false);

		mStartMarker = (Marker) mBaiduMap.addOverlay(markeroptions);
		mPanoView.setPanorama(latlng.longitude, latlng.latitude);
	}

	private void setEndPoint(LatLng latlng)

	{

		if (mEndMarker != null) {
			mEndMarker.remove();
			mEndMarker = null;
		}

		MarkerOptions markeroptions = (new MarkerOptions()).position(latlng)
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_en))
				.zIndex(16).draggable(true);

		mEndMarker = (Marker) mBaiduMap.addOverlay(markeroptions);

	}
	
	private void startMuniRun() {
		task = new AsyncTask<Void, LatLng, String>() {

			@Override
			protected String doInBackground(Void... params) {

				for (int i = 0; i < myAllStep.size(); i++) {
					try {
						publishProgress(myAllStep.get(i));

						if (isPanoViewMap) {
							Thread.sleep(3000);
						} else {
							Thread.sleep(300);
						}

					} catch (Exception e) {
					}
				}
				publishProgress(mEndPt);
				return null;
			}

			@Override
			protected void onProgressUpdate(LatLng... values) {
				// drawStep(myAllStep.get(values[0]));
				if (isPanoViewMap) {
					mPanoView.setPanorama(values[0].longitude,
							values[0].latitude);
				} else {
					
						try {
							drawStep(values[0]);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			}
			@Override
			protected void onPreExecute() {

			}
			@Override
			protected void onPostExecute(String result) {

				super.onPostExecute(result);
			}
		};
		task.execute();
	}

	private void startSearchRoute() {

		if (mEndPt == null){
			T.showLong(mContext, "请点击地图设置终点");
			return;
		}
			
		if (mRouteOverlay != null)
			mRouteOverlay.removeFromMap();
		PlanNode stNode = null;
		PlanNode enNode = null;
		if (mStartPt == null) {
			T.showLong(mContext, "请设置起始点");
			return;
		} else {
			stNode = PlanNode.withLocation(mStartPt);
		}
		if (mEndPt == null) {
		} else {
			enNode = PlanNode.withLocation(mEndPt);
		}
		if (mStartPt != null && mEndPt != null) {
			mSearch.walkingSearch((new WalkingRoutePlanOption()).from(stNode)
					.to(enNode));
		} 

	}
	public void logMsg(String str) {
		try {
			if (mLocationResult != null)
				mLocationResult.setText(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		// 在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
//		ZiZhuYouLanActivity.this.finish();
	}

	@Override
	protected void onResume() {
		
		// 在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
		mMapView.onResume();
		mPanoView.onResume();
		super.onResume();
	}

	@Override
	protected void onPause() {
		
		// 在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
		mMapView.onPause();
		mPanoView.onPause();
		super.onPause();
	}
	@Override
	public void onGetGeoCodeResult(GeoCodeResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGetReverseGeoCodeResult(ReverseGeoCodeResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onLoadPanoramBegin() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onLoadPanoramaEnd() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onLoadPanoramaError() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGetDrivingRouteResult(DrivingRouteResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onGetTransitRouteResult(TransitRouteResult arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onMapPoiClick(MapPoi arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void onGetWalkingRouteResult(WalkingRouteResult result) {
		// TODO Auto-generated method stub
		if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
			Toast.makeText(ZiZhuYouLanActivity.this, "抱歉，未找到结果", Toast.LENGTH_SHORT)
					.show();
		}
		if (result.error == SearchResult.ERRORNO.AMBIGUOUS_ROURE_ADDR) {
			// 起终点或途经点地址有岐义，通过以下接口获取建议查询信息
			// result.getSuggestAddrInfo()
			return;
		}
		if (result.error == SearchResult.ERRORNO.NO_ERROR) {
			mBaiduMap.clear();
			route = result.getRouteLines().get(0);
			mRouteOverlay = new MyWalkingRouteOverlay(mBaiduMap);
			mBaiduMap.setOnMarkerClickListener(mRouteOverlay);
			// routeOverlay = overlay;
			mRouteOverlay.setData(result.getRouteLines().get(0));
			mRouteOverlay.addToMap();
			mRouteOverlay.zoomToSpan();
			mTotalDistance = route.getDistance();
			LatLng currentLanLang = null;
			myAllStep.clear();

			for (int i = 0; i < route.getAllStep().size(); i++) {

				List<LatLng> LatLngList = ((WalkingStep) route.getAllStep()
						.get(i)).getWayPoints();
				for (LatLng latlng1 : LatLngList) {

					if (currentLanLang != null) {
						double d1 = getDistance(latlng1, currentLanLang);
						if (d1 > 9.000000000000001E-005D) {
							int q = (int) (d1 / 9.000000000000001E-005D);
							double d2latitude = (latlng1.latitude - currentLanLang.latitude)
									/ q;
							double d3longitude = (latlng1.longitude - currentLanLang.longitude)
									/ q;
							for (int k = 1; k < q; k++) {
								LatLng LatLng2 = new LatLng(
										currentLanLang.latitude + d2latitude
												* k, currentLanLang.longitude
												+ d3longitude * k);
								myAllStep.add(LatLng2);
							}
						} else {
							myAllStep.add(latlng1);
						}
						currentLanLang = latlng1;
					} else {
						myAllStep.add(latlng1);
						currentLanLang = latlng1;
					}

				}
			}
		}
	}

	public double getDistance(LatLng latlng, LatLng latlng1) {
		double d = latlng.latitude;
		double d1 = latlng1.latitude;
		double d2 = latlng.longitude;
		double d3 = latlng1.longitude;
		return Math.sqrt(Math.pow(d - d1, 2D) + Math.pow(d2 - d3, 2D));
	}

	public void drawStep(LatLng latlng) {
		if (mRunPosMarker != null) {
			mRunPosMarker.remove();
			mRunPosMarker = null;
		}
		MarkerOptions markeroptions = (new MarkerOptions()).position(latlng)
				.icon(bd).zIndex(16).draggable(false);
		mRunPosMarker = (Marker) mBaiduMap.addOverlay(markeroptions);

	}

	private class MyWalkingRouteOverlay extends WalkingRouteOverlay {

		public MyWalkingRouteOverlay(BaiduMap baiduMap) {
			super(baiduMap);
		}

		@Override
		public BitmapDescriptor getStartMarker() {
			return BitmapDescriptorFactory.fromResource(R.drawable.icon_geo);
		}

		@Override
		public BitmapDescriptor getTerminalMarker() {
			return BitmapDescriptorFactory.fromResource(R.drawable.icon_en);
		}
	}
	/**
	 * 设置底图显示模式
	 * @param view
	 */
	public void setMapMode(View view) {
		boolean checked = ((RadioButton) view).isChecked();
		switch (view.getId()) {
		case R.id.normal:
			if (checked) {
				isPanoViewMap = false;
				showhidePanoView(false);

				mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
			}

			break;
		case R.id.statellite:
			if (checked) {
				isPanoViewMap = false;
				showhidePanoView(false);

				mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
			}

			break;
		case R.id.statepanorama:
			if (checked) {
				isPanoViewMap = true;
				showhidePanoView(true);

				if (mStartPt != null) {
					mPanoView
							.setPanorama(mStartPt.longitude, mStartPt.latitude);
				} 
			}
			break;
		}
	}

	private void showhidePanoView(boolean flag) {
		android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams) mMapView
				.getLayoutParams();
		android.widget.LinearLayout.LayoutParams layoutparams1 = (android.widget.LinearLayout.LayoutParams) mPanoView
				.getLayoutParams();
		if (flag) {
			layoutparams.weight = 1.0F;
			layoutparams1.weight = 999F;
		} else {
			layoutparams.weight = 999F;
			layoutparams1.weight = 1.0F;
		}
		mMapView.setLayoutParams(layoutparams);
		mPanoView.setLayoutParams(layoutparams1);
	}

	@Override
	public void onMapClick(LatLng point) {
		mBaiduMap.hideInfoWindow();
		mEndPt = point;
		LatLng ptCenter = point;
		setEndPoint(point);
	}
}
