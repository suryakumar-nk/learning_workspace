package MakeSumDivisibleByP;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000};
        int p = 75;
        int n = nums.length;
        long sum = 0;
        for (int i=0; i<n; i++) {
            sum+=nums[i];
        }
        if (sum % p == 0) {
            System.out.println(0);
            return;
        }
        int l = 1;
        while (l < n) {
            long subSum = 0;
            int firstElementIndex = 0;
            for (int i=0; i<l; i++)
                subSum+=nums[i];
            for (int i=l; i<=n; i++) {
                if ((sum-subSum) % p == 0) {
                    System.out.println(l);
                    System.out.println(sum);
                    System.out.println(subSum);
                    return;
                }
                if (i!=n)
                    subSum = subSum - nums[firstElementIndex++] + nums[i];
            }
            l++;
        }
        System.out.println(-1);
    }
}
