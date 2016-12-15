package com.cv.codepad.ib.math;

import java.util.ArrayList;

/**
 * Created by cv on 12/15/16.
 * Primes till n using Seive of Eratosthenes
 */
public class Seive {

    public static ArrayList<Integer> sieve(int a) {
        boolean seive[] = new boolean[a + 1];
        seive[0] = false;
        seive[1] = false;
        for (int i = 2; i <= a; i++)
            seive[i] = true;
        int upperBound = Double.valueOf(Math.sqrt(a)).intValue();
        for (int i = 2; i <= upperBound; i++) {
            for (int j = 2; i * j <= a; j++) {
                seive[i * j] = false;
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i <= a; i++)
            if (seive[i] == true)
                primes.add(i);
        return primes;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ArrayList<Integer> primes = sieve(100000);
        System.out.println("Took " + (System.currentTimeMillis() - start) + " ms");
        for (Integer prime : primes)
            System.out.println(prime);

    }
}
