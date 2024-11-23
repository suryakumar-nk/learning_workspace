package GOG.BitonicArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        int s = 0;
        int e = n-1;
        int p = -1;
        while (s <= e) {
            int mid = (s+e)/2;
            if (A.get(mid) > A.get(mid-1) && A.get(mid) > A.get(mid+1)) {
                p = mid;
                break;
            }
            if (A.get(mid) >= A.get(mid-1) && A.get(mid) <= A.get(mid+1)) {
                s = mid+1;
            } else {
                e = mid-1;
            }
        }
        System.out.println(p);
        if (A.get(p) == B)
            return p;
        if (B > A.get(p))
            return -1;
        if (B > A.get(0)) {
            s = 0;
            e = p;
            int mid = (s + e)/2;
            while (s <= e) {
                if (A.get(mid) == B) {
                    return mid;
                }
                if (B < A.get(mid)) {
                    e = mid-1;
                } else {
                    s = mid+1;
                }
                mid = (s + e)/2;
            }
        }
        if (B > A.get(n-1)) {
            s = p;
            e = n-1;
            int mid = (s + e)/2;
            while (s <= e) {
                if (A.get(mid) == B) {
                    return mid;
                }
                if (B < A.get(mid)) {
                    s = mid+1;
                } else {
                    e = mid-1;
                }
                mid = (s + e)/2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        // arr.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21));
        arr.addAll(List.of(1,2,3,4,5,6,4,2,1));
        System.out.println(new Solution().solve(arr, 9));
    }
}
