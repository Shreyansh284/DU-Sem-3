import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);

        Bank_account bank_account=new Bank_account();
        System.out.println("Account No: ");
        bank_account.accNo=sc.nextInt();
        System.out.println("UserName: ");
        bank_account.userName=sc.next();
        System.out.println("Email: ");
        bank_account.email=sc.next();
        System.out.println("Account Type: ");
        bank_account.accType=sc.next();
        System.out.println("Account Balance: ");
        bank_account.accBalance=sc.nextInt();
        bank_account.display();
       
        
         // System.out.println("Enter Radius");
        // int radius=sc.nextInt();
        // Circle circle1 = new Circle(radius);
        // circle1.perimeter();
        // circle1.area();

        // Time time1=new Time();
        // Time time2=new Time();
        // System.out.println("Time 1");

        // System.out.println("Enter Hours ");
        // time1.hour=sc.nextInt();
        // System.out.println("Enter Mintue ");
        // time1.mintue=sc.nextInt();
        // System.out.println("Enter Seconds ");
        // time1.seconds=sc.nextInt();

        // System.out.println("Time 2");

        // System.out.println("Enter Hours ");
        // time2.hour=sc.nextInt();
        // System.out.println("Enter Mintue ");
        // time2.mintue=sc.nextInt();
        // System.out.println("Enter Seconds ");
        // time2.seconds=sc.nextInt();
        // time1.addTime(time2);



    }

}
class Bank_account
{
int accNo,accBalance;
String userName,email,accType;

void getDetails(int accNo,int accBalance,String userName,String email,String accType){
    this.accNo=accNo;
    this.accBalance=accBalance;
    this.userName=userName;
    this.email=email;
    this.accType=accType;
}

void display()
{
    System.out.println("Account No: "+this.accNo+" User Name : "+this.userName+" Email: "+this.email+" Account Type: "+this.accType+" Account Balance: "+this.accBalance);
}

// class Sentence{

//     void 

// }

}
class Time
{
    int hour;
    int mintue;
    int seconds;
    // Time(int hour, int mintue,int seconds)
    // {
    //     this.hour=hour;
    //     this.mintue=mintue;
    //     this.seconds=seconds;
    // }
    void addTime(Time time2)
    {
        this.hour+=time2.hour;
        this.mintue+=time2.mintue;
        this.seconds+=time2.seconds;

        if(this.seconds>=60)
        {
            this.mintue=this.mintue+(this.seconds/60);
            this.seconds=this.seconds%60;
        }
        if(this.mintue>=60)
        {
            this.hour=this.hour+(this.mintue/60);
            this.mintue=this.mintue%60;
        }
        

        System.out.println(this.hour+" : "+this.mintue+" : "+this.seconds);
    }


    
}

class Circle{

    int radius;
    Circle(int r)
    {
        this.radius=r;
    }

    void perimeter()
    {
        System.out.println("Perimeter is  : " + Math.PI*Math.pow(radius, 2));
    }
    void area()
    {
        System.out.println("Area is  : " + 2*Math.PI*radius);
    }
}
