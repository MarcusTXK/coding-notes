/**
 * Difficulty: Easy
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 */
class MinSizeSubArraySum {
    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public static int findMinSubArray(int S, int[] arr) {
        int windowStart = 0;
        int smallestLength = 0;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currentSum < S) { // calculate minimum window size
                smallestLength++;
            }
            currentSum += arr[i];
            while (currentSum - arr[windowStart] >= S) { // remove as many last elements as possible
                currentSum -= arr[windowStart];
                windowStart++; // shift start of window up by one each time
            }
            // check to see which is new the shortest
            smallestLength = Math.min(smallestLength, i - windowStart + 1);
        }
        return smallestLength;
    }


    public static void main(String[] args) {
        // Expected Output: 2
        System.out.println("Smallest subarray length: " +
                MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 3, 2}));
        // Expected Output: 1
        System.out.println("Smallest subarray length: " +
                MinSizeSubArraySum.findMinSubArray(7, new int[]{2, 1, 5, 2, 8}));
        // Expected Output: 3
        System.out.println("Smallest subarray length: " +
                MinSizeSubArraySum.findMinSubArray(8, new int[]{3, 4, 1, 1, 6}));
        // Expected Output: 1
        System.out.println("Smallest subarray length: " +
                MinSizeSubArraySum.findMinSubArray(8, new int[]{1, 1, 1, 8, 1, 1, 1, 1, 1}));
    }
}
