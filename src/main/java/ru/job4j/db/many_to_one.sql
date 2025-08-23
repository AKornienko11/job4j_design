create table nationality(
	id serial primary key,
	name varchar(255)
);

create table person(
	id serial primary key,
	name varchar(255),
	position_id int references nationality(id)
);

insert into nationality(name) values('Russian');
insert into person (name, position_id) values ('Ivan', 1);
insert into person (name, position_id) values ('Petr', 1);
insert into person (name, position_id) values ('Aleksey', 1);

select * from person;
select * from nationality where id in (select position_id from person);