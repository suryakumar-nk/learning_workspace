/*
 * Need to check in leetcode for submission
 */

package PathWithMinimumEffort;

public class Solution {

    public int minimumEffortPath(int[][] heights) {
        int diff = 0;
        if (heights.length == 0 || heights.length == 1 && heights[0].length == 1) return 0;
        if (heights.length == 1 && heights[0].length == 2) return diff(heights[0][0], heights[0][1]);
        if (heights.length == 2 && heights[0].length == 1) return diff(heights[0][0], heights[1][0]);
        var passed = new String("[0,0]");
        if (heights[0].length > 1) {
            System.out.println("right");
            diff = diff(heights[0][0], heights[0][1]);
            if (difference(heights, 0, 1, diff, passed) == true) return diff;
        }
        passed = new String("[0,0]");
        if (heights.length > 1) {
            System.out.println("left");
            diff = diff(heights[0][0], heights[1][0]);
            if (difference(heights, 1, 0, diff, passed) == true) return diff;
        }
        System.out.println("last");
        diff = heights[heights.length-1][heights[0].length-1];
        return diff;
    }

    private boolean difference(int[][] arr, int i, int j, int difference, String passed) {
        System.out.println("node "+i+" "+j);
        if (i >= arr.length || j >= arr[0].length) return false;
        if (i == arr.length-1 && j == arr[i].length-1) return true;

        passed = passed.concat("["+i+","+j+"]");

        if ((j+1) < arr[i].length && Boolean.FALSE.equals(passed.contains("["+i+","+(j+1)+"]"))) {
            int k = diff(arr[i][j], arr[i][j+1]);
            if (k == difference) {
                if (difference(arr, i, j+1, difference, passed) == true) return true;
            }
        }
        if ((i+1) < arr.length && Boolean.FALSE.equals(passed.contains("["+(i+1)+","+j+"]"))) {
            int k = diff(arr[i][j], arr[i+1][j]);
            if (k == difference) {
                if (difference(arr, i+1, j, difference, passed) == true) return true;
            }
        }
        if ((j-1) >= 0  && Boolean.FALSE.equals(passed.contains("["+i+","+(j-1)+"]"))) {
            int k = diff(arr[i][j], arr[i][j-1]);
            if (k == difference) {
                if (difference(arr, i, j-1, difference, passed) == true) return true;
            }
        }
        if ((i-1) >= 0 && Boolean.FALSE.equals(passed.contains("["+(i-1)+","+j+"]"))) {
            int k = diff(arr[i][j], arr[i-1][j]);
            if (k == difference) {
                if (difference(arr, i-1, j, difference, passed) == true) return true;
            }
        }
        return false;
    }

    private int diff(int a, int b) {
        int c = a - b;
        if (c < 0) return c*-1;
        return c;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[][] arr = {{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}};
        System.out.println(sol.minimumEffortPath(arr));
    }
}
