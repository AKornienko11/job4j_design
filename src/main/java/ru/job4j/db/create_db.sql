CREATE DATABASE system
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

create table roles(
	id int primary key,
	name varchar(255)
);
create table rules(
	id int primary key,
	name varchar(255)
);

create table roles_rules(
	id int primary key,
	role_id int references roles(id),
	rule_id int references rules(id)
);

create table users (
	id int primary key,
	name varchar(255),
	role_id int references roles(id)

);

create table categories(
	id int primary key,
	name varchar(255)
);

create table states(
	id int primary key,
	 name varchar(255)
);

create table items (
	id int primary key,
	name varchar(255),
	categories_id int references categories(id),
	states_id int references states(id),
    user_id int references users(id)
);

create table comments(
	 id int primary key,
	 content boolean,
     item_id int references items(id)
);

create table attachs(
	 id int primary key,
	 type_file varchar(255),
     item_id int references items(id)

);

insert into roles(id, name) values(1, 'Junior');
insert into roles(id, name) values(2, 'Midle');

insert into rules(id, name) values(1, 'vieving');
insert into rules(id, name) values(2, 'editing');

insert into roles_rules(id, role_id, rule_id) values(1, 1, 1);
insert into roles_rules(id, role_id, rule_id) values(2, 2, 2);

insert into users(id, name, role_id ) values(1, 'Ivan', 1);
insert into users(id, name, role_id) values(2, 'Aleksey', 2);

insert into categories(id, name) values(1, 'urgent');
insert into categories(id, name) values(2, 'non_urgent');

insert into states(id, name) values(1, 'done');
insert into states(id, name) values(2, 'in_procces');

insert into items(id, name, categories_id, states_id, user_id) values(1, 'create db', 1, 1, 1);
insert into items(id, name, categories_id, states_id, user_id) values(2, 'create db', 2, 2, 2);

insert into comments(id, content, item_id) values (1, true, 1);
insert into comments(id, content, item_id) values(2, false, 2);

insert into attachs(id, type_file, item_id) values(1, '.pdf', 1);
insert into attachs(id, type_file, item_id) values(2, '.jpg', 1);
insert into attachs(id, type_file, item_id) values(3, '.txt', 2);