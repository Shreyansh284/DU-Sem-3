import java.util.Scanner;

public class InsertInSortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the original array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize the array with the given size
        int[] array = new int[size + 1]; // Create array with one extra space for the new element

        // Read array elements
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Read the number to be inserted
        System.out.print("Enter the number to insert: ");
        int number = scanner.nextInt();

        // Find the correct position to insert the number
        int position = 0;
        while (position < size && array[position] < number) {
            position++;
        }

        // Shift elements to the right to make space for the new element
        for (int i = size; i > position; i--) {
            array[i] = array[i - 1];
        }

        // Insert the new element
        array[position] = number;

        // Print the updated array
        System.out.println("Array after insertion:");
        for (int i = 0; i <= size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
