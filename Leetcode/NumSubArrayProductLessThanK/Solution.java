package Leetcode.NumSubArrayProductLessThanK;

class Solution {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // int n = nums.length;
        // int length = 1;
        // int count = 0;
        // if (k > 1000){
        //     count = n;
        //     length = 2;
        // }
        // while (length <= n) {
        //     long multi = 1;
        //     for (int i=0; i<length; i++) {
        //         multi*=nums[i];
        //     }
        //     if (multi < k)
        //         count+=1;
        //     for (int i=length; i<n; i++) {
        //         multi = (multi*nums[i])/nums[i-length];
        //         if (multi < k)
        //             count+=1;
        //     }
        //     length+=1;
        // }
        // return count;
        int s = 0, e = 0, multi = 1, count = 0;
        while(e < nums.length) {
            multi *= nums[e++];
            while(s < e && multi >= k) {
                multi /= nums[s++];
            }
            if(multi < k) {
                count += e-s;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        System.out.println(new Solution().numSubarrayProductLessThanK(arr, 100));
    }     
}