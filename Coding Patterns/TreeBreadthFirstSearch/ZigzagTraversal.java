package TreeBreadthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Zigzag Traversal (medium)
 *
 * Given a binary tree, populate an array to represent its zigzag level order traversal. You should populate the values
 * of all nodes of the first level from left to right, then right to left for the next level and keep alternating in the
 * same manner for the following levels.
 */
public class ZigzagTraversal {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public static List<List<Integer>> traverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        boolean isForward = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // keep track of node layer size
            List<Integer> nodeLayer = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) { // iterate through all nodes in the current layer
                TreeNode node = queue.poll();
                if (isForward) {
                    nodeLayer.add(node.val);
                } else {
                    nodeLayer.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            isForward = !isForward;
            result.add(nodeLayer); // add layer to front of list
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
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        // Expected Output: [[12], [1, 7], [9, 10, 5], [17, 20]]
        System.out.println("Zigzag traversal: " + result);
    }
}
