package com.bin.sanshanwuyuanlvyou.function;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.util.Xml;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.model.LatLng;
import com.bin.sanshanwuyuanlvyou.R;

public class XianShiZuJiActivity extends Activity {
	// ��ͼ���
	MapView mMapView;
	BaiduMap mBaiduMap;

	int id;
	private Marker zuJiDianMarker;
	BitmapDescriptor bdZuJi = BitmapDescriptorFactory
			.fromResource(R.drawable.icon_mark);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xianshizuji);
		// ��ʼ����ͼ
		mMapView = (MapView) findViewById(R.id.bmapView);
		mBaiduMap = mMapView.getMap();

		Intent intent = getIntent();
		id = intent.getIntExtra("id", 0);
		// �����洢��xml�ļ�
		List<LatLng> latLngList = parserXmlFromLocal();
		Log.i("TestCase", latLngList.size() + "");
		// for (LatLng latLng : latLngList) {
		// Log.i("TestCase", latLng.latitude+"");
		// }
		MapStatusUpdate msu = MapStatusUpdateFactory.zoomTo(17.0f);
		mBaiduMap.setMapStatus(msu);

		if (latLngList.size() > 1) {
			//��
			OverlayOptions ooPolyline = new PolylineOptions().width(10)
					.color(0xAAFF0000).points(latLngList);
			mBaiduMap.addOverlay(ooPolyline);
			//���ĵ�
			MapStatusUpdate msu2 = MapStatusUpdateFactory.newLatLng(latLngList
					.get(0));
			mBaiduMap.setMapStatus(msu2);
			//����ע
			OverlayOptions ooA = new MarkerOptions()
					.position(latLngList.get(0)).icon(bdZuJi)
					.perspective(false).anchor(0.5f, 0.5f).zIndex(7);
			zuJiDianMarker = (Marker) (mBaiduMap.addOverlay(ooA));
			Toast.makeText(getApplicationContext(), "��ʾ�����㼣",
					Toast.LENGTH_SHORT).show();
		} else if (latLngList.size() == 1) {
			OverlayOptions ooA = new MarkerOptions()
					.position(latLngList.get(0)).icon(bdZuJi)
					.perspective(false).anchor(0.5f, 0.5f).zIndex(7);
			zuJiDianMarker = (Marker) (mBaiduMap.addOverlay(ooA));
			MapStatusUpdate msu2 = MapStatusUpdateFactory.newLatLng(latLngList
					.get(0));
			mBaiduMap.setMapStatus(msu2);
			Toast.makeText(getApplicationContext(), "��ʾ���ļ�¼��",
					Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(getApplicationContext(), "û���㼣", Toast.LENGTH_SHORT)
					.show();
		}
	}

	private List<LatLng> parserXmlFromLocal() {
		try {
			// File path = new File(Environment.getExternalStorageDirectory(),
			// "latLng"+(id+1)+".xml");
			// FileInputStream fis = new FileInputStream(path);

			File file = new File(
					"/data/data/com.bin.sanshanwuyuanlvyou/files/latLng"
							+ (id + 1) + ".xml");
			FileInputStream fis = new FileInputStream(file);

			// ���pull����������
			XmlPullParser parser = Xml.newPullParser();
			// ָ���������ļ��ͱ����ʽ
			parser.setInput(fis, "utf-8");

			int eventType = parser.getEventType(); // ����¼�����

			List<LatLng> latLngList = null;
			LatLng latLng = null;
			double latitude = 0;
			double longitude;
			while (eventType != XmlPullParser.END_DOCUMENT) {
				String tagName = parser.getName(); // ��õ�ǰ�ڵ������

				switch (eventType) {
				case XmlPullParser.START_TAG: // ��ǰ���ڿ�ʼ�ڵ� <person>
					if ("latLngs".equals(tagName)) { // <persons>
						latLngList = new ArrayList<LatLng>();
					} else if ("latLng".equals(tagName)) { // <person id="1">

					} else if ("latitude".equals(tagName)) { // <name>
						latitude = Double.parseDouble(parser.nextText());
					} else if ("longitude".equals(tagName)) { // <age>
						longitude = Double.parseDouble(parser.nextText());
						latLng = new LatLng(latitude, longitude);
					}
					break;
				case XmlPullParser.END_TAG: // </persons>
					if ("latLng".equals(tagName)) {
						// ��Ҫ���������ú�ֵ��person������ӵ�������
						latLngList.add(latLng);
					}
					break;
				default:
					break;
				}

				eventType = parser.next(); // �����һ���¼�����
			}
			return latLngList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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

		mMapView.onDestroy();
		mMapView = null;

		super.onDestroy();
	}
}
