// * Lab 6

import java.util.Scanner;

class EmployeeDetails {
    int emp_id;
    String name;
    String designation;
    int salary;

    public EmployeeDetails(int emp_id, String name, String designation, int salary) {
        this.emp_id = emp_id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }

    void printDetails() {
        System.out.println(
                this.emp_id + "\n" +
                        this.name + "\n" +
                        this.designation + "\n" +
                        this.salary);
    }
}

/**
 * StudentDetails
 */
class StudentDetails {
    int enrollmentNo;
    String Name;
    int Semester;
    int CPI;

    public StudentDetails(int enrollmentNo, String name, int Semester, int CPI) {
        this.enrollmentNo = enrollmentNo;
        this.Name = name;
        this.Semester = Semester;
        this.CPI = CPI;
    }

    void printDetails() {
        System.out.println("Student : " + this.enrollmentNo + "\n Name: " + this.Name + "\n Semester: " + this.Semester
                + "\n CPI : " + this.CPI);
    }
}

class TemperatureConverter {

    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}

class BankAccount {
    int accNo;
    double balance;
    String Name;

    BankAccount(int accNo, double balance, String Name) {
        this.accNo = accNo;
        this.balance = balance;
        this.Name = Name;
    }

    void depositMoney(double amount) {
        this.balance += amount;
        System.out.println("Acc no: " + this.accNo + "Total Balance : " + this.balance);
    }

    void withdrawMoney(double amount) {
        this.balance -= amount;
        System.out.println("Acc no: " + this.accNo + "Total Balance : " + this.balance);
    }

    void checkBalance() {
        System.out.println("Acc no: " + this.accNo + "Total Balance : " + this.balance);
    }
}

public class Class {
    static void swapTwoNums(Scanner sc) {
        System.out.println("Enter Num1: ");
        int num1 = sc.nextInt();
        System.out.println("Enter Num2: ");
        int num2 = sc.nextInt();

        System.out.println("Before Swapping: Num1: " + num1 + "Num2:" + num2);

        int temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.println("After Swapping: Num1: " + num1 + " Num2: " + num2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // * 1
        // swapTwoNums(sc);
        // * 2
        // int emp_id;
        // String name;
        // String designation;
        // int salary;
        // System.out.println("Enter Employee id : ");
        // emp_id = sc.nextInt();
        // System.out.println("Enter Employee Name : ");
        // name = sc.next();
        // System.out.println("Enter Employee Designation : ");
        // designation = sc.next();
        // System.out.println("Enter Employee Salary : ");
        // salary = sc.nextInt();

        // EmployeeDetails emp1 = new EmployeeDetails(emp_id, name, designation,
        // salary);
        // emp1.printDetails();
        // * 3
        // StudentDetails[] students = new StudentDetails[5];
        // for (int i = 0; i < students.length; i++) {
        // System.out.println("Enter Details for student " + i);
        // System.out.println("Enter Enrollment no: ");
        // int enrollmentNo = sc.nextInt();
        // System.out.println("Enter Name: ");
        // String Name = sc.next();
        // System.out.println("Enter Semester: ");
        // int Semester = sc.nextInt();
        // System.out.println("Enter CPI: ");
        // int CPI = sc.nextInt();
        // students[i] = new StudentDetails(enrollmentNo, Name, Semester, CPI);
        // }
        // for (int i = 0; i < students.length; i++) {
        // System.out.println("Details of student " + i);
        // students[i].printDetails();
        // }
        // * 4
        System.out.println("Temperature Converter");
        System.out.println("1. Convert Celsius to Fahrenheit");
        System.out.println("2. Convert Fahrenheit to Celsius");
        System.out.print("Choose an option (1 or 2): ");
        int choice = sc.nextInt();
        TemperatureConverter tc = new TemperatureConverter();
        if (choice == 1) {
            System.out.print("Enter temperature in Celsius: ");
            double celsius = sc.nextDouble();
            double fahrenheit = tc.celsiusToFahrenheit(celsius);
            System.out.println(celsius + "°C is equal to " + fahrenheit + "°F");
        } else if (choice == 2) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double fahrenheit = sc.nextDouble();
            double celsius = tc.fahrenheitToCelsius(fahrenheit);
            System.out.println(fahrenheit + "°F is equal to " + celsius + "°C");
        } else {
            System.out.println("Invalid choice! Please select 1 or 2.");
        }
        // * 5
        // BankAccount[] accounts = new BankAccount[2];
        // for (int i = 0; i < accounts.length; i++) {
        // System.out.println("Enter Details for account " + i);
        // System.out.println("Enter Acc no: ");
        // int accNo = sc.nextInt();
        // System.out.println("Enter Balance: ");
        // double balance = sc.nextDouble();
        // System.out.println("Enter Name: ");
        // String Name = sc.next();
        // accounts[i] = new BankAccount(accNo, balance, Name);
        // }

        // System.out.println("1. Deposit Money");
        // System.out.println("2. Withdraw Money");
        // System.out.println("3. Check Balance");
        // System.out.print("Choose an option (1 or 2 or 3): ");
        // int choice = sc.nextInt();
        // switch (choice) {
        // case 1:
        // System.out.println("Enter accNo : ");
        // int accNo = sc.nextInt();
        // System.out.println("Enter Amount : ");
        // double amount = sc.nextDouble();
        // accounts[accNo].depositMoney(amount);
        // break;
        // case 2:
        // System.out.println("Enter accNo : ");
        // int accNo2 = sc.nextInt();
        // System.out.println("Enter Amount : ");
        // double amount2 = sc.nextDouble();
        // accounts[accNo2].withdrawMoney(amount2);
        // break;
        // case 3:
        // System.out.println("Enter accNo : ");
        // int accNo3 = sc.nextInt();
        // accounts[accNo3].checkBalance();
        // break;
        // default:
        // System.out.println("Enter choice between 1 to 3");
        // break;
        // }
        sc.close();
    }
}