package com.cv.codepad.atlasn;

import java.util.Arrays;

public class Base7 {
    public static void main(String[] args) {
        Base7 sol = new Base7();
        String[] chars = {"0", "a", "t", "l", "s", "i", "N"};
        System.out.println(sol.base7(7, chars));
    }

    public String base7(int num, String[] chars) {
        StringBuilder result = new StringBuilder("");
        while (num > 0) {
            result.append(chars[num % 7]);
            num = num / 7;
        }
        return result.reverse().toString();
    }
}
