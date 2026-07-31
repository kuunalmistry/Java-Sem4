// File: FlattenMultilevelDoublyLinkedList.java
package Problem430_FlattenMultilevelDoublyLinkedList;
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }
}

public class FlattenMultilevelDoublyLinkedList {

    // LeetCode function
    public Node flatten(Node head) {
        if (head == null) return head;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        flattenDFS(prev, head);

        dummy.next.prev = null; // detach dummy
        return dummy.next;
    }

    private Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;

        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }

    // For testing locally in VS Code
    public static void main(String[] args) {
        // Example: 1 - 2 - 3
        //              |
        //              4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.child = new Node(4);

        FlattenMultilevelDoublyLinkedList f = new FlattenMultilevelDoublyLinkedList();
        Node flat = f.flatten(head);

        // Print result
        Node curr = flat;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        // Expected output: 1 2 4 3
    }
}
