package com.cv.codepad.dp;

/**
 * Created by cv on 11/7/17.
 */
public class MaxSumSubarray {

    public static void main(String[] args) {
        MaxSumSubarray sol = new MaxSumSubarray();
        int[] arr =
                //{-2, -3, 4, -1, -2, 1, 5, -3};
                //{-1, -2, -3, -5, -6};
                {8, 6, -4, -11, 5, 3, 5};
        //System.out.println(sol.maxSum(arr));
        System.out.println(sol.maxSumOptimised(arr));
    }

    public int maxSum(int[] a) {
        /*

        M[j] = max sum over all windows ending at index j

        M[x-1]+a[x] - Extending previous window
        a[x] - Start a new window at x

        M[0] = a[0]
        M[j] = max(M[j-1]+a[j], a[j])

        return max M[j]

        space - O(n)
        time - O(n)

        - optimisation => compute max on line, instead of storing all the local maxima

         */
        int len = a.length;
        int[] dp = new int[len];
        dp[0] = a[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + a[i], a[i]);
        }
        int max = dp[0];
        for(int sol : dp) {
            System.out.print(sol + " ");
            if (sol > max) {
                max = sol;
            }
        }
        System.out.println();
        return max;
    }

    public int maxSumOptimised(int[] a) {
        int len = a.length;
        int global_max = a[0];
        int local_max = a[0];
        for(int i = 0; i < len; i++) {
            local_max = Math.max(local_max + a[i], a[i]);
            global_max = Math.max(local_max, global_max);
        }
        return global_max;
    }

}
