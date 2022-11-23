public class TestBST {

        public static void main(String[] args) {
                BST<Integer> tree = new BST<>();

                Integer[] keys = {49, 28, 83, 18, 40, 71, 97, 11, 19, 32, 44, 69, 72, 92, 99};
                //Integer[] keys = {83, 18, 40, 71, 97, 11, 19, 32, 44, 69, 72, 92, 99,49, 28,};
                System.out.println("Inserting the following keys: ");
                for (Integer key : keys) {
                        System.out.printf("%d ", key);
                        tree.add(key);
                }

                System.out.printf("%n%nPreorder traversal%n");
                tree.preorderTraversal();

                System.out.printf("%n%nInorder traversal%n");
                tree.inorderTraversal();

                System.out.printf("%n%nPostorder traversal%n");
                tree.postorderTraversal();

                System.out.println();
                tree.printSideways();
                System.out.println();
                System.out.println(tree.contains(49));
                System.out.println(tree.contains(100));
                tree.levelOrder();



                //2. What happens if you change the order of the integers in the array keys on line 5 in
                //TestBST.java? Do you get the same output? Why?
                // the root will be different, it will still ge the same order or those traversal just some will
                // have more level or height

        }
}