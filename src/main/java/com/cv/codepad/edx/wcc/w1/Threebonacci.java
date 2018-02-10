package com.cv.codepad.edx.wcc.w1;

import com.cv.codepad.edx.wcc.EdxIO;

public class Threebonacci {
    static final int MAXN = 100009;

    public static void main(String[] args) {
        long cache[] = new long[MAXN];
        try (EdxIO io = EdxIO.create()) {
            long t0 = io.nextLong();
            long t1 = io.nextLong();
            long t2 = io.nextLong();
            int n = io.nextInt();
            cache[0] = t0;
            cache[1] = t1;
            cache[2] = t2;
            if (n < 3) {
                io.println(cache[n]);
            } else {
                for (int i = 3; i <= n; i++) {
                    cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
                    if (cache[i] < 0) {
                        System.out.println("Overflowed at i = " + i);
                    }
                }
                io.println(cache[n - 1]);
            }
        }
    }
}
