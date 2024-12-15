-- -- Create the STUDENT table
-- CREATE TABLE STUDENT (
--     Rno INT PRIMARY KEY,
--     Name VARCHAR(100) NOT NULL,
--     Branch VARCHAR(50) NOT NULL
-- );

-- -- Create the RESULT table
-- CREATE TABLE RESULT (
--     Rno INT,
--     SPI DECIMAL(3,1) NOT NULL,
--     PRIMARY KEY (Rno),
--     FOREIGN KEY (Rno) REFERENCES STUDENT(Rno)
-- );

-- -- Create the EMPLOYEE table
-- CREATE TABLE EMPLOYEE (
--     EmployeeNo VARCHAR(10) PRIMARY KEY,
--     Name VARCHAR(100) NOT NULL,
--     ManagerNo VARCHAR(10),
--     FOREIGN KEY (ManagerNo) REFERENCES EMPLOYEE(EmployeeNo)
-- );


-- -- Insert data into the STUDENT table
-- INSERT INTO STUDENT (Rno, Name, Branch) VALUES
-- (101, 'Raju', 'CE'),
-- (102, 'Amit', 'CE'),
-- (103, 'Sanjay', 'ME'),
-- (104, 'Neha', 'EC'),
-- (105, 'Meera', 'EE'),
-- (106, 'Mahesh', 'ME');

-- -- Insert data into the RESULT table
-- INSERT INTO RESULT (Rno, SPI) VALUES
-- (101, 8.8),
-- (102, 9.2),
-- (103, 7.6),
-- (104, 8.2),
-- (105, 7.0),
-- (106, 8.9);

-- -- Insert data into the EMPLOYEE table
-- INSERT INTO EMPLOYEE (EmployeeNo, Name, ManagerNo) VALUES
-- ('E01', 'Tarun', NULL),
-- ('E02', 'Rohan', 'E02'),
-- ('E03', 'Priya', 'E01'),
-- ('E04', 'Milan', 'E03'),
-- ('E05', 'Jay', 'E01'),
-- ('E06', 'Anjana', 'E04');


-- -- Create the DEPARTMENT table
-- CREATE TABLE DEPARTMENT (
--     DepartmentID INT PRIMARY KEY,
--     DepartmentName VARCHAR(100) NOT NULL UNIQUE,
--     DepartmentCode VARCHAR(50) NOT NULL UNIQUE,
--     Location VARCHAR(50) NOT NULL
-- );

-- -- Create the PERSON table
-- CREATE TABLE PERSON (
--     PersonID INT PRIMARY KEY,
--     PersonName VARCHAR(100) NOT NULL,
--     DepartmentID INT NULL,
--     Salary DECIMAL(8,2) NOT NULL,
--     JoiningDate DATETIME NOT NULL,
--     City VARCHAR(100) NOT NULL,
--     FOREIGN KEY (DepartmentID) REFERENCES DEPARTMENT(DepartmentID)
-- );


-- INSERT INTO DEPARTMENT (DepartmentID, DepartmentName, DepartmentCode, Location) VALUES
-- (1, 'Admin', 'Adm', 'A-Block'),
-- (2, 'Computer', 'CE', 'C-Block'),
-- (3, 'Civil', 'CI', 'G-Block'),
-- (4, 'Electrical', 'EE', 'E-Block'),
-- (5, 'Mechanical', 'ME', 'B-Block');


-- INSERT INTO PERSON (PersonID, PersonName, DepartmentID, Salary, JoiningDate, City) VALUES
-- (101, 'Rahul Tripathi', 2, 56000.00, '2000-01-01', 'Rajkot'),
-- (102, 'Hardik Pandya', 3, 18000.00, '2001-09-25', 'Ahmedabad'),
-- (103, 'Bhavin Kanani', 4, 25000.00, '2000-05-14', 'Baroda'),
-- (104, 'Bhoomi Vaishnav', 1, 39000.00, '2005-02-08', 'Rajkot'),
-- (105, 'Rohit Topiya', 2, 17000.00, '2001-07-23', 'Jamnagar'),
-- (106, 'Priya Menpara', NULL, 9000.00, '2000-10-18', 'Ahmedabad'),
-- (107, 'Neha Sharma', 2, 34000.00, '2002-12-25', 'Rajkot'),
-- (108, 'Nayan Goswami', 3, 25000.00, '2001-07-01', 'Rajkot'),
-- (109, 'Mehul Bhundiya', 4, 13500.00, '2005-01-09', 'Baroda'),
-- (110, 'Mohit Maru', 5, 14000.00, '2000-05-25', 'Jamnagar');

-- * lab 8
CREATE TABLE salesmen
(
    salesman_id INT PRIMARY KEY,
    name VARCHAR(50),
    city VARCHAR(50),
    commission DECIMAL(4, 2)
);

-- Create customers table
CREATE TABLE customers
(
    customer_id INT PRIMARY KEY,
    cust_name VARCHAR(50),
    city VARCHAR(50),
    grade INT,
    salesman_id INT,
    FOREIGN KEY (salesman_id) REFERENCES salesmen(salesman_id)
);

-- Create orders table
CREATE TABLE orders
(
    ord_no INT PRIMARY KEY,
    purch_amt DECIMAL(10, 2),
    ord_date DATE,
    customer_id INT,
    salesman_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    FOREIGN KEY (salesman_id) REFERENCES salesmen(salesman_id)
);


INSERT INTO orders
    (ord_no, purch_amt, ord_date, customer_id, salesman_id)
VALUES
    (70001, 150.5, '2012-10-05', 3005, 5002),
    (70009, 270.65, '2012-09-10', 3001, 5005),
    (70020, 65.26, '2012-10-05', 3002, 5001),
    (70004, 110.5, '2012-08-17', 3009, 5003),
    (70007, 948.5, '2012-09-10', 3005, 5002),
    (70005, 2400.6, '2012-07-27', 3007, 5001),
    (70008, 5760, '2012-09-10', 3002, 5001),
    (70010, 1983.43, '2012-10-10', 3004, 5006),
    (70003, 2480.4, '2012-10-10', 3009, 5003),
    (70012, 250.45, '2012-06-27', 3008, 5002),
    (70011, 75.29, '2012-08-17', 3003, 5007),
    (70013, 3045.6, '2012-04-25', 3002, 5001),
    (70099, 150.5, '2012-10-05', 3005, 5002),
    (70100, 270.65, '2012-09-10', 3001, 5005),
    (70002, 65.26, '2012-10-05', 3002, 5001);

INSERT INTO salesmen
    (salesman_id, name, city, commission)
VALUES
    (5001, 'James Hoog', 'New York', 0.15),
    (5002, 'Nail Knite', 'Paris', 0.13),
    (5005, 'Pit Alex', 'London', 0.11),
    (5006, 'Mc Lyon', 'Paris', 0.14),
    (5007, 'Paul Adam', 'Rome', 0.13),
    (5003, 'Lauson Hen', 'San Jose', 0.12);


INSERT INTO customers
    (customer_id, cust_name, city, grade, salesman_id)
VALUES
    (3002, 'Nick Rimando', 'New York', 100, 5001),
    (3007, 'Brad Davis', 'New York', 200, 5001),
    (3005, 'Graham Zusi', 'California', 200, 5002),
    (3008, 'Julian Green', 'London', 300, 5002),
    (3004, 'Fabian Johnson', 'Paris', 300, 5006),
    (3009, 'Geoff Cameron', 'Berlin', 100, 5003),
    (3003, 'Jozy Altidor', 'Moscow', 200, 5007),
    (3001, 'Brad Guzan', 'London', NULL, 5005);

-- * A
-- 1. Write a SQL query to find the salesperson and customer who reside in the same city. Return Salesman,
-- cust_name and city.
select s.name, c.cust_name from salesmen s, customers c 
where s.salesman_id = c.salesman_id 
and s.city = c.city;
-- 2. Write a SQL query to find those orders where the order amount exists between 500 and 2000. Return ord_no,
-- purch_amt, cust_name, city.
select o.ord_no, o.purch_amt, c.cust_name, c.city 
from orders o, customers c
where o.customer_id = c.customer_id and o.purch_amt between 500 and 2000;  
-- 3. Write a SQL query to find the salesperson(s) and the customer(s) he represents. Return Customer Name,
-- city, Salesman, commission.
select c.cust_name, c.city, s.name, s.commission from salesmen s, customers c 
where s.salesman_id = c.salesman_id;
-- 4. Write a SQL query to find salespeople who received commissions of more than 12 percent from the
-- company. Return Customer Name, customer city, Salesman, commission.
select c.cust_name, c.city, s.name, s.commission from salesmen s, customers c 
where s.salesman_id = c.salesman_id and s.commission > 0.12;
-- 5. Write a SQL query to locate those salespeople who do not live in the same city where their customers live
-- and have received a commission of more than 12% from the company. Return Customer Name, customer
-- city, Salesman, salesman city, commission.
select c.cust_name, c.city, s.city,s.name, s.commission from salesmen s, customers c 
where s.salesman_id = c.salesman_id and s.commission > 0.12 and s.city != c.city;
-- 6. Write a SQL query to find the details of an order. Return ord_no, ord_date, purch_amt, Customer Name, grade,
-- Salesman, commission.
select o.ord_no, o.ord_date,o.purch_amt,c.cust_name,c.grade,s.name,s.commission from salesmen s, customers c, orders o 
where o.salesman_id = s.salesman_id and o.customer_id = c.customer_id;
-- 7. Write a SQL statement to join the tables salesman, customer and orders so that the same column of each
-- table appears once and only the relational rows are returned.
select * 
from orders o 
inner join customers c on o.customer_id = c.customer_id
inner join salesmen s on c.salesman_id = s.salesman_id;
-- 8. Write a SQL query to display the customer name, customer city, grade, salesman, salesman city. The results
-- should be sorted by ascending customer_id.
select c.cust_name, c.city, c.grade, s.name, s.city from customers c, salesmen s where c.salesman_id = s.salesman_id 
order by c.customer_id;
-- 9. Write a SQL query to find those customers with a grade less than 300. Return cust_name, customer city,
-- grade, Salesman, salesmancity. The result should be ordered by ascending customer_id.
select c.cust_name, c.city, c.grade, s.name, s.city from customers c, salesmen s 
where c.salesman_id = s.salesman_id and c.grade < 300 
order by c.customer_id;
-- 10. Write a SQL statement to make a report with customer name, city, order number, order date, and order
-- amount in ascending order according to the order date to determine whether any of the existing customers
-- have placed an order or not.
select c.cust_name, c.city, o.ord_no, o.ord_date, o.purch_amt from customers c, orders o 
where o.customer_id = c.customer_id 
order by o.ord_date;