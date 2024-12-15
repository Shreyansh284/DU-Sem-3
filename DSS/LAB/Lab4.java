import java.util.Scanner;

public class Lab4 {

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

    public static void delete(int arr[], int n, int location) {
        for (int i = location; i < n - 1; i++)
            arr[i] = arr[i + 1];
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
    public static void mergeTwoArray(Scanner scanner)
    {
        System.out.print("Enter the size of the 1st array: ");
        int size1 = scanner.nextInt();
        System.out.print("Enter the size of the 2st array: ");
        int size2 = scanner.nextInt();
        int[] array1 = new int[size1+size2];
        int[] array2 = new int[size2];
    
        System.out.println("Enter the elements:");
        for (int i = 0; i < size1; i++) {
            array1[i] = scanner.nextInt();
        }

        System.out.println("Enter the elements for Second Array:");
        for (int i = 0; i < size2; i++) {
            array2[i] = scanner.nextInt();
        }

        for (int i = 0; i < size2; i++) {
            array1[size1+i] = scanner.nextInt();
        }

        for (int i = 0; i < array1.length; i++) {
           
            System.out.println( array1[i] +" ");
        }

        
    }
    public static void deleteDuplicateElementFromArray(Scanner scanner) {
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
    
        System.out.println("Enter the elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
    
        int newSize = size; // size  after removing duplicate
    
        for (int i = 0; i < newSize; i++) {
            for (int j = i + 1; j < newSize; j++) {
                if (array[i] == array[j]) {
                    for (int k = j; k < newSize - 1; k++) {
                        array[k] = array[k + 1];
                    }
                    newSize--; 
                    j--;
                }
            }
        }
    
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newSize; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    // public static void deleteDuplicateElementFromArray(Scanner scanner) {
    //     System.out.print("Enter the size of the array: ");
    //     int size = scanner.nextInt();
    //     int[] array = new int[size + 1];
    //     int newSize=size;
    //     System.out.println("Enter the element:");
    //     for (int i = 0; i < newSize; i++) {
    //         array[i] = scanner.nextInt();
    //     }

    //     for(int i=0 ;i<newSize;i++)
    //     {
    //     for (int j = 1; j < size; j++) {
    //         if(array[i]==array[j])
    //         {
    //         array[j] = array[j + 1];
            
    //     }
    //     newSize--;
    //     }
    //     System.out.println(newSize);
    // }

    //     System.out.println("Array after deletion:");
    //     for (int i = 0; i < size-(newSize+1); i++) {
    //         System.out.print(array[i] + " ");
    //     }
    //     System.out.println();
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // deleteInSortedArray(scanner);
        // insertInSortedArray(scanner);
        deleteDuplicateElementFromArray(scanner);
        scanner.close();
    }

}