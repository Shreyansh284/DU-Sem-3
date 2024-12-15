import java.util.Scanner;

public class Percentage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double marks[] = new double[5];
        System.out.println("Enter marks of students");
        for (int i = 0; i < marks.length; i++) {
            marks[i] = sc.nextDouble();
        }
        double percentage = 0;
        for (int i = 0; i < marks.length; i++) {
            percentage += marks[i];
        }
        percentage = percentage / 500 * 100;
        if (percentage >= 60) {
            System.out.println("Percentage: " + percentage + " Class: 1st Division");
        } else if (percentage <= 59 && percentage >= 50) {
            System.out.println("Percentage: " + percentage + " Class: 2nd Division");
        } else if (percentage <= 49 && percentage >= 40) {
            System.out.println("Percentage: " + percentage + " Class: 3rd Division");
        } else if (percentage <= 39 && percentage >= 40) {
            System.out.println("Percentage: " + percentage + " Class: 4th Division");
        } else {
            System.out.println("Percentage: " + percentage + "Failed");
        }
        sc.close();
    }
}
