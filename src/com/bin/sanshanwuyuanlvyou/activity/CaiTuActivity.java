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
		titleText.setText("�²�������");
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
							.setText("�����Ҳ�ơ��������򡰶���������λ�ڱ�����������Ȫɽ������������ڡ��������Ӱ���Ǿ���԰ʮ����֮һ�����������150�ף��Ǳ�������λ����ߵ�����");
					caiTuShuoMing.setVisibility(View.VISIBLE);
					caiTuChaKan.setText("���ش�");
					chaKan = false;
				}else {
					caiTuChaKan.setText("��ʾ��");
					caiTuShuoMing.setVisibility(View.GONE);
					caiTuXianDai.setVisibility(View.GONE);
					chaKan = true;
				}
			}
		});

	}
}
