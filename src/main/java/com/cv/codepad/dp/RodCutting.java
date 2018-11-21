package com.cv.codepad.dp;

import java.util.Arrays;

public class RodCutting {

    /*
        Given a rod of length l and the profits obtained by selling rods of shorter lengths
        Find a way to cut the rod such that you make max profit

        1,5,8,9,10,17,17,20 -> 22, by 17+5

        Recursive solution

        max over all i from 0 to l, v[i]+v[l-i-1]
        memoise solutions

     */
    public int dp[];

    public static void main(String[] args) {
        RodCutting sol = new RodCutting();
        System.out.println(sol.maxProfit(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
        System.out.println(Arrays.toString(sol.dp));

    }

    public int maxProfit(int[] v) {
        dp = new int[v.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        return maxProfitAux(v, v.length);
    }

    private int maxProfitAux(int[] v, int len) {
        System.out.println("maxProfitAux " + len);
        if (len <= 0) {
            return 0;
        } else if (dp[len] != -1) {
            System.out.println("Looked up for " + len);
            return dp[len];
        }
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            // If a rod is cut at i, remaining length = length - i - 1
            int val = v[i] + maxProfitAux(v, len - i - 1);
            if (val > result) {
                result = val;
            }
        }
        if (dp[len] == -1) {
            System.out.println("Storing for " + len);
            dp[len] = result;
        }
        return result;
    }
}
