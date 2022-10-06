package JianZhiOffer;

//n个骰子的点数

public class Q60 {

    public static void main(String[] args) {

    }

    public double[] dicesProbability(int n) {
        int[][] dp = new int[n+1][6*n+1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= 6*i; j++) {
                for (int k = 1; k <= 6 && k <= j ; k++) {
                    //k是模拟当前投掷第i个骰子可能出现的点数，总共6个点数
                    //j是i个骰子可能会掷出的点数，所以当前骰子掷出的点数必须<=j；如当前掷出k，前i-1个骰子就只能掷出j-k；
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }

        double[] ans = new double[6*n  - n+1];
        for (int i = n; i <= 6*n; i++) {
            ans[i-n] = ((double)dp[n][i] / Math.pow(6,n));
        }
        return ans;

    }

}
