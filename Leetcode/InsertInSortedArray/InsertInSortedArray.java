package Leetcode.InsertInSortedArray;

public class InsertInSortedArray {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        int mid = (start+end)/2;
        if (end == -1) return 0;
        if (end == 0) {
            if (target > nums[end]) return end+1;
            return end;
        }
        while (true) {
            mid = (start+end)/2;
            if (start == mid) {
                if (target < nums[start]) {
                    return start == 0 ? 0 : (target > nums[start-1]) ? start : start-1;
                }
                if (target > nums[start]) {
                    if (start == nums.length-1) {
                        return start+1;
                    }
                    if (target < nums[start+1]) {
                        return start+1;
                    }
                }
            }
            if (start == end-1) {
                if (target < nums[end]) {
                    return end-1;
                }
                if (target > nums[end]) {
                    return end == nums.length-1 ? end+1 : (target < nums[end+1]) ? end+1 : end;
                }
            }
            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }            
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5};
        System.out.println(new InsertInSortedArray().searchInsert(arr, 6));
    }
}
