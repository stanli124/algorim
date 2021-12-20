/**
 * 给定一个整数数组，请找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */

package shuzu;

import java.util.Arrays;

public class Day1_2 {

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        long startTime = System.currentTimeMillis();
        System.out.println(maxSubArray(nums));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");
    }
    public static int maxSubArray(int[] nums){
        //使用滑动窗口的方式，窗口大小从1到数组的大小；该方法在数组特别大的时候，超出时间限制了；
//        int maxValue = -1000;
//        for (int i = 1; i <= nums.length ; i++) {
//            for (int j = 0; j < nums.length; j+=1) {
//                int slideWindowSum = 0;
//                for (int k = j; k < j+i && k < nums.length; k++) {
//                    slideWindowSum+=nums[k];
//                }
//                if (slideWindowSum > maxValue) maxValue = slideWindowSum;
//            }
//        }
//        return maxValue;



        //直接从头开始遍历，若当前值的和大于最大值，则更新最大值；若当前值没有最大值大，则清0当前值，用后面的值加，直到遍历完数组中所有值。 这个方法有问题
//        int maxValue_ = 0;
//        int maxValue = -10000;
//        int curSum = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            curSum += nums[i];
//            if (curSum > maxValue) maxValue = curSum;
//            else {
//                maxValue_ = maxValue;
//                curSum = 0;
//                maxValue = -10000;
//            }
//        }
//        if (maxValue > maxValue_) return maxValue;
//
//        return maxValue_;




        //动态规划
        int[] fn = new int[nums.length + 1];
        int max = -10000;
        fn[0] = max;

        for (int i = 1; i <= fn.length-1; i++) {
            max = (fn[i-1]+nums[i-1])>nums[i-1]?(fn[i-1]+nums[i-1]):nums[i-1];
//            max = max>fn[i-1]?max:fn[i-1];   //如果加了这个比较，那么就不是连续子数组的最大和了；
            fn[i] = max;
        }
        Arrays.sort(fn);
        return fn[fn.length-1];


    }

}
