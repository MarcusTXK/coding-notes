package TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Level Order Successor (easy)
 *
 * Given a binary tree and a node, find the level order successor of the given node in the tree. The level order
 * successor is the node that appears right after the given node in the level order traversal.
 */
public class LevelOrderSuccessor {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public static TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        boolean isFound = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (isFound) {
                return current;
            }
            if (current.val == key) { // alternatively, can just break loop and return queue.peek()
                isFound = true;
            }
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null)
            // Expected Output: 7
            System.out.println(result.val + " ");
        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null)
            // Expected Output: 10
            System.out.println(result.val + " ");
    }
}
