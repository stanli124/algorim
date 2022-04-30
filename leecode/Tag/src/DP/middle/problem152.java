/** 乘积最大子数组
 *  给你一个整数数组nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字）
 *  返回该子数组所对应的乘积。
 */

package DP.middle;

public class problem152 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 10, -1};
        System.out.println(maxProduct(nums));
    }

    //对于有连续负数的数组，未考虑偶数个负数相乘为正的情况。
//    public static int maxProduct(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        int max = nums[0];
//
//
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i-1]*nums[i], nums[i]);
//            if (dp[i] > max) max = dp[i];
//        }
//        return max;
//    }

    public static int maxProduct(int[] nums){
        int[] dp_max = new int[nums.length];
        int[] dp_min = new int[nums.length];

        dp_max[0] = dp_min[0] = nums[0];
        int max = nums[0];


        for (int i = 1; i < nums.length; i++) {
            dp_max[i] = Math.max(Math.max(dp_max[i-1]*nums[i], dp_min[i-1]*nums[i]), nums[i]);
            dp_min[i] = Math.min(Math.min(dp_max[i-1]*nums[i], dp_min[i-1]*nums[i]), nums[i]);
            if (dp_max[i] > max) max = dp_max[i];
        }

        return max;
    }


}
