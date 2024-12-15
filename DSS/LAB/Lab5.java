import java.util.*;

public class Lab5 {

    public static void main(String[] args) {

        // AdditionOfThree2x2Matrix();
        MultiptionOf3x2And2x3Matrix();

    }

    public static void MultiptionOf3x2And2x3Matrix()
    {
        Scanner sc = new Scanner(System.in);
        
        int a[][]=new int[3][2];
        int b[][]=new int[2][3];
        int c[][]=new int[3][3];

        for (int i=0; i<3;i++)
        {
            for(int j=0; j<2;j++)
            {
                System.out.println("Enter Value For Element a"+"["+i+"]"+"["+j+"]" );
                a[i][j]=sc.nextInt();
            }
        }
        for (int i=0; i<2;i++)
        {
            for(int j=0; j<3;j++)
            {
                System.out.println("Enter Value For Element b1"+"["+i+"]"+"["+j+"]" );
                b[i][j]=sc.nextInt();
            }
        }
        for (int i=0; i<3;i++)
        {
            for(int j=0; j<3;j++)
            {
                c[i][j]+=a[i][j]*b[i][j];
                       
            }
        }
        for (int i=0; i<3;i++)
        {
            for(int j=0; j<3;j++)
            {
                System.out.println("c"+"["+i+"]"+"["+j+"] "+c[i][j]);              
            }
            System.out.print(" ");
        }


    }
    
    public static void AdditionOfThree2x2Matrix()
    {
        Scanner sc = new Scanner(System.in);
        
        int a[][]=new int[2][2];
        int b[][]=new int[2][2];
        int c[][]=new int[2][2];

        for (int i=0; i<2;i++)
        {
            for(int j=0; j<2;j++)
            {
                System.out.println("Enter Value For Element a"+"["+i+"]"+"["+j+"]" );
                a[i][j]=sc.nextInt();
            }
        }
        for (int i=0; i<2;i++)
        {
            for(int j=0; j<2;j++)
            {
                System.out.println("Enter Value For Element b1"+"["+i+"]"+"["+j+"]" );
                b[i][j]=sc.nextInt();
            }
        }
        for (int i=0; i<2;i++)
        {
            for(int j=0; j<2;j++)
            {
                c[i][j]=a[i][j]+b[i][j];
                       
            }
        }
        for (int i=0; i<2;i++)
        {
            for(int j=0; j<2;j++)
            {
                System.out.println("c"+"["+i+"]"+"["+j+"] "+c[i][j]);              
            }
            System.out.print(" ");
        }


    }
}
