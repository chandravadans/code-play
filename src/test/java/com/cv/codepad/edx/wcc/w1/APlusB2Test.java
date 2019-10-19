package com.cv.codepad.edx.wcc.w1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class APlusB2Test {

    @Parameterized.Parameter
    public long a;
    @Parameterized.Parameter(1)
    public long b;
    @Parameterized.Parameter(2)
    public long op;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {3, 4, 19},
                {0,new Double(1E9).longValue(), new Double(1E18).longValue()},
                {0,new Double(-1E9).longValue(), new Double(1E18).longValue()}

        });
    }

    @Test
    public void test() {
        assertThat(APlusB2Solver.solve(a, b), is(op));
    }
}