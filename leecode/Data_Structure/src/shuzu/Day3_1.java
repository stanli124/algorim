/** 两个数组的交际
 *
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * 返回的交集中每个元素都需要在 两个整数数组中出现，且每个元素在两个数组中出现的次数应该一致，若某元素在两个数组中出现的次数不一致，则考虑取较小值；
 * 交集是指元素大于等于2？
 *
 */


package shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3_1 {
    public static void main(String[] args) {

        int[] nums1 = new int[]{3,1,2};
        int[] nums2 = new int[]{1,1};

        long startTime = System.currentTimeMillis();
        System.out.println(intersect(nums1, nums2));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        //遍历两个数组，若数组1的第一个元素等于数组2的第一个元素，则索引加1比较后面的数；若不等，则后移数组2的索引，继续比较数组1的第一个值和数组2的第二个值，若相等则两个数组的索引都加1，否则数组2的索引加1； 以此类推；该想法行不通；
//        int i = 0;
//        int j = 0;
//
//        int minLen = 0;
//        int maxLen = 0;
//        if (nums1.length > nums2.length) {
//            minLen = nums2.length;
//            maxLen = nums1.length;
//        }
//        ArrayList<Integer> Intersection = new ArrayList<>();
//        while (i<nums1.length && j< nums2.length){
//        }
//        return new int[]{};

        //一个ArrayList中包含一个数组的所有值；用另一个数组中的值来和ArrayList中的匹配，若包含该值就

//        List<Integer> list1 = new ArrayList<>();
//        for (int num : nums1) {
//            list1.add(num);
//        }
//        List<Integer> list2 = new ArrayList<>();
//        for (int num : nums2) {
//            if (list1.contains(num)) {
//                list2.add(num);
//                // 从 list1 除去已匹配的数值
//                list1.remove(Integer.valueOf(num));
//            }
//        }
//        int[] res = new int[list2.size()];
//        int i = 0;
//        for (int num : list2) {
//            System.out.println(num);
//            res[i++] = num;
//        }
//        return res;

        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        List<Integer> final_r = new ArrayList<>();


        for (int num1: nums1) list1.add(num1);
        for (int num2: nums2) list2.add(num2);

        if (list1.size() > list2.size()){
            list2.retainAll(list1);
            int[] a = new int[list2.size()];
            for (int i = 0; i < list2.size(); i++) {
                a[i] = list2.get(i);
            }
//            for (int i : a) System.out.println(i);

            return Arrays.stream(a).distinct().toArray();

        }
        else {
            list1.retainAll(list2);
            int[] a = new int[list1.size()];
            for (int i = 0; i < list1.size(); i++) {
                a[i] = list1.get(i);
            }
//            for (int i : a) System.out.println(i);

            return Arrays.stream(a).distinct().toArray();
        }


    }
}
