class CircularLinkedList {
    Node head;
    
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void insertAtFront(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while(temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public void 

    public void printList() {
        Node curr = head;
        
        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while(curr != head);
    }
}

public class _1_2_circularLinkedList {

    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.insertAtFront(1);
        cl.insertAtFront(2);
        cl.insertAtFront(3);

        cl.printList();


    }
}
