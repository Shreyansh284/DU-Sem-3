import java.util.Scanner;

public class DoublyLinklist {

    Node head;
    Node tail;

    static class Node {
        int data;
        Node lptr;
        Node rptr;

        Node(int data) {
            this.data = data;
            this.lptr = null;
            this.rptr = null;
        }
    }

    

    public DoublyLinklist() {
        this.head = null;
        this.tail = null;
    }

    public static void main(String[] args) {
        DoublyLinklist doublyLinklist = new DoublyLinklist();
        // doublyLinklist.insertAtStartInDoublyLinklist(0);
        doublyLinklist.insertAtStartInDoublyLinklist(98);
        doublyLinklist.insertAtStartInDoublyLinklist(56);
        doublyLinklist.insertAtStartInDoublyLinklist(98);
        doublyLinklist.insertAtStartInDoublyLinklist(1);
        // doublyLinklist.insertAtStartInDoublyLinklist(2);
        // doublyLinklist.insertAtStartInDoublyLinklist(3);
        doublyLinklist.displayDoublyLinklist();
        doublyLinklist.deleteAlterativeNode();
        doublyLinklist.displayDoublyLinklist();

        // while (true) {

        // int number;
        // Scanner sc = new Scanner(System.in);
        // // System.out.print();
        // System.out.println("Enter 1 to Insert Node At First : ");
        // System.out.println("Enter 2 to Insert Node At End: ");
        // System.out.println("Enter 3 to Insert Node At Any Poistion: ");
        // System.out.println("Enter 4 to Delete First Node ");
        // System.out.println("Enter 5 to Delete Last Node ");
        // System.out.println("Enter 6 to Delete Node From Any Position ");
        // System.out.println("Enter 7 to Count Nodes of list");
        // System.out.println("Enter 8 to Display Nodes of list");
        // System.out.println("Enter 9 to Exit");
        // number = sc.nextInt();

        // if (number == 1) {
        // int data ;
        // System.out.println("Enter Info :");
        // data = sc.nextInt();
        // doublyLinklist.insertAtStartInDoublyLinklist(data);
        // doublyLinklist.displayDoublyLinklist();

        // } else if (number == 2) {
        // int data;
        // System.out.println("Enter Info :");
        // data = sc.nextInt();
        // doublyLinklist.insertAtEndInDoublyLinklist(data);
        // doublyLinklist.displayDoublyLinklist();
        // }
        // else if (number==3)
        // {
        // int data,postion;
        // System.out.println("Enter Poistion :");
        // postion = sc.nextInt();
        // System.out.println("Enter Info :");
        // data = sc.nextInt();
        // doublyLinklist.insertNodeAtGivenPosition(postion,data);
        // doublyLinklist.displayDoublyLinklist();
        // }
        // else if (number == 4) {

        // doublyLinklist.deleteAtStartInDoublyLinkedList();
        // doublyLinklist.displayDoublyLinklist();
        // }
        // else if (number == 5) {
        // doublyLinklist.deleteAtEndInDoublyLinkedList();
        // doublyLinklist.displayDoublyLinklist();
        // }
        // else if(number==6)
        // {
        // int data;
        // System.out.println("Enter Position To Delete:");
        // data=sc.nextInt();
        // doublyLinklist.deleteAnyNodeByIndexInDoublyLinkedList(data);
        // }

        // else if(number == 7)
        // {
        // doublyLinklist.countNodesOfDoublyList();
        // }
        // else if(number == 8)
        // {
        // doublyLinklist.displayDoublyLinklist();
        // }

        // else if (number == 9) {
        // return;
        // } else {
        // System.out.println("Invalid Number Entered -- Plzz Enter Between 1 to 9");
        // }

        // }
    }

    public void insertAtStartInDoublyLinklist(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.rptr = head;
            head.lptr = newNode;
            head = newNode;
        }
    }

    public void insertAtEndInDoublyLinklist(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.lptr = tail;
            tail.rptr = newNode;
            tail = newNode;
        }
    }

    public void insertInOrderedDoublyLinklist(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        } else if (head.data > data) {
            newNode.rptr = head;
            head.lptr = newNode;
            head = newNode;
        } else if (tail.data < data) {

            tail.rptr = newNode;
            newNode.lptr = tail;
            tail = newNode;
        }

        else {
            Node save = head;

            while (save.rptr.data < data) {
                save = save.rptr;
            }

            newNode.lptr = save;
            newNode.rptr = save.rptr;
            save.rptr.lptr = newNode;
            save.rptr = newNode;

        }
    }

    public void insertNodeAtGivenPosition(int postion, int data) {
        Node newNode = new Node(data);
        int count = 2;
        Node save = head;

        if (postion == 1) {
            if (head == null) {
                head = tail = newNode;
                return;
            } else {
                newNode.rptr = head;
                head.lptr = newNode;
                head = newNode;
            }
        }
        while (count != postion && save != tail) {
            save = save.rptr;
            count++;
        }
        if (count != postion) {
            System.out.println("InValid Position ");
            return;
        }

        if (save == tail) {
            newNode.lptr = tail;
            tail.rptr = newNode;
            tail = newNode;

        } else {
            newNode.lptr = save;
            newNode.rptr = save.rptr;
            save.rptr = newNode;
            newNode.rptr.lptr = newNode;
        }
    }

    public void deleteAtStartInDoublyLinkedList() {
        if (head == null) {
            System.out.println("List Is Empty");
            return;
        } else {
            head = head.rptr;
            head.lptr = null;
        }
    }

    public void deleteAtEndInDoublyLinkedList() {
        if (tail == null) {
            System.out.println("List Is Empty");
            return;
        } else {
            tail = tail.lptr;
            tail.rptr = null;
        }
    }

    public void deleteAnyNodeByIndexInDoublyLinkedList(int postion) {
        if (head == null) {
            System.out.println("List Is Empty");
            return;
        }

        Node save = head;
        Node pred = null;
        int count = 1;

        while (save != tail && count != postion) {
            pred = save;
            save = save.rptr;
            count++;
        }

        if (count != postion) {
            System.out.println("Invaild Position");
            return;
        }

        if (count == 1) {
            head = head.rptr;
            head.lptr = null;
        } else if (save == tail) {
            tail = tail.lptr;
            tail.rptr = null;
        } else {
            pred.rptr = save.rptr;
            save.rptr.lptr = pred;

        }
        System.out.println("Element Deleted");
    }

    public void displayDoublyLinklist() {
        // Node current will point to head
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.rptr;
        }
        System.out.println();
    }

    public void countNodesOfDoublyList() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        int count = 0;
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            current = current.rptr;
            count++;
        }
        System.out.println("Number of Nodes : " + count);

    }

    public void deleteAlterativeNode() {
        if (head == null) {
            System.out.println("Underflow");
            return;
        }
        Node save = head;
        Node prev = null;
        while (save != null && save.rptr != null) {
            prev = save;
            save = save.rptr;

            // delete alternative node 
            prev.rptr = save.rptr;

        }

            //  if single node left
        if (prev == null) {
            head = head.rptr;
        }

    }

    public void insertGCDofNodeBetweenAdjecentPairOfNode() {
        if (head == null) {
            System.out.println("Underflow");
            return;
        }
        Node save = head;
        Node prev = null;
        while (save != null && save.rptr != null) {
            prev = save;
            save = save.rptr;
            
            //  create newNode And Insert Between prev and next
            int newdata=gcd(prev.data, save.data);
            Node newnode=new Node(newdata);
            prev.rptr=newnode;
            newnode.lptr=prev;
            newnode.rptr=save;
            save.lptr=newnode;
        }
            //  if single node left
        if (prev == null) {
            System.out.println("Cannot Find Gcd Of Single Info");
        }

    }
    static int gcd(int a, int b)
    {
        // Everything divides 0
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // Base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a - b, b);
        return gcd(a, b - a);
    }

}
