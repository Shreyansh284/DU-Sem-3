import java.util.Scanner;
public class MaxFromThree {
    public static void main(String[] args){
        int number1, number2, number3;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        number1 = sc.nextInt();
        System.out.println("Enter Second Number: ");
        number2 = sc.nextInt();
        System.out.println("Enter Third Number: ");
        number3 = sc.nextInt();

        if((number1 > number2) && (number1 > number3)){
            System.out.println("MAX FIRST : "+ number1);
        } else if((number2 > number1) && (number2 > number3)){
            System.out.println("MAX SECOND : "+ number2);
        } else {
            System.out.println("MAX THIRD : "+ number3);
        }
    }
}