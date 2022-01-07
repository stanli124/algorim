/** 在排序数组中查找元素的第一个和最后一个位置
 *  给定一个按照升序排列的整数数组nums，和一个目标值target。找出给定目标值在数组中的开始位置和结束位置。
 *  如果数组中不存在目标值target，则返回[-1,-1]
 */

package shuzu.middle;

import java.util.LinkedList;
import java.util.List;

public class problem34 {

    public static void main(String[] args) {

        int[] sz = new int[]{5,7,7,8,8,10};
        int target = 15;
        sz = searchRange(sz, target);
        for (int a : sz){
            System.out.println(a);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
//        int[] indexs = new int[]{-1, -1};
//        if (nums.length == 0) return indexs;
//        List<Integer> l = new LinkedList<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] != target) continue;
//            l.add(i);
//        }
//
//        if (l.size()>0){
//            indexs[0] = l.get(0);
//            indexs[1] = l.get(l.size()-1);
//        }
//        return indexs;

        //用二分
        int[] indexs = new int[]{-1, -1};
        int len = nums.length;
        if (len == 0) return indexs;

        int i = 0;
        while (i <= len && i<nums.length && len>=0 ){
            int mid = (i + len) / 2;
            if (nums[mid] < target) i = mid+1 ;   //target大于中间值low就左移
            else if (nums[mid] > target) len = mid-1 ; //target小于中间值high就右移
            else { //target等于当前值
                i = mid;
                len = mid;
                while (i>=0){
                    if (nums[i]==target) i--;
                    else break;
                }
                while (len<nums.length){
                    if (nums[len]==target) len++;
                    else break;
                }
                indexs[0] = i+1;
                indexs[1] = len-1;
                break;
            }
        }

        return indexs;
    }

}
