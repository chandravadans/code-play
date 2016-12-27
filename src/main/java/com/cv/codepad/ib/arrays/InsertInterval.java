package com.cv.codepad.ib.arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by cv on 12/24/16.
 */
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
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
}
