package com.cv.codepad.he.algos.searching.linear;

import java.util.Scanner;

/**
 * Created by cv on 17/8/17.
 */
public class HolidaySeason {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String str = in.next();
        int counts[][] = new int[len][256];
        for (int i = 0; i < len; i++) {

        }
        int numMatches = 0;
        if (len < 4) {
            System.out.println(numMatches);
            return;
        }
        for (int b = 0; b < len - 1; b++) {
            for (int d = b + 1; d < len; d++) {
                if (str.charAt(b) == str.charAt(d)) {
                    // Search for matching a and c

                }
            }
        }
        System.out.println(numMatches);
    }
}
