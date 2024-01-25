package rotateArray;

public class Solution {
    public static void rotate(int[] nums, int k) {
        int arrLength = nums.length;
        k = k % arrLength;
        if (k == 0) return;
        int[] newArr = new int[arrLength];
        int j = 0;
        for (int i = 0; i < arrLength; i++) {
            j = i + k;
            j = j >= arrLength ? j - arrLength : j;
            newArr[j] = nums[i];
        }
        for (int i = 0; i < arrLength; i++) {
            nums[i] = newArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 3);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
