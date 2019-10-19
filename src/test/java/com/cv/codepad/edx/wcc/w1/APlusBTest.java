package com.cv.codepad.edx.wcc.w1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;

@RunWith(Parameterized.class)
public class APlusBTest {

    @Parameterized.Parameter
    public int a;
    @Parameterized.Parameter(1)
    public int b;
    @Parameterized.Parameter(2)
    public int op;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2},
                {0, 1, 1},
                {-1_000_000_000, 1_000_000_000, 0}
        });
    }

    @Test
    public void test() {
        Assert.assertThat(APlusBSolver.solve(a, b), is(op));
    }
}