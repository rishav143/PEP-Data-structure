class Node {
    int data;
    Node next = null;
    
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class _1_1_linkedList {
    public static Node head = null;
    
    public static void insertAtFront(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public static void insertAtLast(int data) {
        Node newNode = new Node(data);
        Node last = head;

        if(last == null){
            head = newNode;
        } else {
            while(last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }
    }

    public static void print() {
        Node curr = head;

        if(head == null) {
            return;
        } else {
            while(curr != null) {
                System.out.print(curr.data + " ");

                curr = curr.next;
            }
        }
    }
    
    public static void main(String[] args) {
        
        insertAtFront(2);
        insertAtFront(3);

        print();
    }
}