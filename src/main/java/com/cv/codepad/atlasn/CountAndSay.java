package com.cv.codepad.atlasn;

import java.util.ArrayList;
import java.util.Arrays;

public class CountAndSay {
    public static void main(String[] args) {

        CountAndSay sol = new CountAndSay();
        System.out.println(sol.countNSayNth(5));

    }

    public String countNSayNth(int n) {
        /*String num = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuilder result = new StringBuilder();
            int j = 0;
            while (j < num.length()) {
                int count = 0, index = j;
                Character say = num.charAt(j);
                while (index < num.length() && say == num.charAt(index)) {
                    count++;
                    index++;
                }
                j = index;
                result.append(count).append(say);
            }
            num = result.toString();
            //System.out.println("num = " + num);
        }*/

        //ArrayList<Integer> ls = new ArrayList<>();
        String str = "a~|b|c";
        for (Character c : str.toCharArray()) {
            System.out.println(c);
        }
        System.out.println(str.replaceAll("~\\|", "\t"));
        //System.out.println(Character.valueOf(128)  + ", " + (int) '~');


        return "-1";
    }
}
