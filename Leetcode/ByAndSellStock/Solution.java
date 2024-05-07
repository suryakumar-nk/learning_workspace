package ByAndSellStock;

/**
 * Solution
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int min = prices[0];
        int max = 0;
        for (int i=1; i<n; i++) {
            max = (prices[i]-min) > max ? prices[i]-min : max;
            min = prices[i] < min ? prices[i] : min;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {7,2,7,3,1,5,25};
        System.out.println(new Solution().maxProfit(arr));
    }
}