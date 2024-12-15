#mongodb lab - 25

<!-- * Part A -->

<!-- 1. Combine information from student and result table using cross join or Cartesian product. -->
db.student2.aggregate([
  {
		$lookup: {
			from: "result2",
			localField: "Rno",
			foreignField: "Rno",
			as: "RESULTS"
		}
	}
])

<!-- 2. Display Rno, Name, Branch and SPI of all students. -->
db.student2.aggregate([
  {
		$lookup: {
			from: "result2",
			localField: "Rno",
			foreignField: "Rno",
			as: "RESULTS"
		}
	}, {
    $project: {
			Rno: 1,
			Name: 1,
			Branch: 1,
			SPI: {$arrayElemAt:['$RESULTS.SPI',0]}
		}
	}
])
<!-- 3. Display Rno, Name, Branch and SPI of CE branch’s student only. -->
db.student2.aggregate([ 
	{
		$match: {Branch: 'CE'}		
	}
  ,{
		$lookup: {
			from: "result2",
			localField: "Rno",
			foreignField: "Rno",
			as: "RESULTS"
		}
	}, {
    $project: {
			Rno: 1,
			Name: 1,
			Branch: 1,
			SPI: {$arrayElemAt:['$RESULTS.SPI',0]}
		}
	}
])

<!-- 4. Display Rno, Name, Branch and SPI of other than EC branch’s student only. -->
db.student2.aggregate([ 
	{
		$match: {Branch: {$ne: 'EC'}}		
	}
  ,{
		$lookup: {
			from: "result2",
			localField: "Rno",
			foreignField: "Rno",
			as: "RESULTS"
		}
	}, {
    $project: {
			Rno: 1,
			Name: 1,
			Branch: 1,
			SPI: {$arrayElemAt:['$RESULTS.SPI',0]}
		}
	}
])

<!-- 5. Display average result of each branch. -->
db.student2.aggregate([
{
	$lookup: {
		from: "result2",
		localField: "Rno",
		foreignField: "Rno",
		as: "Results"
	}
}, 
{
	$group: {
		_id: "$Branch",
		avgResult: {$avg: {$arrayElemAt: ['$Results.SPI', 0]}}
	}
}
])

<!-- 6. Display average result of each branch and sort them in ascending order by SPI. -->

db.student2.aggregate([
{
	$lookup: {
		from: "result2",
		localField: "Rno",
		foreignField: "Rno",
		as: "Results"
	}
}, 
{
	$group: {
		_id: "$Branch",
		avgResult: {$avg: {$arrayElemAt: ['$Results.SPI', 0]}}
	}
}, 
{
	$sort: {avgResult: 1}	
}
])

<!-- 7. Display average result of CE and ME branch. -->
db.student2.aggregate([
  {
    $lookup: {
      from: "result2",
      localField: "Rno",
      foreignField: "Rno",
      as: "Results"
    }
  },
  {
    $group: {
      _id: "$Branch",
      avgResult: { $avg: { $arrayElemAt: ["$Results.SPI", 0] } }
    }
  },
  {
    $match: { $or: [{ _id: "CE" }, { _id: "ME" }] }
  }
])


<!-- 8. Perform the left outer join on Student and Result tables. -->
db.student2.aggregate([
  {
    $lookup: {
      from: "result2",
      localField: "Rno",
      foreignField: "Rno",
      as: "Results"
    }
  }
])

<!-- 9. Perform the right outer join on Student and Result tables. -->
db.result2.aggregate([
  {
    $lookup: {
      from: "student2",
      localField: "Rno",
      foreignField: "Rno",
      as: "StudentDetails"
    }
  }
])

<!-- 10. Perform the full outer join on Student and Result tables. -->
student

<!-- 11. Retrieve the names of employee along with their manager name from the Employee table. -->
db.employee2.aggregate([
  {
    $lookup: {
      from: "employee2",
      localField: "ManagerNo",  
      foreignField: "EmployeeNo",  
      as: "ManagerDetails"
    }
  },
  {
    $project: {
      EmployeeName: "$Name",
      ManagerName: { $arrayElemAt: ["$ManagerDetails.Name", 0] }
    }
  }
])

<!-- * Part B -->
<!-- * Part C -->