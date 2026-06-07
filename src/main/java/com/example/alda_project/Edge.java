package com.example.alda_project;

public class Edge {
    private final Room from;
    private final Room to;
    private final double weight;

    public Edge(Room from, Room to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return from.id + " <-> " + to.id + " | cost = " + weight;
    }
}
