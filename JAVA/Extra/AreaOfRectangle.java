import java.util.Scanner;
public class AreaOfRectangle {
    public static void main(String[] args){
        double length, breath, area;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length: ");
        length = sc.nextDouble();
        System.out.println("Enter Breath: ");
        breath = sc.nextDouble();

        area = length * breath;

        System.out.println("Area Of Rectangle: "+ area);
    }
}