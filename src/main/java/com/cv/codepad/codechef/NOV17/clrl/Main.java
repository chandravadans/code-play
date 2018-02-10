package com.cv.codepad.codechef.NOV17.clrl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by cv on 11/5/17.
 */
public class Main {
    public String solve(String input) {
        StringTokenizer tokenizer = new StringTokenizer(input);
        int numValues = Integer.parseInt(tokenizer.nextToken());
        int target = Integer.parseInt(tokenizer.nextToken());
        List<Integer> values = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            values.add(Integer.parseInt(tokenizer.nextToken()));
        }
        if (values.size() == 1) {
            return "YES";
        }
        boolean increasing = false;
        if (values.get(1) >= values.get(0)) {
            increasing = true;
        } else {
            increasing = false;
        }
        int inflectionValue = Integer.MIN_VALUE;
        for (int i = 1; i < numValues; i++) {
            int value = values.get(i);
            if (value == target) {
                return "YES";
            }
            if (increasing && value < values.get(i - 1)) {
                inflectionValue = values.get(i - 1);
            }

        }
        return "YES";
    }


    /**
     * Utility functions
     */

    public void runTests() {
        Main m = new Main();
        List<String> testCases = Arrays.asList(
                "5 200\n600 300 100 350 200",
                "5 890\n5123 3300 783 1111 890"
        );
        List<String> expectedOutputs = Arrays.asList(
                "NO",
                "YES"
        );
        for (int i = 0, numberOfTests = testCases.size(); i < numberOfTests; i++) {
            String input = testCases.get(i);
            String actual = m.solve(input);
            String expected = expectedOutputs.get(i);
            if (!actual.equals(expected)) {
                throw new RuntimeException("Error! \n " + "Input : " + input + "\n Expected : " + expected + "\n Got : " + actual + "\n");
            } else {
                System.out.println("Test " + i + " passed");
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
