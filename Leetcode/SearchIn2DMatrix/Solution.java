package Leetcode.SearchIn2DMatrix;

public class Solution {
    public static void main(String[] args) {
        // int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int[][] arr = {{1},{3}};
        int target = 0;
        int end = arr.length-1;
        int start = 0;
        int mid = 0;
        while (start < end) {
            mid = (start+end)/2;
            if (target == arr[mid][0]) {
                System.out.println(true);
                return;
            }
            if (target < arr[mid][0]) {
                end = mid-1;
                mid = end;
            } else {
                start = mid+1;
                if (target < arr[start][0]) {
                    break;
                }
                mid = start;
            }
        }
        int row = mid >= 0 ? mid : 0;
        start = 0;
        end = arr[row].length-1;
        while (start <= end) {
            mid = (start+end)/2;
            if (target == arr[row][mid]) {
                System.out.println(true);
                return;
            }
            if (target > arr[row][mid]) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        System.out.println(false);
    }
}
