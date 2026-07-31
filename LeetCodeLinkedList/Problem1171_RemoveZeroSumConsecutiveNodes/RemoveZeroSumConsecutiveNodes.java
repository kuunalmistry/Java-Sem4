package Problem1171_RemoveZeroSumConsecutiveNodes;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class RemoveZeroSumConsecutiveNodes {

    public ListNode removeZeroSumSublists(ListNode head) {
        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Map prefix sum to node
        java.util.Map<Integer, ListNode> map = new java.util.HashMap<>();
        int prefixSum = 0;

        // First pass: store the last occurrence of each prefix sum
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefixSum += curr.val;
            map.put(prefixSum, curr);
        }

        // Second pass: remove nodes between duplicate prefix sums
        prefixSum = 0;
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefixSum += curr.val;
            curr.next = map.get(prefixSum).next;
        }

        return dummy.next;
    }

    // Test code
    public static void main(String[] args) {
        RemoveZeroSumConsecutiveNodes solver = new RemoveZeroSumConsecutiveNodes();

        // Example: [1,2,-3,3,1] -> [3,1]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        ListNode result = solver.removeZeroSumSublists(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 3 1
    }
}
