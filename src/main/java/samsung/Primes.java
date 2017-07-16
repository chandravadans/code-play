package samsung;

import java.util.*;

/**
 * Created by cv on 11/6/17.
 */
public class Primes {

    class Element {
        int x, y;
    }

    public void dfs(int[][] matr, List<Element> pathSoFar) {

    }

    public static void main(String[] args) {
        // initially assume all integers are prime
        List<Integer> l1 = new ArrayList<>();
        l1.addAll(Arrays.asList(1,2));
        boolean[] isPrime = new boolean[100001];
        for (int i = 2; i <= 100000; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor*factor <= 100000; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= 100000; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= 100000; i++) {
            if (isPrime[i]) primes++;
        }
        System.out.println("The number of primes <= " + 100000 + " is " + primes);
    }
}
