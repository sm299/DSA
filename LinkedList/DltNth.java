package LinkedList;

//Delete Nth from End
class ListNode {
    int data;
    ListNode next;

    ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DltNth {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 4, 2, 3 };
        ListNode head = insert(arr);
        // head = dltNthBF(head, 1);
        head = DltNthOA(head, 8);
        print(head);
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode insert(int[] arr) {
        ListNode head = null;
        ListNode temp = head;
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

    public static ListNode dltNthBF(ListNode head, int n) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count == n) {
            return head.next;
        }
        temp = head;
        for (int i = 1; i < count - n; i++) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
        return head;
    }

    public static ListNode DltNthOA(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
