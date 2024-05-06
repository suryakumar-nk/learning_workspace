package Leetcode.NextPermutations;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for (int i=n-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i=n-1; i>index; i--) {
                if (nums[i] > nums[index]) {
                    nums[i] = nums[i]+nums[index];
                    nums[index] = nums[i]-nums[index];
                    nums[i] = nums[i]-nums[index];
                    break;
                }
            }
        }
        int i=(index==-1)?0:index+1;
        int j=n-1;
        while(i<j) {
            nums[i] = nums[i]+nums[j];
            nums[j] = nums[i]-nums[j];
            nums[i] = nums[i]-nums[j];
            i++; j--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3,0,0};
        var sol = new Solution();
        sol.nextPermutation(arr);
    }
}