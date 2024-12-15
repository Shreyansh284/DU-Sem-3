db.borrow.insertMany([
  { LOANNO: 201, CNAME: "ANIL", BNAME: "VRCE", AMOUNT: 1000.00 },
  { LOANNO: 206, CNAME: "MEHUL", BNAME: "AJNI", AMOUNT: 5000.00 },
  { LOANNO: 311, CNAME: "SUNIL", BNAME: "DHARAMPETH", AMOUNT: 3000.00 },
  { LOANNO: 321, CNAME: "MADHURI", BNAME: "ANDHERI", AMOUNT: 2000.00 },
  { LOANNO: 375, CNAME: "PRMOD", BNAME: "VIRAR", AMOUNT: 8000.00 },
  { LOANNO: 481, CNAME: "KRANTI", BNAME: "NEHRU PLACE", AMOUNT: 3000.00 }
]);

db.customers.insertMany([
  { CNAME: "ANIL", CITY: "CALCUTTA" },
  { CNAME: "SUNIL", CITY: "DELHI" },
  { CNAME: "MEHUL", CITY: "BARODA" },
  { CNAME: "MANDAR", CITY: "PATNA" },
  { CNAME: "MADHURI", CITY: "NAGPUR" },
  { CNAME: "PRAMOD", CITY: "NAGPUR" },
  { CNAME: "SANDIP", CITY: "SURAT" },
  { CNAME: "SHIVANI", CITY: "BOMBAY" },
  { CNAME: "KRANTI", CITY: "BOMBAY" },
  { CNAME: "NAREN", CITY: "BOMBAY" }
]);

db.branch.insertMany([
  { BNAME: "VRCE", CITY: "NAGPUR" },
  { BNAME: "AJNI", CITY: "NAGPUR" },
  { BNAME: "KAROLBAGH", CITY: "DELHI" },
  { BNAME: "CHANDI", CITY: "DELHI" },
  { BNAME: "DHARAMPETH", CITY: "NAGPUR" },
  { BNAME: "M.G. ROAD", CITY: "BANGLORE" },
  { BNAME: "ANDHERI", CITY: "BOMBAY" },
  { BNAME: "VIRAR", CITY: "BOMBAY" },
  { BNAME: "NEHRU PLACE", CITY: "DELHI" },
  { BNAME: "POWAI", CITY: "BOMBAY" }
]);


<!-- 1. Retrieve all data from table DEPOSIT.  -->
db.deposit2.find()

<!-- 2. Retrieve all data from table BORROW.  -->
db.borrow.find()

<!-- 3. Retrieve all data from table CUSTOMERS.  -->
db.customers.find()

<!-- 4. Insert a record (550,’JAY’,’AJNI’,NULL)in the BORROW table. -->
db.borrow.insertOne({LOANNO: 500,
  CNAME: 'JAY',
  BNAME: 'AJNI',
  })

<!-- 5. Display Account No, Customer Name & Amount from DEPOSIT. -->
db.deposit2.find({},{ACTNO:1,CNAME:1,AMOUNT:1})

<!-- 6. Display Loan No, Amount from BORROW. -->
db.borrow.find({},{LOANNO:1,AMOUNT:1})

<!-- 7. Display loan details of all customers who belongs to ‘ANDHERI’ branch. -->
db.borrow.find({BNAME: 'ANDHERI'})
<!-- 8. Give account no and amount of depositor, whose account no is equals to 106.  -->
db.deposit2.find({ACTNO:106},{ACTNO:1,AMOUNT:1})

<!-- 9. Give name of borrowers having amount greater than 5000.  -->
db.borrow.find({AMOUNT:{$gt:5000}},{CNAME:1})
<!-- 10. Give name of customers who opened account after date '1-12-96'. -->





<!-- 11. Display name of customers whose account no is less than 105. -->
db.deposit2.find({ACTNO:{$lt:105}},{CNAME:1})


<!-- 12. Display name of customer who belongs to either ‘NAGPUR’ Or ‘DELHI’. -->
db.customers.find({CITY: {$in: ['NAGPUR', 'DELHI']}})

<!-- 13. Display name of customers with branch whose amount is greater than 4000 and account no is less than 
105. -->
db.borrow.find({$and: [{AMOUNT:{$gt}

<!-- 14. Find all borrowers whose amount is greater than equals to 3000 & less than equals to 8000. -->

<!-- 15. Find all depositors who do not belongs to ‘ANDHERI’ branch. -->

<!-- 16. Display Account No, Customer Name & Amount of such customers who belongs to ‘AJNI’, ‘KAROLBAGH’ Or 
‘M.G.ROAD’ and Account No is less than 104. -->

<!-- 17. Display all the details of first five customers. -->

<!-- 18. Display all the details of first three depositors whose amount is greater than 1000. -->

<!-- 19. Display Loan No, Customer Name of first five borrowers whose branch name does not belongs to ‘ANDHERI’. -->

<!-- 20. Retrieve all unique cities using DISTINCT. (Use Customers collectio -->