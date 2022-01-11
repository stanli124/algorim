/** 递增的三元子序列
 *  给你一个整数数组nums，判断这个数组中是否存在长度为3的递增子序列；
 *  若存在这样的三元组下标，i<j<k，且nums[i]<nums[j]<nums[k]，则返回true；
 */

package shuzu.middle;

public class problem334 {


    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{5,4,3}));
    }

    public static boolean increasingTriplet(int[] nums) {
        //暴力解法
//        int len = nums.length;
//
//        for (int i = 0; i < len-1; i++) {
//            if (nums[i]==nums[i+1]) continue;
//            if (i < len-3 && nums[i]==nums[i+2] && nums[i+1]==nums[i+3]) continue;
//            for (int j = i+1; j < len; j++) {
//                if (nums[j] < nums[i]) continue;
//                for (int k = j+1; k < len; k++) {
//                    if (nums[k] < nums[j]) continue;
//                    if (nums[i] < nums[j] && nums[j] < nums[k]) return true;
//                }
//            }
//        }
//        return false;


        //
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= small)small=nums[i]; //如果比small小则赋值给small
            else if(nums[i] <= mid)mid=nums[i]; //如果比mid小则赋值给mid；到这里就已经满足i<j;
            else if(nums[i] > mid)return true; //如果k>j，则有该三元组；
        }
        return false;

    }
}
