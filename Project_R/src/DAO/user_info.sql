
create table user_info
as select * from user;

select num,id,pwd,name,age from user
order by name desc;

select count(*) from user_info;

select sum(age), avg(age), count(1) from user;

drop table user_info;

create table user_info(
num int(7) auto_increment primary key,
id varchar(30) not null,
pwd varchar(30) not null,
name varchar(30) not null,
age in(3) not null);

alter table user_info
add column class_num int(5) not null;

create table class_info(
class_num int(5) auto_increment primary key,
class_name varchar(100) not null);

select * from class_info;