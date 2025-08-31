package LinkedList;

import java.util.Stack;

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseLL {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6 };
        // int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        Node head = insert(arr);
        // head = reverseOfllBF(head);
        // head = reverseOfllOA(head);
        head = reverseRecursion(head);
        print(head);
        // midOfllOA(head1);
    }

    public static Node insert(int[] arr) {
        Node head = null;
        Node temp = head;
        for (int i : arr) {
            Node n = new Node(i);
            if (head == null) {
                head = n;
                temp = head;
            } else {
                temp.next = n;
                temp = n;
            }
        }
        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        if (head == null) {
            System.out.println("List is Empty");
        } else {
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
        }
    }

    public static Node reverseOfllBF(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = stack.peek();
            stack.pop();
            temp = temp.next;
        }
        return head;
    }

    public static Node reverseOfllOA(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node prev = null;
        Node next = head.next;
        while (temp != null) {
            // prev = temp;
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static Node reverseRecursion(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseRecursion(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

}
