package com.trees.sorting.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopologicalSort {

    public static void main(String[] args) {

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        adjacencyList.get(0).add(2);
        adjacencyList.get(1).add(2);
        adjacencyList.get(2).add(4);
        adjacencyList.get(3).add(4);

        int[] ordered = topologicalSort(adjacencyList, 5);

        for(int i: ordered) {
            System.out.print(i + " ");
        }
    }

    public static int[] topologicalSort(List<List<Integer>> adjacencyList, int numberNodes) {

        int[] ordering = new int[numberNodes];
        boolean[] visited = new boolean[numberNodes];
        int orderingPosition = numberNodes - 1;

        for(int i = 0; i < numberNodes; i++) {
            if(!visited[i]) {
                orderingPosition = dfs(orderingPosition, i, visited, ordering, adjacencyList);
            }
        }

        return ordering;
    }

    // Basically do DFS and add to ordering as we recurse back up
    private static int dfs(
            int orderingPosition, int currentNode, boolean[] visited, int[] ordering, List<List<Integer>> adjacencyList) {

        visited[currentNode] = true;

        for(int node: adjacencyList.get(currentNode)) {
            if(!visited[node]) {
                orderingPosition = dfs(orderingPosition, node, visited, ordering, adjacencyList);
            }
        }

        ordering[orderingPosition--] = currentNode;
        return orderingPosition;
    }

}
