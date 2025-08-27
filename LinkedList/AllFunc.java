package LinkedList;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

public class AllFunc {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 4, 3 };
        Node head = insert(arr);
        // head = insertAny(head, 1, 11);
        // head = deletionHead(head);
        // head = deletionTail(head);
        // head = deletionAny(head, 2);
        // head = deletionValue(head, 4);
        // head = insertionHead(head, 20);
        // head = insertionTail(head, 20);
        // head = insertionAny(head, 5, 25);
        head = insertionBeforeValue(head, 5, 25);
        // head = insertionAfterValue(head, 5, 25);
        print(head);
    }

    public static Node insert(int[] arr) {
        Node head = null;
        Node temp = null;
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

    public static Node insertionHead(Node head, int data) {
        return new Node(data, head);
    }

    public static Node insertionTail(Node head, int data) {

        if (head == null)
            return new Node(data);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        return head;
    }

    public static Node insertionAny(Node head, int k, int data) {
        if (head == null) {
            if (k == 1)
                return new Node(data);
            else
                return head;
        }
        if (k == 1) {
            return new Node(data, head);
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k - 1) {
                Node n = new Node(data, temp.next);
                temp.next = n;
                break;
            }
            temp = temp.next;
        }

        if (k > count + 1) {
            System.out.println("List length is smaller that the given position");
        }
        return head;
    }

    public static Node insertionAfterValue(Node head, int eData, int data) {
        if (head == null) {
            return head;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == eData) {
                Node n = new Node(data, temp.next);
                temp.next = n;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node insertionBeforeValue(Node head, int eData, int data) {
        if (head == null) {
            return head;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == eData) {
                Node n = new Node(data, temp.next);
                temp.next = n;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node deletionHead(Node head) {
        if (head == null)
            return head;
        return head.next;
    }

    public static Node deletionTail(Node head) {
        Node temp = head;
        if (head == null || head.next == null)
            return head;
        while (temp.next != null) {
            if (temp.next.next == null) {
                temp.next = null;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public static Node deletionAny(Node head, int k) {
        Node temp = head;
        Node prev = null;
        int count = 0;
        if (head == null)
            return head;
        if (k == 1) {
            return head.next;
        }
        while (temp != null) {
            count++;
            if (count == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node deletionValue(Node head, int data) {
        Node temp = head;
        Node prev = null;
        // int count = 0;
        if (head == null)
            return head;
        if (head.data == data) {
            return head.next;
        }
        while (temp != null) {
            // count++;
            if (temp.data == data) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static void print(Node head) {
        Node temp = head;
        System.out.println("Linked List : ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    // In case you haven't given the whole list but the node only
    public void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }
}
