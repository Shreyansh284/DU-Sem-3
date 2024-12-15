-- * A
-- 1. Write a function to print "hello world".
Create FUNCTION printHelloWorld()
Returns Varchar(255)
AS 
BEGIN
	return 'hello world';
END

select [dbo].[printHelloWorld]()
-- 2. Write a function which returns addition of two numbers.
Create FUNCTION addTwoNumbers(@num1 int, @num2 int)
Returns INT
AS 
BEGIN
	return @num1 + @num2;
END
select [dbo].[addTwoNumbers](2,4)
-- 3. Write a function to print a cube of a given number.
create function cubeOfNum(@num1 int)
returns int
as 
begin 
	return @num1 * @num1 * @num1
end

select [dbo].[cubeOfNum](2)
-- 4. Write a function to check whether the given number is ODD or EVEN.
create function isOddOrEven(@num1 int)
returns varchar(255)
as 
begin 
	if (@num1 % 2 = 0) 
	begin 
		return 'Even'
	end
	return 'Odd'
end

select [dbo].[isOddOrEven](5)
-- 5. Write a function which returns a table with details of a person whose first name starts with B.
create function personNamesStartsWithB()
returns @customTable table (name varchar(255))
as 
begin 
	insert into @customTable 
	select * from person where name Like('b%') or name like('B%')
	return
end

create table person(
	name varchar(255)
)

insert into person values ('Bob'), ('bob2'), ('demo')
select * from person;

select * from [dbo].[personNamesStartsWithB]()
-- 6. Write a function which returns a table with unique first names from the person table.
create function personUniqueNames()
returns @customTable table (name varchar(255))
as 
begin 
	insert into @customTable 
	select Distinct name from person
	return
end

select * from [dbo].personUniqueNames()

-- * B
-- 1. Write a function to compare two integers and return the comparison result. (Using Case statement)
create function compareTwoIntegers(@num1 int, @num2 int)
returns varchar(255)
as 
begin 
	return CASE WHEN @num1 > @num2 THEN 'Num1 is greater'
		WHEN @num1 = @num2 THEN 'Both are equal'
		ELSE 'Num2 is greater'
	END
end

select [dbo].[compareTwoIntegers](15,10)

-- 2. Write a function to print number from 1 to N. (Using while loop)
CREATE FUNCTION Print1toNnum (@num1 INT)
RETURNS VARCHAR(255)
AS
BEGIN
    DECLARE @i INT = 1;
    DECLARE @result VARCHAR(255) = '';

    WHILE @i <= @num1
    BEGIN
        SET @result = @result + CAST(@i AS VARCHAR(10)) + ' ';
        SET @i = @i + 1;
    END

    RETURN RTRIM(@result);  -- Remove the trailing space
END

select [dbo].[Print1toNnum](10)

---3. Write a function to print the sum of even numbers between 1 to 20. 
CREATE FUNCTION SumEvenNumbers()
RETURNS INT
AS
BEGIN
    DECLARE @i INT = 1;
    DECLARE @sum INT = 0;

    WHILE @i <= 20
    BEGIN
        IF @i % 2 = 0
        BEGIN
            SET @sum = @sum + @i;
        END
        SET @i = @i + 1;
    END

    RETURN @sum;
END

select [dbo].[SumEvenNumbers]()