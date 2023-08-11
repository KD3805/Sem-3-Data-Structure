import java.util.Scanner;

public class LLDemo {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---- Singly Linked List Operations ----");
            System.out.println("1. Insert a node at the front");
            System.out.println("2. Display all nodes");
            System.out.println("3. Delete the first node");
            System.out.println("4. Insert a node at the end");
            System.out.println("5. Delete the lastInserted node");
            System.out.println("6. Delete a node from a specified position");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the data to insert at the front: ");
                    int data = scanner.nextInt();
                    linkedList.insertAtFront(data);
                    break;
                case 2:
                    linkedList.display();
                    break;
                case 3:
                    linkedList.deleteFirstNode();
                    break;
                case 4:
                    System.out.print("Enter the data to insert at the end: ");
                    data = scanner.nextInt();
                    linkedList.insertAtEnd(data);
                    break;
                case 5:
                    linkedList.deletelastInsertedNode();
                    break;
                case 6:
                    System.out.print("Enter the position of the node to delete: ");
                    int position = scanner.nextInt();
                    linkedList.deleteFromPosition(position);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        } while (choice != 7);

        scanner.close();
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Insert a node at the front of the linked list
    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        System.out.println("Node inserted at the front.");
    }

    // Display all nodes in the linked list
    public void display() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        Node current = head;
        System.out.print("Nodes in the linked list: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Delete the first node of the linked list
    public void deleteFirstNode() {
        if (head == null) {
            System.out.println("Linked list is empty. Nothing to delete.");
            return;
        }
        head = head.next;
        System.out.println("First node deleted.");
    }

    // Insert a node at the end of the linked list
    public void insertAtEnd(int data) {
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
        System.out.println("Node inserted at the end.");
    }

    // Insert a node in increasing order of the linked list
    public void insertOrder(int data){
        Node newNode = new Node(data);

        if(head == null){
            head = newNode;
        }
        else{
            if(newNode.data <= head.data){
                newNode.next = head;
                head = newNode;
            }

            Node current = head;
            while(current.next != null && newNode.data >= (current.next).data){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Delete the lastInserted node of the linked list
    public void deletelastInsertedNode() {
        if (head == null) {
            System.out.println("Linked list is empty. Nothing to delete.");
            return;
        }
        if (head.next == null) {
            head = null;
            System.out.println("lastInserted node deleted.");
            return;
        }
        Node current = head;
        while ((current.next).next != null) {
            current = current.next;
        }
        current.next = null;
        System.out.println("lastInserted node deleted.");
    }

    // Delete a node from the specified position
    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("Linked list is empty. Nothing to delete.");
            return;
        }
        if (position == 1) {
            head = head.next;
            System.out.println("Node deleted from position " + position);
            return;
        }
        int count = 1;
        Node current = head;
        Node prev = null;
        while (current != null && count < position) {
            prev = current;
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position not found in the linked list.");
        } else {
            prev.next = current.next;
            System.out.println("Node deleted from position " + position);
        }
    }
}


