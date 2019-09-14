package com.cv.codepad.hackerrank.interviewp.sockmerchant;

import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SockMerchantTest {

  @Parameter
  public int n;
  @Parameter(1)
  public String arr;
  @Parameter(2)
  public int output;

  Solver sol;

  @Parameters
  public static Collection<Object[]> data() {
    //@formatter:off
    return Arrays.asList(new Object[][]{
      {9, "10 20 20 10 10 30 50 10 20", 3},
    });
    //@formatter:on
  }

  @Before
  public void setup() {
    sol = new Solver();
  }

  @Test
  public void test() {
    assertThat(sol.solve(n, Arrays.stream(arr.split(" ")).mapToInt(Integer::parseInt).toArray()), Matchers.is(output));
  }

  @Test
  public void limits() {
    int[] arr = new int[100];
    Random r = new Random();
    for (int i = 0; i < 100; i++) {
      arr[i] = r.nextInt(100);
    }
    int x = sol.solve(100, arr);
    System.out.println(x);
  }
}