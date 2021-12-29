package TwoPointers;

/**
 * Pair with Target Sum (easy)
 * <p>
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * <p>
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 */
class PairWithTargetSum {

    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public static int[] search(int[] arr, int targetSum) {
        int front = 0;
        int back = arr.length - 1;
        while (targetSum != arr[front] + arr[back]) {
            if (front >= back) { // no pairs found
                return new int[]{-1, -1};
            }
            if (arr[front] + arr[back] > targetSum) {
                back--; // decrease back pointer if too large
            } else {
                front++; // increase front pointer if too small
            }
        }
        return new int[]{front, back};
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[]{1, 2, 3, 4, 6}, 6);
        // Expected Output: [1, 3]
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[]{2, 5, 9, 11}, 11);
        // Expected Output: [0, 2]
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}
