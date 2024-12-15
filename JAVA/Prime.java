import java.util.*;
public class Prime {
    
    public static void main(String[] args) {
        
        int number1 , number2;
        
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Number1");
        number1=sc.nextInt();
        System.out.println("Enter Number2");
        number2=sc.nextInt();

        for(int i=number1;i<=number2;i++)
        {
            if(i==1)
            {
                System.out.println("1 is Neither Prime Nor Composite");
                continue;
            }
            if(primeornot(i))
            {
                System.out.println(i+" Is Prime");
            }
        }

      
    }
    public static boolean primeornot(int number)
    {
        int count=0;
        for(int i=2;i<=number/2;i++)
        {
            if(number%i==0)
            {
             count++;  
            }
        }
        
        if(count==0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}

