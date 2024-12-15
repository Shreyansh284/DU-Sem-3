-- * A
-- Create the DEPARTMENT table
CREATE TABLE DEPARTMENT (
    DepartmentID INT PRIMARY KEY,
    DepartmentName VARCHAR(100) NOT NULL UNIQUE,
    DepartmentCode VARCHAR(50) NOT NULL UNIQUE,
    Location VARCHAR(50) NOT NULL
);

-- Create the PERSON table
CREATE TABLE PERSON (
    PersonID INT PRIMARY KEY,
    PersonName VARCHAR(100) NOT NULL,
    DepartmentID INT NULL,
    Salary DECIMAL(8,2) NOT NULL,
    JoiningDate DATETIME NOT NULL,
    City VARCHAR(100) NOT NULL,
    FOREIGN KEY (DepartmentID) REFERENCES DEPARTMENT(DepartmentID)
);


INSERT INTO DEPARTMENT (DepartmentID, DepartmentName, DepartmentCode, Location) VALUES
(1, 'Admin', 'Adm', 'A-Block'),
(2, 'Computer', 'CE', 'C-Block'),
(3, 'Civil', 'CI', 'G-Block'),
(4, 'Electrical', 'EE', 'E-Block'),
(5, 'Mechanical', 'ME', 'B-Block');


INSERT INTO PERSON (PersonID, PersonName, DepartmentID, Salary, JoiningDate, City) VALUES
(101, 'Rahul Tripathi', 2, 56000.00, '2000-01-01', 'Rajkot'),
(102, 'Hardik Pandya', 3, 18000.00, '2001-09-25', 'Ahmedabad'),
(103, 'Bhavin Kanani', 4, 25000.00, '2000-05-14', 'Baroda'),
(104, 'Bhoomi Vaishnav', 1, 39000.00, '2005-02-08', 'Rajkot'),
(105, 'Rohit Topiya', 2, 17000.00, '2001-07-23', 'Jamnagar'),
(106, 'Priya Menpara', NULL, 9000.00, '2000-10-18', 'Ahmedabad'),
(107, 'Neha Sharma', 2, 34000.00, '2002-12-25', 'Rajkot'),
(108, 'Nayan Goswami', 3, 25000.00, '2001-07-01', 'Rajkot'),
(109, 'Mehul Bhundiya', 4, 13500.00, '2005-01-09', 'Baroda'),
(110, 'Mohit Maru', 5, 14000.00, '2000-05-25', 'Jamnagar');

-- * B
-- 1. Find all persons with their department name & code.
select DepartmentName, DepartmentCode from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID 
-- 2. Find the person's name whose department is located in C-Block.
select p.PersonName from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID and d.Location = 'C-Block';
-- 3. Retrieve person name, salary & department name who belongs to Jamnagar city.
select p.PersonName, p.Salary, d.DepartmentName from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID and p.city = 'Jamnagar';
-- 4. Retrieve person name, salary & department name who does not belong to Rajkot city.
select p.PersonName, p.Salary, d.DepartmentName from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID and p.city != 'Rajkot';
-- 5. Retrieve person’s name of the person who joined the Civil department after 1-Aug-2001.
select p.PersonName from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID and p.JoiningDate > '01-08-2001' and d.DepartmentName = 'Civil';
-- 6. Find details of all persons who belong to the Computer department.
select * from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID and d.DepartmentName = 'Computer';
-- 7. Display all the person's name with the department whose joining date difference with the current date is
-- more than 365 days.
-- * day wise
select p.PersonName, d.DepartmentName from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID and DATEDIFF(DAY, p.JoiningDate, GETDATE()) > 365;
-- * month wise
select p.PersonName, d.DepartmentName from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID and DATEDIFF(MONTH, p.JoiningDate, GETDATE()) > 12;
-- * year wise
select p.PersonName, d.DepartmentName from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID and DATEDIFF(YEAR, p.JoiningDate, GETDATE()) > 1;
-- 8. Find department wise person counts.
select d.DepartmentName, count(p.DepartmentID) from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID group by d.DepartmentName;
-- 9. Give department wise maximum & minimum salary with department name.
select d.DepartmentName, MIN(p.Salary), MAX(p.Salary) from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID group by d.DepartmentName;
-- 10. Find city wise total, average, maximum and minimum salary.
select p.City, SUM(p.Salary), AVG(p.Salary), MAX(p.Salary), MIN(p.Salary) from PERSON p group by p.City;
-- 11. Find the average salary of a person who belongs to Ahmedabad city.
select p.City, AVG(p.Salary) from PERSON p where p.City='Ahmedabad' group by p.City;
-- 12. Produce Output Like: <PersonName> lives in <City> and works in <DepartmentName> Department. (In single
-- column)
select CONCAT(p.PersonName, ' lives in ', p.City, ' and works in ', d.DepartmentName, ' Department.') from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID;
-- 13. Produce Output Like: <PersonName> earns <Salary> from <DepartmentName> department monthly. (In
-- single column)
select CONCAT(p.PersonName, ' earns ', p.Salary, ' from ', d.DepartmentName, ' department monthly.') from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID;
-- 14. Find city & department wise total, average & maximum salaries.
select p.City, d.DepartmentName, SUM(p.Salary), AVG(p.Salary), MAX(p.Salary) from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID group by p.City, d.DepartmentName;
-- 15. Find all persons who do not belong to any department.
select * from PERSON where DepartmentID is null;

-- * C
-- 1. Find all departments whose total salary is exceeding 100000.
select d.DepartmentName from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID 
group by d.DepartmentName
having SUM(p.Salary) > 100000;
-- 2. List all departments who have no person.
select d.DepartmentName from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID 
and p.DepartmentID is null;
-- 3. List out department names in which more than two persons are working.
select d.DepartmentName from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID 
group by d.DepartmentName
having count(p.PersonID) > 2;
-- 4. Give a 10% increment in the Computer department employee’s salary. (Use Update)
UPDATE PERSON p
JOIN DEPARTMENT d ON p.DepartmentID = d.DepartmentID
SET p.Salary = p.Salary * 1.10
WHERE d.DepartmentName = 'Computer';
-- 5. Calculate Employee Experience in Years, Months & Days with respect to their joining Date.
select p.PersonName, p.JoiningDate, DATEDIFF(YEAR, p.JoiningDate, GETDATE()) as [YOE] from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p where d.DepartmentID = p.DepartmentID;
