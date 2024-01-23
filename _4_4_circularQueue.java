import java.util.Stack;

class circularQueue {
    private int arr[] = new arr[5];
    private int front = -1, rear = -1;
    
    public boolean isEmpty() {
        if(rear == -1 && front == -1) {
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(front == 0 && rear == arr.length - 1) {
            return true;
        }
        if(front == rear+1){
            return true;
        } 
        return false;
    }
    
    public void enqueue(int data) {
        if(isFull) {
            System.out.println("Queue is Full !");
        }else {
            if(front == -1) {
                
            }
            rear = rear%arr.length;
        }
    }
}

class Main {
    public static void main(String[] args) {
        // Queue q = new Queue();
        System.out.print();
        
    }
}
