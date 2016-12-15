package com.cv.codepad.ib.math;

import java.util.ArrayList;
import java.util.Collections;
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
            int upperBound = Double.valueOf(Math.sqrt(n)).intValue();
            for (int i = 1; i <= upperBound; i++) {
                if (n % i == 0) {
                    factors.add(i);
                    int otherFactor = n / i;
                    if (otherFactor != i)
                        factors.add(otherFactor);
                }
            }
        }
        Collections.sort(factors);
        return factors;
    }

    public static void main(String[] args) {
        List<Integer> factors = allFactors(9);
        for (Integer factor : factors)
            System.out.println(factor);
    }
}
