class Queue {
    private int items[] = new int[5];
    private int front, rear;
    
    Queue() {
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        if(front == 0 && rear == items.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if(front == -1 && rear == -1) {
            return true;
        }
        return false;
    }

    public void enqueue(int data) {
        if(isFull()) {
            System.out.print("Queue is Full!");
        } else {
            if(front == -1) {
                front = 0;
            }
            rear++;
            items[rear] = data;
        }
    }

    public int dequeue() {
        int element;
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        } else {
            element = items[front];
            if(front >= rear) {
                front = -1;
                rear = -1; 
            } else {
                front++;
            }
        }
        return element;
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Queue is Empty!");
        } else {
            for(int i = front; i <= rear; i++) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        }
    }
}

class _1_7_queueUsingArray {
    public static void main(String[] args) {
        Queue q = new Queue();
        
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.dequeue());

        q.display();
    }
}
