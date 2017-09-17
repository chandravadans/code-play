package com.cv.codepad.he.algos.searching.linear;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cv on 17/8/17.
 * You have been given an array of size N consisting of integers. In addition you have been given an element M you need to find and print the index of the last occurrence of this element M in the array if it exists in it, otherwise print -1. Consider this array to be 1 indexed.
 *
 * Input Format:
 *
 * The first line consists of 2 integers
 * N and M denoting the size of the array and the element to be searched for in the array respectively. The next line contains N space separated integers denoting the elements of of the array.
 *
 * Output Format
 *
 * Print a single integer denoting the index of the last occurrence of integer
 * M in the array if it exists, otherwise print -1.
 *
 * Input:
   5 1
   1 2 3 4 1
 * Output:
   5
 */
public class LastOccurrence {
    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        List<Integer> numbers = new ArrayList<>();

        int M = s.nextInt();

        for (int i = 0; i < N; i++) {
            int e = s.nextInt();
            numbers.add(e);
        }
        int position = -1;
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) == M) {
                position = i + 1;
                break;
            }
        }
        System.out.println(position);
    }
}
