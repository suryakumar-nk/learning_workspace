package GOG.MaximumProductSubArray;

public class Solution {
    
    public static void main(String[] args) {
        int[] arr = {6, -3, -10, 0, 2};
        long maxProd = Long.MIN_VALUE;
        long leftToRight = 1L;
        long rightToLeft = 1L;
        int n = arr.length;
        for (int i=0; i<n; i++) {
            leftToRight = leftToRight == 0 ? 1 : leftToRight;
            rightToLeft = rightToLeft == 0 ? 1 : rightToLeft;
            leftToRight *= arr[i];
            rightToLeft *= arr[n-i-1];
            maxProd = Math.max(maxProd, Math.max(leftToRight, rightToLeft));
        }
        System.out.println(maxProd);
    }
}
