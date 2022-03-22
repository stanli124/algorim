package DP.simple;

public class backpack {

    public static void main(String[] args) {
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        int maxW = 10;

        backpack test = new backpack();
        System.out.println(test.bag01(weight, value, maxW));

    }

    public int bag01(int[] w, int[] v, int maxWeight){
        int nums = w.length;
        //初始化第0行
        int[][] dp = new int[nums][maxWeight+1];

        //dp数组默认初始化为0，可以不用这个循环把第0列初始化为0
//        for (int i = 0; i < nums; i++) {
//            dp[i][0] = 0; //初始化第0列，表示背包重量为0时，无法加入任何一个物品
//        }

        for (int i = 0; i <= maxWeight; i++) {
            if (i >= w[0]) dp[0][i] = v[0]; //初始化第0行，
        }

        //递推顺序
        for (int i = 1; i < nums; i++) { //从第下标为1的物品开始。
            for (int j = 1; j <= maxWeight; j++) { //依次便利重量1->maxWeight
                if (j < w[i]) dp[i][j] = dp[i-1][j];  //当前物品不放入背包，是前i-个物品，重量为j时的最大价值；
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]); //放入当前物品，当前物品的价值 加上 前i-1个物品，重量为j-weight[i]的最大价值
            }
        }

        for (int i = 0; i < nums; i++) {
            System.out.println();
            for (int j = 0; j <=maxWeight ; j++) {
                System.out.printf(" " + dp[i][j]);
            }
        }

        return dp[nums-1][maxWeight];

    }

}
