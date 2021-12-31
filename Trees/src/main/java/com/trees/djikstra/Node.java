package com.trees.djikstra;

import java.util.*;

public class Node implements Comparable<Node> {

    String name;
    Integer distance = Integer.MAX_VALUE;
    Map<Node, Integer> adjacentNodes = new HashMap<>();
    List<Node> shortestPath = new LinkedList<>();

    Node(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Node that) {
        if (this.distance < that.distance)
            return -1;

        if (this.distance > that.distance)
            return 1;

        return 0;
    }
}
