import java.util.*;

public class CalcSwitchCase{

    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the value of A:");

    int a = sc.nextInt();

    System.out.println("Enter the value of B:");

    int b = sc.nextInt();

    System.out.println("Enter operator +,-,*,/,%");

    char opr = sc.next().charAt(0);

    switch(opr){

        case '+':

            System.out.println(a+b);
            break;

        case '-':

            System.out.println(a-b);
            break;

        case '*':

            System.out.println(a*b);
            break;

        case '/':

            System.out.println(a/b);
            break;

          case '%':

            System.out.println(a%b);
            break;

        default :

            System.out.println("Enter valid operator");
            break;

    }

    }
}