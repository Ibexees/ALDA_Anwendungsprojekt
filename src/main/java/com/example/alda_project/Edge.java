package com.example.alda_project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Edge {
    int from;
    int to;
    int weight;

    public Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    //Kruskals MST
    public static List<Edge> computeMST(int[][] adjecencyMatrix, int roomCount)
    {

        //MST mit Adjazenzmatrix hat O(n^2) während mit Adjazenzlisten die komplexität reduziert werden kann.
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0; i < roomCount; i++)
        {
            for(int j = 0; j < roomCount; j++)
            {
                edges.add(new Edge(i,j,adjecencyMatrix[i][j]));
            }
        }

        Edge.selectionSort(edges);

        Disjoint_Set disjointSet = new Disjoint_Set(roomCount);
        List<Edge> MST = new ArrayList<>();


        for(int i = 0; i < edges.size(); i++)
        {
            int from = edges.get(i).from;
            int to = edges.get(i).to;

            if(disjointSet.find(from) != disjointSet.find(to))
            {
                disjointSet.union(from,to);
                MST.add(edges.get(i));
            }
            if(MST.size() == roomCount - 1)
            {
                break;
            }


        }

        return MST;
    }

    public static void selectionSort(List<Edge> edges) {

        int indexSmallestUnsorted;
        for (int i = 0; i < edges.size(); i++) {
            //leftmost counts as sorted initially
            indexSmallestUnsorted = i;

            for (int j = i + 1; j < edges.size(); j++) {
                if (edges.get(indexSmallestUnsorted).weight > edges.get(j).weight) {
                    indexSmallestUnsorted = j;
                }
            }
            if (indexSmallestUnsorted > i) {
                Edge placeholder = edges.get(indexSmallestUnsorted);
                edges.set(indexSmallestUnsorted, edges.get(i));
                edges.set(i, placeholder);
            }

        }
    }

    @Override
    public String toString() {
        return from + " <-> " + to + " | cost = " + weight;
    }
}
