package com.example.unionFind;

public class UnionFind extends UnionFindBaseClass {
    
    public UnionFind(int n) {
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    public int root(int a) {
        return arr[a];
    } 

    public void union(int p, int q) {
        int pid = arr[p];
        int qid = arr[q];
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == pid) arr[i] = qid;
    }
}
