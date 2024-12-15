-- Create salesmen table
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
--1. Write a SQL query to calculate total purchase amount of all orders. Return total purchase amount.
select sum(orders.purch_amt) as [total_purchase_amount] from orders 
--2. Write a SQL query to calculate the average purchase amount of all orders. Return average purchase amount.
select AVG(orders.purch_amt) as [average_purchase_amount] from orders 
--3. Write a SQL query that counts the number of unique salespeople. Return number of salespeople.
select COUNT(distinct name) as[salespeople] from salesmen
--4. Write a SQL query to count the number of customers. Return number of customers.
select COUNT(customers.customer_id) as [customers] from customers
--5. Write a SQL query to determine the number of customers who received at least one grade for their activity.
select COUNT(customers.customer_id) as [customers] from customers where customers.grade is not null
--6. Write a SQL query to find the maximum purchase amount.
select MAX(orders.purch_amt) from orders
--7. Write a SQL query to find the minimum purchase amount.
select MIN(orders.purch_amt) from orders
--8. Write a SQL query to find the highest grade of the customers in each city. Return city, maximum grade.
select city, MAX(customers.grade) as [maximum_grade] from customers group by city
--9. Write a SQL query to find the highest purchase amount ordered by each customer. Return customer ID,
--maximum purchase amount.
select MAX(orders.purch_amt) as [maximum_purchase_amount], orders.customer_id from orders group by orders.customer_id
--10. Write a SQL query to find the highest purchase amount ordered by each customer on a particular date.
--Return, order date and highest purchase amount.
select MAX(orders.purch_amt) as [maximum_purchase_amount], orders.ord_date from orders group by orders.ord_date

-- * B
Select * from [dbo].[salesmen]
Select * from[dbo].[orders]
Select * from[dbo].[customers]

-- 1. Write a SQL query to determine the highest purchase amount made by each salesperson on '2012-08-17'.
-- Return salesperson ID, purchase amount.
SELECT salesman_id, MAX(purch_amt) AS highest_purchase
FROM orders
WHERE ord_date = '2012-08-17'
GROUP BY salesman_id;

-- 2. Write a SQL query to find the highest order (purchase) amount by each customer on a particular order date.
-- Filter the result by highest order (purchase) amount above 2000.00. Return customer id, order date and
-- maximum purchase amount.
SELECT customer_id, ord_date, MAX(purch_amt) AS highest_purchase
FROM orders
WHERE purch_amt > 2000.00
GROUP BY customer_id, ord_date
ORDER BY highest_purchase DESC;

-- 3. Write a SQL query to find the maximum order (purchase) amount in the range 2000 - 6000 (Begin and end
-- values are included.) by combination of each customer and order date. Return customer id, order date and
-- maximum purchase amount.
SELECT customer_id, ord_date, MAX(purch_amt) AS max_purchase
FROM orders
WHERE purch_amt BETWEEN 2000 AND 6000
GROUP BY customer_id, ord_date;

-- 4. Write a SQL query to find the maximum order (purchase) amount based on the combination of each
-- customer and order date. Filter the rows for maximum order (purchase) amount is either 2000, 3000, 5760,
-- 6000. Return customer id, order date and maximum purchase amount.
SELECT customer_id, ord_date, MAX(purch_amt) AS max_purchase
FROM orders
WHERE customer_id IN (3000, 3005, 5760, 6000)
GROUP BY customer_id, ord_date
HAVING MAX(purch_amt) BETWEEN 2000 AND 6000;

-- 5. Write a SQL query to determine the maximum order amount for each customer. The customer ID should be
-- in the range 3002 and 3007(Begin and end values are included.). Return customer id and maximum purchase
-- amount.
SELECT customer_id, MAX(purch_amt) AS max_purchase
FROM orders
WHERE customer_id BETWEEN 3002 AND 3007
GROUP BY customer_id;

-- 6. Write a SQL query to find the maximum order (purchase) amount for each customer. The customer ID should
-- be in the range 3002 and 3007(Begin and end values are included.). Filter the rows for maximum order
-- (purchase) amount is higher than 1000. Return customer id and maximum purchase amount.
SELECT customer_id, MAX(purch_amt) AS max_purchase
FROM orders
WHERE customer_id BETWEEN 3002 AND 3007
GROUP BY customer_id
HAVING MAX(purch_amt) > 1000;

-- 7. Write a SQL query to determine the maximum order (purchase) amount generated by each salesperson.
-- Filter the rows for the salesperson ID is in the range 5003 and 5008 (Begin and end values are included.).
-- Return salesperson id and maximum purchase amount.
SELECT salesman_id, MAX(purch_amt) AS max_purchase
FROM orders
WHERE salesman_id BETWEEN 5003 AND 5008
GROUP BY salesman_id;

-- 8. Write a SQL query to count all the orders generated on '2012-08-17'. Return number of orders.
SELECT COUNT(*) AS order_count
FROM orders
WHERE ord_date = '2012-08-17';

-- 9. Write a SQL query to count the number of salespeople in a city. Return number of salespeople.
SELECT city, COUNT(*) AS num_salespeople
FROM salesmen
GROUP BY city;

-- 10. Write a SQL query to count the number of orders based on the combination of each order date and
-- salesperson. Return order date, salesperson id.
SELECT ord_date, salesman_id, COUNT(*) AS num_orders
FROM orders
GROUP BY ord_date, salesman_id;

-- * C
-- 1. Write a SQL query to calculate the average product price. Return average product price.
SELECT AVG(purch_amt) AS average_product_price
FROM orders;
-- 2. Write a SQL query to count the number of products whose price are higher than or equal to 350. Return
-- number of products.
SELECT COUNT(*) AS number_of_products
FROM orders
WHERE purch_amt >= 350;
-- 3. Write a SQL query to compute the average price for unique companies. Return average price and company
-- id.
SELECT customer_id, AVG(purch_amt) AS average_price
FROM orders
GROUP BY customer_id;
-- 4. Write a SQL query to compute the sum of the allotment amount of all departments. Return sum of the
-- allotment amount.
SELECT salesman_id, SUM(purch_amt) AS sum_of_allotment_amount
FROM orders
GROUP BY salesman_id;
-- 5. Write a SQL query to count the number of employees in each department. Return department code and
-- number of employees.
SELECT salesman_id, COUNT(*) AS number_of_employees
FROM customers
GROUP BY salesman_id;


