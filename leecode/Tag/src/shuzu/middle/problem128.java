/**
 * 最长连续序列
 * 给定一个未排序的整数数组 nums， 找出数字连续的最长序列(不要求序列元素在原数组中连续)的长度
 */

package shuzu.middle;

import java.util.Arrays;

public class problem128 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,0,1};
        int res = longestConsecutive(nums);
        System.out.println(res);
    }

    //先排序，再遍历
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);

        int maxLen = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            //排完序后，有相同的值就跳过
            if (nums[i] - nums[i-1]==0){
                continue;
            }
            else if (nums[i] - nums[i-1] != 1){
                maxLen = maxLen > count ? maxLen : count;
                count=1;
            }else {
                count++;
            }
        }

        return maxLen > count ? maxLen : count;

    }




    //有负数，不能使用这种方法，没有负数的下标。
//    public static int longestConsecutive(int[] nums) {
//        int[] res = new int[100000];
//        for (int i = 0; i < nums.length; i++) {
//            res[nums[i]] = 1;
//        }
//
//        int maxLen = 0;
//
//        int count = 0;
//        for (int i = 0; i < res.length; i++) {
//
//            if (res[i] == 0){
//                maxLen = maxLen > count ? maxLen : count;
//                count=0;
//            }else {
//                count++;
//            }
//        }
//
//        return maxLen;
//    }


}
