package com.cv.codepad.ib.math;

/**
 * Created by cv on 12/15/16.
 */
public class VerifyPrime {
    public static int isPrime(int n) {
        if (n == 1)
            return 0;
        int upperBound = Double.valueOf(Math.sqrt(n)).intValue();
        for (int i = 2; i <= upperBound; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(1233434332));
    }

}
