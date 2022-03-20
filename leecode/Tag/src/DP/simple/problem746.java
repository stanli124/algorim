/** 给你一个整数数组cost,其中cost[i]是从楼梯第i哥台阶向上爬需要支付的费用
 *  一旦你支付此费用，即可选择向上爬一个或两个台阶。
 *  你可以选择从下标0或下标1的台阶开始爬楼梯
 */

package DP.simple;

public class problem746 {

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1,1,1,100,1,1,100,1}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < len+1; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
            System.out.println(dp[i]);
        }

        return dp[len];
    }

}
