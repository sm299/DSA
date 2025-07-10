import java.util.Stack;

public class InFixToPostFix {
    public static void main(String[] args) {
        String s1 = "a+b+c+d-e";
        String s2 = "3*(1+1)";
        System.out.println(inFixToPostFix(s1));
        System.out.println(inFixToPostFix(s2));
    }

    public static String inFixToPostFix(String s) {
        char[] arr = s.toCharArray();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for (char c : arr) {
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    while (!stack.isEmpty() &&
                            (precedence(c) <= precedence(stack.peek()))) {
                        result.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    private static int precedence(char c) {
        // TODO Auto-generated method stub
        switch (c) {
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
}