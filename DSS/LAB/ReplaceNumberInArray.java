import java.util.Scanner;

public class ReplaceNumberInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Read the array elements
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // Read the two different numbers
        System.out.print("Enter the first number to be replaced: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Enter the second number to replace the first number: ");
        int secondNumber = scanner.nextInt();

        // Replace the first number with the second number and print the index
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (array[i] == firstNumber) {
                array[i] = secondNumber;
                System.out.println("Replaced first number at index: " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("First number not found in the array.");
        }

        // Print the final array
        System.out.println("Final array:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}