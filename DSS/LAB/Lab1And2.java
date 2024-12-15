import java.util.Scanner;

public class Lab1And2 {

    public void areaOfCircle(Scanner sc) {
        System.out.println("Enter radius:");

        double radius = sc.nextDouble();

        double area = radius * radius * (3.14);

        System.out.println(area);
    }

    public void oddEven(Scanner sc) {

        System.out.println("Enter a number :");

        int a = sc.nextInt();

        if (a % 2 == 0) {

            System.out.println("The number is even.");

        } else {

            System.out.println("The number is odd.");
        }
    }

    public void vowelOrNot(Scanner sc) {

        System.out.println("Enter a character:");

        char ch = sc.next().charAt(0);

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            System.out.println("Character is a vowel.");
        } else {
            System.out.println("Character is not a vowel.");
        }
    }

    public void factorialUsingLoop(Scanner sc) {
        System.out.println("Enter number");
    
        int n = sc.nextInt();
    
        // using loop
    
        int factorial = 1;
    
        for (int i = 1; i <= n; i++) {
    
            factorial *= i;
    
        }
        System.out.println("Factorial of " + n + " is " + factorial);
    }
//  Factorial Using Recursion

    public void factorialUsingRecursion(Scanner sc) {
        System.out.println("Enter number");
    
        int n = sc.nextInt();

        int result = factorial(n);

        System.out.println("Factorial of " + n + " is " + result);
        
        
    }

    public int factorial(int n)
    {
        if(n==0)
        {
            return 1;
        }
        else{
            return n* factorial(n-1);
        }
    }

    // End of Factorial Using Recursion

    public void powerUsingLoop(Scanner sc)
    {
        
   System.out.println("Enter the base number:");

   int base = sc.nextInt();

 System.out.println("Enter the power number:");

  int power = sc.nextInt();


      int result = 1;

  for (int i = 0; i < power; i++) {

     result *= base;
  }
           System.out.println("Here is the answer: " + result);

    }

    public void findFactor(Scanner sc)
    {
        System.out.println("Enter number:");

        int n = sc.nextInt();

         System.out.println("Factors of " + n + " are:");



       for (int i = 1; i <= n; i++) {

     if (n % i == 0) { 
        
                System.out.println(i); 
            }
        }
    }

    public void primeOrNot(Scanner sc)
    {
        System.out.println("Enter the number");

        int a = sc.nextInt();

        int count = 0;

         for (int i = 1; i <= a; i++) {

            if (a % i == 0) {

               count++;
            }
        }

        if(count == 2){

            System.out.println("Number is prime");
        }
        else{

            System.out.println("Number is notprime");
        }
    }
    public void secMinHour(Scanner sc)
    {
        System.out.println("Enter second");

        int totalSeconds = sc.nextInt();
        int hours = totalSeconds / 3600;
        int remainingSeconds = totalSeconds % 3600;
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;

        System.out.println(hours+" : "+minutes+" : "+seconds);
    }

    public void daysWeeksYears(Scanner sc)
    {
        System.out.println("Enter the number of days:");

        int totalDays = sc.nextInt(); 
        int years = totalDays / 365;
       int remainingDays = totalDays % 365;
       int weeks = remainingDays / 7;
       int days = remainingDays % 7;

       System.out.println(years+" years "+weeks+" wee "+days+" days");

    }

    public void sumOfnNumbers(Scanner sc)
    {
        System.out.println("Enter the value:");

        int n = sc.nextInt();
        int sum = 0;

       for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {

                 sum = sum + j;
            }
        }
          System.out.println("The sum is: " + sum);

    }

    public void armstrong()
    {
        int n, count = 0, a, b, c, sum = 0;
        System.out.print("Armstrong numbers from 1 to 1000:");
        for(int i = 1; i <= 1000; i++)
        {
            n = i;
            while(n > 0)
            {
                b = n % 10;
                sum = sum + (b * b * b);
                n = n / 10;
            }
            if(sum == i)
            {
                System.out.print(i+" ");
            }
            sum = 0;
        }
     }
    
     public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

     }
}
