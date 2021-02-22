package main.java.com.yuda.train;

/**
 * @author canyu
 * @create_date 2021/2/22 9:32
 */
public class Solution70 {
    public int climbStairs(int n) {
        int result = 1;
        int one = 0;
        int two = 0;
        for (int i = 0; i < n; i++) {
            one = two;
            two = result;
            result = one + two;
        }
        return result;
    }
}
