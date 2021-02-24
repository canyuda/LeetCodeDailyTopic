package main.java.com.yuda.train;

/**
 * @author canyu
 * @create_date 2021/2/24 8:07
 */
public class Solution832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int rowLength = A[i].length;
            for (int j = 0; j < rowLength / 2; j++) {
                // 翻转
                int temp = A[i][j];
                A[i][j] = A[i][rowLength - 1 - j];
                A[i][rowLength - 1 - j] = temp;
                // 取反
                A[i][j] = A[i][j] == 1 ? 0 : 1;
                A[i][rowLength - j - 1] = A[i][rowLength - j - 1] == 1 ? 0 : 1;
            }
            if (rowLength % 2 == 1) {
                A[i][rowLength / 2] = A[i][rowLength / 2] == 1 ? 0 : 1;
            }
        }
        return A;
    }
}
