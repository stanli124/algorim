/** 两个数组的交际
 *
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * 返回的交集中每个元素都需要在 两个整数数组中出现，且每个元素在两个数组中出现的次数应该一致，若某元素在两个数组中出现的次数不一致，则考虑取较小值；
 * 交集是指元素大于等于2？
 *
 *
 * 这里的交集指 交集数组中的每个元素都必须在两个数组中出现，若某值只单独存在于某一个数组中，那么它不会出现在交集数组中；比如4在数组1中出现2次，在数组2中出现5次，那么在交集数组中它只出现2次。若4在数组1和数组2中都出现3次，那么4在交集数组中要出现3次；
 *
 */


package shuzu;

import java.util.*;

public class Day3_1 {
    public static void main(String[] args) {

        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

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



        //这个方法是错误的
//        List<Integer> list1 = new ArrayList<Integer>();
//        List<Integer> list2 = new ArrayList<Integer>();
//        List<Integer> final_r = new ArrayList<>();
//
//
//        for (int num1: nums1) list1.add(num1);
//        for (int num2: nums2) list2.add(num2);
//
//        if (list1.size() > list2.size()){
//            list2.retainAll(list1);
//            int[] a = new int[list2.size()];
//            for (int i = 0; i < list2.size(); i++) {
//                a[i] = list2.get(i);
//            }
////            for (int i : a) System.out.println(i);
//
//            return Arrays.stream(a).distinct().toArray();
//
//        }
//        else {
//            list1.retainAll(list2);
//            int[] a = new int[list1.size()];
//            for (int i = 0; i < list1.size(); i++) {
//                a[i] = list1.get(i);
//            }
////            for (int i : a) System.out.println(i);
//
//            return Arrays.stream(a).distinct().toArray();
//        }

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        List<Integer> final_r = new ArrayList<>();

        for (int num : nums1){
            if (map1.containsKey(num)) map1.put(num, map1.get(num)+1);
            else map1.put(num, 1);
        }
        for (int num : nums2){
            if (map2.containsKey(num)) map2.put(num, map2.get(num)+1);
            else map2.put(num, 1);
        }

        Set jiaoJi = map1.keySet();
        jiaoJi.retainAll(map2.keySet());  //得到交集
        Iterator it = jiaoJi.iterator();

//        System.out.println(jiaoJi.toString());

        int num = 0;
        while (it.hasNext()){
            num = (int) it.next(); //键
            if (map1.get(num) >= map2.get(num)) {
                for (int i = 0; i < map2.get(num); i++) {
                    final_r.add(num);
                }
            }
            else {
                for (int i = 0; i < map1.get(num); i++) {
                    final_r.add(num);
                }
            }
        }

        int[] re = new int[final_r.size()];
        for (int i = 0; i < final_r.size(); i++) {
            re[i] = final_r.get(i);
        }
//        for (int i : re) System.out.println(i);
        return re;

    }
}
