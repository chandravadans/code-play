package com.cv.codepad.edx.wcc.w1;

import com.cv.codepad.edx.wcc.EdxIO;

//import mooc.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class APlusB {

    public static void main(String[] args) throws IOException {
        try (EdxIO io = EdxIO.create()) {
            io.println(io.nextInt() + io.nextInt());
        }
    }
}