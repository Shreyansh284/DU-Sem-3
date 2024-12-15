// * lab 7

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class INT_Stack {
    static int MAX = 50;
    static int[] stack = new int[MAX];
    static int TOP = -1;

    void push(int x) {
        if (TOP == MAX - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        TOP++;
        stack[TOP] = x;
        System.out.println(x + " pushed into stack");
    }

    int pop() {
        if (TOP == -1) {
            System.out.println("Stack Underflow");
            return 0;
        }

        int temp = stack[TOP];
        TOP--;
        // System.out.println(temp + " Poped From stack");

        return temp;
    }

    void display() {
        if (TOP == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = 0; i <= TOP; i++) {
            System.out.println(stack[i]);
        }
    }

    int peep(int idx) {
        if (TOP - idx + 1 < 0) {
            System.out.println("Element Not Found.");
            return 0;
        }

        return stack[TOP - idx + 1];
    }

    void change(int x, int idx) {
        if (TOP - idx + 1 < 0) {
            System.out.println("Invalid index.");
            return;
        }
        stack[TOP - idx + 1] = x;
        System.out.println("Value changed at index " + idx);
    }
    

    void stackImplementation(Scanner sc) {
        int choice = 0;
        System.out.println("*********Stack operations using array*********\n");
        System.out.println("\n------------------------------------------------\n");
        while (choice != 6) {
            System.out.println("Enter 1. PUSH, 2. POP, 3. PEEP, 4. CHANGE, 5. DISPLAY, 6. EXIT");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter value to be inserted : ");
                    int x = sc.nextInt();
                    push(x);
                    break;
                case 2:
                    System.out.println( pop() + " Poped From stack");                
                    break;
                case 3:
                    System.out.println("Enter index : ");
                    int idx = sc.nextInt();
                    System.out.println(peep(idx));
                    break;
                case 4:
                    System.out.println("Enter value and index : ");
                    int data = sc.nextInt();
                    int index = sc.nextInt();
                    change(data, index);
                    break;
                case 5:
                    display();
                    break;
                case 6:
                    System.out.println("THANK YOU !!");
                    break;
                default:
                    System.out.println("Please Enter Choice Between 1 to 6 !!");
                    break;
            }
        }
    }
}

class CHAR_Stack {
    static int MAX = 50;
    static char[] stack = new char[MAX];
    static int TOP = -1;

    void push(char x) {
        if (TOP == MAX - 1) {
            System.out.println("Stack Overflow");
            return;
        }

        TOP++;
        stack[TOP] = x;
    }

    char pop() {
        if (TOP == -1) {
            System.out.println("Stack Underflow");
            return 0;
        }

        char temp = stack[TOP];
        TOP--;
        return temp;
    }

    boolean isEmpty() {
        return TOP == -1;
    }
}

public class Lab7_STACK {

    static boolean isPalindrome(Scanner sc) {
        CHAR_Stack char_Stack = new CHAR_Stack();
        System.out.println("Enter String: ");
        String str = sc.next();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            char_Stack.push(str.charAt(i));
        }
        int start = (length % 2 == 0) ? length / 2 : length / 2 + 1;
        for (int i = start; i < length; i++) {
            if (char_Stack.pop() != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    static boolean isAIBI(Scanner sc) {
        System.out.println("Enter String: ");
        String string = sc.next();
        string.toLowerCase();
        int countA = 0;
        int countB = 0;
        boolean foundB = false;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'a') {
                if (foundB) {
                    return false;
                }
                countA++;
            } else if (string.charAt(i) == 'b') {
                foundB = true;
                countB++;
            } else {
                return false;
            }
        }

        return countA == countB && countA > 0;
    }

    static int isMatchingParantheses(Scanner sc) {
        CHAR_Stack char_Stack = new CHAR_Stack();
        System.out.println("Enter String: ");
        String string = sc.next();
        int length = string.length();
        if (string.isEmpty()) {
            return 1;
        }
        for (int i = 0; i < length; i++) {
            char ch = string.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                char_Stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (char_Stack.isEmpty()) {
                    return 0;
                }

                char top = char_Stack.pop();
                if ((top == '(' && ch != ')') || (top == '{' && ch != '}') || (top == '[' && ch != ']')) {
                    return 0;
                }
            }
        }
        return char_Stack.isEmpty() ? 1 : 0;
    }

    static int[][] overlappedInterval(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] topInterval = stack.peek();

            if (currentInterval[0] <= topInterval[1]) {
                topInterval[1] = Math.max(topInterval[1], currentInterval[1]);
            } else {
                stack.push(currentInterval);
            }
        }

        int[][] mergedIntervals = new int[stack.size()][2];
        for (int i = stack.size() - 1; i >= 0; i--) {
            mergedIntervals[i] = stack.pop();
        }

        return mergedIntervals;
    }

    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    static void vowelAnxiety(Scanner sc) {
        System.out.println("Enter a string: ");
        String string = sc.next();
        StringBuilder result = new StringBuilder();
        string = string.toLowerCase();
        Stack<Character> char_Stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (isVowel(string.charAt(i))) {
                while (!char_Stack.isEmpty()) {
                    result.append(char_Stack.pop());
                }

                result.append(string.charAt(i));
            } else {
                char_Stack.push(string.charAt(i));
            }
        }

        while (!char_Stack.isEmpty()) {
            result.append(char_Stack.pop());
        }

        System.out.println("Result: " + result.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // * 1
        INT_Stack int_Stack = new INT_Stack();
        // int_Stack.stackImplementation(sc);
        // * 2
        // if (isPalindrome(sc))
        // System.out.println("Palindrome");
        // else
        // System.out.println("Not a Palindrome");
        // * 3
        // if (isAIBI(sc))
        // System.out.println("The string is of the form a^i b^i");
        // else
        // System.out.println("The string is NOT of the form a^i b^i");
        // * 4
        // ()
        // ([)]
        // ([{}()])[{}]
        // [{{}]
        System.out.println(isMatchingParantheses(sc));
        // * 5
        // int[][] intervals = { { 1, 3 }, { 2, 4 }, { 6, 8 }, { 9, 10 } };
        // int[][] merged = overlappedInterval(intervals);
        // for (int i = 0; i < merged.length; i++) {
        // System.out.print("{" + merged[i][0] + "," + merged[i][1] + "} ");
        // }
        // * 6
        // vowelAnxiety(sc);
        sc.close();
    }
}
