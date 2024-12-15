-- Part - A
  CREATE TABLE STUDENT(
	StuID int,
	FirstName varchar(100),
	LastName varchar(100),
	Website varchar(200),
	City varchar(50),
	Division varchar(50)
  )

  INSERT INTO STUDENT VALUES
  (1011,'Keyur', 'Patel', 'techonthenet.com', 'Rajkot', 'II-BCX'),
(1022, 'Hardik', 'Shah', 'digminecraft.com', 'Ahmedabad', 'I-BCY'),
(1033, 'Kajal', 'Trivedi', 'bigactivities.com', 'Baroda', 'IV-DCX'),
(1044, 'Bhoomi', 'Gajera', 'checkyourmath.com', 'AhmedabadV', 'III-DCW'),
(1055, 'Harmit', 'Mitel', NULL, 'Rajkot', 'II-BCY'),
(1066, 'Ashok','Jani', NULL, 'Baroda', 'II-BCZ')

--Part B

CREATE TABLE CUSTOMER(
	CID int,
	CustomerName varchar(100),
	ContactName varchar(100),
	Address varchar(200),
	City varchar(50),
	PostalCode varchar(50),
	Country varchar(50)
)

INSERT INTO CUSTOMER VALUES
(1, 'Alfreds Futterkiste', 'Maria Anders', 'Obere Str. 57', 'Berlin', '12209', 'Germany'),
(2, 'AAna Trujillo Emparedados y helados', 'Ana Trujillo', 'Avda. de la Constit', 'Mexico D.F.', '05021', 'Mexico'),
(3, 'Antonio Moreno Taqueria', 'Antonio Moreno', 'Mataderos 2312 ', 'Mexico D.F.', '05023', 'Mexico'),
(4, 'Around the Horn', 'Thomas Hardy', '120 Hanover Sq.', 'London', 'WA1 1DP', 'UK'),
(5, 'Berglunds snabbkop ', 'Christina Berglund', 'Berguvsvagen 8', 'Lulea', 'S-958 22', 'Sweden')

--Part C

create table Customer_2(
CID int,
Name varchar(50),
Age int,
Address varchar(244),
Salary varchar(12)
)
select * from Customer_2

insert into Customer_2 values 
(1, 'Ramesh', 32, 'Ahmedabad', '2000.00'),
(2, 'Khilan', 25, 'Delhi', '1500.00'),
(3, 'Kaushik', 23, 'Kota', '2000.00'),
(4, 'Chaitali', 25, 'Mumbai', '6500.00'),
(5, 'Hardik', 27, 'Bhopal', '8500.00'),
(6, 'Komal', 22, 'Hyderabad', '4500.00'),
(7, 'Muffy', 24, 'Indore', '10000.00')

--Display the name of students whose name starts with �k�.

SELECT * FROM STUDENT1 WHERE FirstName LIKE 'K%'

--Display the name of students whose name consists of five characters

SELECT * FROM STUDENT1 WHERE FirstName LIKE '_____'

--Retrieve the first name & last name of students whose city name ends with a & contains six characters.

SELECT FIRSTNAME ,LASTNAME,CITY FROM STUDENT1 WHERE CITY LIKE '%A' AND CITY LIKE '______'

--Display all the students whose last name ends with �tel�

SELECT LASTNAME FROM STUDENT1 WHERE LASTNAME LIKE '%TEL'

--Display all the students whose first name starts with �ha� & ends with�t�.

SELECT FIRSTNAME FROM STUDENT1 WHERE FIRSTNAME LIKE 'HA%T'

--Display all the students whose first name starts with �k� and third character is �y�.

SELECT FIRSTNAME FROM STUDENT1 WHERE FIRSTNAME LIKE 'K_Y%'

--Display the name of students having no website and name consists of five characters

SELECT	FIRSTNAME , WEBSITE FROM STUDENT1 WHERE WEBSITE IS NULL AND FIRSTNAME LIKE '_____'

--Display all the students whose last name consist of �jer�. 

SELECT LASTNAME FROM STUDENT1 WHERE LASTNAME LIKE '%JER%'

--Display all the students whose city name starts with either �r� or �b�.	

SELECT CITY FROM STUDENT1 WHERE CITY LIKE '%R' OR CITY LIKE 'B%'

--Display all the name students having websites.

SELECT *  FROM STUDENT1 WHERE website IS NOT NULL

--Display all the students whose name starts from alphabet A to H.

SELECT * FROM STUDENT1 WHERE FIRSTNAME LIKE '[A-H]%'

--Display all the students whose name�s second character is vowel.

SELECT * FROM STUDENT1 WHERE  FIRSTNAME LIKE '_[A,E,I,O,U]%'

--Display student�s name whose city name consist of �rod�.

SELECT * FROM STUDENT1 WHERE CITY LIKE '%ROD%'

--Retrieve the First & Last Name of students whose website name starts with �bi�

SELECT FIRSTNAME, LASTNAME FROM STUDENT1 WHERE WEBSITE LIKE 'BI%'

--Display student�s city whose last name consists of six characters.

SELECT * FROM STUDENT1 WHERE LASTNAME LIKE '______'

--Display all the students whose city name consist of five characters & not starts with �ba�.

SELECT * FROM STUDENT1 WHERE CITY LIKE '_____' AND CITY NOT LIKE 'BA%'

--Show all the student�s whose division starts with �II�

SELECT * FROM STUDENT1 WHERE DIVISION LIKE 'II%'

--Find out student�s first name whose division contains �bc� anywhere in division name

SELECT FirstName FROM STUDENT1 WHERE DIVISION LIKE '%BC%'

--Show student id and city name in which division consist of six characters and having website name.

SELECT STUID , CITY FROM STUDENT1 WHERE  DIVISION LIKE '______' AND WEBSITE IS NOT NULL

--Display all the students whose name�s third character is consonant

SELECT * FROM STUDENT1 WHERE  FIRSTNAME LIKE '__[^A,E,I,O,U]%'
SELECT * FROM STUDENT1 WHERE  FIRSTNAME NOT LIKE '__[A,E,I,O,U]%'

select * from CUSTOMER

SELECT * FROM Customer WHERE City LIKE 'L_nd__';

SELECT * FROM Customer WHERE City LIKE '%L%';

SELECT * FROM Customer WHERE City NOT LIKE '%L%';

SELECT * FROM Customer WHERE CustomerName LIKE 'La%';

SELECT * FROM Customer WHERE CustomerName NOT LIKE 'La%';

SELECT * FROM Customer WHERE CustomerName LIKE 'a%' OR CustomerName LIKE 'b%';

SELECT * FROM Customer WHERE CustomerName LIKE 'a%' OR CustomerName LIKE 'c%' OR CustomerName LIKE 't%';

SELECT * FROM Customer WHERE CustomerName BETWEEN 'a' AND 'd%';

SELECT * FROM Customer WHERE CustomerName LIKE '%a';

SELECT * FROM Customer WHERE CustomerName LIKE 'b%s';

SELECT * FROM Customer WHERE CustomerName LIKE '%or%';

SELECT * FROM Customer WHERE CustomerName LIKE 'a__' OR CustomerName LIKE 'a___' OR CustomerName LIKE 'a____';

SELECT * FROM Customer WHERE CustomerName LIKE '_r%';

SELECT * FROM Customer WHERE Country = 'Spain';