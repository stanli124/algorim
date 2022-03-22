package DP.middle;

public class problem96 {

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }

    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int inx = i;
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[--inx];
            }
        }

        return dp[n];
    }

}
