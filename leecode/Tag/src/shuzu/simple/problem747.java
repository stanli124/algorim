/** 至少是其他数字两倍的最大数
 *  给你一个整数数组nums，其中总是存在唯一的一个最大整数；
 *  找出数组的最大元素，并检查它是否至少是数组中每个其它数组的两倍
 */

package shuzu.simple;

import java.util.Arrays;

public class problem747 {
    public static void main(String[] args) {

        System.out.println(dominantIndex(new int[]{2,0,0,3}));

    }

    public static int dominantIndex(int[] nums) {
         //想在一个循环内同时找出最大值和第二大值
//        int i = nums.length;
//        if (i==1) return 0;
//
//        int indexMax = 0;
//        int indexMid = 0;
//        int saveIndex = -1;
//
//        for (int j = 1; j < i; j++) {
//            if (nums[j] >= nums[indexMax]) indexMax = j;
//            if (nums[j] >= nums[indexMid]) {
//                saveIndex = indexMid;
//                indexMid=j;
//            }
//            if (indexMax == indexMid) indexMid = saveIndex;
//        }
//
//        if (nums[indexMid]==0) return indexMax;
//        if (nums[indexMid]*2 <= nums[indexMax]) return indexMax;
//
//        return -1;

        int i = nums.length;
        if (i==1) return 0;
        int indexMax = 0;
        int indexMid = 0;
        int v = -100;

        for (int j = 0; j < i; j++) {
            if (nums[j] >= v) {
                v = nums[j];
                indexMax = j;
            }
        }

        v = -100;
        for (int j = 0; j < i; j++) {
            if (nums[j] >= v && j!=indexMax) {
                v = nums[j];
                indexMid = j;
            }
        }

        if (nums[indexMid]==0) return indexMax;
        if (nums[indexMid]*2 <= nums[indexMax]) return indexMax;

        return -1;

    }

}
