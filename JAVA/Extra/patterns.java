import java.util.Scanner;

/**
 * patterns
 */
public class patterns {
    public static void main(String[] args) {
        patterns patterns = new patterns();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = sc.nextInt();

        patterns.pattern1(n);
        patterns.pattern2(n);
        patterns.pattern3(n);
        patterns.pattern4(n);
        patterns.pattern5(n);
        patterns.pattern6(n);
        patterns.pattern7(n);
        patterns.pattern8(n);
        patterns.pattern9(n);
        patterns.pattern10(n);
        patterns.pattern11();

    }

    public void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern3(int n) {
        for (int i = n; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern4(int n) {
        int k = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(k + " ");
                k++;
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern5(int n) {
        for (int i = 1; i <= n; i++) {
            for (int space = 1; space <= n - i; space++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern6(int n) {
        for (int i = 1; i <= n; i++) {

            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern7(int n) {
        for (int i = 1; i <= n; i++) {

            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
               
                    System.out.print("* ");
            }

            System.out.println();
        }
        for (int i = n-1; i >= 1; i--) {

            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
             
                    System.out.print("* ");
              
            }

            System.out.println();
        }
    }
    
    public void pattern8(int n) {
        for (int i = n; i >= 1; i--) {
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 2; i <= n; i++) {
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void pattern9(int n) {
        for (int i = 1; i <= n; i++) {

            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                if (i == j || i == n || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
        System.out.println();
    }

    public void pattern10(int n) {
        for (int i = 1; i <= n; i++) {

            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                if (i == j || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
        for (int i = n-1; i >= 1; i--) {

            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                if (i == j || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public void pattern11()
    {
        String string="stream";

        for(int i=0;i<string.length();i++)
        {
            for(int j=0;j<=i;j++)
            {
                System.out.print(string.charAt(j)+" ");
            }
            System.out.println();
        }
    }
}