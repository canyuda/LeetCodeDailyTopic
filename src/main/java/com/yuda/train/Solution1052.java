package main.java.com.yuda.train;

/**
 * @author canyu
 * @create_date 2021/2/23 21:39
 */
public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        // 计算一定满意的客户数
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        // 初始化窗口
        int other = 0;
        for (int i = 0; i < X; i++) {
            other += customers[i] * grumpy[i];
        }
        int max = other;
        // 移动窗口求最大
        for (int i = X; i < customers.length; i++) {
            other = other - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
            max = Math.max(max, other);
        }
        return total + max;
    }
}
