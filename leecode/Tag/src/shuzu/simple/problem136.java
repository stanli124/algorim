/** 只出现一次的数字
 *  给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 *  找出那个只出现一次的元素。
 */

package shuzu.simple;

import java.util.ArrayList;
import java.util.Arrays;

public class problem136 {

    public static void main(String[] args) {
        int[] nums = new int[]{1};

        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len==1) return nums[0];

        for (int i = 0; i <= nums.length-1; i+=2) {
//            if (i==len-1) return nums[len-1]; //处理数组是奇数个的情况，遍历到最后一个元素后，数组会越界。
            if (i==len-1 || nums[i] != nums[i+1]) return nums[i];
        }
        return 0;
    }

}
