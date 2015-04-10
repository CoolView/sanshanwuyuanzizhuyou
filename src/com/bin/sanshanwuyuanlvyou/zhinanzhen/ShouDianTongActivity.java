package com.bin.sanshanwuyuanlvyou.zhinanzhen;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bin.sanshanwuyuanlvyou.R;

public class ShouDianTongActivity extends Activity {
	private boolean isopent = false;
	private Camera camera;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View view = View.inflate(this, R.layout.shoudiantong, null);
		setContentView(view);
		final ImageButton im_sdt = (ImageButton) findViewById(R.id.im_sdt);
		
		im_sdt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!isopent) {
					Toast.makeText(getApplicationContext(), "您已经打开了手电筒", 0)
							.show();
					camera = Camera.open();
					Parameters params = camera.getParameters();
					params.setFlashMode(Parameters.FLASH_MODE_TORCH);
					camera.setParameters(params);
					camera.startPreview(); // 开始亮灯
					im_sdt.setBackgroundResource(R.drawable.sdt_liang);

					isopent = true;
				} else {
					Toast.makeText(getApplicationContext(), "关闭了手电筒",
							Toast.LENGTH_SHORT).show();
					camera.stopPreview(); // 关掉亮灯
					camera.release(); // 关掉照相机
					isopent = false;
					im_sdt.setBackgroundResource(R.drawable.sdt_hei);
				}
			}
		});
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if (isopent){
			camera.stopPreview(); // 关掉亮灯
			camera.release();
		}
	}

}
