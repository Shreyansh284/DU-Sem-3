import java.util.*;

public class DaysWeekYear{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of days:");

         int totalDays = sc.nextInt(); 
         int years = totalDays / 365;
        int remainingDays = totalDays % 365;
        int weeks = remainingDays / 7;
        int days = remainingDays % 7;
        
       System.out.printf("%d years, %d weeks, %d days%n", years, weeks, days);
    }
}