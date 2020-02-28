/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.27 : Database - weblog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`weblog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `weblog`;

/*Table structure for table `adminuser` */

DROP TABLE IF EXISTS `adminuser`;

CREATE TABLE `adminuser` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_name` varchar(36) NOT NULL,
  `a_pass` blob NOT NULL,
  `a_nickname` varchar(36) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_used` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `adminuser` */

insert  into `adminuser`(`a_id`,`a_name`,`a_pass`,`a_nickname`,`createtime`,`is_used`) values (9,'adminuser','Z�:�_\Z��B��G��	Y�Yh�#��w','李卓恒','2019-07-04 00:53:50',1),(11,'jpdark','\"����{Z=8��t���\'��0*p��M��V�','张佳沛','2019-07-08 00:04:33',1);

/*Table structure for table `albums` */

DROP TABLE IF EXISTS `albums`;

CREATE TABLE `albums` (
  `al_id` int(11) NOT NULL AUTO_INCREMENT,
  `al_name` varchar(45) NOT NULL,
  `al_author` int(11) NOT NULL,
  `al_liulang` int(20) DEFAULT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_used` tinyint(1) NOT NULL DEFAULT '1',
  `al_url` varchar(60) DEFAULT 'notphoto.png',
  PRIMARY KEY (`al_id`),
  KEY `al_author_idx` (`al_author`),
  CONSTRAINT `al_author` FOREIGN KEY (`al_author`) REFERENCES `adminuser` (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `albums` */

insert  into `albums`(`al_id`,`al_name`,`al_author`,`al_liulang`,`createtime`,`is_used`,`al_url`) values (15,'海景',9,2,'2019-07-04 02:26:58',1,'2f7daf40-b533-4b00-8d64-c635759a4d73.jpg'),(16,'科贸景色',9,NULL,'2019-07-04 03:01:34',1,'5f4b9695-b0b3-4c6b-b8f1-0e4724b93050.jpg'),(17,'萌宠',9,NULL,'2019-07-04 03:03:09',1,'56c9c688-a60f-4089-b23f-baca8e17b6bf.jpg'),(18,'天空奇象',9,NULL,'2019-07-04 03:04:52',1,'35a05f0a-f307-4d48-80cc-98d4f00f6ebf.jpg'),(19,'天气不错',9,NULL,'2019-07-08 10:13:55',1,'42b96d4a-017f-42f5-9fc6-2c197d20d1f3.jpg'),(20,'小猫',9,NULL,'2019-07-08 10:15:11',1,'24a7bd2f-f0b1-40ba-9b8c-5be740b67237.jpg'),(21,'小狗',9,NULL,'2019-07-08 10:15:32',1,'9da0198d-cb4f-4444-8b70-b66a39f48834.jpg'),(22,'落日',9,NULL,'2019-07-08 10:16:17',1,'06490380-7a08-4888-9934-07f9ffe74333.jpg'),(23,'Q.Q',9,NULL,'2019-07-08 10:16:41',1,'0236a8fd-718e-495b-b9c7-1a821d4e5fe4.jpg'),(24,'gy',11,NULL,'2019-07-08 14:50:01',1,'2bef23bc-097b-400b-8ae6-c22b5f8a84cc.jpg');

/*Table structure for table `dianzan` */

DROP TABLE IF EXISTS `dianzan`;

CREATE TABLE `dianzan` (
  `dz_id` int(11) NOT NULL AUTO_INCREMENT,
  `dz_album` int(11) NOT NULL,
  `dz_user` int(11) NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_used` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`dz_id`),
  KEY `dz_photo_idx` (`dz_album`),
  KEY `dz_user_idx` (`dz_user`),
  CONSTRAINT `dz_album` FOREIGN KEY (`dz_album`) REFERENCES `albums` (`al_id`),
  CONSTRAINT `dz_user` FOREIGN KEY (`dz_user`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `dianzan` */

insert  into `dianzan`(`dz_id`,`dz_album`,`dz_user`,`createtime`,`is_used`) values (13,15,15,'2019-07-05 21:09:59',1),(14,16,15,'2019-07-05 14:08:41',1),(15,17,15,'2019-07-05 14:08:43',1),(16,17,16,'2019-07-08 14:42:52',1),(17,16,16,'2019-07-07 23:28:09',0),(18,15,16,'2019-07-08 14:05:25',1);

/*Table structure for table `dongtai` */

DROP TABLE IF EXISTS `dongtai`;

CREATE TABLE `dongtai` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT,
  `d_title` varchar(100) NOT NULL,
  `d_content` text,
  `d_author` int(11) NOT NULL,
  `d_liulang` int(20) DEFAULT '0',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_used` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`d_id`),
  KEY `d_author_idx` (`d_author`),
  CONSTRAINT `d_author` FOREIGN KEY (`d_author`) REFERENCES `adminuser` (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `dongtai` */

insert  into `dongtai`(`d_id`,`d_title`,`d_content`,`d_author`,`d_liulang`,`createtime`,`is_used`) values (10,'记录第一次登陆自己的博客','         人生都是从无数个第一次开始的，也是由第一次开始成长进步的。\r\n         博客是一个可以让说出自己不满心情的地方，也是一个可以让人保留一天看到的风景的地方，它还是一个让人们互动的好地方。\r\n         当我们心情不满时，我们到了这里；当我们看到好的风景，诱人的美食时，拍下来想要一直保留时，我们来到了这里；当我们想听听别人的建议以及看法时，想要有个互动的人的时候，我们还是来到了这里。\r\n          \r\n          这是我第一次登陆属于我自己的博客，我相信会越来越好的，记录发布的第一篇文章。谢谢各位。\r\n',9,15,'2019-07-04 02:19:16',1),(11,'蜗牛的励志故事-自己保护自己','今天我给大家分享一篇我最近很喜欢的故事\r\n\r\n如果你不是咬着金钥匙出生，那么就请像蜗牛一样，自己保护自己，自己创造梦想吧。\r\n\r\n　　小蜗牛问妈妈：为什么我们从生下来，就要背负这个又硬又重的壳呢?\r\n　　妈妈：因为我们的身体没有骨骼的支撑，只能爬，又爬不快。所以要这个壳的保护!\r\n　　小蜗牛：毛虫姊姊没有骨头，也爬不快，为什么她却不用背这个又硬又重的壳呢?\r\n　　妈妈：因为毛虫姊姊能变成蝴蝶，天空会保护她啊。\r\n　　小蜗牛：可是蚯蚓弟弟也没骨头爬不快，也不会变成蝴蝶他什么不背这个又硬又重的壳呢?\r\n　　妈妈：因为蚯蚓弟弟会钻土,大地会保护他啊。\r\n　　小蜗牛哭了起来：我们好可怜，天空不保护，大地也不保护。\r\n　　蜗牛妈妈安慰他：所以我们有壳啊!  我们不上天，也不下地，我们保护自己。',9,3,'2019-07-04 02:20:40',1),(12,'故事还长，请别失望','今天给大家分享一篇短文。\r\n时光无情，岁月苍凉，一路走来，难免悲伤!但无论怎样，都要坚强，因为前路还长，你总会看到曙光。人生无常，聚散难料，但无论如何，只要活着，就还有希望。不管今天身在何处，无论明天路往何方，只要生活还在继续，就别急着失望。\r\n成长的路上，我们总会有太多的迷惑和茫然，很多时候，我们都看不清楚方向，无论前进或是后退都是一片虚无缥缈。这样的状态，我们称之为迷茫，每个人都会经历迷茫，不是我们不够聪明，而是我们缺少应对的智慧。\r\n曾经说过多少次，再也不爱了，可后来还是爱了，或许人生就是这样吧!当初以为已经失去的东西，如今想来却又不曾失去过，当初以为拥有的东西，如今回首，却又仿佛未曾拥有。我们都在太早的年纪里，给未来下了太早的结论。',9,5,'2019-07-04 02:25:51',1),(13,'今年非常赞的一篇毕业致辞：像弱者一样感受世界','毕业季的到来，让每个人更加忙碌，校长们也不例外，分享我今天喜欢的这篇文章\r\n6月23日，中国农业大学人文与发展学院2019届毕业典礼举行。\r\n叶敬忠院长的致辞，充满浪漫的情怀和朴素的思想，希望毕业生能够保持纯真与真实，能够时刻深入自己的内心，倾听良知发出的声音！“长长的路，慢慢地走；深深的话，浅浅地说。”整篇致辞，非常精彩，值得细细品读。\r\n各位同学：\r\n大家好！\r\n祝贺大家顺利毕业，即将奔赴新的岗位！此时此刻，我不想对大家的本科或研究生期间的学习和生活进行总结，因为最好的总结需要留给你们自己去做。\r\n\r\n在大家进入人文与发展学院时，我都会向大家介绍人文与发展学院的理念和理想。尤其会强调，大学应该给学生提供的不仅是知识，更重要的是思想。我认为，在知识与思想之间，知识是物质的，思想是观念的；知识是经验的，思想是哲学的；知识是功用的，思想是自由的。大学学习并非仅仅是为了学习知识来改变命运，而更是为了获得思想来追求自由。在人文与发展学院希望传递的思想中，一个重要的关切视角便是普通人。\r\n\r\n在人文与发展学院的5分钟宣传片《他们》中，全片仅有三句话——看见他们，走近他们，讲述他们。我们希望呈现的是：在大发展时代，人们看到的常常是高楼大厦、高铁高速……而看不到大发展背后的数以亿计的普通人。人文与发展学院就是要看见这些普通人，通过教育教学、学术研究、社会行动走近这些普通人；通过论文著作、社会讨论、政策倡导等讲述这些普通人。\r\n\r\n在大家毕业之际，我想再次提示大家，在未来的工作和生活中，要关注我们社会中的普通人，尤其是，普通人中的弱者。\r\n\r\n\r\n\r\n\r\n',9,3,'2019-07-04 02:32:53',1),(14,' 27年后，我们忘不了你的名字','今天我分享一位伟大事迹老人的故事。\r\n1992年6月28日，被誉为“中国原子弹之父”的著名科学家钱三强在北京逝世享年79岁\r\n钱三强，原名钱秉穹，原籍浙江湖州，生于浙江绍兴，他是中国原子能科学事业的创始人；中国“两弹一星”元勋；中国科学院院士\r\n1936年，从清华大学物理系毕业后，23岁的钱三强赴法国进修镭学，他同居里夫人的女儿和女婿，约里奥－居里夫妇共同奋斗，拍出世界第一张核裂变碎片的照片\r\n他和夫人何泽慧，发现了三分裂现象和四分裂现象，被约里奥 - 居里夫妇称作；第二次世界大战以后，该实验室第一个最重要的工作，钱三强是他们指导下的一代科学人员中最优秀者\r\n1948年，钱三强放弃法国的优渥生活，选择回到祖国，参与筹建中科院及学部，领导建立我国原子能研究基地，聚集和培养了大批科学技术人才为中国第一颗原子弹和氢弹的研制，作出了突出贡献\r\n1954年，钱三强被批准加入中国共产党\r\n1982年11月29日，出席五届全国人大五次会议的天津代表团分组审议宪法修改草案。\r\n历经沧桑，饱受坎坷，钱三强不追名、不逐利，始终如一地奉献着自己的全部才智\r\n钱三强对自己要求非常严格，从不向组织提任何要求，完全过着普通人的生活 ，有同志上钱三强家慰问时，不约而同地惊呆了\r\n屋内的陈设陈旧，房间里除了书就是资料，老式沙发坐下去都能感到弹簧的破损，旧藤椅腿上还缠着密密麻麻的布条\r\n国家几次催他乔迁新居，可他一直住在中关村的“老家”，理由很简单、很自然，住惯了，有感情，而且离图书馆近，查阅图书、资料很方便\r\n钱三强的女儿钱民协说，在我们眼里，父亲是个真性情的人，他有思想不盲从，是一个纯粹的科学工作者，他很自信，心里有底气，追求科学真理，敢说话，他的一生，为世界和中国科学技术事业，留下宝贵的业绩，作为他的后代我们将把他的业绩和精神传承下去\r\n今天，让我们一起追思这位科学泰斗，重温科学家峥嵘岁月，激励我辈爱国奋进。\r\n',9,5,'2019-07-04 02:33:41',1),(15,'有些路啊，我们终究要学会一个人去走','这是一个朋友的故事\r\n　　有些路，终究是要一个人走。哪怕前路漫漫布满荆棘，只要勇敢闯过去，你经历的所有艰辛，会有一天都能笑着说出来。\r\n　　二十几岁是人生的一道坎儿。有的人年轻时怕吃苦，碌碌无为一辈子；有的人20岁的时候就知道自己想要什么，10年后打造了属于自己的一片天。\r\n　　曾听过这么一句话：每一个强大的人，可能都曾咬牙度过一段没人帮忙、没人支持、没人嘘寒问暖的日子。过去了，这就是你的成人礼；过不去，求饶了，这就是你的无底洞。\r\n　　一位好友曾向我抱怨，她在工作上经常受委屈，做事情常常不被理解，偶尔还会莫名其妙地被同事或朋友孤立，生活中的困难只能一个人扛……“好像越长大越不开心了。”她说。\r\n　　我告诉她，她正经历的这些，我也曾经历过。我上学的时候，每个阶段都会给自己定一个目标，然后为之努力，但却常常会因为自己的这份“小追求”而被别人孤立。室友玩游戏、逛街、睡懒觉……而早起看书的我，就成了被整个寝室讨厌的人。\r\n　　她们在别人面前把我诋毁得一无是处。没人理解，没人支持，更没有人同行。当时，不知道是哪来的一股力量，催使着我一个人活成了一支队伍。\r\n　　后来我发现，很多有所成就的人都有过独自跋涉的经历，背后有质疑和嘲笑，可那又算得了什么？我们，始终是在为自己默默地努力着。\r\n　　一个人，只有学会了独立思考，学会了独自解决问题，才能扛起生活的责任和担当。\r\n　　有的人，忍受不了孤独，害怕别人的眼光；有的人，朝着目标坚定前行，不在乎旁人的议论。往往，后者都拥有了更好的生活。回头再看，曾经在背后指指点点的人不知何时已经消失在了人海中。\r\n　　人生那么长，我们都要有胆量为自己选择一次。\r\n　　',9,3,'2019-07-04 02:34:04',1),(16,'你的未来，从不取决于任何一场考试','最近高考等各大类考试的慢慢结束，我想分享一些话。\r\n1、如果我问你：高考会决定你的一生吗？刚考完试的你可能会说：那当然！\r\n但大学毕业多年、投入工作数载的你，可能只会冷冷地一笑：瞧您说的……\r\n因为你已经知道了，高考是小考，人生才是大考。在高考之后漫长的人生中，你还将会迎来大大小小的各种挑战，你也会因此得到很多可以改变自己的机会。\r\n高考真的会决定一生？答案是肯定的，如果，你的人生就止步于18岁，不再前进的话。\r\n如果不是，那结论就是：未必。这两天高考放榜，有人欢喜，有人愁。十年前那个闷热的夏天，我是愁的那个人。\r\n2、当英语老师那会儿，总有同学跑过来问一个问题：老师，你能给我推荐一本书，让我学好英语吗？\r\n 我很纳闷，怎么会有这么一本书呢？如果只看一本书就能让你学好英语，还要英语老师来干嘛？\r\n 于是我发现了，人们总有一个思维误区，容易过分强调一件事情的重要性。比如，一本书，足以让你学好英语；比如，一次高考，重要到可以决定终生。所以，只要一次失败，有的人就会全盘否定自己。\r\n 可是你却忘记了，通向成功的路，本来就是由一个接一个的失败铺成的。\r\n \r\n ',9,11,'2019-07-04 02:34:25',1),(17,'别浪费自己的人生去斤斤计较','我又来分享故事啦~\r\n1、每个人都有一本人生账簿，记录着美好与不美好的事情。随着年纪增长，那些不美好的东西会被慢慢划去，留下美好的东西。\r\n我们经常会被思绪、情绪羁绊，不敢选择，不敢挑战，不敢逃离，只能自怨自艾，抱怨生活为什么那么苦，别人为什么可以这样对待我，为什么受挫的总是……\r\n既然不可能事事如愿，不如学会释然。与其斤斤计较，不如学会淡然处之。\r\n生活中，有些人经常苦闷、烦躁，感觉世界将所有难题都摆在了自己面前，明明都是小事，却怎么也想不通、过不去。\r\n生活中，很多事情常常交织在一起，错综复杂，让人感到烦躁。可越烦躁郁闷，越容易将事情搞砸。如果经常纠结于此，让小事在脑海中无限放大，营造出没有处理好这件事就会后果很严重的氛围，不免会因小失大。\r\n冷静下来思考，其实很多事情没那么复杂。事情分轻重缓急，先将主要的部分解决好，再去解决其他的事情，我们的压力就不会那么大了。\r\n2、有这样一个故事：\r\n一只骆驼行走在大漠中，被一小块玻璃硌到了脚，骆驼很生气地把玻璃踢开，踢飞的玻璃弹回来，又将它的腿划破了，鲜血直流。流出来的鲜血滴在沙漠中，血的味道引来了秃鹫和狼的注意。骆驼为了逃命狂奔起来，却不小心走到了食人蚁巢穴的附近，最后被一团黑黑的食人蚁吃掉。临死前骆驼都没想到，一块小小的玻璃，最后竟让它丢了性命。\r\n生活中，我们不也常常纠缠于一些很小的烂事吗？对过去的错误耿耿于怀，对丢失的小物件愤懑不平，对毫无意义的争论怀恨在心……\r\n',9,3,'2019-07-04 02:34:48',1),(18,' 这个世界对懂事的人并不友好','今天分享一些故事\r\n\r\n6月7日，45岁的南京万达茂总经理徐毓跳楼身亡，具体原因警方尚末最终确定。\r\n在众说纷纭的传闻中让人唏嘘不已：\r\n6月5日，徐毓在她与丈夫和女儿的微信群中发了一条‘对不起’的消息后关机失联。去年11月份被调到南京万达茂后，生活重心全扑在项目上，甚至在项目附近买了房，大年三十也仅回家一个多小时。更甚的坊间传闻是：万达茂开业压力巨大，会议上被区域总大骂了一顿……\r\n看到这里，真相已变得不那么重要，真相就是：这个世界对懂事的人并不友好。\r\n1、懂事的什么也没得到，不懂事的人却满足了很多愿望\r\n小时候，虽说是家里的独子，但众多表弟表妹的存在，让我不得不扮演起懂事老大的人设。最常听见的一句话就是：你最懂事，让着点弟弟妹妹。于是，即便心里有一万只槽泥马在狂奔，表面上还总维持着大度的形象。\r\n直到有一天，妈妈把我的玩具宝剑送给了表弟，还轻描淡写地说：弟弟太喜欢了，况且你不是还有个变形金刚？\r\n虽然，宝剑确实比不上变形金刚对我更有吸引力，可在那个物质并不丰裕的年代，宝剑是我为数不多的玩具之一。\r\n只记得那一天，我哭了个惊天动地，妈妈开始还想用大道理来安抚住我的情绪，可，那一刻我异常执着地哭喊着：凭什么要把我的玩具送给别人？凭什么我是哥哥就要谦让？\r\n最终的结果是：妈妈骑着自行车带着我，去百货公司玩具柜台，又买了把一模一样的宝剑，还顺便给我买了根“娃娃头”冰棍。\r\n那一刻，是一把宝剑加一根娃娃头，告诉了我一个道理：会哭的孩子有奶吃。\r\n2、去他妈的大道理，凭什么用自己的不爽换别人的爽\r\n很多时候，是老师、家长、社会灌输给了我们太多的大道理逼着我们，在“懂事”这条路上越走越远、甚至脱离轨道。\r\n\r\n',9,9,'2019-07-04 02:35:10',1),(19,'如何坚持不懈做一件事情','给各位的一些小建议，希望对你们有帮助\r\n同一起跑线做同一件事情，到最后还是有很多人被别人远远甩在背后，原因不是他不够聪明或者勤劳，却是因为他不够坚持。“坚持就是胜利”说的就是这个道理。做一件事如何坚持下去，是很多人都在寻找答案的问题。\r\n　　1.积极的自我暗示。心里的想法对一个人的行为有非常深远的影响，心态便是这个道理。在生活中常常进行一些积极的自我暗示，例如我一定能瘦下去，我一定能战胜一切等等，在这样的主动的心态引导下，化解困难就不那么难了。\r\n　　2.吸取生活中的正能量。每天早上起床和晚上睡觉前，多看一些积极向上的东西，吸取其中的正能量;每天上下班的过程中，留意身边的正能量。让自己的心态是阳光积极的，这样坚持也就不那么困难了。\r\n　　3.借助榜样的力量。我们应该有一个属于自己的榜样，这个榜样不是拿来羡慕嫉妒恨的，而是学习借鉴的。他可以是某一个经历各种不易才成功的名人，也可以是身边具体的某一个人，甚至是故事里某一个主角。每次想放弃的时候，想想他们的经历和成功，立志自己要成为他。\r\n　　4.寻找同伴的鼓励。一句话叫做：“要想走得快，你就一个人走;要想走得远，那就一群人一起走”，说的就是这个道理。寻找一些志同道合的朋友，相互帮助，相互鼓励，成功路上便不再孤单。\r\n　　5.想象成功的诱惑。做一件事情之前，一定要有个具体的目标，例如成功瘦掉20斤，赚取5万块，获得一等奖学金等等。自己在每次想要放弃的 ...',9,12,'2019-07-04 02:35:34',0),(20,'ijj','hhh',11,0,'2019-07-08 14:51:18',1);

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_user` int(11) NOT NULL,
  `f_adminuser` int(11) NOT NULL,
  `f_content` text NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_used` tinyint(1) NOT NULL DEFAULT '1',
  `is_used_0` int(11) NOT NULL DEFAULT '0' COMMENT '未读为0已读为1',
  PRIMARY KEY (`f_id`),
  KEY `f_user_idx` (`f_user`),
  KEY `f_adminuser_idx` (`f_adminuser`),
  CONSTRAINT `f_adminuser` FOREIGN KEY (`f_adminuser`) REFERENCES `adminuser` (`a_id`),
  CONSTRAINT `f_user` FOREIGN KEY (`f_user`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `feedback` */

insert  into `feedback`(`f_id`,`f_user`,`f_adminuser`,`f_content`,`createtime`,`is_used`,`is_used_0`) values (6,15,9,'反馈测试','2019-07-05 14:14:25',1,1),(7,16,9,'你好','2019-07-08 00:06:14',1,1),(8,18,9,'反馈','2019-07-08 10:26:19',1,0),(9,16,11,'你好啊','2019-07-08 14:06:45',1,1),(10,16,11,'uguigiug','2019-07-08 14:43:40',1,1);

/*Table structure for table `feedbackanwer` */

DROP TABLE IF EXISTS `feedbackanwer`;

CREATE TABLE `feedbackanwer` (
  `fa_id` int(11) NOT NULL AUTO_INCREMENT,
  `fa_leixin` int(11) NOT NULL COMMENT '0代表管理员1代表用户',
  `fa_admin` int(11) DEFAULT NULL,
  `fa_user` int(11) DEFAULT NULL,
  `fa_feedback` int(11) NOT NULL,
  `fa_content` text COLLATE utf8_bin NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_used` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`fa_id`),
  KEY `fa_feedback_idx` (`fa_feedback`),
  KEY `fa_admin` (`fa_admin`),
  KEY `fa_user` (`fa_user`),
  CONSTRAINT `fa_feedback` FOREIGN KEY (`fa_feedback`) REFERENCES `feedback` (`f_id`),
  CONSTRAINT `feedbackanwer_ibfk_1` FOREIGN KEY (`fa_admin`) REFERENCES `adminuser` (`a_id`),
  CONSTRAINT `feedbackanwer_ibfk_2` FOREIGN KEY (`fa_user`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `feedbackanwer` */

insert  into `feedbackanwer`(`fa_id`,`fa_leixin`,`fa_admin`,`fa_user`,`fa_feedback`,`fa_content`,`createtime`,`is_used`) values (14,0,9,NULL,6,'可以','2019-07-05 14:14:31',1),(15,1,NULL,15,6,' 666','2019-07-05 14:14:56',1),(16,1,NULL,16,7,' asdasdsa','2019-07-07 23:27:19',1),(17,0,9,NULL,7,'你好','2019-07-08 00:06:39',1),(18,0,9,NULL,7,'请问有什么问题呢 请在这里说出你的问题','2019-07-08 00:50:06',1),(19,1,NULL,16,7,' 请问有什么问题呢 请在这里说出你的问题','2019-07-08 00:50:13',1),(20,0,11,NULL,10,'huhhuhu','2019-07-08 14:43:49',1),(21,1,NULL,16,10,' hhuu','2019-07-08 14:44:15',1);

/*Table structure for table `huifu` */

DROP TABLE IF EXISTS `huifu`;

CREATE TABLE `huifu` (
  `h_id` int(11) NOT NULL AUTO_INCREMENT,
  `h_pid` int(11) DEFAULT NULL COMMENT '评论id',
  `h_hid` int(11) DEFAULT NULL COMMENT '目标id',
  `h_content` text NOT NULL COMMENT '回复内容',
  `h_userid` int(1) DEFAULT NULL,
  `h_huifuid` int(1) DEFAULT NULL,
  PRIMARY KEY (`h_id`),
  KEY `h_pid` (`h_pid`),
  KEY `h_hid` (`h_hid`),
  KEY `h_userid` (`h_userid`),
  KEY `h_huifuid` (`h_huifuid`),
  CONSTRAINT `huifu_ibfk_1` FOREIGN KEY (`h_pid`) REFERENCES `pinglun` (`pl_id`),
  CONSTRAINT `huifu_ibfk_2` FOREIGN KEY (`h_hid`) REFERENCES `huifu` (`h_id`),
  CONSTRAINT `huifu_ibfk_3` FOREIGN KEY (`h_userid`) REFERENCES `user` (`u_id`),
  CONSTRAINT `huifu_ibfk_4` FOREIGN KEY (`h_huifuid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `huifu` */

/*Table structure for table `photo` */

DROP TABLE IF EXISTS `photo`;

CREATE TABLE `photo` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_url` varchar(60) NOT NULL,
  `p_title` varchar(1024) DEFAULT NULL,
  `p_albums` int(11) NOT NULL,
  `p_author` int(11) NOT NULL,
  `p_liulang` longtext,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_used` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`p_id`),
  KEY `p_albums_idx` (`p_albums`),
  KEY `p_author_idx` (`p_author`),
  CONSTRAINT `p_albums` FOREIGN KEY (`p_albums`) REFERENCES `albums` (`al_id`),
  CONSTRAINT `p_author` FOREIGN KEY (`p_author`) REFERENCES `adminuser` (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `photo` */

insert  into `photo`(`p_id`,`p_url`,`p_title`,`p_albums`,`p_author`,`p_liulang`,`createtime`,`is_used`) values (9,'056523ff-1565-4662-9237-8a8d47424e8c.jpg','海景',15,9,NULL,'2019-07-04 02:59:14',0),(10,'b3a97fd7-c52a-486f-98f6-b3c0767462dc.jpg','海景2',15,9,NULL,'2019-07-04 02:58:40',1),(11,'a783215f-3e5a-4459-bca6-aa8a6efeb1a3.jpg','海景3',15,9,NULL,'2019-07-04 02:58:52',1),(12,'f9ef6942-1ecc-406a-8d34-c4374cf01a94.jpg','海景4',15,9,NULL,'2019-07-04 02:59:03',1),(13,'83279bad-ecc5-4d14-affe-d2146d291c53.jpg','海景1',15,9,NULL,'2019-07-04 03:00:04',1),(14,'a0d604cf-cf3d-4a12-b59f-7beb081d2ba2.jpg','科贸景色1',16,9,NULL,'2019-07-04 03:01:47',1),(15,'ac15b83b-f3c1-4410-a420-1f535f255ec9.jpg','科贸景色2',16,9,NULL,'2019-07-04 03:02:00',1),(16,'736476db-2cd0-4e8d-bd92-c126828e446b.jpg','科贸景色3',16,9,NULL,'2019-07-04 03:02:13',1),(17,'247c278a-0d3f-44b6-86b9-dca7ab7a0012.jpg','科贸景色4',16,9,NULL,'2019-07-04 03:02:28',1),(18,'0b5b05ce-d959-4ef0-a6fb-5308fc8affbc.jpg','科贸景色5',16,9,NULL,'2019-07-04 03:02:42',1),(19,'fea8bb7c-9414-47dd-b953-d5b2afda4f4b.jpg','萌宠1',17,9,NULL,'2019-07-04 03:03:43',1),(20,'e5863bb8-0059-4716-8ee7-843de4a63800.jpg','萌宠2',17,9,NULL,'2019-07-04 03:03:51',1),(21,'7faa7371-da4d-410b-9d6d-d70d2504d64f.jpg','萌宠3',17,9,NULL,'2019-07-04 03:03:58',1),(22,'b08a1777-451e-4266-b344-e810579645a8.jpg','萌宠4',17,9,NULL,'2019-07-04 03:04:10',1),(23,'74c95e65-800b-4256-8059-3ecf574f30a5.jpg','天空奇象1',18,9,NULL,'2019-07-04 03:05:02',1),(24,'d1d222f5-1dc5-45c7-9f38-9a2ea5cf1462.jpg','天空奇象2',18,9,NULL,'2019-07-04 03:05:09',1),(25,'f8717ea4-c802-41f3-92eb-29559148031a.jpg','天空奇象3',18,9,NULL,'2019-07-04 03:05:16',1),(26,'2ec101d7-7510-4e8a-b946-1776aaa71b23.jpg','天空奇象4',18,9,NULL,'2019-07-04 03:05:24',1),(27,'f904fddb-8afc-4178-9a21-b098f68951e7.jpg','天空奇象5',18,9,NULL,'2019-07-04 03:05:35',1),(28,'f5bbc321-9a3e-4c5a-8d7d-f8ab152e0485.jpg','iji',24,11,NULL,'2019-07-08 14:49:14',1);

/*Table structure for table `pinglun` */

DROP TABLE IF EXISTS `pinglun`;

CREATE TABLE `pinglun` (
  `pl_id` int(11) NOT NULL AUTO_INCREMENT,
  `pl_author` int(11) NOT NULL,
  `pl_dongtai` int(11) NOT NULL,
  `pl_content` text NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_used` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`pl_id`),
  KEY `pl_author_idx` (`pl_author`),
  KEY `pl_dongtai_idx` (`pl_dongtai`),
  CONSTRAINT `pl_author` FOREIGN KEY (`pl_author`) REFERENCES `user` (`u_id`),
  CONSTRAINT `pl_dongtai` FOREIGN KEY (`pl_dongtai`) REFERENCES `dongtai` (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `pinglun` */

insert  into `pinglun`(`pl_id`,`pl_author`,`pl_dongtai`,`pl_content`,`createtime`,`is_used`) values (6,15,10,'欢迎你第一次来到博客，成为博客的一名小成员。接下来期待你的小故事和美图风景~','2019-07-04 02:37:05',1),(7,15,10,'嘿嘿，我来博客的目的也是和你一样的，可以倾诉以及分享，很高兴你的到来啊。','2019-07-04 02:37:17',1),(8,15,11,'这是一个鼓励人们的一个小故事，很喜欢你的分享。每个人生下来都有父母的保护，可是当你步入社会时就得学着蜗牛一样有外壳可以保护好自己，愿每个人无论怎么样，都能保护好自己。','2019-07-04 02:37:43',1),(9,15,11,'我想：蜗牛羡慕别人时，别人也羡慕蜗牛吧。每个人都有自己的方法保护自己，正如蝴蝶，蚯蚓，蜗牛以及我们。希望你分享更多的励志故事。\r\n','2019-07-04 02:43:00',1),(10,15,12,'努力去磨练自己吧，终将会闪闪发光的时刻。真的很欣赏那些踏实做事的人们，他们很平凡也很伟大，故事很长你别失望。','2019-07-04 02:43:27',1),(11,15,12,'不能说出口的牵挂靠彼此之间的默契，希望你还愿意相信，不动声色的变好就是最稳妥的回应。我过得不错，你们也要更多加好好努力。','2019-07-04 02:43:35',1),(12,15,12,'不论此刻的你正遭受着怎么样的挫折，相信我，挺住就是一切，秋日的暖阳很快就会到来，故事很长，先别失望。加油。','2019-07-04 02:43:42',1),(13,15,13,'我们要做到的，不是极力追逐个人利益，而是置身于广深的社会之中，去体会弱者，帮扶弱者，平和以待，平等以待，才是真正的价值。','2019-07-04 02:44:06',1),(14,15,13,'正如标题，向弱者一样感受世界！我们每一个人都要这样做，才能成为一个真正有“温度”的人，厚德载物。','2019-07-04 02:44:13',1),(15,15,14,'钱三强，中国科学家中的楷模。不会忘却的，老一辈的科学家真的给后世树立了良好的榜样，我们为他致敬。','2019-07-04 02:44:31',1),(16,15,14,'钱先生是中华民族的民族脊梁！为国家兴盛和民族发展立下汗马功劳，他们的精神更值得我们永远敬佩和学习','2019-07-04 02:44:38',1),(17,15,15,'安逸就是最大的陷阱。 舒适区才是一个人停滞不前的根本原因。  挫折和痛苦才会给人改变现状的无限动力。有些路自己一个人也可以很好。','2019-07-04 02:44:55',1),(18,15,15,'之前看过一句话说，下雨天连影子都不会陪着自己；在慢慢变强大的路上，大多数是一个人的。希望以后的自己能够笑看我所面对的挫折与孤独。因为一个人也可以变得越来越好啊。','2019-07-04 02:45:02',1),(19,15,16,'多年过去，再回忆高考，其实本质上没有考的好与差的说法，重要的是所有的年轻人在一起，做份试题，然后决定去哪座城市，做什么工作，今后和谁相知，和谁一起旅行，和谁走一辈子。不管故事怎样，结局如何，一切都是美好的。','2019-07-04 02:45:36',1),(20,15,16,'文案写的太好了叭！其实真的是这样的，我们的未来从不取决任何一场考试，而是取决于自身，你若想盛开，无人可阻你；请所有人加油吖??','2019-07-04 02:45:44',1),(21,15,16,'高考只能决定你今后的人生方向，却无法决定你的人生，请淡然处之。你的未来还很精彩。','2019-07-04 02:45:55',1),(22,15,17,'当你认为是人生最不顺的时候，别放弃一定要扛住；因为那正是你运气要上升的时候，你的时间和精力有限 要把最重要的事情都放在第一位。','2019-07-04 02:46:11',1),(23,15,17,'说的真好，别浪费自己的人生去斤斤计较，处人处事，有时候会去烦恼，到头来都是庸人自扰，看淡，看轻，看清～一切随风而去～我开心，我快乐，我自在，就足够啦，喜欢你分享的每一个故事。','2019-07-04 02:46:20',1),(24,15,18,'懂事，忍让，最后结果都不太好，他们就是以懂事来让你心甘情愿的被剥夺，被侵犯。多好的借口。小的时候总是拼命委屈自己成全别人，现在我懂的了会哭的孩子有奶喝。以前害怕得罪人，最后变成孤家寡人，现在，得罪又怎么样，又不是得罪不起，那些人，志不同道不合，跟他们在一起还浪费生命。\r\n','2019-07-04 02:46:38',1),(25,15,19,'后来，坚持越来越难了。如果每个人都能和每天坚持玩手机一样坚持一件事情，那该多好啊。','2019-07-04 02:47:01',1),(26,15,19,'希望你的这篇小建议可以帮到很多很多人，感谢分享。','2019-07-04 02:47:07',1),(27,16,19,'你好','2019-07-07 20:39:31',1),(28,17,18,'0.0','2019-07-07 21:44:50',1),(29,16,16,'高考只能决定你今后的人生方向，却无法决定你的人生，请淡然处之。你的未来还很精彩。','2019-07-08 13:59:41',1),(30,16,18,'hhhhi\r\n','2019-07-08 14:41:53',1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(36) NOT NULL,
  `u_pass` blob NOT NULL,
  `u_nickname` varchar(36) DEFAULT NULL,
  `u_touxiang` varchar(50) DEFAULT NULL,
  `u_problem` varchar(100) NOT NULL,
  `u_answer` varchar(100) NOT NULL,
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_used` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`u_name`,`u_pass`,`u_nickname`,`u_touxiang`,`u_problem`,`u_answer`,`createtime`,`is_used`) values (15,'adminuser',';�V��#�g��;Hߤ,#7aCJ�[��pLs�','adminuser','4d5d45c9-16b1-42fb-a15a-2bd367dc6d27.jpg','你的梦想是什么？','咸鱼','2019-07-04 02:30:02',1),(16,'jp','�H�j�e��X�9h��u4�u�\n`�2�I','jp.darkbuiu','74c21a35-f0e3-4b99-94b5-36f54bb1eb40.jpg','你的学号是什么？','123','2019-07-08 14:44:48',1),(17,'123456',':ߦ��l�X��VX���\rz��un�h��','123456','11b1f113-7588-4b1a-9668-45a5ef217c6d.jpg','你的梦想是什么？','123456','2019-07-07 21:38:25',1),(18,'user01','!�Fx1}���\n���T����3�c>e��','user011','5e6e62c9-f061-4ef5-a741-4836f37ae231.jpg','你的梦想是什么？','user01','2019-07-08 10:25:34',1),(19,'joj','j5D��W|h\"��4l�y�$\ZN�P','joj',NULL,'你的梦想是什么？','123123','2019-07-08 14:48:27',0);

/*Table structure for table `userlog` */

DROP TABLE IF EXISTS `userlog`;

CREATE TABLE `userlog` (
  `l_id` int(11) NOT NULL,
  `l_user` int(11) DEFAULT NULL,
  `l_logtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `l_ipaddr` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`l_id`),
  KEY `l_user_idx` (`l_user`),
  CONSTRAINT `l_user` FOREIGN KEY (`l_user`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userlog` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
