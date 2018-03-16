package com.cv.codepad.tc.srm7291;

import java.math.BigInteger;

public class MagicNumberThree {
    int MOD = 1000000007;

    public int countSubsequences(String s) {
        int strlen = s.length();
        int result = 0;
        BigInteger three = new BigInteger("3");
        for (int i = 0; i < strlen; i++) {
            for (int j = i + 1; j <= strlen; j++) {
                String thisNum = s.substring(i, j);
                System.out.println(thisNum);
                BigInteger x = new BigInteger(thisNum);
                if (x.mod(three).intValue() == 0) {
                    result = (result + 1) % MOD;
                    //System.out.println(x);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MagicNumberThree sol = new MagicNumberThree();
        //System.out.println(sol.countSubsequences("12345678901234567890123456789012345678901234567890"));
        System.out.println(sol.countSubsequences("132"));
    }
}
