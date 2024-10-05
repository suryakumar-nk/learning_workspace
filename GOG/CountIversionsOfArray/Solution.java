public class Solution {

    public long countAndMerge(long[] arr, int l, int m, int r) {
        int n1 = m-l+1, n2 = r-m;
        long[] left = new long[n1];
        long[] right = new long[n2];
        for (int i=0; i<n1; i++)
            left[i] = arr[i+l];
        for (int i=0; i<n2; i++)
            right[i] = arr[m+i+1];
        long res = 0;
        int i=0, j=0, k=l;
        while (i<n1 && j<n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                res += (n1-i);
            }
        }
        while (i<n1) {
            arr[k++] = left[i++];
        }
        while (j<n2) {
            arr[k++] = right[j++];
        }
        return res;
    }
    
    public long countInv(long[] arr, int l, int r) {
        long res = 0;
        if (l < r) {
            int m = (r + l) / 2;
            res += countInv(arr, l, m);
            res += countInv(arr, m + 1, r);
            res += countAndMerge(arr, l, m, r);
        }
        return res;
    }

    public static void main(String[] args) {
        long[] arr = {2, 4, 1, 3, 5, 5, 23, 7, 8, 45, 9, 1, 34, 65, 32, 51, 68, 69, 45, 21};
        System.out.println(new Solution().countInv(arr, 0, arr.length-1));
        for (long a: arr)
            System.out.println(a);
    }
}
