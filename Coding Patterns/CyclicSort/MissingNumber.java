package CyclicSort;

/**
 * Find the Missing Number (easy)
 *
 * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. Since the array has only ‘n’
 * numbers out of the total ‘n+1’ numbers, find the missing number.
 */
public class MissingNumber {

    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public static int findMissingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums.length) { // if its n ignore it as it is too large
                    break;
                }
                swap(nums, nums[i], i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) { // number does not match index
                return i;
            }
        }
        return nums.length;
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
        // Expected Output: 2
        System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        // Expected Output: 7
        System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
