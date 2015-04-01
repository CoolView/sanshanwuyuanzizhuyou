package com.bin.sanshanwuyuanlvyou.weather;

public interface HttpCallbackListener {

	void onFinish(String response);

	void onError(Exception e);

}
