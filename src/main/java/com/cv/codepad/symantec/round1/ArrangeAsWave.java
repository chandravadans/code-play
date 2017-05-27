package com.cv.codepad.symantec.round1;

import java.util.Arrays;

/**
 * Created by Chandravadan on 4/27/2017.
 */

/**
 * Arrange as wave. inc - dec - inc - dec
 * 1, 2, 3, 4 -> 2, 1, 3, 4
 */
public class ArrangeAsWave {
    public static void main(String[] args) {
        //Integer[] test = new Integer[]{1, 2, 3, 4, 5};
        Integer[] test = new Integer[]{2, 1};
        Integer[] result = wave(test);
        for (Integer number : result) {
            System.out.print(number + " ");
        }
    }

    public static Integer[] wave(Integer[] numbers) {
        /*if (numbers.length < 3) {
            return numbers;
        }*/
        Arrays.sort(numbers);
        /*if (numbers.length < 3) {
            return numbers;
        }*/
        int numberOfElements = numbers.length;
        for (int i = 1; i < numberOfElements; i += 2) {
            int temp = numbers[i];
            numbers[i] = numbers[i - 1];
            numbers[i - 1] = temp;
        }
        return numbers;
    }
}
