import java.util.Scanner;

public class AreaofCircle{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter radius:");

        double radius = sc.nextDouble();

         double pie;

        pie = 3.14;

        double area = radius * radius *(3.14);

        System.out.println(area);

        sc.close();
    }
}

