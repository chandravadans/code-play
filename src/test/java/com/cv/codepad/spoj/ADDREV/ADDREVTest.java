package com.cv.codepad.spoj.ADDREV;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ADDREVTest {

    @Parameter
    public String in;
    @Parameter(1)
    public String out;

    Solver sol;

    @Parameters(name = "({0}) => {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { 
            { "24 1", "34" }, 
            { "4358 754", "1998" }, 
            { "305 794", "1" },
            { "1 9", "1" }, 
            { "01 09", "1" }, 
            { "0 0", "0" } 
        });
    }

    @Before
    public void setup() {
        sol = new Solver();
    }

    @Test
    public void test() {
        assertThat(sol.solve(in), is(out));
    }
}