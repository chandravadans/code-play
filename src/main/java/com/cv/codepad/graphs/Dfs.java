package com.cv.codepad.graphs;

/**
 * Created by cv on 16/7/17.
 * Print DFS of given graph
 */
public class Dfs {
    public void dfs(int[][] graph, int x, int y) {
        int rows = graph.length;
        int cols = graph[0].length;
        boolean[][] visited = new boolean[rows][cols];
        dfsUtil(graph, visited, x, y);
    }

    public void dfsUtil(int[][] graph, boolean[][] visited, int x, int y) {
        int rows = graph.length;
        int cols = graph[0].length;
        if (x < 0 || x >= cols || y < 0 || y >= cols) {
            return;
        } else {
            visited[x][y] = true;
            System.out.println("Visited " + x + "," + y);
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newX = x + i;
                    int newY = y + j;
                    if (newX >= 0 && newX < cols && newY >= 0 && newY < rows) {
                        if (!visited[newX][newY]) {
                            dfsUtil(graph, visited, newX, newY);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Dfs dfs = new Dfs();
        int[][] graph = new int[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };
        dfs.dfs(graph,3,3);
    }
}
