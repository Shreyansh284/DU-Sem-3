import java.util.Scanner;


public class countVowelsAndConsonant {
    static void countVowelsAndConsonantMethod(Scanner sc) {
        System.out.println("Enter a line: ");
        String str = sc.nextLine();
        
        int vowelCount = 0;
        int consonantCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'u' || str.charAt(i) == 'A'
                    || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O' || str.charAt(i) == 'U') {
                vowelCount++;
            } else {
                if (str.charAt(i) == ' ')
                    continue;
                consonantCount++;
            }

        }

        System.out.println("Vowels : " + vowelCount + " Consonants: " + consonantCount);
    } 

    static void calculateAvgArr(Scanner sc) {
        System.out.println("Enter size of arr : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int avg, sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter arr ["+ i + "]");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        
        avg = sum / arr.length;

        System.out.println("Avg : " + avg);
    }

    static void printArrInReverse(Scanner sc) {
        System.out.println("Enter size of arr : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter arr ["+ i + "]");
            arr[i] = sc.nextInt();
        }

        System.out.println("Reversed Array : ");
        for (int i = n -1 ; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    static void lenAndHalfStr(Scanner sc) {
        System.out.println("Enter string : ");
        String str = sc.next();
        int length = str.length();
        System.out.println("Length : "+ str.length());
        for (int i = 0; i < length / 2; i++) {
            System.out.print(str.charAt(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1
        // countVowelsAndConsonantMethod(sc);
        // 2
        // calculateAvgArr(sc);
        // 3
        // printArrInReverse(sc);
        // 4
        // lenAndHalfStr(sc);
        sc.close();
    }
}
