create table owner (
	id int primary key,
	name varchar(255),
	rules date
);

create table cars(
	id int primary key,
	model varchar(255),
	number int,
	owner_id int references owner(id)
);

insert into owner(id, name, rules) values(1, 'Ivan', '2010.02.03');
insert into owner(id, name, rules) values(2, 'Sergey', '2019.02.03');

insert into cars(id, model, number, owner_id) values(1, 'Niva', 1234, 1);
insert into cars(id, model, number, owner_id) values(2, '2109', 342245, 1);
insert into cars(id, model, number, owner_id) values(3, 'Priora', 33443113, 2);
insert into cars(id, model, number, owner_id) values(4, 'Kalina', 11234455, 2);

select * from cars
join owner on cars.owner_id = owner.id;

select model, owner_id, name, rules from cars
join owner on cars.owner_id = owner.id;

select c.model, c.owner_id, o.name from cars as c
join owner as o on c.owner_id = o.id;

select c.model as Моель, c.owner_id Владелец, o.name Имя from cars as c
join owner as o on c.owner_id = o.id;