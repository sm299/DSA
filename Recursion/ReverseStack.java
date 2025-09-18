package Recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println(stack);
        stack = reverse(stack);
        System.out.println(stack);
        reverse2(stack);
        System.out.println(stack);
    }

    public static Stack reverse(Stack stack) {
        int bottom = 0;
        int top = stack.size() - 1;
        swap(bottom, top, stack);
        return stack;
    }

    public static void swap(int bottom, int top, Stack stack) {
        if (bottom < top) {
            int temp = (int) stack.get(top);
            stack.set(top, (int) stack.get(bottom));
            stack.set(bottom, temp);
            bottom++;
            top--;
            swap(bottom, top, stack);
        }

    }
    // end of my code
    // start of optimal code

    public static void reverse2(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;

        int top = stack.pop();
        reverse2(stack);
        insertAtBottom(stack, top);
    }

    public static void insertAtBottom(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }

        int temp = stack.pop();
        insertAtBottom(stack, val);
        stack.push(temp);
    }
}
