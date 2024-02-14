class Stack {
    private int size, pos;
    private int arr[];

    Stack(int size) {
        this.size = size;
        pos = 0;
        arr = new int[size];
    }

    void push(int data) {
        if(pos >= arr.length) {
            System.out.println("stack is full !");
            return;
        }
        arr[pos] = data;
        pos++;
    }

    void pop() {
        if(pos <= 0) {
            System.out.println("stack is empty");
            return;
        }
        pos--;
        System.out.println(arr[pos]);
    }

    int peek() {
        return arr[pos - 1];
    }
}
public class _7_4_stackUsingArray {
    public static void main(String[] args) {
        Stack stk = new Stack(5);
    
        stk.push(1);
        stk.push(2);
        stk.push(3);
    }
}


