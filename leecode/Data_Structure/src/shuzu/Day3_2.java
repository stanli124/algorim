/**
 * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * 在数组中挑选一只股票买入，买入之后就只能从数组后面选择一个最高价格卖出。
 *
 * 相当于找数字对，这个数字对的后一个数值减去前一个数值的差值要最大，就返回这个差值；如果差值<=0 就返回0值；
 *
 */


package shuzu;

import java.util.Arrays;
import java.util.HashMap;

public class Day3_2 {

    public static void main(String[] args) {

        int[] prices = new int[]{2,1,2,0,1};

        long startTime = System.currentTimeMillis();
        System.out.println(maxProfit(prices));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");

    }

    public static int maxProfit(int[] prices) {


        //使用hashmap的方法不行，因为会遇到有重复价格的情况，而hashmap无法保证两个相同的键，也就没办法记录相同键的不同索引；
//        HashMap<Integer, Integer> numIndex = new HashMap<>();   //保存数组的值及其索引 值->索引
//        int len = prices.length;
//        int maxValue = 0;
//
//        for (int i = 0; i < len; i++) {
//            if (numIndex.containsKey(prices[i])) continue;
//            else numIndex.put(prices[i] , i);
//        }
//
//        Arrays.sort(prices); //对价格排序
//
//        int j = len-1;
//        for (int i = 0; i < len-1; i++) {
//
//            while (j > i){ //从后向前，不能到达i所指的值；因为那个值是数字对中的另一个数值；
//                if (numIndex.get(prices[j]) > numIndex.get(prices[i])){    //去映射找索引关系，要满足卖出的价格在买入的价格前面
//                    maxValue = (prices[j] - prices[i])>maxValue?(prices[j] - prices[i]):maxValue;
//
//                }
//                j--;
//            }
//            j = len - 1;
//
//        }
//
//        return maxValue;

        //这个方法可以通过测试用例，但是超时了；
//        int maxValue = 0;
//        int len = prices.length;
//
//        for (int i = 0; i < len-1; i++) {
//            for (int j = i+1; j < len; j++) {
//                if (prices[j] - prices[i] > maxValue) maxValue = prices[j] - prices[i];
//            }
//        }
//        return maxValue;

        int minPrice = prices[0];
        int len = prices.length;
        int max_Profit = 0;

        for (int i = 1; i < len; i++) {
            if (prices[i] <= minPrice) minPrice = prices[i];
            else max_Profit = (prices[i]-minPrice)>max_Profit?(prices[i]-minPrice):max_Profit;
        }
        return max_Profit;
    }

}
