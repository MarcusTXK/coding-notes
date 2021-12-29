package MergeIntervals;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval (medium)
 *
 * Given a list of non-overlapping intervals sorted by their start time, insert a given interval at the correct position
 * and merge all necessary intervals to produce a list that has only mutually exclusive intervals.
 */
public class InsertInterval {
    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> mergedIntervals = new ArrayList<>();
        int i = 0;
        // add smaller intervals
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }
        // merge any overlapping intervals with the new interval
        while (i < intervals.size() && intervals.get(i).start < newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        // add new interval
        mergedIntervals.add(newInterval);
        // merge remaining intervals larger
        while (i < intervals.size()) {
            mergedIntervals.add(intervals.get(i));
            i++;
        }
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        // Expected Output: [1,3] [4,7] [8,12]
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        // Expected Output: [1,3] [4,12]
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        // Expected Output: [1,4] [5,7]
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
