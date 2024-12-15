import java.util.Scanner;

public class Palindrome {
public static  void main(String[] args)
{
    int number,reversed=0;

        
            Scanner sc =new Scanner(System.in);
            System.out.println("Enter number1");
            number=sc.nextInt();

            int copy=number;

            while (number != 0) {
               int temp = number% 10;
               reversed= reversed*10+temp;
               number/=10;                
            }

            if(copy==reversed)
            {
                System.out.println("Palindrome");
            }
            else
            {
                System.out.println("Not Palindrome");

            }
    }
}
