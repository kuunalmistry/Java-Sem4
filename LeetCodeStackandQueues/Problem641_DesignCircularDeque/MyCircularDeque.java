package Problem641_DesignCircularDeque;

public class MyCircularDeque {
    private int[] deque;
    private int front, rear, size, capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + capacity) % capacity;
        deque[front] = value;
        size++;
        if (size == 1) rear = front; // first element
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        deque[rear] = value;
        size++;
        if (size == 1) front = rear; // first element
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : deque[front];
    }

    public int getRear() {
        return isEmpty() ? -1 : deque[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3);

        System.out.println(circularDeque.insertLast(1));  // true
        System.out.println(circularDeque.insertLast(2));  // true
        System.out.println(circularDeque.insertFront(3)); // true
        System.out.println(circularDeque.insertFront(4)); // false
        System.out.println(circularDeque.getRear());      // 2
        System.out.println(circularDeque.isFull());       // true
        System.out.println(circularDeque.deleteLast());   // true
        System.out.println(circularDeque.insertFront(4)); // true
        System.out.println(circularDeque.getFront());     // 4
    }
}
