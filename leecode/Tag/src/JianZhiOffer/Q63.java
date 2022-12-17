package JianZhiOffer;

public class Q63 {

    //股票的最大利润
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        //暴力解法
//        int max = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i+1; j < prices.length; j++) {
//                if (prices[j] - prices[i] > max) max = prices[j] - prices[i];
//            }
//        }
//
//        return max;

        //动态规划
        if (prices.length == 0) return 0;
        int[] dp = new int[prices.length];

        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            dp[i] = Math.max(dp[i-1], prices[i] - min);
        }
        return dp[prices.length-1];
    }

}
