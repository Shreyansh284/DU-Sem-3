

---------------------------------- Part A ------------------------------------------------------


-- Table Creation for CITY
CREATE TABLE CITY (
    CityID INT PRIMARY KEY,
    Name NVARCHAR(50) UNIQUE NOT NULL,
    Pincode NVARCHAR(6) NOT NULL,
    Remarks NVARCHAR(50)
);

INSERT INTO CITY (CityID, Name, Pincode, Remarks) VALUES
(1, 'Rajkot', '360005', 'Good'),
(2, 'Surat', '335009', 'Very Good'),
(3, 'Baroda', '390001', 'Awesome'),
(4, 'Jamnagar', '361003', 'Smart'),
(5, 'Junagadh', '362229', 'Historic'),
(6, 'Morvi', '363641', 'Ceramic');

-- Table Creation for VILLAGE
CREATE TABLE VILLAGE (
    VID INT PRIMARY KEY,
    Name NVARCHAR(50) NOT NULL,
    CityID INT,
    FOREIGN KEY (CityID) REFERENCES CITY(CityID)
);

INSERT INTO VILLAGE (VID, Name, CityID) VALUES
(101, 'Raiya', 1),
(102, 'Madhapar', 1),
(103, 'Dodka', 3),
(104, 'Falla', 4),
(105, 'Bhesan', 5),
(106, 'Dhoraji', 5);


-- * A
-- 1. Display all the villages of Rajkot city.
select v.name from VILLAGE v, CITY c where v.CityID = c.CityID and c.Name='Rajkot';
-- 2. Display city along with their villages & pin code.
select c.Name, v.Name, c.Pincode from VILLAGE v, CITY c where v.CityID = c.CityID;
-- 3. Display the city having more than one village.
select c.Name, count(v.CityID) from VILLAGE v, CITY c where v.CityID = c.CityID 
group by c.Name
having count(v.CityID) > 1;
-- 4. Display the city having no village.
select c.Name from 
VILLAGE v left join CITY c 
v.CityID on c.CityID 
group by c.Name
having count(v.CityID) = 0;
-- 5. Count the total number of villages in each city.
select c.Name, count(v.CityID) from VILLAGE v, CITY c where v.CityID = c.CityID
group by c.Name;
-- 6. Count the number of cities having more than one village.
select Distinct count(v.CityID) 
from VILLAGE v, CITY c where v.CityID = c.CityID 
group by c.Name
having count(v.CityID) > 1;

-- Student Table Creation
CREATE TABLE Student (
    StudentID INT PRIMARY KEY,
    Name NVARCHAR(50),
    SPI FLOAT CHECK (SPI BETWEEN 0 AND 10),
    Bklog INT CHECK (Bklog >= 0),
    Branch NVARCHAR(50) DEFAULT 'General'
);

INSERT INTO Student (StudentID, Name, Branch, SPI, Bklog) VALUES
(101, 'Raju', 'CE', 8.80, 0),
(102, 'Amit', 'CE', 2.20, 3),
(103, 'Sanjay', 'ME', 1.50, 6),
(104, 'Neha', 'EC', 7.65, 0),
(105, 'Meera', 'EE', 5.52, 2),
(106, 'Mahesh', 'General', 4.50, 3);

update Student set SPI = 12 where StudentID=101;
update Student set Bklog = -1 where StudentID=104;

-- * B 
-- Dept(Did, Dname)
CREATE TABLE DEPT (
    Did int PRIMARY KEY,
    DNAME VARCHAR(255) UNIQUE NOT NULL,
)

-- City(Cid, Cname)
CREATE TABLE CITY_2 (
    Cid int PRIMARY KEY,
    Cname VARCHAR(255) UNIQUE NOT NULL,
)

-- Emp(Eid, Ename, Did, Cid, Salary, Experience)
CREATE TABLE Emp (
    Eid int PRIMARY KEY,
    Ename VARCHAR(255) NOT NULL,
    DID INT NOT NULL,
    CID INT NOT NULL,
    SALARY INT CHECK(SALARY >= 0),
    Experience INT CHECK(Experience >= 0),
    FOREIGN KEY (DID) REFERENCES DEPT(Did),
    FOREIGN KEY (CID) REFERENCES CITY_2(Cid)
)

INSERT INTO DEPT VALUES (1, 'SALES')
INSERT INTO DEPT VALUES (2, 'TECH')

INSERT INTO CITY_2 VALUES (1, 'RAJKOT')
INSERT INTO CITY_2 VALUES (2, 'AHEMDABAD')

INSERT INTO Emp VALUES (101, 'DEMO', 1, 1, 1000, 1)

INSERT INTO Emp VALUES (101, '', 2, 2, -200, -50);

-- * C
-- Emp(Eid, Ename, Did, Cid, Salary, Experience)
CREATE TABLE Emp_2 (
    Eid int PRIMARY KEY,
    Ename VARCHAR(255) NOT NULL,
    DID INT NOT NULL,
    CID INT NOT NULL,
    SALARY INT CHECK(SALARY >= 0),
    Experience INT CHECK(Experience >= 0),
    FOREIGN KEY (DID) REFERENCES DEPT_2(Did),
    FOREIGN KEY (CID) REFERENCES CITY_3(Cid)
)

-- Dept(Did, Dname)
CREATE TABLE DEPT_2 (
    Did int PRIMARY KEY,
    DNAME VARCHAR(255) UNIQUE NOT NULL,
)

-- City(Cid, Cname)
CREATE TABLE CITY_3 (
    Cid int PRIMARY KEY,
    Cname VARCHAR(255) UNIQUE NOT NULL,
    Did int,
    FOREIGN KEY (Did) REFERENCES District(Did)
)

-- District(Did, Dname, Sid)
CREATE TABLE District (
    Did int PRIMARY KEY,
    Dname VARCHAR(255) UNIQUE NOT NULL,
    Sid INT,
    FOREIGN KEY (Sid) REFERENCES State(Sid)
)

-- State(Sid, Sname, Cid)
CREATE TABLE State (
    Sid int PRIMARY KEY,
    Sname VARCHAR(255) UNIQUE NOT NULL,
    Cid INT,
    FOREIGN KEY(Cid) REFERENCES Country(Cid)
)

-- Country(Cid, Cname)
CREATE TABLE Country (
    Cid int PRIMARY KEY,
    Cname VARCHAR(255) UNIQUE NOT NULL,
)
