package LinkedList;

class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

}

public class RotateLL {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        ListNode head = insert(arr);
        head = rotate(head, 2);
        print(head);
    }

    public static ListNode insert(int[] arr) {
        ListNode head = null;
        ListNode temp = null;
        for (int i : arr) {
            ListNode n = new ListNode(i);
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

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static ListNode rotate(ListNode head, int rotation) {
        if (head == null || head.next == null || rotation == 0) {
            return head;
        }
        ListNode temp = head;
        ListNode newHead = null;
        ListNode prev = null;
        int count = 1;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        rotation = (count - (rotation % count)) % count;

        if (rotation != 0) {
            temp.next = head;
            temp = head;
            while (rotation > 0) {
                prev = temp;
                temp = temp.next;
                rotation--;
            }

            newHead = temp;
            prev.next = null;
            return newHead;
        } else {
            return head;
        }
    }
}
