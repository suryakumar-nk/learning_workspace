package com.example.unionFind;

public class QuickUnion extends UnionFindBaseClass {
     
    public QuickUnion(int n) {
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i;
        }
    }

    public int root(int i) {
        while (i != arr[i]) i = arr[i];
        return i;
    }

    public void union(int a, int b) {
        int p = root(a);
        int q = root(b);
        arr[p] = q;
    }
}
