package unionFind;

import edu.princeton.cs.algs4.StdOut;

public class QuickUnion {
     
    int[] arr;

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

    public boolean isConnected(int a, int b) {
        return root(b) == root(a);
    }

    public void union(int a, int b) {
        int p = root(a);
        int q = root(b);
        arr[p] = q;
    }

    public void print() {
        for (int i : arr) StdOut.print(i+" ");
    }
}
