package com.cv.codepad.spoj.NSTEPS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int t = Integer.parseInt(reader.readLine());
      Solver s = new Solver();
      while (t > 0) {
        System.out.println(s.solve(reader.readLine()));
        t--;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class Solver {
  public String solve(String in) {
    StringTokenizer tokenizer = new StringTokenizer(in);
    int x = Integer.parseInt(tokenizer.nextToken());
    int y = Integer.parseInt(tokenizer.nextToken());
    boolean xOdd = x % 2 != 0;
    boolean yOdd = y % 2 != 0;
    String result = "No Number";
    if (y <= x && (x - y) <= 2) {
      if (xOdd && yOdd) {
        result = String.valueOf((x + y) - 1);
      } else if (!xOdd && !yOdd) {
        result = String.valueOf(x + y);
      }
    }
    return result;
  }
}

/*
 * (0, 0) -> 0
 * (1, 1) -> 1 
 * (2, 0) -> 2 
 * (3, 1) -> 3 
 * (2, 2) -> 4 
 * (3, 3) -> 5 
 * (4, 2) -> 6 
 * (5, 3) -> 7 
 * (4, 4) -> 8 
 * (5, 5) -> 9 
 * (6, 4) -> 10
 */