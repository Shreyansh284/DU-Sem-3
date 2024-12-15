import java.util.Scanner;
public class TemperatureConverter {
    public static void main(String[] args){
        double fehrenhit, celcius, res;
        int choice;

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Choice (1. fehrenhit to celcius) ,(2. celcius to fehrenhit): ");
        choice = sc.nextInt();

        if(choice == 1) {
            System.out.println("Enter fehrenhit: ");
            fehrenhit = sc.nextDouble();
            res = ((fehrenhit - 32) * 5) / 9;
            System.out.println("Result: "+ res);
        } else {
            System.out.println("Enter celcius: ");
            celcius = sc.nextDouble();
            res = ((celcius * 9 / 5) + 32);
            System.out.println("Result: "+ res);
        }
    }
}