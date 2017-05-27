package com.cv.codepad.gfg.graphs;

/**
 * Created by cv on 3/27/17.
 */
public class Islands {

    public boolean isSafe(int[][] graph, int x, int y, boolean[][]visited) {
        int rows = graph.length;
        int cols = graph[0].length;
        if (    x < rows && x >= 0
                && y < cols && y >=0
                && graph[x][y] == 1
                && visited[x][y] == false) {
            return true;
        } else {
            return false;
        }

    }

    public void dfs(int[][]graph, int x, int y, boolean[][] visited) {
        if(isSafe(graph, x, y, visited)) {
            visited[x][y] = true;
            for(int i=-1; i <=1; i++) {
                for(int j = -1; j <=1; j++) {
                    dfs(graph, x+i, y+j, visited);
                }
            }
        }
    }

    public int numberOfIslands(int[][]graph) {
        int rows = graph.length;
        int cols = graph[0].length;
        boolean visited [] [] = new boolean[rows][cols];
        int count = 0;
        for(int i=0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if (graph[i][j] == 1 && visited[i][j] != true) {
                    dfs(graph,i,j,visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Islands problem = new Islands();
        /*Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int [][] graph = new int[r][c];
        for(int i=0; i < r; i++){
            for(int j=0; i < c; j++) {
                graph[i][j] = in.nextInt();
            }
        }*/
        int graph [] [] = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(problem.numberOfIslands(graph));
    }
}
