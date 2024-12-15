import java.util.Scanner;

public class NameAge{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your Name :");

        String str = sc.nextLine();

        System.out.println("Enter Your Age :");

        int age = sc.nextInt();

        System.out.println("Your name is :"+str+"Your age is :"+age);

    }
}