package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Triplet Sum to Zero (medium)
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 */
class TripletSumToZero {

    /**
     * Time Complexity O(N^2)
     * Space Complexity O(N)
     */
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            findPair(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    /**
     * Finds pairs matching target and adds to provided List
     *
     * @param arr        sorted arr
     * @param target     value for pair to add up to
     * @param startIndex index to start from
     * @param triplets   list containing triplets that add up to 0
     */
    public static void findPair(int[] arr, int target, int startIndex, List<List<Integer>> triplets) {
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            if (arr[startIndex] + arr[endIndex] == target) {
                triplets.add(Arrays.asList(-target, arr[startIndex], arr[endIndex]));
                endIndex--;
                startIndex++;
                // Prevents duplicated sets by skipping duplicated elements
                while (startIndex < endIndex && arr[startIndex] == arr[startIndex - 1]) {
                    startIndex++;
                }
                while (startIndex < endIndex && arr[endIndex] == arr[endIndex + 1]) {
                    endIndex--;
                }
            } else if (arr[startIndex] + arr[endIndex] > target) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
