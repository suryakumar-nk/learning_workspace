package Leetcode.MedianOfTwoSortedArray;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[n + m];
        int k = 0, i = 0, j = 0;
        while (k<(m+n)) {
            if (i == m) {
                merged[k++] = nums2[j++];
                continue;
            }
            if (j == n) {
                merged[k++] = nums1[i++];
                continue;
            }
            merged[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }
        int total = merged.length;
        if (total % 2 == 1) {
            return (double) merged[total / 2];
        } else {
            int middle1 = merged[total / 2 - 1];
            int middle2 = merged[total / 2];
            return ((double) middle1 + (double) middle2) / 2.0;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[] nums1 = {1,2};
        int[] nums2 = {-1,3};
        System.out.println(sol.findMedianSortedArrays(nums1, nums2));
    }
}
