package Leetcode.TopKelements;

import java.util.PriorityQueue;

public class Solution {
    public int[] topKElements(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k)
                queue.poll();
        }
        int[] res = new int[k];
        int i = 0;
        while(queue.isEmpty() == false) {
            res[i++] = queue.poll();
        }
        return res;
    }
    
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {1,1,4,2,2,3};
        int[] res = new int[k];
        for (int i : arr) {
            if (res[k-1] > i)
                continue;
            res[k-1] = i;
            for (i=k-2; i>=0; i--) {
                if (res[i] > res[i+1]) 
                    break;
                res[i] = res[i]+res[i+1];
                res[i+1] = res[i]-res[i+1];
                res[i] = res[i]-res[i+1];
            }
        }
        for (int i : res) System.out.println(i);
    }
}
