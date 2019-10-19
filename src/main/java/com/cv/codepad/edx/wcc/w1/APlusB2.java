package com.cv.codepad.edx.wcc.w1;

import mooc.EdxIO;

public class APlusB2 {

    public static void main(String... args) {

        try (EdxIO io = EdxIO.create()) {
            io.println(APlusB2Solver.solve(io.nextLong(), io.nextLong()));
        }
    }
}

class APlusB2Solver {

    static Long solve(long a, long b) {
        return a + (b * b);
    }
}