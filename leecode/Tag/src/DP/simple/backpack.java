package DP.simple;

public class backpack {

    public static void main(String[] args) {
        int[] weight = new int[]{2,3,4,5};
        int[] value = new int[]{3,4,5,6};
        int maxW = 8;

        backpack test = new backpack();
        System.out.println(test.bag02(weight, value, maxW));

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

    //一维dp数组解法
    public int bag02(int[] w, int[] v, int maxWeight) {
        int[] dp = new int[maxWeight+1];

        //初始化；
        for (int i = 1; i < maxWeight+1; i++) {
            if (i >= w[0]) dp[i] = v[0]; //若当前背包重量能放得下第0个物品，那么当前背包重量的最大价值就第0个物品的价值
        }

        //不要初始化，i就从0下标开始
        for (int i = 1; i < w.length; i++) { //i从第一个开始是因为，在初始化的时候以及计算了第0个物品的情况
            for (int j = maxWeight; j >= w[i]; j--) { //倒序遍历不会把一个物品重复放背包
                //如果当前背包承受重量 小于 当前要放入物品的重量，那么无法放入该物品就结束循环；因为是倒序，所以后面的也不可能放下
                dp[j] = Math.max(dp[j], dp[j - w[i]]+v[i]);
            }
        }


        return dp[maxWeight];
    }



}
