/**
 * 完全平方数
 * 给你一个整数n，返回和为n的完全平方数的最少数量
 */

package hot100.middle;

public class problem279 {

    public static void main(String[] args) {
        int n = 9;
        problem279 a = new problem279();
        System.out.println(a.numSquares(n));
    }


    public int numSquares(int n) {

//        //判断当前数字是不是完全平方数
//        for (int i = 1; i <= n; i++) {
//            double a = Math.sqrt(i);
//            int b = (int)a;
//            if (a-b==0){ //是完全平方数
//                System.out.println(i);
//            }
//        }
//
//        return 0;

        int[] dp = new int[n+1]; //第i个表示最少需要多个完全平方数来表示整数i；
        for (int i = 1; i <= n; i++) {
            int min = i; //每次最多需要i个完全平方数，1也是完全平方数
            for (int j = 1; i >= j*j; j++) {
                min = Math.min(min, dp[i - j*j]); //j*j表示一个完全平方数，dp[i-j*j]表示i-j*j这个数字最少要几个完全平方数
            }
            dp[i] = min+1;
        }

        return dp[n];
    }

}
