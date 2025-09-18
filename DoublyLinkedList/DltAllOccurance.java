package DoublyLinkedList;

class Node {
    int data;
    Node back;
    Node next;

    Node(int data, Node back, Node next) {
        this.data = data;
        this.back = back;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.back = null;
        this.next = null;
    }
}

public class DltAllOccurance {
    public static void main(String[] args) {
        int[] arr = { 10, 4, 5, 10, 11, 10, 3, 10 };
        Node head = insert(arr);
        head = dtlOccr(head, 10);
        print(head);
    }

    public static Node insert(int[] arr) {
        Node head = null;
        Node temp = head;
        Node prev = null;
        for (int i : arr) {
            Node n = new Node(i, prev, null);
            if (head == null) {
                head = n;
                prev = head;
            } else {
                temp = n;
                prev.next = temp;
                prev = temp;
            }
        }
        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node dtlOccr(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                if (temp.back == null) {
                    head = head.next;
                } else {
                    temp.back.next = temp.next;
                    temp.back = null;
                }
            }
            temp = temp.next;
        }

        return head;
    }
}
