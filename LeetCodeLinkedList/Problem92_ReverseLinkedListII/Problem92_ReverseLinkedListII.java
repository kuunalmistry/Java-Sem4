package Problem92_ReverseLinkedListII;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem92_ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // move prev to node before "left"
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // start reversing
        ListNode curr = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example: head = [1,2,3,4,5], left=2, right=4 → [1,4,3,2,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Problem92_ReverseLinkedListII sol = new Problem92_ReverseLinkedListII();
        ListNode res = sol.reverseBetween(head, 2, 4);

        System.out.print("Reversed List: ");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
