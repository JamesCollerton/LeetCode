package com.trees.sorting.graph;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {

    public static void main(String[] args) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // 5 -> 3 -> 4
        // 1 -> 2 -> 4
        // 0 -> 2 - > 4
        //

        adjacencyList.get(0).add(2);
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(4);
        adjacencyList.get(3).add(4);
        adjacencyList.get(5).add(3);

        int[] ordered = topologicalSort(adjacencyList, 7);

        for(int i: ordered) {
            System.out.print(i + " ");
        }
    }

    private static int[] topologicalSort(List<List<Integer>> adjacencyList, int numberNodes) {

        int[] ordering = new int[numberNodes];
        boolean[] seen = new boolean[numberNodes];
        int orderingPosition = numberNodes - 1;

        for(int node = 0; node < numberNodes; node++) {
            if(!seen[node]) {
                orderingPosition = dfs(ordering, seen, adjacencyList, orderingPosition, node);
            }
        }

        return ordering;
    }

    private static int dfs(int[] ordering, boolean[] seen, List<List<Integer>> adjacencyList, int orderingPosition, int node) {
        if(seen[node]) {
            return orderingPosition;
        }

        seen[node] = true;

        for(int connectedNode: adjacencyList.get(node)) {
            if(!seen[connectedNode]) {
                orderingPosition = dfs(ordering, seen, adjacencyList, orderingPosition, connectedNode);
            }
        }

        ordering[orderingPosition] = node;

        return orderingPosition - 1;
    }


}
