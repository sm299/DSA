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

public class SortLL {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 6, 4, 2, 3 };
        ListNode head = insert(arr);
        // head = dltNthBF(head, 1);
        head = MergeSortOA(head);
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

    public static ListNode MergeSortOA(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMid(head);
        ListNode left = head;
        ListNode right = middle.next;
        middle.next = null;
        left = MergeSortOA(left);
        right = MergeSortOA(right);
        return merge(left, right);
    }

    public static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode temp = null;
        ListNode dummy = new ListNode(-1);
        temp = dummy;
        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                temp = left;
                left = left.next;
                // temp = temp.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
                // temp = temp.next;
            }
        }
        if (left != null) {
            temp.next = left;
        }
        if (right != null) {
            temp.next = right;
        }
        return dummy.next;
    }

}
