package com.cv.codepad.edx.wcc.w1;

/**
 * Created by cv on 11/3/16.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*

Bad is the team which doesn’t dream of winning a competition! However, in order to win, it is necessary to understand what you can do, distribute your forces the right way, and implement your ideas precisely.

The team of three, Dream Team, can do this rather well. In particular, since the very beginning of the competition it manages to understand, for every proposed problem, how much time it will take them to solve it. This way, they are able to eﬃciently distribute their time during the competition. But it is not enough for a victory. It is necessary to solve the maximum possible number of problems.

Write a program that, given the time Dream Team needs to solve every proposed problem, can determine what is the maximum possible number of problems they can solve in 300 minutes, which is the timespan of ACM ICPC World Finals.
Input
The ﬁrst line of the input ﬁle contains an integer number n (1 ≤ n ≤ 15) – the number of proposed problems. The second line contains n integer numbers t1, t2, …, tn, where ti is the time, in seconds, which is required to solve the i-th problem. All ti are positive and don’t exceed 105. Please recall that one minute consists of 60 seconds.
Output
Output the single number – the maximum number of problems, which Dream Team can solve.
Examples
win.in
win.out
2
60 18000
1

3
10000 9000 8000
2
 */
public class Win {
    static Scanner newInput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new Scanner(new File("win.in"));
        } else {
            return new Scanner(System.in);
        }
    }

    static PrintWriter newOutput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new PrintWriter("win.out");
        } else {
            return new PrintWriter(System.out);
        }
    }

    public static void main(String[] args) throws IOException {
        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            Integer numberOfProblems = in.nextInt();
            List<Integer> problemTimes = new ArrayList<>();
            for (int i = 0; i < numberOfProblems; i++) {
                problemTimes.add(in.nextInt());
            }
            Collections.sort(problemTimes);
            Integer totalProblems = 0;
            Double totalTime = 0.0;
            Double maxTime = 300.0;
            for (int i = 0; i < numberOfProblems; i++) {
                totalTime += problemTimes.get(i) / 60.0;
                if (totalTime > maxTime) {
                    break;
                } else {
                    totalProblems += 1;
                }
            }
            out.print(totalProblems);
        }
    }
}
