
import java.util.Scanner;

public class DoublyLinklistOfString {

    Node head;
    Node tail;
    Node current;

    static class Node {
        String data;
        Node lptr;
        Node rptr;

        Node(String data) {
            this.data = data;
            this.lptr = null;
            this.rptr = null;
        }
    }

    public DoublyLinklistOfString() {
        this.head = null;
        this.tail = null;
    }

    

    public void insertAtEndInDoublyLinklist(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            newNode.lptr = newNode;
            newNode.rptr = newNode;
        } else {
            newNode.lptr = tail;
            tail.rptr = newNode;
            tail = newNode;
            newNode.rptr = head;

        }
        current = head;
    }

    public void displayDoublyLinklist() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.rptr;
        } while (temp != tail.rptr);
        System.out.println();
    }

    public void play() {

        System.out.println("Now Playing  : " + current.data);
    }

    public void nextSong() {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        current = current.rptr;

        System.out.println(" Switched To Next Song :--");
        System.out.println("Now Playing  : " + current.data);

    }

    public void prevSong() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node prev = current;

        prev = current.lptr;

        current = prev;

        System.out.println(" Switched To Previous Song :-- ");
        System.out.println("Now Playing : " + prev.data);

    }
    public static void main(String[] args) {
        DoublyLinklistOfString doublyLinklist = new DoublyLinklistOfString();
        while (true) {

            int number;
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("Enter 1 to Add a Song : ");
            System.out.println("Enter 2 to Play a Song");
            System.out.println("Enter 3 to Play Next Song ");
            System.out.println("Enter 4 to Play Previous Song: ");
            System.out.println("Enter 5 to Display All Songs");
            System.out.println("Enter 6 to Exit");
            number = sc.nextInt();

            if (number == 1) {
                String song;
                System.out.println("Enter Song Name :");
                song = sc.next();
                doublyLinklist.insertAtEndInDoublyLinklist(song);
                doublyLinklist.displayDoublyLinklist();

            } else if (number == 2) {
                doublyLinklist.play();
            } else if (number == 3) {
                doublyLinklist.nextSong();
            } else if (number == 4) {
                doublyLinklist.prevSong();
            }
            else if (number == 5) {
                doublyLinklist.displayDoublyLinklist();
            }

            else if (number == 6) {
                return;
            } else {
                System.out.println("Invalid Number Entered -- Plzz Enter Between 1 to 6");
            }
        }
    }


}
