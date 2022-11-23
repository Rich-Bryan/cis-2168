public class IntTree {
    private Node root;
    private class Node {
        int data;           // value stored at this node
        Node left, right;   // left and right subtrees of this node

        public Node(int data) {
            this(data, null, null);
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public IntTree(int size) { root = buildTree(1, size); }
    private Node buildTree(int n, int size) {
        if (n > size) return null;
        else {
            Node left = buildTree(2*n, size); // build n's left subtree
            Node right = buildTree(2*n + 1, size); // build n's right subtree
            return new Node(n, left, right); // return the Node rooted at n
        }
    }

    private void inorderHelper(Node node){
        if(node != null){
            inorderHelper(node.left);
            System.out.print(" " + node.data);
            inorderHelper(node.right);
        }
    }
    public void inorderTraversal(){
        System.out.print("inorder: ");
        inorderHelper(root);
    }

    private void preorderHelper(Node node){
        if(node != null){
            System.out.print(" " + node.data);
            preorderHelper(node.left);
            preorderHelper(node.right);

        }

    }

    public void preorderTraversal(){
        System.out.print("preorder: ");
        preorderHelper(root);

    }

    private void postorderHelper(Node node){
        if(node != null) {

            postorderHelper(node.left);
            postorderHelper(node.right);
            System.out.print(" " + node.data);
        }

    }
    public void postorderTraversal(){
        System.out.print("postorder: ");
        postorderHelper(root);

    }
    private int sumHelper(Node node){
        int total = 0;
        if(node != null) {
            total = node.data + sumHelper(node.left) + sumHelper(node.right);
        }
        return total;
    }
    public int sum(){
        return sumHelper(root);
    }
    private int countLevelsHelper(Node node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(countLevelsHelper(node.left), countLevelsHelper(node.right));

    }
    public int countLevels(){
        return countLevelsHelper(root);
    }

    private int height(Node node){
        if(node == null){
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public int height(){
        return height(root);
    }

    private int countLeavesHelper(Node node){
        if (node == null){ // if there is no item
            return 0;
        }else if(node.left == null && node.right == null){
            return 1;
        }else {
            return countLeavesHelper(node.left) + countLeavesHelper(node.right);
        }

    }
    public int countLeaves(){
        return countLeavesHelper(root);
    }

    private void printSideways(Node root, int level) {
        if (root != null) {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideways(root.left, level + 1);
        }
    }

    public void printSideways() {
        printSideways(root, 0);
    } // YOUR CODE HERE

    public static void main(String[] args) {
        //ToyIntTree bt = new ToyIntTree(7);
        IntTree tree = new IntTree(7);
        tree.printSideways();
        tree.inorderTraversal();
        System.out.println();
        tree.preorderTraversal();
        System.out.println();

        tree.postorderTraversal();
        System.out.println();
        System.out.println(tree.height());

        System.out.println("sum: " +tree.sum());
        System.out.println("Level: "+tree.countLevels());
        System.out.println("leaves: "+tree.countLeaves());
    }
}
