package DoublyLinkedList;
//Remove duplicate from sorted DLL

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

public class RemoveDuplicate {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 1, 2, 2, 2, 3, 4, 5, 5 };
        Node head = insert(arr);
        head = rmvDup(head);
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

    public static Node rmvDup(Node head) {
        Node temp = head;
        if (head == null || head.next == null) {
            return head;
        }
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

}
