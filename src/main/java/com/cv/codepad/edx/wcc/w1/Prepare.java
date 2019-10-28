package com.cv.codepad.edx.wcc.w1;

import mooc.EdxIO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

/**
 * To successfully participate in programming competitions, you should prepare a lot. This is very clear to young Jamie.
 * So he decided to undertake a scientific point of view. Jamie thinks that the preparation level is determined by a
 * certain number, the ability to solve problems, which accumulates every possible aspect of being ready to compete well.
 * <p>
 * After reading some books on competitive programming, Jamie understood that there are two ways to improve his skills:
 * studying theory and practicing a lot. There are n days before the next programming competition. Based on his biorhythm
 * calendar, Jamie determined two numbers for each of these days: ti is how much his ability to solve problems will improve
 * if he studies theory at the i-th day, and pi is how much it will improve if he practices a lot at the i-th day. Every
 * day should be entirely dedicated to either theory or practice. Additionally, at least one of these days should be
 * theoretical, and at least one should be practical.
 * <p>
 * Help Jamie construct such a timetable which increases his ability to solve problems to a maximum possible value.
 * You may assume that this value is equal to zero before preparation.
 * Input
 * The first line of the input file contains an integer n (2 <= n <= 100). The second line contains n integers
 * p1, p2 , ... , pn , separated by whitespace. The third line contains n integers t1, t2, ..., tn, separated by whitespace.
 * All pi and ti are positive and do not exceed 1000.
 * Output
 * Output the maximum possible value of ability to solve problems, which Jamie can achieve in n days.
 * Pay attention to the fact that Jamie should spend at least one day for theory, and at least one day for practicing.
 * Examples
 * prepare.in
 *
 * 2
 * 1 2
 * 2 1
 * 4
 * <p>
 * prepare.out
 * 3
 * 1 2 3
 * 1 2 3
 * 6
 */
public class Prepare {

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            int n = io.nextInt();

            List<Integer> p = new ArrayList<>(n);
            range(0, n).forEach(i -> p.add(io.nextInt()));

            List<Integer> t = new ArrayList<>(n);
            range(0, n).forEach(i -> t.add(io.nextInt()));

            io.println(PrepareSolver.solve(n, p, t));
        }
    }
}

class PrepareSolver {

    static int solve(int n, List<Integer> p, List<Integer> t) {
        int ability = 0;
        boolean didPractice = false;
        boolean didTheory = false;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (p.get(i) >= t.get(i)) {
                didPractice = true;
                ability += p.get(i);
            } else {
                didTheory = true;
                ability += t.get(i);
            }
            int diff = Math.abs(p.get(i) - t.get(i));
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        if (!(didPractice && didTheory)) {
            //Do a 'flip' on the day there's a minimum effect of doing so
            ability -= minDiff;
        }
        return ability;
    }
}