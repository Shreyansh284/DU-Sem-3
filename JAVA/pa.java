import java.util.Scanner;
/**
 * patterns
 */
public class pa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();
        // * p-1
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // // * p-2
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // // * p-3
        // for (int i = n; i > 0; i--) {
        //     for (int j = i; j > 0; j--) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // // * p-4
        // int k = 1;
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= i; j++) {
        //         System.out.print(k+ " ");
        //         k++;
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // // * p-5
        // for (int i = 1; i <= n; i++) {
        //     for (int space = 1; space <= n - i; space++) {
        //         System.out.print(" ");
        //     }

        //     for (int j = 1; j <= i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        // System.out.println();
        // // * p-6
        // for (int i = 1; i <= n; i++) {

        //     for (int space = 1; space <= n - i; space++) {
        //         System.out.print(" ");
        //     }

        //     for (int j = 1; j <= i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();        
        // // * p-7
        // // remaining (no spaces)
        // for (int i = 1; i <= n; i++) {

        //     for (int space = 1; space <= n - i; space++) {
        //         System.out.print("");
        //     }

        //     for (int j = 1; j <= i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // for (int i = n - 1; i >= 1; i--) {

        //     for (int space = 1; space <= n - i; space++) {
        //         System.out.print("");
        //     }

        //     for (int j = 1; j <= i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // for (int i = n; i >= 1; i--) {

        //     for (int space = 1; space <= n - i; space++) {
        //         System.out.print("");
        //     }

        //     for (int j = 1; j <= i; j++) {
        //         System.out.print(" *");
        //     }
        //     System.out.println();
        // }
        // for (int i = 1; i <= n -1; i++) {
        //     for (int space = 1; space <= n - i; space++) {
        //         System.out.print("");
        //     }

        //     for (int j = 1; j <= i; j++) {
        //         System.out.print(" *");
        //     }
        //     System.out.println();
        // }
        // System.out.println();        
        // // * p-8
        // for (int i = n; i >= 1; i--) {
        //     for (int space = 1; space <= n - i; space++) {
        //         System.out.print(" ");
        //     }

        //     for (int j = i; j >= 1; j--) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();        
        // }
        // for (int i = 2; i <= n; i++) {
        //     for (int space = 1; space <= n - i; space++) {
        //         System.out.print(" ");
        //     }

        //     for (int j = 1; j <= i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();        
        // }
        // System.out.println();        
        // * p-9
        // remaining
       for(int i=1;i<=n;i++)
       {

        for(int space=1; space<=n-i;space++)
        {
            System.out.println(" ");
        }

        for(int j=i;j>=1;j--)
        {
            if(i==1||i==n||j==1||j==n)
            {
                System.out.println("*");
            }
            else{
                System.out.println(" ");
            }
        }

       }
        // * p-10
        // remaining
        sc.close();
    }
}