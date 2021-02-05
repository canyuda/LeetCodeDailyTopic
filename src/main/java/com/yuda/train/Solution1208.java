package com.yuda.train;

public class Solution1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int length = s.length();
        int[] costs = new int[length];
        for (int i = 0; i < length; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int start = 0, end = 0;
        int sum = 0;
        int maxLength = 0;
        while (end < length) {
            sum += costs[end];
            if (sum > maxCost) {
                sum -= costs[start];
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}
