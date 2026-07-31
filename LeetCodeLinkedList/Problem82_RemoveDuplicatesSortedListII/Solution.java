package Problem82_RemoveDuplicatesSortedListII;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        // Dummy node to handle cases where head itself is duplicate
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null) {
            // Skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next; // remove duplicates
            } else {
                prev = prev.next;
            }
            head = head.next;
        }

        return dummy.next;
    }

    // For local testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Input: [1,2,3,3,4,4,5]
        ListNode head = new ListNode(1,
            new ListNode(2,
            new ListNode(3,
            new ListNode(3,
            new ListNode(4,
            new ListNode(4,
            new ListNode(5)))))));

        ListNode result = sol.deleteDuplicates(head);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Expected Output: 1 2 5
    }
}
