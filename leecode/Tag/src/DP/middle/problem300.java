/**
 * 最长递增子序列
 * 给你一个整数数组 nums，找到其中最长严格递增子序列的长度
 */

package DP.middle;

import java.util.Arrays;

public class problem300 {

    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        problem300 a = new problem300();
        System.out.println(a.lengthOfLIS(nums));
    }


    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;//每个元素的其自身的最长递增子序列的长度为1
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = dp[i] > maxLen ? dp[i] : maxLen;
        }
        return maxLen;
    }


}
