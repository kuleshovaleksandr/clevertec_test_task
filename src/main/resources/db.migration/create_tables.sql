create table product
(
    id    serial primary key,
    name  varchar(255)                    not null,
    price numeric(7, 2) check (price > 0) not null
);

create table discount_card
(
    id       serial primary key,
    number   bigint                        not null,
    discount smallint check (discount > 0) not null
);