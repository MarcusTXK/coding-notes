package TreeDepthFirstSearch;

/**
 * Sum of Path Numbers (medium)
 *
 * Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
 * Find the total sum of all the numbers represented by all paths.
 */
public class SumOfPathNumbers {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public static int findSumOfPathNumbers(TreeNode root) {
        return treeTraversal(root, 0);
    }

    public static int treeTraversal(TreeNode current, int num) {
        if (current == null) {
            return 0;
        }
        num = num * 10 + current.val;
        if (current.left == null && current.right == null) {
            return num;
        }
        return treeTraversal(current.left, num) +
                treeTraversal(current.right, num);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        // Expected Output: 332
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
