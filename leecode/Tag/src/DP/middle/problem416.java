/** 分割等和子集
 *  给你一个只包含正整数的非空数组 nums。
 *  请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
 */

package DP.middle;

import java.util.Arrays;

public class problem416 {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
    }

    //这种解法只能过一半  67/117
//    public static boolean canPartition(int[] nums) {
//        Arrays.sort(nums);
//
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum+=nums[i];
//        }
//
//        int subSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            subSum += nums[i];
//            sum -= nums[i];
//            if (subSum == sum) return true;
//        }
//        return false;
//    }

    //动态规划版
    //背包体积是sum/2；背包里要放入的商品重量是数组元素的数值，价值也是数组元素的数值；
    //背包如果正好装满，说明找到了总和为sum/2的子集
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if (sum % 2 == 1) return false; //总和如果是奇数，那么不会有相等的两个子集。

        int tiji = sum / 2;
        int[] dp = new int[tiji+1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = tiji; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[tiji]==tiji;

    }




}
