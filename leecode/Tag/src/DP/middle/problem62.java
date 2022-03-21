/** 不同路径
 *  一个机器人位于一个 m*n网格的左上角（起始点在途中start的地方）
 *  机器人每次只能向下或者向右移动一步，机器人试图到达网格的右下角
 *  总共有多少种不同的路径。
 */

package DP.middle;

public class problem62 {

    public static void main(String[] args) {
//        System.out.println((int)2*Math.pow(10, 9));
//        System.out.println(Integer.MAX_VALUE);
        System.out.println(uniquePaths(7, 3));
        System.out.println(dfs(0,0, 7,3));
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //初始化 第0行和第0列，0行只能一直向右走才能到，0列只有一直向下走才能到
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1; //0行初始化1
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1; //0列初始化为0
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[m-1][n-1];
    }

    public static int dfs(int i, int j, int m, int n){
        if (i > m-1 || j > n-1) return 0;
        if (i == m-1 && j==n-1) return 1;
        return dfs(i+1, j, m, n) + dfs(i, j+1, m, n);
    }

}
