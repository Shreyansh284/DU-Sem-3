import java.util.Hashtable;
import java.util.Scanner;
import java.util.Random;

class HashingExample {
    public static int hash(int x) {
        return (x % 18) + 2;
    }

    public static void insert(int[] arr, int value) {
        int index = hash(value);
        while (arr[index] != 0) { // Linear probing
            index = (index + 1) % arr.length;
        }
        arr[index] = value;
    }

    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Index " + i + ": " + (arr[i] == 0 ? "Empty" : arr[i]));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        Random rand = new Random();

        // Generate 15 different random values between 100,000 and 999,999
        for (int i = 0; i < 15; i++) {
            int value;
            do {
                value = 100000 + rand.nextInt(900000);
            } while (contains(arr, value)); // Ensure uniqueness

            insert(arr, value);
        }

        display(arr);
    }

    private static boolean contains(int[] arr, int value) {
        for (int v : arr) {
            if (v == value) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Hashing
 */
public class Hashing {

    // public static int hash(int x) {
    // int res = Math.ceilMod(x, 18) + 2;
    // return res;
    // }

    // public static void hashArr() {
    // int[] arr = new int[20];
    // for (int i = 100000; i <= 999999; i++) {
    // arr[i] = hash(i);
    // }
    // }

    public static void dictionary(Scanner sc) {
        Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
        hashtable.put(1, "A");
        hashtable.put(2, "B");
        hashtable.put(3, "C");
        hashtable.put(4, "D");
        hashtable.put(5, "E");
        hashtable.put(6, "F");
        System.out.println("Enter key : (1 to 6)");
        int key = sc.nextInt();
        if (key < 1 || key > 6) {
            System.out.println("Please Enter in between 1 to 6".toUpperCase());
        } else
            System.out.println(hashtable.get(key));
    }

    public static void main(String[] args) {
        // hashArr();
        Scanner sc = new Scanner(System.in);
        dictionary(sc);
    }
}