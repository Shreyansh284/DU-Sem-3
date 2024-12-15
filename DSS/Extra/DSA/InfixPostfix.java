
// * lab 8
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class InfixPostfix {
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    static String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);

            if (Character.isLetterOrDigit(current)) {
                result.append(current);
            } else if (current == '(') {
                stack.push(current);
            } else if (current == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop();
            } else if (isOperator(current)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(current)) {
                    result.append(stack.pop());
                }
                stack.push(current);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    static void infixToPrefix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        String reversedInfix = reverseString(infix);
        StringBuilder modifiedInfix = new StringBuilder();

        for (int i = 0; i < reversedInfix.length(); i++) {
            char ch = reversedInfix.charAt(i);
            if (ch == '(') {
                modifiedInfix.append(')');
            } else if (ch == ')') {
                modifiedInfix.append('(');
            } else {
                modifiedInfix.append(ch);
            }
        }

        String postfix = infixToPostfix(modifiedInfix.toString());
        String prefix = reverseString(postfix);

        System.out.println("Infix Notation: " + infix);
        System.out.println("Prefix Notation: " + prefix);
    }

    static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] arr = expression.split(" ");
        
        for (int i = 0; i <arr.length; i++) {
            // System.out.println(num);
            if (arr[i]=="+"||arr[i]=="-"||arr[i]=="/"||arr[i]=="*") {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch (arr[i]) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                }
            } 
            else {

                stack.push(Integer.parseInt(arr[i]));
            }
        }

        return stack.pop();
    }

    static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter an infix equation: ");
        // String infix = sc.next();
        // String postfix = infixToPostfix(infix);
        // System.out.println("Infix Notation: " + infix);
        // System.out.println("Postfix Notation: " + postfix);
        // infixToPrefix(infix);
        String postfixExpr = "2053+82-*";
        // String prefixExpr = "*+53-82";
        // System.out.println("Postfix Expression: " + postfixExpr);
        System.out.println("Postfix Evaluation Result: " + evaluatePostfix(postfixExpr));

        // System.out.println("Prefix Expression: " + prefixExpr);
        // System.out.println("Prefix Evaluation Result: " + evaluatePrefix(prefixExpr));
        // evaluatePostfix("50 2 +");
        sc.close();
    }
}