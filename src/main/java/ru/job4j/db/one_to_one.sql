create table detail(
	id int primary key,
	name varchar(255)
);

create table factory_num(
	id int primary key,
	name varchar(255)
);

create table autoshop(
	id int primary key,
	detail_id int references detail(id) unique,i
	factory_num_id int references factory_num(id) unique
);


insert into detail (id, name) values (1,'engine');
insert into detail (id, name) values (2,'transmission');
insert into detail (id, name) values (3, 'clutch');

insert into factory_num (id, name) values(1, '123456');
insert into factory_num (id, name) values(2, '234556');
insert into factory_num (id, name) values(3, '3456643');

insert into autoshop(id, detail_id, factory_num_id) values (1, 1, 1);
insert into autoshop(id, detail_id, factory_num_id) values (2, 2, 2);
insert into autoshop(id, detail_id, factory_num_id) values (3, 3, 3);

select * from autoshop;