--Part - A
-- Create the EMPLOYEE table
CREATE TABLE EMPLOYEE (
    Emp_ID INT PRIMARY KEY,
    Emp_Name VARCHAR(50),
    Emp_Salary DECIMAL(10, 2),
    Emp_Department VARCHAR(50),
    Emp_City VARCHAR(50),
    Emp_JoinDate DATE
);

-- Insert provided data into EMPLOYEE table
INSERT INTO EMPLOYEE (Emp_ID, Emp_Name, Emp_Salary, Emp_Department, Emp_City, Emp_JoinDate) VALUES 
(101, 'Rahul', 56000, 'Admin', 'Rajkot', '1990-01-01'),
(102, 'Hardik', 18000, 'IT', 'Ahmedabad', '1990-09-25'),
(103, 'Bhavin', 25000, 'HR', 'Baroda', '1991-05-14'),
(104, 'Bhoomi', 39000, 'Admin', 'Rajkot', '1991-02-08'),
(105, 'Rohit', 17000, 'IT', 'Jamnagar', '1990-07-23'),
(106, 'Priya', 9000, 'IT', 'Ahmedabad', '1990-10-18'),
(107, 'Neha', 34000, 'HR', 'Rajkot', '1991-12-25');

-- Part - B 

-- Create the COMPANY table
CREATE TABLE COMPANY (
    Title VARCHAR(100),
    Company VARCHAR(100),
    Type VARCHAR(50),
    Production_year INT,
    System VARCHAR(10),
    Production_cost DECIMAL(10, 2),
    Revenue DECIMAL(10, 2),
    Rating INT
);

-- Insert provided data into COMPANY table
INSERT INTO COMPANY (Title, Company, Type, Production_year, System, Production_cost, Revenue, Rating) VALUES
('Blasting Boxes', 'Simone Games', 'action adventure', 1998, 'PC', 100000, 200000, 7),
('Run Run Run!', '13 Mad Bits', 'shooter', 2011, 'PS3', 3500000, 650000, 3),
('Duck n�Go', '13 Mad Bits', 'shooter', 2012, 'Xbox', 3000000, 1500000, 5),
('SQL Wars!', 'Vertabelo', 'wargames', 2017, 'Xbox', 5000000, 25000000, 10),
('Tap Tap Hex!', 'PixelGaming Inc.', 'rhythm', 2006, 'PS2', 2500000, 3500000, 7),
('NoRisk', 'Simone Games', 'action adventure', 2004, 'PS2', 1400000, 3400000, 8);

--Display the Highest, Lowest, Total, and Average salary of all employees. Label the columns Maximum,
--Minimum, Total_Sal and Average_Sal, respectively.
SELECT 
MAX (Emp_Salary) AS 'MAXIMUM' , 
MIN(Emp_Salary) AS 'MINIMUM' ,
SUM(Emp_Salary) AS 'Total_Sal' ,
AVG(Emp_Salary) AS 'Average_Sal' 
FROM EMPLOYEE
--OR
select Emp_Salary, MAX(Emp_Salary) as ["Maximum"],MIN(Emp_Salary) as ["Minimum"],SUM(Emp_Salary) as ["Total_Sal"],AVG(Emp_Salary) as ["Avreage_Sal"] from EMPLOYEE group by Emp_Salary

--Find total number of employees of EMPLOYEE table

select count(Emp_id) from EMPLOYEE

--Give maximum salary from IT department

select Emp_salary,MAX(Emp_Salary) from EMPLOYEE where Emp_Department = 'IT'  group by Emp_Salary

--Count total number of cities of employee without duplication.

SELECT COUNT(DISTINCT Emp_City) FROM EMPLOYEE 

--Display city with the total number of employees belonging to each city.

SELECT Emp_City ,COUNT(EMP_ID) FROM EMPLOYEE 
GROUP BY Emp_City

--Display city having more than one employee.

SELECT Emp_city 
from EMPLOYEE 
group by Emp_City
having count(Emp_ID) >1 

--Give total salary of each department of EMPLOYEE table

SELECT Emp_Department,
SUM(Emp_Salary) AS Total_Salary
FROM EMPLOYEE
GROUP BY Emp_Department;

--Give average salary of each department of EMPLOYEE table without displaying the respective department name

SELECT AVG(Emp_Salary) AS Average_Salary
FROM EMPLOYEE
GROUP BY Emp_Department

--Give minimum salary of employee who belongs to Ahmedabad

SELECT MIN(Emp_Salary) from EMPLOYEE WHERE Emp_City = 'Ahmedabad'

--9. Give minimum salary of employee who belongs to Ahmedabad.
select min(Emp_Salary) from EMPLOYEE where Emp_City = 'Ahmedabad'
--10. List the departments having total salaries more than 50000 and located in city Rajkot.
select Emp_Department, SUM(Emp_Salary) from EMPLOYEE
where Emp_City = 'Rajkot'
Group by Emp_Department
having SUM(Emp_Salary) > 50000
--11. Count the number of employees living in Rajkot.
select COUNT(EMPLOYEE.Emp_ID) from EMPLOYEE where EMPLOYEE.Emp_City = 'Rajkot';
--12. Display the difference between the highest and lowest salaries. Label the column DIFFERENCE.
select MAX(EMPLOYEE.Emp_Salary) - MIN (EMPLOYEE.Emp_Salary) AS [DIFFERENCE] from EMPLOYEE
--13. Display the total number of employees hired before 1st January, 1991.
select COUNT(EMPLOYEE.Emp_ID) from EMPLOYEE where Emp_JoinDate < '1991-01-01';
--14. Display total salary of each department with total salary exceeding 35000 and sort the list by total salary.
select Emp_Department, SUM(EMPLOYEE.Emp_Salary) from EMPLOYEE 
Group by Emp_Department Having SUM(EMPLOYEE.Emp_Salary) > 35000 Order by SUM(EMPLOYEE.Emp_Salary)
--15. List out department names in which more than two employees.
select EMPLOYEE.Emp_Department, COUNT(EMPLOYEE.Emp_ID) from EMPLOYEE 
Group by Emp_Department having COUNT(EMPLOYEE.Emp_ID) > 2;