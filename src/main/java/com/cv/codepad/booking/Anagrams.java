package com.cv.codepad.booking;

import java.util.*;

/**
 * Created by cv on 2/6/17.
 */
public class Anagrams {
    public static void main(String[] args) {
        String s = "hello";
        String s2 = "olleh";
        System.out.println(sortString(s).equals(sortString(s2)));
        System.out.println(s.charAt(0) - 'A');
        List<Integer> sortedList = new ArrayList<>();
        Set<Integer> uniqueSet = new HashSet<>();
        sortedList.addAll(uniqueSet);
        Collections.sort(sortedList);

        //sortedSet.addAll(uniqueSet);
    }

    public static String sortString(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
