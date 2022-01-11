/** 两个数组的交集
 *  给定两个数组，编写一个函数来计算它们的交集。
 */

package shuzu.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class problem349 {

    public static void main(String[] args) {

        int[] a = intersection(new int[]{1,2,2,1}, new int[]{2,2});
        for (int aa : a) System.out.println(aa);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> intersection1 = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len2==0 || len1==0) return new int[]{};

        for (int i = 0; i < len1; i++) {
            intersection1.add(nums1[i]);
        }
        for (int i = 0; i < len2; i++) {
            if (intersection1.contains(nums2[i]) && !(l.contains(nums2[i]))) l.add(nums2[i]);
        }


        len1 = l.size();
        int[] re = new int[len1];
        for (int i = 0; i < len1; i++) {
            re[i] = l.get(i);
        }

        return re;

    }

}
