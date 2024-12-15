#mongodb lab - 17

<!-- * data -->

db.employee.insertMany([
{ EID: 1, ENAME: "Nick", GENDER: "Male", JOININGDATE: new Date("01-JAN-13"), SALARY: 4000, CITY: "London" },
{ EID: 2, ENAME: "Julian", GENDER: "Female", JOININGDATE: new Date("01-OCT-14"), SALARY: 3000, CITY: "New York" },
{ EID: 3, ENAME: "Roy", GENDER: "Male", JOININGDATE: new Date("01-JUN-16"), SALARY: 3500, CITY: "London" },
{ EID: 4, ENAME: "Tom", GENDER: "Male", JOININGDATE: new Date(null), SALARY: 4500, CITY: "London" },
{ EID: 5, ENAME: "Jerry", GENDER: "Male", JOININGDATE: new Date("01-FEB-13"), SALARY: 2800, CITY: "Sydney" },
{ EID: 6, ENAME: "Philip", GENDER: "Male", JOININGDATE: new Date("01-JAN-15"), SALARY: 7000, CITY: "New York" },
{ EID: 7, ENAME: "Sara", GENDER: "Female", JOININGDATE: new Date("01-AUG-17"), SALARY: 4800, CITY: "Sydney" },
{ EID: 8, ENAME: "Emily", GENDER: "Female", JOININGDATE: new Date("01-JAN-15"), SALARY: 5500, CITY: "New York" },
{ EID: 9, ENAME: "Michael", GENDER: "Male", JOININGDATE: new Date(null) , SALARY: 6500, CITY: "London" },
{ EID: 10, ENAME: "John", GENDER: "Male", JOININGDATE: new Date("01-JAN-15"), SALARY: 8800, CITY: "London" }
])

<!-- * A -->
<!-- 1. Display employees whose gender is Male. -->

db.employee.find({GENDER: 'Male'})

<!-- 2. Display employees who belong to London city. -->

db.employee.find({CITY: 'London'})

<!-- 3. Display employees whose salary is greater than 3500. -->

db.employee.find({SALARY: {$gt: 3500}})

<!-- 4. Display employees whose joining date is before 2015-01-01. -->

db.employee.find({
JOININGDATE: { $lt: new Date("2015-01-01") }
})

<!-- 5. Display employees whose EID is greater than or equal to 7. -->

db.employee.find({EID: {$gte: 7}})

<!-- 6. Display employees whose city is Landon or New York (use:IN) -->

db.employee.find({CITY: {$in: ['London', 'New York']}})

<!-- 7. Display employees who do not belongs to Landon or New York (use: NOT IN) -->

db.employee.find({CITY: {$nin: ['London', 'New York']}})

<!-- 8. Display the EID of those employee who lives in city London. -->

db.employee.find({CITY: 'London'}, {EID: 1})

<!-- 9. Display first 2 employee names who lives in New york. -->

db.employee.find({CITY: 'New York'}).limit(2)

<!-- 10. Display next 2 employee after skipping first 2 whose city is London. -->

db.employee.find({CITY: 'London'}).skip(2).limit(2)

<!-- 11. Display Male employees who lives Sydney. -->

db.employee.find({$and: [{GENDER: 'Male'}, {CITY: 'Sydney'}]})

<!-- 12. Display EID, ENAME, CITY and SALARY of those employees who belongs to London or Sydney. -->

db.employee.find({$or: [{CITY: 'London'}, {CITY: 'Sydney'}]}, {EID: 1, ENAME: 1, CITY: 1})

<!-- 13. Display ENAME, SALARY, and CITY of those employee whose salary is more than 7000. -->

db.employee.find({SALARY: {$gt: 7000}}, {ENAME: 1, SALARY: 1, CITY: 1})

<!-- 14. Display documents whose name start with E. -->

db.employee.find({ENAME: {$regex: /^E/}})
db.employee.find({ENAME:/^E/})

<!-- 15. Display documents whose name starts with S or M in your collection. -->

db.employee.find({
ENAME: { $regex: /^[SM]/ }
})

db.employee.find({ENAME:/^[SM]/})

<!-- 16. Display documents where city starts with A to M in your collection. -->

db.employee.find({
CITY: { $regex: /^[A-M]/ }
})

db.employee.find({ENAME:/^[A-M]/})

<!-- 17. Display documents where city name ends in ‘ney’. -->

db.employee.find({
CITY: { $regex: /ney$/ }
})

db.employee.find({ENAME:/[ney]$/i})

<!-- 18. Display employee info whose name contains n. (Both uppercase(N) and lowercase(n)) -->

db.employee.find({
ENAME: { $regex: /n/i }
})
db.employee.find({ENAME:/^n/i})

<!-- 19. Display employee info whose name starts with E and having 5 characters. -->

db.employee.find({
ENAME: { $regex: /^E.{4}$/ }
})
db.employee.find({ENAME:/^E..../})

<!-- 20. Display employee whose name start with S and ends in a. -->

db.employee.find({
ENAME: { $regex: /^S.*a$/ }
})
db.employee.find({ENAME:/^S.*a$/})


<!-- 21. Display EID, ENAME, CITY and SALARY whose name starts with ‘Phi’. -->

db.employee.find({
ENAME: { $regex: /^Phi/ }
}, {
EID: 1, ENAME: 1, CITY: 1, SALARY: 1, _id: 0
})

db.employee.find({ENAME:/^Phi/},EID: 1, ENAME: 1, CITY: 1, SALARY: 1, _id: 0)

<!-- 22. Display ENAME, JOININGDATE and CITY whose city contains ‘dne’ as three letters in city name. -->

db.employee.find({
CITY: { $regex: /dne/ }
}, {
ENAME: 1, JOININGDATE: 1, CITY: 1, _id: 0
})

db.employee.find({ENAME:/dne/},{
ENAME: 1, JOININGDATE: 1, CITY: 1, _id: 0
})

<!-- 23. Display ENAME, JOININGDATE and CITY who does not belongs to city London or Sydney. -->

db.employee.find({CITY: {$nin: ['London', 'Sydney']}}, {ENAME: 1, JOININGDATE: 1, CITY: 1})

<!-- 24. Delete the documents whose city is New York. -->

db.employee.deleteMany({CITY: 'New York'})

<!-- 25. Update ENAME of Nick to ‘Naysa’ and GENDER to ‘Female’. -->

db.employee.updateOne({ENAME: 'Nick'}, {$set: {ENAME: 'Naysa', GENDER: 'Female'}})

<!-- * B -->
<!-- 1. Display Female students. -->

db.student.find({GENDER: 'Female'})

<!-- 2. Display students who belong to Rajkot city. -->

db.student.find({CITY: 'Rajkot'})

<!-- 3. Display students studying in 7th sem. -->

db.student.find({SEM: 7})

<!-- 4. Display students not studying in 3rd sem. -->

db.student.find({SEM: {$ne: 3}})

<!-- 5. Display students whose roll no is greater than 107. -->

db.student.find({ROLLNO: {$gt: 107}})

<!-- 6. Display students whose city is Jamnagar or Baroda (use:IN) -->

db.student.find({CITY: {$in: ['Jamnagar', 'Baroda']}})

<!-- 7. Display students whose fees is less than 9000. -->

db.student.find({FEES: {$lt: 9000}})

<!-- 8. Display the roll no of those students who belongs to Mechanical department -->

db.student.find({DEPARTMENT: 'Mechanical'}, {ROLLNO: 1})

<!-- 9. Display first 2 students names who lives in Baroda. -->

db.student.find({CITY: 'Baroda'}, {SNAME: 1}).limit(2)

<!-- 10. Display Male students who studying in 3rd sem. -->

db.student.find({$and: [{GENDER: 'Male'}, {SEM: 3}]})

<!-- 11. Display sname and city and fees of those students whose roll no is less than 105. -->

db.student.find({ROLLNO: {$lt: 105}}, {SNAME: 1, CITY: 1, FEES: 1})

<!-- 12. Display documents where sname start with K. -->

db.student.find({SNAME: {$regex: /^K/}})
db.student.find({ENAME:/^K/})

<!-- 13. Display documents where sname starts with Z or D in your collection. -->

db.student.find({SNAME: {$regex: /^[ZD]/}})
db.student.find({SNAME:/^[ZD]/})

<!-- 14. Display documents where city starts with A to R in your collection. -->

db.student.find({CITY: {$regex: /^[A-R]/}})
db.student.find({CITY:/^[A-R]/i})
<!-- 15. Display students’ info whose name start with P and ends in i. -->
db.student.find({SNAME: {$regex: /^P.*i/}})
db.student.find({SNAME:/^P.*i/i})

<!-- 16. Display students’ info whose department name starts with ‘C’. -->
db.student.find({DEPARTMENT: {$regex: /^C/}})
db.student.find({DEPARTMENT:/^C/})

<!-- 17. Display name, sem, fees, and department whose city contains ‘med’ as three letters somewhere in city name. -->

db.student.find(
    {CITY: { $regex: /med/ }}, 
    {SNAME: 1, SEM: 1, FEES: 1, DEPARTMENT: 1, _id: 0}
)
db.student.find(
    {CITY:  /med/ }, 
    {SNAME: 1, SEM: 1, FEES: 1, DEPARTMENT: 1, _id: 0}
)



<!-- 18. Display name, sem, fees, and department who does not belongs to city Rajkot or Baroda. -->
db.student.find(
    {CITY: {$nin: ['Rajkot', 'Baroda']}}, 
    {SNAME: 1, SEM: 1, FEES: 1, DEPARTMENT: 1, _id: 0}
)

<!-- 19. Delete the documents whose city is Jamnagar. -->

db.student.deleteMany({CITY: 'Jamnagar'})

<!-- 20. Update sname of Krish to ‘fenny’ and gender to ‘Female’. -->

db.student.updateOne({SNAME: 'Krish'}, 
    {
        $set: {SNAME: 'Fenny', GENDER: 'Female'}
    }
)

<!-- * C -->
<!-- 1. Display next 2 students after skipping first 2 whose city is Ahmedabad. -->
db.student.find({CITY: 'Ahmedabad'}).skip(2).limit(2)

<!-- 2. Display rollno, sname, fees, and department of those students who is from Baroda and belongs to CE department. -->

db.student.find(
    {$and: [{CITY: 'Baroda'}, {DEPARTMENT: 'CE'}]},
    {ROLLNO: 1, SNAME: 1, FEES: 1, DEPARTMENT: 1, _id: 0}
)

<!-- 3. Display documents where city name ends in ‘oda’. -->

  db.student.find({
    CITY: { $regex: /oda$/ }
  })

db.student.find({CITY:/oda$/i})


<!-- 4. Display students’ info whose name contains v. (Both uppercase(V) and lowercase(v)) -->

db.student.find({
  SNAME: { $regex: /v/i }
})

<!-- 5. Display students’ info whose name starts with V and having 4 characters. -->

db.student.find({
  SNAME: { $regex: /^V.{3}$/ }
})

