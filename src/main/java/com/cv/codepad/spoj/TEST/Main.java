package com.cv.codepad.spoj.TEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Chandravadan on 8/30/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (true) {
            s = in.readLine();
            if (s == null || s.equals("42")) {
                break;
            } else {
                System.out.println(s);
            }
        }
    }
}
