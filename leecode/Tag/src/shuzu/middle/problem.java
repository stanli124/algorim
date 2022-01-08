/** 子集
 *  给定一个整数数组nums，数组中的元素互不相同。返回该数组所有可能的子集。
 *  解集不能包含重复的子集，你可以按照任意顺序返回该解集。
 */

package shuzu.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class problem {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3,4}));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        int len = nums.length;
        List<List<Integer>> all = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len-i; j++) {
                ArrayList<Integer> one = new ArrayList<>();
                for (int k = 0; k <=i ; k++) {
                    one.add(nums[j+k]);
                }
                all.add(one);
            }
        }

        return all;

    }

}
