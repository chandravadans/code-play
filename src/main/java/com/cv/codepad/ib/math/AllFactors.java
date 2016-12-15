package com.cv.codepad.ib.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cv on 12/15/16.
 */
public class AllFactors {
    static List<Integer> allFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        if (n == 1)
            factors.add(1);
        else {
            int upperBound = n / 2;
            for (int i = 1; i <= upperBound; i++) {
                if (n % i == 0)
                    factors.add(i);
            }
            factors.add(n);
        }
        return factors;
    }

    public static void main(String[] args) {
        List<Integer> factors = allFactors(7);
        for (Integer factor : factors)
            System.out.println(factor);
    }
}
