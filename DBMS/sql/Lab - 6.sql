-- * A
-- Create the STUDENT table
CREATE TABLE STUDENT (
    Rno INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Branch VARCHAR(50) NOT NULL
);

-- Create the RESULT table
CREATE TABLE RESULT (
    Rno INT,
    SPI DECIMAL(3,1) NOT NULL,
    PRIMARY KEY (Rno),
    FOREIGN KEY (Rno) REFERENCES STUDENT(Rno)
);

-- Create the EMPLOYEE table
CREATE TABLE EMPLOYEE (
    EmployeeNo VARCHAR(10) PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    ManagerNo VARCHAR(10),
    FOREIGN KEY (ManagerNo) REFERENCES EMPLOYEE(EmployeeNo)
);


-- Insert data into the STUDENT table
INSERT INTO STUDENT (Rno, Name, Branch) VALUES
(101, 'Raju', 'CE'),
(102, 'Amit', 'CE'),
(103, 'Sanjay', 'ME'),
(104, 'Neha', 'EC'),
(105, 'Meera', 'EE'),
(106, 'Mahesh', 'ME');

-- Insert data into the RESULT table
INSERT INTO RESULT (Rno, SPI) VALUES
(101, 8.8),
(102, 9.2),
(103, 7.6),
(104, 8.2),
(105, 7.0),
(106, 8.9);

-- Insert data into the EMPLOYEE table
INSERT INTO EMPLOYEE (EmployeeNo, Name, ManagerNo) VALUES
('E01', 'Tarun', NULL),
('E02', 'Rohan', 'E02'),
('E03', 'Priya', 'E01'),
('E04', 'Milan', 'E03'),
('E05', 'Jay', 'E01'),
('E06', 'Anjana', 'E04');

--1. Combine information from student and result table using cross join or Cartesian product.
SELECT *
FROM student
CROSS JOIN result;
--2. Display Rno, Name, Branch and SPI of all students.
SELECT s.Rno, s.Name, s.Branch, r.SPI from student s inner join result r on s.Rno = r.Rno;
--3. Display Rno, Name, Branch and SPI of CE branch’s student only.
SELECT s.Rno, s.Name, s.Branch, r.SPI from student s inner join result r on s.Rno = r.Rno where s.Branch = 'CE';
--4. Display Rno, Name, Branch and SPI of other than EC branch’s student only.
SELECT s.Rno, s.Name, s.Branch, r.SPI from student s inner join result r on s.Rno = r.Rno where s.Branch != 'CE';
--5. Display average result of each branch.
SELECT s.Branch, AVG(r.SPI) from student s inner join result r on s.Rno = r.Rno group by s.Branch;
--6. Display average result of each branch and sort them in ascending order by SPI.
SELECT s.Branch, AVG(r.SPI), r.SPI from student s inner join result r on s.Rno = r.Rno group by s.Branch,r.SPI order by r.SPI;
--7. Display average result of CE and ME branch.
SELECT s.Branch, AVG(r.SPI) from student s inner join result r on s.Rno = r.Rno where s.Branch = 'CE' OR s.Branch = 'ME' group by s.Branch;
--8. Perform the left outer join on Student and Result tables.
SELECT * from student s left outer join result r on s.Rno = r.Rno; 
--9. Perform the right outer join on Student and Result tables.
SELECT * from student s right outer join result r on s.Rno = r.Rno; 
--10. Perform the full outer join on Student and Result tables.
SELECT * from student s full outer join result r on s.Rno = r.Rno; 
--11. Retrieve the names of employee along with their manager name from the Employee table.
SELECT e.Name, m.name from EMPLOYEE e inner join EMPLOYEE m on e.EmployeeNo = m.ManagerNo; 


-- * B
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

-- 1. Find all persons with their department name & code.
SELECT d.DepartmentName, d.DepartmentCode from PERSON p, DEPARTMENT d where p.DepartmentID = d.DepartmentID;
-- 2. Give department wise maximum & minimum salary with department name.
SELECT d.DepartmentName, MIN(p.Salary), MAX(p.Salary) from PERSON p, DEPARTMENT d where p.DepartmentID = d.DepartmentID group by d.DepartmentName;
-- 3. Find all departments whose total salary is exceeding 100000.
SELECT d.DepartmentName, SUM(p.Salary) from PERSON p, DEPARTMENT d where p.DepartmentID = d.DepartmentID group by d.DepartmentName having SUM(p.Salary) > 100000;
-- 4. Retrieve person name, salary & department name who belongs to Jamnagar city.
SELECT d.DepartmentName, p.Salary, p.PersonName from PERSON p, DEPARTMENT d where p.DepartmentID = d.DepartmentID and p.City = 'Jamnagar';
-- 5. Find all persons who does not belongs to any department.
SELECT * from PERSON p where p.DepartmentID is NULL;
-- 6. Find department wise person counts.
SELECT d.DepartmentName, count(p.PersonID) from PERSON p, DEPARTMENT d where p.DepartmentID = d.DepartmentID group by d.DepartmentName;
-- 7. Find average salary of person who belongs to Ahmedabad city.
SELECT d.DepartmentName, AVG(p.Salary) from PERSON p, DEPARTMENT d where p.DepartmentID = d.DepartmentID and p.City = 'Ahmedabad' group by d.DepartmentName;
-- 8. Produce Output Like: <PersonName> earns <Salary> from department <DepartmentName> monthly. (In
-- Single Column)
SELECT CONCAT(PersonName, ' earns ', Salary, ' from department ', DepartmentName, ' monthly.') AS Output
FROM PERSON 
JOIN DEPARTMENT ON PERSON.DepartmentID = DEPARTMENT.DepartmentID;
-- 9. List all departments who have no persons.
SELECT DepartmentName
FROM DEPARTMENT
 JOIN PERSON ON DEPARTMENT.DepartmentID = PERSON.DepartmentID
WHERE PERSON.PersonID IS NULL;
-- 10. Find city & department wise total, average & maximum salaries.
Select p.City, d.DepartmentName, SUM(p.Salary), AVG(p.Salary), MAX(p.Salary) 
from [dbo].[DEPARTMENT] d, [dbo].[PERSON] p 
where d.DepartmentID = p.DepartmentID
group by p.City, d.DepartmentName;