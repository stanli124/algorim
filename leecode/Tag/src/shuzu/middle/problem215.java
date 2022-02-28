/** 数组中的第k个最大元素
 *  给定整数数组nums和整数k，请返回数组中第k个最大的元素。
 *  返回数组排序后的第k个最大的元素，而不是第k个不同的元素。
 *
 */

package shuzu.middle;

import java.util.Arrays;

public class problem215 {


    public static void main(String[] args) {
        int m = findKthLargest(new int[]{1}, 1);
        System.out.println(m);
    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (k < 1 || k >len) return 0;

        Arrays.sort(nums);
        return nums[len - k];
    }

}
