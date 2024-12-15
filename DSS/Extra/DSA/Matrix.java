// * Lab 5 
import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
    static void twoXtwoMatrix(Scanner sc) {
        // * 2*2
        int[][] arr = new int[2][2];
        int[][] arr2 = new int[2][2];
        int[][] res = new int[2][2];
        System.out.println("Enter elements of first matrix : ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Enter : " + i + j);
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter elements of second matrix : ");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Enter : " + i + j);
                arr2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = arr[i][j] + arr2[i][j];
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }

    static void threeXthreeMatrix(Scanner sc) {
        // * 3*2 multiplication
        int[][] arr = new int[3][2];
        int[][] arr2 = new int[2][3];
        int[][] res = new int[3][3]; // * 3*2 * 2*3 = 3*3 */

        System.out.println("Enter elements of first matrix:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print("Enter element at position (" + i + "," + j + "): ");
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter elements of second matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter element at position (" + i + "," + j + "): ");
                arr2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res[i][j] = 0;
                for (int k = 0; k < 2; k++) { // Column of first matrix / Row of second matrix
                    res[i][j] += arr[i][k] * arr2[k][j];
                }
            }
        }

        // Output the result matrix
        System.out.println("Resultant Matrix:");
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void Anagram(Scanner sc) {
        int n;
        System.out.println("Enter N: ");
        n = sc.nextInt();
        String[] words = new String[n];
        System.out.println("Enter " + n + " Words : ");
        for (int i = 0; i < words.length; i++) {
            words[i] = sc.next();
        }

        double randomNum = Math.floor(Math.random() * (n - 1));
        System.out.println("Got : " + words[(int) randomNum] + "\nEnter it's Anagram : ");
        String anagram = sc.next();

        char wordArr[] = words[(int) randomNum].toCharArray();
        char anagramArr[] = anagram.toCharArray();
        Arrays.sort(wordArr);
        Arrays.sort(anagramArr);

        String wordStr = new String(wordArr);
        String anagramStr = new String(anagramArr);

        if (wordStr.equals(anagramStr)) {
            System.out.println("It's an anagram \t YOU WIN!!");
        } else
            System.out.println("YOU LOST, Better Luck Next Time !");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // twoXtwoMatrix(sc);
        // threeXthreeMatrix(sc);
        Anagram(sc);
        sc.close();
    }
}
