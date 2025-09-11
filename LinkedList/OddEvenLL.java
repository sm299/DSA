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

public class OddEvenLL {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 4, 2, 3 };
        Node head = insert(arr);
        // head = oddEvenLLBF(head);
        // head = oddEvenLLMS(head);
        head = oddEvenLLOA(head);
        print(head);
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
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

    public static Node oddEvenLLBF(Node head) {
        if (head == null && head.next == null) {
            return head;
        }
        Node temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) {
            list.add(temp.data);
        }
        temp = head.next;
        while (temp != null && temp.next != null) {
            list.add(temp.data);
            temp = temp.next.next;
        }
        if (temp != null) {
            list.add(temp.data);
        }
        temp = head;
        for (int i : list) {
            temp.data = i;
            temp = temp.next;
        }
        return head;
    }

    public static Node oddEvenLLMS(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node oddTemp = head;
        Node evenTemp = head.next;
        Node temp = head;
        Node newHead = head.next;
        Node prev = null;
        int count = 0;
        while (temp != null) {
            count++;
            prev = temp;
            if (count % 2 == 0) {
                evenTemp = temp;
                evenTemp = evenTemp.next;
            } else {
                oddTemp = temp;
                oddTemp = oddTemp.next;
            }
            temp = temp.next;
        }
        prev.next = newHead;
        return head;
    }

    public static Node oddEvenLLOA(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

}
