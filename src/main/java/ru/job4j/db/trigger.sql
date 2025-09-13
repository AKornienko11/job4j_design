create table products
(
    id       serial primary key,
    name     varchar(50),
    producer varchar(50),
    count    integer default 0,
    price    integer
);

 create
or replace function tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price * 1.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger tax_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure tax();

insert into products (name, producer, count, price)
VALUES ('product_4', 'producer_4', 8, 100);

create table history_of_price
(
    id    serial primary key,
    name  varchar(50),
    price integer,
    date  timestamp
);

CREATE OR REPLACE FUNCTION history_price()
  RETURNS trigger AS
$$
BEGIN
 INSERT INTO history_of_price (name,  price, date)
VALUES(NEW.name,NEW.price,current_date);
RETURN NEW;
END;
$$
LANGUAGE 'plpgsql';

create trigger  history_price
    after insert
    on products
    for each row
    execute procedure  history_price();


insert into products (name, producer, count, price)
VALUES ('product_11', 'producer_14', 89, 1400);

insert into products (name, producer, count, price)
VALUES ('product_12', 'producer_15', 879, 14900);





