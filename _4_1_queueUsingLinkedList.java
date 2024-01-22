class Queue {
    Node head;
    int size;

    class Node {
        int data;
        Node next = null;
        
        Node(int data) {
            this.data = data;
            next = null;
        }
    
    }
    
    private void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    private void deleteAtFront() {
        if(head == null) {
            return;
        }else {
            head = head.next;
        }
    }

    //implementing queue using Linked List
    public void enqueue(int data) {
        insertAtEnd(data);
        size++;
    }

    public void dequeue() {
        deleteAtFront();
        size--;
    }

    public int peek() {
        return head.data;
    }

    public void print() {
        Node curr = head;

        if(head == null) {
            return;
        } else {
            while(curr != null) {
                System.out.print(curr.data + " ");

                curr = curr.next;
            }
            System.out.println();
        }
    }
}

class _4_1_queueUsingLinkedList {
    public static void main(String[] args) {
        Queue q = new Queue();
        //1. enqueue
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        q.print();

        //2. dequeue
        q.dequeue();
        q.print();

        //3. peek
        System.out.println(q.peek());
    }
}