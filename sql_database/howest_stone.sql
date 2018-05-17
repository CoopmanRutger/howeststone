/*
SQLyog Community v12.4.3 (64 bit)
MySQL - 5.7.19 : Database - howest_stone
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`howest_stone` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `howest_stone`;

/*Table structure for table `hero` */

DROP TABLE IF EXISTS `hero`;

CREATE TABLE `hero` (
  `heroName` varchar(60) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  `heroPower` varchar(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `hero` */

insert  into `hero`(`heroName`,`img`,`heroPower`) values 
('Mage',NULL,'Fireblast'),
('Lesser Heal',NULL,'Lesser Heal');

/*Table structure for table `heropower` */

DROP TABLE IF EXISTS `heropower`;

CREATE TABLE `heropower` (
  `powerName` varchar(60) DEFAULT NULL,
  `heroType` varchar(60) DEFAULT NULL,
  `mana` int(11) DEFAULT NULL,
  `tags` varchar(100) DEFAULT NULL,
  `abilityType` varchar(60) DEFAULT NULL,
  `duration` int(11) DEFAULT NULL,
  `abilityValue` int(11) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `heropower` */

insert  into `heropower`(`powerName`,`heroType`,`mana`,`tags`,`abilityType`,`duration`,`abilityValue`,`img`) values 
('Fireblast','Mage',2,'Targeted','damage',1,NULL,NULL),
('Lesser Heal','Priest',2,'Targeted','health',1,NULL,NULL);

/*Table structure for table `minions` */

DROP TABLE IF EXISTS `minions`;

CREATE TABLE `minions` (
  `cardId` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(21) CHARACTER SET utf8 DEFAULT NULL,
  `type` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `mana` int(11) DEFAULT NULL,
  `attack` int(11) DEFAULT NULL,
  `health` int(11) DEFAULT NULL,
  `heroType` varchar(7) CHARACTER SET utf8 DEFAULT NULL,
  `race` varchar(9) CHARACTER SET utf8 DEFAULT NULL,
  `mechanicsName` varchar(13) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(88) CHARACTER SET utf8 DEFAULT NULL,
  `img` varchar(75) CHARACTER SET utf8 DEFAULT NULL,
  `imgBack` varchar(89) CHARACTER SET utf8 DEFAULT NULL,
  `extraAbility` tinyint(1) DEFAULT '1',
  `affected` varchar(50) DEFAULT NULL,
  `abilityAmount` char(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `minions` */

insert  into `minions`(`cardId`,`name`,`type`,`mana`,`attack`,`health`,`heroType`,`race`,`mechanicsName`,`description`,`img`,`imgBack`,`extraAbility`,`affected`,`abilityAmount`) values 
('CS2_231','Wisp','Minion',0,1,1,'Neutral',NULL,NULL,NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_231.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_231_premium.gif',0,NULL,NULL),
('CS2_188','Abusive Sergeant','Minion',1,1,1,'Neutral',NULL,'Battlecry','Battlecry: Give a minion +2_Attack this turn.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_188.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_188_premium.gif',1,NULL,NULL),
('EX1_009','Angry Chicken','Minion',1,1,1,'Neutral','Beast',NULL,'Has +5 Attack while damaged.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_009.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_009_premium.gif',1,NULL,NULL),
('EX1_008','Argent Squire','Minion',1,1,1,'Neutral',NULL,'Divine Shield','Divine Shield','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_008.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_008_premium.gif',1,NULL,NULL),
('CS2_059','Blood Imp','Minion',1,0,1,'Warlock','Demon','Stealth','[x] Stealth. At the end of your \nturn, give another random\n friendly minion +1 Health.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_059.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_059_premium.gif',1,NULL,NULL),
('EX1_319','Flame Imp','Minion',1,3,2,'Warlock','Demon','Battlecry','Battlecry: Deal 3 damage to your hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_319.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_319_premium.gif',1,NULL,NULL),
('EX1_538t','Hound','Minion',1,1,1,'Hunter','Beast','Charge','Charge','http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_538t.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/EX1_538t_premium.gif',1,NULL,NULL),
('NEW1_017','Hungry Crab','Minion',1,1,2,'Neutral','Beast','Battlecry','Battlecry: Destroy a Murloc and gain +2/+2.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_017.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/NEW1_017_premium.gif',1,NULL,NULL),
('EX1_029','Leper Gnome','Minion',1,1,1,'Neutral',NULL,'Deathrattle','Deathrattle: Deal 2 damage to the enemy_hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_029.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_029_premium.gif',1,NULL,NULL),
('EX1_405','Shieldbearer','Minion',1,0,4,'Neutral',NULL,'Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_405.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_405_premium.gif',1,NULL,NULL),
('CS2_152','Squire','Minion',1,2,2,'Neutral',NULL,NULL,NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/CS2_152.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/CS2_152_premium.gif',0,NULL,NULL),
('EX1_010','Worgen Infiltrator','Minion',1,2,1,'Neutral',NULL,'Stealth','Stealth','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_010.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_010_premium.gif',1,NULL,NULL),
('CS2_169','Young Dragonhawk','Minion',1,1,1,'Neutral','Beast','Windfury','Windfury','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_169.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_169_premium.gif',1,NULL,NULL),
('EX1_004','Young Priestess','Minion',1,2,1,'Neutral',NULL,NULL,'At the end of your turn, give another random friendly minion +1 Health.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_004.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_004_premium.gif',1,NULL,NULL),
('EX1_393','Amani Berserker','Minion',2,2,3,'Neutral',NULL,NULL,'Has +3 Attack while damaged.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_393.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_393_premium.gif',1,NULL,NULL),
('EX1_362','Argent Protector','Minion',2,2,2,'Paladin',NULL,'Divine Shield','Battlecry: Give a friendly minion Divine Shield.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_362.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_362_premium.gif',1,NULL,NULL),
('EX1_362','Argent Protector','Minion',2,2,2,'Paladin',NULL,'Battlecry','Battlecry: Give a friendly minion Divine Shield.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_362.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_362_premium.gif',1,NULL,NULL),
('EX1_012','Bloodmage Thalnos','Minion',2,1,1,'Neutral',NULL,'Deathrattle','Spell Damage +1\nDeathrattle: Draw a card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_012.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_012_premium.gif',1,NULL,NULL),
('EX1_012','Bloodmage Thalnos','Minion',2,1,1,'Neutral',NULL,'Spell Damage','Spell Damage +1\nDeathrattle: Draw a card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_012.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_012_premium.gif',1,NULL,NULL),
('NEW1_018','Bloodsail Raider','Minion',2,2,3,'Neutral','Pirate','Battlecry','Battlecry: Gain Attack equal to the Attack\nof your weapon.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_018.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/NEW1_018_premium.gif',1,NULL,NULL),
('EX1_059','Crazed Alchemist','Minion',2,2,2,'Neutral',NULL,'Battlecry','Battlecry: Swap the Attack and Health of a minion.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_059.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_059_premium.gif',1,NULL,NULL),
('EX1_603','Cruel Taskmaster','Minion',2,2,2,'Warrior',NULL,'Battlecry','Battlecry: Deal 1 damage to a minion and give it +2_Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_603.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_603_premium.gif',1,NULL,NULL),
('EX1_162','Dire Wolf Alpha','Minion',2,2,2,'Neutral','Beast','AdjacentBuff','Adjacent minions have +1_Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_162.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_162_premium.gif',1,NULL,NULL),
('EX1_162','Dire Wolf Alpha','Minion',2,2,2,'Neutral','Beast','Aura','Adjacent minions have +1_Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_162.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_162_premium.gif',1,NULL,NULL),
('NEW1_023','Faerie Dragon','Minion',2,3,2,'Neutral','Dragon',NULL,'Can\'t be targeted by spells or Hero Powers.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_023.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/NEW1_023_premium.gif',1,NULL,NULL),
('NEW1_040t','Gnoll','Minion',2,2,2,'Neutral',NULL,'Taunt','Taunt','http://wow.zamimg.com/images/hearthstone/cards/enus/original/NEW1_040t.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/NEW1_040t_premium.gif',1,NULL,NULL),
('EX1_341','Lightwell','Minion',2,0,5,'Priest',NULL,NULL,'At the start of your turn, restore 3 Health to a damaged friendly character.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_341.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_341_premium.gif',1,NULL,NULL),
('EX1_096','Loot Hoarder','Minion',2,2,1,'Neutral',NULL,'Deathrattle','Deathrattle: Draw a card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_096.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_096_premium.gif',1,NULL,NULL),
('EX1_082','Mad Bomber','Minion',2,3,2,'Neutral',NULL,'Battlecry','Battlecry: Deal 3 damage randomly split between all other characters.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_082.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_082_premium.gif',1,NULL,NULL),
('NEW1_037','Master Swordsmith','Minion',2,1,3,'Neutral',NULL,NULL,'At the end of your turn, give another random friendly minion +1 Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_037.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/NEW1_037_premium.gif',1,NULL,NULL),
('EX1_058','Sunfury Protector','Minion',2,2,3,'Neutral',NULL,'Taunt','Battlecry: Give adjacent minions Taunt.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_058.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_058_premium.gif',1,NULL,NULL),
('EX1_058','Sunfury Protector','Minion',2,2,3,'Neutral',NULL,'Battlecry','Battlecry: Give adjacent minions Taunt.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_058.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_058_premium.gif',1,NULL,NULL),
('EX1_049','Youthful Brewmaster','Minion',2,3,2,'Neutral',NULL,'Battlecry','Battlecry: Return a friendly minion from the battlefield to your hand.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_049.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_049_premium.gif',1,NULL,NULL),
('EX1_007','Acolyte of Pain','Minion',3,1,3,'Neutral',NULL,NULL,'Whenever this minion takes damage, draw a_card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_007.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_007_premium.gif',1,NULL,NULL),
('EX1_006','Alarm-o-Bot','Minion',3,0,3,'Neutral','Mech',NULL,'[x]At the start of your turn,\nswap this minion with a\n random one in your hand.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_006.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_006_premium.gif',1,NULL,NULL),
('EX1_382','Aldor Peacekeeper','Minion',3,3,3,'Paladin',NULL,'Battlecry','Battlecry: Change an_enemy minion\'s Attack to 1.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_382.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_382_premium.gif',1,NULL,NULL),
('EX1_089','Arcane Golem','Minion',3,4,4,'Neutral',NULL,'Battlecry','Battlecry: Give your opponent a Mana Crystal.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_089.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_089_premium.gif',1,NULL,NULL),
('EX1_590','Blood Knight','Minion',3,3,3,'Neutral',NULL,'Divine Shield','Battlecry: All minions lose Divine Shield. Gain +3/+3 for each Shield lost.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_590.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_590_premium.gif',1,NULL,NULL),
('EX1_590','Blood Knight','Minion',3,3,3,'Neutral',NULL,'Battlecry','Battlecry: All minions lose Divine Shield. Gain +3/+3 for each Shield lost.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_590.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_590_premium.gif',1,NULL,NULL),
('EX1_103','Coldlight Seer','Minion',3,2,3,'Neutral','Murloc','Battlecry','Battlecry: Give your other Murlocs +2 Health.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_103.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_103_premium.gif',1,NULL,NULL),
('EX1_102','Demolisher','Minion',3,1,4,'Neutral','Mech',NULL,'At the start of your turn, deal 2 damage to a random enemy.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_102.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_102_premium.gif',1,NULL,NULL),
('CS2_117','Earthen Ring Farseer','Minion',3,3,3,'Neutral',NULL,'Battlecry','Battlecry: Restore 3_Health.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_117.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_117_premium.gif',1,NULL,NULL),
('EX1_170','Emperor Cobra','Minion',3,2,3,'Neutral','Beast','Poisonous','Poisonous','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_170.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_170_premium.gif',1,NULL,NULL),
('EX1_301','Felguard','Minion',3,3,5,'Warlock','Demon','Taunt','Taunt\nBattlecry: Destroy one of your Mana Crystals.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_301.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_301_premium.gif',1,NULL,NULL),
('EX1_301','Felguard','Minion',3,3,5,'Warlock','Demon','Battlecry','Taunt\nBattlecry: Destroy one of your Mana Crystals.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_301.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_301_premium.gif',1,NULL,NULL),
('EX1_finkle','Finkle Einhorn','Minion',3,3,3,'Neutral',NULL,NULL,NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_finkle.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/EX1_finkle_premium.gif',0,NULL,NULL),
('tt_004','Flesheating Ghoul','Minion',3,2,3,'Neutral',NULL,NULL,'Whenever a minion dies, gain +1 Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/tt_004.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/tt_004_premium.gif',1,NULL,NULL),
('EX1_604','Frothing Berserker','Minion',3,2,4,'Warrior',NULL,NULL,'Whenever a minion takes damage, gain +1 Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_604.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_604_premium.gif',1,NULL,NULL),
('CS2_181','Injured Blademaster','Minion',3,4,7,'Neutral',NULL,'Battlecry','Battlecry: Deal 4 damage to HIMSELF.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_181.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_181_premium.gif',1,NULL,NULL),
('CS2_203','Ironbeak Owl','Minion',3,2,1,'Neutral','Beast','Silence','Battlecry: Silence a_minion.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_203.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_203_premium.gif',1,NULL,NULL),
('CS2_203','Ironbeak Owl','Minion',3,2,1,'Neutral','Beast','Battlecry','Battlecry: Silence a_minion.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_203.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_203_premium.gif',1,NULL,NULL),
('EX1_017','Jungle Panther','Minion',3,4,2,'Neutral','Beast','Stealth','Stealth','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_017.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_017_premium.gif',1,NULL,NULL),
('EX1_507','Murloc Warleader','Minion',3,3,3,'Neutral','Murloc','Aura','Your other Murlocs have +2 Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_507.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_507_premium.gif',1,NULL,NULL),
('EX1_412','Raging Worgen','Minion',3,3,3,'Neutral',NULL,'Windfury','Has +1 Attack and Windfury while damaged.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_412.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_412_premium.gif',1,NULL,NULL),
('EX1_020','Scarlet Crusader','Minion',3,3,1,'Neutral',NULL,'Divine Shield','Divine Shield','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_020.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_020_premium.gif',1,NULL,NULL),
('NEW1_027','Southsea Captain','Minion',3,3,3,'Neutral','Pirate','Aura','Your other Pirates have +1/+1.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_027.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/NEW1_027_premium.gif',1,NULL,NULL),
('EX1_390','Tauren Warrior','Minion',3,2,3,'Neutral',NULL,'Taunt','Taunt\nHas +3 Attack while damaged.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_390.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_390_premium.gif',1,NULL,NULL),
('EX1_021','Thrallmar Farseer','Minion',3,2,3,'Neutral',NULL,'Windfury','Windfury','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_021.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_021_premium.gif',1,NULL,NULL),
('EX1_304','Void Terror','Minion',3,3,3,'Warlock','Demon','Battlecry','[x]Battlecry: Destroy both\nadjacent minions and gain\n their Attack and Health.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_304.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_304_premium.gif',1,NULL,NULL),
('EX1_057','Ancient Brewmaster','Minion',4,5,4,'Neutral',NULL,'Battlecry','Battlecry: Return a friendly minion from the battlefield to your hand.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_057.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_057_premium.gif',1,NULL,NULL),
('EX1_584','Ancient Mage','Minion',4,2,5,'Neutral',NULL,'Spell Damage','Battlecry: Give adjacent_minions Spell_Damage +1.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_584.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_584_premium.gif',1,NULL,NULL),
('EX1_584','Ancient Mage','Minion',4,2,5,'Neutral',NULL,'Battlecry','Battlecry: Give adjacent_minions Spell_Damage +1.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_584.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_584_premium.gif',1,NULL,NULL),
('EX1_046','Dark Iron Dwarf','Minion',4,4,4,'Neutral',NULL,'Battlecry','Battlecry: Give a minion +2_Attack this turn.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_046.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_046_premium.gif',1,NULL,NULL),
('EX1_093','Defender of Argus','Minion',4,2,3,'Neutral',NULL,'Taunt','Battlecry: Give adjacent minions +1/+1 and Taunt.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_093.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_093_premium.gif',1,NULL,NULL),
('EX1_093','Defender of Argus','Minion',4,2,3,'Neutral',NULL,'Battlecry','Battlecry: Give adjacent minions +1/+1 and Taunt.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_093.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_093_premium.gif',1,NULL,NULL),
('EX1_396','Mogu\'shan Warden','Minion',4,1,7,'Neutral',NULL,'Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_396.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_396_premium.gif',1,NULL,NULL),
('EX1_313','Pit Lord','Minion',4,5,6,'Warlock','Demon','Battlecry','Battlecry: Deal 5 damage to your hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_313.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_313_premium.gif',1,NULL,NULL),
('EX1_023','Silvermoon Guardian','Minion',4,3,3,'Neutral',NULL,'Divine Shield','Divine Shield','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_023.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_023_premium.gif',1,NULL,NULL),
('EX1_048','Spellbreaker','Minion',4,4,3,'Neutral',NULL,'Silence','Battlecry: Silence a_minion.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_048.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_048_premium.gif',1,NULL,NULL),
('EX1_048','Spellbreaker','Minion',4,4,3,'Neutral',NULL,'Battlecry','Battlecry: Silence a_minion.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_048.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_048_premium.gif',1,NULL,NULL),
('EX1_043','Twilight Drake','Minion',4,4,1,'Neutral','Dragon','Battlecry','Battlecry: Gain +1 Health for each card in your hand.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_043.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_043_premium.gif',1,NULL,NULL),
('EX1_097','Abomination','Minion',5,4,4,'Neutral',NULL,'Taunt','Taunt. Deathrattle: Deal 2\ndamage to ALL characters.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_097.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_097_premium.gif',1,NULL,NULL),
('EX1_097','Abomination','Minion',5,4,4,'Neutral',NULL,'Deathrattle','Taunt. Deathrattle: Deal 2\ndamage to ALL characters.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_097.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_097_premium.gif',1,NULL,NULL),
('EX1_005','Big Game Hunter','Minion',5,4,2,'Neutral',NULL,'Battlecry','Battlecry: Destroy a minion with 7 or more Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_005.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_005_premium.gif',1,NULL,NULL),
('NEW1_024','Captain Greenskin','Minion',5,5,4,'Neutral','Pirate','Battlecry','Battlecry: Give your weapon +1/+1.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_024.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/NEW1_024_premium.gif',1,NULL,NULL),
('CS1_069','Fen Creeper','Minion',5,3,6,'Neutral',NULL,'Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS1_069.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS1_069_premium.gif',1,NULL,NULL),
('EX1_558','Harrison Jones','Minion',5,5,4,'Neutral',NULL,'Battlecry','Battlecry: Destroy your opponent\'s weapon and draw cards equal to its Durability.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_558.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_558_premium.gif',1,NULL,NULL),
('CS2_221','Spiteful Smith','Minion',5,4,6,'Neutral',NULL,NULL,'Your weapon has +2 Attack while this is damaged.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_221.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_221_premium.gif',1,NULL,NULL),
('NEW1_041','Stampeding Kodo','Minion',5,3,5,'Neutral','Beast','Battlecry','Battlecry: Destroy a random enemy minion with 2 or less Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_041.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/NEW1_041_premium.gif',1,NULL,NULL),
('EX1_028','Stranglethorn Tiger','Minion',5,5,5,'Neutral','Beast','Stealth','Stealth','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_028.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_028_premium.gif',1,NULL,NULL),
('EX1_067','Argent Commander','Minion',6,4,2,'Neutral',NULL,'Charge','Charge\nDivine Shield','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_067.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_067_premium.gif',1,NULL,NULL),
('EX1_067','Argent Commander','Minion',6,4,2,'Neutral',NULL,'Divine Shield','Charge\nDivine Shield','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_067.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_067_premium.gif',1,NULL,NULL),
('EX1_tk34','Infernal','Minion',6,6,6,'Warlock','Demon',NULL,NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_tk34.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/EX1_tk34_premium.gif',0,NULL,NULL),
('EX1_583','Priestess of Elune','Minion',6,5,4,'Neutral',NULL,'Battlecry','Battlecry: Restore 4 Health to your hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_583.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_583_premium.gif',1,NULL,NULL),
('EX1_032','Sunwalker','Minion',6,4,5,'Neutral',NULL,'Taunt','Taunt\nDivine Shield','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_032.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_032_premium.gif',1,NULL,NULL),
('EX1_032','Sunwalker','Minion',6,4,5,'Neutral',NULL,'Divine Shield','Taunt\nDivine Shield','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_032.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_032_premium.gif',1,NULL,NULL),
('EX1_623','Temple Enforcer','Minion',6,6,6,'Priest',NULL,'Battlecry','Battlecry: Give a friendly minion +3 Health.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_623.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_623_premium.gif',1,NULL,NULL),
('EX1_002','The Black Knight','Minion',6,4,5,'Neutral',NULL,'Taunt','Battlecry: Destroy an enemy minion with Taunt.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_002.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_002_premium.gif',1,NULL,NULL),
('EX1_002','The Black Knight','Minion',6,4,5,'Neutral',NULL,'Battlecry','Battlecry: Destroy an enemy minion with Taunt.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_002.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_002_premium.gif',1,NULL,NULL),
('EX1_033','Windfury Harpy','Minion',6,4,5,'Neutral',NULL,'Windfury','Windfury','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_033.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_033_premium.gif',1,NULL,NULL),
('EX1_249','Baron Geddon','Minion',7,7,5,'Neutral','Elemental',NULL,'At the end of your turn, deal 2 damage to ALL other characters.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_249.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_249_premium.gif',1,NULL,NULL),
('EX1_350','Prophet Velen','Minion',7,7,7,'Priest',NULL,NULL,'Double the damage and healing of your spells and Hero Power.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_350.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_350_premium.gif',1,NULL,NULL),
('CS2_161','Ravenholdt Assassin','Minion',7,7,5,'Neutral',NULL,'Stealth','Stealth','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_161.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_161_premium.gif',1,NULL,NULL),
('EX1_414','Grommash Hellscream','Minion',8,4,9,'Warrior',NULL,'Charge','Charge\nHas +6 Attack while damaged.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_414.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_414_premium.gif',1,NULL,NULL),
('NEW1_038','Gruul','Minion',8,7,7,'Neutral',NULL,NULL,'At the end of each turn, gain +1/+1 .','http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_038.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/NEW1_038_premium.gif',1,NULL,NULL),
('EX1_561','Alexstrasza','Minion',9,8,8,'Neutral','Dragon','Battlecry','Battlecry: Set a hero\'s remaining Health to 15.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_561.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_561_premium.gif',1,NULL,NULL),
('EX1_543','King Krush','Minion',9,8,8,'Hunter','Beast','Charge','Charge','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_543.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_543_premium.gif',1,NULL,NULL),
('EX1_563','Malygos','Minion',9,4,12,'Neutral','Dragon','Spell Damage','Spell Damage +5','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_563.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_563_premium.gif',1,NULL,NULL),
('EX1_560','Nozdormu','Minion',9,8,8,'Neutral','Dragon',NULL,'Players only have 15 seconds to take their_turns.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_560.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_560_premium.gif',1,NULL,NULL),
('EX1_586','Sea Giant','Minion',10,8,8,'Neutral',NULL,NULL,'Costs (1) less for each other minion on the battlefield.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_586.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_586_premium.gif',1,NULL,NULL),
('GAME_002','Avatar of the Coin','Minion',0,1,1,'Neutral',NULL,NULL,'You lost the coin flip, but gained a friend.','http://wow.zamimg.com/images/hearthstone/cards/enus/original/GAME_002.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/GAME_002_premium.gif',1,NULL,NULL),
('CS2_boar','Boar','Minion',1,1,1,'Neutral','Beast',NULL,NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/CS2_boar.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/CS2_boar_premium.gif',0,NULL,NULL),
('CS2_189','Elven Archer','Minion',1,1,1,'Neutral',NULL,'Battlecry','Battlecry: Deal 1 damage.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_189.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_189_premium.gif',1,NULL,NULL),
('CS1_042','Goldshire Footman','Minion',1,1,2,'Neutral',NULL,'Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS1_042.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS1_042_premium.gif',1,NULL,NULL),
('EX1_508','Grimscale Oracle','Minion',1,1,1,'Neutral','Murloc',NULL,'Your other Murlocs have +1 Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_508.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_508_premium.gif',1,NULL,NULL),
('EX1_025t','Mechanical Dragonling','Minion',1,2,1,'Neutral','Mech',NULL,NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_025t.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/EX1_025t_premium.gif',0,NULL,NULL),
('CS2_168','Murloc Raider','Minion',1,2,1,'Neutral','Murloc',NULL,NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_168.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_168_premium.gif',0,NULL,NULL),
('EX1_506a','Murloc Scout','Minion',1,1,1,'Neutral','Murloc',NULL,NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_506a.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/EX1_506a_premium.gif',0,NULL,NULL),
('CS2_235','Northshire Cleric','Minion',1,1,3,'Priest',NULL,NULL,'Whenever a minion is healed, draw a card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_235.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_235_premium.gif',1,NULL,NULL),
('CS2_tk1','Sheep','Minion',1,1,1,'Neutral','Beast',NULL,NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/CS2_tk1.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/CS2_tk1_premium.gif',0,NULL,NULL),
('CS2_101t','Silver Hand Recruit','Minion',1,1,1,'Paladin',NULL,NULL,NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/CS2_101t.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/CS2_101t_premium.gif',0,NULL,NULL),
('CS2_171','Stonetusk Boar','Minion',1,1,1,'Neutral','Beast','Charge','Charge','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_171.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_171_premium.gif',1,NULL,NULL),
('DS1_175','Timber Wolf','Minion',1,1,1,'Hunter','Beast','Aura','Your other Beasts have +1_Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_175.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/DS1_175_premium.gif',1,NULL,NULL),
('CS2_065','Voidwalker','Minion',1,1,3,'Warlock','Demon','Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_065.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_065_premium.gif',1,NULL,NULL),
('EX1_011','Voodoo Doctor','Minion',1,2,1,'Neutral',NULL,'Battlecry','Battlecry: Restore 2_Health.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_011.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_011_premium.gif',1,NULL,NULL),
('CS2_172','Bloodfen Raptor','Minion',2,3,2,'Neutral','Beast',NULL,NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_172.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_172_premium.gif',0,NULL,NULL),
('CS2_173','Bluegill Warrior','Minion',2,2,1,'Neutral','Murloc','Charge','Charge','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_173.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_173_premium.gif',1,NULL,NULL),
('CS2_121','Frostwolf Grunt','Minion',2,2,2,'Neutral',NULL,'Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_121.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_121_premium.gif',1,NULL,NULL),
('CS2_142','Kobold Geomancer','Minion',2,2,2,'Neutral',NULL,'Spell Damage','Spell Damage +1','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_142.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_142_premium.gif',1,NULL,NULL),
('EX1_015','Novice Engineer','Minion',2,1,1,'Neutral',NULL,'Battlecry','Battlecry: Draw a card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_015.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_015_premium.gif',1,NULL,NULL),
('CS2_120','River Crocolisk','Minion',2,2,3,'Neutral','Beast',NULL,NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_120.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_120_premium.gif',0,NULL,NULL),
('EX1_306','Succubus','Minion',2,4,3,'Warlock','Demon','Battlecry','Battlecry: Discard a random card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_306.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_306_premium.gif',1,NULL,NULL),
('EX1_582','Dalaran Mage','Minion',3,1,4,'Neutral',NULL,'Spell Damage','Spell Damage +1','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_582.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_582_premium.gif',1,NULL,NULL),
('NEW1_034','Huffer','Minion',3,4,2,'Hunter','Beast','Charge','Charge','http://wow.zamimg.com/images/hearthstone/cards/enus/original/NEW1_034.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/NEW1_034_premium.gif',1,NULL,NULL),
('CS2_141','Ironforge Rifleman','Minion',3,2,2,'Neutral',NULL,'Battlecry','Battlecry: Deal 1 damage.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_141.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_141_premium.gif',1,NULL,NULL),
('CS2_125','Ironfur Grizzly','Minion',3,3,3,'Neutral','Beast','Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_125.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_125_premium.gif',1,NULL,NULL),
('NEW1_033','Leokk','Minion',3,2,4,'Hunter','Beast','Aura','Your other minions have +1 Attack.','http://wow.zamimg.com/images/hearthstone/cards/enus/original/NEW1_033.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/NEW1_033_premium.gif',1,NULL,NULL),
('CS2_118','Magma Rager','Minion',3,5,1,'Neutral','Elemental',NULL,NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_118.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_118_premium.gif',0,NULL,NULL),
('NEW1_032','Misha','Minion',3,4,4,'Hunter','Beast','Taunt','Taunt','http://wow.zamimg.com/images/hearthstone/cards/enus/original/NEW1_032.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/NEW1_032_premium.gif',1,NULL,NULL),
('CS2_122','Raid Leader','Minion',3,2,2,'Neutral',NULL,'Aura','Your other minions have +1 Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_122.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_122_premium.gif',1,NULL,NULL),
('EX1_019','Shattered Sun Cleric','Minion',3,3,2,'Neutral',NULL,'Battlecry','Battlecry: Give a friendly minion +1/+1.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_019.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_019_premium.gif',1,NULL,NULL),
('CS2_127','Silverback Patriarch','Minion',3,1,4,'Neutral','Beast','Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_127.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_127_premium.gif',1,NULL,NULL),
('EX1_084','Warsong Commander','Minion',3,2,3,'Warrior',NULL,'Charge','Your Charge minions have +1 Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_084.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_084_premium.gif',1,NULL,NULL),
('EX1_084','Warsong Commander','Minion',3,2,3,'Warrior',NULL,'Aura','Your Charge minions have +1 Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_084.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_084_premium.gif',1,NULL,NULL),
('CS2_124','Wolfrider','Minion',3,3,1,'Neutral',NULL,'Charge','Charge','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_124.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_124_premium.gif',1,NULL,NULL),
('CS2_182','Chillwind Yeti','Minion',4,4,5,'Neutral',NULL,NULL,NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_182.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_182_premium.gif',0,NULL,NULL),
('CS2_147','Gnomish Inventor','Minion',4,2,4,'Neutral',NULL,'Battlecry','Battlecry: Draw a card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_147.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_147_premium.gif',1,NULL,NULL),
('DS1_070','Houndmaster','Minion',4,4,3,'Hunter',NULL,'Taunt','Battlecry: Give a friendly Beast +2/+2 and Taunt.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_070.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/DS1_070_premium.gif',1,NULL,NULL),
('DS1_070','Houndmaster','Minion',4,4,3,'Hunter',NULL,'Battlecry','Battlecry: Give a friendly Beast +2/+2 and Taunt.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_070.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/DS1_070_premium.gif',1,NULL,NULL),
('NEW1_011','Kor\'kron Elite','Minion',4,4,3,'Warrior',NULL,'Charge','Charge','http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_011.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/NEW1_011_premium.gif',1,NULL,NULL),
('CS2_119','Oasis Snapjaw','Minion',4,2,7,'Neutral','Beast',NULL,NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_119.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_119_premium.gif',0,NULL,NULL),
('CS2_197','Ogre Magi','Minion',4,4,4,'Neutral',NULL,'Spell Damage','Spell Damage +1','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_197.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_197_premium.gif',1,NULL,NULL),
('CS2_179','Sen\'jin Shieldmasta','Minion',4,3,5,'Neutral',NULL,'Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_179.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_179_premium.gif',1,NULL,NULL),
('CS2_131','Stormwind Knight','Minion',4,2,5,'Neutral',NULL,'Charge','Charge','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_131.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_131_premium.gif',1,NULL,NULL),
('CS2_187','Booty Bay Bodyguard','Minion',5,5,4,'Neutral',NULL,'Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_187.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_187_premium.gif',1,NULL,NULL),
('DS1_055','Darkscale Healer','Minion',5,4,5,'Neutral',NULL,'Battlecry','Battlecry: Restore 2 Health to all friendly characters.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_055.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/DS1_055_premium.gif',1,NULL,NULL),
('CS2_226','Frostwolf Warlord','Minion',5,4,4,'Neutral',NULL,'Battlecry','Battlecry: Gain +1/+1 for each other friendly minion on the battlefield.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_226.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_226_premium.gif',1,NULL,NULL),
('EX1_399','Gurubashi Berserker','Minion',5,2,7,'Neutral',NULL,NULL,'Whenever this minion takes damage, gain +3_Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_399.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_399_premium.gif',1,NULL,NULL),
('EX1_593','Nightblade','Minion',5,4,4,'Neutral',NULL,'Battlecry','Battlecry: Deal 3 damage to the enemy hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_593.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_593_premium.gif',1,NULL,NULL),
('CS2_150','Stormpike Commando','Minion',5,4,2,'Neutral',NULL,'Battlecry','Battlecry: Deal 2 damage.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_150.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_150_premium.gif',1,NULL,NULL),
('DS1_178','Tundra Rhino','Minion',5,2,5,'Hunter','Beast','Charge','Your Beasts have Charge.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_178.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/DS1_178_premium.gif',1,NULL,NULL),
('DS1_178','Tundra Rhino','Minion',5,2,5,'Hunter','Beast','Aura','Your Beasts have Charge.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_178.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/DS1_178_premium.gif',1,NULL,NULL),
('CS2_155','Archmage','Minion',6,4,7,'Neutral',NULL,'Spell Damage','Spell Damage +1','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_155.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_155_premium.gif',1,NULL,NULL),
('CS2_200','Boulderfist Ogre','Minion',6,6,7,'Neutral',NULL,NULL,NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_200.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_200_premium.gif',0,NULL,NULL),
('CS2_064','Dread Infernal','Minion',6,6,6,'Warlock','Demon','Battlecry','Battlecry: Deal 1 damage to ALL other characters.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_064.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_064_premium.gif',1,NULL,NULL),
('CS2_162','Lord of the Arena','Minion',6,6,5,'Neutral',NULL,'Taunt','Taunt','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_162.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_162_premium.gif',1,NULL,NULL),
('CS2_213','Reckless Rocketeer','Minion',6,5,2,'Neutral',NULL,'Charge','Charge','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_213.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_213_premium.gif',1,NULL,NULL),
('CS2_201','Core Hound','Minion',7,9,5,'Neutral','Beast',NULL,NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_201.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_201_premium.gif',0,NULL,NULL),
('CS2_088','Guardian of Kings','Minion',7,5,6,'Paladin',NULL,'Battlecry','Battlecry: Restore 6 Health to your hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_088.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_088_premium.gif',1,NULL,NULL),
('CS2_222','Stormwind Champion','Minion',7,6,6,'Neutral',NULL,'Aura','Your other minions have +1/+1.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_222.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_222_premium.gif',1,NULL,NULL),
('CS2_186','War Golem','Minion',7,7,7,'Neutral',NULL,NULL,NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_186.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_186_premium.gif',0,NULL,NULL);

/*Table structure for table `playabledeck` */

DROP TABLE IF EXISTS `playabledeck`;

CREATE TABLE `playabledeck` (
  `deckName` varchar(60) DEFAULT NULL,
  `hero` varchar(60) DEFAULT NULL,
  `heroPower` varchar(60) DEFAULT NULL,
  `card1` varchar(60) DEFAULT NULL,
  `card2` varchar(60) DEFAULT NULL,
  `card3` varchar(60) DEFAULT NULL,
  `card4` varchar(60) DEFAULT NULL,
  `card5` varchar(60) DEFAULT NULL,
  `card6` varchar(60) DEFAULT NULL,
  `card7` varchar(60) DEFAULT NULL,
  `card8` varchar(60) DEFAULT NULL,
  `card9` varchar(60) DEFAULT NULL,
  `card10` varchar(60) DEFAULT NULL,
  `card11` varchar(60) DEFAULT NULL,
  `card12` varchar(60) DEFAULT NULL,
  `card13` varchar(60) DEFAULT NULL,
  `card14` varchar(60) DEFAULT NULL,
  `card15` varchar(60) DEFAULT NULL,
  `card16` varchar(60) DEFAULT NULL,
  `card17` varchar(60) DEFAULT NULL,
  `card18` varchar(60) DEFAULT NULL,
  `card19` varchar(60) DEFAULT NULL,
  `card20` varchar(60) DEFAULT NULL,
  `card21` varchar(60) DEFAULT NULL,
  `card22` varchar(60) DEFAULT NULL,
  `card23` varchar(60) DEFAULT NULL,
  `card24` varchar(60) DEFAULT NULL,
  `card25` varchar(60) DEFAULT NULL,
  `card26` varchar(60) DEFAULT NULL,
  `card27` varchar(60) DEFAULT NULL,
  `card28` varchar(60) DEFAULT NULL,
  `card29` varchar(60) DEFAULT NULL,
  `card30` varchar(60) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `playabledeck` */

/*Table structure for table `spells` */

DROP TABLE IF EXISTS `spells`;

CREATE TABLE `spells` (
  `cardId` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(18) CHARACTER SET utf8 DEFAULT NULL,
  `type` varchar(5) CHARACTER SET utf8 DEFAULT NULL,
  `mana` int(11) DEFAULT NULL,
  `heroType` varchar(7) CHARACTER SET utf8 DEFAULT NULL,
  `mechanicsName` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(76) CHARACTER SET utf8 DEFAULT NULL,
  `img` varchar(73) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `spells` */

insert  into `spells`(`cardId`,`name`,`type`,`mana`,`heroType`,`mechanicsName`,`description`,`img`) values 
('EX1_621','Circle of Healing','Spell',0,'Priest',NULL,'Restore #4 Health to ALL_minions.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_621.png'),
('EX1_607','Inner Rage','Spell',0,'Warrior',NULL,'Deal $1 damage to a minion and give it +2_Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_607.png'),
('EX1_332','Silence','Spell',0,'Priest','Silence','Silence a minion.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_332.png'),
('EX1_014t','Bananas','Spell',1,'Neutral',NULL,'Give a minion +1/+1.','http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_014t.png'),
('CS1_129','Inner Fire','Spell',1,'Priest',NULL,'Change a minion\'s Attack to be equal to its Health.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS1_129.png'),
('EX1_410','Shield Slam','Spell',1,'Warrior','AffectedBySpellPower','Deal 1 damage to a minion for each Armor you have.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_410.png'),
('EX1_392','Battle Rage','Spell',2,'Warrior',NULL,'Draw a card for each damaged friendly character.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_392.png'),
('EX1_619','Equality','Spell',2,'Paladin',NULL,'Change the Health of ALL minions to 1.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_619.png'),
('CS2_104','Rampage','Spell',2,'Warrior',NULL,'Give a damaged minion +3/+3.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_104.png'),
('EX1_617','Deadly Shot','Spell',3,'Hunter',NULL,'Destroy a random enemy minion.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_617.png'),
('EX1_349','Divine Favor','Spell',3,'Paladin',NULL,'Draw cards until you have as many in hand as your opponent.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_349.png'),
('EX1_317','Sense Demons','Spell',3,'Warlock',NULL,'Draw 2 Demons\nfrom your deck.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_317.png'),
('EX1_626','Mass Dispel','Spell',4,'Priest','Silence','Silence all enemy minions. Draw a card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_626.png'),
('EX1_303','Shadowflame','Spell',4,'Warlock','AffectedBySpellPower','Destroy a friendly minion and deal its Attack damage to all enemy minions.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_303.png'),
('EX1_355','Blessed Champion','Spell',5,'Paladin',NULL,'Double a minion\'s Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_355.png'),
('EX1_407','Brawl','Spell',5,'Warrior',NULL,'Destroy all minions except one. (chosen randomly)','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_407.png'),
('EX1_537','Explosive Shot','Spell',5,'Hunter',NULL,'Deal $5 damage to a minion and $2 damage to adjacent ones.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_537.png'),
('EX1_365','Holy Wrath','Spell',5,'Paladin','AffectedBySpellPower','Draw a card and deal_damage equal to_its Cost.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_365.png'),
('EX1_384','Avenging Wrath','Spell',6,'Paladin','ImmuneToSpellpower','Deal $8 damage randomly split among all enemies.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_384.png'),
('EX1_624','Holy Fire','Spell',6,'Priest',NULL,'Deal $5 damage. Restore #5 Health to your hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_624.png'),
('EX1_309','Siphon Soul','Spell',6,'Warlock',NULL,'Destroy a minion. Restore #3 Health to_your hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_309.png'),
('EX1_354','Lay on Hands','Spell',8,'Paladin',NULL,'Restore #8 Health. Draw_3 cards.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_354.png'),
('EX1_312','Twisting Nether','Spell',8,'Warlock',NULL,'Destroy all minions.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_312.png'),
('EX1_279','Pyroblast','Spell',10,'Mage',NULL,'Deal $10 damage.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_279.png'),
('NEW1_003','Sacrificial Pact','Spell',0,'Warlock',NULL,'Destroy a Demon. Restore #5 Health to your hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/NEW1_003.png'),
('GAME_005','The Coin','Spell',0,'Neutral',NULL,'Gain 1 Mana Crystal this turn only.','http://wow.zamimg.com/images/hearthstone/cards/enus/original/GAME_005.png'),
('EX1_277','Arcane Missiles','Spell',1,'Mage','ImmuneToSpellpower','Deal $3 damage randomly split among all enemies.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_277.png'),
('DS1_185','Arcane Shot','Spell',1,'Hunter',NULL,'Deal $2 damage.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_185.png'),
('CS2_087','Blessing of Might','Spell',1,'Paladin',NULL,'Give a minion +3_Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_087.png'),
('EX1_371','Hand of Protection','Spell',1,'Paladin','Divine Shield','Give a minion Divine Shield.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_371.png'),
('CS1_130','Holy Smite','Spell',1,'Priest',NULL,'Deal $2 damage.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS1_130.png'),
('EX1_360','Humility','Spell',1,'Paladin',NULL,'Change a minion\'s Attack to 1.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_360.png'),
('CS2_084','Hunter\'s Mark','Spell',1,'Hunter',NULL,'Change a minion\'s Health to 1.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_084.png'),
('CS2_004','Power Word: Shield','Spell',1,'Priest',NULL,'Give a minion +2_Health.\nDraw a card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_004.png'),
('EX1_400','Whirlwind','Spell',1,'Warrior',NULL,'Deal $1 damage to ALL_minions.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_400.png'),
('CS2_025','Arcane Explosion','Spell',2,'Mage',NULL,'Deal $1 damage to all enemy minions.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_025.png'),
('CS2_114','Cleave','Spell',2,'Warrior',NULL,'[x]Deal $2 damage to\ntwo random enemy\nminions.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_114.png'),
('CS2_236','Divine Spirit','Spell',2,'Priest',NULL,'Double a minion\'s Health.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_236.png'),
('CS2_108','Execute','Spell',2,'Warrior',NULL,'Destroy a damaged enemy minion.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_108.png'),
('CS2_105','Heroic Strike','Spell',2,'Warrior',NULL,'Give your hero +4_Attack this turn.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_105.png'),
('CS2_089','Holy Light','Spell',2,'Paladin',NULL,'Restore #6 Health.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_089.png'),
('DS1_233','Mind Blast','Spell',2,'Priest',NULL,'Deal $5 damage to the enemy hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_233.png'),
('CS2_234','Shadow Word: Pain','Spell',2,'Priest',NULL,'Destroy a minion with 3_or less Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_234.png'),
('CS2_023','Arcane Intellect','Spell',3,'Mage',NULL,'Draw 2 cards.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_023.png'),
('CS2_061','Drain Life','Spell',3,'Warlock',NULL,'Deal $2 damage. Restore #2 Health to your hero.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_061.png'),
('CS2_057','Shadow Bolt','Spell',3,'Warlock',NULL,'Deal $4 damage\nto a minion.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_057.png'),
('EX1_622','Shadow Word: Death','Spell',3,'Priest',NULL,'Destroy a minion with 5_or more Attack.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_622.png'),
('EX1_606','Shield Block','Spell',3,'Warrior',NULL,'Gain 5 Armor.\nDraw a card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_606.png'),
('CS2_092','Blessing of Kings','Spell',4,'Paladin',NULL,'Give a minion +4/+4. (+4 Attack/+4 Health)','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_092.png'),
('CS2_093','Consecration','Spell',4,'Paladin',NULL,'Deal $2 damage to all_enemies.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_093.png'),
('CS2_029','Fireball','Spell',4,'Mage',NULL,'Deal $6 damage.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_029.png'),
('CS2_094','Hammer of Wrath','Spell',4,'Paladin',NULL,'Deal $3 damage.\nDraw a card.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_094.png'),
('CS2_062','Hellfire','Spell',4,'Warlock',NULL,'Deal $3 damage to ALL_characters.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_062.png'),
('DS1_183','Multi-Shot','Spell',4,'Hunter',NULL,'Deal $3 damage to two random enemy minions.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/DS1_183.png'),
('CS2_022','Polymorph','Spell',4,'Mage',NULL,'Transform a minion\ninto a 1/1 Sheep.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_022.png'),
('CS1_112','Holy Nova','Spell',5,'Priest',NULL,'Deal $2 damage to all enemies. Restore #2_Health to all friendly characters.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS1_112.png'),
('CS2_032','Flamestrike','Spell',7,'Mage',NULL,'Deal $4 damage to all enemy minions.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_032.png');

/*Table structure for table `weapons` */

DROP TABLE IF EXISTS `weapons`;

CREATE TABLE `weapons` (
  `cardId` varchar(8) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(17) CHARACTER SET utf8 DEFAULT NULL,
  `type` varchar(6) CHARACTER SET utf8 DEFAULT NULL,
  `mana` int(11) DEFAULT NULL,
  `attack` int(11) DEFAULT NULL,
  `durability` int(11) DEFAULT NULL,
  `heroType` varchar(7) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(58) CHARACTER SET utf8 DEFAULT NULL,
  `img` varchar(73) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `weapons` */

insert  into `weapons`(`cardId`,`name`,`type`,`mana`,`attack`,`durability`,`heroType`,`description`,`img`) values 
('EX1_398t','Battle Axe','Weapon',1,2,2,'Warrior',NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_398t.png'),
('EX1_409t','Heavy Axe','Weapon',1,1,3,'Warrior',NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_409t.png'),
('EX1_323w','Blood Fury','Weapon',3,3,8,'Warlock',NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_323w.png'),
('EX1_383t','Ashbringer','Weapon',5,5,3,'Paladin',NULL,'http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_383t.png'),
('EX1_411','Gorehowl','Weapon',7,7,1,'Warrior','Attacking a minion costs 1 Attack instead of 1 Durability.','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_411.png'),
('CS2_091','Light\'s Justice','Weapon',1,1,4,'Paladin',NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_091.png'),
('BCON_026','Blazing Longsword','Weapon',3,2,3,'Warrior','Also damages minions next to whomever your hero attacks.','http://wow.zamimg.com/images/hearthstone/cards/enus/original/BCON_026.png'),
('CS2_106','Fiery War Axe','Weapon',3,3,2,'Warrior',NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_106.png'),
('CS2_112','Arcanite Reaper','Weapon',5,5,2,'Warrior',NULL,'http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_112.png');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
