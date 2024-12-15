import java.util.Scanner;

public class ArrayInsertion {

    public static void insertion(int arr[], int n, int x, int location) {
        for (int i = n; i > location; i--) {
            arr[i] = arr[i - 1];
        }
        arr[location] = x;
    }

    public static void printArray(int arr[], int n) {
        for (int i : arr)
            System.out.print(arr[i] + " ");
    }

    public static void delete(int arr[], int n, Scanner scanner) {

        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the position to delete the element (0-based index): ");
        int position = scanner.nextInt();

        // Shift elements to the left to delete the element
        for (int i = position; i < n - 1; i++) {
            array[i] = array[i + 1];
        }

        // Print the updated array
        System.out.println("Array after deletion:");
        for (int i = 0; i < n - 1; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void insertInSortedArray(Scanner scanner) {
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] array = new int[size + 1];

        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to insert: ");
        int number = scanner.nextInt();

        int position = 0;
        while (position < size && array[position] < number) {
            position++;
        }

        for (int i = size; i > position; i--) {
            array[i] = array[i - 1];
        }

        array[position] = number;

        System.out.println("Array after insertion:");
        for (int i = 0; i <= size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void deleteInSortedArray(Scanner scanner) {
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size + 1];

        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter location to delete");
        int location = scanner.nextInt();

        for (int i = location; i < size; i++) {
            array[i] = array[i + 1];
        }

        System.out.println("Array after deletion:");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // deleteInSortedArray(scanner);
        // insertInSortedArray(scanner);
        scanner.close();
    }

}