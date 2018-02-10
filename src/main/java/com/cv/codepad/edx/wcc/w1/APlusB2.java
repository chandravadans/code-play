package com.cv.codepad.edx.wcc.w1;

import com.cv.codepad.edx.wcc.EdxIO;

public class APlusB2 {

    public static void main(String[] args) {

        try (EdxIO io = EdxIO.create()) {
            Long a = io.nextLong();
            Long b = io.nextLong();
            io.println(a + (b * b));
        }
    }
}