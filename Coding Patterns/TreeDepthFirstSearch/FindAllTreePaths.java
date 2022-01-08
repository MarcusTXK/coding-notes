package TreeDepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * All Paths for a Sum (medium)
 *
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 */
public class FindAllTreePaths {
    /**
     * Time Complexity O(N * Log N)
     * Space Complexity O(N * Log N) - Maximum of (N+1)/2 leaf nodes and each path having max height of Log N
     */
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        pathTraversal(root, sum, new ArrayList<>(), allPaths);
        return allPaths;
    }

    public static void pathTraversal(TreeNode node, int sum, List<Integer> previousNodes, List<List<Integer>> allPaths) {
        if (node == null) {
            return;
        }
        previousNodes.add(node.val);
        if (sum == node.val && node.left == null && node.right == null) {
            allPaths.add(new ArrayList<>(previousNodes));
        } else {
            pathTraversal(node.left, sum - node.val, previousNodes, allPaths);
            pathTraversal(node.right, sum - node.val, previousNodes, allPaths);
        }
        // remove current node from path to backtrack
        previousNodes.remove(previousNodes.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        // Expected Output: [[12, 7, 4], [12, 1, 10]]
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}

