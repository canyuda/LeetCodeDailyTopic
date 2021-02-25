package main.java.com.yuda.train;

/**
 * @author canyu
 * @create_date 2021/2/25 11:58
 */
public class Solution867 {
    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] newMatrix = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }
        return newMatrix;
    }
}
