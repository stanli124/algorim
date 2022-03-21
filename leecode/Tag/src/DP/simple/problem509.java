package DP.simple;

public class problem509 {

    public static void main(String[] args) {
        System.out.println(fib(0));
    }

    public static int fib(int n) {
        if(n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

}
