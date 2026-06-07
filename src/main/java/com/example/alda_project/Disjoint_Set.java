package com.example.alda_project;

public class Disjoint_Set {

    private int[] parent;

    public Disjoint_Set(int size)
    {
        parent = new int[size];
        for (int i = 0; i < size; i++)
        {
            parent[i] = i;

        }

    }

    public int find(int i) {

        // if i itself is root or representative
        if (parent[i] == i) {
            return i;
        }

        return  find(parent[i]);

    }

    public void union(int i, int j) {

        // Representative of set containing i
        int irep = find(i);

        // Representative of set containing j
        int jrep = find(j);

        // Make the representative of i's set be
        // the representative of j's set
        parent[irep] = jrep;
    }


}
