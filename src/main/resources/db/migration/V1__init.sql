create table authors
(
    author_id   bigint primary key auto_increment,
    author_name varchar(50)
);

create table genres
(
    genre_id   bigint primary key auto_increment,
    genre_name varchar(50)
);

create table books
(
    book_id          bigint primary key auto_increment,
    title            varchar(100)  not null,
    price            float(8, 2) not null default 99,
    amount           int           not null default 1,
    description      varchar(1000)          default "Появится позже...",
    publish_date     datetime               default now(),
    last_update_time datetime
);

create table book_author
(
    book_id   bigint not null,
    author_id bigint not null,
    primary key (book_id, author_id),
    foreign key (book_id) references books (book_id),
    foreign key (author_id) references authors (author_id)
);

create table book_genre
(
    book_id bigint not null,
    genre_id bigint not null,
    primary key (book_id, genre_id),
    foreign key (book_id) references books (book_id),
    foreign key (genre_id) references genres (genre_id)
);