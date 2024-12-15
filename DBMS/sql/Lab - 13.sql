CREATE TABLE Person
(
    PersonID INT PRIMARY KEY,
    PersonName VARCHAR(100) NOT NULL,
    Salary DECIMAL(8,2) NOT NULL,
    JoiningDate DATETIME NOT NULL,
    City VARCHAR(100) NOT NULL,
    Age INT NULL,
    BirthDate DATETIME NOT NULL
);

CREATE TABLE PersonLog
(
    PLogID INT PRIMARY KEY IDENTITY(1,1),
    PersonID INT NOT NULL,
    PersonName VARCHAR(250) NOT NULL,
    Operation VARCHAR(50) NOT NULL,
    UpdateDate DATETIME NOT NULL
);

-- * A
-- 1. Create a trigger that fires on INSERT, UPDATE and DELETE operation on the Person table to display a
-- message “Record is Affected.”
CREATE TRIGGER PersonLogTrigger
ON Person
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    PRINT 'Record is Affected.'
END

-- 2. Create a trigger that fires on INSERT, UPDATE and DELETE operation on the Person table. For that, log all
-- operations performed on the person table into PersonLog.
CREATE TRIGGER PersonLogAfterTrigger
ON Person
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    
    if EXISTS (select * from inserted)
        begin
            insert into personLog
            select PersonID,PersonName,'inserted',GETDATE() from inserted
        end
    if EXISTS (select * from inserted) and exists (select * from deleted)
        begin
            insert into personLog
            select PersonID,PersonName,'updated',GETDATE() from inserted
        end
    if EXISTS (select * from deleted)
        begin
            insert into personLog
            select PersonID,PersonName,'deleted',GETDATE() from deleted
        end
END

-- * B
-- 1. Create an INSTEAD OF trigger that fires on INSERT, UPDATE and DELETE operation on the Person table. For
-- that, log all operations performed on the person table into PersonLog.
CREATE TRIGGER PersonLogInsteadOfTrigger
ON Person
INSTEAD OF INSERT, UPDATE, DELETE
AS
BEGIN
    if EXISTS (select * from inserted)
        begin
            insert into personLog
            select PersonID,PersonName,'inserted',GETDATE() from inserted
        end
    if EXISTS (select * from inserted) and exists (select * from deleted)
        begin
            insert into personLog
            select PersonID,PersonName,'updated',GETDATE() from inserted
        end
    if EXISTS (select * from deleted)
        begin
            insert into personLog
            select PersonID,PersonName,'deleted',GETDATE() from deleted
        end
END

-- 2. Create a trigger that fires on INSERT operation on the Person table to convert person name into uppercase
-- whenever the record is inserted.
CREATE TRIGGER PersonLogAfterTrigger
ON Person
AFTER INSERT
AS
BEGIN
    UPDATE Person SET PersonName = UPPER(PersonName)
END

insert into person1 values(1,'test',10000,02-07-2024,'city',20,29-04-2005);
update person1 set PersonName='test2' where PersonName='test';
delete from person1 where PersonName='test2'

select * from Person
select * from PersonLog