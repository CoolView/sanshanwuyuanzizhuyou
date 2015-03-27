package com.bin.sanshanwuyuanlvyou.function;

import java.util.ArrayList;
import java.util.List;

import com.bin.sanshanwuyuanlvyou.R;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class JingDianJieShaoActivity extends Activity {
	TextView titleText;
	private List<JingDian> jingDianlist;
	ListView listView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.jingdianjieshao_layout);
		
		Intent intent = getIntent();
		int id = intent.getIntExtra("ID", 0);
		titleText = (TextView) findViewById(R.id.title_text);
		switch (id) {
		case 0:
			titleText.setText("��ɽ�������");
			jingDianlist = new ArrayList<JingDian>();

			JingDian changYangGe = new JingDian("������", R.drawable.chongyangge);
			jingDianlist.add(changYangGe);
			JingDian sunZhongShanJiNianTang = new JingDian("����ɽ������",
					R.drawable.sunzhongshanjiniantang);
			jingDianlist.add(sunZhongShanJiNianTang);
			JingDian zhiSongYuan = new JingDian("֪��԰", R.drawable.zhisongyuan);
			jingDianlist.add(zhiSongYuan);
			JingDian yingLuoYan = new JingDian("�����", R.drawable.yingluoyan);
			jingDianlist.add(yingLuoYan);
			JingDian yanJingHu = new JingDian("�۾���", R.drawable.yanjinghu);
			jingDianlist.add(yanJingHu);
			JingDian qinZhengDian = new JingDian("������", R.drawable.qinzhengdian);
			jingDianlist.add(qinZhengDian);
			JingDian xiangShanSi = new JingDian("��ɽ��", R.drawable.xiangshansi);
			jingDianlist.add(xiangShanSi);
			JingDian shuangQingBieShu = new JingDian("˫�����",
					R.drawable.shuangqingbieshu);
			jingDianlist.add(shuangQingBieShu);
			JingDian chaoYangDong = new JingDian("������", R.drawable.chaoyangdong);
			jingDianlist.add(chaoYangDong);
			JingDian xiShanQingXueBei = new JingDian("��ɽ��ѩ��",
					R.drawable.xishanqingxuebei);
			jingDianlist.add(xiShanQingXueBei);
			JingDian yuHuaShanZhuang = new JingDian("��ɽׯ",
					R.drawable.yuhuashanzhuang);
			jingDianlist.add(yuHuaShanZhuang);
			JingDian jianXinZhai = new JingDian("����ի", R.drawable.jianxinzhai);
			jingDianlist.add(jianXinZhai);

			// �������
			layoutJingDian(jingDianlist,0);
			
			break;
		case 1:
			titleText.setText("����԰�������");
			jingDianlist = new ArrayList<JingDian>();

			JingDian enYouSi = new JingDian("������", R.drawable.enyousi);
			jingDianlist.add(enYouSi);
			JingDian enMuSiShanMen = new JingDian("��Ľ��ɽ��", R.drawable.enmusishanmen);
			jingDianlist.add(enMuSiShanMen);
			
			layoutJingDian(jingDianlist,1);
			break;
		case 2:
			titleText.setText("����԰�������");
			jingDianlist = new ArrayList<JingDian>();

			JingDian yuFengTa = new JingDian("�����", R.drawable.yufengta);
			jingDianlist.add(yuFengTa);
			
			layoutJingDian(jingDianlist,2);
			break;
		case 3:
			titleText.setText("����԰�������");
			jingDianlist = new ArrayList<JingDian>();

			JingDian fuRongPing = new JingDian("ܽ��ƺ", R.drawable.furongping);
			jingDianlist.add(fuRongPing);
			JingDian zhaoMiao = new JingDian("����", R.drawable.zhaomiao);
			jingDianlist.add(zhaoMiao);
			JingDian biYunSi = new JingDian("������", R.drawable.biyunsi);
			jingDianlist.add(biYunSi);
			
			layoutJingDian(jingDianlist,3);
			break;
		case 4:
			titleText.setText("����ɽ�������");
			jingDianlist = new ArrayList<JingDian>();

			JingDian xiangYanZongYinZhiGe = new JingDian("������ӡ֮��", R.drawable.xiangyanzongyinzhige);
			jingDianlist.add(xiangYanZongYinZhiGe);
			JingDian jiaYinXuan = new JingDian("������", R.drawable.jiayinxuan);
			jingDianlist.add(jiaYinXuan);
			JingDian xieQuYuan = new JingDian("гȤ԰", R.drawable.xiequyuan);
			jingDianlist.add(xieQuYuan);
			JingDian tiaoYuanZhai = new JingDian("��Զի", R.drawable.tiaoyuanzhai);
			jingDianlist.add(tiaoYuanZhai);
			JingDian huaZhongYou = new JingDian("������", R.drawable.huazhongyou);
			jingDianlist.add(huaZhongYou);
			JingDian xieQiuXuan = new JingDian("д����", R.drawable.xieqiuxuan);
			jingDianlist.add(xieQiuXuan);
			JingDian yuanLangZhai = new JingDian("Բ��ի", R.drawable.yuanlangzhai);
			jingDianlist.add(yuanLangZhai);
			
			layoutJingDian(jingDianlist,4);
			break;
		case 5:
			titleText.setText("�ú�԰�������");
			jingDianlist = new ArrayList<JingDian>();

			JingDian renShouDian = new JingDian("���ٵ�", R.drawable.renshoudian);
			jingDianlist.add(renShouDian);
			JingDian leShouTang = new JingDian("������", R.drawable.leshoutang);
			jingDianlist.add(leShouTang);
			JingDian yuLanTang = new JingDian("������", R.drawable.yulantang);
			jingDianlist.add(yuLanTang);
			JingDian yunHuiGuan = new JingDian("��ܿ��", R.drawable.yunhuiguan);
			jingDianlist.add(yunHuiGuan);
			JingDian kunMingHu = new JingDian("������", R.drawable.kunminghu);
			jingDianlist.add(kunMingHu);
			JingDian daXiLou = new JingDian("��Ϸ¥", R.drawable.daxilou);
			jingDianlist.add(daXiLou);
			JingDian foXiangGe = new JingDian("�����", R.drawable.foxiangge);
			jingDianlist.add(foXiangGe);
			JingDian paiYunDian = new JingDian("���Ƶ�", R.drawable.paiyundian);
			jingDianlist.add(paiYunDian);
			JingDian zhiHuiHai = new JingDian("�ǻۺ�", R.drawable.zhihuihai);
			jingDianlist.add(zhiHuiHai);
			JingDian changLang = new JingDian("����", R.drawable.changlang);
			jingDianlist.add(changLang);
			JingDian baoYunGe = new JingDian("���Ƹ�", R.drawable.baoyunge);
			jingDianlist.add(baoYunGe);
			JingDian wenChangGe = new JingDian("�Ĳ���", R.drawable.wenchangge);
			jingDianlist.add(wenChangGe);
			JingDian shiQiKongQiao = new JingDian("ʮ�߿���", R.drawable.shiqikongqiao);
			jingDianlist.add(shiQiKongQiao);
			
			layoutJingDian(jingDianlist,5);
			break;
		case 6:
			titleText.setText("Բ��԰�������");
			jingDianlist = new ArrayList<JingDian>();

			JingDian xiYangLouYiZhi = new JingDian("����¥��ַ", R.drawable.xiyanglouyizhi);
			jingDianlist.add(xiYangLouYiZhi);
			JingDian zhengJueSi = new JingDian("������", R.drawable.zhengjuesi);
			jingDianlist.add(zhengJueSi);
			JingDian jianBiTing = new JingDian("����ͤ", R.drawable.jianbiting);
			jingDianlist.add(jianBiTing);
			JingDian shiCanQiao = new JingDian("ʯ����", R.drawable.shicanqiao);
			jingDianlist.add(shiCanQiao);
			JingDian qiChunYuan = new JingDian("粴�԰", R.drawable.qichunyuan);
			jingDianlist.add(qiChunYuan);
			
			layoutJingDian(jingDianlist,6);
			break;
		case 7:
			titleText.setText("��Ȫɽ�������");
			jingDianlist = new ArrayList<JingDian>();

			JingDian yuQuanShanJingDian = new JingDian("��Ȫɽ", R.drawable.yuquanshanjingdian);
			jingDianlist.add(yuQuanShanJingDian);
			
			layoutJingDian(jingDianlist,7);
			
			break;
		default:
			break;
		}
	}

	private void layoutJingDian(List<JingDian> jingDianlist2,final int id2) {
		JingDianAdapter adapter = new JingDianAdapter(
				JingDianJieShaoActivity.this, R.layout.jingdian_item,
				jingDianlist2);
		listView = (ListView) findViewById(R.id.lv_jingdian);
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				JingDian jingDian = jingDianlist.get(position);
				Intent intent = new Intent(JingDianJieShaoActivity.this,JingDianXiangQingActivity.class);
				intent.putExtra("ID", id2);
				intent.putExtra("JingDianId", jingDian.getImageId());
				startActivity(intent);
			}
			
		});
	}
}
