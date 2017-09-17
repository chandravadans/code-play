package com.cv.codepad.he.algos.searching.linear;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cv on 17/8/17.
 * Square Inc. processes thousands of transactions daily amounting to millions of dollars. They also have a daily target that they must achieve. Given a list of transactions done by Square Inc. and a daily target your task is to determine at which transaction does Square achieves the same.
 * <p>
 * Input:
 * First line contains T, number of transactions done by Square in a day.
 * The following line contains T integers, the worth of each transactions.
 * Next line contains Q, the no of queries.
 * Next Q lines contain an integer each representing the daily target.
 * <p>
 * Output:
 * For each query, print the transaction number where the daily limit is achieved or -1 if the target can't be achieved.
 * <p>
 * Constraints:
 * 1<= T <=100_000
 * 1<= Ai <=1000
 * 1<= Target <= 10^9
 * 1<=Q<=1000000
 * <p>
 * Input:
 5
 1 2 1 3 4
 3
 4
 2
 10
 Output:
 3
 2
 5
 */
public class SquareTransaction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        List<Integer> cumulativeSum = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int ai = in.nextInt();
            if (cumulativeSum.size() == 0) {
                cumulativeSum.add(ai);
            } else {
                cumulativeSum.add(cumulativeSum.get(cumulativeSum.size() - 1) + ai);
            }
        }
        /*System.out.println("Cum sum : ");
        cumulativeSum.forEach(i -> System.out.print(i+" "));
        System.out.println();*/
        int q = in.nextInt();
        for(int i = 0; i < q; i++) {
            int target = in.nextInt();
            int index = Collections.binarySearch(cumulativeSum, target);
            //System.out.println(index);
            if (Math.abs(index) >= cumulativeSum.size()) {
                System.out.println("-1");
            } else if (index >= 0){
                System.out.println(Math.abs(index) + 1);
            } else {
                System.out.println(Math.abs(index));
            }
        }
    }
}
