package DP.middle;

public class problem221 {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        problem221 a = new problem221();
        System.out.println(a.maximalSquare(matrix));
    }

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0'){
                    continue;
                }
                //当前矩阵位置的元素值为'1';
                dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
            }
        }

        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(dp[i][j]+" ");
                maxLen = Math.max(maxLen, dp[i][j]);
            }
            System.out.println();
        }


        return maxLen * maxLen;
    }

}
