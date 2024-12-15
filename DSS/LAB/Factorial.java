import java.util.*;

public class Factorial{

    public static void main(String[] args){
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");

        int n = sc.nextInt();

        // using loop
        
        int factorial = 1;

          for (int i = 1; i <= n; i++) {

             factorial *= i;
        
        }
        System.out.println("Factorial of "+n+" is "+factorial(n));
    }
    // using recurrsion
    public static int factorial(int n)
    {

        if(n==0)
        {
            return 1;
        }
        else{
            return n* factorial(n-1);
        }
    }
}