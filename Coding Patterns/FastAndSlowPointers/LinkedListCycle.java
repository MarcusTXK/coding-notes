package FastAndSlowPointers;

/**
 * LinkedList Cycle (easy)
 * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 */
class LinkedListCycle {

    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     * Another possible solution is to use a hashmap and checking if the ListNode is already present in the hashmap.
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.value == slow.value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        // Expected Output: false
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
        // Expected Output: true
        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
        // Expected Output: true
        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList has cycle: " + LinkedListCycle.hasCycle(head));
    }
}
