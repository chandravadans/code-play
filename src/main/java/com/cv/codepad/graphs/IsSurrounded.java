package com.cv.codepad.graphs;

/**
 * Created by cv on 16/7/17.
 * Given a graph containing 0s and 1s and a point x,y, return true if it is surrounded by the opposite color
 * <p>
 * 1 1 1 1
 * 1 0 0 1
 * 0 1 1 1
 * 1,1 -> false
 * <p>
 * 1 1 1 1
 * 1 0 0 1
 * 1 1 1 1
 * 1,1 -> true
 * <p>
 * 1 1 1 1 1 1
 * 0 1 1 0 0 1
 * 1 1 1 0 1 1
 * 1 0 0 0 1 0
 * 1 1 1 1 1 1
 * 3,1 -> true
 */
public class IsSurrounded {
    private boolean[][] visited;
    private boolean surrounded = true;

    public static void main(String[] args) {
        IsSurrounded isSurrounded = new IsSurrounded();
        int[][] graph = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };
        System.out.println(isSurrounded.isSurrounded(graph, 2, 2));

    }

    public boolean isSurrounded(int[][] graph, int x, int y) {
        int rows = graph.length;
        int cols = graph[0].length;
        visited = new boolean[rows][cols];
        int opponent;
        if (graph[x][y] == 0) {
            opponent = 1;
        } else {
            opponent = 0;
        }
        dfs(graph, x, y, opponent);
        return surrounded;
    }

    private void dfs(int[][] graph, int x, int y, int opponent) {
        int rows = graph.length;
        int cols = graph[0].length;
        visited[x][y] = true;
        System.out.println("Marked " + x + "," + y + " as visited");
        if ((x == 0 || x >= cols - 1 || y == 0 || y >= rows - 1) && graph[x][y] != opponent) {
            surrounded = false;
        }
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newX = x + i;
                int newY = y + j;
                if (newX >= 0 && newX < cols && newY >= 0 && newY < rows) {
                    if (!visited[newX][newY] && graph[newX][newY] != opponent) {
                        //System.out.println("recursing for " + newX + "," + newY);
                        dfs(graph, newX, newY, opponent);
                    }
                }

            }
        }
    }
}
