import java.util.*;

public class SmallestLargestNumber{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of elements:");

        int n = sc.nextInt();
        int[] a = new int[n];

       System.out.println("Enter " + n + " numbers:");

           for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

       int min = a[0];
        int max = a[0];
        int minIndex = 0;
        int maxIndex = 0;

             for (int i = 1; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                minIndex = i;
            }
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }

        System.out.println("Smallest number is " + min + " at index " + minIndex);
        System.out.println("Largest number is " + max + " at index " + maxIndex);
    }
}