package unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Soo {
    public static void main(String[] args) {
        StdOut.print("Enter Number of items: ");
        int n = StdIn.readInt();
        var uf = new UnionFind(n);
        while (!StdIn.isEmpty())
        {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (!uf.connected(p, q))
            {
                uf.union(p, q);
                StdOut.println(p + " " + q);
                uf.print();
            }
        }
    }
}
