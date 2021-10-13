package array.medium;

import java.util.Arrays;

/**
 * 56. Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array
 * of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals_56 {
    /**
     * Time complexity O(nlogn)
     * Space complexity O(n)
     */
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int startValue = intervals[0][0];
        int endValue = intervals[0][1];
        int currentIndex = 0; // where to store the new information, so that no new array is created
        for (int i = 1; i < intervals.length; i++) {
            if (endValue >= intervals[i][0]) { // overlap
                endValue = Math.max(endValue, intervals[i][1]);
            } else {
                intervals[currentIndex][0] = startValue;
                intervals[currentIndex][1] = endValue;
                currentIndex++;
                startValue = intervals[i][0];
                endValue = intervals[i][1];
            }
        }
        // copy over last interval
        intervals[currentIndex][0] = startValue;
        intervals[currentIndex][1] = endValue;
        currentIndex++;

        int[][] result = new int[currentIndex][2]; // result to return
        for (int i = 0; i < currentIndex; i++) { // copy over intervals to result
            result[i][0] = intervals[i][0];
            result[i][1] = intervals[i][1];
        }
        return result;
    }
}
