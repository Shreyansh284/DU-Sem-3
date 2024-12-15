import java.util.*;

public class LinkedList {
    Node first; // head of list
    Node last = null;

    /**
     * Node
     */
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void insertAtStart(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            newNode.next = null;
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    public void insertAtEnd(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            newNode.next = null;
            first = newNode;
        } else {
            Node Save = first;
            while (Save.next != null) {
                Save = Save.next;
            }
            Save.next = newNode;
            newNode.next = null;
        }
    }

    public void insord(int x) {
        Node newNode = new Node(x);
        if (first == null || x <= first.data) {
            newNode.next = first;
            first = newNode;
        } else {
            Node Save = first;
            while ((Save.next != null) && (Save.next.data < x)) {
                Save = Save.next;
            }
            newNode.next = Save.next;
            Save.next = newNode;
        }
    }

    public void deleteAnyNodeByInfo(int data) {
        Node save = first;
        Node pred = null;

        while (save.data != data && save.next != null) {
            pred = save;
            save = save.next;
        }

        if (save.data != data) {
            System.out.println("Node not found");
            return;

        }

        if (first.data == data) {
            first = first.next;
        } else {
            pred.next = save.next;
        }

    }

    public void deleteAnyNodeByPositon(int data) {
        int count = 1;
        Node save = first;
        Node pred = null;

        while (count != data && save.next != null) {
            pred = save;
            save = save.next;
            count++;
        }

        if (count != data) {
            System.out.println("Node not found");
            return;

        }
        if (count == 1) {
            first = first.next;
        } else {

            pred.next = save.next;
        }

    }

    public void countNodesOfLinklist() {
        Node currNode = first;
        int count = 0;
        while (currNode != null) {
            currNode = currNode.next;
            count++;
        }
        System.out.print("Number Of Nodes : " + count);
    }

    public static void twoLinkListIsSameOrNot(LinkedList list1, LinkedList list2) {
        Node list1First = list1.first;
        Node list2First = list2.first;

        while (list1First != null && list2First != null) {
            if (list1First.data != list2First.data) {
                System.out.println("Lists Are Not Same");
                return;
            }

            list1First = list1First.next;
            list2First = list2First.next;
        }

        System.out.println("Lists Are Same");
    }

    public static void copyLinklist(LinkedList list1, LinkedList list2) {
        Node list1First = list1.first;

        if (list1First == null) {
            System.out.println("List is Empty");
            return;
        }

        while (list1First != null) {

            list2.insertAtEnd(list1First.data);
            list1First = list1First.next;

        }
        System.out.println("Original List");
        list1.printList();
        System.out.println("Copyed List");
        list2.printList();

    }

    public static void sortLinklist(LinkedList list) {
        Node save;
        boolean swapped;


        do {
            swapped=false;
            save=list.first;
            while (save != null ) {

                if (save.next != null && save.data > save.next.data ) {
                    int temp=save.data;
                    save.data = save.next.data;
                    save.next.data = temp;
                    swapped=true;
                }
                save = save.next;
            }
      
        } while (swapped);

       list.printList();

    }

    public void printList() {
        Node currNode = first;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("");
    }

    // ---------------------- ------------------- CIRCULAR LINKEDLIST
    // --------------------------------------------------------------

    public void insertAtStartInCircularLinklist(int x) {
        Node newNode = new Node(x);

        if (first == null) {
            newNode.next = first;
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            last.next = newNode;
            first = newNode;

        }

    }

    public void insertAtEndInCircularLinklist(int x) {
        Node newNode = new Node(x);

        if (first == null) {
            newNode.next = first;
            first = last = newNode;
        } else {
            newNode.next = first;
            last.next = newNode;
            last = newNode;

        }

    }

    public void insertInOrderedCircularLinklist(int data) {
        Node newNode = new Node(data);

        if (first == null) {
            newNode.next = first;
            first = newNode;
            last = newNode;
            return;
        }

        else if (first.data > data) {
            newNode.next = first;
            last.next = newNode;
            first = newNode;
            return;
        } else {
            Node save = first;

            while (save.next.data < data && save != last) {

                save = save.next;
            }
            newNode.next = save.next;
            save.next = newNode;

            if (save == last) {
                last = newNode;
            }
        }

    }

    public void deleteAtStartInCircularLinklist() {
        if (first == last) {
            first = last = null;
        } else {
            first = first.next;
            last.next = first;
        }
    }

    public void deleteAtEndInCircularLinklist() {
        if (first == last) {
            first = last = null;
        } else {
            Node save = first;
            Node pred = null;

            while (save != last) {
                pred = save;
                save = save.next;
            }
            pred.next = first;
            last = pred;

        }
    }

    public void deleteAnyNodeByInfoInCircularLinkedList(int data) {
        if (first == null) {
            System.out.println("Linklist Is Empty !!");
            return;
        }

        Node save = first;
        Node pred = null;

        while (save != last && save.data != data) {
            pred = save;
            save = save.next;
        }

        if (save.data != data) {
            System.out.println("Data Not Found");
            return;
        }

        if (first == last) {
            first = last = null;
        } else if (first.data == data) {
            first = first.next;
            last.next = first;
        } else {
            pred.next = save.next;

            if (last.data == data) {
                last = pred;
            }
        }

    }

    public void deleteAnyNodeByIndexInCircularLinkedList(int data) {
        int count = 1;

        if (first == null) {
            System.out.println("Linklist Is Empty !!");
            return;
        }

        Node save = first;
        Node pred = null;

        while (save != last && count != data) {
            pred = save;
            save = save.next;
            count++;
        }

        if (count != data) {
            System.out.println("Data Not Found");
            return;
        }

        if (first == last) {
            first = last = null;
        } else if (count == 1) {
            first = first.next;
            last.next = first;
        } else {
            pred.next = save.next;

            if (last == save) {
                last = pred;
            }
        }

    }

    public void countNodesOfCircularList() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }
        int count = 0;
        Node temp = first;
        do {
            temp = temp.next;
            count++;
        } while (temp != last.next);
        System.out.println("Number of Nodes : " + count);
    }

    public void printCircularList() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = first;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println();
    }

    // ----------------------------- ----------- END OF CIRULAR LIST
    // -------------------------------------

    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        DoubleLinklist doublyLinkedList = new DoubleLinklist();

        // while (true) {

        // int number;
        // Scanner sc = new Scanner(System.in);
        // // System.out.print();
        // System.out.println("Enter 1 to Insert Node At First : ");
        // System.out.println("Enter 2 to Insert Node At End: ");
        // // System.out.println("Enter 3 to Insert Node At Any Position : ");
        // System.out.println("Enter 3 to Delete Node By Its Value(INFO) ");
        // System.out.println("Enter 4 to Delete Node From Any Position ");
        // System.out.println("Enter 5 to Exit");
        // number = sc.nextInt();

        // if (number == 1) {
        // int data ;
        // System.out.println("Enter Info :");
        // data = sc.nextInt();
        // list.insertAtStart(data);
        // list.printList();

        // } else if (number == 2) {
        // int data;
        // System.out.println("Enter Info :");
        // data = sc.nextInt();
        // list.insertAtEnd(data);
        // list.printList();
        // }
        // // else if (number == 3) {
        // // int data;
        // // System.out.println("Enter Position At which You Want to Insert :");
        // // data = sc.nextInt();
        // // list.insord(data);
        // // list.printList();}
        // else if (number == 3) {
        // int data;
        // System.out.println("Enter Value By which You Want to Delete Node :");
        // data = sc.nextInt();
        // list.deleteAnyNodeByInfo(data);
        // list.printList();
        // }
        // else if (number == 4) {
        // int data;
        // System.out.println("Enter Postion At which You Want to Delete Node :");
        // data = sc.nextInt();
        // list.deleteAnyNodeByPositon(data);
        // list.printList();
        // } else if (number == 5) {
        // return;
        // } else {
        // System.out.println("Invalid Number Entered -- Plzz Enter Between 1 to 5");
        // }

        // }

        // --------------------- LIST SAME OR NOT
        // ----------------------------------------

        // LinkedList list1 =new LinkedList();
        // LinkedList list2 =new LinkedList();

        // list 1

        // list1.insertAtStart(10);
        // list1.insertAtStart(11);

        // list 2

        // list2.insertAtStart(10);
        // list2.insertAtStart(1);

        // twoLinkListIsSameOrNot(list1,list2);

        // --------------------- End Of LIST SAME OR NOT
        // ----------------------------------------

        // --------------------- COPY LIST ----------------------------------------

        // LinkedList list1 =new LinkedList();
        // LinkedList list2 =new LinkedList();

        // list1.insertAtStart(10);
        // list1.insertAtEnd(12);
        // list1.insertAtStart(11);

        // copyLinklist(list1,list2);

        // --------------------- End Of COPY LIST ---------------------------

        // ------------------- SORT LINKLIST----------------------------------------

        LinkedList list1 = new LinkedList();

        list1.insertAtStart(10);
        list1.insertAtStart(20);
        list1.insertAtStart(60);
        list1.insertAtStart(50);
        list1.insertAtStart(40);

        System.out.println("Original List : ");
        list1.printList();
        System.out.println("Sorted List : ");
        sortLinklist(list1);

        // ------------------- END OF SORT
        // LINKLIST----------------------------------------

        // ------------- CIRCULAR LINKED LIST INISALIZATION ----------------

        // list.insertAtEndInCircularLinklist(30);
        // list.insertAtStartInCircularLinklist(20);
        // list.insertAtStartInCircularLinklist(10);
        // list.insertAtEndInCircularLinklist(50);
        // list.insertInOrderedCircularLinklist(10);
        // list.insertAtStartInCircularLinklist(60);
        // list.deleteAnyNodeByIndexInCircularLinkedList(6);
        // list.deleteAnyNodeByInfoInCircularLinkedList(30);
        // list.deleteAtStartInCircularLinklist();
        // list.deleteAtEndInCircularLinklist();
        // list.printCircularList();
        // list.countNodesOfCircularList();
        // list.countNodesOfLinklist();

        // ------------- Doubly LINKED LIST INISALIZATION ----------------

        // doublyLinkedList.insertAtStartInDoublyLinklist(30);
        // doublyLinkedList.insertAtStartInDoublyLinklist(20);
        // doublyLinkedList.insertAtStartInDoublyLinklist(10);
        // doublyLinkedList.insertAtEndInDoublyLinklist(40);
        // doublyLinkedList.insertInOrderedDoublyLinklist(1);
        // doublyLinkedList.insertInOrderedDoublyLinklist(21);
        // doublyLinkedList.insertInOrderedDoublyLinklist(31);
        // doublyLinkedList.insertInOrderedDoublyLinklist(11);
        // doublyLinkedList.deleteAtStartInDoublyLinkedList();
        // doublyLinkedList.deleteAtEndInDoublyLinkedList();
        // doublyLinkedList.deleteAnyNodeByIndexInDoublyLinkedList(3);
        // doublyLinkedList.displayDoublyLinklist();

    }

}

class DoubleLinklist {

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

    public DoubleLinklist() {
        this.head = null;
        this.tail = null;
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
            // Prints each node by incrementing the pointer.

            System.out.print(current.data + " ");
            current = current.rptr;
        }
    }

}
