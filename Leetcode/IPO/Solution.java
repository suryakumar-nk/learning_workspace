package Leetcode.IPO;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        PriorityQueue<Integer> maximizeCapital = new PriorityQueue<>(Collections.reverseOrder());
        while (k-- > 0) {
            while (i < n && projects[i][0] <= w) {
                maximizeCapital.offer(projects[i][1]);
                i++;
            }
            if (maximizeCapital.isEmpty()) {
                break;
            }
            w += maximizeCapital.poll();
        }
        return w;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().findMaximizedCapital(2, 0, new int[]{3,2,3}, new int[]{1,0,1}));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // Add elements to the priority queue
        pq.offer(10);
        pq.offer(30);
        pq.offer(20);
        pq.offer(5);

        // Retrieve and remove elements from the priority queue
        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // Elements are retrieved in ascending order
        }
    }
}