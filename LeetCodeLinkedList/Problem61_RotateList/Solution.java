package Problem61_RotateList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find length and tail
        ListNode cur = head;
        int length = 1;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }

        // Step 2: Connect tail -> head (make it circular)
        cur.next = head;

        // Step 3: Find new head after rotation
        k = k % length;
        int stepsToNewHead = length - k;

        ListNode newTail = cur;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Step 4: Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    // For local testing in VS Code
    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2;

        ListNode rotated = sol.rotateRight(head, k);

        while (rotated != null) {
            System.out.print(rotated.val + " ");
            rotated = rotated.next;
        }
        // Expected Output: 4 5 1 2 3
    }
}
