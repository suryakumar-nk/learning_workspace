package Leetcode.SubsetsOfArray;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingApproach {
    private List<List<Integer>> results = new ArrayList<>();

    private void backTracking(int start, List<Integer> current, int[] nums) {
        results.add(new ArrayList<>(current));
        System.out.println(results);
        for (int i=start; i<nums.length; i++) {
            current.add(nums[i]);
            backTracking(i+1, current, nums);
            current.remove(current.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        backTracking(0, new ArrayList<>(), nums);
        return results;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new BackTrackingApproach().subsets(arr));
    }
}