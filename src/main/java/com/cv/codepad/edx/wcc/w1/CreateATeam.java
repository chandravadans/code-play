package com.cv.codepad.edx.wcc.w1;

import mooc.EdxIO;

public class CreateATeam {

    public static void main(String[] args) {
        int[][] scores = new int[3][3];
        try (EdxIO io = EdxIO.create()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    scores[i][j] = io.nextInt();
                }
            }
            io.println(CreateATeamSolver.solve(scores));
        }
    }
}

class CreateATeamSolver {

    public static double solve(int[][] scores) {
        double maxScore = Double.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j != i) {
                    for (int k = 0; k < 3; k++) {
                        if (k != i && k != j) {
                            double score = Math.sqrt(
                                    scores[0][i] * scores[0][i]
                                    + scores[1][j] * scores[1][j]
                                    + scores[2][k] * scores[2][k]);
                            if (score > maxScore) {
                                maxScore = score;
                            }
                        }
                    }
                }
            }
        }
        return maxScore;
    }
}