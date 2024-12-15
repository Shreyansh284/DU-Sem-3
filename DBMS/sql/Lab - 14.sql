-- Create the Products table
CREATE TABLE Products (
    Product_id INT PRIMARY KEY,
    Product_Name VARCHAR(250) NOT NULL,
    Price DECIMAL(10,2) NOT NULL
);

-- Insert data into the Products table
INSERT INTO Products (Product_id, Product_Name, Price) VALUES
(1, 'Smartphone', 35000),
(2, 'Laptop', 65000),
(3, 'Headphones', 5500),
(4, 'Television', 85000),
(5, 'Gaming Console', 32000);

-- Re-insert data into the Products table for the next operations
INSERT INTO Products (Product_id, Product_Name, Price) VALUES
(1, 'Smartphone', 35000),
(2, 'Laptop', 65000),
(3, 'Headphones', 5500),
(4, 'Television', 85000),
(5, 'Gaming Console', 32000);

-- 1. Create a cursor Product_Cursor to fetch all the rows from a products table.
DECLARE fetchAllProducts CURSOR FOR SELECT * FROM Products
OPEN fetchAllProducts
while @@fetch_status = 0 
    begin 
        fetch next from fetchAllProducts
    end
close fetchAllProducts
deallocate fetchAllProducts

-- 2. Create a cursor Product_Cursor_Fetch to fetch the records in form of ProductID_ProductName.
-- (Example: 1_Smartphone)
-- Create a cursor Product_CursorDelete that deletes all the data from the Products table.
DECLARE Product_Cursor_Fetch CURSOR FOR SELECT Product_id, Product_Name, Price FROM Products
declare @Product_id INT, @Product_Name varchar(255), @Price int
OPEN fetchAllProducts
fetch next from fetchAllProducts into @Product_id, @Product_Name, @Price
while @@fetch_status = 0 
    begin 
		select @Product_id, @Product_Name, @Price
        fetch next from fetchAllProducts into @Product_id, @Product_Name, @Price
    end
close fetchAllProducts
deallocate fetchAllProducts

DECLARE Product_CursorDelete CURSOR FOR SELECT Product_id FROM Products
DECLARE @Product_id INT
OPEN Product_CursorDelete
fetch next from Product_CursorDelete into @Product_id
while @@fetch_status = 0 
    begin 
		delete from Products where Product_id = @Product_id
        fetch next from fetchAllProducts into @Product_id
    end
close Product_CursorDelete
deallocate Product_CursorDelete
