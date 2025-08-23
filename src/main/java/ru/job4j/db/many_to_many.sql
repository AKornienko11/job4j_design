create table byer (
	id serial primary key,
	name varchar(255)
);

create table products (
	id serial primary key,
	name varchar(255)
);

create table shop (
	id serial primary key,
	byer_id int references products(id),
	products_id int references byer(id)
);

insert into byer(name) values ('Ivan');
insert into byer(name) values ('Fedor');
insert into byer(name) values ('Mariya');

insert into products(name) values ('Meat');
insert into products(name) values('Milk');
insert into products(name) values('Bread');

insert into shop (byer_id, products_id) values (1, 1);
insert into shop (byer_id, products_id) values (1, 2);
insert into shop (byer_id, products_id) values (1, 3);
insert into shop (byer_id, products_id) values (2, 2);
insert into shop (byer_id, products_id) values (2, 3);
insert into shop (byer_id, products_id) values (3, 3);

select * from shop;