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

        Set<Node> seen = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>();

        source.distance = 0;
        queue.add(source);

        while(!queue.isEmpty()) {

            Node currentNode = queue.remove();

            for(Map.Entry<Node, Integer> entry: currentNode.adjacentNodes.entrySet()) {
                Node node = entry.getKey();
                int distance = entry.getValue();

                if(!seen.contains(node)) {
                    calculateMinimumDistance(node, distance, currentNode);

                    queue.add(node);
                }
            }

            seen.add(currentNode);

        }

        for(Node node: graph.nodes) {
            System.out.println(node);
        }

    }

    private static void calculateMinimumDistance(Node node, int distance, Node previousNode) {

        int newDistance = previousNode.distance + distance;

        if(newDistance < node.distance) {
            node.distance = newDistance;
            List<Node> newPath = new LinkedList<>(previousNode.path);
            newPath.add(previousNode);
            node.path = newPath;
        }

    }

}
