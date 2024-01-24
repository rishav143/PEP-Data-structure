// Binary Search Tree operations in Java

class BinarySearchTree {
  class Node {
    int key;
    Node left, right;

    public Node(int item) {
      key = item;
      left = right = null;
    }
  }

  Node root;

  BinarySearchTree() {
    root = null;
  }

  void insert(int key) {
    root = insertKey(root, key);
  }

  // Insert key in the tree
  Node insertKey(Node root, int key) {
    // Return a new node if the tree is empty
    if (root == null) {
      root = new Node(key);
      return root;
    }

    // Traverse to the right place and insert the node
    if (key < root.key)
      root.left = insertKey(root.left, key);
    else if (key > root.key)
      root.right = insertKey(root.right, key);

    return root;
  }

  void inorder() {
    inorderRec(root);
  }

  // Inorder Traversal
  void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.print(root.key + " ");
      inorderRec(root.right);
    }
  }

  void deleteKey(int key) {
    root = deleteRec(root, key);
  }

  Node deleteRec(Node root, int key) {
    // Return if the tree is empty
    if (root == null)
      return root;

    // Find the node to be deleted
    if (key < root.key)
      root.left = deleteRec(root.left, key);
    else if (key > root.key)
      root.right = deleteRec(root.right, key);
    else {
      // If the node is with only one child or no child
      if (root.left == null)
        return root.right;
      else if (root.right == null)
        return root.left;

      // If the node has two children
      // Place the inorder successor in position of the node to be deleted
      root.key = minValue(root.right);

      // Delete the inorder successor
      root.right = deleteRec(root.right, root.key);
    }

    return root;
  }

  // Find the inorder successor
  int minValue(Node root) {
    int minv = root.key;
    while (root.left != null) {
      minv = root.left.key;
      root = root.left;
    }
    return minv;
  }

  // Question - 1
  void displayLeaf() {
    leafNode(root);
  }

  void leafNode(Node root) {
    if (root == null) {
      return;
    }

    if (root.left == null && root.right == null) {
      System.out.print(root.key + " ");
    }

    leafNode(root.left);
    leafNode(root.right);
  }

  // height of the tree
  int treeHeight() {
    return treeHeightRec(root);
  }

  int treeHeightRec(Node root) {
    if (root == null) {
      return 0;
    } else {
      int lDepth = treeHeightRec(root.left);
      int rDepth = treeHeightRec(root.right);

      return Math.max(lDepth, rDepth) + 1;
    }
  }

  //finding the predecessor of BST
  int predecessor() {
    if(root == null || root.left == null) {
      return -1;
    }
    return predecessorRec(root.left);
  }

  int predecessorRec(Node root) {
    int minV = root.key;
    while(root.right != null) {
      minV = root.right.key;
      root = root.right;
    }
    return minV;
  }

  void decendingOrder() {
    decendingOrderRec(root);
    System.out.println();
  }

  void decendingOrderRec(Node root) {
    if(root == null) {
      return;
    }

    decendingOrderRec(root.right);
    System.out.print(root.key + " ");
    decendingOrderRec(root.left);
  }

  // Driver Program to test above functions
  public static void main(String[] args) {
    BinarySearchTree tree = new BinarySearchTree();

    tree.insert(8);
    tree.insert(3);
    tree.insert(1);
    tree.insert(6);
    tree.insert(7);
    tree.insert(10);
    tree.insert(14);
    tree.insert(4);

    tree.inorder();
    System.out.println();

    tree.deleteKey(10);
    tree.inorder();
    System.out.println();

    // //Question - 1 print leaf Node
		tree.displayLeaf();
		System.out.println();

    // Question - 2 height of tree or depth of tree
		System.out.println(tree.treeHeight());

    //Question - 3 inorder predecessor of BST
    System.out.println(tree.predecessor());

    //Question - 5-A accending order for bst is inorder traversal
    //Question - 5-B decending order of BST
    tree.decendingOrder();
  }
}