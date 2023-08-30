package com.example.unionFind;

import edu.princeton.cs.algs4.StdOut;

public abstract class UnionFindBaseClass {
    int [] arr;

    public abstract int root(int a);

    public abstract void union(int a, int b);

    public boolean connected(int a, int b) {
        return root(a) == root(b);
    }

    public void print() {
        for (int i : arr) StdOut.print(i+" ");
        StdOut.println();
    }
}
