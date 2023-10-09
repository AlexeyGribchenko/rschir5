create table if not exists product_type(
    type_id serial primary key,
    type_name varchar(128)
);

create table if not exists client(
     id serial primary key,
     name varchar(128),
     email varchar(128),
     login varchar(128),
     password varchar(128)
);

create table if not exists book(
    id serial primary key,
    author varchar(128),
    seller_id int,
    product_type int,
    price int,
    title varchar(128)
);

create table if not exists telephone(
    id serial primary key,
    producer varchar(128),
    accumulator_volume int,
    seller_id int,
    product_type int,
    price int,
    title varchar(128)
);

create table if not exists washing_machine(
    id serial primary key,
    producer varchar(128),
    tank_volume int,
    seller_id int,
    product_type int,
    price int,
    title varchar(128)
);

insert into product_type (type_id, type_name)
values (1, 'book'), (2, 'telephone'), (3, 'washing_machine');