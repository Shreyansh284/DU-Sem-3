import java.util.*;

public class SecMinHour{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter second");

        int totalSeconds = sc.nextInt();
        int hours = totalSeconds / 3600;
        int remainingSeconds = totalSeconds % 3600;
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;

       System.out.printf("%d:%02d:%02d\n", hours, minutes, seconds);
    }
}