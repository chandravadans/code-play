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
        int numMatches = 0;
        if (len < 4) {
            System.out.println(numMatches);
            return;
        }
        for (int a = 0; a < len - 3; a++) {
            for (int b = a + 1; b < len - 2; b++) {
                for (int c = b + 1; c < len - 1; c++) {
                    for (int d = c + 1; d < len; d++) {
                        if (str.charAt(a) == str.charAt(c) && str.charAt(b) == str.charAt(d)) {
                            numMatches ++;
                            //System.out.println(a+","+b+","+c+","+d);
                        }
                    }
                }
            }
        }
        System.out.println(numMatches);
    }
}
