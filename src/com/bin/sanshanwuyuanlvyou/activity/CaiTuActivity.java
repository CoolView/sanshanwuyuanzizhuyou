package com.bin.sanshanwuyuanlvyou.activity;

import com.bin.sanshanwuyuanlvyou.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CaiTuActivity extends Activity {

	private TextView titleText;
	private TextView caiTuShuoMing;
	private ImageView caiTuGuDai;
	private ImageView caiTuXianDai;
	private Button caiTuChaKan;
	private boolean chaKan = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caitu);

		titleText = (TextView) findViewById(R.id.title_text);
		titleText.setText("猜猜这是哪");
		caiTuGuDai = (ImageView) findViewById(R.id.caitu_gudai);
		caiTuGuDai.setBackgroundResource(R.drawable.caitu_gudai);
		caiTuXianDai = (ImageView) findViewById(R.id.caitu_xiandai);

		caiTuShuoMing = (TextView) findViewById(R.id.caitu_shuoming);

		caiTuChaKan = (Button) findViewById(R.id.caitu_chakan);
		caiTuChaKan.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (chaKan) {
					caiTuXianDai
							.setBackgroundResource(R.drawable.caitu_xiandai);
					caiTuXianDai.setVisibility(View.VISIBLE);
					caiTuShuoMing
							.setText("玉峰塔也称“大塔”或“定光塔”，位于北京西北的玉泉山主峰上香积寺内。“玉峰塔影”是静明园十六景之一，塔顶距地面150米，是北京地理位置最高的塔。");
					caiTuShuoMing.setVisibility(View.VISIBLE);
					caiTuChaKan.setText("隐藏答案");
					chaKan = false;
				}else {
					caiTuChaKan.setText("显示答案");
					caiTuShuoMing.setVisibility(View.GONE);
					caiTuXianDai.setVisibility(View.GONE);
					chaKan = true;
				}
			}
		});

	}
}
