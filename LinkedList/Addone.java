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

public class Addone {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 9, 9 };
        ListNode head = insert(arr);
        // head = reverse(head);
        // head = addOne(head);
        // head = reverse(head);
        head = addOneOA(head);
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
        ListNode temp = head;
        ListNode prev = null;
        ListNode next = head;
        while (temp != null) {
            // prev = temp;
            // temp = temp.next;
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;

        }
        return prev;
    }

    public static ListNode addOne(ListNode head) {
        ListNode temp = head;
        int carry = 1;
        while (temp.next != null) {
            int sum = temp.data + carry;
            temp.data = sum % 10;
            if (sum >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            temp = temp.next;
            if (carry == 0) {
                break;
            }
        }
        if (temp.next == null && carry == 1) {
            ListNode n = new ListNode(carry);
            temp.data = (temp.data + carry) % 10;
            temp.next = n;
        }
        return head;
    }

    public static ListNode addOneOA(ListNode head) {
        ListNode temp = head;
        int carry = helper(temp);
        if (carry == 1) {
            ListNode n = new ListNode(carry, head);
            // temp.next = n;
            return n;
        }
        return head;
    }

    public static int helper(ListNode temp) {
        if (temp == null) {
            return 1;
        }
        int carry = helper(temp.next);
        int sum = (temp.data + carry);
        temp.data = (temp.data + carry) % 10;
        if (sum >= 10) {
            carry = 1;
        } else {
            carry = 0;
        }

        return carry;
    }
}
