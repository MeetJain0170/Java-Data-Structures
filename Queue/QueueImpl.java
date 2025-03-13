// Assuming ListNode is already defined elsewhere or should be defined here
class ListNode {
    int val;
    ListNode next;
    
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class QueueImpl {
    ListNode front, rear;

    // Constructor to initialize the queue
    public QueueImpl() {
        front = rear = null;
    }

    // Enqueue operation
    public void enqueue(int val) {
        ListNode newNode = new ListNode(val);
        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue operation
    public int dequeue() {
        if (front == null) {
            return -1;  // Return -1 to indicate an empty queue
        }
        int data = front.val;
        front = front.next;

        if (front == null) {
            rear = null;  // Reset rear if queue becomes empty
        }

        return data;
    }

    // Peek operation
    public int peek() {
        if (front == null) {
            return -1;  // Return -1 to indicate an empty queue
        }
        return front.val;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Display all elements of the queue
    public void display() {
        ListNode curr = front;
        while (curr != null) {
            System.out.print(curr.val + " ");  // Use string concatenation instead of character
            curr = curr.next;
        }
        System.out.println();  // New line after printing queue
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        queue.display();
    }
}
