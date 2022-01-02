package com.trees.sorting.graph;

import java.util.ArrayList;
import java.util.List;

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

        for (int currentNode = 0; currentNode < numberNodes; currentNode++) {
            if (!visited[currentNode]) {
                orderingPosition = dfs(orderingPosition, currentNode, visited, ordering, adjacencyList);
            }
        }

        return ordering;
    }

    private static int dfs(
            int orderingPosition, int currentNode, boolean[] visited, int[] ordering, List<List<Integer>> adjacencyList) {

        visited[currentNode] = true;

        List<Integer> connectedNodes = adjacencyList.get(currentNode);

        for (int connectedNode: connectedNodes) {
            if (!visited[connectedNode]) {
                orderingPosition = dfs(orderingPosition, connectedNode, visited, ordering, adjacencyList);
            }
        }

        ordering[orderingPosition] = currentNode;
        return orderingPosition - 1;
    }

}
