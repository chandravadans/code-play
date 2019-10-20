package com.cv.codepad.edx.wcc.w1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CreateATeamTest {

    @Parameterized.Parameter
    public int[][] scores;

    @Parameterized.Parameter(1)
    public double op;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[][]{
                        {1, 1, 1},
                        {1, 1, 1},
                        {1, 1, 1}}, 1.7320508075688772},
                {new int[][]{
                        {1, 2, 3},
                        {6, 5, 4},
                        {7, 8, 9}}, 11.0}
        });
    }

    @Test
    public void test() {
        Assert.assertTrue(Math.abs(CreateATeamSolver.solve(scores) - op) < 1E-6);
    }
}