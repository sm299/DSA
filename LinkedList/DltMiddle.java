package LinkedList;

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

public class DltMiddle {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6 };
        Node head = insert(arr);
        head = DltMiddle(head);
        print(head);
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

    public static Node dltmidOA(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head == null || head.next == null) {
            return null;
        }
        Node fast = head;
        Node slow = head;
        fast = fast.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
