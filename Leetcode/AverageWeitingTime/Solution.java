package AverageWeitingTime;

public class Solution {

    private double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int end = customers[0][0];
        long totalTime = 0;
        for (int i=0; i<n; i++) {
            end = (end > customers[i][0]) ? end + customers[i][1] : customers[i][1] + customers[i][0];
            totalTime = totalTime + end - customers[i][0];
        }
        return (double) totalTime/n;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[][] arr = {{5,2},{5,4},{10,3},{20,1}};
        System.out.println(sol.averageWaitingTime(arr));
    }
}