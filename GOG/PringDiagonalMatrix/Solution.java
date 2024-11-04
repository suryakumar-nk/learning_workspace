package GOG.PringDiagonalMatrix;

public class Solution {

    public int[] matrixDiagonally(int[][] mat) {
        char d = 'u';
        int n = mat.length;
        int m = mat[0].length;
        int[] arr = new int[n*m];
        int i=0, j = 0, k = 0;
        while (k < (n*m)) {
            arr[k++] = mat[i][j];
            if (d == 'u') {
                if (i == 0 && j < m-1) {
                    j++;
                    d = 'd';
                }
                else if (j == m-1) {
                    i++;
                    d = 'd';
                } else {
                    i--; j++;
                }
            } else {
                if (j == 0 && i < n-1) {
                    i++;
                    d = 'u';
                }
                 else if (i == n-1) {
                     j++;
                     d = 'u';
                 } else {
                     i++; j--;
                 }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new Solution().matrixDiagonally(arr));
    }
}
