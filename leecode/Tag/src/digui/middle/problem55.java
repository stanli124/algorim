package digui.middle;

import java.util.Arrays;

public class problem55 {

    boolean[] memo;
    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,0,4};
        System.out.println(canJump(nums));
    }

//    public boolean canJump(int[] nums) {
//        memo = new boolean[nums.length];
//
//        return dp(nums, 0, memo);
//    }
//
//    //nums[i]的取值范围是[0, 10的五次方]，所以循环的话会超时
//    public boolean dp(int[] nums, int index, boolean[] memo){
//        if (index == nums.length-1) return true;
//        if (index > nums.length-1) return false;
//        if (memo[index]) return true;
//
//        for (int i = 1; i <= nums[index]; i++) {
//            if (dp(nums, index+i, memo)) {
//                memo[index] = true;
//            }
//        }
//
//        return memo[index];
//    }

    public static boolean canJump(int[] nums){
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n-1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest <= i) return false;
        }
        return farthest >= n-1;
    }

}
