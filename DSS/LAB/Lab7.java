import java.util.Arrays;

import java.util.Stack;
import java.util.Scanner;

class IntStack {
    int max = 5;
    int stack[] = new int[max];
    int top = -1;

    void push(int x) {
        if (top == max - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack[top] = x;
        System.out.println(x + "Pused into stack ");

    }

    int pop() {
        if (top <= -1) {
            System.out.println("Stack UnderFlow");
        }
        int popedElement = stack[top];
        top--;
        return popedElement;
    }

    int peep(int index) {
        if (top - index + 1 < 0) {
            System.out.println("Element Not Found");
            return 0;
        }

        return stack[top - index + 1];
    }

    void change(int index, int data) {
        if (top - index + 1 < 0) {
            System.out.println("Element Not Found");
            return;
        }

        stack[top - index + 1] = data;
        System.out.println("Value changed at index " + index);

    }

    void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    void opertaionsOnStack(Scanner sc) {
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
                    System.out.println(pop() + " Poped From stack");
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

class CharStack {
    int max = 5;
    char stack[] = new char[max];
    int top = -1;

    void push(char x) {
        if (top == max - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack[top] = x;
        System.out.println(x + "Pused into stack ");

    }

    char pop() {
        if (top <= -1) {
            return 'n';
        }
        char popedElement = stack[top];
        top--;
        return popedElement;
    }

    // void isPalindrome(String s) {
    //     int i = 0;
    //     if (top == -1) {
    //         top = 1;
    //         // System.out.println(top);
    //         push('c');
    //     }
    //     int cIndex = -1;
    //     while (i < s.length()) {
    //         char nextChar = s.charAt(i);
    //             if (nextChar != 'c') {
    //             if (nextChar == ' ') {
    //                 System.out.println("Invalid String");
    //                 return;
    //             }
    //             push(nextChar);
    //         } else {
    //             break;
    //         }
    //         cIndex = i++;

    //     }
    //     while (cIndex + 2 < s.length()) {
    //         char nextChar = s.charAt(cIndex + 2);
    //         if (stack[top] != 'c') {
    //             char x = pop();
    //             if (x != nextChar) {
    //                 System.out.println("Invalid String");
    //                 return;
    //             }
    //         }
    //         cIndex++;
    //     }
    //     if(stack[top]=='c')
    //     {
    //         System.out.println("valid String");
    //     }
    // }

     boolean isPalindrome(Scanner sc) {
        System.out.println("Enter String: ");
        String str = sc.next();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
             push(str.charAt(i));
        }
        int start = (length % 2 == 0) ? length / 2 : length / 2 + 1;
        for (int i = start; i < length; i++) {
            if (pop() != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    public boolean isAiBi(Scanner sc) {
        System.out.println("Enter String");
        String string = sc.next().toLowerCase();
 
        int countA = 0;
        int countB = 0;

        for (int i=0;i<string.length();i++)
        {
            push(string.charAt(i));
        }
        
        for(int i=0 ;i<string.length();i++)
        {
            char x= pop();
  
            if(x=='a')
            {
            countA++;
            }
            else if(x=='b')
            {
                countB++;
            }
        }
        

        return countA == countB && countA > 0;
    }
}

class poilishNotation
{
    void infixTOPostFix(String infrix)
    {

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
    }
}

public class Lab7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        IntStack intstack = new IntStack();
        // intstack.opertaionsOnStack(sc);

        CharStack charStack = new CharStack();
        // charStack.isPalindrome(sc);
        
        if (charStack.isAiBi(sc))
        System.out.println("The string is of the form a^i b^i");
        else
        System.out.println("The string is NOT of the form a^i b^i");
        

    }
    
}
