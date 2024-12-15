#mongodb lab - 16

<!-- * A -->
<!-- 1. Retrieve/Display every document of Deposit collection. -->

db.deposit.insertMany([
{
ACTNO: 101,
CNAME: "ANIL",
BNAME: "VRCE",
AMOUNT: 1000.0,
ADATE: "1-3-95",
},
{
ACTNO: 102,
CNAME: "SUNIL",
BNAME: "AJNI",
AMOUNT: 5000.0,
ADATE: "4-1-96",
},
{
ACTNO: 103,
CNAME: "MEHUL",
BNAME: "KAROLBAGH",
AMOUNT: 3500.0,
ADATE: "17-11-95",
},
{
ACTNO: 104,
CNAME: "MADHURI",
BNAME: "CHANDI",
AMOUNT: 1200.0,
ADATE: "17-12-95",
},
{
ACTNO: 105,
CNAME: "PRMOD",
BNAME: "M.G. ROAD",
AMOUNT: 3000.0,
ADATE: "27-3-96",
},
{
ACTNO: 106,
CNAME: "SANDIP",
BNAME: "ANDHERI",
AMOUNT: 2000.0,
ADATE: "31-3-96",
},
{
ACTNO: 107,
CNAME: "SHIVANI",
BNAME: "VIRAR",
AMOUNT: 1000.0,
ADATE: "5-9-95",
},
{
ACTNO: 108,
CNAME: "KRANTI",
BNAME: "NEHRU PLACE",
AMOUNT: 5000.0,
ADATE: "2-7-95",
},
]);

<!-- 2. Retrieve/Display every document of Deposit collection. (Use: pretty()) -->

db.deposit.find().pretty()

<!-- 3. Display only one document of Deposit collection. (Use: findOne()) -->

db.deposit.findOne()

<!-- 4. Insert following document to Deposit collection. (Use: insertOne()) -->

db.deposit.insertOne({
ACTNO:109 ,
CNAME:'KIRTI' ,
BNAME:'VIRAR',
AMOUNT:3000.00 ,
ADATE:'3-5-97',
})

<!-- 5. Insert following documents to your collection. (Use: insertMany()) -->

db.deposit.insertMany([

{
ACTNO:110,
CNAME:'MITALI',
BNAME:'ANDHERI',
AMOUNT:4500.00,
ADATE:'4-9-95',
},
{
ACTNO:111,
CNAME:'RAJIV',
BNAME:'NEHRU PLACE',
AMOUNT:7000.00,
ADATE:'2-10-98',
}
])

<!-- 6. Display documents with CNAME, BNAME and AMOUNT fields. -->

db.deposit.find({}, {CNAME: 1, BNAME: 1, AMOUNT: 1})

<!-- 7. Display every document of Deposit collection on ascending order by CNAME. -->

db.deposit.find().sort({CNAME: 1})

<!-- 8. Display every document of Deposit collection on descending order by BNAME. -->

db.deposit.find().sort({BNAME: 1})

<!-- 9. Display every document of Deposit collection on ascending order by ACTNO and descending order by AMOUNT. -->

db.deposit.find({}).sort({ ACTNO: 1, AMOUNT: -1 })

<!-- 10. Display only two documents of Deposit collection. -->

db.deposit.find({}).limit(2)

<!-- 11. Display 3rd document of Deposit collection. -->

db.deposit.find({}).skip(2).limit(1)

<!-- 12. Display 6th and 7th documents of Deposit collection. -->

db.deposit.find({}).skip(5).limit(2)

<!-- 13. Display the count of documents in Deposit collection. -->

db.deposit.countDocuments()

<!-- 14. Display only first documents of Deposit collection. -->

db.deposit.findOne()

<!-- 15. Display every document of Deposit collection on descending order by AMOUNT. -->

db.deposit.find().sort({AMOUNT: -1})

<!-- * B -->
<!-- 1. Insert following document to Deposit collection. (Use: insertOne()) -->

db.deposit.insertOne({
ACTNO:112,
CNAME:'MANISH',
BNAME:'ANDHERI',
AMOUNT:8000.00,
ADATE:'9-5-98',
})

<!-- 2. Display 9th document of Deposit collection. -->

db.deposit.find().skip(8).limit(1)

<!-- 3. Display 11th and 12th documents of Deposit collection. -->

db.deposit.find().skip(10).limit(2)

<!-- * C -->
<!-- 1. Display every document of Deposit collection on ascending order by AMOUNT and descending order by BNAME. -->

db.deposit.find().sort({AMOUNT: 1, BNAME: -1})

<!-- 2. Display only five documents of Deposit collection. -->

db.deposit.find().limit(5)

<!-- 3. Delete all the documents of collection Deposit. -->

db.deposit.deleteMany({})

<!-- 4. Drop BANK_INFO database. -->

db.dropDatabase()
