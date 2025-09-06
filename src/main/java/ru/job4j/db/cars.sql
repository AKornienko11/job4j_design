create table car_bodies (
	id int primary key,
	name varchar(255)
);

create table car_engines (
	id int primary key,
	name varchar(255)
);

create table car_transmissions (
	id int primary key,
	name varchar(255)
);

create table cars(
	id int primary key,
	name varchar(255),
	body_id int references car_bodies(id),
	engine_id int references car_engines(id),
	transmission_id int references car_transmissions(id)
);

insert into car_bodies(id, name) values (1, 'Sedan'), (2, 'Coup'), (3, 'Hatchback'), (4, 'Piсkup'), (5, 'Universal');
insert into car_engines(id, name) values (1, 'Electric engine'), (2, 'Petrol engine'), (3, 'Diesel engine'), (4, 'Hybrid engine'), (5, 'Hydrogen engine ');
insert into car_transmissions(id, name) values (1, 'Automatic transmission'), (2, 'Robot transmission'), (3, 'Mechanical transmission'), (4, 'CVC transmission');

insert into cars(id, name, body_id, engine_id, transmission_id) values (1, 'Nissan', 5, 1, null ), (2, 'BMW', 1, 2, 1 ),
(3, 'UAZ', 4, null, 3 ),
(4, 'Mazda', 3, 4, 2);

select c.name, cb.name, ce.name, ct.name from cars as c
left join car_bodies as cb on c.body_id = cb.id
left join  car_engines as ce on c.engine_id = ce.id
left join car_transmissions as ct on c.transmission_id = ct.id;

select  c.name, c.body_id, cb.name  from cars as c
right join car_bodies as cb on c.body_id = cb.id
where c.body_id is null;

select  c.name, c.engine_id, ce.name  from cars as c
right join  car_engines as ce on c.engine_id = ce.id
where c.engine_id is null;

select  c.name, c.transmission_id, ct.name  from cars as c
right join car_transmissions as ct on c.transmission_id = ct.id
where c.transmission_id is null;