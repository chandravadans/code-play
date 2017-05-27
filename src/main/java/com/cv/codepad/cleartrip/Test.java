/* IMPORTANT: Multiple classes and nested static classes are supported */
//imports for BufferedReader
package com.cv.codepad.cleartrip;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;


class Test {
    public static void main(String args[] ) throws Exception {
        
        /* * Read input from stdin and provide input before running
         * Use either of these methods for input */

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String [] parts = line.split(" ");
        int N = Integer.parseInt(parts[0]);
        int k = Integer.parseInt(parts[1]);
        long x = Long.parseLong(parts[2]);
        long y = Long.parseLong(parts[3]);
        String array = br.readLine();
        String arrStr[] = array.split(" ");
        long ans = 0L;

        List<Integer> numbers = new ArrayList<>();

        for(int i=0; i < N; i++) {
            numbers.add(Integer.parseInt(arrStr[i]) %k );
        }
        Collections.sort(numbers);
        int arrK[] = new int[k];
        for(int i=0; i < N; i++) {
            arrK[numbers.get(i)]++;
        }
        for(int i=0; i < k; i++) {
            if ((y == i*(x-i)) && (x-i < k && x-i > 0) && (i < (x-i))) {
                ans += arrK[i] * arrK[Integer.valueOf(""+(x-i))];
            }
        }
        /*int ans = 0L;
        for(int i=0; i < N-1; i++) {
            for(int j=i+1; j < N; j++) {
                if ((numbers.get(i) + numbers.get(j)) %k == x && (numbers.get(i)*numbers.get(j)) %k == y) {
                    ans+=1;
                }
                
            }
        }*/
        System.out.println(ans);
    }

}
