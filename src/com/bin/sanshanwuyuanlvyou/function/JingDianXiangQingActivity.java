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
				titleText.setText("重阳阁");
				tv_jingDianXiangQing
						.setText("		香炉峰顶的一组建筑，意在九九重阳登高瞩望京城，建于1983年4月，分为上、下两层。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.chongyangge);
				break;
			case R.drawable.sunzhongshanjiniantang:
				titleText.setText("孙中山纪念堂");
				tv_jingDianXiangQing
						.setText("		这座殿堂原为普明妙觉殿。1925年3月12日，孙中山先生在北京逝世，"
								+ "他的灵柩曾停放在碧云寺最高处的金刚宝座塔内，1929年，中山先生的灵柩前往南京紫金山时，曾在此殿设灵堂，"
								+ "举行了隆重的公祭和哀悼，殿内存有中山先生的衣冠，即为中山先生的衣冠冢，殿前左方，立有国民革命军第四集团军"
								+ "总指挥的纪念碑。之后，这里辟为“孙中山纪念堂”，供人们瞻仰。悬挂在门楣上的匾额是由宋庆龄亲笔所书的“孙中山纪念堂”六个大字。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.sunzhongshanjiniantang);
				break;
			case R.drawable.zhisongyuan:
				titleText.setText("知松园");
				tv_jingDianXiangQing
						.setText("		位于南北主要游览干道西侧，占地2公顷，是1987年新辟建的景区。景区内一、二"
								+ "级古松柏100余株。在景区之东立宽1.5米，长2.5米，高5.5米巨石一块，正面书直径为0.8米的“知松园”三字，石背录陈毅诗“大雪"
								+ "压青松，青松挺且直，欲知松高节，待到雪化时”。知松取意于《论语·子罕》“岁寒然后知松柏之后凋也”。景区内有古松同琉璃塔形成借景，命名为“琼松塔影”。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.zhisongyuan);
				break;
			case R.drawable.yingluoyan:
				titleText.setText("璎珞岩");
				tv_jingDianXiangQing
						.setText("		位于静翠湖南面。始建于明代，是一处人工叠成的石山，有泉水流下，俗称\"小瀑布\"，淙淙水声，悦耳动"
								+ "听，上边建有小亭匾书\"清音\"，再后敞厅匾书康熙题名\"绿筠深处\"。《日下旧闻考》称这里：\"亭之胜以耳受，岩之胜以目谋，澡濯神明，斯为最矣\"。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.yingluoyan);
				break;
			case R.drawable.yanjinghu:
				titleText.setText("眼镜湖");
				tv_jingDianXiangQing
						.setText("		为中华民国时建。由两水池构成，形如眼镜，故名。湖北侧依山叠石砌成石洞，"
								+ "引卓锡之水形成水帘洞景区。湖东南有\"佳日亭\"一座，建于1992年，为十字重檐，苏式彩画。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.yanjinghu);
				break;
			case R.drawable.qinzhengdian:
				titleText.setText("勤政殿");
				tv_jingDianXiangQing
						.setText("		勤政殿为二十八景之首，是香山具有皇家园林特色的标志性建筑，位于公园东宫门内，它是乾隆皇帝来园驻跸临时"
								+ "处理政务，接见王公大臣之所，取意勤政务本、勤于思政。勤政殿始建于清乾隆十年（1745），其景区由正殿、南北配殿、朝房、假山、月河、牌楼等"
								+ "组成。咸丰十年（1860年）被英法联军焚毁。2002年7月香山勤政殿复建工程动工至2003年7月竣工并正式对游人开放，是建国以来复建等级最"
								+ "高、单体建筑最大的一组宫殿型建筑。主要项目有正殿、南北配殿及牌楼修复及景区内山石道路整理，建筑面积1000多平方米，景区占地面积8000平"
								+ "方米。勤政殿是一组单檐歇山式建筑，正殿内、外檐是金龙和玺彩画，正殿布展依据“静宜园勤政殿陈设档案”，参照清康乾盛世皇家宫殿恢复。南配殿举办"
								+ "香山（静宜园）历史展，配有香山（静宜园）沙盘图（比例尺为1：600），北配殿开辟为香山公园游客中心。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.qinzhengdian);
				break;
			case R.drawable.xiangshansi:
				titleText.setText("香山寺");
				tv_jingDianXiangQing
						.setText("		该寺遗址即金大定二十六年（1186）所建之大永安寺，原为金代行宫。据记载原有五层大殿，前有石坊、山门、钟"
								+ "鼓楼、城垣、红墙碧瓦掩映在苍松翠柏之中，为香山二十八景之一。经英法联军和八国联军二次浩劫之后，只剩下正殿前的石屏。石碑和石台阶等为数不多"
								+ "的几件不怕火燹的石头制品了。石屏本身有较高的艺术价值，正面中间是《金刚经》，左为《心经》，右为《观音经》，背面是燃灯、观音、普贤像。山"
								+ "门内有汉、满、蒙、藏四种文字的石碑，内容是乾隆书的《娑罗树歌》。娑罗树，被视为佛门圣树， 是一种具有特殊意义的植物，乔木，叶如手掌，为掌"
								+ "状复叶，多为七瓣，每年五六月间开花，花为宝塔状圆锥花序。据佛经记载，佛教创始人释迦牟尼涅槃于娑罗树下，乾隆皇帝亲自撰写“娑罗树歌”，也蕴藏深意。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.xiangshansi);
				break;
			case R.drawable.shuangqingbieshu:
				titleText.setText("双清别墅");
				tv_jingDianXiangQing
						.setText("		香山寺东南半山坡上，有一处别致清静的庭院，即双清。院内二道清泉，常年流水不息，一股流向知乐濠，一"
								+ "股流向静翠湖，此即\"双清\"二字之缘由。院内池旁有八角亭及参天银杏树。 1917年河北省大水，督办熊希龄办香山慈幼局，在此建别墅，始称双清别墅。 194"
								+ "9年3月25日，毛主席随党中央由河北平山县西柏坡来平，住在此处，直到11月份才迁居中南海。在此发表了一系列重要文件。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.shuangqingbieshu);
				break;
			case R.drawable.chaoyangdong:
				titleText.setText("朝阳洞");
				tv_jingDianXiangQing
						.setText("		森玉笏西北有一洞，名朝阳洞。乾隆皇帝来此洞曾即兴赋诗。现仍能见到石刻。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.chaoyangdong);
				break;
			case R.drawable.xishanqingxuebei:
				titleText.setText("西山晴雪碑");
				tv_jingDianXiangQing
						.setText("		从平台北望即可见到石碑一座，上书\"西山晴雪\"，乾隆十六年（1751）立。为燕京"
								+ "八景之一。相传金明昌时，初名“西山积雪”。元时改为“西山晴雪”。明时又改称“西山霁雪”。清乾隆时又恢复使用了元时名称。景碑现仍立于香"
								+ "山公园内半山亭北、朝阳洞山道右侧。 西山风景优美，唐、宋以来已成为寺院荟萃之地，金代有名的西山八院，就是在金代开辟的园林。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.xishanqingxuebei);
				break;
			case R.drawable.yuhuashanzhuang:
				titleText.setText("玉华山庄");
				tv_jingDianXiangQing
						.setText("		玉华山庄位于山脉中部，在明清古刹遗址上所建的山庄，是庭院型风景点。此处是秋季观赏红叶的理想之处。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.yuhuashanzhuang);
				break;
			case R.drawable.jianxinzhai:
				titleText.setText("见心斋");
				tv_jingDianXiangQing
						.setText("		昭庙往北可见一道围墙，墙内即见心斋。这里是惟一的一处保存较好的古迹。始建于明嘉靖元"
								+ "年（1522），清嘉庆元年（1796）重修。小院内建筑布局极富江南情趣。院内东侧为半圆形水池。泉水由龙头吐入池内。上挂'见心斋'匾额。轩"
								+ "后有'正凝堂'五间，现为售品部。池东与轩相对者为知鱼亭。院内池轩相映，回廊临水，是香山公园中的园中之园。");
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
				titleText.setText("恩佑寺");
				tv_jingDianXiangQing.setText("		恩佑寺位于北京大学西门外，两山门并列。恩佑寺山门建于清雍正元年(1723)。原为"
						+"清初畅春园内的清溪书屋，康熙皇帝常宴寝于此，后死在这里。雍正即位后，\"为圣祖仁皇帝荐福，建恩佑寺于畅春园东垣。\"原"
						+"为三进殿，将书屋改为恩佑寺。现仅存山门。");
				image_jingDianXiangQing
						.setBackgroundResource(R.drawable.enyousi);
				break;
			case R.drawable.enmusishanmen:
				titleText.setText("恩慕寺山门");
				tv_jingDianXiangQing.setText("		恩慕寺山门，属区级文保单位，位于海淀区北京大学西门外，其北侧50米处为恩佑寺山门。建"
						+"于清乾隆四十二年。乾隆时，皇太后长期居住于畅春园，后于乾隆四十二年病逝。乾隆皇帝“昭承家法”，在恩佑寺旁建恩慕寺。现存建筑只有一座山门。");
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
					titleText.setText("玉峰塔");
					tv_jingDianXiangQing.setText("		玉峰塔也称“大塔”或“定光塔”，位于北京西北的玉泉山主峰上香积寺内。“玉峰塔影”是静明园" 
							+"十六景之一，塔顶距地面150米，是北京地理位置最高的塔。");
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
					titleText.setText("芙蓉坪");
					tv_jingDianXiangQing.setText("		芙蓉坪所在地势很高，与西山晴雪处于同一高度，暑天凉爽，四周丛林密茂，院内种有青竹，环境幽静。");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.furongping);
					break;
				case R.drawable.zhaomiao:
					titleText.setText("昭庙");
					tv_jingDianXiangQing.setText("		昭庙全称宗镜大昭之庙，位于香山公园见心斋以南，地处半山，坐西向东；原为清室皇家之鹿园。"
					+"清乾隆四十五年（1780年）为接待西藏班禅来京而建，故世人称之为班禅行宫。乾隆四十五年九月十九日，宗镜大昭之庙开光。六世班禅额尔德尼来到香山静宜园，在其行宫内休息。");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.zhaomiao);
					break;
				case R.drawable.biyunsi:
					titleText.setText("碧云寺");
					tv_jingDianXiangQing.setText("		碧云寺位于北京海淀区香山公园北侧，西山余脉聚宝山东麓，是一组布局紧凑、保存完好的园林式寺庙。创建于元至顺二年（1331"
							+"年），后经明、清扩建。寺院坐西朝东，依山势而建造。整个寺院布置，以排列在六进院落为主体，南北各配一组院落，院落采用各自封闭建筑手法，层层殿"
							+"堂依山叠起，三百多级阶梯式地势而形成的特殊布局。因寺院依山势逐渐高起，为不使总体布局景露无遗，故而采用迥旋串连引人入胜的建造形式。其中"
							+"立于山门前的一对石狮、哼哈二将，殿中的泥质彩塑以及弥勒佛殿山墙上的壁塑皆为明代艺术珍品。");
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
					titleText.setText("香岩宗印之阁");
					tv_jingDianXiangQing.setText("		它始建于清乾隆年间，系仿西藏桑耶寺形式而建。当时它是一座3层高阁，1860年英法联军毁坏后，光绪十四年重修颐和园时改建为单层佛殿。殿坐北朝南，面阔5间。前后有廊。正脊歇山黄色琉璃瓦顶。殿内正中供奉三世佛，两侧供奉十八罗汉。阁东、西各有3间硬山顶建筑，坐南朝北。");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.xiangyanzongyinzhige);
					break;
				case R.drawable.jiayinxuan:
					titleText.setText("嘉荫轩");
					tv_jingDianXiangQing.setText("		始建于乾隆年间，因建于两棵古槐的绿荫之间而得名，一八六〇年被英法联军烧毁，一九八九年重建。");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.jiayinxuan);
					break;
				case R.drawable.xiequyuan:
					titleText.setText("谐趣园");
					tv_jingDianXiangQing.setText("		谐趣园位于颐和园的东北角，由于它小巧玲珑，在颐和园中自成一局，故有“园中之园”之称。谐趣园中共有桥五座，其中以知鱼桥最为著名。该桥接近水面，便于观鱼，故取名知鱼桥。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.xiequyuan);
					break;
				case R.drawable.tiaoyuanzhai:
					titleText.setText("眺远斋");
					tv_jingDianXiangQing.setText("		眺远斋，俗称“看会楼”，位于北京市颐和园万寿山后湖景区。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.tiaoyuanzhai);
					break;
				case R.drawable.huazhongyou:
					titleText.setText("画中游");
					tv_jingDianXiangQing.setText("		画中游位于颐和园的万寿山前西部，包括画中游、澄辉阁、借秋楼、爱山楼、湖山真意等建筑。此处地势坡度较大，各个建筑因地制宜，随山就势，是一组极具特色的建筑群。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.huazhongyou);
					break;
				case R.drawable.xieqiuxuan:
					titleText.setText("写秋轩");
					tv_jingDianXiangQing.setText("		一八六〇年被英法联军烧毁，光绪年间重建，是万寿山前山东侧的一组建筑。正殿三楹，建于高台之上，两侧以爬山廊连接“观生意”与“寻云”两配亭。此轩隐于山间，幽雅清净，是观赏秋色的极佳之处。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.xieqiuxuan);
					break;
				case R.drawable.yuanlangzhai:
					titleText.setText("圆朗斋");
					tv_jingDianXiangQing.setText("		圆朗斋，位于北京颐和园内的万寿山景区，始建于乾隆年间，一八六〇年被英法联军焚毁，光绪年间重修。");
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
					titleText.setText("仁寿殿");
					tv_jingDianXiangQing.setText("		仁寿殿，清漪园时名勤政殿，始建于清乾隆十五年（1750），咸丰十年（1860）被英法联军烧毁，光绪十二年（1886）重建，取《论语》中“仁者寿”之意，改名仁寿殿。这里是慈禧和光绪住园期间临朝理政，接受恭贺和接见外国使节的地方，是颐和园听政区的主要建筑。");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.renshoudian);
					break;
				case R.drawable.leshoutang:
					titleText.setText("乐寿堂");
					tv_jingDianXiangQing.setText("		北京颐和园内慈禧的寝宫乐寿堂，原为乾隆十五年(公元1750年)时期的清漪园建筑，也是颐和园居住生活区中的主建筑。本是乾隆的母亲孝圣宪皇后要过六十岁生日，乾隆为了给母亲庆祝六十大寿，在乾隆十四年的时候就把原来的瓮山和西湖加以改造。瓮山就是现在的万寿山，而西湖就是现在的昆明湖。咸丰十年(公元1860年)被毁，嘉庆七年（1802）修葺，光绪十七年（1891）重修。");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.leshoutang);
					break;
				case R.drawable.yulantang:
					titleText.setText("玉澜堂");
					tv_jingDianXiangQing.setText("		玉澜堂在颐和园昆明湖畔。清乾隆十五年（1750年）建，光绪年间（1875－1908）重建。是光绪帝的寝宫。光绪二十四年（1898年）戊戌政变失败后，慈禧曾幽禁光绪于此。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.yulantang);
					break;
				case R.drawable.yunhuiguan:
					titleText.setText("宜芸馆");
					tv_jingDianXiangQing.setText("		宜芸馆在颐和园玉澜堂后。建于清乾隆年间（1736-1795），光绪时（1875-1908）重修。是光绪帝的隆裕皇后在园中的住处。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.yunhuiguan);
					break;
				case R.drawable.kunminghu:
					titleText.setText("昆明湖");
					tv_jingDianXiangQing.setText("		昆明湖位于北京的颐和园内，它的面积约为总体面积的四分之三。原为北京西北郊众多泉水汇聚成的天然湖泊，曾有七里泺、大泊湖等名称。昆明湖的前身叫瓮山泊，因万寿山前身有瓮山之名而得名瓮山泊。瓮山泊因地处北京西郊，又被人们称为西湖。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.kunminghu);
					break;
				case R.drawable.daxilou:
					titleText.setText("大戏楼");
					tv_jingDianXiangQing.setText("		大戏楼在德和园内，与承德避暑山庄里的清音阁、紫禁城内的畅音阁，合称清代三大戏台。德和园大戏楼是为慈禧60岁生日修建，专供慈禧看戏。高21米，在颐和园中仅次于最高的佛香阁。戏楼共三层，后台化妆楼二层。顶板上有七个“天井”，地板中有“地井”。舞台底部有水井和五个方池。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.daxilou);
					break;
				case R.drawable.foxiangge:
					titleText.setText("佛香阁");
					tv_jingDianXiangQing.setText("		佛香阁是颐和园的主体建筑，建筑在万寿山前山高20米的方形台基上，南对昆明湖，背靠智慧海，以它为中心的各建筑群严整而对称地向两翼展开，形成众星捧月之势，气派相当宏伟。佛香阁高41米，8面3层4重檐，阁内有8根巨大铁梨木擎天柱，结构相当复杂，为古典建筑精品。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.foxiangge);
					break;
				case R.drawable.paiyundian:
					titleText.setText("排云殿");
					tv_jingDianXiangQing.setText("		排云殿原是乾隆为其母后60寿辰而建的大报恩延寿寺，慈禧重建的时候更名为排云殿，排云殿在万寿山前建筑的中心部位，“排云”二字取自郭璞诗：“神仙排云山，但见金银台”。这组建筑是颐和园最为壮观的建筑群。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.paiyundian);
					break;
				case R.drawable.zhihuihai:
					titleText.setText("智慧海");
					tv_jingDianXiangQing.setText("		智慧海，是最高处的一座，是一座的无梁佛殿，由纵横相间的拱券结构组成。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.zhihuihai);
					break;
				case R.drawable.changlang:
					titleText.setText("长廊");
					tv_jingDianXiangQing.setText("		长廊位于万寿山南麓，面向昆明湖，北依万寿山，东起邀月门，西止石丈亭，全长728米，共273间，是中国园林中最长的游廊，1992年被认定为世界上最长的长廊，列入“吉尼斯世界纪录”。廊上的每根枋梁上都有彩绘，共有图画14000余幅，内容包括山水风景、花鸟鱼虫、人物典故等。画中的人物画均取材于中国古典名著。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.changlang);
					break;
				case R.drawable.baoyunge:
					titleText.setText("宝云阁");
					tv_jingDianXiangQing.setText("		宝云阁位于北京颐和园万寿山佛香阁景区西侧，建于清乾隆二十年（1755年），俗称铜殿或铜亭。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.baoyunge);
					break;
				case R.drawable.wenchangge:
					titleText.setText("文昌阁");
					tv_jingDianXiangQing.setText("		文昌阁是一种传统祭祀建筑，为祭祀传说中掌管文运功名之神，保一方文风昌盛而建。文昌帝君是汉族民间和道教尊奉的掌管士人功名禄位之神。古时认为是主持文运功名的星宿。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.wenchangge);
					break;
				case R.drawable.shiqikongqiao:
					titleText.setText("十七孔桥");
					tv_jingDianXiangQing.setText("		十七孔桥坐落在昆明湖上，位于东堤和南湖岛之间，用以连接堤岛，为园中最大石桥。石桥宽8米，长150米，由17个桥洞组成。石桥两边栏杆上雕有大小不同、形态各异的石狮500多只。");
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
					titleText.setText("西洋楼遗址");
					tv_jingDianXiangQing.setText("		圆明园遗址公园位于北京市海淀区中部偏东，西北去西直门二十华里。其东南角为清华大学西门。圆明园遗址公园为著名的爱国主义教育基地。圆明园遗址公园建成于1988年，仅存山形水系、园林格局和建筑基址，假山叠石、雕刻残迹仍然可见。在“西洋楼”旧址建有园史展览馆，供人瞻仰凭吊。");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.xiyanglouyizhi);
					break;
				case R.drawable.zhengjuesi:
					titleText.setText("正觉寺");
					tv_jingDianXiangQing.setText("		据清康熙《常州府志》载，正觉寺建于唐开元年间，初名开元寺，乃大夫李遵旧宅，寺内旧有铜模唐明皇像。宋代改额正觉寺。清乾隆《阳湖县志》记元人萨天锡《正觉寺晚归》诗云“粥鱼声已罢，日暮掩柴扉，送客月在地，出山云满衣。灯明闻犬吠，松暗见萤飞，深夜长廊静，多应独自归”，即此。正觉寺始建于唐代，初名妙觉寺。相传是有南宗八祖之尊的马祖道一开基立寺，规模不大，其景观现不可考，到宋代盛况空前，历代文人对正觉寺都留有赞誉诗文。");
					image_jingDianXiangQing
							.setBackgroundResource(R.drawable.zhengjuesi);
					break;
				case R.drawable.jianbiting:
					titleText.setText("鉴碧亭");
					tv_jingDianXiangQing.setText("		原建于1811年（嘉庆十六年）前后，绮春园宫门内，碧湖之中，方亭高敞，为观景佳处。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.jianbiting);
					break;
				case R.drawable.shicanqiao:
					titleText.setText("石残桥");
					tv_jingDianXiangQing.setText("		圆明园盛时共有近200座各种样式和规格的砖、石、木结构的园林桥梁。圆明园罹劫并经百年风雨后，仅残存这座单孔石拱桥。");
					image_jingDianXiangQing
					.setBackgroundResource(R.drawable.shicanqiao);
					break;
				case R.drawable.qichunyuan:
					titleText.setText("绮春园");
					tv_jingDianXiangQing.setText("		绮春园成园于乾隆时期，虽然乾隆皇帝最早着手建它，绮春园的主要营建工作却是在嘉庆皇帝手里完成的。嘉庆皇帝曾经效仿他的父皇，把绮春园归纳为“绮春园三十景”。不过，“绮春园三十景”远没有“圆明园四十景”那样名头响亮。从用途上来看，道光初年以后，绮春园便主要成为了大清国太后太妃们的园居之地。");
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
					titleText.setText("玉泉山");
					tv_jingDianXiangQing.setText("		玉泉山位于颐和园西，五六里。这座六峰连缀、逶迤南北的玉泉山，是西山东麓的支脉，在“山之阳”，它最突出的地方是“土纹隐起，作苍龙鳞，沙痕石隙，随地皆泉。");
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

