/*
package com.cv.codepad.he.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

*/
/**
 * Created by Chandravadan on 12/27/2016.
 *//*

public class EdgeCheck {
    public static void main(String args[]) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Input number of nodes and edges
        String line = br.readLine();
        String[] parts = line.split(" ");
        int nodes = Integer.parseInt(parts[0].trim());
        int edges = Integer.parseInt(parts[1].trim());
        boolean[][] graph = new boolean[nodes][nodes];

        //Input edges
        for (int i = 0; i < edges; i++) {
            line = br.readLine();
            parts = line.split(" ");
            int node1 = Integer.parseInt(parts[0].trim());
            int node2 = Integer.parseInt(parts[1].trim());
            graph[node1][[node2] = true;
            graph[node2][node1] = true;
        }

        //Take queries
        line = br.readLine();
        int queries = Integer.parseInt(line.trim());
        for (int i = 0; i < queries; i++) {
            line = br.readLine();
            parts = line.split(" ");
            int node1 = Integer.parseInt(parts[0].trim());
            int node2 = Integer.parseInt(parts[1].trim());
            if (graph[node1][node2])
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
*/
