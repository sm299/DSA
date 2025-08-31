package LinkedList;

import java.util.ArrayList;
import java.util.List;

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

public class IfCirClePresent {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6 };
        // int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        Node head = insert(arr);
        isCircularBF(head);
        isCircularOA(head);
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
        temp.next = head.next.next;
        return head;
    }

    public static void isCircularBF(Node head) {
        List<Node> list = new ArrayList<>();
        Node temp = head;
        boolean isCircular = false;
        while (temp != null) {
            if (list.contains(temp)) {
                System.out.println();
                System.out.println("Cycle starts at : " + temp.data);
                isCircular = true;
                break;
            }
            System.out.print(temp.data + " ");
            list.add(temp);
            temp = temp.next;
        }

        System.out.println("List if Circular : " + isCircular);
    }

    public static void isCircularOA(Node head) {
        Node slow = head;
        Node fast = head;
        boolean isCircular = false;
        while (fast != null) {
            // System.out.print(fast.data + " ");
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                // System.out.println();
                // System.out.println("Circle starts at : " + slow.data);
                isCircular = true;
                break;
            }

        }
        System.out.println("List is Circular Tortoise & Hare : " + isCircular);
    }

}
