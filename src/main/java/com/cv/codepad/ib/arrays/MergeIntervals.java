package com.cv.codepad.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by cv on 12/24/16.
 */
public class MergeIntervals {
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        //System.out.println(Arrays.toString(intervals.toArray()));
        int numberOfIntervals = intervals.size();
        ArrayList<Interval> result = new ArrayList<>();
        Interval runningInterval = intervals.get(0);
        for (int i = 1; i < numberOfIntervals; i++) {
            if (intervals.get(i).start >= runningInterval.start
                    && intervals.get(i).start < runningInterval.end && intervals.get(i).end > runningInterval.end) {
                runningInterval = new Interval(runningInterval.start, intervals.get(i).end);
            } else if (intervals.get(i).start > runningInterval.end) {
                result.add(runningInterval);
                runningInterval = intervals.get(i);
            }
        }
        result.add(runningInterval);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(54, 75));
        intervals.add(new Interval(56, 60));
        intervals.add(new Interval(61, 86));
        intervals.add(new Interval(22, 43));
        intervals.add(new Interval(56, 87));
        intervals.add(new Interval(32, 53));
        intervals.add(new Interval(14, 81));
        intervals.add(new Interval(64, 65));
        intervals.add(new Interval(9, 42));
        intervals.add(new Interval(12, 33));
        intervals.add(new Interval(22, 58));
        intervals.add(new Interval(84, 90));
        intervals.add(new Interval(27, 59));
        intervals.add(new Interval(41, 48));
        intervals.add(new Interval(43, 47));
        intervals.add(new Interval(22, 29));
        intervals.add(new Interval(16, 23));
        intervals.add(new Interval(41, 72));
        intervals.add(new Interval(15, 87));
        intervals.add(new Interval(20, 59));
        intervals.add(new Interval(45, 84));
        intervals.add(new Interval(14, 77));
        intervals.add(new Interval(72, 93));
        intervals.add(new Interval(20, 58));
        intervals.add(new Interval(47, 53));
        intervals.add(new Interval(25, 88));
        intervals.add(new Interval(5, 89));
        intervals.add(new Interval(34, 97));
        intervals.add(new Interval(14, 47));
        System.out.println(Arrays.toString(merge(intervals).toArray()));

    }
}
