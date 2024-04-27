
#Create Database
create database bookmydocv2;
use bookmydocv2;

#Create Tables 

create table DoctorsCred(Did numeric primary key, Dname varchar(100), Demail varchar(100),Dpassword varchar(100));
create table DoctorsDetails(Did numeric primary key , Dname varchar(100),Demail varchar(100),specialzation varchar(100), shift varchar(100), slot1 varchar(50),patients1 numeric,slot2 varchar(50),patients2 numeric);

create table UsersCred(Uid numeric primary key, Uname varchar(100),Uemail varchar(100) ,Upassword varchar(100));

create table Appointments(Aid numeric primary key, Uid numeric, Pname varchar(100), Patage numeric, Uemail varchar(100), pphone numeric, Did numeric, Dname varchar(100), Adate varchar(50), Atime varchar(50), Atoken numeric);


#Insert Values
insert into DoctorsCred values(3, 'Ragu','ragu@gmail.com','ragu123');

insert into DoctorsDetails values(1,'Shamala','shamala@gmail.com','Pediatrician','morning','9am-11am',0,'12pm-2pm',0);
insert into DoctorsDetails values(2,'Daha','daha@gmail.com','Pediatrician','morning','9am-11am',0,'12pm-2pm',0);
insert into DoctorsDetails values(3,'Ragu','ragu@gmail.com','ENT','evening','4pm-6pm',0,'7pm-9pm',0);

insert into UsersCred values(1, 'Dhanush','dhanush@gmail.com','dhanush123',8637600333);
insert into UsersCred values(2, 'Kathir','kathir@gmail.com','kathir123',2958565020);
insert into UsersCred values(3, 'Tom','tom@gmail.com','tom123',1234567890);


# Display Tables
select * from DoctorsCred;
select * from DoctorsDetails;
select * from UsersCred;
select * from Appointments;


# Update/Alter Tables 
alter table UsersCred add Uphone numeric;


# Delete/ Turncate Tables
DELETE FROM UsersCred WHERE Uid = 6;
DELETE FROM Appointments;

ALTER TABLE DoctorsDetails DROP COLUMN patients2;
ALTER TABLE Appointments DROP COLUMN Atoken;