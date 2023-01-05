create database javafxsample;
use javafxsample;
create table if not exists flights(
    id int(11) not null auto_increment,
    direction varchar(255) not null unique,
    date_time date not null,
    number_of_seats int(255) not null,
    total_price int(255) not null,
    created_at datetime not null default current_timestamp,
    primary key(id)
    );