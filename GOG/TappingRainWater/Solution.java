package GOG.TappingRainWater;

public class Solution {
    public long trappingWater(int arr[], int n) { 
        // Your code here
        int lm = 0, rm = 0;
        long res = 0;
        int l = 0, r = n-1;
        while (l <= r) {
            if (arr[l] <= arr[r]) {
                if (arr[l] >= lm) {
                    lm = arr[l];
                } else {
                    res = res + lm - arr[l];
                }
                l++;
            } else {
                if (arr[r] >= rm) {
                    rm = arr[r];
                } else {
                    res = res + rm - arr[r];
                }
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var solution = new Solution();
        System.out.println(solution.trappingWater(new int[]{4,2,0,3,2,5,6,1,2,3,4}, 11));
    }
}
