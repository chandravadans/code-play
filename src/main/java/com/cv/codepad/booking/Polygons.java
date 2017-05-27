package com.cv.codepad.booking;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by cv on 15/5/17.
 */
public class Polygons {

    enum ShapeEnum {
        SQUARE,
        RECTANGLE,
        OTHER
    }

    public ShapeEnum getShape(int a, int b, int c, int d) {
        StringBuilder sb;
        String[] words = "Hello World".split(" ");
        String x = "Hello";
        x.toLowerCase();
        Set<String> values = new HashSet<>();
        for(String s : values) {
            
        }
        if (a <= 0 || b <=0 || c <=0 || d <=0) {
            return ShapeEnum.OTHER;
        }
        if (a == b && b == c && c == d && a == d) {
            return ShapeEnum.SQUARE;
        }
        if (a == c && b == d) {
            return ShapeEnum.RECTANGLE;
        }
        return ShapeEnum.OTHER;
    }

    public static void main(String[] args) throws IOException {
        Polygons p = new Polygons();
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        String line = bufr.readLine();
        int numberOfSquares = 0;
        int numberOfRectangles = 0;
        int numberOfPolygons = 0;
        while (line.trim().length() > 0) {
            String[] numbers = line.split(" ");
            ShapeEnum shape = p.getShape(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]));
            switch (shape) {
                case SQUARE:
                    numberOfSquares++;
                    break;
                case RECTANGLE:
                    numberOfRectangles++;
                    break;
                case OTHER:
                    numberOfPolygons++;
                    break;
            }
            line = bufr.readLine();
        }
        System.out.println(numberOfSquares + " " + numberOfRectangles + " " + numberOfPolygons);
        bufr.close();
    }
}
