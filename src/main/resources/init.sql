create table Human
(
    id            integer not null auto_increment,
    created_date  date,
    modified_date date,
    age           integer,
    name          varchar(255),
    primary key (id)
);

create table Person
(
    d_type      varchar(31) not null,
    id          integer     not null auto_increment,
    name        varchar(255),
    mega_skill  varchar(255),
    super_skill varchar(255),
    primary key (id)
);

create table elephant
(
    id            integer not null,
    name          varchar(255),
    walking_speed integer,
    primary key (id)
);

create table whale
(
    id            integer not null,
    name          varchar(255),
    swimmingSpeed integer,
    primary key (id)
);

create table hibernate_sequence
(
    next_val bigint
);


insert into hibernate_sequence
values (1);


create table linux
(
    kernel_version varchar(255),
    id             integer not null,
    primary key (id)
);

create table my_sequence
(
    next_val bigint
);
insert into my_sequence
values (1);
create table OperationSystem
(
    id   integer not null,
    name varchar(255),
    primary key (id)
);
create table windows
(
    cost integer,
    id   integer not null,
    primary key (id)
);
alter table linux
    add constraint FKc2io0awa0mepslhjmdh32s4w7 foreign key (id) references OperationSystem (id);
alter table windows
    add constraint FKmvvf1fsu17urd40blgvhy4597 foreign key (id) references OperationSystem (id);

