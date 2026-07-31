package Problem203_RemoveLinkedListElements;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Problem203_RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example: [1,2,6,3,4,5,6], val = 6 → [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        Problem203_RemoveLinkedListElements sol = new Problem203_RemoveLinkedListElements();
        ListNode res = sol.removeElements(head, 6);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}

