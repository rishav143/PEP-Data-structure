import java.util.Scanner;
import java.util.Stack;
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
    // public static String reverse(String expre) {
    //     char arr[] = expre.toCharArray();
    //     int start = 0, end = arr.length - 1;

    //     while(start < end) {
    //         //swap element
    //         char temp = arr[start];
    //         arr[start] = arr[end];
    //         arr[end] = temp;

    //         start++;
    //         end--;
    //     }

    //     return arr.toString();
    // }

    public static boolean isDigit(char currChar) {
        if(currChar >= '0' && currChar <= '9') {
            return true;
        } 
        return false;
    }

    public static int getPriority(char currChar) {
        if(currChar == '+' || currChar == '-') {
            return 1;
        } else if(currChar == '*' || currChar == '/') {
            return 2;
        } else if(currChar == '^') {
            return 3;
        } else {
            return 0;
        }
    }

    public static void infixToPostfix(String expre) {
        Stack<Character> charStack = new Stack<>();
        // String newStr = reverse(expre);
        for(int i = 0; i < expre.length(); i++) {
            char currChar = expre.charAt(i);
            if(isDigit(currChar)) {
                System.out.print(currChar);
            } else {
                while(!charStack.isEmpty() && getPriority(currChar) <= getPriority(charStack.peek())) {
                    System.out.print(charStack.peek());
                    charStack.pop();
                }

                charStack.add(currChar);
            }
        }
        while(!charStack.isEmpty()) {
            System.out.print(charStack.peek());
            charStack.pop();
        }
    }

    public static void stackUsingRecursion(LinkedList stk5, int n) {
        if(n <= 0) {
            return;
        }
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        stk5.push(num);
        stackUsingRecursion(stk5, n-1);
    }

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
        System.out.println();
        
        //Question 4 - infix to prefix
        String expr = "5+6*2-3/2";
        infixToPostfix(expr);
        System.out.println();

        //Question 8 - impl of stack using recursion
        LinkedList stk5 = new LinkedList();
        stackUsingRecursion(stk5, 5);
        stk5.print();

        //Question 9 - 
    }
}
