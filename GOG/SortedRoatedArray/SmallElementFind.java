package GOG.SortedRoatedArray;

import java.util.List;

public class SmallElementFind {

    private int getSmall(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            // The current subarray is already sorted,
            // the minimum is at the low index
            if (arr[low] <= arr[high])
                return arr[low];

            // We reach here when we have at least
            // two elements and the current subarray
            // is rotated
            int mid = (low + high) / 2;

            // The right half is not sorted. So
            // the minimum element must be in the
            // right half.
            if (arr[mid] > arr[high])
                low = mid + 1;

            // The right half is sorted. Note that in
            // this case, we do not change high to mid - 1
            // but keep it to mid. The mid element
            // itself can be the smallest
            else
                high = mid;
        }

        return arr[low];
    }
    
    public static void main(String[] args) {
        // int[] arr = {8,9,10,11,12,13,14,2,3,4,5,6,7};
        // int[] arr = {35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
        int[] arr = {5,1,2,3,4};
        int low = 0;
        int high = arr.length-1;
        int res = 0;
        while(low <= high) {
            if (high == low) {
                res = arr[low];
                break;
            }
            if (arr[low] < arr[high]) {
                res = arr[low];
                break;
            }
            int mid = (low+high)/2;
            if (mid !=0 && arr[mid] < arr[mid-1]) {
                res = arr[mid];
                break;
            }
            else if (mid < high && arr[mid] > arr[mid+1]) {
                res = arr[mid+1];
                break;
            }
            if (arr[mid] > arr[low]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        System.out.println(res);
        System.out.println(new SmallElementFind().getSmall(arr));
        System.out.println(new SmallElementFind().smallInList(List.of(5, 1, 2, 3, 4)));
    }

    private int smallInList(List<Integer> arr) {
        int low = 0;
        int high = arr.size();
        while (low < high) {
            if (arr.get(low) < arr.get(high)) {
                return low;
            }
            int mid = (low+high)/2;
            if (arr.get(mid) > arr.get(high)) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
