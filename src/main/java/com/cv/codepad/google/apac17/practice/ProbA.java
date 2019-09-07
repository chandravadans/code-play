package com.cv.codepad.google.apac17.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cv on 2/21/17.
 */
public class ProbA {
    public static void main(String[] args) throws IOException {
         /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input */

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        
        for(int i=0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int set[] = new int[N];
            for(int j = 0; j < N; j++) {
                set[j] = Integer.parseInt(br.readLine());
            }
            System.out.println(calculateXorOfAllSubsets(set));
        }
    }
    static Integer calculateXorOfAllSubsets(int[] set) {
        int result = -1;
        int n = set.length;

        for (int i = 0; i < (1<<n); i++)
        {
            // Print current subset
            for (int j = 0; j < n; j++)

                // (1<<j) is a number with jth bit 1
                // so when we 'and' them with the
                // subset number we get which numbers
                // are present in the subset and which
                // are not
                if ((i & (1 << j)) > 0){
                    if(result == -1)
                        result = set[j];
                    else
                        result = result ^ set[j];
                }
        }
        return result;
    }
}
