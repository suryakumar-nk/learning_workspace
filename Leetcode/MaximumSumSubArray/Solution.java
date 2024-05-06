package Leetcode.MaximumSumSubArray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum = sum+nums[i];
            if (sum > result) { result = sum; }
            if (sum < 0) { sum = 0; }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(new Solution().maxSubArray(arr));
    }
}
