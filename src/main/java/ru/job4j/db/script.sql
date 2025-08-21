create DATABASE car
    with
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

create table cars
(
	id serial primary key,
	name varchar(100) not null,
	model text not null,
	factory_number integer not null,
	color_metalic boolean
);

insert into cars(id, name, model, factory_number, color_metalic) values
(1, 'Ford', 'Mustang', 12345, true),
(2, 'Reno', 'Logan', 34567, false),
(3, 'Lada', 'Vesta', 78657, false)
;

update cars set name  = 'BMW', model = 'X5', factory_number = 54678, color_metalic = true;

delete from cars;