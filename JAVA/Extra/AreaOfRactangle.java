import java.util.*;

public class AreaOfRactangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length :");
        double length = sc.nextDouble();
        System.out.println("Enter the Breadth :");
        double breadth = sc.nextDouble();
        double area = length * breadth;
        System.out.println(area);
        sc.close();
    }
}