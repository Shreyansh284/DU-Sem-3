import java.util.*;
public class EvenOdd {
    
    public static void main(String[] args) {
        
        int number;

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Number");
        number=sc.nextInt();
        System.out.println(number%2==0?"Even":"Odd");

    }
}
