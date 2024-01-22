class Node {
    int data;
    Node left, right;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class Tree {
    Node root;
    
    public void inorder(Node root) {
        if(root == null) {
            return;
        }
        
        inorder(root.left); // Left
        System.out.print(root.data + " "); // root
        inorder(root.right); //right
    }
    
    public void preorder(Node root) {
        if(root == null) {
            return;
        }
        
        System.out.print(root.data + " "); //root
        preorder(root.left); //Left
        preorder(root.right); //right
    }
    
    public void postorder(Node root) {
        if(root == null) {
            return;
        }
        
        postorder(root.left);//Left
        postorder(root.right);//right
        System.out.print(root.data + " ");//root
    }
}

class _5_1_tree
{
	public static void main(String[] args) {
		Tree t = new Tree();
		
		t.root = new Node (1);
		t.root.left = new Node(2);
		t.root.right = new Node(3);
		
		//print inorder
		t.inorder(t.root);
		System.out.println();
		//print preorder
		t.preorder(t.root);
		System.out.println();
		//print postorder
		t.postorder(t.root);
		System.out.println();
	}
}