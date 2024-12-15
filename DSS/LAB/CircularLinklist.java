import java.util.Scanner;

/**
 * CircularLinklist
 */
public class CircularLinklist {
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

    public static void main(String[] args) {
        CircularLinklist circularLinklist = new CircularLinklist();

        circularLinklist.insertAtStartInCircularLinklist(1);
        circularLinklist.insertAtStartInCircularLinklist(7);
        circularLinklist.insertAtStartInCircularLinklist(7);
        circularLinklist.insertAtStartInCircularLinklist(4);
        circularLinklist.insertAtStartInCircularLinklist(5);
        circularLinklist.insertAtStartInCircularLinklist(5);
        circularLinklist.printCircularList();
        circularLinklist.splitlist(circularLinklist);
        // while (true) {

        // int number;
        // Scanner sc = new Scanner(System.in);
        // // System.out.print();
        // System.out.println("Enter 1 to Insert Node At First : ");
        // System.out.println("Enter 2 to Insert Node At End: ");
        // System.out.println("Enter 3 to Delete First Node ");
        // System.out.println("Enter 4 to Delete Last Node ");
        // System.out.println("Enter 5 to Delete Node From Any Position ");
        // System.out.println("Enter 6 to Count Nodes of list");
        // System.out.println("Enter 7 to Display Nodes of list");
        // System.out.println("Enter 8 to Exit");
        // number = sc.nextInt();

        // if (number == 1) {
        // int data ;
        // System.out.println("Enter Info :");
        // data = sc.nextInt();
        // circularLinklist.insertAtStartInCircularLinklist(data);
        // circularLinklist.printCircularList();

        // } else if (number == 2) {
        // int data;
        // System.out.println("Enter Info :");
        // data = sc.nextInt();
        // circularLinklist.insertAtEndInCircularLinklist(data);
        // circularLinklist.printCircularList();
        // }
        // else if (number == 3) {

        // circularLinklist.deleteAtStartInCircularLinklist();
        // circularLinklist.printCircularList();
        // }
        // else if (number == 4) {
        // circularLinklist.deleteAtEndInCircularLinklist();
        // circularLinklist.printCircularList();
        // }
        // else if(number==5)
        // {
        // int data;
        // System.out.println("Enter Position To Delete:");
        // data=sc.nextInt();
        // circularLinklist.deleteAnyNodeByIndexInCircularLinkedList(data);
        // }

        // else if(number == 6)
        // {
        // circularLinklist.countNodesOfCircularList();
        // }
        // else if(number == 7)
        // {
        // circularLinklist.printCircularList();
        // }

        // else if (number == 8) {
        // return;
        // } else {
        // System.out.println("Invalid Number Entered -- Plzz Enter Between 1 to 8");
        // }

        // }
    }

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

        System.out.println("Element Deleted");

    }

    public int countNodesOfCircularList() {
        if (last == null) {
            System.out.println("List is empty.");
            return 0;
        }
        int count = 0;
        Node temp = first;
        do {
            temp = temp.next;
            count++;
        } while (temp != last.next);
        System.out.println("Number of Nodes : " + count);
        return count;
    }

    public void splitlist(CircularLinklist list) {
        CircularLinklist list1 = new CircularLinklist();
        CircularLinklist list2 = new CircularLinklist();
        int count = list.countNodesOfCircularList();
        int mid = count / 2;
        int i = 0;

        Node save = first;

        while (i != mid) {
            list1.insertAtEndInCircularLinklist(save.data);
            save = save.next;
            i++;
        }

        Node newSave = save;

        Node s = newSave;

        while (mid != count) {
            list2.insertAtEndInCircularLinklist(newSave.data);
            newSave = newSave.next;
            mid++;
        }
            save.next = first;
            newSave.next = s;
            
        list1.printCircularList();
        list2.printCircularList();

    }

    public void printCircularList() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = first;
        System.out.println("Circular List : ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println();
    }

}