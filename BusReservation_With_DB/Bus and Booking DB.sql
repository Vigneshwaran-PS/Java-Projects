show character set;

create database BusReservation;
use BusReservation;

create table bus(
bus_no int primary key,
ac boolean,
capacity int
);

insert into bus values
(1,0,2),
(2,1,10),
(3,0,15);

select * from bus;

create table booking(
bus_no int ,
passengerName varchar(20),
travel_date date);

drop table booking;

select * from booking;