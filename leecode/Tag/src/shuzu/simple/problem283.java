package shuzu.simple;

import java.util.Arrays;

public class problem283 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,0,1};
        moveZeroes(nums);
    }

//    public static void moveZeroes(int[] nums) {
//        int len = nums.length;
//        if(len==1 || len==0) return ;
//
//        int j = 0;
//        int i = 0;
//
//        while(i<len && j<len){
//            while(j < len && nums[j]==0) //移动到要交换的值
//            {
//                j++;
//            }
//            if(i < len && j< len && i<j && nums[i]==0){
//                nums[i] = nums[j];
//                nums[j] = 0;
//            }
//            else
//                i++;
//        }
//    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        if(len==1 || len==0) return ;

        int[] shuzu = Arrays.copyOf(nums, len);
        int j=0;

        for(int i=0; i<len; i++){
            if (shuzu[i]!=0){
                nums[j++] = shuzu[i];
            }
        }

        while (j<len){
            nums[j++]=0;
        }

    }

    //官方解法
//    public void moveZeroes(int[] nums) {
//        int n = nums.length, left = 0, right = 0;
//        while (right < n) {
//            if (nums[right] != 0) {
//                swap(nums, left, right);
//                left++;
//            }
//            right++;
//        }
//    }
//
//    public void swap(int[] nums, int left, int right) {
//        int temp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = temp;
//    }


}
