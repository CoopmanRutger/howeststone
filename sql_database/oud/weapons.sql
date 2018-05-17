CREATE TABLE weapons (
    `list_cardId` VARCHAR(8) CHARACTER SET utf8,
    `list_dbfId` INT,
    `list_name` VARCHAR(17) CHARACTER SET utf8,
    `list_cardSet` VARCHAR(7) CHARACTER SET utf8,
    `list_type` VARCHAR(6) CHARACTER SET utf8,
    `list_cost` INT,
    `list_attack` INT,
    `list_durability` INT,
    `list_playerClass` VARCHAR(7) CHARACTER SET utf8,
    `list_img` VARCHAR(73) CHARACTER SET utf8,
    `list_imgGold` VARCHAR(88) CHARACTER SET utf8,
    `list_locale` VARCHAR(4) CHARACTER SET utf8,
    `list_elite` VARCHAR(4) CHARACTER SET utf8,
    `list_faction` VARCHAR(7) CHARACTER SET utf8,
    `list_rarity` VARCHAR(4) CHARACTER SET utf8,
    `list_text` VARCHAR(58) CHARACTER SET utf8,
    `list_flavor` VARCHAR(109) CHARACTER SET utf8,
    `list_artist` VARCHAR(15) CHARACTER SET utf8,
    `list_collectible` VARCHAR(4) CHARACTER SET utf8,
    `list_howToGet` VARCHAR(21) CHARACTER SET utf8,
    `list_howToGetGold` VARCHAR(21) CHARACTER SET utf8
);
INSERT INTO weapons VALUES ('EX1_398t',1707,'Battle Axe','Classic','Weapon',1,2,2,'Warrior','http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_398t.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/EX1_398t_premium.gif','enUS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO weapons VALUES ('EX1_409t',1661,'Heavy Axe','Classic','Weapon',1,1,3,'Warrior','http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_409t.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/EX1_409t_premium.gif','enUS',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO weapons VALUES ('EX1_323w',1660,'Blood Fury','Classic','Weapon',3,3,8,'Warlock','http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_323w.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/EX1_323w_premium.gif','enUS','True',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO weapons VALUES ('EX1_383t',1730,'Ashbringer','Classic','Weapon',5,5,3,'Paladin','http://wow.zamimg.com/images/hearthstone/cards/enus/original/EX1_383t.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/EX1_383t_premium.gif','enUS','True',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO weapons VALUES ('EX1_411',810,'Gorehowl','Classic','Weapon',7,7,1,'Warrior','http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_411.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_411_premium.gif','enUS',NULL,'Neutral','Epic','Attacking a minion costs 1 Attack instead of 1 Durability.','Grommash Hellscream''s famous axe. Somehow this ended up in Prince Malchezaar''s possession. Quite the mystery!','Zoltan & Gabor','True',NULL,NULL);
INSERT INTO weapons VALUES ('CS2_091',383,'Light''s Justice','Basic','Weapon',1,1,4,'Paladin','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_091.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_091_premium.gif','enUS',NULL,'Neutral','Free',NULL,'Prince Malchezaar was a collector of rare weapons. He''d animate them and have them dance for him.','Glenn Rane','True','Unlocked at Level 1.','Unlocked at Level 36.');
INSERT INTO weapons VALUES ('BCON_026',49251,'Blazing Longsword','Basic','Weapon',3,2,3,'Warrior','http://wow.zamimg.com/images/hearthstone/cards/enus/original/BCON_026.png','http://wow.zamimg.com/images/hearthstone/cards/enus/animated/BCON_026_premium.gif','enUS',NULL,NULL,'Free','Also damages minions next to whomever your hero attacks.',NULL,NULL,NULL,NULL,NULL);
INSERT INTO weapons VALUES ('CS2_106',401,'Fiery War Axe','Basic','Weapon',3,3,2,'Warrior','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_106.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_106_premium.gif','enUS',NULL,'Neutral','Free',NULL,'During times of tranquility and harmony, this weapon was called by its less popular name, Chilly Peace Axe.','Lucas Graciano','True','Unlocked at Level 1.','Unlocked at Level 49.');
INSERT INTO weapons VALUES ('CS2_112',304,'Arcanite Reaper','Basic','Weapon',5,5,2,'Warrior','http://media.services.zam.com/v1/media/byName/hs/cards/enus/CS2_112.png','http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/CS2_112_premium.gif','enUS',NULL,'Neutral','Free',NULL,'No… actually you should fear the Reaper.','Stefan Kopinski','True','Unlocked at Level 10.','Unlocked at Level 51.');
