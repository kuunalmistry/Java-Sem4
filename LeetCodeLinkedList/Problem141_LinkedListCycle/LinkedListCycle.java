package Problem141_LinkedListCycle;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle sol = new LinkedListCycle();

        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        n4.next = n2; // cycle
        System.out.println("Has Cycle? " + sol.hasCycle(n1));

        ListNode m4 = new ListNode(4);
        ListNode m3 = new ListNode(3, m4);
        ListNode m2 = new ListNode(2, m3);
        ListNode m1 = new ListNode(1, m2);
        System.out.println("Has Cycle? " + sol.hasCycle(m1));
    }
}
