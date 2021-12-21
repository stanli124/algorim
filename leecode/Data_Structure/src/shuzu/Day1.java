/**
 * 给定一个整数数组，判断是否存在重复元素；如果存在一值在数组中出现至少两次，函数返回true。如果数组中每个元素都不相同，则返回false。
 */
package shuzu;

import java.util.Arrays;
import java.util.HashSet;

public class Day1 {
    public static void main(String[] args) {

        int[] nums = {1,5,4,10,3,2,6,1};

        long startTime = System.currentTimeMillis();
        System.out.println(containsDuplicate(nums));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");


    }

    public static boolean containsDuplicate(int[] nums){
        //先排序，排序之后从前往后，每次按照顺序取两个数比较，若相同则返回true；若不同,则这两个指针依次往后移动1个；
        //该方法时间负责度和空间复杂度都相对高；
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i]==nums[i+1]) return true;
//        }
//        return false;

        //用一个set来存已有的值，若有重复值则返回true；
        HashSet<Integer> soleNum = new HashSet();
        for (int i : nums){
//            if (soleNum.contains(i)) return true;
//            else soleNum.add(i);

            //set的add方法若存在重复元素，那么会插入失败会返回false
            if (!soleNum.add(i)) return true;

        }
        return false;


    }

}
