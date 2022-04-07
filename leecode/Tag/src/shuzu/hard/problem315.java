/** 计算右侧小于当前元素的个数
 *  给你一个整数数组nums，按要求返回一个新数组counts。
 *  counts[i]的值是 nums[i]右侧小于nums[i]的元素的数量。
 */

package shuzu.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem315 {

    public static void main(String[] args) {
        int[] a = new int[]{2, 0, 1};
        countSmaller(a);
    }

    public static List<Integer> countSmaller(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();
        res.addFirst(0);
        int[] counts = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = help(i, nums, counts);
            counts[i] = count;
            res.addFirst(count);
        }

        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }

        return res;
    }

    public static int help(int index, int[] nums, int[] counts){
        int count = 0;
        if (nums[index] > nums[index+1]){
            count = 1 + counts[index+1];
        }else if (nums[index] <= nums[index+1]){
            int inx = index;
            while (index < counts.length && nums[inx] <= nums[index]) index++;
            if (index < counts.length && nums[inx] > nums[index]){
                count = 1 + counts[index];
            }
        }
        return count;
    }
}
