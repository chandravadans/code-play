package com.cv.codepad.ib.arrays;

/**
 * Created by cv on 12/24/16.
 */
public class Interval {

    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "(" + start + "," + end + ")";
    }
}

