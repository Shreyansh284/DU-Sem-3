import java.util.*;
public class Result
{

    public static void main(String[] args) {
        
        double mark[]=new double[5] ;
        
        double total=0,percentage=0;


        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Marks For 5 subject ");

        for(int i=0;i<mark.length;i++)
        {
            mark[i]=sc.nextDouble();

        }

        for(int i=0;i<mark.length;i++)
        {
            total += mark[i];
        }
       
        percentage= (total/500)*100;

        if(percentage>=60)
        {
            System.out.println("Percentage"+ percentage + " 1st Divison");
        }
        else if (percentage<=59 && percentage>=50)
        {
            System.out.println("Percentage"+ percentage + " 2nd Divison");

        }
        else if (percentage<=49 && percentage>=40)
        {
            System.out.println("Percentage"+ percentage + " 3rd Divison");

        }
        else if (percentage<=39 && percentage>=30)
        {
            System.out.println("Percentage"+ percentage + " 4th Division");
        }

        else
        {
            System.out.println("Percentage"+ percentage + " FAIL");

        }


    }

}