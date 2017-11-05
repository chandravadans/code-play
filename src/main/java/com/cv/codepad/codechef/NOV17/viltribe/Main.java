package com.cv.codepad.codechef.NOV17.viltribe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by cv on 11/5/17.
 */
public class Main {
    public String solve(String villageConfig) {
        int numVillages = villageConfig.length();
        int aVillages = 0;
        int bVillages = 0;
        StringBuilder villageConfigEditable = new StringBuilder(villageConfig);
        for (int i = 0; i < numVillages; i++) {
            char thisVillage = villageConfigEditable.charAt(i);
            if (thisVillage == 'A') {
                aVillages++;
            } else if (thisVillage == 'B') {
                bVillages++;
            } else if (thisVillage == '.') {

                // Nearest non empty village to the left
                char nearestLeft = '.';
                for (int idx = i; idx >= 0; idx--) {
                    if (villageConfigEditable.charAt(idx) == '.') {
                        continue;
                    } else if (villageConfigEditable.charAt(idx) == 'A') {
                        nearestLeft = 'A';
                        break;
                    } else {
                        // It can only be B
                        nearestLeft = 'B';
                        break;
                    }
                }

                // Nearest non empty village to the right
                char nearestRight = '.';
                for (int idx = i; idx < numVillages; idx++) {
                    if (villageConfigEditable.charAt(idx) == '.') {
                        continue;
                    } else if (villageConfigEditable.charAt(idx) == 'A') {
                        nearestRight = 'A';
                        break;
                    } else {
                        // It can only be B
                        nearestRight = 'B';
                        break;
                    }
                }

                if (nearestLeft == nearestRight && nearestLeft != '.') {
                    villageConfigEditable.setCharAt(i, nearestLeft);
                    if (nearestLeft == 'A') {
                        aVillages++;
                    } else {
                        bVillages++;
                    }
                }
            } else {
                throw new RuntimeException("Invalid character: " + thisVillage);
            }
        }
        return String.valueOf(aVillages + " " + bVillages);
    }


    /**
     * Utility functions
     */

    public void runTests() {
        Main m = new Main();
        List<String> testCases = Arrays.asList(
                "A..A..B...B",
                "..A..",
                "A....A",
                "..B..B..B..",
                "......"
        );
        List<String> expectedOutputs = Arrays.asList(
                "4 5",
                "1 0",
                "6 0",
                "0 7",
                "0 0"

        );
        for (int i = 0, numberOfTests = testCases.size(); i < numberOfTests; i++) {
            String input = testCases.get(i);
            String actual = m.solve(input);
            String expected = expectedOutputs.get(i);
            if (!actual.equals(expected)) {
                throw new RuntimeException("Error! \n " + "Input : " + input + "\n Expected : " + expected + "\n Got : " + actual + "\n");
            } else {
                System.out.println("Test " + i +" passed");
            }
        }
    }

    public void runSolution() throws Exception {
        Main m = new Main();
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(inp.readLine());
        while (t > 0) {
            String villageConfig = inp.readLine();
            System.out.println(m.solve(villageConfig));
            t--;
        }
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        //m.runSolution();
        m.runTests();
    }
}
