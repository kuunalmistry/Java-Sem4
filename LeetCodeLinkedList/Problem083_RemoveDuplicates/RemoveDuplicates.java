package Problem083_RemoveDuplicates;

public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;  // skip duplicate
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        // Example: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1,
                        new ListNode(1,
                        new ListNode(2,
                        new ListNode(3,
                        new ListNode(3)))));

        RemoveDuplicates rd = new RemoveDuplicates();
        ListNode result = rd.deleteDuplicates(head);

        // Print result: should be 1 -> 2 -> 3
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
