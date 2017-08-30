package com.cv.codepad.spoj.ADDREV;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Chandravadan on 8/30/2017.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t > 0) {
            String line = in.readLine();
            String[] parts = line.split(" ");
            int a = Integer.parseInt(new StringBuffer(parts[0]).reverse().toString());
            int b = Integer.parseInt(new StringBuffer(parts[1]).reverse().toString());
            int ans = a + b;
            System.out.println(Integer.parseInt(new StringBuffer(String.valueOf(ans)).reverse().toString()));
            t--;
        }
    }
}
