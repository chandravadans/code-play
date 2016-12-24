/*
package com.cv.codepad.ib.arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by cv on 12/18/16.
 *//*

public class OpPredict {
    public static void main(String[] args) {
        List<ArrayList<Integer>> a = new ArrayList<>();
        int row[] = {1, 2, 3, 4};
        ArrayList<Integer> row1 = new ArrayList<>();
        List<Integer> row2 = new ArrayList<>(row1);
        Integer x = -1303455736;
        //4 1967513926 1540383426 -1303455736 -52159368
        Double c = Double.MIN_VALUE;
        BigInteger x = row2.get(20);


        a.add(row1);

    }

    ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < A.size(); i++) {
            B.add(new ArrayList<Integer>());

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).add(0);
            }

            for (int j = 0; j < A.get(i).size(); j++) {
                B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
            }
        }
        return B;
    }
}
*/
