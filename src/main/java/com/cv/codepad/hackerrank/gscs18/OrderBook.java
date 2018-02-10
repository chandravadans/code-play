package com.cv.codepad.hackerrank.gscs18;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class OrderBook {


    /*
     * Complete the function below.
     */
    static String[] processQueries(String[] queries) {
        // Write your code here.

        return null;

    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        if (bw == null) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int queriesSize = Integer.parseInt(scan.nextLine().trim());

        String[] queries = new String[queriesSize];

        for (int queriesItr = 0; queriesItr < queriesSize; queriesItr++) {
            String queriesItem = scan.nextLine();
            queries[queriesItr] = queriesItem;

        }

        String[] response = processQueries(queries);

        for (int responseItr = 0; responseItr < response.length; responseItr++) {
            bw.write(response[responseItr]);

            if (responseItr != response.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }

}
