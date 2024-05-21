package Leetcode.TopKFrequentElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4,6,3,4,6,10,4,7,10,6};
        int k = 3;
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int num : nums) {
            if (numCount.containsKey(num)) {
                int val = numCount.get(num);
                numCount.put(num, val+1);
            } else {
                numCount.put(num, 1);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for (Entry<Integer, Integer> entry : numCount.entrySet()) {
            int[] val = {entry.getKey(), entry.getValue()};
            pq.add(val);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (pq.isEmpty() == false) {
            res[i++] = pq.poll()[0];
        }
        Arrays.sort(res);
        for(int j : res) System.out.println(j);
    }
}
