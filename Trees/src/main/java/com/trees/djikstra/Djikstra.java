package com.trees.djikstra;

import java.util.*;

public class Djikstra {

    public static void main(String[] args) {

        Graph graph = new Graph();

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        graph.nodes.add(a);
        graph.nodes.add(b);
        graph.nodes.add(c);
        graph.nodes.add(d);
        graph.nodes.add(e);

        a.adjacentNodes.put(c, 7);
        a.adjacentNodes.put(b, 2);

        b.adjacentNodes.put(a, 2);
        b.adjacentNodes.put(c, 3);
        b.adjacentNodes.put(d, 2);

        c.adjacentNodes.put(a, 7);
        c.adjacentNodes.put(b, 3);
        c.adjacentNodes.put(d, 3);
        c.adjacentNodes.put(e, 6);

        d.adjacentNodes.put(b, 2);
        d.adjacentNodes.put(c, 3);
        d.adjacentNodes.put(e, 6);

        e.adjacentNodes.put(c, 6);
        e.adjacentNodes.put(d, 6);

        djikstra(graph, a);
    }

    private static void djikstra(Graph graph, Node source) {

        source.distance = 0;

        Set<Node> seenNodes = new HashSet<>();

        Queue<Node> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(source);

        while(!priorityQueue.isEmpty()) {

            Node currentNode = priorityQueue.remove();

            for (Map.Entry<Node, Integer> adjacencyPair: currentNode.adjacentNodes.entrySet()) {

                Node node = adjacencyPair.getKey();
                Integer weight = adjacencyPair.getValue();

                if (!seenNodes.contains(node)) {
                    calculateMinimumDistance(node, weight, currentNode);
                    priorityQueue.add(node);
                }

            }

            seenNodes.add(currentNode);
        }

        for(Node node: graph.nodes) {
            System.out.println("Node: " + node.name);
            System.out.println("Distance: " + node.distance);
        }

    }

    private static void calculateMinimumDistance(Node currentNode, int weight, Node previousNode) {
        Integer previousDistance = previousNode.distance;
        if (previousDistance + weight < currentNode.distance) {
            currentNode.distance = previousDistance + weight;
            LinkedList<Node> shortestPath = new LinkedList<>(previousNode.shortestPath);
            shortestPath.add(previousNode);
            currentNode.shortestPath = shortestPath;
        }
    }

}
