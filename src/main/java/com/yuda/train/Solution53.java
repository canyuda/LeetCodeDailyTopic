package com.yuda.train;

/**
 * @author canyu
 * @create_date 2021/1/28 23:33
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
