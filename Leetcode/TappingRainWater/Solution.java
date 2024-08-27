package Leetcode.TappingRainWater;

/**
 * Solution
 */
public class Solution {
    
    public long trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;
        int maxIndex = 0, maxNum = height[0];
        for (int i=1; i<n; i++) {
            if (height[i] > maxNum) {
                maxIndex = i;
                maxNum = height[i];
            } 
        }

        long totalSum = 0, currentSum = 0;
        int i=0, j=1;

        while(j <= maxIndex) {
            if (height[j] < height[i]) {
                currentSum += (height[i] - height[j]);
            } else {
                i = j;
                totalSum += currentSum;
                currentSum = 0;
            }
            j++;
        }

        i = n-1;
        j = n-2;
        while (j >= maxIndex) {
            if (height[j] < height[i]) {
                currentSum += (height[i] - height[j]);
            } else {
                i = j;
                totalSum += currentSum;
                currentSum = 0;
            }
            j--;
        }
        return totalSum;
    }

    public long trappingWater(int arr[], int n) { 
        // Your code here
        int lm = 0, rm = 0;
        long res = 0;
        int l = 0, r = n-1;
        while (l <= r) {
            if (arr[l] <= arr[r]) {
                if (arr[l] >= lm) {
                    lm = arr[l];
                } else {
                    res = res + lm - arr[l];
                }
                l++;
            } else {
                if (arr[r] >= rm) {
                    rm = arr[r];
                } else {
                    res = res + rm - arr[r];
                }
                r--;
            }
        }
        return res;
    } 

    public static void main(String[] args) {
        var solution = new Solution();
        int[] arr = {4,2,0,3,2,5,6};
        System.err.println(solution.trap(arr));
    }
}