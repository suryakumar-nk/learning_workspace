package Leetcode.MaximumWidthRamp;

import java.util.Stack;

public class Solution {

    public int maxWidthRamp(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        // First pass: Push indices of potential left boundaries into the stack
        // We only push indices where the value is smaller than the previous stack top
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || arr[stack.peek()] > arr[i]) {
                stack.push(i);
            }
        }

        int ans = 0;

        // Second pass: Iterate from right to left to find the maximum width ramp
        for (int i = n - 1; i > 0; i--) {
            // While the stack is not empty and the current element is greater than or equal to the stack top
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                // Calculate the width of the ramp and update the maximum
                ans = Math.max(ans, i - stack.peek());
                // Remove the top element as we've found a valid ramp for it
                stack.pop();
            }
        }

        // Return the maximum width ramp found
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {6,4,8,2,1,5};
        new Solution().maxWidthRamp(arr);
        int n = arr.length;
        int res = 0;
        int i=0, j=(n-1);
        while (i < j) {
            if (arr[i] <= arr[j]) {
                res = j-i;
                break;
            } else {
                i++;
            }   
        }
        System.out.println(res);
    }
}