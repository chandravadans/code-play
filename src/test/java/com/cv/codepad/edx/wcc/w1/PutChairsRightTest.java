package com.cv.codepad.edx.wcc.w1;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class PutChairsRightTest {

    @Parameter
    public int a;
    @Parameter(1)
    public int b;
    @Parameter(2)
    public int c;

    @Parameter(3)
    public int op;

    PutChairsRight underTest;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {3, 4, 5, 2.00000000},
                {5, 5, 7, 2.83333333}
        });
    }

    @Test
    public void test() {
        assertTrue(Math.abs(PutChairsRightSolver.solve(a, b, c) - op) < 1E-6);
    }
}