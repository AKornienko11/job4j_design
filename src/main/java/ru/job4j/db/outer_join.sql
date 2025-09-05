create table departments(
	id int primary key,
	name varchar(255)
	);

create table employees(
	id int primary key,
	name varchar(255),
	department_id int references departments(id)
);

insert into departments(id, name) values (1, 'Financial') ,  (2, 'Legal'), (3,'Production'), (4,'Labor Protection');

insert into employees(id, name, department_id) values (1, 'Vasiliy', 1 ) , (2, 'Ivan', 2), (3, 'Nikolay', 3), (4, 'Elena', 1);


select * from employees e
left join departments d on e.department_id = d.id;

select * from employees e
right join departments d on e.department_id = d.id;

select * from employees e
full join departments d on e.department_id = d.id;

select * from employees e
cross join departments d;

select * from departments d
left join employees e on d.id = e.department_id
where e.name is null;

select * from departments d
right join employees e on d.id = e.department_id;

select * from employees e
left join departments d on e.department_id = d.id;

create table teens(
	id int primary key,
	name varchar(255),
	gender varchar(255)
);

insert into teens(id, name, gender) values (1, 'Nina', 'female'), (2, 'Valya', 'female'), (3, 'Sergey', 'male'), (4, 'Anton', 'male'), (5, 'Anna', 'female');

select n1.name, n1.gender , n2.name, n2.gender, (n1.name, n2.name ) as "Пара" from teens n1
         cross join teens n2
		 where n1.gender != n2.gender and n1.gender = 'female';

