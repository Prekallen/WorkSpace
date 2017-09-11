select * from user_info;


insert into user_info (id,pwd,name,age,class_num)
values ('lime','lime','하늘동',22,3);

select sum(age) from user_info;

show variables where
variable_name = 'general_log';

show variables where variable_name = 'autocommit';

select @@autocommit;

select @@version, @@general_log;



select * from tables
where table_schema='iot_test';

use iot_test2;

create table user_info(
user_num int(3) not null auto_increment primary key,
user_id varchar(30) not null,
user_name varchar(30) not null
);

alter table user_info
add unique index(user_id);

create table board(
board_num int(3) not null auto_increment,
board_title varchar(30) not null,
user_num int(3) not null,
primary key (board_num),
foreign key (user_num) references user_info(user_num)
);

delimiter $$
create procedure p_p_insert_user_infoinsert_user_info
(in loop_cnt int(1), out result int)
begin
	declare i int default 0;
	declare exit handler for sqlexception
		begin
			rollback;
			set result=-1;
		end;
		start transaction;
		while(i< loop_cnt) do
			insert into user_info(user_id, user_name)
			values (concat('test',i),concat('test',i));
			set i=i+1;
		end while;
		commit;
		set result = 0;
end$$
delimiter ;