import java.util.*;

public class AverageofFirstNnumber{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the numbers:");

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
        double average = (double) sum / n;
        System.out.println("Average of the numbers: " + average);
    }
}