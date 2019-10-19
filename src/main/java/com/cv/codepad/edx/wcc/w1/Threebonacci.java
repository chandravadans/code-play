package com.cv.codepad.edx.wcc.w1;

import mooc.EdxIO;

public class Threebonacci {
    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            io.println(ThreebonacciSolver.solve(io.nextLong(), io.nextLong(), io.nextLong(), io.nextInt()));
        }
    }
}

final class ThreebonacciSolver {

    static long solve(long t0, long t1, long t2, int n) {
        long cache[] = new long[n + 5];
        cache[0] = t0;
        cache[1] = t1;
        cache[2] = t2;
        if (n < 3) {
            return cache[n];
        } else {
            for (int i = 3; i <= n; i++) {
                cache[i] = cache[i - 1] + cache[i - 2] - cache[i - 3];
            }
            return cache[n];
        }
    }
}