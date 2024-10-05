package GOG.SieveOfEratosthenes;

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        int N = 10;
        var list = new ArrayList<Integer>();
        for (int i=2; i<=N; i++) {
            int sqnm = 1;
            int j= 0;
            while (true) {
                j++;
                if (j*j == i) {
                    sqnm = j;
                    break;
                } 
                if (j*j > i) {
                    sqnm = j-1;
                    break;
                }
            }
            boolean flag = true;
            for (int k=2; k<(sqnm+1); k++) {
                if (i%k == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(i);
        }
        System.out.println(list);
    }
}
