package com.cv.codepad.he.algos.searching.linear;

import java.util.Scanner;

/**
 * Created by cv on 17/8/17.
 * Today, Monk went for a walk in a garden. There are many trees in the garden and each tree has an English alphabet on it. While Monk was walking, he noticed that all trees with vowels on it are not in good state. He decided to take care of them. So, he asked you to tell him the count of such trees in the garden.
 Note : The following letters are vowels: 'A', 'E', 'I', 'O', 'U' ,'a','e','i','o' and 'u'.

 Input:
 The first line consists of an integer T denoting the number of runTests cases.
 Each runTests case consists of only one string, each character of string denoting the alphabet (may be lowercase or uppercase) on a tree in the garden.

 Output:
 For each runTests case, print the count in a new line.

 Constraints:
 1≤T≤10
 1 ≤ length of string ≤ 10^5

 Input:
 2
 nBBZLaosnm
 JHkIsnZtTL
 Output:
 2
 1
 */
public class TakesAWalk {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int numVowels = 0;
            String s = in.next();
            for(char c : s.toCharArray()) {
                if (isVowel(c)) {
                    numVowels ++;
                }
            }
            System.out.println(numVowels);
        }
    }

    public static boolean isVowel(char c) {
        return     c == 'A' || c == 'a'
                || c == 'E' || c == 'e'
                || c == 'I' || c == 'i'
                || c == 'O' || c == 'o'
                || c == 'U' || c == 'u';
    }
}
