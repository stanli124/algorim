/** 搜索插入位置
 *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */

package shuzu.simple;

public class problem35 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,0};
        System.out.println(searchInsert(nums,2));
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]){
                return i;
            }
        }
        return nums.length;
    }

}
