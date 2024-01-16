class Node {
    int data;
    Node next;
    Node head = null;

    public void insertatfront(int data) {
        Node newNode = new Node();
        

        if(head == null) {
            newNode = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertLast(int data) {
        Node newNode = new Node();
        Node last = head;

        if(last == null){
            newNode = head;
        } else {
            while(last.next != null) {
                last = last.next;
            }

            last.next = newNode;
        }
    }

    public void print() {
        Node curr = head;

        if(head == null) {
            return;
        } else {
            while(curr.next != null) {
                System.out.print(curr.data + " ");

                curr = curr.next;
            }
        }
    }
}

public class _1_1_linkedList {
    
    public static void main(String[] args) {
        Node ll = new Node();
        
        ll.insertAtFront(2);
        ll.insertAtFront(3);

        ll.print();
    }
}
