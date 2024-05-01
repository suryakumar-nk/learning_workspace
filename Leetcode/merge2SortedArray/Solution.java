package Leetcode.merge2SortedArray;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n != 0) {
            if (m == 0) {
                for (int i=0; i<n; i++) {
                    nums1[i] = nums2[i];
                }
            } else {
                int i = 0, j = 0;
                while (j < n) {
                    if (i == m) {
                        nums1[m+j] = nums2[j];
                        j++;
                    }
                    else if (nums1[i] <= nums2[j]) {
                        i++;
                    } else {
                        // int temp = nums2[j];
                        // nums2[j] = nums1[i];
                        // nums1[i] = temp;
                        nums1[i] = nums1[i] + nums2[j];
                        nums2[j] = nums1[i] - nums2[j];
                        nums1[i] = nums1[i] - nums2[j];
                        i++;
                        Arrays.sort(nums2);
                    }
                }
            }
        }
        System.err.println(nums1);
    }
    
    public static void main(String[] args) {
        int[] a1 = {1,2,3,0,0,0};
        int[] a2 = {2,5,6};
        var sol = new Solution();
        sol.merge(a1, 3, a2, 3);
    }
}