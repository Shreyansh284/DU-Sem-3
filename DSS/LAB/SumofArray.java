import java.util.*;

public class SumofArray{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

       System.out.println("Enter the number of elements:");

        int m = sc.nextInt();
        int n = sc.nextInt();

       int[] a = new int[n];

        System.out.println("Enter " + n + " numbers:");
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
            int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
              System.out.println("Sum of the array elements: " + sum);
        
    }
}