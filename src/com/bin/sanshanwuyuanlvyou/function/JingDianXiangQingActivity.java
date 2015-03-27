package com.bin.sanshanwuyuanlvyou.function;

import com.bin.sanshanwuyuanlvyou.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;


public class JingDianXiangQingActivity extends Activity {
	TextView titleText;
	TextView tv_jingDianXiangQing;
	ImageView image_jingDianXiangQing;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.jingdianxiangqing_layout);
		
		Intent intent = getIntent();
		int id = intent.getIntExtra("ID", 0);
		int ImageId = intent.getIntExtra("JingDianId", 0);

		titleText = (TextView) findViewById(R.id.title_text);
		tv_jingDianXiangQing = (TextView) findViewById(R.id.tv_jingdianxiangqing);
		image_jingDianXiangQing = (ImageView) findViewById(R.id.image_jingdianxiangqing);
		switch (id) {
		case 0:
			switch (ImageId) {
			case R.drawable.chongyangge:
				titleText.setText("������");
				tv_jingDianXiangQing
						.setText("		��¯�嶥��һ�齨�������ھž������Ǹ��������ǣ�����1983��4�£���Ϊ�ϡ������㡣");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.chongyangge);
				break;
			case R.drawable.sunzhongshanjiniantang:
				titleText.setText("����ɽ������");
				tv_jingDianXiangQing
						.setText("		��������ԭΪ��������1925��3��12�գ�����ɽ�����ڱ���������"
								+ "����������ͣ���ڱ�������ߴ��Ľ�ձ������ڣ�1929�꣬��ɽ����������ǰ���Ͼ��Ͻ�ɽʱ�����ڴ˵������ã�"
								+ "������¡�صĹ����Ͱ��������ڴ�����ɽ�������¹ڣ���Ϊ��ɽ�������¹�ڣ����ǰ�󷽣����й�����������ļ��ž�"
								+ "��ָ�ӵļ����֮�������Ϊ������ɽ�����á���������հ��������������ϵ��Ҷ������������ױ�����ġ�����ɽ�����á��������֡�");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.sunzhongshanjiniantang);
				break;
			case R.drawable.zhisongyuan:
				titleText.setText("֪��԰");
				tv_jingDianXiangQing
						.setText("		λ���ϱ���Ҫ�����ɵ����࣬ռ��2���꣬��1987���±ٽ��ľ�����������һ����"
								+ "�����ɰ�100���ꡣ�ھ���֮������1.5�ף���2.5�ף���5.5�׾�ʯһ�飬������ֱ��Ϊ0.8�׵ġ�֪��԰�����֣�ʯ��¼����ʫ����ѩ"
								+ "ѹ���ɣ�����ͦ��ֱ����֪�ɸ߽ڣ�����ѩ��ʱ����֪��ȡ���ڡ�����Ӻ������꺮Ȼ��֪�ɰ�֮���Ҳ�����������й���ͬ�������γɽ辰������Ϊ��������Ӱ����");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.zhisongyuan);
				break;
			case R.drawable.yingluoyan:
				titleText.setText("�����");
				tv_jingDianXiangQing
						.setText("		λ�ھ�������档ʼ������������һ���˹����ɵ�ʯɽ����Ȫˮ���£��׳�\"С�ٲ�\"������ˮ�����ö���"
								+ "�����ϱ߽���Сͤ����\"����\"���ٺ������鿵������\"�����\"�������¾��ſ��������\"֮ͤʤ�Զ��ܣ���֮ʤ��Ŀı�����������˹Ϊ����\"��");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.yingluoyan);
				break;
			case R.drawable.yanjinghu:
				titleText.setText("�۾���");
				tv_jingDianXiangQing
						.setText("		Ϊ�л����ʱ��������ˮ�ع��ɣ������۾�����������������ɽ��ʯ����ʯ����"
								+ "��׿��֮ˮ�γ�ˮ������������������\"����ͤ\"һ��������1992�꣬Ϊʮ�����ܣ���ʽ�ʻ���");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.yanjinghu);
				break;
			case R.drawable.qinzhengdian:
				titleText.setText("������");
				tv_jingDianXiangQing
						.setText("		������Ϊ��ʮ�˾�֮�ף�����ɽ���лʼ�԰����ɫ�ı�־�Խ�����λ�ڹ�԰�������ڣ�����Ǭ¡�ʵ���԰פ����ʱ"
								+ "�������񣬽Ӽ�������֮����ȡ�������񱾡�����˼����������ʼ������Ǭ¡ʮ�꣨1745�����侰��������ϱ�����������ɽ���ºӡ���¥��"
								+ "��ɡ��̷�ʮ�꣨1860�꣩��Ӣ�������ٻ١�2002��7����ɽ����������̶�����2003��7�¿�������ʽ�����˿��ţ��ǽ������������ȼ���"
								+ "�ߡ����彨������һ�鹬���ͽ�������Ҫ��Ŀ������ϱ�����¥�޸���������ɽʯ��·�����������1000��ƽ���ף�����ռ�����8000ƽ"
								+ "���ס���������һ�鵥��Ъɽʽ�����������ڡ������ǽ��������ʻ������չ���ݡ�����԰��������赵�����������念Ǭʢ���ʼҹ���ָ��������ٰ�"
								+ "��ɽ������԰����ʷչ��������ɽ������԰��ɳ��ͼ��������Ϊ1��600����������Ϊ��ɽ��԰�ο����ġ�");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.qinzhengdian);
				break;
			case R.drawable.xiangshansi:
				titleText.setText("��ɽ��");
				tv_jingDianXiangQing
						.setText("		������ַ����󶨶�ʮ���꣨1186������֮�������£�ԭΪ����й����ݼ���ԭ������ǰ��ʯ����ɽ�š���"
								+ "��¥����ԫ����ǽ������ӳ�ڲ��ɴ��֮�У�Ϊ��ɽ��ʮ�˾�֮һ����Ӣ�������Ͱ˹��������κƽ�֮��ֻʣ������ǰ��ʯ����ʯ����ʯ̨�׵�Ϊ������"
								+ "�ļ������»��޵�ʯͷ��Ʒ�ˡ�ʯ�������нϸߵ�������ֵ�������м��ǡ���վ�������Ϊ���ľ�������Ϊ������������������ȼ�ơ�������������ɽ"
								+ "�����к��������ɡ����������ֵ�ʯ����������Ǭ¡��ġ�������衷�������������Ϊ����ʥ���� ��һ�־������������ֲ���ľ��Ҷ�����ƣ�Ϊ��"
								+ "״��Ҷ����Ϊ�߰꣬ÿ�������¼俪������Ϊ����״Բ׶���򡣾ݷ𾭼��أ���̴�ʼ������Ĳ��������������£�Ǭ¡�ʵ�����׫д��������衱��Ҳ�̲����⡣");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.xiangshansi);
				break;
			case R.drawable.shuangqingbieshu:
				titleText.setText("˫�����");
				tv_jingDianXiangQing
						.setText("		��ɽ�¶��ϰ�ɽ���ϣ���һ�������徲��ͥԺ����˫�塣Ժ�ڶ�����Ȫ��������ˮ��Ϣ��һ������֪��婣�һ"
								+ "�����򾲴�����˼�\"˫��\"����֮Ե�ɡ�Ժ�ڳ����а˽�ͤ�������������� 1917��ӱ�ʡ��ˮ��������ϣ�����ɽ���׾֣��ڴ˽�������ʼ��˫������� 194"
								+ "9��3��25�գ�ë��ϯ�浳�����ɺӱ�ƽɽ����������ƽ��ס�ڴ˴���ֱ��11�·ݲ�Ǩ�����Ϻ����ڴ˷�����һϵ����Ҫ�ļ���");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.shuangqingbieshu);
				break;
			case R.drawable.chaoyangdong:
				titleText.setText("������");
				tv_jingDianXiangQing
						.setText("		ɭ����������һ��������������Ǭ¡�ʵ����˶������˸�ʫ�������ܼ���ʯ�̡�");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.chaoyangdong);
				break;
			case R.drawable.xishanqingxuebei:
				titleText.setText("��ɽ��ѩ��");
				tv_jingDianXiangQing
						.setText("		��ƽ̨�������ɼ���ʯ��һ��������\"��ɽ��ѩ\"��Ǭ¡ʮ���꣨1751������Ϊ�ྩ"
								+ "�˾�֮һ���ഫ������ʱ����������ɽ��ѩ����Ԫʱ��Ϊ����ɽ��ѩ������ʱ�ָĳơ���ɽ��ѩ������Ǭ¡ʱ�ָֻ�ʹ����Ԫʱ���ơ���������������"
								+ "ɽ��԰�ڰ�ɽͤ����������ɽ���Ҳࡣ ��ɽ�羰�������ơ��������ѳ�Ϊ��Ժ����֮�أ������������ɽ��Ժ�������ڽ�����ٵ�԰�֡�");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.xishanqingxuebei);
				break;
			case R.drawable.yuhuashanzhuang:
				titleText.setText("��ɽׯ");
				tv_jingDianXiangQing
						.setText("		��ɽׯλ��ɽ���в����������ɲ��ַ��������ɽׯ����ͥԺ�ͷ羰�㡣�˴����＾���ͺ�Ҷ������֮����");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.yuhuashanzhuang);
				break;
			case R.drawable.jianxinzhai:
				titleText.setText("����ի");
				tv_jingDianXiangQing
						.setText("		���������ɼ�һ��Χǽ��ǽ�ڼ�����ի��������Ωһ��һ������ϺõĹż���ʼ�������ξ�Ԫ"
								+ "�꣨1522���������Ԫ�꣨1796�����ޡ�СԺ�ڽ������ּ���������Ȥ��Ժ�ڶ���Ϊ��Բ��ˮ�ء�Ȫˮ����ͷ������ڡ��Ϲ�'����ի'�Ҷ��"
								+ "����'������'��䣬��Ϊ��Ʒ�����ض����������Ϊ֪��ͤ��Ժ�ڳ�����ӳ��������ˮ������ɽ��԰�е�԰��֮԰��");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.jianxinzhai);
				break;

			default:
				break;
			}

			break;
		case 1:
			switch (ImageId) {
			case R.drawable.enyousi:
				titleText.setText("������");
				tv_jingDianXiangQing.setText("		������λ�ڱ�����ѧ�����⣬��ɽ�Ų��С�������ɽ�Ž�����Ӻ��Ԫ��(1723)��ԭΪ"
						+"�������԰�ڵ���Ϫ���ݣ������ʵ۳������ڴˣ����������Ӻ����λ��\"Ϊʥ���ʻʵۼ��������������ڳ���԰��ԫ��\"ԭ"
						+"Ϊ����������ݸ�Ϊ�����¡��ֽ���ɽ�š�");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.enyousi);
				break;
			case R.drawable.enmusishanmen:
				titleText.setText("��Ľ��ɽ��");
				tv_jingDianXiangQing.setText("		��Ľ��ɽ�ţ��������ı���λ��λ�ں�����������ѧ�����⣬�䱱��50�״�Ϊ������ɽ�š���"
						+"����Ǭ¡��ʮ���ꡣǬ¡ʱ����̫���ھ�ס�ڳ���԰������Ǭ¡��ʮ���겡�š�Ǭ¡�ʵۡ��ѳмҷ������ڶ������Խ���Ľ�¡��ִ潨��ֻ��һ��ɽ�š�");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.enmusishanmen);
				break;
			default:
				break;
			}
			break;
			case 2:
				switch (ImageId) {
				case R.drawable.yufengta:
					titleText.setText("�����");
					tv_jingDianXiangQing.setText("		�����Ҳ�ơ��������򡰶���������λ�ڱ�����������Ȫɽ������������ڡ��������Ӱ���Ǿ���԰" 
							+"ʮ����֮һ�����������150�ף��Ǳ�������λ����ߵ�����");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.yufengta);
					break;
				default:
					break;
				}

				break;
			case 3:
				switch (ImageId) {
				case R.drawable.furongping:
					titleText.setText("ܽ��ƺ");
					tv_jingDianXiangQing.setText("		ܽ��ƺ���ڵ��ƺܸߣ�����ɽ��ѩ����ͬһ�߶ȣ�������ˬ�����ܴ�����ï��Ժ���������񣬻����ľ���");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.furongping);
					break;
				case R.drawable.zhaomiao:
					titleText.setText("����");
					tv_jingDianXiangQing.setText("		����ȫ���ھ�����֮��λ����ɽ��԰����ի���ϣ��ش���ɽ�������򶫣�ԭΪ���һʼ�֮¹԰��"
					+"��Ǭ¡��ʮ���꣨1780�꣩Ϊ�Ӵ����ذ������������������˳�֮Ϊ�����й���Ǭ¡��ʮ�������ʮ���գ��ھ�����֮���⡣���������������������ɽ����԰�������й�����Ϣ��");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.zhaomiao);
					break;
				case R.drawable.biyunsi:
					titleText.setText("������");
					tv_jingDianXiangQing.setText("		������λ�ڱ�����������ɽ��԰���࣬��ɽ�����۱�ɽ��´����һ�鲼�ֽ��ա�������õ�԰��ʽ����������Ԫ��˳���꣨1331"
							+"�꣩������������������Ժ������������ɽ�ƶ����졣������Ժ���ã�������������Ժ��Ϊ���壬�ϱ�����һ��Ժ�䣬Ժ����ø��Է�ս����ַ�������"
							+"����ɽ�������ٶ༶����ʽ���ƶ��γɵ����Ⲽ�֡�����Ժ��ɽ���𽥸���Ϊ��ʹ���岼�־�¶���ţ��ʶ�������������������ʤ�Ľ�����ʽ������"
							+"����ɽ��ǰ��һ��ʯʨ���߹����������е����ʲ����Լ����շ��ɽǽ�ϵı��ܽ�Ϊ����������Ʒ��");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.biyunsi);
					break;
				default:
					break;
				}

				break;
			case 4:
				switch (ImageId) {
				case R.drawable.xiangyanzongyinzhige:
					titleText.setText("������ӡ֮��");
					tv_jingDianXiangQing.setText("		��ʼ������Ǭ¡��䣬ϵ������ɣҮ����ʽ��������ʱ����һ��3��߸�1860��Ӣ�������ٻ��󣬹���ʮ���������ú�԰ʱ�Ľ�Ϊ��������������ϣ�����5�䡣ǰ�����ȡ�����Ъɽ��ɫ�����߶����������й������������๩��ʮ���޺����󶫡�������3��Ӳɽ�����������ϳ�����");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.xiangyanzongyinzhige);
					break;
				case R.drawable.jiayinxuan:
					titleText.setText("������");
					tv_jingDianXiangQing.setText("		ʼ����Ǭ¡��䣬�������ùŻ�������֮���������һ�������걻Ӣ�������ջ٣�һ�Ű˾����ؽ���");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.jiayinxuan);
					break;
				case R.drawable.xiequyuan:
					titleText.setText("гȤ԰");
					tv_jingDianXiangQing.setText("		гȤ԰λ���ú�԰�Ķ����ǣ�������С�����磬���ú�԰���Գ�һ�֣����С�԰��֮԰��֮�ơ�гȤ԰�й�����������������֪������Ϊ���������Žӽ�ˮ�棬���ڹ��㣬��ȡ��֪���š�");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.xiequyuan);
					break;
				case R.drawable.tiaoyuanzhai:
					titleText.setText("��Զի");
					tv_jingDianXiangQing.setText("		��Զի���׳ơ�����¥����λ�ڱ������ú�԰����ɽ���������");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.tiaoyuanzhai);
					break;
				case R.drawable.huazhongyou:
					titleText.setText("������");
					tv_jingDianXiangQing.setText("		������λ���ú�԰������ɽǰ���������������Ρ��λԸ󡢽���¥����ɽ¥����ɽ����Ƚ������˴������¶Ƚϴ󣬸�������������ˣ���ɽ���ƣ���һ�鼫����ɫ�Ľ���Ⱥ��");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.huazhongyou);
					break;
				case R.drawable.xieqiuxuan:
					titleText.setText("д����");
					tv_jingDianXiangQing.setText("		һ�������걻Ӣ�������ջ٣���������ؽ���������ɽǰɽ�����һ�齨����������麣����ڸ�̨֮�ϣ���������ɽ�����ӡ������⡱�롰Ѱ�ơ�����ͤ����������ɽ�䣬�����徻���ǹ�����ɫ�ļ���֮����");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.xieqiuxuan);
					break;
				case R.drawable.yuanlangzhai:
					titleText.setText("Բ��ի");
					tv_jingDianXiangQing.setText("		Բ��ի��λ�ڱ����ú�԰�ڵ�����ɽ������ʼ����Ǭ¡��䣬һ�������걻Ӣ�������ٻ٣�����������ޡ�");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.yuanlangzhai);
					break;
				default:
					break;
				}

				break;
			case 5:
				switch (ImageId) {
				case R.drawable.renshoudian:
					titleText.setText("���ٵ�");
					tv_jingDianXiangQing.setText("		���ٵ����԰ʱ�������ʼ������Ǭ¡ʮ���꣨1750�����̷�ʮ�꣨1860����Ӣ�������ջ٣�����ʮ���꣨1886���ؽ���ȡ������С������١�֮�⣬�������ٵ�����Ǵ����͹���ס԰�ڼ��ٳ����������ܹ��غͽӼ����ʹ�ڵĵط������ú�԰����������Ҫ������");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.renshoudian);
					break;
				case R.drawable.leshoutang:
					titleText.setText("������");
					tv_jingDianXiangQing.setText("		�����ú�԰�ڴ������޹������ã�ԭΪǬ¡ʮ����(��Ԫ1750��)ʱ�ڵ�����԰������Ҳ���ú�԰��ס�������е�������������Ǭ¡��ĸ��Тʥ�ܻʺ�Ҫ����ʮ�����գ�Ǭ¡Ϊ�˸�ĸ����ף��ʮ���٣���Ǭ¡ʮ�����ʱ��Ͱ�ԭ������ɽ���������Ը��졣��ɽ�������ڵ�����ɽ���������������ڵ����������̷�ʮ��(��Ԫ1860��)���٣��������꣨1802�����ݣ�����ʮ���꣨1891�����ޡ�");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.leshoutang);
					break;
				case R.drawable.yulantang:
					titleText.setText("������");
					tv_jingDianXiangQing.setText("		���������ú�԰�������ϡ���Ǭ¡ʮ���꣨1750�꣩����������䣨1875��1908���ؽ����ǹ����۵��޹���������ʮ���꣨1898�꣩��������ʧ�ܺ󣬴������Ľ������ڴˡ�");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.yulantang);
					break;
				case R.drawable.yunhuiguan:
					titleText.setText("��ܿ��");
					tv_jingDianXiangQing.setText("		��ܿ�����ú�԰�����ú󡣽�����Ǭ¡��䣨1736-1795��������ʱ��1875-1908�����ޡ��ǹ����۵�¡ԣ�ʺ���԰�е�ס����");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.yunhuiguan);
					break;
				case R.drawable.kunminghu:
					titleText.setText("������");
					tv_jingDianXiangQing.setText("		������λ�ڱ������ú�԰�ڣ��������ԼΪ����������ķ�֮����ԭΪ�����������ڶ�Ȫˮ��۳ɵ���Ȼ�������������������󲴺������ơ���������ǰ�����ɽ����������ɽǰ������ɽ֮����������ɽ������ɽ����ش������������ֱ����ǳ�Ϊ������");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.kunminghu);
					break;
				case R.drawable.daxilou:
					titleText.setText("��Ϸ¥");
					tv_jingDianXiangQing.setText("		��Ϸ¥�ڵº�԰�ڣ���е±���ɽׯ����������Ͻ����ڵĳ����󣬺ϳ��������Ϸ̨���º�԰��Ϸ¥��Ϊ����60�������޽���ר��������Ϸ����21�ף����ú�԰�н�������ߵķ����Ϸ¥�����㣬��̨��ױ¥���㡣���������߸����쾮�����ذ����С��ؾ�������̨�ײ���ˮ����������ء�");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.daxilou);
					break;
				case R.drawable.foxiangge:
					titleText.setText("�����");
					tv_jingDianXiangQing.setText("		��������ú�԰�����彨��������������ɽǰɽ��20�׵ķ���̨���ϣ��϶��������������ǻۺ�������Ϊ���ĵĸ�����Ⱥ�������ԳƵ�������չ�����γ���������֮�ƣ������൱��ΰ��������41�ף�8��3��4���ܣ�������8���޴�����ľ���������ṹ�൱���ӣ�Ϊ�ŵ佨����Ʒ��");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.foxiangge);
					break;
				case R.drawable.paiyundian:
					titleText.setText("���Ƶ�");
					tv_jingDianXiangQing.setText("		���Ƶ�ԭ��Ǭ¡Ϊ��ĸ��60�ٳ������Ĵ󱨶������£������ؽ���ʱ�����Ϊ���Ƶ���Ƶ�������ɽǰ���������Ĳ�λ�������ơ�����ȡ�Թ��ʫ������������ɽ����������̨�������齨�����ú�԰��Ϊ׳�۵Ľ���Ⱥ��");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.paiyundian);
					break;
				case R.drawable.zhihuihai:
					titleText.setText("�ǻۺ�");
					tv_jingDianXiangQing.setText("		�ǻۺ�������ߴ���һ������һ�������������ݺ����Ĺ�ȯ�ṹ��ɡ�");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.zhihuihai);
					break;
				case R.drawable.changlang:
					titleText.setText("����");
					tv_jingDianXiangQing.setText("		����λ������ɽ��´����������������������ɽ�����������ţ���ֹʯ��ͤ��ȫ��728�ף���273�䣬���й�԰����������ȣ�1992�걻�϶�Ϊ��������ĳ��ȣ����롰����˹�����¼�������ϵ�ÿ�������϶��вʻ棬����ͼ��14000��������ݰ���ɽˮ�羰��������桢�����ʵȡ����е����ﻭ��ȡ�����й��ŵ�������");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.changlang);
					break;
				case R.drawable.baoyunge:
					titleText.setText("���Ƹ�");
					tv_jingDianXiangQing.setText("		���Ƹ�λ�ڱ����ú�԰����ɽ����������࣬������Ǭ¡��ʮ�꣨1755�꣩���׳�ͭ���ͭͤ��");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.baoyunge);
					break;
				case R.drawable.wenchangge:
					titleText.setText("�Ĳ���");
					tv_jingDianXiangQing.setText("		�Ĳ�����һ�ִ�ͳ���뽨����Ϊ���봫˵���ƹ����˹���֮�񣬱�һ���ķ��ʢ�������Ĳ��۾��Ǻ������͵��������ƹ�ʿ�˹���»λ֮�񡣹�ʱ��Ϊ���������˹��������ޡ�");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.wenchangge);
					break;
				case R.drawable.shiqikongqiao:
					titleText.setText("ʮ�߿���");
					tv_jingDianXiangQing.setText("		ʮ�߿����������������ϣ�λ�ڶ��̺��Ϻ���֮�䣬�������ӵ̵���Ϊ԰�����ʯ�š�ʯ�ſ�8�ף���150�ף���17���Ŷ���ɡ�ʯ�����������ϵ��д�С��ͬ����̬�����ʯʨ500��ֻ��");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.shiqikongqiao);
					break;
				default:
					break;
				}
				break;
			case 6:
				switch (ImageId) {
				case R.drawable.xiyanglouyizhi:
					titleText.setText("����¥��ַ");
					tv_jingDianXiangQing.setText("		Բ��԰��ַ��԰λ�ڱ����к������в�ƫ��������ȥ��ֱ�Ŷ�ʮ����䶫�Ͻ�Ϊ�廪��ѧ���š�Բ��԰��ַ��԰Ϊ�����İ�������������ء�Բ��԰��ַ��԰������1988�꣬����ɽ��ˮϵ��԰�ָ�ֺͽ�����ַ����ɽ��ʯ����̲м���Ȼ�ɼ����ڡ�����¥����ַ����԰ʷչ���ݣ�����հ��ƾ����");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.xiyanglouyizhi);
					break;
				case R.drawable.zhengjuesi:
					titleText.setText("������");
					tv_jingDianXiangQing.setText("		���念�������ݸ�־���أ������½����ƿ�Ԫ��䣬������Ԫ�£��˴�������լ�����ھ���ͭģ���������δ��Ķ������¡���Ǭ¡��������־����Ԫ������������������顷ʫ�ơ��������Ѱգ���ĺ�ڲ��飬�Ϳ����ڵأ���ɽ�����¡�������Ȯ�ͣ��ɰ���ө�ɣ���ҹ���Ⱦ�����Ӧ���Թ顱�����ˡ�������ʼ�����ƴ�����������¡��ഫ�������ڰ���֮��������һ�������£���ģ�����侰���ֲ��ɿ������δ�ʢ����ǰ���������˶������¶���������ʫ�ġ�");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.zhengjuesi);
					break;
				case R.drawable.jianbiting:
					titleText.setText("����ͤ");
					tv_jingDianXiangQing.setText("		ԭ����1811�꣨����ʮ���꣩ǰ��粴�԰�����ڣ��̺�֮�У���ͤ�߳���Ϊ�۾��Ѵ���");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.jianbiting);
					break;
				case R.drawable.shicanqiao:
					titleText.setText("ʯ����");
					tv_jingDianXiangQing.setText("		Բ��԰ʢʱ���н�200��������ʽ�͹���ש��ʯ��ľ�ṹ��԰��������Բ��԰ٲ����������󣬽��д���������ʯ���š�");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.shicanqiao);
					break;
				case R.drawable.qichunyuan:
					titleText.setText("粴�԰");
					tv_jingDianXiangQing.setText("		粴�԰��԰��Ǭ¡ʱ�ڣ���ȻǬ¡�ʵ��������ֽ�����粴�԰����ҪӪ������ȴ���ڼ���ʵ�������ɵġ�����ʵ�����Ч�����ĸ��ʣ���粴�԰����Ϊ��粴�԰��ʮ��������������粴�԰��ʮ����Զû�С�Բ��԰��ʮ����������ͷ����������;����������������Ժ�粴�԰����Ҫ��Ϊ�˴����̫��̫���ǵ�԰��֮�ء�");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.qichunyuan);
					break;
				default:
					break;
				}

				break;
			case 7:
				switch (ImageId) {
				case R.drawable.yuquanshanjingdian:
					titleText.setText("��Ȫɽ");
					tv_jingDianXiangQing.setText("		��Ȫɽλ���ú�԰�������������������׺�������ϱ�����Ȫɽ������ɽ��´��֧�����ڡ�ɽ֮����������ͻ���ĵط��ǡ����������������ۣ�ɳ��ʯ϶����ؽ�Ȫ��");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.yuquanshanjingdian);
					break;
				
				default:
					break;
				}

				break;
			default:
				break;
			}
		

		}
	}

