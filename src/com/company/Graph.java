package com.company;

import java.io.*;
import java.util.*;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    private int []dist = new int[100500];

    Graph(int v){
        V = v;
        adj = new LinkedList[v];
        dist = new int[v];
        for (int i = 1; i < v; ++i) {
            adj[i] = new LinkedList( );
            dist[i] = 0;
        }
    }

    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    void BFS(int s){

        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s]=true;
        queue.add(s);
        //dist[s] = -1;

        while (queue.size() != 0) {
            int v = queue.poll();

            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    dist[n] = dist[v] + 6;
                }
            }
        }
    }

    void printDist(int v, int s){
        for(int i = 1; i <= v; i++){
            if(i != s) {
                if (dist[i] != 0)
                    System.out.print(dist[i] + " ");
                else
                    System.out.print(-1 + " ");
            }
        }
        System.out.println();
    }
}
