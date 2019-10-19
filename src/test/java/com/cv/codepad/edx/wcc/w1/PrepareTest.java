package com.cv.codepad.edx.wcc.w1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.IntStream.range;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class PrepareTest {

    @Parameterized.Parameter
    public int n;
    @Parameterized.Parameter(1)
    public List<Integer> p;
    @Parameterized.Parameter(2)
    public List<Integer> t;
    @Parameterized.Parameter(3)
    public int op;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return asList(new Object[][]{
                {2, asList(1, 2), asList(2, 1), 4},
                {3, asList(1, 2, 3), asList(1, 2, 3), 6},
                {4, asList(1, 2, 3, 4), asList(1000, 8, 12, 5), 1024},
                {1000, range(1, 1001).boxed().collect(Collectors.toList()),
                        range(1, 1001).boxed().collect(Collectors.toList()), (1000 * 1001) / 2}
        });
    }

    @Test(timeout = 2000L)
    public void test() {
        assertThat(PrepareSolver.solve(n, p, t), is(op));
    }
}