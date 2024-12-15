import java.util.HashSet;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class StackUsingLinkedList {
    private Node top; // The top of the stack

    // Constructor to initialize an empty stack
    public StackUsingLinkedList() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        System.out.println("Pushed " + data + " onto the stack.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow! No elements to pop.");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        System.out.println("Popped " + poppedData + " from the stack.");
        return poppedData;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! No elements to peek.");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        Node current = top;
        System.out.print("Stack elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class QueueUsingLinkedList {
    private Node front, rear;

    public QueueUsingLinkedList() {
        this.front = this.rear = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);

        if (this.rear == null) {
            this.front = this.rear = newNode;
            System.out.println("Enqueued " + data + " to the queue.");
            return;
        }

        this.rear.next = newNode;
        this.rear = newNode;
        System.out.println("Enqueued " + data + " to the queue.");
    }

    public int dequeue() {
        if (this.front == null) {
            System.out.println("Queue underflow! No elements to dequeue.");
            return -1;
        }

        int dequeuedData = this.front.data;
        this.front = this.front.next;

        // If the front becomes null, then change rear to null as well (queue is empty)
        if (this.front == null) {
            this.rear = null;
        }

        System.out.println("Dequeued " + dequeuedData + " from the queue.");
        return dequeuedData;
    }

    public int peek() {
        if (this.front == null) {
            System.out.println("Queue is empty! No elements to peek.");
            return -1;
        }
        return this.front.data;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        Node current = front;
        System.out.print("Queue elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class SinglyLinkedList {
    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        Node current = head;
        Node previous = null;

        while (current != null) {
            // If the element is already in the set, it's a duplicate
            if (set.contains(current.data)) {
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            current = current.next;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

public class LAB11 {
    public static void main(String[] args) {
        // SinglyLinkedList list = new SinglyLinkedList();
        // list.add(10);
        // list.add(20);
        // list.add(30);
        // list.add(20);
        // list.add(40);
        // list.add(50);
        // list.add(10);

        // System.out.println("Original List:");
        // list.printList();

        // list.removeDuplicates();

        // System.out.println("List after removing duplicates:");
        // list.printList();
        // StackUsingLinkedList stack = new StackUsingLinkedList();

        // stack.push(10);
        // stack.push(20);
        // stack.push(30);

        // stack.printStack();

        // System.out.println("Top element is " + stack.peek());

        // stack.pop();
        // stack.printStack();

        // System.out.println("Top element is " + stack.peek());

        // stack.pop();
        // stack.pop();
        // stack.pop();
        // QueueUsingLinkedList queue = new QueueUsingLinkedList();

        // queue.enqueue(10);
        // queue.enqueue(20);
        // queue.enqueue(30);

        // queue.printQueue();

        // System.out.println("Front element is " + queue.peek());

        // queue.dequeue();
        // queue.printQueue();

        // System.out.println("Front element is " + queue.peek());

        // queue.dequeue();
        // queue.dequeue();
        // queue.dequeue();
    }
}
