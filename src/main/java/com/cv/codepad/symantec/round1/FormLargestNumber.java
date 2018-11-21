package com.cv.codepad.symantec.round1;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Chandravadan on 4/27/2017.
 */
/*

Given list of positive numbers, form the largest number

3, 30, 34, 5, 9

- 9534330
 */
public class FormLargestNumber {
    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(3, 30, 34, 5, 9);
        //List<Integer> runTests = Arrays.asList(new Integer[]{9, 0, 99, 43, 31, 33, 34});
        //List<Integer> runTests = Arrays.asList(new Integer[]{3, 30});
        //List<Integer> runTests = Arrays.asList(new Integer[]{34, 32, 3, 5, 9});
        System.out.println(largestNumber(test));
    }

    public static String largestNumber(final List<Integer> list) {
        List<String> asStrings = new ArrayList<>();
        for (Integer i : list) {
            asStrings.add(String.valueOf(i));
        }
        asStrings = list.stream().map(i -> String.valueOf(i)).collect(Collectors.toList());

        Collections.sort(asStrings, (o1, o2) -> {
            Integer i1 = Integer.parseInt(o1+o2);
            Integer i2 = Integer.parseInt(o2+o1);
            return i2.compareTo(i1);
        });

        StringBuilder sb = new StringBuilder("");
        for (String s : asStrings) {
            sb.append(s);
        }
        return sb.toString();
    }
}
