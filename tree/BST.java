import java.util.LinkedList;
import java.util.Queue;

public class BST <Key extends Comparable>{
    private Node root;

    private class Node{
        Key key;
        Node left, right;

        public Node(Key key) { this(key, null, null); }
        public Node(Key key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

    }
    public BST() { }
    // inserts a new node in the binary search tree (BST)
    public void add (Key key ) { root = add(root, key); }

        // recursively adds a new node preserving the BST property
    private Node add (Node node, Key key) {
        if (node == null) return new Node(key);
        int cmp = key.compareTo(node.key);
        if (cmp <= 0) node.left = add(node.left, key);
        else node.right = add(node.right, key);
        return node;
    }

        // begin inorder traversal
    public void inorderTraversal() {
        inorderHelper(root);
    }
        // perform inorder traversal recursively
    private void inorderHelper( Node node ) {
        if ( node == null ) return;
        inorderHelper( node.left ); // traverse left subtree
        System.out.printf( "%s ", node.key ); // output node data
        inorderHelper( node.right ); // traverse left subtree
    }
    private void preorderHelper(Node node){
        if(node != null){
            System.out.print(" " + node.key);
            preorderHelper(node.left);
            preorderHelper(node.right);

        }

    }
    public void preorderTraversal(){
        //System.out.print("preorder: ");
        preorderHelper(root);
    }
    private void postorderHelper(Node node){
        if(node != null) {
            postorderHelper(node.left);
            postorderHelper(node.right);
            System.out.print(" " + node.key);
        }

    }
    public void postorderTraversal(){
        //System.out.print("postorder: ");
        postorderHelper(root);

    }

    public Key contains(Key key){
        return Contains(root, key);
    }
    private Key Contains (Node node, Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);

        if (cmp == 0){ // means we find the node
            return node.key;
        }
        if (cmp < 0 && node.left != null){ // if the key is on less it means on the left
            return Contains(node.left, key);
        }
        if(cmp > 0 && node.right != null){ // if the key is more it means on the right
            return Contains(node.right, key);
        }
        return null;

    }
    public void levelOrder(){
        levelOrder(root);

    }

    private void levelOrder(Node node){
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll(); // remove the item in queue
            System.out.println(temp.key); // print the data
            if (temp.left != null){ // check is the left node is null
                q.offer(temp.left);
            }
            if(temp.right != null){ // check if right node is null
                q.offer(temp.right);
            }
        }
    }
    private void printSideways(Node root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.key);
            printSideways(root.left, level + 1);
        }
    }
    public void printSideways() {
        printSideways(root, 0);
    } // YOUR CODE HERE

}
