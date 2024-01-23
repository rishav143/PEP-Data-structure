class Node {
    int data;
    Node left, right;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class binaryTree {
    Node root;
    
    void root(int data) {
        root = insert(root, 1);
    }
    
    Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        } else if(root.data > key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }
    
    void inorder(Node root) {
        if(root == null) {
            return;
        }
        
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

public class _5_2_binaryTree
{
	public static void main(String[] args) {
        binaryTree bt = new binaryTree();
        
        bt.root(1);
        bt.insert(bt.root, 2);
        bt.insert(bt.root, 3);
        
        bt.inorder(bt.root);
    }
}