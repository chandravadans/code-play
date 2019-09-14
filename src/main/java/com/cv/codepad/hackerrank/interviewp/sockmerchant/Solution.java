package com.cv.codepad.hackerrank.interviewp.sockmerchant;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

  // Complete the sockMerchant function below.
  static int sockMerchant(int n, int[] ar) {
    return new Solver().solve(n, ar);
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int n = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    int[] ar = new int[n];

    String[] arItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      int arItem = Integer.parseInt(arItems[i]);
      ar[i] = arItem;
    }

    int result = sockMerchant(n, ar);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}

class Solver {
  public int solve(int n, int[] ar) {
    boolean[] hash = new boolean[102];
    AtomicInteger result = new AtomicInteger(0);
    Arrays.stream(ar).forEach(sock -> {
      if (!hash[sock]) {
        hash[sock] = true;
      } else {
        hash[sock] = false;
        result.incrementAndGet();
      }
    });
    return result.get();
  }
}