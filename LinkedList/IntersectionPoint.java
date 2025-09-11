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

public class IntersectionPoint {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4, 5, 6, 7 };
        ListNode head = insert(arr);
        ListNode head1 = new ListNode(10, head.next.next);
        ListNode tem = ifCommon(head, head1);
        System.out.println(tem != null ? tem.data : null);
        ListNode res = ifCommonOA(head, head1);
        System.out.println(res != null ? res.data : null);
        print(head);
        print(head1);

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
            // temp = temp.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static ListNode ifCommon(ListNode head, ListNode head1) {
        int len1 = length(head);
        int len2 = length(head1);
        ListNode temp = null;
        if (len1 > len2) {
            temp = commonNode(head, head1, len1 - len2);
        } else {
            temp = commonNode(head1, head, len2 - len1);
        }
        return temp;
    }

    public static ListNode commonNode(ListNode head, ListNode head1, int len) {
        ListNode temp = null;
        while (len != 0) {
            len--;
            head = head.next;
        }
        while (head != null) {
            if (head == head1) {
                temp = head;
                break;
            }
            head = head.next;
            head1 = head1.next;
        }
        return temp;
    }

    public static int length(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static ListNode ifCommonOA(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return null;

        ListNode temp1 = head1;
        ListNode temp2 = head2;
        while (temp1 != temp2) {
            temp1 = (temp1 == null) ? head2 : temp1.next;
            temp2 = (temp2 == null) ? head1 : temp2.next;
        }

        return temp1;
    }
}
