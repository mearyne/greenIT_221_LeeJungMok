create table custom (
custno number(6) not null primary key,
custname varchar2(20),
phone varchar2(13),
address varchar2(4),
joindate date default sysdate,
grade char(1),
city char(2)
);


insert into custom values(100001, '김행복', '010-1111-2222', 'sk', '20151202', 'A', '01');
insert into custom values(100002, '이축복', '010-1111-3333', 'sk', '20151202', 'B', '01');
insert into custom values(100003, '장믿음', '010-1111-4444', 'lg', '20151202', 'B', '30');
insert into custom values(100004, '최사랑', '010-1111-5555', 'kt', '20151202', 'A', '30');
insert into custom values(100005, '진평화', '010-1111-6666', 'sk', '20151202', 'B', '60');
insert into custom values(100006, '차공단', '010-1111-7777', 'lg', '20151202', 'C', '60');




create table customTrade (
custno number(6) not null,
salenol number(8) not null primary key,
pcost number(8),
amount number(4),
price number(8),
pcode varchar2(4),
sdate date
);

insert into customTrade values (100001, 20160001, 500, 5, 2500, 'A001', '20160101');
insert into customTrade values (100001, 20160002, 1000, 5, 4000, 'A002', '20160101');
insert into customTrade values (100001, 20160003, 500, 5, 1500, 'A008', '20160101');
insert into customTrade values (100002, 20160004, 2000, 5, 2000, 'A004', '20160102');
insert into customTrade values (100002, 20160005, 500, 5, 500, 'A001', '20160103');
insert into customTrade values (100003, 20160006, 1500, 5, 3000, 'A003', '20160103');
insert into customTrade values (100004, 20160007, 1000, 5, 1000, 'A001', '20160104');
insert into customTrade values (100004, 20160008, 300, 5,300, 'A005', '20160104');
insert into customTrade values (100004, 20160009, 600, 5, 600, 'A006', '20160104');
insert into customTrade values (100004, 20160010, 3000, 5, 3000, 'A007', '20160106');