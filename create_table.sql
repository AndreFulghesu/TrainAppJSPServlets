CREATE SCHEMA `train_app` ;

create table train_app.APP_USER (
user_id BIGINT not null AUTO_INCREMENT,
user_name varchar(50) not null,
user_password varchar(100) not null,
email varchar(50) not null,
address varchar(50) not null,
birth_place varchar(50) not null,
user_role varchar(50) not null,
phone varchar(20) not null,
primary key(user_id)
);
truncate table train_app.APP_USER;
select * from train_app.APP_USER;

create table train_app.TRAIN_COMPANY (
company_id BIGINT not null,
company_name varchar(50) not null,
primary key(company_id)
);

create table train_app.TICKET (
ticket_id BIGINT not null,
departure_date date not null,
arrival_date date not null,
station varchar(50) not null,
passengers long not null,
is_purchased boolean not null,
company_id BIGINT not null, 
primary key(ticket_id),
foreign key(company_id) references TRAIN_COMPANY(company_id)
);

commit;






