/** 不同路径2
 *  一个机器人位于一个 m*n网格的左上角
 *  机器人每次只能向下或向右移动一步。机器人试图到达网格的右下角
 *  考虑网格中有障碍物，那么从左上角到右下角有多少条不同的路径
 *  网格中障碍物和空位置分别用 1和0表示
 *
 */

package DP.middle;

public class problem63 {
    //有障碍物位置的对应dp数组 初始化为0
    public static void main(String[] args) {
//        System.out.println(uniquePathsWithObstacles(new int[][]{{0,0},{1,1},{0,0}}));
        System.out.println(dfs(0,0,3,3, new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        boolean rowFlag = false; //如果初始化行有障碍，那么障碍后面的都是0
        boolean colFlag = false; //如果初始化列有障碍，那么障碍后面的都是0

        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) { //初始化第一行
            if (obstacleGrid[0][i]==1) rowFlag=true;
            if (rowFlag) dp[0][i] = 0;
            else dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) { //初始化第一列
            if (obstacleGrid[i][0]==1) colFlag=true;
            if (colFlag) dp[i][0] = 0;
            else dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static int dfs(int i, int j, int m, int n, int[][] obstacleGrid){
        if (i > m-1 || j > n-1) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if (i == m-1 && j==n-1) return 1;
        return dfs(i+1, j, m, n, obstacleGrid) + dfs(i, j+1, m, n, obstacleGrid);
    }


}
