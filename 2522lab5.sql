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
  `genre` varchar(29) NOT NULL,
  `dateOfBirth` date NOT NULL,
  `dateOfDeath` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `author`
--

LOCK TABLES `author` WRITE;
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` VALUES
(1,'Saul','Bellow','Literary Fiction','1915-06-10','2005-04-05'),
(2,'Robert','Penn Warren','Southern Literature','1905-04-24','1989-09-15'),
(3,'Philip','Roth','Postmodern Fiction','1933-03-19','2018-05-22'),
(4,'Theodore','Dreiser','Naturalism','1871-08-27','1945-12-28'),
(5,'George','Orwell','Dystopian Fiction','1903-06-25','1950-01-21'),
(6,'John','O\'Hara','Realism','1905-01-31','1970-04-11'),
(7,'Judy','Blume','Young Adult Fiction','1938-02-12',NULL),
(8,'Bernard','Malamud','Jewish American Literature','1914-04-26','1986-03-18'),
(9,'Flann','O\'Brien','Satire','1911-10-05','1966-04-01'),
(10,'Ian','McEwan','Literary Fiction','1948-06-21',NULL),
(11,'Toni','Morrison','African American Literature','1931-02-18','2019-08-05'),
(12,'Christopher','Isherwood','Modernism','1904-08-26','1986-01-04'),
(13,'Raymond','Chandler','Hardboiled Fiction','1888-07-23','1959-03-26'),
(14,'Margaret','Atwood','Speculative Fiction','1939-11-18',NULL),
(15,'Cormac','McCarthy','Southern Gothic','1933-07-20','2023-06-13'),
(16,'Evelyn','Waugh','Satire','1903-10-28','1966-04-10'),
(17,'Thornton','Wilder','Drama','1897-04-17','1975-12-07'),
(18,'Henry','Roth','Modernism','1906-02-08','1995-10-13'),
(19,'Joseph','Heller','Satire','1923-05-01','1999-12-12'),
(20,'J.D.','Salinger','Literary Fiction','1919-01-01','2010-01-27'),
(21,'Anthony','Burgess','Dystopian Fiction','1917-02-25','1993-11-25'),
(22,'William','Styron','Southern Gothic','1925-06-11','2006-11-01'),
(23,'Jonathan','Franzen','Literary Fiction','1959-08-17',NULL),
(24,'Thomas','Pynchon','Postmodern Fiction','1937-05-08',NULL),
(25,'Anthony','Powell','Satire','1905-12-21','2000-03-28'),
(26,'Nathanael','West','Black Comedy','1903-10-17','1940-12-22'),
(27,'Willa','Cather','Regionalism','1873-12-07','1947-04-24'),
(28,'James','Agee','Journalism','1909-11-27','1955-05-16'),
(29,'Elizabeth','Bowen','Modernism','1899-06-07','1973-02-22'),
(30,'James','Dickey','Poetry','1923-02-02','1997-01-19'),
(31,'Robert','Stone','Literary Fiction','1937-08-21','2015-01-10'),
(32,'John','Cheever','Short Stories','1912-05-27','1982-06-18'),
(33,'John','Fowles','Postmodern Fiction','1926-03-31','2005-11-05'),
(34,'Doris','Lessing','Feminist Literature','1919-10-22','2013-11-17'),
(35,'James','Baldwin','African American Literature','1924-08-02','1987-12-01'),
(36,'Margaret','Mitchell','Historical Fiction','1900-11-08','1949-08-16'),
(37,'John','Steinbeck','Realism','1902-02-27','1968-12-20'),
(38,'F. Scott','Fitzgerald','Modernism','1896-09-24','1940-12-21'),
(39,'Carson','McCullers','Southern Gothic','1917-02-19','1967-09-29'),
(40,'Graham','Greene','Thriller','1904-10-02','1991-04-03'),
(41,'Marilynne','Robinson','Literary Fiction','1943-11-26',NULL),
(42,'V.S.','Naipaul','Postcolonial Literature','1932-08-17','2018-08-11'),
(43,'Robert','Graves','Historical Fiction','1895-07-24','1985-12-07'),
(44,'David Foster','Wallace','Postmodern Fiction','1962-02-21','2008-09-12'),
(45,'Ralph','Ellison','African American Literature','1914-03-01','1994-04-16'),
(46,'William','Faulkner','Southern Gothic','1897-09-25','1962-07-06'),
(47,'C.S.','Lewis','Fantasy','1898-11-29','1963-11-22'),
(48,'Vladimir','Nabokov','Modernism','1899-04-22','1977-07-02'),
(49,'William','Golding','Allegory','1911-09-19','1993-06-19'),
(50,'J.R.R.','Tolkien','Fantasy','1892-01-03','1973-09-02'),
(51,'Henry','Green','Modernism','1905-10-29','1973-12-13'),
(52,'Kingsley','Amis','Satire','1922-04-16','1995-10-22'),
(53,'Christina','Stead','Realism','1902-07-17','1983-03-31'),
(54,'Salman','Rushdie','Magical Realism','1947-06-19',NULL),
(55,'Martin','Amis','Satire','1949-08-25',NULL),
(56,'Walker','Percy','Southern Gothic','1916-05-28','1990-05-10'),
(57,'Virginia','Woolf','Modernism','1882-01-25','1941-03-28'),
(58,'William','Burroughs','Beat Generation','1914-02-05','1997-08-02'),
(59,'Richard','Wright','African American Literature','1908-09-04','1960-11-28'),
(60,'William','Gibson','Cyberpunk','1948-03-17',NULL),
(61,'Kazuo','Ishiguro','Literary Fiction','1954-11-08',NULL),
(62,'Jack','Kerouac','Beat Generation','1922-03-12','1969-10-21'),
(63,'Ken','Kesey','Counterculture','1935-09-17','2001-11-10'),
(64,'Jerzy','Kosinski','Psychological Fiction','1933-06-14','1991-05-03'),
(65,'E.M.','Forster','Modernism','1879-01-01','1970-06-07'),
(66,'Joan','Didion','Journalism','1934-12-05','2021-12-23'),
(67,'A.S.','Byatt','Literary Fiction','1936-08-24',NULL),
(68,'Muriel','Spark','Satire','1918-02-01','2006-04-13'),
(69,'John','Updike','Literary Fiction','1932-03-18','2009-01-27'),
(70,'E.L.','Doctorow','Historical Fiction','1931-01-06','2015-07-21'),
(71,'William','Gaddis','Postmodern Fiction','1922-12-29','1998-12-16'),
(72,'Dashiell','Hammett','Hardboiled Fiction','1894-05-27','1961-01-10'),
(73,'Richard','Yates','Realism','1926-02-03','1992-11-07'),
(74,'Paul','Bowles','Existentialism','1910-12-30','1999-11-18'),
(75,'Kurt','Vonnegut','Satire','1922-11-11','2007-04-11'),
(76,'Neal','Stephenson','Science Fiction','1959-10-31',NULL),
(77,'John','Barth','Postmodern Fiction','1930-05-27',NULL),
(78,'Richard','Ford','Literary Fiction','1944-02-16',NULL),
(79,'John','le Carré','Spy Fiction','1931-10-19','2020-12-12'),
(80,'Ernest','Hemingway','Modernism','1899-07-21','1961-07-02'),
(81,'Zora Neale','Hurston','African American Literature','1891-01-07','1960-01-28'),
(82,'Chinua','Achebe','Postcolonial Literature','1930-11-16','2013-03-21'),
(83,'Harper','Lee','Southern Gothic','1926-04-28','2016-02-19'),
(84,'Henry','Miller','Modernism','1891-12-26','1980-06-07'),
(85,'Philip K.','Dick','Science Fiction','1928-12-16','1982-03-02'),
(86,'Iris','Murdoch','Philosophical Fiction','1919-07-15','1999-02-08'),
(87,'Malcolm','Lowry','Modernism','1909-07-28','1957-06-27'),
(88,'Alan','Moore','Graphic Novels','1953-11-18',NULL),
(89,'Don','DeLillo','Postmodern Fiction','1936-11-20',NULL),
(90,'Zadie','Smith','Literary Fiction','1975-10-25',NULL),
(91,'Jean','Rhys','Modernism','1890-08-24','1979-05-14');
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
(1,'The Adventures of Augie March',1,1953),
(2,'All the King\'s Men',2,1946),
(3,'American Pastoral',3,1997),
(4,'An American Tragedy',4,1925),
(5,'Animal Farm',5,1946),
(6,'Appointment in Samarra',6,1934),
(7,'Are You There God? It\'s Me, Margaret.',7,1970),
(8,'The Assistant',8,1957),
(9,'At Swim-Two-Birds',9,1938),
(10,'Atonement',10,2002),
(11,'Beloved',11,1987),
(12,'The Berlin Stories',12,1946),
(13,'The Big Sleep',13,1939),
(14,'The Blind Assassin',14,2000),
(15,'Blood Meridian',15,1986),
(16,'Brideshead Revisited',16,1946),
(17,'The Bridge of San Luis Rey',17,1927),
(18,'Call It Sleep',18,1935),
(19,'Catch-22',19,1961),
(20,'The Catcher in the Rye',20,1951),
(21,'A Clockwork Orange',21,1963),
(22,'The Confessions of Nat Turner',22,1967),
(23,'The Corrections',23,2001),
(24,'The Crying of Lot 49',24,1966),
(25,'A Dance to the Music of Time',25,1951),
(26,'The Day of the Locust',26,1939),
(27,'Death Comes for the Archbishop',27,1927),
(28,'A Death in the Family',28,1958),
(29,'The Death of the Heart',29,1958),
(30,'Deliverance',30,1970),
(31,'Dog Soldiers',31,1974),
(32,'Falconer',32,1977),
(33,'The French Lieutenant\'s Woman',33,1969),
(34,'The Golden Notebook',34,1962),
(35,'Go Tell It on the Mountain',35,1953),
(36,'Gone with the Wind',36,1936),
(37,'The Grapes of Wrath',37,1939),
(38,'Gravity\'s Rainbow',24,1973),
(39,'The Great Gatsby',38,1925),
(40,'A Handful of Dust',16,1934),
(41,'The Heart Is a Lonely Hunter',39,1940),
(42,'The Heart of the Matter',40,1948),
(43,'Herzog',1,1964),
(44,'Housekeeping',41,1981),
(45,'A House for Mr. Biswas',42,1962),
(46,'I, Claudius',43,1934),
(47,'Infinite Jest',44,1996),
(48,'Invisible Man',45,1952),
(49,'Light in August',46,1932),
(50,'The Lion, The Witch and the Wardrobe',47,1950),
(51,'Lolita',48,1955),
(52,'Lord of the Flies',49,1954),
(53,'The Lord of the Rings',50,1954),
(54,'Loving',51,1945),
(55,'Lucky Jim',52,1954),
(56,'The Man Who Loved Children',53,1940),
(57,'Midnight\'s Children',54,1981),
(58,'Money',55,1984),
(59,'The Moviegoer',56,1961),
(60,'Mrs. Dalloway',57,1925),
(61,'Naked Lunch',58,1959),
(62,'Native Son',59,1940),
(63,'Neuromancer',60,1984),
(64,'Never Let Me Go',61,2005),
(65,'1984',5,1948),
(66,'On the Road',62,1957),
(67,'One Flew Over the Cuckoo\'s Nest',63,1962),
(68,'The Painted Bird',64,1965),
(69,'Pale Fire',48,1962),
(70,'A Passage to India',65,1924),
(71,'Play It as It Lays',66,1970),
(72,'Portnoy\'s Complaint',3,1969),
(73,'Possession',67,1990),
(74,'The Power and the Glory',40,1939),
(75,'The Prime of Miss Jean Brodie',68,1961),
(76,'Rabbit, Run',69,1960),
(77,'Ragtime',70,1975),
(78,'The Recognitions',71,1955),
(79,'Red Harvest',72,1929),
(80,'Revolutionary Road',73,1961),
(81,'The Sheltering Sky',74,1949),
(82,'Slaughterhouse-Five',75,1969),
(83,'Snow Crash',76,1992),
(84,'The Sot-Weed Factor',77,1960),
(85,'The Sound and the Fury',46,1929),
(86,'The Sportswriter',78,1986),
(87,'The Spy Who Came in from the Cold',79,1964),
(88,'The Sun Also Rises',80,1926),
(89,'Their Eyes Were Watching God',81,1937),
(90,'Things Fall Apart',82,1959),
(91,'To Kill a Mockingbird',83,1960),
(92,'To the Lighthouse',57,1929),
(93,'Tropic of Cancer',84,1934),
(94,'Ubik',85,1969),
(95,'Under the Net',86,1954),
(96,'Under the Volcano',87,1947),
(97,'Watchmen',88,1986),
(98,'White Noise',89,1985),
(99,'White Teeth',90,2000),
(100,'Wide Sargasso Sea',91,1966);
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

-- Dump completed on 2025-02-13 13:24:32
