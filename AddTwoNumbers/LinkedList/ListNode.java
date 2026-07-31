package LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static void printElement(ListNode head) {

        ListNode curr = head;

        while(curr!=null){
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
        System.out.println();
    }

}