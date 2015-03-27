package com.bin.sanshanwuyuanlvyou.zizhuyoulan.utils;

import com.baidu.mapapi.model.LatLng;

/**

 */
public class GeoUtil {

	/**
	 * 鏍规嵁缁忕含搴﹀拰璺濈杩斿洖涓�釜鐭╁舰鑼冨洿
	 * 
	 * @param lng
	 *            缁忓害
	 * @param lat
	 *            绾害
	 * @param distance
	 *            璺濈(鍗曚綅涓虹背)
	 * @return [lng1,lat1, lng2,lat2] 鐭╁舰鐨勫乏涓嬭(lng1,lat1)鍜屽彸涓婅(lng2,lat2)
	 */
	public static double[] getRectangle(double lng, double lat, long distance) {
		float delta = 111000;
		if (lng != 0 && lat != 0) {
			double lng1 = lng - distance
					/ Math.abs(Math.cos(Math.toRadians(lat)) * delta);
			double lng2 = lng + distance
					/ Math.abs(Math.cos(Math.toRadians(lat)) * delta);
			double lat1 = lat - (distance / delta);
			double lat2 = lat + (distance / delta);
			return new double[] { lng1, lat1, lng2, lat2 };
		} else {
			// TODO ZHCH 绛変簬0鏃剁殑璁＄畻鍏紡
			double lng1 = lng - distance / delta;
			double lng2 = lng + distance / delta;
			double lat1 = lat - (distance / delta);
			double lat2 = lat + (distance / delta);
			return new double[] { lng1, lat1, lng2, lat2 };
		}
	}

	/**
	 * 寰楀埌涓ょ偣闂寸殑璺濈 绫�	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double getDistanceOfMeter(double lat1, double lng1,
			double lat2, double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10;
		return s;
	}

	/**
	 * 寰楀埌涓ょ偣闂寸殑璺濈 绫�	 * 
	 * @param lat1
	 * @param lng1
	 * @param lat2
	 * @param lng2
	 * @return
	 */
	public static double getDistanceOfMeter(LatLng latlng, LatLng latlng1) {
		double lat1 = latlng.latitude;
		double lat2 = latlng1.latitude;
		double lng1 = latlng.longitude;
		double lng2 = latlng1.longitude;
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10;
		return s;
	}

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	/**
	 * 鍦扮悆鍗婂緞锛�378.137KM
	 */
	private static double EARTH_RADIUS = 6378.137;
}
