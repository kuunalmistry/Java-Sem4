package Problem725_SplitLinkedListInParts;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // First, find the total length of the list
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        // Determine the size of each part
        int partSize = length / k;
        int remainder = length % k;

        ListNode[] result = new ListNode[k];
        curr = head;

        for (int i = 0; i < k && curr != null; i++) {
            result[i] = curr;

            int currentPartSize = partSize + (i < remainder ? 1 : 0);

            // Move to the end of this part
            for (int j = 1; j < currentPartSize; j++) {
                curr = curr.next;
            }

            // Break the list
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return result;
    }
}
