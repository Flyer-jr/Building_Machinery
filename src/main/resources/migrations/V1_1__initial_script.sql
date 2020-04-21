create table if not exists m_user
(
    id              bigserial    not null
        constraint id
            primary key,
    first_name      varchar(50)  not null,
    second_name     varchar(50)  not null,
    phone_number    varchar(13)  not null,
    password        varchar(100) not null,
    post            varchar(50),
    actual          boolean,
    date_of_dismiss timestamp(6),
    role            bigint       not null,
    login           varchar(20)  not null,
    email           varchar(30)  not null
);

alter table m_user
    owner to "Flyer";

create unique index if not exists m_user_login_uindex
    on m_user (login);

create unique index if not exists m_user_email_uindex
    on m_user (email);

create index if not exists m_user_second_name_index
    on m_user (second_name);

create table if not exists m_customer
(
    id           bigserial    not null
        constraint m_customer_pkey
            primary key,
    company_name varchar(200) not null,
    address      varchar(200) not null,
    manager      varchar(200) not null,
    phone_number varchar(13)  not null,
    short_name   varchar(20)  not null
);

alter table m_customer
    owner to "Flyer";

create index if not exists m_customers_short_name_index
    on m_customer (short_name);

create table if not exists m_equipment_producers
(
    id           bigint       not null
        constraint m_equipment_producers_pkey
            primary key,
    name         varchar(200) not null,
    post_address varchar(200) not null
);

alter table m_equipment_producers
    owner to "Flyer";

create table if not exists m_equipment
(
    id           bigint       not null
        constraint m_equipment_pkey
            primary key,
    store_number varchar      not null,
    model        varchar(100) not null,
    producer_id  bigint       not null
        constraint producer
            references m_equipment_producers
);

alter table m_equipment
    owner to "Flyer";

create unique index if not exists m_equipment_store_number_uindex
    on m_equipment (store_number);

create table if not exists m_contractor
(
    id         bigserial    not null
        constraint m_contractor_pkey
            primary key,
    short_name varchar(50)  not null,
    full_name  varchar(150) not null,
    address    varchar(200) not null
);

alter table m_contractor
    owner to "Flyer";

create table if not exists m_construction_site
(
    id             bigint       not null
        constraint m_construction_site_pkey
            primary key,
    full_name      varchar(400) not null,
    short_name     varchar(50)  not null,
    customer_id    bigint       not null
        constraint customer
            references m_customer,
    responsible_id bigint       not null
        constraint responsible
            references m_user,
    contractor_id  bigint       not null
        constraint contractor
            references m_contractor
            on update cascade on delete cascade,
    date_of_start  timestamp(6),
    date_of_finish timestamp(6)
);

alter table m_construction_site
    owner to "Flyer";

create index if not exists m_construction_site_short_name_index
    on m_construction_site (short_name);

create index if not exists m_contractor_short_name_index
    on m_contractor (short_name);

create table if not exists m_order
(
    id                   bigserial             not null
        constraint m_order_pkey
            primary key,
    user_id              bigint                not null
        constraint "user"
            references m_user,
    construction_site_id bigint                not null
        constraint construction_site
            references m_construction_site,
    date_taken           timestamp             not null,
    active               boolean default false not null
);

alter table m_order
    owner to "Flyer";

create index if not exists m_order_construction_site_id_index
    on m_order (construction_site_id);

create index if not exists m_order_user_id_index
    on m_order (user_id);

create table if not exists m_roles
(
    role_id   bigint  not null
        constraint m_roles_pkey
            primary key,
    role_name varchar not null
);

alter table m_roles
    owner to "Flyer";

alter table m_user
    add constraint role
        foreign key (role) references m_roles;

create table if not exists m_order_equipment
(
    order_id     bigint not null
        constraint "order"
            references m_order,
    equipment_id bigint not null
        constraint equipment
            references m_equipment,
    constraint m_order_equipment_pkey
        primary key (order_id, equipment_id)
);

alter table m_order_equipment
    owner to "Flyer";

create table if not exists m_not_confirmed_users
(
    id                 bigint default nextval('m_not_confirmed_users_id_seq'::regclass) not null
        constraint m_not_confirmed_users_pkey
            primary key,
    first_name         varchar(50)                                                      not null,
    second_name        varchar(50)                                                      not null,
    phone_number       varchar(13)                                                      not null,
    password           varchar(100)                                                     not null,
    post               varchar(50)                                                      not null,
    confirmation_token varchar(200)                                                     not null,
    login              varchar(20)                                                      not null
        constraint login
            unique,
    email              varchar(50)                                                      not null
        constraint email
            unique
);

alter table m_not_confirmed_users
    owner to "Flyer";

create table if not exists m_conflicts
(
    id              bigserial not null
        constraint m_conflicts_pkey
            primary key,
    target_order_id bigint    not null,
    source_order_id bigint    not null,
    equipment_id    bigint    not null
        constraint m_conflicts_equipment_id_fkey
            references m_equipment,
    operation_date  date      not null
);

alter table m_conflicts
    owner to "Flyer";

create index if not exists m_conflicts_equipment_id_index
    on m_conflicts (equipment_id);

create index if not exists m_conflicts_source_order_id_index
    on m_conflicts (source_order_id);

create index if not exists m_conflicts_target_order_id_index
    on m_conflicts (target_order_id);

