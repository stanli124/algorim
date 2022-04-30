package DP.middle;

import java.util.Arrays;

public class problem64 {

    public static void main(String[] args) {
        int[][] gird = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
//        int[][] gird = new int[][]{{1,1,1},{1,1,1}};
//        System.out.println(minPathSum(gird));
        System.out.println(minPathSum(gird, 1));
    }

    //动态规划解法
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        //初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        //初始化第一行
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i]+dp[0][i-1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j]+grid[i][j], dp[i][j-1] + grid[i][j]);
            }
        }

        return dp[m-1][n-1];
    }


    //递归+备忘录
    public static int minPathSum(int[][] grid, int k){

        int m = grid.length;
        int n = grid[0].length;

        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(grid, m-1, n-1, memo);
    }

    static int dp(int[][] grid, int i, int j, int[][] memo){
        if (i == 0 && j==0) return grid[0][0];
        if (i < 0 || j < 0) return Integer.MAX_VALUE;

        if (memo[i][j] != -1) return memo[i][j];

        memo[i][j] = Math.min(dp(grid, i-1, j, memo), dp(grid, i, j-1, memo)) + grid[i][j];

        return memo[i][j];
    }

}
