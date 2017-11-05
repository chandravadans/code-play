package samsung;/* IMPORTANT: Multiple classes and nested static classes are supported */


/*
Turtle's Path
To be good at problem solving, Monk thinks that Graphs are a topic one can definitely not skip. They have a variety of applications in Networks, flows , Routing and so on.

He has prepared some really interesting problems based on the same for talented programmers like you. He really adores his friends, and has chosen one of this close friends Mona as the main character for this task. So, this is how it goes :

You've got a table of size N*M containing positive integers. We'll consider the table rows numbered from top to bottom 1 through N, and the columns numbered from left to right 1 through M. Then we'll denote the cell in row x and column y as (x, y).

Initially cell (1, 1) contains one turtle named Mona. Mona wants to get to cell (N, M). Some cells of the table have obstacles. A cell is considered to be containing an obstacle if value of the cell is a NON-PRIME NUMBER. That means that Mona can only move through PRIME Numbers. It is guaranteed that upper left corner (1,1) contains a prime number.

Mona can go from cell (x, y) to one of three cells (x + 1, y ), ( x , y + 1 ) and ( x + 1, y + 1 ) only if the required cell doesn't contain an obstacle. Help him find the number of ways in which it can go from cell (1, 1) to cell (N, M).

In addition, you need to print the lexicographical largest path to reach cell (N,M).

Note: A cell (
x
1
,
y
1
x1,y1) is lexicographical larger than another cell (
x
2
,
y
2
x2,y2) if either
x
1
>
x
2
x1>x2 or if
x
1
=
x
2
x1=x2 and
y
1
>
y
2
y1>y2. A path
X
X is lexicographical larger than another path
Y
Y, if the first cell that does not match is lexicographical larger in
X
X than in
Y
Y. For example, cell
(
3
,
2
)
(3,2) is lexicographical larger than cell
(
3
,
1
)
(3,1).
Let, Path Y:
(
1
,
1
)
(
2
,
1
)
(
3
,
1
)
(
3
,
2
)
(
3
,
3
)
(1,1)(2,1)(3,1)(3,2)(3,3)
Path X:
(
1
,
1
)
(
2
,
1
)
(
3
,
2
)
(
3
,
3
)
(1,1)(2,1)(3,2)(3,3)
Path X is lexicographical larger than another path Y, because the first cell that does not match (i.e. (
3
,
2
3,2) in X and (
3
,
1
3,1) in Y) is lexicographical larger in X than in Y.

Input Format

The first line contains two space separated integers, N (number of rows) and M (number of columns).

Then N lines follow, each containing M space separated integers.

Constraints

1 <= N,M <= 103
2 <= A[x][y] <= 105 (the elements of the matrix)

Output Format

In the first line, print the total number of possible ways to reach (N,M) from (1,1). Since this number may be too large, print the answer modulo 109 +7.

Print the cell indexes (space separated) of each step of his lexicographically largest path in a new line .
If no path exists, only print 0 in first line.

(See sample runTests case for clarification)

Sample Input
3 3
2 3 7
5 4 2
3 7 11
Sample Output
4
1 1
2 1
3 2
3 3
Explanation
There are four ways to reach (3,3) from (1,1).

Path 1. (1,1) (1,2) (1,3) (2,3) (3,3)
Path 2. (1,1) (1,2) (2,3) (3,3)
Path 3. (1,1) (2,1) (3,1) (3,2) (3,3)
Path 4. (1,1) (2,1) (3,2) (3,3)

Lexicographical Order -> 4 > 3 > 2 > 1
 */

// uncomment this if you want to read input.
//imports for BufferedReader

//import for Scanner and other utility classes

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class TestClass {
    private static List<Element> finalPath = Collections.emptyList();
    private static long numberOfPaths = 0;
    private static int MOD = 10000007;
    private static int MAX = 100000;

    static boolean isPrime[];

    static class Element {
        public Integer x;
        public Integer y;

        public Element(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

    }

    static void printPaths(List<Element> tempPath, int i, int j, int m, int n, Integer[][] arr) {
        List<Element> newPath = new ArrayList<>(tempPath);
        newPath.add(new Element(i + 1, j + 1));
        if (i == m - 1 && j == n - 1) {
            if (isLarger(newPath, finalPath)) {
                finalPath = newPath;
            }
            numberOfPaths = (numberOfPaths + 1) % MOD;
            return;
        }

        //right
        if (j + 1 < n && isPrime[arr[i][j + 1]]) {
            printPaths(newPath, i, j + 1, m, n, arr);
        }
        //down
        if (i + 1 < m && isPrime[arr[i + 1][j]]) {
            printPaths(newPath, i + 1, j, m, n, arr);
        }
        //diagonal
        if (i + 1 < m && j + 1 < n && isPrime[arr[i + 1][j + 1]]) {
            printPaths(newPath, i + 1, j + 1, m, n, arr);
        }

    }

    public static boolean isLarger(List<Element> left, List<Element> right) {
        if (right.isEmpty()) {
            return true;
        }
        List<Element> shorter;
        if (left.size() <= right.size()) {
            shorter = left;
        } else {
            shorter = right;
        }
        for (int i = 0; i < shorter.size(); i++) {
            Element leftElement = left.get(i);
            Element rightElement = right.get(i);
            if (leftElement.x.equals(rightElement.x) && leftElement.y.equals(rightElement.y)) {
                continue;
            }
            if (leftElement.x.compareTo(rightElement.x) != 0) {
                return leftElement.x.compareTo(rightElement.x) >= 0;
            } else {
                return leftElement.y.compareTo(rightElement.y) >= 0;
            }
        }
        return false;
    }

    public static boolean isElementGreater(Element leftElement, Element rightElement) {
        if (leftElement.x.equals(rightElement.x) && leftElement.y.equals(rightElement.y)) {
            return true;
        }
        if (leftElement.x.compareTo(rightElement.x) != 0) {
            return leftElement.x.compareTo(rightElement.x) >= 0;
        } else {
            return leftElement.y.compareTo(rightElement.y) >= 0;
        }
    }


    public static void main(String args[]) throws Exception {

        /*Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();*/
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        String line = bufr.readLine();
        String[] parts = line.split(" ");
        int M = Integer.parseInt(parts[0]);
        int N = Integer.parseInt(parts[1]);

        int max = Integer.MIN_VALUE;

        Integer[][] mat = new Integer[M][N];
        for (int i = 0; i < M; i++) {
            line = bufr.readLine();
            parts = line.split(" ");
            for (int j = 0; j < parts.length; j++) {
                mat[i][j] = Integer.parseInt(parts[j]);
                if (mat[i][j] > max) {
                    max = mat[i][j];
                }
            }
            /*for (int j = 0; j < N; j++) {
                int e = in.nextInt();
                mat[i][j] = e;
            }*/
        }
        bufr.close();

        isPrime = new boolean[max+1];

        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor * factor <= max; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor * j <= max; j++) {
                    isPrime[factor * j] = false;
                }
            }
        }


        printPaths(new ArrayList<>(), 0, 0, M, N, mat);
        System.out.println(numberOfPaths);
        StringBuilder sb = new StringBuilder();
        for (Element e : finalPath) {
            sb.append(e+"\n");
        }
        System.out.println(sb.toString());

    }
}
