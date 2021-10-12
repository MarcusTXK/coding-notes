/**
 * Maximum Sum Subarray of Size K (easy)
 *
 * Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of
 * size ‘k’.
 */
public class MaxSumSubArrayOfSizeK {
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i ++) {
            if (i < k) { // create window of size k
                currentSum += arr[i];
                maxSum = currentSum;
            } else { // shift sliding window by 1
                currentSum = currentSum - arr[i - k] + arr[i];
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        // Expected Output: 9
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        // Expected Output: 7
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
