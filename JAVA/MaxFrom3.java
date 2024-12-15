import java.util.*;
public class MaxFrom3 {
    
    public static void main(String[] args) {
        
        int num1,num2,num3;

        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Number1");
        num1=sc.nextInt();
        System.out.println("Enter Number2");
        num2=sc.nextInt();
        System.out.println("Enter Number3");
        num3=sc.nextInt();
        int max= (num1>num2 && num1>num3)?num1:(num2>num3)?num2:num3;
        System.out.println("Max Number is"+ max);

    }
}
