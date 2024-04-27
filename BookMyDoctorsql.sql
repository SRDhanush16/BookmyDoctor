# for BookMyDoctor

create database bookmydoctor;
use bookmydoctor;

# Creating tables 
create table Doctors(id numeric, name varchar(100),specialzation varchar(100));
insert into Doctors values(1,'Balakrishnan','ENT/otolaryngologist'),(2,'Govinda Raj','Andrologist'),(3,'Shamala','Pediatrician'),(5,'Brindha','Ophthalmologists'),(6,'Daha','Pediatrician'),(7,'Ragunandan','ENT/otolaryngologist');
create table Users(uid numeric, uname varchar(100), uemail varchar(50),upassword varchar(100), uphone numeric);
insert into Users values(1,'Dhanush','dhanush@gmail.com','Dhanush123', 8637603303),(2,'Kathir','Kathir@gmail.com','Kathir123',29585602),(3,'Tom','Tom@gmail.com','Tom123', 1231236540);

create table Appointments(apno numeric, pname varchar(100), pphone numeric, patage numeric, dname varchar(100), apdate varchar(20), aptime varchar(20));
select * from Appointments;


###############

select * from Users;
select * from Doctors;

ALTER TABLE Doctors
MODIFY COLUMN slot1 VARCHAR(255) DEFAULT '0',
MODIFY COLUMN slot2 VARCHAR(255) DEFAULT '0';

ALTER TABLE Doctors ADD shift varchar(20);
ALTER TABLE Doctors ADD dpassword varchar(50); 
ALTER TABLE Appointments ADD pemail varchar(100);

ALTER TABLE Doctors ADD email varchar(100);
UPDATE Doctors SET email = CONCAT(name,'@gmail.com');

UPDATE Doctors SET shift = 'morning' where id in(1,2,5);
UPDATE Doctors SET shift = 'eveing' where id in(3,4,6);
UPDATE Doctors SET dpassword = CONCAT('passD', id);

DELETE FROM Users WHERE uid = 4;
DELETE FROM Appointments;





