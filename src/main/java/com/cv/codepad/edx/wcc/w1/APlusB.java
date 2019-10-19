package com.cv.codepad.edx.wcc.w1;

import com.cv.codepad.edx.wcc.EdxIO;

public final class APlusB {

    public static void main(String... args) {
        try (EdxIO io = EdxIO.create()) {
            io.println(APlusBSolver.solve(io.nextInt(), io.nextInt()));
        }
    }
}

final class APlusBSolver {

    public static int solve(int a, int b) {
        return a + b;
    }
}