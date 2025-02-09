/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.6.2-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: 2522lab5
-- ------------------------------------------------------
-- Server version	11.6.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `author` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(49) NOT NULL,
  `lastName` varchar(49) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `dateOfDeath` date DEFAULT NULL,
  `genre` varchar(29) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `firstName` (`firstName`,`lastName`)
) ENGINE=InnoDB AUTO_INCREMENT=469 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES
(376,'Saul','Bellow','1915-06-10','2005-04-05','Literary Fiction'),
(377,'Robert','Penn Warren','1905-04-24','1989-09-15','Southern Literature'),
(378,'Philip','Roth','1933-03-19','2018-05-22','Postmodern Fiction'),
(379,'Theodore','Dreiser','1871-08-27','1945-12-28','Naturalism'),
(380,'George','Orwell','1903-06-25','1950-01-21','Dystopian Fiction'),
(381,'John','O\'Hara','1905-01-31','1970-04-11','Realism'),
(382,'Judy','Blume','1938-02-12',NULL,'Young Adult Fiction'),
(383,'Bernard','Malamud','1914-04-26','1986-03-18','Jewish American Literature'),
(384,'Flann','O\'Brien','1911-10-05','1966-04-01','Satire'),
(385,'Ian','McEwan','1948-06-21',NULL,'Literary Fiction'),
(386,'Toni','Morrison','1931-02-18','2019-08-05','African American Literature'),
(387,'Christopher','Isherwood','1904-08-26','1986-01-04','Modernism'),
(388,'Raymond','Chandler','1888-07-23','1959-03-26','Hardboiled Fiction'),
(389,'Margaret','Atwood','1939-11-18',NULL,'Speculative Fiction'),
(390,'Cormac','McCarthy','1933-07-20','2023-06-13','Southern Gothic'),
(391,'Evelyn','Waugh','1903-10-28','1966-04-10','Satire'),
(392,'Thornton','Wilder','1897-04-17','1975-12-07','Drama'),
(393,'Henry','Roth','1906-02-08','1995-10-13','Modernism'),
(394,'Joseph','Heller','1923-05-01','1999-12-12','Satire'),
(395,'J.D.','Salinger','1919-01-01','2010-01-27','Literary Fiction'),
(396,'Anthony','Burgess','1917-02-25','1993-11-25','Dystopian Fiction'),
(397,'William','Styron','1925-06-11','2006-11-01','Southern Gothic'),
(398,'Jonathan','Franzen','1959-08-17',NULL,'Literary Fiction'),
(399,'Thomas','Pynchon','1937-05-08',NULL,'Postmodern Fiction'),
(400,'Anthony','Powell','1905-12-21','2000-03-28','Satire'),
(401,'Nathanael','West','1903-10-17','1940-12-22','Black Comedy'),
(402,'Willa','Cather','1873-12-07','1947-04-24','Regionalism'),
(403,'James','Agee','1909-11-27','1955-05-16','Journalism'),
(404,'Elizabeth','Bowen','1899-06-07','1973-02-22','Modernism'),
(405,'James','Dickey','1923-02-02','1997-01-19','Poetry'),
(406,'Robert','Stone','1937-08-21','2015-01-10','Literary Fiction'),
(407,'John','Cheever','1912-05-27','1982-06-18','Short Stories'),
(408,'John','Fowles','1926-03-31','2005-11-05','Postmodern Fiction'),
(409,'Doris','Lessing','1919-10-22','2013-11-17','Feminist Literature'),
(410,'James','Baldwin','1924-08-02','1987-12-01','African American Literature'),
(411,'Margaret','Mitchell','1900-11-08','1949-08-16','Historical Fiction'),
(412,'John','Steinbeck','1902-02-27','1968-12-20','Realism'),
(413,'F. Scott','Fitzgerald','1896-09-24','1940-12-21','Modernism'),
(414,'Carson','McCullers','1917-02-19','1967-09-29','Southern Gothic'),
(415,'Graham','Greene','1904-10-02','1991-04-03','Thriller'),
(416,'Marilynne','Robinson','1943-11-26',NULL,'Literary Fiction'),
(417,'V.S.','Naipaul','1932-08-17','2018-08-11','Postcolonial Literature'),
(418,'Robert','Graves','1895-07-24','1985-12-07','Historical Fiction'),
(419,'David Foster','Wallace','1962-02-21','2008-09-12','Postmodern Fiction'),
(420,'Ralph','Ellison','1914-03-01','1994-04-16','African American Literature'),
(421,'William','Faulkner','1897-09-25','1962-07-06','Southern Gothic'),
(422,'C.S.','Lewis','1898-11-29','1963-11-22','Fantasy'),
(423,'Vladimir','Nabokov','1899-04-22','1977-07-02','Modernism'),
(424,'William','Golding','1911-09-19','1993-06-19','Allegory'),
(425,'J.R.R.','Tolkien','1892-01-03','1973-09-02','Fantasy'),
(426,'Henry','Green','1905-10-29','1973-12-13','Modernism'),
(427,'Kingsley','Amis','1922-04-16','1995-10-22','Satire'),
(428,'Christina','Stead','1902-07-17','1983-03-31','Realism'),
(429,'Salman','Rushdie','1947-06-19',NULL,'Magical Realism'),
(430,'Martin','Amis','1949-08-25',NULL,'Satire'),
(431,'Walker','Percy','1916-05-28','1990-05-10','Southern Gothic'),
(432,'Virginia','Woolf','1882-01-25','1941-03-28','Modernism'),
(433,'William','Burroughs','1914-02-05','1997-08-02','Beat Generation'),
(434,'Richard','Wright','1908-09-04','1960-11-28','African American Literature'),
(435,'William','Gibson','1948-03-17',NULL,'Cyberpunk'),
(436,'Kazuo','Ishiguro','1954-11-08',NULL,'Literary Fiction'),
(437,'Jack','Kerouac','1922-03-12','1969-10-21','Beat Generation'),
(438,'Ken','Kesey','1935-09-17','2001-11-10','Counterculture'),
(439,'Jerzy','Kosinski','1933-06-14','1991-05-03','Psychological Fiction'),
(440,'E.M.','Forster','1879-01-01','1970-06-07','Modernism'),
(441,'Joan','Didion','1934-12-05','2021-12-23','Journalism'),
(442,'A.S.','Byatt','1936-08-24',NULL,'Literary Fiction'),
(443,'Muriel','Spark','1918-02-01','2006-04-13','Satire'),
(444,'John','Updike','1932-03-18','2009-01-27','Literary Fiction'),
(445,'E.L.','Doctorow','1931-01-06','2015-07-21','Historical Fiction'),
(446,'William','Gaddis','1922-12-29','1998-12-16','Postmodern Fiction'),
(447,'Dashiell','Hammett','1894-05-27','1961-01-10','Hardboiled Fiction'),
(448,'Richard','Yates','1926-02-03','1992-11-07','Realism'),
(449,'Paul','Bowles','1910-12-30','1999-11-18','Existentialism'),
(450,'Kurt','Vonnegut','1922-11-11','2007-04-11','Satire'),
(451,'Neal','Stephenson','1959-10-31',NULL,'Science Fiction'),
(452,'John','Barth','1930-05-27',NULL,'Postmodern Fiction'),
(453,'Richard','Ford','1944-02-16',NULL,'Literary Fiction'),
(454,'John','le Carré','1931-10-19','2020-12-12','Spy Fiction'),
(455,'Ernest','Hemingway','1899-07-21','1961-07-02','Modernism'),
(456,'Zora Neale','Hurston','1891-01-07','1960-01-28','African American Literature'),
(457,'Chinua','Achebe','1930-11-16','2013-03-21','Postcolonial Literature'),
(458,'Harper','Lee','1926-04-28','2016-02-19','Southern Gothic'),
(459,'Henry','Miller','1891-12-26','1980-06-07','Modernism'),
(460,'Philip K.','Dick','1928-12-16','1982-03-02','Science Fiction'),
(461,'Iris','Murdoch','1919-07-15','1999-02-08','Philosophical Fiction'),
(462,'Malcolm','Lowry','1909-07-28','1957-06-27','Modernism'),
(463,'Alan','Moore','1953-11-18',NULL,'Graphic Novels'),
(464,'Don','DeLillo','1936-11-20',NULL,'Postmodern Fiction'),
(465,'Zadie','Smith','1975-10-25',NULL,'Literary Fiction'),
(466,'Jean','Rhys','1890-08-24','1979-05-14','Modernism');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` text NOT NULL,
  `author` int(11) NOT NULL,
  `yearPublished` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`) USING HASH,
  KEY `author` (`author`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`author`) REFERENCES `author` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES
(1,'The Adventures of Augie March',376,1953),
(2,'All the King\'s Men',377,1946),
(3,'American Pastoral',378,1997),
(4,'An American Tragedy',379,1925),
(5,'Animal Farm',380,1946),
(6,'Appointment in Samarra',381,1934),
(7,'Are You There God? It\'s Me, Margaret.',382,1970),
(8,'The Assistant',383,1957),
(9,'At Swim-Two-Birds',384,1938),
(10,'Atonement',385,2002),
(11,'Beloved',386,1987),
(12,'The Berlin Stories',387,1946),
(13,'The Big Sleep',388,1939),
(14,'The Blind Assassin',389,2000),
(15,'Blood Meridian',390,1986),
(16,'Brideshead Revisited',391,1946),
(17,'The Bridge of San Luis Rey',392,1927),
(18,'Call It Sleep',393,1935),
(19,'Catch-22',394,1961),
(20,'The Catcher in the Rye',395,1951),
(21,'A Clockwork Orange',396,1963),
(22,'The Confessions of Nat Turner',397,1967),
(23,'The Corrections',398,2001),
(24,'The Crying of Lot 49',399,1966),
(25,'A Dance to the Music of Time',400,1951),
(26,'The Day of the Locust',401,1939),
(27,'Death Comes for the Archbishop',402,1927),
(28,'A Death in the Family',403,1958),
(29,'The Death of the Heart',404,1958),
(30,'Deliverance',405,1970),
(31,'Dog Soldiers',406,1974),
(32,'Falconer',407,1977),
(33,'The French Lieutenant\'s Woman',408,1969),
(34,'The Golden Notebook',409,1962),
(35,'Go Tell It on the Mountain',410,1953),
(36,'Gone with the Wind',411,1936),
(37,'The Grapes of Wrath',412,1939),
(38,'Gravity\'s Rainbow',399,1973),
(39,'The Great Gatsby',413,1925),
(40,'A Handful of Dust',391,1934),
(41,'The Heart Is a Lonely Hunter',414,1940),
(42,'The Heart of the Matter',415,1948),
(43,'Herzog',376,1964),
(44,'Housekeeping',416,1981),
(45,'A House for Mr. Biswas',417,1962),
(46,'I, Claudius',418,1934),
(47,'Infinite Jest',419,1996),
(48,'Invisible Man',420,1952),
(49,'Light in August',421,1932),
(50,'The Lion, The Witch and the Wardrobe',422,1950),
(51,'Lolita',423,1955),
(52,'Lord of the Flies',424,1954),
(53,'The Lord of the Rings',425,1954),
(54,'Loving',426,1945),
(55,'Lucky Jim',427,1954),
(56,'The Man Who Loved Children',428,1940),
(57,'Midnight\'s Children',429,1981),
(58,'Money',430,1984),
(59,'The Moviegoer',431,1961),
(60,'Mrs. Dalloway',432,1925),
(61,'Naked Lunch',433,1959),
(62,'Native Son',434,1940),
(63,'Neuromancer',435,1984),
(64,'Never Let Me Go',436,2005),
(65,'1984',380,1948),
(66,'On the Road',437,1957),
(67,'One Flew Over the Cuckoo\'s Nest',438,1962),
(68,'The Painted Bird',439,1965),
(69,'Pale Fire',423,1962),
(70,'A Passage to India',440,1924),
(71,'Play It as It Lays',441,1970),
(72,'Portnoy\'s Complaint',378,1969),
(73,'Possession',442,1990),
(74,'The Power and the Glory',415,1939),
(75,'The Prime of Miss Jean Brodie',443,1961),
(76,'Rabbit, Run',444,1960),
(77,'Ragtime',445,1975),
(78,'The Recognitions',446,1955),
(79,'Red Harvest',447,1929),
(80,'Revolutionary Road',448,1961),
(81,'The Sheltering Sky',449,1949),
(82,'Slaughterhouse-Five',450,1969),
(83,'Snow Crash',451,1992),
(84,'The Sot-Weed Factor',452,1960),
(85,'The Sound and the Fury',421,1929),
(86,'The Sportswriter',453,1986),
(87,'The Spy Who Came in from the Cold',454,1964),
(88,'The Sun Also Rises',455,1926),
(89,'Their Eyes Were Watching God',456,1937),
(90,'Things Fall Apart',457,1959),
(91,'To Kill a Mockingbird',458,1960),
(92,'To the Lighthouse',432,1929),
(93,'Tropic of Cancer',459,1934),
(94,'Ubik',460,1969),
(95,'Under the Net',461,1954),
(96,'Under the Volcano',462,1947),
(97,'Watchmen',463,1986),
(98,'White Noise',464,1985),
(99,'White Teeth',465,2000),
(100,'Wide Sargasso Sea',466,1966);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-02-08 21:15:13
