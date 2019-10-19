package com.cv.codepad.edx.wcc.w1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class ThreebonacciTest {

    @Parameterized.Parameter
    public long t0;
    @Parameterized.Parameter(1)
    public long t1;
    @Parameterized.Parameter(2)
    public long t2;
    @Parameterized.Parameter(3)
    public int n;
    @Parameterized.Parameter(4)
    public long op;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3, 4, 5},
                {-1, -1, -1, 10, -1},
                {1000, 1000, 1000, 100000, 1000}
        });
    }

    @Test(timeout = 2000L)
    public void test() {
        assertThat(ThreebonacciSolver.solve(t0, t1, t2, n), is(op));
    }
}