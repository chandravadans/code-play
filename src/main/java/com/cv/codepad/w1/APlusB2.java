package com.cv.codepad.w1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class APlusB2 {
    static Scanner newInput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new Scanner(new File("aplusbb.in"));
        } else {
            return new Scanner(System.in);
        }
    }

    static PrintWriter newOutput() throws IOException {
        if (System.getProperty("JUDGE") != null) {
            return new PrintWriter("aplusbb.out");
        } else {
            return new PrintWriter(System.out);
        }
    }

    public static void main(String[] args) throws IOException {

        try (Scanner in = newInput(); PrintWriter out = newOutput()) {
            Long a = Long.valueOf("" + in.nextInt());
            Long b = Long.valueOf("" + in.nextInt());
            out.print(a + (b * b));
        }
    }
}