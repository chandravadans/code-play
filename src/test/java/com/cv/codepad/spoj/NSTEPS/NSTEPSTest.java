package com.cv.codepad.spoj.NSTEPS;

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
public class NSTEPSTest {

    @Parameter
    public String in;
    @Parameter(1)
    public String out;

    Solver sol;

    @Parameters(name = "({0}) => {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                //@formatter:off 
                { "4 2", "6" },
                { "6 6", "12" },
                { "4 3", "No Number" }, 
                { "0 0", "0" }, 
                { "1 1", "1" }, 
                { "3 1", "3" }, 
                { "6 2", "No Number" },
                { "6 5", "No Number" }, 
                { "3 5", "No Number" }, 
                { "10000 10000", "20000" } 
                //@formatter:on
        });
    }

    @Before
    public void setup() {
        sol = new Solver();
    }

    @Test
    public void test() {
        assertThat(sol.solve(in), org.hamcrest.Matchers.is(out));
    }
}