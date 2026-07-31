package Problem148_SortList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem148_SortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // 1. Split list into two halves
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // break into two halves

        // 2. Sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        // 3. Merge sorted halves
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        // Example: [4,2,1,3] -> [1,2,3,4]
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        Problem148_SortList sol = new Problem148_SortList();
        ListNode sorted = sol.sortList(head);

        System.out.print("Sorted List: ");
        while (sorted != null) {
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
    }
}
