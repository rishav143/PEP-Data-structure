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
    
    //Question 1 - reverse String
    public String reverseString(String str) {
        for(int i = 0; i < str.length(); i++) {
            push(str.charAt(i));
        }
        
        String newString = "";
        for(int i = 0; i < str.length(); i++) {
            newString = newString + (char)peek();
            pop();
        }
        
        return newString;
    }
    
    //Question 2 - balance expression
    public boolean balacingExpression(String exp) {
        for(int i = 0; i < exp.length(); i++) {
            char currChar = exp.charAt(i);
            if((peek() == '{' && currChar == '}') || (peek() == '(' && currChar == ')') || (peek() == '[' && currChar == ']')) {
                pop();
            } else {
                push(currChar);
            }
        }
        
        if(peek() == -1) {
            return true;
        }
        return false;
    }
    
    //Quesion 4 - delete a middle element of stack
    public void deleteInMiddle() {
        int mid = size/2;
        int arr[] = new int[mid];
        
        for(int i = 0; i < mid-1; i++) {
            arr[i] = peek();
            pop();
        }
        pop();
        for(int i = arr.length; i>=0; i--) {
            
        }
    }
}

public class _1_5_implementingStackUsingLL {
    
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
        System.out.println(stk2.reverseString(str));
        
        // Question 2 - balacing the expression
        LinkedList stk3 = new LinkedList(); // stack 3
        String str2 = "{({})}";
        boolean res = stk3.balacingExpression(str2);
        if(res == true) {
            System.out.println("Expression is valid !");
        } else {
            System.out.println("wrong !");
        }
        
        //Quesion 3 - removing the mid element from stack
        
    }
}
