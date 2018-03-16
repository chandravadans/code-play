package com.cv.codepad.codechef.MAR18.cheglove;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Main s = new Main();
        s.solve();
    }

    private void solve() {
        Scanner in = new Scanner(System.in);
        Integer n = in.nextInt();
        for (int t = 0; t < n; t++) {
            Integer numFingers = in.nextInt();

            List<Integer> fingers = new ArrayList<>();
            List<Integer> gloves = new ArrayList<>();

            for (int i = 0; i < numFingers; i++) {
                fingers.add(in.nextInt());
            }

            for (int i = 0; i < numFingers; i++) {
                gloves.add(in.nextInt());
            }

            boolean front = true;
            boolean back = true;

            // front
            for (int i = 0; i < numFingers; i++) {
                if (fingers.get(i) > gloves.get(i)) {
                    front = false;
                    break;
                }
            }

            // back
            for (int i = 0; i < numFingers; i++) {
                if (fingers.get(i) > gloves.get(numFingers - 1 - i)) {
                    back = false;
                    break;
                }
            }

            if (!front && !back) {
                System.out.println("none");
            } else if (front && back) {
                System.out.println("both");
            } else if (front && !back) {
                System.out.println("front");
            } else if (back && !front) {
                System.out.println("back");
            }
        }
    }

    /* FAST IO CLASSES */
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
