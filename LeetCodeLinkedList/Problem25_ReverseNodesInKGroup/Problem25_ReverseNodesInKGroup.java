
package Problem25_ReverseNodesInKGroup;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Problem25_ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, curr = dummy, next = dummy;

        // count length of list
        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        // reverse in groups of k
        while (count >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // Example: head=[1,2,3,4,5], k=2 → [2,1,4,3,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Problem25_ReverseNodesInKGroup sol = new Problem25_ReverseNodesInKGroup();
        ListNode res = sol.reverseKGroup(head, 2);

        System.out.print("Reversed in K-Group: ");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
