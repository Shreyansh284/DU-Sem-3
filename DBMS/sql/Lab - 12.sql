create table department (
departmentid int primary key,
departmentname varchar(25)not null unique
);

create table designation (
desigantionid int primary key,
designationname varchar(25) not null unique
);

create table person (
worker_id int primary key,
firsname varchar(25) not null,
lastname varchar(25),
salary decimal(8,2),
joiningdate datetime,
departmentid int foreign key references department(departmentid),
designationid int foreign key references designation(desigantionid)
);

insert into person values(101,'rahul','anshu',56000,'01-01-1990',1,12);
insert into person values(102,'hardik','hinsu',18000,'01-01-1990',2,11);
insert into person values(103,'bhavin','kamani',25000,'01-01-1990',NULL,11);
insert into person values(104,'bhoomi','patel',39000,'01-01-1990',1,13);
insert into person values(105,'rohit','rajgor',17000,'01-01-1990',2,15);
insert into person values(106,'priya','mehta',25000,'01-01-1990',2,NULL);
insert into person values(107,'neha','trivedi',18000,'01-01-1990',3,15);

insert into department values(1,'admin');
insert into department values(2,'it');
insert into department values(3,'hr');
insert into department values(4,'account');

insert into designation values(11,'jobber');
insert into designation values(12,'welder');
insert into designation values(13,'clerk');
insert into designation values(14,'manager');
insert into designation values(15,'ceo');

-- * A
-- 1. Create a Procedure on Department, Designation & Person Table for INSERT, UPDATE & DELETE Procedures.
create procedure PR_DEPARTMENT_INSERT
@departmentid INT, @departmentname VARCHAR(25)
AS
BEGIN
INSERT INTO department values(@departmentid, @departmentname)
END

create procedure PR_DEPARTMENT_UPDATE
@departmentid INT, @departmentname VARCHAR(25)
AS
BEGIN
UPDATE department SET departmentname=@departmentname WHERE departmentid=@departmentid
END

create procedure PR_DEPARTMENT_DELETE
@departmentid INT
AS
BEGIN
DELETE FROM department WHERE departmentid=@departmentid
END

create procedure PR_DESIGNATION_INSERT
@desigantionid INT, @designationname VARCHAR(25)
AS
BEGIN
INSERT INTO designation values(@desigantionid, @designationname)
END

create procedure PR_DESIGNATION_UPDATE
@desigantionid INT, @designationname VARCHAR(25)
AS
BEGIN
UPDATE designation SET designationname=@designationname WHERE desigantionid=@desigantionid
END

create procedure PR_DESIGNATION_DELETE
@desigantionid INT
AS
BEGIN
DELETE FROM designation WHERE desigantionid=@desigantionid
END

create procedure PR_PERSON_INSERT
@worker_id INT, @firstname VARCHAR(25), @lastname VARCHAR(25), @salary DECIMAL(8,2), @joiningdate DATETIME, @departmentid INT, @designationid INT
AS
BEGIN
INSERT INTO person values(@worker_id, @firsname, @lastname, @salary, @joiningdate, @departmentid, @designationid)
END

create procedure PR_PERSON_UPDATE
@worker_id INT, @firstname VARCHAR(25), @lastname VARCHAR(25), @salary DECIMAL(8,2), @joiningdate DATETIME, @departmentid INT, @designationid INT
AS
BEGIN
UPDATE person SET firstname=@firstname, lastname=@lastname, salary=@salary, joiningdate=@joiningdate, departmentid=@departmentid, designationid=@designationid WHERE worker_id=@worker_id
END

create procedure PR_PERSON_DELETE
@worker_id INT
AS
BEGIN
DELETE FROM person WHERE worker_id=@worker_id
END

-- 2. Create a Procedure on Department, Designation & Person Table for SELECTBYPRIMARYKEY
create procedure PR_DEPARTMENT_SELECTBYPRIMARYKEY
@departmentid INT
AS
BEGIN
    SELECT * FROM department WHERE departmentid=@departmentid;
END

create procedure PR_DESIGNATION_SELECTBYPRIMARYKEY
@desigantionid INT
AS
BEGIN
    SELECT * FROM designation WHERE desigantionid=@desigantionid;
END

create procedure PR_PERSON_SELECTBYPRIMARYKEY
@worker_id INT
AS
BEGIN
    SELECT * FROM person WHERE worker_id=@worker_id;
END

-- 3. Create a Procedure on Department, Designation & Person Table (If foreign key is available then do write join
-- and take columns on select list)
create procedure PR_PERSON_SELECTBYJOINWITHDEPRARTMENT
AS
BEGIN
    SELECT  P.firstname, P.lastname, P.salary, DEP.departmentname, DESG.designationname FROM 
    person P INNER JOIN department DEP ON person.departmentid=department.departmentid
    INNER JOIN designation DESG ON person.designationid=designation.desigantionid;
END

EXEC PR_PERSON_SELECTBYJOINWITHDEPRARTMENT;

-- 4. Create a Procedure that shows details of the first 3 persons.
create procedure PR_PERSON_SELECTFIRSTTHREE
AS
BEGIN
    SELECT TOP 3 * FROM person;
END

EXEC PR_PERSON_SELECTFIRSTTHREE;

-- * B