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

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }

    private static void djikstra(Graph graph, Node source) {

        Set<Node> seen = new HashSet<>();
        Queue<Node> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        source.distance = 0;
        queue.offer(source);

        while(!queue.isEmpty()) {

            Node node = queue.poll();

            if(!seen.contains(node)) {

                seen.add(node);

                for(Map.Entry<Node, Integer> entry: node.adjacentNodes.entrySet()) {
                    Node connectedNode = entry.getKey();
                    int distanceFromCurrentNode = entry.getValue();

                    if(!seen.contains(connectedNode)) {
                        calculateMinDistance(node, connectedNode, distanceFromCurrentNode);
                        queue.offer(connectedNode);
                    }
                }

            }

        }

    }

    private static void calculateMinDistance(Node node, Node connectedNode, int distanceFromCurrentNode) {

        int newDistance = node.distance + distanceFromCurrentNode;

        if(connectedNode.distance > newDistance) {
            connectedNode.distance = newDistance;
            List<Node> newPath = new ArrayList<>(node.path);
            newPath.add(node);
            connectedNode.path = newPath;
        }

    }

}
