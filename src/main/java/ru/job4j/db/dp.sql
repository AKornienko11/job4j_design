create table devices
(
    id    int primary key,
    name  varchar(255),
    price float
);

create table people
(
    id   int primary key,
    name varchar(255)
);

create table devices_people
(
    id        int primary key,
    device_id int references devices (id),
    people_id int references people (id)
);

insert into devices (id, name, price) values (1,'IPhone', 9000.0),(2, 'Xiaomi', 3000.0), (3, 'Slamsung', 7000.0), (4, 'ZTE', 600.0);
insert into people (id, name) values (1, 'Mihail'), (2, 'Sergey'), (3, 'Irina');

insert into devices_people (id, device_id, people_id) values (1, 1, 1), (2, 2, 1), (3, 3, 1), (4, 4, 1);
insert into devices_people (id, device_id, people_id) values (5, 1, 2), (6, 3, 2), (7, 4, 2);
insert into devices_people (id, device_id, people_id) values (8, 2, 3), (9 ,3, 3);

select avg(price) from devices;

select  p.name, avg(d.price) from devices_people as dp
inner join  people as p on dp.people_id = p.id
inner join  devices as d on dp.device_id = d.id
group by p.name
having avg(d.price) > 5000;
