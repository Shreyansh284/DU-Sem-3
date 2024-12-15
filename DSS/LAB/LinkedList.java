import java.util.*;

public class LinkedList {
    Node first; // head of list

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
            first = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    public void insertAtEnd(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
        } else {
            Node Save = first;
            while (Save.next != null) {
                Save = Save.next;
            }
            Save.next = newNode;
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
        System.out.println("Number Of Nodes : " + count);
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

    public void printList() {
        Node currNode = first;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println("");
    }

    // lab 11 -------- 62

    // lab 12 -------- 63,64,65

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

    public static void reverseLinklist(LinkedList list1, LinkedList list2) {
        Node list1First = list1.first;

        if (list1First == null) {
            System.out.println("List is Empty");
            return;
        }
        while (list1First != null) {

            list2.insertAtStart(list1First.data);
            list1First = list1First.next;

        }
        System.out.println("Original List");
        list1.printList();
        System.out.println("Reversed List");
        list2.printList();
    }

    public static void sortLinklist(LinkedList list) {
        Node save;
        boolean swapped;

        do {
            swapped = false;
            save = list.first;
            while (save != null) {

                if (save.next != null && save.data > save.next.data) {
                    int temp = save.data;
                    save.data = save.next.data;
                    save.next.data = temp;
                    swapped = true;
                }
                save = save.next;
            }

        } while (swapped);

        list.printList();

    }

    public void insertGCDofNodeBetweenAdjecentPairOfNode() {
        Node save = first;
        Node prev = null;
        while (save != null && save.next != null) {
            prev = save;
            save = save.next;
            
            //  create newNode And Insert Between prev and next
            int newdata=gcd(prev.data, save.data);
            Node newNode=new Node(newdata);
            prev.next=newNode;
            newNode.next=save;
         
        }
            //  if single node left
        if (prev == null) {
            System.out.println("Cannot Find Gcd Of Single Info");
        }

    }

    public int gcd(int a, int b)
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

    public static void removeDuplicateNode(LinkedList list) {
        Node save = list.first;
        Node save2 = list.first;
        while (save.next != null) {
            while (save2.next != null) {
                if (save.data == save2.next.data) {

                    System.out.println("e save2:" + save2.data);
                    System.out.println(" e save1 inside:" + save.data);
                    // save2.next=save2.next.next;
                }
                save2 = save2.next;

                System.out.println("save2:" + save2.data);
                System.out.println("save1 inside:" + save.data);
            }
            save = save.next;
            System.out.println("save1 out:" + save.data);
        }
        list.printList();

    }


    public void swapNodes()
    {
        Node save = first;
        Node prev = null;
        while (save != null && save.next != null) {
            prev = save;
            save = save.next;
            
            //  create newNode And Insert Between prev and next
           int temp=prev.data;
            prev.data=save.data;
            save.data=temp;
        }
            //  if single node left
        if (prev == null) {
            System.out.println("Cannot Find Gcd Of Single Info");
        }
    }
    public static void main(String[] args) {

        LinkedList list = new LinkedList();
        LinkedList list2 = new LinkedList();

        // list.insertAtStart(10);
        // list.insertAtStart(20);
        // list.insertAtStart(10);

        // reverseLinklist(list,list2);

        // while (true) {

        // int number;
        // Scanner sc = new Scanner(System.in);
        // // System.out.print();
        // System.out.println("Enter 1 to Insert Node At First : ");
        // System.out.println("Enter 2 to Insert Node At End: ");
        // System.out.println("Enter 3 to Delete Node By Its Value(INFO) ");
        // System.out.println("Enter 4 to Delete Node From Any Position ");
        // System.out.println("Enter 5 to Sort Lsit Element ");
        // System.out.println("Enter 6 to Insert Node At Any Position In Sorted List :
        // ");
        // System.out.println("Enter 7 to Count Nodes of list");
        // System.out.println("Enter 8 to Display Nodes of list");
        // System.out.println("Enter 9 to Exit");
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
        // }
        // else if(number==5)
        // {
        // System.out.println("Original list");
        // list.printList();
        // System.out.println("Sorted list");
        // sortLinklist(list);
        // }
        // else if (number == 6) {
        // int data;
        // System.out.println("Enter Position At which You Want to Insert :");
        // data = sc.nextInt();
        // list.insord(data);
        // list.printList();
        // }
        // else if(number == 7)
        // {
        // list.countNodesOfLinklist();
        // }
        // else if(number == 8)
        // {
        // list.printList();
        // }

        // else if (number == 9) {
        // return;
        // } else {
        // System.out.println("Invalid Number Entered -- Plzz Enter Between 1 to 9");
        // }

        // }

    // GCD  of two Node

       list.insertAtStart(98);
       list.insertAtStart(56);
       list.insertAtStart(56);
       list.insertAtStart(98);
       list.printList();
    list.swapNodes();
    //    list.insertGCDofNodeBetweenAdjecentPairOfNode();
       list.printList();
    }
}