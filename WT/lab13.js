// demonstrate use of callback functions
const callback = (callback) => {
  console.log("callback function called");
  callback();
};

callback(() => {
  console.log("inside callback function");
});

function demo(callback)
{
  
  callback()
  // console.log(i)
}

function callback()
{
  let i=10
}

// difference between let and var

console.log(a);
let a = 10;
console.log(b);
var b = 20;

// default parameters
function add(a, b = 10) {
  return a + b;
}

console.log(add(10));
console.log(add(10, 20));

// demonstrate use of spread operator
let arr1 = [1, 2, 3];
let arr2 = [4, 5, 6];

let arr3 = [...arr1, ...arr2];
console.log(arr3);

// demonstrate use of for of loop
for (const element of arr3) {
  console.log(element);
}

let str = "hello";
for (const element of str) {
  console.log(element);
}

// 6. Demonstrate the Array and Object Destructuring.
let arr4 = [1, 2, 3, 4];
let [first, second,...arg] = arr4;
console.log(first);
console.log(second);
const person = {
  name: "test",
  age: 25,
  gender: "male",
};

let { name, age, gender } = person;
console.log(name);
console.log(age);
console.log(gender);

// 7. Demonstrate the Arrow functions
const addTwo = (a, b) => {
  return a + b;
};
console.log(add(10, 20));

// 8. Demonstrate how to create a class in Java Script.
class Person {
  constructor(name, age, gender) {
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  getName() {
    return this.name;
  }

  getAge() {
    return this.age;
  }

  getGender() {
    return this.gender;
  }
}
const person1 = new Person("test", 25, "male");
console.log(person1.getName());
console.log(person1.getAge());
console.log(person1.getGender());