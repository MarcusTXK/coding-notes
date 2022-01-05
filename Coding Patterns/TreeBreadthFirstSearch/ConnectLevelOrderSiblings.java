package TreeBreadthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Connect Level Order Siblings (medium)
 *
 * Given a binary tree, connect each node with its level order successor. The last node of each level should point to a
 * null node.
 */
class ConnectLevelOrderSiblings {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public static void connect(ConnectTreeNode root) {
        if (root == null) {
            return;
        }
        Queue<ConnectTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                ConnectTreeNode current = queue.poll();
                if (i + 1 != levelSize) { // not last node in level
                    current.next = queue.peek();
                } else {
                    current.next = null;
                }
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        ConnectTreeNode root = new ConnectTreeNode(12);
        root.left = new ConnectTreeNode(7);
        root.right = new ConnectTreeNode(1);
        root.left.left = new ConnectTreeNode(9);
        root.right.left = new ConnectTreeNode(10);
        root.right.right = new ConnectTreeNode(5);
        ConnectLevelOrderSiblings.connect(root);
        /**
         * Expected Output:
         * 12
         * 7 1
         * 9 10 5
         */
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }
}

/**
 * Custom Tree Node used for Connect Level Order Siblings (medium)
 */
class ConnectTreeNode {
    int val;
    ConnectTreeNode left;
    ConnectTreeNode right;
    ConnectTreeNode next;

    ConnectTreeNode(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        ConnectTreeNode nextLevelRoot = this;
        while (nextLevelRoot != null) {
            ConnectTreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
