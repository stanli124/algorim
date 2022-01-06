/** 给定一个包含n个整数的数组nums，判断nums中是否存在三个元素a,b,b，使得a+b+c=0。请找出所有和为0且不重复的三元组。
 *
 *
 */

package shuzu.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class problem15 {

    public static void main(String[] args) {

        System.out.println(threeSum(new int[]{0,0,0,0,12,3,0,0}));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //暴力破解 输出可能会有重复的三元组
//        int len = nums.length;
//        List<List<Integer>> three = new ArrayList<>();
//        if (len<3) return three;
//
//        for (int i = 0; i < len; i++) {
//            for (int j = i+1; j < len; j++) {
//                for (int k = j+1; k < len; k++) {
//                    if (nums[i]+nums[j]+nums[k]==0){
//                        ArrayList<Integer> l = new ArrayList<>();
//                        l.add(nums[i]);
//                        l.add(nums[j]);
//                        l.add(nums[k]);
//                        three.add(l);
//                    }
//                }
//            }
//        }
//
//        return three;

        //三个下标不能处理所有情况
//        int len = nums.length;
//        List<List<Integer>> three = new ArrayList<>();
//        if (len<3) return three;
//
//        Arrays.sort(nums);
//        int i=0;
//        int j=1;
//        int end = len-1;
//        while (j<end){
//            if (nums[i]+nums[j]+nums[end]==0){
//                ArrayList<Integer> l = new ArrayList<>();
//                l.add(nums[i++]);
//                l.add(nums[j++]);
//                l.add(nums[end--]);
//                three.add(l);
//            }
//            else if (nums[i]+nums[j]+nums[end]<0){
//                i++;
//                j++;
//            }
//            else if (nums[i]+nums[j]+nums[end]>0){
//                end--;
//            }
//        }
//        return three;


//        int len = nums.length;
//        List<List<Integer>> three = new ArrayList<>();
//        if (len<3) return three;
//        Arrays.sort(nums);
//
//        for (int i = 0; i < len; i++) {
//            for (int j = i+1; j < len; j++) {
//                for (int k = j+1; k < len; k++) {
//                    if (i > 0 && nums[i] == nums[i - 1]) continue;
//                    else if (j > 0 && nums[j] == nums[j - 1]) continue;
//                    else if (k > 0 && nums[k] == nums[k - 1]) continue;
//
//                    if (nums[i]+nums[j]+nums[k]==0){
//                        ArrayList<Integer> l = new ArrayList<>();
//                        l.add(nums[i]);
//                        l.add(nums[j]);
//                        l.add(nums[k]);
//                        three.add(l);
//                    }else if (nums[i]+nums[j]+nums[k] > 0){
//                        return three;
//                    }
//                }
//            }
//        }
//
//        return three;

        List<List<Integer>> result = new LinkedList<>();
        // sort
        Arrays.sort(nums);
        // 3 foreach
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int t = -nums[i];
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] > t) {
                    k--;
                } else if (nums[j] + nums[k] < t) {
                    j++;
                } else {
                    // find
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // 去除临近相同的元素
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    j++;
                    k--;
                }
            }
        }
        return result;



    }

}
