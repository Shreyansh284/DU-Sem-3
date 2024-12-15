import java.lang.reflect.Array;
import java.util.Scanner;

public class Ternary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two Number : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        // int num3 = sc.nextInt();

        // * even or odd
        // System.out.println(num % 2 == 0 ? "Even" : "Odd");
        // * Max from three
        // int max = (num1 > num2) && (num1 > num3) ? num1 : (num2 > num3) ? num2 :
        // num3;
        // System.out.println("Max : " + max);
        // * prime or not
        // int count = 0;
        // for (int i = 2; i < Math.sqrt(num1); i++) {
        // if (num1 % i == 0)
        // count++;
        // }
        // if (count >= 1)
        // System.out.println("Not Prime");
        // else
        // System.out.println("Prime");
        // * leap year
        // if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
        // System.out.println(year + " is a Leap Year");
        // } else {
        // System.out.println(year + " is not a Leap Year");
        // }
        // * palindrome
        // int reversed = 0;
        // int temp = num1;
        // while (num1 != 0) {
        // int b = num1 % 10;
        // reversed = reversed * 10 + b;
        // num1 /= 10;
        // }
        // if (temp == reversed)
        // System.out.println("Palindrome");
        // else
        // System.out.println("Not Palindrome");
        // * print prime nums between given range
        // for (int i = num1; i < num2; i++) {
        // if (i == 1) {
        // System.out.println("1 is Neither Prime nor composite");
        // continue;
        // }
        // if (primeOrNot(i)) {
        // System.out.println(i + " is Prime");
        // }
        // }
        sc.close();
    }

    public static Boolean primeOrNot(int number) {
        int count = 0;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0)
                count++;
        }
        if (count == 0)
            return true;
        else
            return false;
    }

}
