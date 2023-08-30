package com.example.unionFind;

import edu.princeton.cs.algs4.StdOut;

public class UnionFindHighValueRoot extends UnionFindBaseClass {
    
    public UnionFindHighValueRoot(int n) {
        arr = new int[n];
        for (int i=0; i<n; i++) arr[i] = i;
    }

    public int root(int i) {
        while (i != arr[i]) i = arr[i];
        return i;
    }

    public void union(int p, int q) {
        int a = root(p);
        int b = root(q);
        if (a == b) return;
        if (a > b) arr[b] = a;
        else arr[a] = b;
    }

    public int find(int a) {
        return root(a);
    }
    
    public static void main(String[] args) {
        var uf = new UnionFindHighValueRoot(9);
        uf.union(0, 3);
        uf.union(4,7);
        uf.union(5,8);
        uf.union(1, 5);
        uf.print();
        StdOut.println(uf.find(0));
        StdOut.println(uf.find(1));
    }
}
