class LinkedList {
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
    
    public void insertAtFront(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void deleteAtFront() {
        if(head == null) {
            return;
        }else {
            head = head.next;
        }
    }
    
    //implementing stack using queue
    public void push(int data) {
        insertAtFront(data);
        size++;
    }
    
    public void pop() {
        deleteAtFront();
        size--;
    }
    
    public int peek() {
        if(head == null) {
            return -1;
        } else {
            return head.data;
        }
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
        }
    }

    //question 3 - delete in the middle
    public void deleteInMiddle() {
        int mid = size/2;
        
        Node stackNode = head;
        for(int i = 1; i <= size; i++) {
            if(i != mid) {
                System.out.print(stackNode.data + " ");
            }
            stackNode = stackNode.next;
        }
    }
}

public class _1_5_implementingStackUsingLL {
    //Question 1 - reverse String
    public static String reverseString(String str, LinkedList stk2) {
        for(int i = 0; i < str.length(); i++) {
            stk2.push(str.charAt(i));
        }
        
        String newString = "";
        for(int i = 0; i < str.length(); i++) {
            newString = newString + (char)stk2.peek();
            stk2.pop();
        }
        
        return newString;
    }
    
    //Question 2 - balance expression
    public static boolean balacingExpression(String exp, LinkedList stk3) {
        for(int i = 0; i < exp.length(); i++) {
            char currChar = exp.charAt(i);
            if((stk3.peek() == '{' && currChar == '}') || (stk3.peek() == '(' && currChar == ')') || (stk3.peek() == '[' && currChar == ']')) {
                stk3.pop();
            } else {
                stk3.push(currChar);
            }
        }
        
        if(stk3.peek() == -1) {
            return true;
        }
        return false;
    }

    //Quesion 4 - infix to postfix expression
    
    public static void main(String[] args) {
        LinkedList stack = new LinkedList();
        //stack using linked list
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.print();
        System.out.println();
        
        //peek
        System.out.println(stack.peek());
        stack.print();
        System.out.println();
        
        //remove top element
        stack.pop();
        stack.print(); 
        System.out.println();
        System.out.println(stack.size); //finding size
        
        // Question 1 - reverse a string using stack
        LinkedList stk2 = new LinkedList(); // new stack 2
        String str = "hello world";
        System.out.println(reverseString(str, stk2));
        
        // Question 2 - balacing the expression
        LinkedList stk3 = new LinkedList(); // stack 3
        String str2 = "{({})}";
        boolean res = balacingExpression(str2, stk3);
        if(res == true) {
            System.out.println("Expression is valid !");
        } else {
            System.out.println("wrong !");
        }
        
        //Quesion 3 - Deleted middle of the linked list using stack
        LinkedList ll = new LinkedList();
        ll.push(0);
        ll.push(1);
        ll.push(2);
        ll.push(3);

        ll.deleteInMiddle();
        
        //Question 4 - infix to prefix

    }
}
