/** 丢失的数字
 *  给定一个包含[0,n]中n个数的数组nums，找出在[0,n]这个范围内没有出现在数组中的那个数
 *
 */

package shuzu.simple;

public class problem268 {

    public static void main(String[] args) {

        System.out.println(missingNumber(new int[]{3,0,1}));
    }

    public static int missingNumber(int[] nums) {

        int len = nums.length;

        int[] missNum = new int[len+1];

        for (int i = 0; i < len; i++) {
            missNum[nums[i]] = 1;
        }

        for (int i = 0; i <= len; i++) {
            if (missNum[i]==0) return i;
        }

        return 0;
    }

}
