create table buyers (
 	id int primary key,
	name varchar(255)
);

create table genres(
	id int primary key,
	name varchar(255)
);

create table films(
	id int primary key,
	name varchar(255),
	price float,
	genre_id int references genres(id)
);

create table orders(
	id int primary key,
	number int,
	buyer_id int references buyers(id),
	film_id int references films(id)
);

insert into buyers (id, name) values (1, 'Ivan'), (2, 'Sergey'), (3, 'Nikolay'),(4, 'Vera'),(5, 'Tatyana');
insert into genres (id, name) values (1, 'Triller'), (2, 'Comedy'), (3, 'Fantastic'), (4, 'Action'), (5, 'Melodrama');
insert into films(id, name, price, gener_id) values (1, 'The Silence of the Lambs', 200, 1),
(2, 'Home Alone,', 150, 2), (3, 'Harry Potter', 300, 3), (4, 'Terminator', 300, 4),
(5, 'Harry Potter', 100, 5),

insert into buyers (id, name) values (1, 'Ivan'), (2, 'Sergey'), (3, 'Nikolay'),(4, 'Vera'),(5, 'Tatyana');
insert into genres (id, name) values (1, 'Triller'), (2, 'Comedy'), (3, 'Fantastic'), (4, 'Action'), (5, 'Melodrama');
insert into films(id, name, price, genre_id) values (1, 'The Silence of the Lambs', 200, 1),
(2, 'Home Alone', 150, 2), (3, 'Harry Potter', 300, 3), (4, 'Terminator', 400, 4),
(5, 'Gone with the Wind', 100, 5);
insert into orders (id, number, buyer_id, film_id) values
(1, 24, 1, 1), (2, 25, 1, 4), (3, 26, 1, 3), (4, 27, 2, 4), (5, 28, 2, 1),
(6, 29, 3, 4), (7, 30, 3, 2), (8, 31, 3, 1), (9, 32, 3, 3), (10, 33, 4, 4),
(11, 34, 4, 5), (12, 35, 5, 5);

create view maximum_revenue as
select g.name as Жанр, sum(f.price) as Максимальная_выручка  from orders as o
join buyers as b on o.buyer_id = b.id
join films as f on o.film_id = f.id
join genres as g on f.genre_id = g.id
group by (g.name)
having sum(f.price) = (select max(sum) from (select  fil.name, sum(fil.price) from orders as ord
join films fil on ord.film_id = fil.id
group by fil.name)) ;

select * from maximum_revenue;