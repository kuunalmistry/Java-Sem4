package Problem86_PartitionList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        // Two dummy lists: one for < x and one for >= x
        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;

        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;         // terminate the "after" list
        before.next = afterHead.next; // join the lists

        return beforeHead.next;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Input: head = [1,4,3,2,5,2], x = 3
        ListNode head = new ListNode(1,
            new ListNode(4,
            new ListNode(3,
            new ListNode(2,
            new ListNode(5,
            new ListNode(2))))));

        ListNode result = sol.partition(head, 3);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Expected Output: 1 2 2 4 3 5
    }
}
