import java.lang.String;
class Node {
    int data;
    Node next = null;
    
    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Main {
    public static Node head = null;
    public static int size = 0;
    
    public static void insertAtFront(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public static void deleteAtFront() {
        if(head == null) {
            return;
        }else {
            head = head.next;
        }
    }
    
    //implementing stack using queue
    public static void push(int data) {
        insertAtFront(data);
        size++;
    }
    
    public static void pop() {
        deleteAtFront();
        size--;
    }
    
    public static int peek() {
        if(head == null) {
            return -1;
        } else {
            return head.data;
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
    
    //Question 1 - reverse String
    public static String reverseString(String str) {
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
    public static boolean balacingExpression(String exp) {
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
    public static void deleteInMiddle() {
        int mid = size/2;
        int arr[] = new arr[mid];
        
        for(int i = 0; i < mid-1; i++) {
            arr[i] = peek();
            pop();
        }
        pop();
        for(int i = arr.length; i>=0; i--) {
            
        }
    }
    
    public static void main(String[] args) {
        
        //stack using linked list
        push(2);
        push(3);
        push(4);
        push(5);
        print();
        System.out.println();
        
        //peek
        System.out.println(peek());
        print();
        System.out.println();
        
        //remove top element
        pop();
        print(); 
        System.out.println();
        System.out.println(size); //finding size
        
        // Question 1 - reverse a string using stack
        head = null;
        String str = "hello world";
        System.out.println(reverseString(str));
        
        // Question 2 - balacing the expression
        head = null; // make static head to again null to discontinue previous linked list
        String str2 = "{({})}";
        boolean res = balacingExpression(str2);
        if(res == true) {
            System.out.println("Expression is valid !");
        } else {
            System.out.println("wrong !");
        }
        
        //Quesion 3 - removing the mid element from stack
        
    }
}
