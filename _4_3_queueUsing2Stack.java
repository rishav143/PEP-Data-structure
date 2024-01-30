import java.util.Stack;

class Queue {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    public void enqueue(int data) {
        stk1.push(data);
    }

    public int dequeue() {
        if(stk1.isEmpty()) {
            System.out.println("Queue is Empty!");
            return -1;
        }else {
            while(!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        return stk2.pop();
    }

    public int peek() {
        return stk2.peek();
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }

    public int poll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'poll'");
    }enqueue(2);
        q.enqueue(3);

        System.out.print(q.dequeue());
    }

    public void add(int addVert) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
