package com.cv.codepad.spoj.ADDREV;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Chandravadan on 8/30/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        final Solver sol = new Solver();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(in.readLine());
            while (t > 0) {
                String input = in.readLine();
                System.out.println(sol.solve(input));
                t--;
            }
        }
    }
}

class Solver {
    public String solve(String in) {
        StringTokenizer tokenizer = new StringTokenizer(in);
        int a = Integer.parseInt(new StringBuilder(tokenizer.nextToken()).reverse().toString());
        int b = Integer.parseInt(new StringBuilder(tokenizer.nextToken()).reverse().toString());
        int ans = a + b;
        return stripLeadingZeroes(new StringBuilder(String.valueOf(ans)).reverse());
    }

    private String stripLeadingZeroes(StringBuilder num) {
        while (num.length() > 0 && num.charAt(0) == '0') {
            num.deleteCharAt(0);
        }
        if(num.length() > 0) {
            return num.toString();
        } else {
            return "0";
        }
    }
}
