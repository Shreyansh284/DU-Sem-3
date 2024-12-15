class SimpleQueue {

    int front = -1;
    int rear = -1;
    int size;
    int[] queue;

    SimpleQueue(int s) {
        size = s;
        queue = new int[size];
    }

    void enqueue(int data) {
        if (rear >= size - 1) {
            System.out.println("Queue is Full !");
            return;
        }
        rear++;
        queue[rear] = data;
        if (front == -1) {
            front++;
        }

    }

    int dequeue() {
        
        int element = queue[front];
        if(front==-1)
        {
            System.out.println("Queue is Empty !");
            return 0;
        }
        if (front==rear) {
            front = rear = -1;
        }
        else{
            front++;
        }
        return element;
    }

    void display() {

        if (front > rear) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = front ; i <= rear ; i++) {
            System.out.print(queue[i] + " <-- ");
        }

    }

}

class CircularQueue {
    int front = -1;
    int rear = -1;
    int size;
    int[] queue;

    CircularQueue(int s) {
        this.size = s;
        this.queue = new int[size];
    }

    void cEnqueue(int data) {
        if (rear == size - 1) {
            rear = 0;

        } else {
            rear += 1;
        }

        if (front == rear) {
            System.out.println("OverFlow");
            if (rear == 0) {
                rear = size - 1;
            } else {
                rear--;
            }
            return;
        }
        queue[rear] = data;

        if (front == -1) {
            front++;
            return;
        }

    }

int cDequeue()
{
    if(front==-1)
    {
        System.out.println("Underflow");
        return 0;
    }
    int element=queue[front];

    if(front==rear)
    {
        front=rear=-1;
        return element;
    }
    if(front==size-1)
    {
        front=0;
    }
    else
    {
        front++;
    }
    return element;
}

    void display() {

        //  Using i+1 % size 

        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = front; i != rear; i = (i + 1) % (size)) {
            System.out.print(queue[i] + " <-- ");
        }
        System.out.println(queue[rear] + " <-- ");

        // USE 2 LOOPS 
        // for(int i=front;i<=rear;i++)
        // {
        // System.out.print(queue[i] + " <-- ");
        // }
        // return;
        // }
        // else
        // {
        // for(int i=front;i<size;i++)
        // {
        // System.out.print(queue[i] + " <-- ");
        // }
        // for(int i=0;i<=rear;i++)
        // {
        // System.out.print(queue[i] + " <-- ");
        // }
        // }
    }
}



public class Queue {
    public static void main(String args[]) {
        SimpleQueue q= new SimpleQueue(4);
        q.enqueue(10);
        q.enqueue(10);
        q.enqueue(10);
        q.enqueue(10);
        // q.enqueue(10);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.display();

        // CircularQueue Cqueue = new CircularQueue(4);
        // Cqueue.cEnqueue(1);
        // Cqueue.cEnqueue(2);
        // Cqueue.cEnqueue(3);
        // Cqueue.cEnqueue(6);
        // Cqueue.cDequeue();
        // Cqueue.cDequeue();
        // Cqueue.cDequeue();
        // Cqueue.cEnqueue(6);
        // Cqueue.cEnqueue(7);
       
        // // Cqueue.cEnqueue(6);
        // Cqueue.display();
    }
}