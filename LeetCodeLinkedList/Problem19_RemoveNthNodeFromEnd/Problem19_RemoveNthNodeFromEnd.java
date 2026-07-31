package Problem19_RemoveNthNodeFromEnd;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem19_RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node for handling head removal easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Move first pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move first to the end, maintaining gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Remove nth node
        second.next = second.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example: [1,2,3,4,5], n=2 → Output: [1,2,3,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Problem19_RemoveNthNodeFromEnd sol = new Problem19_RemoveNthNodeFromEnd();
        ListNode res = sol.removeNthFromEnd(head, 2);

        System.out.print("Result List: ");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
