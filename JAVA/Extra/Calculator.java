import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
        int number1, number2;
        char operator;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Number: ");
        number1 = sc.nextInt();
        System.out.println("Enter Second Number: ");
        number2 = sc.nextInt();
        
        System.out.println("Enter Operator: ");
        operator = sc.next().charAt(0);
        switch(operator){
            case '+': 
                System.out.println("Addition : "+ (number1+number2));
                break;
            case '-': 
                System.out.println("Substraction : "+ (number1-number2));
                break;
            case '*': 
                System.out.println("Multiplication : "+ (number1*number2));
                break;
            case '/': 
                System.out.println("Division : "+ (number1/number2));
                break;
            default: 
                System.out.println("Please Enter (+,-,*,/)");
                break;
        }
    }
}