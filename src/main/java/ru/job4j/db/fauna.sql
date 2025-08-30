create table fauna(
	id serial primary key,
	name text,
	avg_age int,
	discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values('chocolate_frog', 300,  '2020.01.09');
insert into fauna(name, avg_age, discovery_date) values('flying_couscous', 2000, '2022.03.07');
insert into fauna(name, avg_age, discovery_date) values('meerkat', 5000, '1930.01.10');
insert into fauna(name, avg_age, discovery_date) values('honey_badger', 3000, '1900.04.09');
insert into fauna(name, avg_age, discovery_date) values('Banana_cricket', 200, '2000.03.04');
insert into fauna(name, avg_age, discovery_date) values('kangaroo', 12500, '1850.09.08');
insert into fauna(name, avg_age, discovery_date) values('elephant', 12000, null);
insert into fauna(name, avg_age, discovery_date) values('nanohameleon', 100, '2010.03.07');
insert into fauna(name, avg_age, discovery_date) values('rhinoceros', 15000, null);
insert into fauna(name, avg_age, discovery_date) values('swordfish', 2000, '1920.01.09');

select * from fauna where name like '%fish%';
select * from fauna where avg_age > 10000 and avg_age < 20000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950.03.07';

