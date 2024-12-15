import java.util.Scanner;

public class Addition{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter First Number :");

        int A = sc.nextInt();

        System.out.println("Enter Second Number :");

        int B = sc.nextInt();

        int C = A+B;

        System.out.println("A+B = :"+C);

    }
}