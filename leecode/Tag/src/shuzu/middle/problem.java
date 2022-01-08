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
        if (len == 0) return all;
        all.add(Arrays.asList(nums[0]));

        for (int i = 1; i < len; i++) {
            int l_size = all.size();
            for (int j = 0; j < l_size; j++) {  //遍历当前所有子集
                ArrayList<Integer> one = new ArrayList<>(all.get(j));
                one.add(nums[i]); //给每个子集都加上当前元素；
                all.add(one);
            }
            //加上当前元素
            all.add(Arrays.asList(nums[i]));
        }
        all.add(new ArrayList<>());
        return all;

    }

}
