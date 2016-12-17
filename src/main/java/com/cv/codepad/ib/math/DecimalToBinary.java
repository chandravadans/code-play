package com.cv.codepad.ib.math;

/**
 * Created by cv on 12/15/16.
 */
public class DecimalToBinary {
    public static String findDigitsInBinary(int a) {
        if (a == 0)
            return "0";
        StringBuilder sb = new StringBuilder("");
        while (a > 0) {
            sb.append(String.valueOf(a % 2));
            a = a / 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(findDigitsInBinary(1024));
    }
}
