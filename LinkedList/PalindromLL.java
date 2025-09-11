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

public class PalindromLL {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 4, 2, 3 };
        Node head = insert(arr);
        palBF(head);
        System.out.println("Is palindrom : " + palOA(head));

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
        // temp.next = head.next.next;
        return head;
    }

    public static void palBF(Node head) {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            System.out.println("If Palindrom : " + true);
            return;
        }
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        boolean isPlaindrom = true;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.data != stack.peek()) {
                isPlaindrom = false;
                break;
            }
            temp = temp.next;
            stack.pop();
        }
        System.out.println("If Palindrom: " + isPlaindrom);
    }

    public static boolean palOA(Node head) {
        // boolean isPlaindrom = true;
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node newHead = reverse(slow.next);
        Node first = head;
        Node second = newHead;
        while (second != null) {
            if (first.data != second.data) {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node temp = head;
        Node next = head.next;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;

        }
        return prev;
    }
}
