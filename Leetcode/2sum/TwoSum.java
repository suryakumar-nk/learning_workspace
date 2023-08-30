import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TwoSum {
    public List<int[]> twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int start = 0;
        int end = numbers.length-1;
        List<int[]> res = new ArrayList<>();
        while (start < end) {
            var sum = numbers[start] + numbers[end];
            if (sum == target) {
                int[] arr = {numbers[start], numbers[end]};
                res.add(arr);
            }
            if (sum < target) start++;
            else end--;
        }
        return res;
    }

    public List<int[]> twoSum(int[] nums, long target, int start) {
        Arrays.sort(nums);
        List<int[]> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
    
        while (lo < hi) {
            int currSum = nums[lo] + nums[hi];
            // if (currSum < target || (lo > start && nums[lo] == nums[lo - 1])) {
            if (currSum < target) {
                ++lo;
            // } else if (currSum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
            } else if (currSum > target) {
                --hi;
            } else {
                int[] arr = {nums[lo++], nums[hi--]};
                res.add(arr);
            }
        }
                                                          
        return res;
    }

    public static void main(String[] args) {
        var sol = new TwoSum();
        int[] nums = {2,5,11,15,2,3,4}; //2,2,3,4,5,11,15
        var res = sol.twoSum(nums, 7);
        System.out.println(res);
        var res2 = sol.twoSum(nums, 7, 0);
        System.out.println(res2);
    }
}