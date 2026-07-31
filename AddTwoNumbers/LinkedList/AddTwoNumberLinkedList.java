package LinkedList;

public class AddTwoNumberLinkedList {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int sum = 0, carry = 0;

        while (l1 != null || l2 != null) {
            int p = (l1 == null) ? 0 : l1.val;
            int q = (l2 == null) ? 0 : l2.val;

            sum = p + q + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
       
        ListNode l1_one = new ListNode(2);
        ListNode l1_two = new ListNode(4);
        ListNode l1_four = new ListNode(3);
        l1_one.next = l1_two;
        l1_two.next = l1_four;

        ListNode l2_one = new ListNode(5);
        ListNode l2_three = new ListNode(6);
        ListNode l2_four = new ListNode(4);
        l2_one.next = l2_three;
        l2_three.next = l2_four;

        ListNode newHead = addTwoNumbers(l1_one, l2_one);

        ListNode.printElement(newHead);
    }
}
