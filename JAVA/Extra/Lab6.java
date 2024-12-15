import java.util.Scanner;

import javax.sound.midi.SysexMessage;

public class Lab6 {
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        // System.out.println("Enter No. Of Subject ");
        // int number=sc.nextInt();
        // Student[] students = new Student[number];
        // for(int i=0;i<number;i++)
        // {
        //     students[i]=new Student();
        //     students[i].getStudentDetail(number) ;           
        // }
        // System.out.println("Enter Author Name");
        // String author_name=sc.next();
        // System.out.println("Enter Title");
        // String title=sc.next();

        // Book_Publication book_publication=new Book_Publication(author_name,title);
        // Paper_Publication paper_Publication=new Paper_Publication(author_name,title);
        
        // System.out.println("Book_publication ");
        // book_publication.display();

        // System.out.println("Book_publication ");
        // paper_Publication.display();

        Manager manager=new Manager(18,98610,20000,"Shreyansh","gondal","aiml","CE");
        Employee employee=new Employee(18,9110,20000,"Shreyansh","gondal","aiml","ce");
        System.out.println("MANAGER DETAIL");
        manager.printSalary();
        System.out.println("Empolyee DETAIL");
        employee.printSalary();



    }
}

// 6-B3

class Member
{
    String name, address;
    int age,salary;
    long mobileNo;
     void printSalary()
     {
        System.out.println("Salary of "+name+" is "+salary);
     }
}

/**
 *  Emp
 */
 class Employee extends Member{

String specialization,department;

Employee(int age,long mobileNo,int salary,String name, String address,String specialization ,String department) 
{
    super.age=age;
        super.mobileNo=mobileNo;
        super.salary=salary;
        super.name=name;
        super.address=address;
        this.specialization=specialization;
        this.department=department;
}   

     void printSalary()
     {
        System.out.println("Salary of "+name+" is "+salary + " Belongs to "+department+" In "+ specialization );
     }
}

 class Manager extends Member
{

    String specialization,department;

Manager(int age,long mobileNo,int salary,String name, String address,String specialization ,String department) 
{
    super.age=age;
        super.mobileNo=mobileNo;
        super.salary=salary;
        super.name=name;
        super.address=address;
         this.specialization=specialization;
        this.department=department;
}  

     void printSalary()
     {
        System.out.println("Salary of "+name+" is "+salary + " Belongs to "+department+" In "+ specialization );
     }
}


// 6-2

// class book
// {
//     String author_name,title;
//     book(String author_name,String title)
//     {
//         this.author_name=author_name;
//         this.title=title;
//     }
//     void display()
//     {
//         System.out.println("Author : "+ author_name+" Title : "+ title);
//     }

// }

// class Book_Publication extends book
// {
//     String title;
//     Book_Publication(String author_name,String title)
//     {
//         super(author_name, title);
//     }

// }
// class Paper_Publication extends book
// {


//     String title;

//     void getTitle()
//     {
//         Scanner sc=new Scanner(System.in)   ; 
//         System.out.println("Enter title");
//         this.title=sc.next();
//     }
//     Paper_Publication(String author_name)
//     {
        
//         super(author_name,title);
//     }

// }

// 6-1

class Student
{
  
    int id_no,no_of_subjects_registered;
    int[] subject_credits;
    String[] grade_obtained,subject_code;
    Scanner sc =new Scanner(System.in);
    void getStudentDetail(int no_of_subjects_registered)
    {
        System.out.println("Enter Id");
        id_no=sc.nextInt();
        this.no_of_subjects_registered=no_of_subjects_registered;

        for(int i=0;i<no_of_subjects_registered;i++)
        {
            System.out.println("Enter Credits of subject "+ i+1);
            subject_credits[i]=sc.nextInt();
            System.out.println("Enter Code of subject"+ i+1);
            subject_code[i]=sc.next();
            System.out.println("Enter Grade of subject"+ i+1);
            grade_obtained[i]=sc.next();
        }
    }

    void calculateSpi()
    {
        int gradePoints=0,credits=0;

    }

   
} 