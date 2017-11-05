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
        Collections.sort(asStrings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer possibility1 = Integer.valueOf(o1 + o2);
                Integer possibility2 = Integer.valueOf(o2 + o1);
                if (possibility1 > possibility2)
                    return -1;
                else
                    return 1;
            }
        });

        String x = "hello!";
        BigInteger b1 = new BigInteger("3428984728974837827487297489278787587238657423865836249765743628698462");
        BigInteger b2 = new BigInteger("38489279374027587208578275837853289289045835732875285420827485723857238");
        b1.compareTo(b2);

        Collections.sort(asStrings, (o1, o2) -> {
            Integer i1 = Integer.parseInt(o1+o2);
            Integer i2 = Integer.parseInt(o2+o1);
            return i1.compareTo(i2);
        });

        StringBuilder sb = new StringBuilder("");
        for (String s : asStrings) {
            sb.append(s);
        }
        return sb.toString();
    }
}
