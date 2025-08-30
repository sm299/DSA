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

public class MidOfLL {
    public static void main(String[] args) {
        int[] arr1 = { 3, 2, 4, 5, 6 };
        int[] arr2 = { 1, 2, 3, 4, 5, 6 };
        Node head1 = insert(arr1);
        // print(head1);
        System.out.println();
        midOfllBF(head1);
        midOfllOA(head1); // Hare Tortoise Method;
        Node head2 = insert(arr2);
        // print(head2);
        midOfllBF(head2);
        midOfllOA(head2); // Hare Tortoise Method;
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

    public static void midOfllBF(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int mid = (count / 2) + 1;
        temp = head;
        while (temp != null) {
            mid--;
            if (mid == 0) {
                System.out.println("The Mid Element in BF : " + temp.data);
                break;
            }
            temp = temp.next;
        }
    }

    public static void midOfllOA(Node head) {
        if (head == null) {
            System.out.println("List is Empty");
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("The Mid Element by Hare Tortoise Method : " + slow.data);
    }
}
