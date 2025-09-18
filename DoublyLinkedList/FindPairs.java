package DoublyLinkedList;

//DLL is sorted , Have to find pair to sum up target
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

public class FindPairs {
    public static void main(String[] args) {
        int[] arr = { -4, 1, 2, 3, 4, 5, 6, 9, 10 };
        int target = 6;
        Node head = insert(arr);
        findPair(head, target);
        System.out.println("Optimal one");
        findPairOA(head, target);
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

    public static void findPair(Node head, int target) {
        Node temp1 = head;
        Node temp2 = temp1.next;
        while (temp1 != null) {
            temp2 = temp1.next;
            while (temp2 != null && (temp1.data + temp2.data) <= target) {
                if ((temp1.data + temp2.data) == target) {
                    System.out.println("Pair : " + temp1.data + " , " + temp2.data);
                    break;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
    }

    public static void findPairOA(Node head, int target) {
        Node left = head;
        Node right = head;
        Node temp = head;
        while (right.next != null) {
            right = right.next;
        }
        while (temp.next != null && left.data < right.data) {
            int sum = left.data + right.data;
            if (sum == target) {
                System.out.println("Pair : " + left.data + " , " + right.data);
                left = left.next;
                right = right.back;
            } else if (sum < target) {
                left = left.next;
            } else {
                right = right.back;
            }
        }
    }
}
