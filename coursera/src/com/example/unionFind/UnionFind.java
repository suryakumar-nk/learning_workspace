package com.example.unionFind;

import edu.princeton.cs.algs4.StdOut;

public class UnionFind {
    
    int[] arr;

    public UnionFind(int n) {
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public void union(int p, int q) {
        int pid = arr[p];
        int qid = arr[q];
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == pid) arr[i] = qid;
    }

    public boolean connected(int p, int q) {
        return arr[p] == arr[q];
    }    

    public void print() {
        for (int i : arr) StdOut.print(i+" ");
    }
}
