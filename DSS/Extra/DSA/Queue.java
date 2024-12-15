
// * lab - 9
import java.security.Principal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * SimpleQueue
 */
class SimpleQueue {
    int[] Queue;
    int front, rear, MAX;

    SimpleQueue(int MAX) {
        front = 0;
        rear = -1;
        this.MAX = MAX;
        Queue = new int[MAX];
    }

    public void enqueue(int x) {
        if (rear == MAX - 1) {
            System.out.println("Queue is full");
            return;
        } else {
            rear++;
            Queue[rear] = x;
        }
    }

    public void dequeue() {
        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        } else {
            for (int i = 0; i < rear; i++) {
                Queue[i] = Queue[i + 1];
            }
            rear--;
        }
    }

    public void display() {
        if (front > rear) {
            System.out.println("Queue is Empty");
            return;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(Queue[i] + " <-- ");
        }
        System.out.println();
    }
}

/**
 * CircularQueue
 */
class CircularQueue {
    int[] CircularQueue;
    int MAX, front, rear;

    CircularQueue(int MAX) {
        front = -1;
        rear = -1;
        this.MAX = MAX;
        CircularQueue = new int[MAX];
    }

    public void insert(int x) {
        if ((rear + 1) % MAX == front) {
            System.out.println("Queue is Full (Overflow)");
            return;
        }

        if (front == -1) {
            front = 0;
        }
        // rear++;
        // if (rear == MAX) {
        // rear = 0;
        // }
        rear = (rear + 1) % MAX; // * DOUBT
        CircularQueue[rear] = x;
        System.out.println(x + " inserted into queue");
    }

    public void delete() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        int x = CircularQueue[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            // front++;
            // if (front == MAX) {
            // front = 0;
            // }
            front = (front + 1) % MAX; // * DOUBT
        }

        System.out.println("Deleted : " + x);
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.print("Queue: ");
        if (rear >= front) {
            for (int i = front; i <= rear; i++) {
                System.out.print(CircularQueue[i] + " ");
            }
        } else {
            for (int i = front; i < MAX; i++) {
                System.out.print(CircularQueue[i] + " ");
            }
            for (int i = 0; i <= rear; i++) {
                System.out.print(CircularQueue[i] + " ");
            }
        }
        System.out.println();
    }
}

/**
 * DoubleEndedQueue
 */
class DoubleEndedQueue {
    int[] doubleEndedQueue;
    int MAX, front, rear;

    public DoubleEndedQueue(int MAX) {
        front = rear = 0;
        this.MAX = MAX;
        doubleEndedQueue = new int[MAX];
    }

    public void insertAtFrontEnd(int x) {
        if ((front == 0 && rear == MAX - 1) || (front == rear + 1)) {
            System.out.println("Queue is Full (Overflow)");
            return;
        } else if (front == -1 && rear == -1) {
            front = rear = 0;
            doubleEndedQueue[front] = x;
        } else if (front == 0) {
            front = MAX - 1;
            doubleEndedQueue[front] = x;
        } else {
            front -= 1;
            doubleEndedQueue[front] = x;
        }
    }

    public void insertAtRearEnd(int x) {
        if ((front == 0 && rear == MAX - 1) || (front == rear + 1)) {
            System.out.println("Queue is Full (Overflow)");
            return;
        } else if (front == -1 && rear == -1) {
            rear = 0;
            doubleEndedQueue[rear] = x;
        } else if (rear == MAX - 1) {
            rear = 0;
            doubleEndedQueue[rear] = x;
        } else {
            rear++;
            doubleEndedQueue[rear] = x;
        }
    }

    public void deleteFromFrontEnd() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is Empty.");
            return;
        } else if (front == rear) {
            System.out.println("\nThe deleted element is " + doubleEndedQueue[front]);
            front = -1;
            rear = -1;
        } else if (front == (MAX - 1)) {
            System.out.println("\nThe deleted element is " + doubleEndedQueue[front]);
            front = 0;
        } else {
            System.out.println("\nThe deleted element is " + doubleEndedQueue[front]);
            front++;
        }
    }

    public void deleteFromRearEnd() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is Empty.");
            return;
        } else if (front == rear) {
            System.out.println("\nThe deleted element is " + doubleEndedQueue[rear]);
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            System.out.println("\nThe deleted element is " + doubleEndedQueue[rear]);
            rear = MAX - 1;
        } else {
            System.out.println("\nThe deleted element is " + doubleEndedQueue[rear]);
            rear--;
        }
    }

    public void display() {
        int i = front;
        System.out.println("\nElements in a deque are: ");

        while (i != rear) {
            System.out.println(doubleEndedQueue[i]);
            i = (i + 1) % MAX;
        }
        System.out.println(doubleEndedQueue[rear]);
    }
}

/**
 * PriorityQueue
 */
class PriorityQueue {
    /**
     * Pair
     */
    // * Doubt : do with this or array
    // public class Pair {
    // int val;
    // int priority;

    // public Pair(int val, int priority) {
    // this.val = val;
    // this.priority = priority;
    // }
    // }

    int MAX, size;
    int[] priorityQueue;

    public PriorityQueue(int MAX) {
        this.MAX = MAX;
        priorityQueue = new int[MAX];
        size = 0;
    }

    public void insert(int x) {
        if (size == MAX) {
            System.out.println("Priority Queue Overflow");
            return;
        }
        // priorityQueue[priorityQueue.length - 1] = x;
        // System.out.println("Adding: " + x);
        // for (int i = 0; i < priorityQueue.length; i++) {
        // if (priorityQueue[i] >= priorityQueue[i + 1]) {
        // int temp = priorityQueue[i];
        // priorityQueue[i] = priorityQueue[i + 1];
        // priorityQueue[i + 1] = temp;
        // }
        // }
        // System.out.println("Added: " + x);
        int i;
        for (i = size - 1; i >= 0; i--) {
            if (x > priorityQueue[i]) {
                priorityQueue[i + 1] = priorityQueue[i];
            } else {
                break;
            }
        }

        priorityQueue[i + 1] = x;
        size++;
        System.out.println("Inserted: " + x);
    }

    public void delete() {
        if (size == 0) {
            System.out.println("Priority Queue Underflow");
            return;
        }

        int deletedValue = priorityQueue[0];
        for (int i = 0; i < size - 1; i++) {
            priorityQueue[i] = priorityQueue[i + 1];
        }
        size--;
        System.out.println("Deleted: " + deletedValue);
    }

    public void display() {
        if (size == 0) {
            System.out.println("Priority Queue is Empty");
            return;
        }

        System.out.println("Priority Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(priorityQueue[i] + " ");
        }
        System.out.println();
    }
}

public class Queue {

    private static String fetchBottomFeather(Stack<String> stack) {
        Stack<String> tempStack = new Stack<>();
        while (stack.size() > 1) {
            tempStack.push(stack.pop());
        }
        String bottomFeather = stack.pop();

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return bottomFeather;
    }

    public static void percyThePeacock(Scanner sc) {
        Stack<String> suitcase = new Stack<>();
        // Input queries
        System.out.println("Enter the queries (separated by commas): ");

        String[] queries = sc.nextLine().split(", ");

        for (String query : queries) {
            if (query.startsWith("buy_")) {
                String color = query.split("_")[1];
                suitcase.push(color);
            } else if (query.equals("fetch")) {
                if (!suitcase.isEmpty()) {
                    String bottomFeather = fetchBottomFeather(suitcase);
                    suitcase.push(bottomFeather);
                    System.out.println("Fetched feather: " + bottomFeather);
                } else {
                    System.out.println("No feathers to fetch!");
                }
            }
        }
    }

    public static void main(String[] args) {
        // * Simple Queue
        // SimpleQueue queue = new SimpleQueue(4);
        // int number;
        // Scanner sc = new Scanner(System.in);
        // do {
        // System.out.println("Enter 1 to Enqueue");
        // System.out.println("Enter 2 to Dequeue");
        // System.out.println("Enter 3 to Display");
        // System.out.println("Enter 4 to Exit");
        // number = sc.nextInt();

        // switch (number) {
        // case 1:
        // System.out.println("Enter Info :");
        // int dataStart = sc.nextInt();
        // queue.enqueue(dataStart);
        // break;

        // case 2:
        // queue.dequeue();
        // break;

        // case 3:
        // queue.display();
        // break;

        // case 4:
        // System.out.println("Thank You");
        // break;

        // default:
        // System.out.println("Invalid Number Entered -- Please Enter Between 1 to 4");
        // break;
        // }
        // } while (number != 4);
        // sc.close();
        // * Circular Queue
        // CircularQueue queue = new CircularQueue(4);
        // queue.insert(10);
        // queue.insert(20);
        // queue.insert(30);
        // queue.insert(40);
        // queue.insert(50);

        // queue.display();

        // queue.delete();
        // queue.delete();

        // queue.insert(60);
        // queue.insert(70); // * DOUBT */ This should be inserted at the wrapped-around
        // * positions

        // queue.display();
        // int number;
        // Scanner sc = new Scanner(System.in);
        // do {
        // System.out.println("Enter 1 to Enqueue");
        // System.out.println("Enter 2 to Dequeue");
        // System.out.println("Enter 3 to Display");
        // System.out.println("Enter 4 to Exit");
        // number = sc.nextInt();

        // switch (number) {
        // case 1:
        // System.out.println("Enter Info :");
        // int dataStart = sc.nextInt();
        // queue.insert(dataStart);
        // break;

        // case 2:
        // queue.delete();
        // break;

        // case 3:
        // queue.display();
        // break;

        // case 4:
        // System.out.println("Thank You");
        // break;

        // default:
        // System.out.println("Invalid Number Entered -- Please Enter Between 1 to 4");
        // break;
        // }
        // } while (number != 4);
        // sc.close();
        // * DoubleEnded Queue
        // DoubleEndedQueue queue = new DoubleEndedQueue(4);
        // int number;
        // Scanner sc = new Scanner(System.in);
        // do {
        // System.out.println("Enter 1 to Insert At Front End");
        // System.out.println("Enter 2 to Insert At Rear End");
        // System.out.println("Enter 3 to Delete from Front End");
        // System.out.println("Enter 4 to Delete from Rear End");
        // System.out.println("Enter 5 to Display");
        // System.out.println("Enter 6 to Exit");
        // number = sc.nextInt();

        // switch (number) {
        // case 1:
        // System.out.println("Enter Info :");
        // int dataStart = sc.nextInt();
        // queue.insertAtFrontEnd(dataStart);
        // break;

        // case 2:
        // System.out.println("Enter Info :");
        // int dataRear = sc.nextInt();
        // queue.insertAtRearEnd(dataRear);
        // break;

        // case 3:
        // queue.deleteFromFrontEnd();
        // break;

        // case 4:
        // queue.deleteFromRearEnd();
        // break;

        // case 5:
        // queue.display();
        // break;

        // case 6:
        // System.out.println("Thank You");
        // break;

        // default:
        // System.out.println("Invalid Number Entered -- Please Enter Between 1 to 6");
        // break;
        // }
        // } while (number != 6);
        // sc.close();
        // * Priority Queue
        // PriorityQueue priorityQueue = new PriorityQueue(5);
        // priorityQueue.insert(5);
        // priorityQueue.insert(15);
        // priorityQueue.insert(3);
        // priorityQueue.insert(45);
        // // priorityQueue.delete();
        // priorityQueue.display();
        // priorityQueue.insert(30);
        // priorityQueue.insert(20);
        // priorityQueue.insert(40);
        // priorityQueue.insert(10);
        // priorityQueue.insert(50);

        // priorityQueue.display();

        // priorityQueue.delete();
        // priorityQueue.display();
        // * Percy the peacock
        Scanner sc = new Scanner(System.in);
        percyThePeacock(sc);
        sc.close();
    }
}
