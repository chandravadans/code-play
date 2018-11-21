package com.cv.codepad.dp;

import java.lang.ref.SoftReference;

/**
 * Created by cv on 11/7/17.
 */
public class CoinChange {

    /*
    M[j] = min # coins to make change j

    M[j-v_i] = including coin v_i => make change for j - v_i
    record minimum of M[j - v _i] for all i, and add 1 to it (because ith coin is included)

    M[j] = minOverAlli(M[j - v_i) + 1

    return M[C], where C is the required change to make

     */
    public int minCoinsForChange(int[] coins, int change) {
        int[] dp = new int[change];


        return 0;
    }

    public int numWaysOfMakingChange(int[] coins, int change) {
        return 0;
    }

    public static void main(String[] args) {
        CoinChange sol = new CoinChange();
        int[] coins =
                {1, 2, 3, 4, 5};
        int change = 10;

    }
}
