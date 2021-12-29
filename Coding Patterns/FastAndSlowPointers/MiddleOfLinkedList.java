package FastAndSlowPointers;

/**
 * Middle of the LinkedList (easy)
 *
 * Given the head of a Singly LinkedList, write a method to return the middle node of the LinkedList. *
 * If the total number of nodes in the LinkedList is even, return the second middle node.
 */
class MiddleOfLinkedList {

    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // Expected Output: 3
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
        // Expected Output: 4
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
        // Expected Output: 4
        head.next.next.next.next.next.next = new ListNode(7);
        System.out.println("Middle Node: " + MiddleOfLinkedList.findMiddle(head).value);
    }
}
