package LinkedList;

import java.util.HashMap;
import java.util.Map;

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

public class LengthOfCircle {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6 };
        // int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        Node head = insert(arr);
        locBF(head);
        locOA(head);
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

    public static void locBF(Node head) {
        if (head == null || head.next == null) {
            System.out.println("No Node or Single node is Present");
        }
        Map<Node, Integer> map = new HashMap<>();
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (map.containsKey(temp)) {
                System.out.println("Length : " + (count - map.get(temp)));
                break;
            }
            map.put(temp, count);
            temp = temp.next;
        }
    }

    public static void locOA(Node head) {
        if (head == null || head.next == null) {
            System.out.println("No Node or Single node is Present");
        }
        // Map<Node, Integer> map = new HashMap<>();
        Node slow = head;
        Node fast = head;
        int count = 1;
        while (fast != null && fast.next != null) {
            // count++;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = fast.next;
                while (fast != slow) {
                    count++;
                    fast = fast.next;
                }
                System.out.println("Length :: " + count);
                break;
            }

        }
    }

}