delimiter $$ 
CREATE PROCEDURE p_insert_goods_info(IN loop_cnt int(1))
BEGIN
	DECLARE i INT DEFAULT 0;

	/* 만약 SQL에러라면 ROLLBACK 처리한다. */
	DECLARE exit handler for SQLEXCEPTION
	BEGIN
		ROLLBACK;        
	END;
	/* 트랜젝션 시작 */
	START TRANSACTION;
	WHILE (i <= loop_cnt) DO
        INSERT INTO goods_info(giname,gidesc, vinum, gicredat,gicretim)
        VALUES (concat('giname',i), concat('gidesc', i), 1, 
		  DATE_FORMAT(NOW(),'%Y%m%d'), DATE_FORMAT(NOW(),'%H%i%s'));
        SET i = i + 1;
    END WHILE;
	/* 커밋 */
	COMMIT;
END
$$ 

call p_insert_goods_info(1000);

drop procedure p_insert_goods_info;