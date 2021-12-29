package TwoPointers;

/**
 * Remove Duplicates (easy)
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space;
 * after removing the duplicates in-place return the length of the subarray that has no duplicate in it.
 */
class RemoveDuplicates {

    /**
     * Time Complexity O(N)
     * Space Complexity O(1)
     */
    public static int remove(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int uniqueLen = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[uniqueLen]) {
                arr[uniqueLen] = arr[i]; // new largest unique number
                uniqueLen ++;
            }
        }
        return uniqueLen;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        // Expected Output: 4
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        // Expected Output: 2
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
