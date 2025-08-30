package DoublyLinkedList;

import java.util.Stack;

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

public class AlFuncDLL {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5 };
        Node head = insert(arr);
        // head = deletionHead(head);
        // head = deletionTail(head);
        // head = deletionAny(head, 1);
        // head = deletionVal(head, 3);
        // deletionNode(head);
        // head = insertionBeforeHead(head, 10);
        // head = insertionAfterHead(head, 11);
        // head = insertionBeforeTail(head, 11);
        // head = insertionAfterTail(head, 10);
        // head = insertionAfterAny(head, 2, 15);
        // head = insertionBeforeAny(head, 2, 15);
        // insertBeforeNode(head.next, 16);
        // head = reverseBF(head);
        head = reverseOA(head);
        print(head);
    }

    public static Node insert(int[] arr) {
        if (arr == null) {
            return null;
        }
        Node head = null;
        Node temp = head;
        Node prev = null;
        for (int i : arr) {
            if (head == null) {
                head = new Node(i);
                prev = head;
            } else {
                temp = new Node(i, prev, null);
                prev.next = temp;
                prev = temp;
            }
        }
        return head;
    }

    public static Node insertionBeforeHead(Node head, int data) {
        Node n = new Node(data, null, head);
        head.back = n;
        return n;
    }

    public static Node insertionAfterHead(Node head, int data) {
        Node n = new Node(data, head, head.next);
        head.next = n;
        return head;
    }

    public static Node insertionBeforeTail(Node head, int data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node n = new Node(data, temp.back, temp);
        temp.back.next = n;
        temp.back = n;
        return head;
    }

    public static Node insertionAfterTail(Node head, int data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node n = new Node(data, temp, null);
        temp.next = n;
        return head;
    }

    public static Node insertionAfterAny(Node head, int k, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                break;
            }
            temp = temp.next;
        }
        if (temp.back == null && temp.next == null) {
            Node n = new Node(data, temp, null);
            temp.next = n;
        } else if (temp.back == null) {
            return insertionAfterHead(head, data);
        } else if (temp.next == null) {
            Node n = new Node(data, temp, null);
            temp.next = n;
        } else {
            Node n = new Node(data, temp, temp.next);
            temp.next.back = n;
            temp.next = n;
        }
        return head;
    }

    public static Node insertionBeforeAny(Node head, int k, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                break;
            }
            temp = temp.next;
        }
        if (temp.back == null && temp.next == null) {
            Node n = new Node(data, temp, null);
            temp.next = n;
        } else if (temp.back == null) {
            return insertionBeforeHead(head, data);
        } else if (temp.next == null) {
            Node n = new Node(data, temp.back, temp);
            temp.back = n;
        } else {
            Node n = new Node(data, temp.back, temp);
            temp.back.next = n;
            temp.back = n;
        }
        return head;
    }

    public static void insertBeforeNode(Node n, int data) {
        Node node = new Node(data, n.back, n);
        n.back.next = node;
        n.back = node;
    }

    public static Node deletionHead(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    public static Node deletionAny(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            if (count == k) {
                break;
            }
            temp = temp.next;
        }
        if (temp.back == null && temp.next == null) {
            return null;
        } else if (temp.back == null) {
            return deletionHead(head);
        } else if (temp.next == null) {
            temp.back.next = null;
            temp.back = null;
        } else {
            temp.back.next = temp.next;
            temp.back = null;
            temp.next.back = temp.back;
            temp.next = null;
        }

        return head;
    }

    public static void deletionNode(Node n) {
        n.back.next = n.next;
        n.next.back = n.back;
        n.next = null;
        n.back = null;
    }

    public static Node deletionVal(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        // int count = 0;
        while (temp != null) {
            // count++;
            if (temp.data == k) {
                break;
            }
            temp = temp.next;
        }
        if (temp.back == null && temp.next == null) {
            return null;
        } else if (temp.back == null) {
            return deletionHead(head);
        } else if (temp.next == null) {
            temp.back.next = null;
            temp.back = null;
        } else {
            temp.back.next = temp.next;
            temp.back = null;
            temp.next.back = temp.back;
            temp.next = null;
        }

        return head;
    }

    public static Node deletionTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.back.next = null;
        temp.back = null;
        return head;
    }

    public static void print(Node head) {
        if (head == null) {
            System.out.println("List is Empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node reverseBF(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node temp = head;
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = stack.peek();
            stack.pop();
            temp = temp.next;
        }
        return head;
    }

    public static Node reverseOA(Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            prev = temp.back;
            temp.back = temp.next;
            temp.next = prev;

            temp = temp.back;
        }
        if (prev != null) {
            head = prev.back;
        }

        return head;
    }
}
