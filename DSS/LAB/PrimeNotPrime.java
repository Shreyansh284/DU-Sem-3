import java.util.*;

public class PrimeNotPrime{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

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
}