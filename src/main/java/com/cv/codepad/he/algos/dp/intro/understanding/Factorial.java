package com.cv.codepad.he.algos.dp.intro.understanding;

/*
Given an integer N, print the factorial of the N (mod 10^9+7).

Input:
First line contains one integer, T, number of test cases.
Each test case contains one integer, N.

Output:
For each test case you need to print the factorial of
N (mod 10^9 + 7).

Constraints:
1 ≤ T ≤ 10^5
0 ≤ N ≤ 10^ 5

Sample Input
5
1
2
3
4
5

Sample Output
1
2
6
24
120

*/


import java.util.Scanner;

public class Factorial {

    public static void main(String args[]) throws Exception {
        //Scanner
        Scanner s = new Scanner(System.in);
        int numQueries = s.nextInt();
        Long dp[] = new Long[100009];
        dp[0] = 1L;
        dp[1] = 1L;
        Integer MOD = 1000000007;
        // Pre compute all answers
        for (int i = 2; i < 100009; i++) {
            dp[i] = (i * (dp[i - 1] % MOD)) % MOD;
        }
        for (int q = 0; q < numQueries; q++) {
            Integer n = s.nextInt();                 // Reading input from STDIN
            System.out.println(dp[n]);
        }
        s.close();

    }

}
