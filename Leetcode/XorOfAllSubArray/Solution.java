package XorOfAllSubArray;

public class Solution {

    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        // Iterate through all possible subsets
        System.out.println(1 << n);
        for (int i = 0; i < (1 << n); i++) {
            int subsetXor = 0;
            for (int j = 0; j < n; j++) {
                // Check if the j-th element is in the i-th subset
                System.out.println(1 << j);
                if ((i & (1 << j)) != 0) {
                    subsetXor ^= nums[j];
                }
            }
            totalSum += subsetXor;
        }
        return totalSum;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        // System.out.println(sol.maximumValueSum(new int[]{1,2,1}, 3, new int[][]{{0,1},{0,2}}));
        System.out.println(sol.subsetXORSum(new int[]{1,2,3}));
    }
}
