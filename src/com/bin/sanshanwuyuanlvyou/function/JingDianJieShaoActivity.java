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
			titleText.setText("ÏãÉ½¾°µã½éÉÜ");
			jingDianlist = new ArrayList<JingDian>();

			JingDian changYangGe = new JingDian("ÖØÑô¸ó", R.drawable.chongyangge);
			jingDianlist.add(changYangGe);
			JingDian sunZhongShanJiNianTang = new JingDian("ËïÖĞÉ½¼ÍÄîÌÃ",
					R.drawable.sunzhongshanjiniantang);
			jingDianlist.add(sunZhongShanJiNianTang);
			JingDian zhiSongYuan = new JingDian("ÖªËÉÔ°", R.drawable.zhisongyuan);
			jingDianlist.add(zhiSongYuan);
			JingDian yingLuoYan = new JingDian("è¬çóÑÒ", R.drawable.yingluoyan);
			jingDianlist.add(yingLuoYan);
			JingDian yanJingHu = new JingDian("ÑÛ¾µºş", R.drawable.yanjinghu);
			jingDianlist.add(yanJingHu);
			JingDian qinZhengDian = new JingDian("ÇÚÕşµî", R.drawable.qinzhengdian);
			jingDianlist.add(qinZhengDian);
			JingDian xiangShanSi = new JingDian("ÏãÉ½ËÂ", R.drawable.xiangshansi);
			jingDianlist.add(xiangShanSi);
			JingDian shuangQingBieShu = new JingDian("Ë«Çå±ğÊû",
					R.drawable.shuangqingbieshu);
			jingDianlist.add(shuangQingBieShu);
			JingDian chaoYangDong = new JingDian("³¯Ñô¶´", R.drawable.chaoyangdong);
			jingDianlist.add(chaoYangDong);
			JingDian xiShanQingXueBei = new JingDian("Î÷É½ÇçÑ©±®",
					R.drawable.xishanqingxuebei);
			jingDianlist.add(xiShanQingXueBei);
			JingDian yuHuaShanZhuang = new JingDian("Óñ»ªÉ½×¯",
					R.drawable.yuhuashanzhuang);
			jingDianlist.add(yuHuaShanZhuang);
			JingDian jianXinZhai = new JingDian("¼ûĞÄÕ«", R.drawable.jianxinzhai);
			jingDianlist.add(jianXinZhai);

			// ²¼¾ÖÏà¹Ø
			layoutJingDian(jingDianlist,0);
			
			break;
		case 1:
			titleText.setText("³©´ºÔ°¾°µã½éÉÜ");
			jingDianlist = new ArrayList<JingDian>();

			JingDian enYouSi = new JingDian("¶÷ÓÓËÂ", R.drawable.enyousi);
			jingDianlist.add(enYouSi);
			JingDian enMuSiShanMen = new JingDian("¶÷Ä½ËÂÉ½ÃÅ", R.drawable.enmusishanmen);
			jingDianlist.add(enMuSiShanMen);
			
			layoutJingDian(jingDianlist,1);
			break;
		case 2:
			titleText.setText("¾²Ã÷Ô°¾°µã½éÉÜ");
			jingDianlist = new ArrayList<JingDian>();

			JingDian yuFengTa = new JingDian("Óñ·åËş", R.drawable.yufengta);
			jingDianlist.add(yuFengTa);
			
			layoutJingDian(jingDianlist,2);
			break;
		case 3:
			titleText.setText("¾²ÒËÔ°¾°µã½éÉÜ");
			jingDianlist = new ArrayList<JingDian>();

			JingDian fuRongPing = new JingDian("Ü½ÈØÆº", R.drawable.furongping);
			jingDianlist.add(fuRongPing);
			JingDian zhaoMiao = new JingDian("ÕÑÃí", R.drawable.zhaomiao);
			jingDianlist.add(zhaoMiao);
			JingDian biYunSi = new JingDian("±ÌÔÆËÂ", R.drawable.biyunsi);
			jingDianlist.add(biYunSi);
			
			layoutJingDian(jingDianlist,3);
			break;
		case 4:
			titleText.setText("ÍòÊÙÉ½¾°µã½éÉÜ");
			jingDianlist = new ArrayList<JingDian>();

			JingDian xiangYanZongYinZhiGe = new JingDian("ÏãÑÒ×ÚÓ¡Ö®¸ó", R.drawable.xiangyanzongyinzhige);
			jingDianlist.add(xiangYanZongYinZhiGe);
			JingDian jiaYinXuan = new JingDian("¼ÎÒñĞù", R.drawable.jiayinxuan);
			jingDianlist.add(jiaYinXuan);
			JingDian xieQuYuan = new JingDian("Ğ³È¤Ô°", R.drawable.xiequyuan);
			jingDianlist.add(xieQuYuan);
			JingDian tiaoYuanZhai = new JingDian("Ì÷Ô¶Õ«", R.drawable.tiaoyuanzhai);
			jingDianlist.add(tiaoYuanZhai);
			JingDian huaZhongYou = new JingDian("»­ÖĞÓÎ", R.drawable.huazhongyou);
			jingDianlist.add(huaZhongYou);
			JingDian xieQiuXuan = new JingDian("Ğ´ÇïĞù", R.drawable.xieqiuxuan);
			jingDianlist.add(xieQiuXuan);
			JingDian yuanLangZhai = new JingDian("Ô²ÀÊÕ«", R.drawable.yuanlangzhai);
			jingDianlist.add(yuanLangZhai);
			
			layoutJingDian(jingDianlist,4);
			break;
		case 5:
			titleText.setText("ÒÃºÍÔ°¾°µã½éÉÜ");
			jingDianlist = new ArrayList<JingDian>();

			JingDian renShouDian = new JingDian("ÈÊÊÙµî", R.drawable.renshoudian);
			jingDianlist.add(renShouDian);
			JingDian leShouTang = new JingDian("ÀÖÊÙÌÃ", R.drawable.leshoutang);
			jingDianlist.add(leShouTang);
			JingDian yuLanTang = new JingDian("ÓñÀ½ÌÃ", R.drawable.yulantang);
			jingDianlist.add(yuLanTang);
			JingDian yunHuiGuan = new JingDian("ÒËÜ¿¹İ", R.drawable.yunhuiguan);
			jingDianlist.add(yunHuiGuan);
			JingDian kunMingHu = new JingDian("À¥Ã÷ºş", R.drawable.kunminghu);
			jingDianlist.add(kunMingHu);
			JingDian daXiLou = new JingDian("´óÏ·Â¥", R.drawable.daxilou);
			jingDianlist.add(daXiLou);
			JingDian foXiangGe = new JingDian("·ğÏã¸ó", R.drawable.foxiangge);
			jingDianlist.add(foXiangGe);
			JingDian paiYunDian = new JingDian("ÅÅÔÆµî", R.drawable.paiyundian);
			jingDianlist.add(paiYunDian);
			JingDian zhiHuiHai = new JingDian("ÖÇ»Ûº£", R.drawable.zhihuihai);
			jingDianlist.add(zhiHuiHai);
			JingDian changLang = new JingDian("³¤ÀÈ", R.drawable.changlang);
			jingDianlist.add(changLang);
			JingDian baoYunGe = new JingDian("±¦ÔÆ¸ó", R.drawable.baoyunge);
			jingDianlist.add(baoYunGe);
			JingDian wenChangGe = new JingDian("ÎÄ²ı¸ó", R.drawable.wenchangge);
			jingDianlist.add(wenChangGe);
			JingDian shiQiKongQiao = new JingDian("Ê®Æß¿×ÇÅ", R.drawable.shiqikongqiao);
			jingDianlist.add(shiQiKongQiao);
			
			layoutJingDian(jingDianlist,5);
			break;
		case 6:
			titleText.setText("Ô²Ã÷Ô°¾°µã½éÉÜ");
			jingDianlist = new ArrayList<JingDian>();

			JingDian xiYangLouYiZhi = new JingDian("Î÷ÑóÂ¥ÒÅÖ·", R.drawable.xiyanglouyizhi);
			jingDianlist.add(xiYangLouYiZhi);
			JingDian zhengJueSi = new JingDian("Õı¾õËÂ", R.drawable.zhengjuesi);
			jingDianlist.add(zhengJueSi);
			JingDian jianBiTing = new JingDian("¼ø±ÌÍ¤", R.drawable.jianbiting);
			jingDianlist.add(jianBiTing);
			JingDian shiCanQiao = new JingDian("Ê¯²ĞÇÅ", R.drawable.shicanqiao);
			jingDianlist.add(shiCanQiao);
			JingDian qiChunYuan = new JingDian("ç²´ºÔ°", R.drawable.qichunyuan);
			jingDianlist.add(qiChunYuan);
			
			layoutJingDian(jingDianlist,6);
			break;
		case 7:
			titleText.setText("ÓñÈªÉ½¾°µã½éÉÜ");
			jingDianlist = new ArrayList<JingDian>();

			JingDian yuQuanShanJingDian = new JingDian("ÓñÈªÉ½", R.drawable.yuquanshanjingdian);
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
