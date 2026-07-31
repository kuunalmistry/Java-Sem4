package Problem1669_MergeInBetweenLinkedLists;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;
        ListNode afterB = list1;

        // Find node before index a
        for (int i = 0; i < a - 1; i++) {
            prevA = prevA.next;
        }

        // Find node after index b
        for (int i = 0; i < b; i++) {
            afterB = afterB.next;
        }
        afterB = afterB.next;

        // Connect prevA to head of list2
        prevA.next = list2;

        // Move to the end of list2
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        // Connect end of list2 to afterB
        tail2.next = afterB;

        return list1;
    }
}
