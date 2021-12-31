package com.trees.djikstra;

import java.util.*;
import java.util.stream.Collectors;

public class Node implements Comparable<Node> {

    String name;
    Map<Node, Integer> adjacentNodes = new HashMap<>();
    Integer distance = Integer.MAX_VALUE;
    List<Node> path = new LinkedList<>();

    Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n\nNode: " + this.name + "\n" +
                "Distance: " + this.distance + "\n" +
                "Path: " + path.stream().map(n -> n.name).collect(Collectors.joining("-")) + "\n";
    }

    @Override
    public int compareTo(Node that) {

        if(this.distance < that.distance) {
            return -1;
        }

        if(this.distance > that.distance) {
            return 1;
        }

        return 0;
    }
}
