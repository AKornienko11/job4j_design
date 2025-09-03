create table type (
	id int primary key,
	name varchar(255)
);

create table product(
	id int primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date date,
	price float
);

insert into type (id, name) values (1, 'Сыр'), (2, 'Молоко'), (3, 'Мороженое'), (4, 'Яйцо');


insert into product(id, name, type_id, expired_date, price) values
(1, 'Пармизан', 1, '2025.09.10', 400.0),
(2, 'Маасдам', 1, '2025.09.30', 450.0),
(3, 'Российский', 1, '2025.09.20', 250.0),
(4, 'Молоко 1%', 2, '2025.09.01', 150.0),
(5, 'Молоко 2%', 2, '2025.09.15', 170.0),
(6, 'Молоко 3,2%', 2, '2025.09.18', 190.0),
(7, ' Мороженое_Эскимо', 3, '2025.08.30', 150.0),
(8, 'Пломбир', 3, '2025.09.22', 200.0),
(9, 'Мороженое_Ежик', 3, '2025.09.27', 90.0),
(10, 'Яйцо куриное С0', 4, '2025.09.29', 119.0),
(11, 'Яйцо куриное С1', 4, '2025.09.19', 107.0),
(12, 'Яйцо Перепелиное', 4, '2025.08.20', 167.0);
(13, 'Яйцо Страуса', 4, '2025.09.23', 450.0);

select t.name, p.name from product as p
join type as t on p.type_id = t.id
where t.name = 'Сыр';

select * from product where  name like '%Мороженое%';

select * from product where  expired_date < current_date;

select name, price from product where price = (select max(price) from product);

select t.name, count(*) from product as p
join type as t on p.type_id = t.id
group by t.name;

select t.name, p.name from product as p
join type as t on p.type_id = t.id
where t.name = 'Сыр' or t.name ='Молоко';

select t.name, count(*) from product as p
join type as t on p.type_id = t.id
group by t.name
having count(*) < 10;

select p.name, t.name from product as p
join type as t on p.type_id = t.id;