1. Display distinct city.
    db.employee.distinct("city")
2. Display city wise number of persons.
db.employee.aggregate([{$group:{_id:$CITY,total:{$sum:1}}}])
3. Display sum of salary in your collection.
db.employee.aggregate([{$group:{_id:null,total:{$sum:"$SALARY"}}}])
4. Display average of salary in your document.
db.employee.aggregate([{$group:{_id:null,total:{$avg:"$SALARY"}}}])
5. Display maximum and minimum salary of your document.
db.employee.aggregate([{$group:{_id:null,maxSalary:{$max:"$SALARY"},minSalary:{$min:"$SALARY"}}}])
6. Display city wise total salary in your collection.
db.employee.aggregate([{$group:{_id:"$CITY",total:{$sum:"$SALARY"}}}])
7. Display gender wise maximum salary in your collection.
db.employee.aggregate([{$group:{_id:"$GENDER",maxSalary:{$max:"$SALARY"}}}])
8. Display city wise maximum and minimum salary.
db.employee.aggregate([{$group:{_id:"$CITY",maxSalary:{$max:"$SALARY"},minSalary:{$min:"$SALARY"}}}])
9. Display count of persons lives in Sydney city in your collection.
db.employee.find({CITY:"Sydney"}).count()
10. Display average salary of New York city.
db.employee.aggregate([{$group:{_id:"$CITY",avgSalary:{$avg:"$SALARY"}}},{$match:{_id:"New York"}}])

<!-- B . Aggregate Functions -->

1. Display distinct department.
db.student.distinct("DEPARTMENT")
2. Display city wise number of student.
db.student.aggregate([{$group:{_id:$CITY,total:{$sum:1}}}])
3. Display sum of fees in your collection.
db.student.aggregate([{$group:{_id:null,total:{$sum:"$FEES"}}}])
4. Display average of fees in your document.
db.student.aggregate([{$group:{_id:null,total:{$avg:"$FEES"}}}])
5. Display maximum and minimum fees of your document.
db.student.aggregate([{$group:{_id:null,maxFees:{$max:"$FEES}}}])
