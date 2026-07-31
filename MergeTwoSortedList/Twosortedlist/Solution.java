class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;

        if (list1 == null && list2 == null) {
            return head;
        } else if (list1 == null && list2 != null) {
            return list2;
        } else if (list1 != null && list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode curr = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        if (list1 != null) curr.next = list1;
        if (list2 != null) curr.next = list2;

        return head;
    }

    public static void main(String[] args) {
        // First list: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        // Second list: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        Solution sol = new Solution();
        ListNode merged = sol.mergeTwoLists(l1, l2);

        // Print result
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
}
