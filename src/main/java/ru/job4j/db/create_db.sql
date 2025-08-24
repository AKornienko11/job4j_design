CREATE DATABASE system
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

create table comments(
	id int primary key,
	 content boolean
);

create table attachs(
	id int primary key,
	 type_file varchar(255)
);

create table categories(
	id int primary key,
	 name varchar(255)

);

create table states(
	id int primary key,
	 name varchar(255)
);

create table item (
	id int primary key,
	name varchar(255),
	comments_id int references comments(id),
	attachs_id int references attachs(id),
	categories_id int references categories(id),
	states_id int references states(id)
);

create table role(
	id int primary key,
	name varchar(255)
);
create table rule(
	id int primary key,
	name varchar(255)
);

create table roles_rules(
	id int primary key,
	role_id int references role(id),
	rule_id int references rule(id)
);

create table users (
	id int primary key,
	name varchar(255),
	role_rule_id int references role(id),
	item_id int references item(id)
);

insert into comments(id, content) values (1, true);
insert into comments(id, content) values(2, false);

insert into attachs(id, type_file) values(1, '.pdf');
insert into attachs(id, type_file) values(2, '.jpg');
insert into attachs(id, type_file) values(3, '.txt');

insert into categories(id, name) values(1, 'urgent');
insert into categories(id, name) values(2, 'non_urgent');

insert into states(id, name) values(1, 'done');
insert into states(id, name) values(2, 'in_procces');

insert into item(id, name, comments_id, attachs_id, categories_id, states_id) values(1, 'create db',1, 1, 1, 1);
insert into item(id, name, comments_id, attachs_id, categories_id, states_id) values(2, 'create db',2, 2, 2, 2);

insert into role(id, name) values(1, 'Junior');
insert into role(id, name) values(2, 'Midle');

insert into rule(id, name) values(1, 'vieving');
insert into rule(id, name) values(2, 'editing');

insert into roles_rules(id, role_id, rule_id) values(1, 1, 1);
insert into roles_rules(id, role_id, rule_id) values(2, 2, 2);

insert into users(id, name, role_rule_id, item_id) values(1, 'Ivan', 1, 1);
insert into users(id, name, role_rule_id, item_id) values(2, 'Aleksey', 2, 2);