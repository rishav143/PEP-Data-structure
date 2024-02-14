class Stack {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    void insertAtFront(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    
    void deleteAtFront() {
        if(head == null) {
            return;
        }
        head = head.next;
    }
    
    //-------------------------------------------------------
    void push(int data) {
        insertAtFront(data);
    }
    
    int peek() {
        if(head == null) {
            return -1;
        }
        return head.data;
    }
    
    void pop() {
        if(head == null) {
            return;
        }
        System.out.print(head.data);
        deleteAtFront();
    }
}

public class _7_3_stackUsingLinkedList {
	public static void main(String[] args) {
	    Stack stk = new Stack();
	    stk.push(1);
	    stk.push(2);
	    
	    stk.pop();
	}
}
