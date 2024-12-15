-- Create the STUDENT table
CREATE TABLE STUDENT (
    Rno INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    City VARCHAR(100) NOT NULL,
    DID INT NOT NULL
);

-- Create the ACADEMIC table
CREATE TABLE ACADEMIC (
    Rno INT PRIMARY KEY,
    SPI DECIMAL(3,1) NOT NULL,
    Bklog INT NOT NULL,
    FOREIGN KEY (Rno) REFERENCES STUDENT(Rno)
);

-- Create the DEPARTMENT table
CREATE TABLE DEPARTMENT (
    DID INT PRIMARY KEY,
    DName VARCHAR(100) NOT NULL
);



-- Insert data into the STUDENT table
INSERT INTO STUDENT (Rno, Name, City, DID) VALUES
(101, 'Raju', 'Rajkot', 10),
(102, 'Amit', 'Ahmedabad', 20),
(103, 'Sanjay', 'Baroda', 40),
(104, 'Neha', 'Rajkot', 20),
(105, 'Meera', 'Ahmedabad', 30),
(106, 'Mahesh', 'Baroda', 10);

-- Insert data into the ACADEMIC table
INSERT INTO ACADEMIC (Rno, SPI, Bklog) VALUES
(101, 8.8, 0),
(102, 9.2, 2),
(103, 7.6, 1),
(104, 8.2, 4),
(105, 7.0, 2),
(106, 8.9, 3);

-- Insert data into the DEPARTMENT table
INSERT INTO DEPARTMENT (DID, DName) VALUES
(10, 'Computer'),
(20, 'Electrical'),
(30, 'Mechanical'),
(40, 'Civil');

.
-- Create the COMPANY_MASTER table
CREATE TABLE COMPANY_MASTER (
    COM_ID INT PRIMARY KEY,
    COM_NAME VARCHAR(100) NOT NULL
);


-- Insert data into the COMPANY_MASTER table
INSERT INTO COMPANY_MASTER (COM_ID, COM_NAME) VALUES
(11, 'Samsung'),
(12, 'iBall'),
(13, 'Epsion'),
(14, 'Zebronics'),
(15, 'Asus'),
(16, 'Frontech');


-- Create the EMP_DETAILS table
CREATE TABLE EMP_DETAILS (
    EMP_IDNO INT PRIMARY KEY,
    EMP_FNAME VARCHAR(100) NOT NULL,
    EMP_LNAME VARCHAR(100) NOT NULL,
    EMP_DEPT INT NOT NULL
);


-- Insert data into the EMP_DETAILS table
INSERT INTO EMP_DETAILS (EMP_IDNO, EMP_FNAME, EMP_LNAME, EMP_DEPT) VALUES
(127323, 'Michale', 'Robbin', 57),
(526689, 'Carlos', 'Snares', 63),
(843795, 'Enric', 'Dosio', 57),
(328717, 'Jhon', 'Snares', 63),
(444527, 'Joseph', 'Dosni', 47),
(659831, 'Zanifer', 'Emily', 47),
(847674, 'Kuleswar', 'Sitaraman', 57),
(748681, 'Henrey', 'Gabriel', 47),
(555935, 'Alex', 'Manuel', 57),
(539569, 'George', 'Mardy', 27),
(733843, 'Mario', 'Saule', 63),
(631548, 'Alan', 'Snappy', 27),
(839139, 'Maria', 'Foster', 57);


-- Create the EMP_DEPARTMENT table
CREATE TABLE EMP_DEPARTMENT (
    DPT_CODE INT PRIMARY KEY,
    DPT_NAME VARCHAR(100) NOT NULL,
    DPT_ALLOTMENT DECIMAL(10,2) NOT NULL
);


-- Insert data into the EMP_DEPARTMENT table
INSERT INTO EMP_DEPARTMENT (DPT_CODE, DPT_NAME, DPT_ALLOTMENT) VALUES
(57, 'IT', 65000.00),
(63, 'Finance', 15000.00),
(47, 'HR', 240000.00),
(27, 'RD', 55000.00),
(89, 'QC', 75000.00);

-- * A
-- 1. Display details of students who are from computer department.
select * from STUDENT where did in (select DID from DEPARTMENT where DName = 'Computer')
-- 2. Displays name of students whose SPI is more than 8.
select Name from STUDENT where Rno in (select Rno from ACADEMIC where SPI > 8)
-- 3. Display details of students of computer department who belongs to Rajkot city.
select * from STUDENT where did in (select DID from DEPARTMENT where DName = 'Computer') and City='Rajkot'
-- 4. Find total number of students of electrical department.
select count(Rno) from STUDENT where DID in (select DID from DEPARTMENT where DName = 'Electrical')
-- 5. Display name of student who is having maximum SPI.
select Name from STUDENT where Rno in (select Rno from ACADEMIC where SPI in (select MAX(SPI) from ACADEMIC))
-- 6. Display details of students having more than 1 backlog.
select * from STUDENT where Rno in (select Rno from ACADEMIC where Bklog > 1)
-- 7. Display name of student who is having second highest SPI.
select Name from STUDENT where Rno in (
    select Rno from ACADEMIC where SPI in (
        select MAX(SPI) from ACADEMIC where SPI < (
            select MAX(SPI) from ACADEMIC
            )
        )
    )
-- 8. Display name of students who are either from computer department or from mechanical department.
select Name from STUDENT where DID in (
    select DID from DEPARTMENT where DName = 'Computer' or DName='Mechanical'
)
-- 9. Display name of students who are in same department as 102 studying in.
select Name from STUDENT where DID in (
    select DID from STUDENT where Rno = 102 
)
-- 10. Display name of students whose SPI is more than 9 and who is from electrical department.
select Name from STUDENT where Rno in (
    select Rno from ACADEMIC where SPI > 9
) and DID in (
    select DID from DEPARTMENT where DName = 'Electrical'
)

-- * B
-- 1. Write a SQL query to calculate the average price of each manufacturer's product along with their name.
-- Return Average Price and Company.
select 
-- 2. Write a SQL query to calculate the average price of each manufacturer's product of 350 or more. Return
-- Average Price and Company.
-- 3. Write a SQL query to find the most expensive product of each company. Return Product Name, Price and
-- Company.
-- 4. Write a SQL query to find employees whose last name is Gabriel or Dosio. Return emp_idno, emp_fname,
-- emp_lname and emp_dept.
-- 5. Write a SQL query to find the employees who work in department 89 or 63. Return emp_idno, emp_fname,
-- emp_lname and emp_dept.