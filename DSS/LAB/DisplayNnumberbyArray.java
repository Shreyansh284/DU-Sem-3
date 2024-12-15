import java.util.*;

public class DisplayNnumberbyArray{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements:");

        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("The entered numbers are:");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
        
    }
}