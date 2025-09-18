package Recursion;

import java.util.Stack;

public class SortingStack {
    public static void main(String args[]) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);
        System.out.println("Original stack: " + st);
        sortStack(st);
        System.out.println("Sorted stack: " + st);
    }

    public static void sortStack(Stack<Integer> st) {

        if (!st.isEmpty()) {
            int top = st.pop();
            sortStack(st);
            insertSorted(st, top);
        }
    }

    public static void insertSorted(Stack<Integer> st, int x) {
        if (st.isEmpty() || st.peek() <= x) {
            st.push(x);
            return;
        }
        int temp = st.pop();
        insertSorted(st, x);
        st.push(temp);
    }
}
