/** 假设你正在爬楼梯，需要n阶你才能到达楼顶
 * 每次你可以爬1步或者两步台阶，有多少种不同的方法可以爬到楼顶呢？
 *
 */

package DP.simple;

public class problem70_2 {

    public static void main(String[] args) {
        System.out.println(climbStairs(13));
    }

    public static int climbStairs(int n) {
        if (n<=2) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
