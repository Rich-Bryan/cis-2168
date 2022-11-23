import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateList {
    static List<Integer> nodeList = new ArrayList<>();

    public static List<Integer> createList(TreeNode<Integer> node) {
    // YOU CAN WRITE YOUR SOLUTION HERE
        if (node == null) {
            return null;
        } else {
            nodeList.add(node.data);
            createList(node.left);
            createList(node.right);
        }

        return nodeList;
    }

    // inner class, represents a binary tree
    static class TreeNode<Integer> {
        int data; // node data
        TreeNode left; // this node's left subtree
        TreeNode right; // this node's right subtree

        // constructor: initializes data, sets subtrees to null
        public TreeNode(int value) {
            this.data = value;
        }
    }

    public static void show(TreeNode bt) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(bt);
        while (!q.isEmpty()) {
            TreeNode t = q.remove();
            if (t == null) continue;
            System.out.printf("%s ", t.data); // output node data
            q.add(t.left);
            q.add(t.right);
        }
    }
}