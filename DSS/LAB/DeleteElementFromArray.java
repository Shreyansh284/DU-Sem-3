import java.util.Scanner;

public class DeleteElementFromArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the original array size
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        // Initialize the array with the given size
        int[] array = new int[size];

        // Read array elements
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Read the position to delete the element from
        System.out.print("Enter the position to delete the element (0-based index): ");
        int position = scanner.nextInt();

        // Validate the position
        if (position < 0 || position >= size) {
            System.out.println("Invalid position! Please enter a position between 0 and " + (size - 1));
            return;
        }

        // Shift elements to the left to delete the element
        for (int i = position; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        // Print the updated array
        System.out.println("Array after deletion:");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
