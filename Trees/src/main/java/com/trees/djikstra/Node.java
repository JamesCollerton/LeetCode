package com.trees.djikstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Node implements Comparable<Node> {

    String name;
    int distance = Integer.MAX_VALUE;
    List<Node> path = new LinkedList<>();
    Map<Node, Integer> adjacentNodes = new HashMap<>();

    Node(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return "Node: " + name + "\n" +
                "Distance: " + distance + "\n" +
                "Path: " + path.stream().map(n -> n.name).collect(Collectors.joining("-"));

    }

}
