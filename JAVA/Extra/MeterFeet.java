import java.util.Scanner;

public class MeterFeet{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Meter :");

        int meter = sc.nextInt();

        double feet = meter*3.28084;

        System.out.println("Feet :"+feet);

    }
}