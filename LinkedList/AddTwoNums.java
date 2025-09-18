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

public class AddTwoNums {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4, 9 };
        int[] arr1 = { 1, 5, 6, 7, 8, 9 };
        ListNode head1 = insert(arr);
        ListNode head2 = insert(arr1);
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode head = add(head1, head2);
        head = reverse(head);
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
                temp = temp.next;
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

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;

        }
        return prev;
    }

    public static ListNode add(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode dummy = dummyHead;
        int carry = 0;
        while (head1 != null && head2 != null) {
            int sum = head1.data + head2.data + carry;
            if (sum >= 10) {
                ListNode n = new ListNode(sum % 10);
                dummy.next = n;
                dummy = n;
                carry = 1;
            } else {
                ListNode n = new ListNode(sum % 10);
                dummy.next = n;
                dummy = n;
                carry = 0;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        while (head1 != null) {
            int sum = head1.data + carry;
            if (sum >= 10) {
                ListNode n = new ListNode(sum % 10);
                carry = 1;
                dummy.next = n;
                dummy = n;
            } else {
                ListNode n = new ListNode(sum % 10);
                dummy.next = n;
                dummy = n;
                carry = 0;
            }
            head1 = head1.next;
        }
        while (head2 != null) {
            int sum = head2.data + carry;
            if (sum >= 10) {
                ListNode n = new ListNode(sum % 10);
                carry = 1;
                dummy.next = n;
                dummy = n;
            } else {
                ListNode n = new ListNode(sum % 10);
                dummy.next = n;
                dummy = n;
                carry = 0;
            }
            head2 = head2.next;
        }
        if (carry == 1) {
            ListNode n = new ListNode(carry);
            dummy.next = n;
            dummy = n;

        }
        return dummyHead.next;
    }
}
