package com.cv.codepad.he.algos.searching.linear;

import java.util.Scanner;

/**
 * Created by cv on 17/8/17.
 * Given A Series Of N Positive Integers a1,a2,a3........an. , Find The Minimum And Maximum Values That Can Be Calculated By Summing Exactly N-1 Of The N Integers. Then Print The Respective Minimum And Maximum Values As A Single Line Of Two Space-Separated Long Integers.

 Input Format

 First Line Take Input Value Of N

 Second Line Take Input N Space Separated Integer Value

 Output Format

 Two Space Separated Value ( One Maximum Sum And One Minimum Sum )

 Constraints

 0 < N < 100001
 0 <= ai < 10^13

 Input:
 5
 1 2 3 4 5

 Output:
 10 14

 */
public class MinMax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        long sum = 0L;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            long ai = in.nextLong();
            sum = sum + ai;
            if (ai < min) {
                min = ai;
            }
            if (ai > max) {
                max = ai;
            }
        }

        System.out.println(sum - max + " " + (sum - min));
    }
}
