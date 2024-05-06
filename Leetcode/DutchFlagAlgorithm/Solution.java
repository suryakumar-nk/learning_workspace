package Leetcode.DutchFlagAlgorithm;

public class Solution {
    // private void swap(int[] nums, int i, int j) {
    //     nums[i] = nums[i]+nums[j];
    //     nums[j] = nums[i]-nums[j];
    //     nums[i] = nums[i]-nums[j];
    // }
    
    public void sortColors(int[] nums) {
        // int l=0, m=0, h=nums.length-1;
        // while(m<=h) {
        //     if (nums[m] == 0) swap(nums, l++, m++);
        //     if (nums[m] == 1) m++;
        //     if (nums[m] == 2 && m<h) swap(nums, m, h--);
        // }
        // h--;
        int z=0, o=0, t=0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if (nums[i] == 0) z++;
            else if (nums[i] == 1) o++;
            else t++;
        }
        int i=0;
        while(i<z) nums[i++] = 0;
        while(i<(o+z)) nums[i++] = 1;
        while(i<(z+o+t)) nums[i++] = 2;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,1};
        new Solution().sortColors(arr);
    }
}
