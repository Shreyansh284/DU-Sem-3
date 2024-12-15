
// * lab - 10
import java.util.Scanner;

/**
 * Node
 */
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// * Circular List
class CircularLinkedList {
    Node last;

    CircularLinkedList() {
        this.last = null;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (last == null) {
            last = newNode;
            last.next = last;
        } else {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        }
    }

    void printList() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = last.next;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println();
    }

    int countNodes() {
        if (last == null) {
            return 0;
        }

        Node temp = last.next;
        int count = 0;

        do {
            count++;
            temp = temp.next;
        } while (temp != last.next);

        return count;
    }
}

public class LinkedList {
    Node first; // head of list

    public void insertAtStart(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            return;
        } else {
            newNode.next = first;
            first = newNode;
            return;
        }
    }

    public void insertAtEnd(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            return;
        } else {
            Node Save = first;
            while (Save.next != null) {
                Save = Save.next;
            }
            Save.next = newNode;
        }
        return;
    }

    public void insord(int x) {
        Node newNode = new Node(x);
        if (first == null || x <= first.data) {
            newNode.next = first;
            first = newNode;
            return;
        } else {
            Node Save = first;
            while ((Save.next != null) && (Save.next.data < x)) {
                Save = Save.next;
            }
            newNode.next = Save.next;
            Save.next = newNode;
        }
        return;
    }

    public void deleteAnyNode(int data) {
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

    public void printList() {
        Node currNode = first;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        return;
    }

    public void countNodes() {
        Node currNode = first;
        int noOfNodes = 0;
        if (currNode == null) {
            System.out.println("No. Of Nodes : " + noOfNodes);
            return;
        } else {
            while (currNode.next != null) {
                noOfNodes++;
                currNode = currNode.next;
            }
            System.out.println("No. Of Nodes : " + (noOfNodes + 1));
            return;
        }
    }

    static public boolean isListSameOrNot(LinkedList list1, LinkedList list2) {
        Node list1_first = list1.first;
        Node list2_first = list2.first;
        while (list1_first != null && list2_first != null) {
            if (list1_first.data != list2_first.data) {
                return false;
            }
            list1_first = list1_first.next;
            list2_first = list2_first.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // * Singly Linked List
        // LinkedList list = new LinkedList();
        // int number;
        // Scanner sc = new Scanner(System.in);
        // do {
        // System.out.println("Enter 1 to Insert Node At First : ");
        // System.out.println("Enter 2 to Insert Node At End: ");
        // System.out.println("Enter 3 to Insert Node At Any Position : ");
        // System.out.println("Enter 4 to Delete Node From Any Position");
        // System.out.println("Enter 5 to Print the list.");
        // System.out.println("Enter 6 to Exit");

        // number = sc.nextInt();

        // switch (number) {
        // case 1:
        // System.out.println("Enter Info :");
        // int dataStart = sc.nextInt();
        // list.insertAtStart(dataStart);
        // list.printList();
        // break;

        // case 2:
        // System.out.println("Enter Info :");
        // int dataEnd = sc.nextInt();
        // list.insertAtEnd(dataEnd);
        // list.printList();
        // break;

        // case 3:
        // System.out.println("Enter Info :");
        // int dataPos = sc.nextInt();
        // list.insord(dataPos);
        // list.printList();
        // break;

        // case 4:
        // System.out.println("Enter Value By which You Want to Delete Node :");
        // int dataDel = sc.nextInt();
        // list.deleteAnyNode(dataDel);
        // list.printList();
        // break;

        // case 5:
        // list.printList();
        // list.countNodes();
        // break;

        // case 6:
        // System.out.println("Exiting...");
        // sc.close();
        // break;

        // default:
        // System.out.println("Invalid Number Entered -- Please Enter Between 1 to 6");
        // break;
        // }
        // } while (number != 6);
        // sc.close();
        // * is same or not
        LinkedList list1 = new LinkedList();
        list1.insertAtStart(5);
        list1.insertAtStart(10);
        LinkedList list2 = new LinkedList();
        list2.insertAtStart(5);
        list2.insertAtStart(10);
        System.out.println(isListSameOrNot(list1, list2));
        // * Circularly Linked List
        // CircularLinkedList list = new CircularLinkedList();
        // list.insertAtEnd(2);
        // list.insertAtEnd(24);
        // list.insertAtEnd(245);
        // list.insertAtEnd(2455);
        // int count = list.countNodes();
        // list.printList();
        // System.out.println(count);
    }
}