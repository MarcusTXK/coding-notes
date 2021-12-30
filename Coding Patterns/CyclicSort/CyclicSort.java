package CyclicSort;

/**
 * Cyclic Sort (easy)
 *
 * We are given an array containing n objects. Each object, when created, was assigned a unique number from the range 1
 * to n based on their creation sequence. This means that the object with sequence number 3 was created just before the
 * object with sequence number 4.
 *
 * Write a function to sort the objects in-place on their creation sequence number in O(n) and without using any extra
 * space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each
 * number is actually an object.
 */
public class CyclicSort {
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - 1 != i) {
                // swap current to its correct location
                swap(nums, nums[i] - 1, i);
            }
        }
    }

    /**
     * Swaps two elements in an array
     * @param arr array to swap
     * @param indexOne first index
     * @param indexTwo second index
     */
    public static void swap(int[] arr, int indexOne, int indexTwo) {
        int copy = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = copy;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        // Expected Output: [1, 2, 3, 4, 5]
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
        // Expected Output: [1, 2, 3, 4, 5, 6]
        arr = new int[] { 2, 6, 4, 3, 1, 5 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
        // Expected Output: [1, 2, 3, 4, 5, 6]
        arr = new int[] { 1, 5, 6, 4, 3, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }
}
