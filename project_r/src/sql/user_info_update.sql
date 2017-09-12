DROP TABLE IF EXISTS `user_info`;
CREATE TABLE IF NOT EXISTS `user_info` (
  `usernum` int(5) NOT NULL AUTO_INCREMENT,
  `userid` varchar(30) NOT NULL,
  `username` varchar(100) NOT NULL,
  `age` int(1) NOT NULL,
  `address` varchar(200) NOT NULL,
  `hp1` char(4) DEFAULT NULL,
  `hp2` char(4) DEFAULT NULL,
  `hp3` char(4) DEFAULT NULL,
  `userpwd` varchar(100) NOT NULL,
  `userrolelevel` char(2) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `departnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`usernum`),
  UNIQUE KEY `userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- 테이블 데이터 iot.user_info:~6 rows (대략적) 내보내기
DELETE FROM `user_info`;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` (`usernum`, `userid`, `username`, `age`, `address`, `hp1`, `hp2`, `hp3`, `userpwd`, `userrolelevel`, `gender`, `departnum`) VALUES
	(1, 'red', '홍길동', 30, '대한민국 인천시', '10', '892', '1023', 'red', '1', '0', NULL),
	(3, 'green', '녹길동', 123, '대한민국 부산시', '321', '123', '453', 'green', '10', '1', NULL),
	(4, 'blue', '청길동', 20, '대한민국 서울시', '123', '432', '1234', 'blue', '1', '1', NULL),
	(5, 'brown', '흙길동', 99, '대한민국 제주특별시', '789', '987', '4564', 'brown', '10', '1', NULL),
	(7, 'black', '흑길동', 951, '대한민국 독도', '4567', '7534', '6985', 'purple', '1', '0', NULL),
	(11, 'purple', '자길동', 75, '대한민국 마라도', '123', '7568', '8789', 'purple', '10', '0', NULL);