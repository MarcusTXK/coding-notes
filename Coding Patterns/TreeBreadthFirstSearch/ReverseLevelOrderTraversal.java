package TreeBreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Reverse Level Order Traversal (easy)
 *
 * Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, i.e., the lowest
 * level comes first. You should populate the values of all nodes in each level from left to right in separate sub-arrays.
 */
public class ReverseLevelOrderTraversal {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public static List<List<Integer>> traverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // keep track of node layer size
            List<Integer> nodeLayer = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) { // iterate through all nodes in the current layer
                TreeNode node = queue.poll();
                nodeLayer.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(0, nodeLayer); // add layer to front of list
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        // Expected Output: [[9, 10, 5], [7, 1], [12]]
        System.out.println("Reverse level order traversal: " + result);
    }
}
