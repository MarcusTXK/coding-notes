package InPlaceReversalOfALinkedList;

/**
 * Reverse a Sub-list (medium)
 *
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
 */
public class ReverseSubList {

    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public static ListNode reverse(ListNode current, int p, int q) {
        boolean isSwap = false;
        ListNode nodeBeforeP = null;
        ListNode nodeP = null;
        ListNode prev = null;
        ListNode newHead = current;
        int currentPosition = 1;
        while (current != null) {
            if (currentPosition + 1 == p) {
                nodeBeforeP = current;
            }
            if (currentPosition == p) {
                isSwap = true;
                nodeP = current;
            }
            ListNode next = current.next;
            if (isSwap) {
                current.next = prev;
            }
            if (currentPosition == q) {
                isSwap = false;
                if (nodeBeforeP != null) {
                    nodeBeforeP.next = current;
                }
                nodeP.next = next;
                if (p == 1) {
                    newHead = current;
                }
            }
            prev = current;
            current = next;
            currentPosition++;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        // Expected Output: 1 4 3 2 5
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
