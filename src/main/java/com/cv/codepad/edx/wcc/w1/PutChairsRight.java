package com.cv.codepad.edx.wcc.w1;

import mooc.EdxIO;

public class PutChairsRight {

    public static void main(String[] args) {
        try (EdxIO io = EdxIO.create()) {
            int a = io.nextInt();
            int b = io.nextInt();
            int c = io.nextInt();
            io.println(PutChairsRightSolver.solve(a, b, c));
        }
    }
}

class PutChairsRightSolver {

    public static double solve(int a, int b, int c) {
        return (double) (a + b + c) / 6.0;
    }
}