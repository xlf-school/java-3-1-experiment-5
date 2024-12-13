create table users
(
    id       int auto_increment
        primary key,
    username varchar(50)  not null,
    password varchar(100) not null,
    email    varchar(100) not null,
    constraint email
        unique (email),
    constraint username
        unique (username)
);

create table articles
(
    id         int auto_increment
        primary key,
    title      varchar(255)                        not null,
    content    text                                not null,
    author_id  int                                 null,
    created_at timestamp default CURRENT_TIMESTAMP null,
    constraint articles_ibfk_1
        foreign key (author_id) references users (id)
);

create index author_id
    on articles (author_id);

