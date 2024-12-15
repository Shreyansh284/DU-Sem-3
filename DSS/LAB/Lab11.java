import java.util.Stack;




public class Lab11 {
    
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
    // static String infixToPostfix(String infix)
    // {
    
    //     Stack<Character> stack = new Stack<>();
    //     StringBuilder result = new StringBuilder();
    //     int i=0;
    //     while(i<infix.length())
    //     {
    //         char current=infix.charAt(i);

    //         if(Character.isLetterOrDigit(current))
    //         {
    //             result.append(current);
    //         }
    //          if(current =='(')
    //         {
    //             stack.push(current);
    //         }
    //        if(current==')')
    //         {
    //             while(!stack.isEmpty() && stack.peek()!=')')
    //             {
    //                 result.append(stack.pop());
    //             }
    //             stack.pop();
    //         }
    //         if(isOperator(current))
    //         {
    //             while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(current)) {
    //                 result.append(stack.pop());
    //             }
    //             stack.push(current);
    //         }
    //     }
    //     while (!stack.isEmpty()) {
    //         result.append(stack.pop());
    //     }
    //     return result.toString();
    // }

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
                // System.out.println(Integer.parseInt(arr[i]));
                // System.out.println(Integer.parseInt(arr[i]));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String expression = "23 + 4 *";
        System.out.println("Postfix expression: " + evaluatePostfix(expression));
    }
}
