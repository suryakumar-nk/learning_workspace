package RankTransformOfArray;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {40,10,20,40,30};
        int n = arr.length;
        int[] rankArr = new int[n];
        for (int i=0; i<n; i++) {
            rankArr[i] = Integer.MAX_VALUE;
        }
        int c = 0;
        for (int i=0; i<n; i++) {
            int small = arr[i];
            for (int j=0; j<n; j++) {
                if (small < rankArr[j]) {
                    int temp = small;
                    small = rankArr[j];
                    rankArr[j] = temp;
                } else if (small == rankArr[j]) {
                    break;
                }
                c = i+1;
            }
        }
        Map<Integer, Integer> mapIndex = new HashMap<>();
        for(int i=0; i<c; i++) {
            mapIndex.put(rankArr[i], i+1);
        }
        for (int i=0; i<n; i++) {
            arr[i] = mapIndex.get(arr[i]);
        }
        System.out.println(arr);
    }
}
