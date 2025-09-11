package LinkedList;

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

public class zot {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 0, 2, 1, 1, 1, 1, 2, 2, 2, 0, 0 };
        ListNode head = null;
        head = insert(arr);
        head = sort(head);
        print(head);
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
                // ListNode n = new ListNode(i);
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

    public static ListNode sort(ListNode head) {
        ListNode temp = head;
        ListNode zh = new ListNode(-1);
        ListNode tr0 = zh;
        ListNode oh = new ListNode(-1);
        ListNode tr1 = oh;
        ListNode th = new ListNode(-1);
        ListNode tr2 = th;
        while (temp != null) {
            if (temp.data == 0) {
                zh.next = temp;
                zh = temp;
            } else if (temp.data == 1) {
                oh.next = temp;
                oh = temp;
            } else {
                th.next = temp;
                th = temp;
            }
            temp = temp.next;
        }
        th.next = null;
        if (tr0.next != null) {
            zh.next = tr1.next;
            oh.next = tr2.next;
        } else {
            zh.next = tr2.next;
        }

        return tr0.next;
    }
}
