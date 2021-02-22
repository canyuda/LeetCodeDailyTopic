package main.java.com.yuda.train;

/**
 * @author canyu
 * @create_date 2021/2/19 9:15
 */
public class Solution1004 {
    public int longestOnes(int[] A, int K) {
        int low = 0;
        int high = 0;
        int currentK = K;
        int maxLength = K;
        while (high < A.length) {
            if (A[high] == 0) {
                if (currentK == 0) {
                    while (A[low] == 1) {
                        low++;
                    }
                    low++;
                } else {
                    currentK--;
                }
            }
            maxLength = Math.max(maxLength, ++high - low);
        }
        return maxLength;
    }
}
