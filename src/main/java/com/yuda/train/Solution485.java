package main.java.com.yuda.train;

/**
 * @author canyu
 * @create_date 2021/2/20 20:43
 */
public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l = 0;
        int h = 0;
        int maxCount = 0;
        while (h < nums.length) {
            if (nums[h] == 1) {
                h++;
                maxCount = Math.max(h - l, maxCount);
            } else {
                h++;
                l = h;
            }
        }
        return maxCount;
    }
}
