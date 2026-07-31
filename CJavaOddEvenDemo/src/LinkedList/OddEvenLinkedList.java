package LinkedList;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode odd = head, even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode seven = new ListNode(7);

        one.next = two;
        two.next = four;
        four.next = five;
        five.next = seven;

        ListNode.printElement(one);

        ListNode newHead = oddEvenList(one);

        ListNode.printElement(newHead);
    }
}
