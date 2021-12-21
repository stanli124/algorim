/**
 * 两数之和
 * 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出 和为目标值target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *[2,7,11,15]
 * 你可以按任意顺序返回答案。
 *
 */

package shuzu;

import java.util.HashMap;

public class Day2_1 {


    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2,7,11,15}, 9)[1]);
    }

    public static int[] twoSum(int[] nums, int target){
        //使用hashmap存储target-x和当前x索引的映射；
        HashMap<Integer, Integer> target_sub_x = new HashMap(nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            if (target_sub_x.containsKey(nums[i])){   //如果有键等会当前的值，则返回索引；
                return new int[]{target_sub_x.get(nums[i]), i};
            }
            else target_sub_x.put(target - nums[i], i);
        }

        return new int[]{0,0};

    }

}
