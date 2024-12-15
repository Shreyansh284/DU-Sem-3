import java.util.Arrays;
import java.util.Scanner;

public class Lab3 {

    public void avgOfFirstNnumber(Scanner sc) {
        System.out.println("Enter the numbers:");

        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        double average = (double) sum / n;
        System.out.println("Average of the numbers: " + average);
    }

    public void arrayContainsDuplicateOrNot(Scanner sc) {
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        boolean hasDuplicate = false;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    hasDuplicate = true;
                    break;
                }
            }
            if (hasDuplicate) {
                break;
            }
        }

        if (hasDuplicate) {
            System.out.println("The array contains duplicate numbers.");
        } else {
            System.out.println("The array does not contain duplicate numbers.");
        }
    }

    public void smallestAndLargestNumber(Scanner sc) {
        System.out.println("Enter the number of elements:");

        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter " + n + " numbers:");

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int min = a[0];
        int max = a[0];
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                minIndex = i;
            }
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }

        System.out.println("Smallest number is " + min + " at index " + minIndex);
        System.out.println("Largest number is " + max + " at index " + maxIndex);
    }

    public void replaceNumberInArray(Scanner sc) {
        // Read the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        // Read the array elements
        int[] array = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // Read the two different numbers
        System.out.print("Enter the first number to be replaced: ");
        int firstNumber = sc.nextInt();
        System.out.print("Enter the second number to replace the first number: ");
        int secondNumber = sc.nextInt();

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
    }

    public void pascalTraingle( Scanner sc)
    {
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        sc.close();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows - i; j++) {
                System.out.print(" ");
            }

            int number = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print(number + " ");
                number = number * (i - j) / (j + 1);
            }

            System.out.println();
        }
    }
    
    public void sortNames(Scanner sc)
    {
          System.out.print("Enter the number of names: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] names = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = sc.nextLine();
        }
        
        Arrays.sort(names);

        System.out.println("Names in alphabetical order:");
        for (String name : names) {
            System.out.println(name);
        }

        sc.close();
    }
}
