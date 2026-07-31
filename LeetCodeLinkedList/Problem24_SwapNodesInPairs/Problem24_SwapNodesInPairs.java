package Problem24_SwapNodesInPairs;

public class Problem24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    // 🔹 Main method for testing in VS Code
    public static void main(String[] args) {
        // Create sample linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        Problem24_SwapNodesInPairs solution = new Problem24_SwapNodesInPairs();
        ListNode result = solution.swapPairs(head);

        // Print swapped list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Expected Output: 2 1 4 3
    }
}

// Standard ListNode definition
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
