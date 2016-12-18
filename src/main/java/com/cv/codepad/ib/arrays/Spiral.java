package com.cv.codepad.ib.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cv on 12/18/16.
 */
public class Spiral {
    public static ArrayList<Integer> spiralOrderTraversal(List<ArrayList<Integer>> matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;
        int dir = 0; // 0-> l-r, 1-> t-b, 2 -> r-l, 3 -> b-t
        while (top <= bottom && left <= right) {
            switch (dir) {
                case 0: //l-r
                    for (int i = left; i <= right; i++) {
                        result.add((Integer) matrix.get(top).get(i));
                    }
                    top++;
                    dir = (dir + 1) % 4;
                    break;
                case 1: //t-b
                    for (int i = top; i <= bottom; i++) {
                        //System.out.print(matrix[i][right]+" ");
                        result.add((Integer) matrix.get(i).get(right));
                    }
                    right--;
                    dir = (dir + 1) % 4;
                    break;
                case 2: //r-l
                    for (int i = right; i >= left; i--) {
                        //System.out.print(matrix[bottom][i]+" ");
                        result.add((Integer) matrix.get(bottom).get(i));
                    }
                    bottom--;
                    dir = (dir + 1) % 4;
                    break;
                case 3: //b-t
                    for (int i = bottom; i >= top; i--) {
                        //System.out.print(matrix[i][left]+" ");
                        result.add((Integer) matrix.get(i).get(left));
                    }
                    left++;
                    dir = (dir + 1) % 4;
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        List<ArrayList<Integer>> matr = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> colElements = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                colElements.add(in.nextInt());
            }
            matr.add(colElements);
        }
        ArrayList<Integer> spiralOrderTraversal = spiralOrderTraversal(matr);
        spiralOrderTraversal.stream().forEach(element -> System.out.print(element + " "));
    }
}
